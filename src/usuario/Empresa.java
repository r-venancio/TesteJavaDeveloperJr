package usuario;

public class Empresa implements Usuario {
    private String cnpj;
    private double saldo;
    private double taxa;

    public Empresa(String cnpj, double taxa) {
        this.cnpj = cnpj;
        this.taxa = taxa;
    }

    public String getCnpj() {
        return cnpj;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public void sacar(double valor) {
        saldo -= valor;
    }

    public double calcularTaxa(double valor) {
        return valor * taxa;
    }

    @Override
    public String getId() {
        return cnpj;
    }


}