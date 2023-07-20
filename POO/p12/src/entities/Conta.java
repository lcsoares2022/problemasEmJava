package entities;

public class Conta {
    private int numConta;
    private String name;
    private double saldo;

    public Conta(int numConta, String name, double saldo) {
        this.numConta = numConta;
        this.name = name;
        this.saldo = saldo;
    }

    public Conta(int numConta, String name) {
        this.numConta = numConta;
        this.name = name;
        saldo = 0.0;
    }

    public int getNumConta() {
        return numConta;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double deposito) {
        saldo += deposito;
    }

    public void sacar(double valorASacar) {
        saldo -= 5.00;
        if(valorASacar>0) {
            saldo -= valorASacar;
        } else {
            System.out.println("Valor inválido");
        }
    }

    public String toString() {
        return "Account "
        + getNumConta()
        + ", "
        + "Holder: "
        + getName()
        + ", "
        + "Balance: $ "
        + String.format("%.2f",getSaldo());
    }
}
