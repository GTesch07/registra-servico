package tesch.zandona.models;

import java.util.Date;

public class Service {
    private int id;
    private String placa;
    private String servico;
    private double valor;
    private Date data;

    public Service() {
    }

    public Service(String placa, String servico, double valor) {
        this.placa = placa;
        this.servico = servico;
        this.valor = valor;
        this.data = new Date();
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
