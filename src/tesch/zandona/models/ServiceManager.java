package tesch.zandona.models;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ServiceManager {
    private static final String ARQUIVO = "servicos.txt";
    private List<Service> servicos = new ArrayList<>();
    private int idCounter = 1;

    public ServiceManager() {
        carregar();
    }

    public void adicionar(Service servico) {
        int maiorId = servicos.stream()
                .mapToInt(Service::getId)
                .max()
                .orElse(0);
        servico = new Service(maiorId + 1, servico.getPlaca(), servico.getServico(), servico.getValor(),
                servico.getData());
        servicos.add(servico);
        salvar();
    }

    public void listar() {
        if (servicos.isEmpty()) {
            System.out.println("Nenhum serviço cadastrado.");
        } else {
            servicos.forEach(System.out::println);
        }
    }

    public void localizarPorPlaca(String placa) {
        boolean encontrado = false;
        for (Service s : servicos) {
            if (s.getPlaca().equalsIgnoreCase(placa)) {
                System.out.println(s);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Nenhum serviço encontrado para essa placa. ");
        }
    }

    public void removerPorId(int id) {
        boolean removido = servicos.removeIf(s -> s.getId() == id);
        if (removido) {
            salvar();
            System.out.println("Serviço removido com sucesso.");
        } else {
            System.out.println("Serviço não encontrado.");
        }
    }

    private void salvar() {
        try (BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(ARQUIVO), StandardCharsets.UTF_8))) {
            for (Service s : servicos) {
                writer.write(s.toFileFormat());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        }
    }

    private void carregar() {
        File file = new File(ARQUIVO);
        if (!file.exists())
            return;

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(ARQUIVO), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Service s = Service.fromFileFormat(line);
                if (s != null) {
                    servicos.add(s);
                    if (s.getId() >= idCounter) {
                        idCounter = s.getId() + 1;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar: " + e.getMessage());
        }

    }

    public static void limparTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void pausar() {
        System.out.println("\nPressione Enter para continuar...");
        new Scanner(System.in).nextLine();
    }
}
