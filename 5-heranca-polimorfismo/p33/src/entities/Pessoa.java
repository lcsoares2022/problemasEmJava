package entities;

public abstract class Pessoa {

    private String name;
    private Double rendaAnual;
    private Double valorImposto;

    public Pessoa() {
    }

    public Pessoa(String name, Double rendaAnual) {
        this.name = name;
        this.rendaAnual = rendaAnual;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getRendaAnual() {
        return rendaAnual;
    }

    public void setRendaAnual(Double rendaAnual) {
        this.rendaAnual = rendaAnual;
    }

    public Double getValorImposto() {
        return valorImposto;
    }

    public void setValorImposto(Double valorImposto) {
        this.valorImposto = valorImposto;
    }

    protected abstract void calcImposto(Double rendaAnual);

    @Override
    public String toString() {
        return this.getName()
                + " $ "
                + String.format("%.2f", this.getValorImposto());
    }
}
