package entities;

public class Juridica extends Pessoa{
    private Integer numFunc;

    public Juridica() {
        super();
    }

    public Juridica(String name, Double rendaAnual, Integer numFunc) {
        super(name, rendaAnual);
        this.numFunc = numFunc;
        calcImposto(rendaAnual);
    }

    public Integer getNumFunc() {
        return numFunc;
    }

    public void setNumFunc(Integer numFunc) {
        this.numFunc = numFunc;
    }

    @Override
    public void calcImposto(Double rendaAnual) {

        Double valorAPagar = this.getNumFunc() < 10 ?
                rendaAnual * 0.16 : rendaAnual * 0.14;

        this.setValorImposto(valorAPagar);
    }
}
