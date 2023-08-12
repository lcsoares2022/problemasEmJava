package entities;


public class Funcionario {
    private int id;
    private String nome;
    private double salario;

    public Funcionario(int id, String nome, double salario) {
        this.id = id;
        this.nome = nome;
        this.salario = salario;
    }
               
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return this.salario;
    }
    
    public void aumentarSalario(double aumento) {
       double decimal = aumento / 100.00 + 1;
       salario *= decimal;
   }
   
   public String toString() {
       return id
           + ", "
           + nome
           + ", R$ "
           + String.format("%.2f", salario);
   }

}
