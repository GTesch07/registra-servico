package tesch.zandona.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Service {
    private int id;
    private String placa;
    private String servico;
    private double valor;
    private Date data;

    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Service(int id, String placa, String servico, double valor, Date data) {
        this.id = id;
        this.placa = placa;
        this.servico = servico;
        this.valor = valor;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public String getPlaca() {
        return placa;
    }

    public String getServico() {
        return servico;
    }

    public double getValor() {
        return valor;
    }

    public Date getData() {
        return data;
    }

    public String toFileFormat() {
        return id + ";" + placa + ";" + servico + ";" + valor + ";" + sdf.format(data);
    }

    public static Service fromFileFormat(String line) {
        try {
            String[] parts = line.split(";");
            return new Service(
                    Integer.parseInt(parts[0]),
                    parts[1],
                    parts[2],
                    Double.parseDouble(parts[3]),
                    sdf.parse(parts[4]));
        } catch (ParseException | NumberFormatException e) {
            System.out.println("Erro ao ler serviço: " + e.getMessage());
            return null;
        }
    }

    public static Date parseData(String dataStr) throws ParseException {
        return sdf.parse(dataStr);
    }

    @Override
    public String toString() {
        return String.format("ID: %d | Placa: %s | Serviço: %s | Valor: R$ %.2f | Data: %s",
                id, placa, servico, valor, sdf.format(data));
    }
}
