package tesch;

import java.util.Scanner;

import tesch.zandona.models.Service;
import tesch.zandona.models.ServiceManager;

public class Main {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        ServiceManager manager = new ServiceManager();

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Adicionar novo Serviço");
            System.out.println("2 - Listar todos os Serviços");
            System.out.println("3 - Localizar serviços por placa");
            System.out.println("4 - Remover Serviço (por id)");
            System.out.println("5 - Sair");
            System.out.print("Escolha: ");

            String opcao = sc.nextLine();
            switch (opcao) {
                case "1":
                    System.out.print("Placa: ");
                    String placa = sc.nextLine();
                    System.out.print("Serviço: ");
                    String servico = sc.nextLine();
                    System.out.print("Valor: ");
                    double valor = Double.parseDouble(sc.nextLine());
                    manager.adicionar(new Service(0, placa, servico, valor));
                    break;
                case "2":
                    manager.listar();
                    break;
                case "3":
                    System.out.print("Digite a placa: ");
                    manager.localizarPorPlaca(sc.nextLine());
                    break;
                case "4":
                    System.out.print("Digite o ID para remover: ");
                    manager.removerPorId(Integer.parseInt(sc.nextLine()));
                    break;
                case "5":
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
