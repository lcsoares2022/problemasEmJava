package entities;

public class Fisica extends Pessoa{

    private Double gastoSaude;

    public Fisica() {
        super();
    }

    public Fisica(String name, Double rendaAnual, Double gastoSaude) {
        super(name, rendaAnual);
        this.gastoSaude = gastoSaude;
        calcImposto(rendaAnual);
    }

    public Double getGastoSaude() {
        return gastoSaude;
    }

    public void setGastoSaude(Double gastoSaude) {
        this.gastoSaude = gastoSaude;
    }

    @Override
    public void calcImposto(Double rendaAnual) {
        Double valorAPagar;
        if(rendaAnual >= 0 && rendaAnual <= 20000.00) {
            valorAPagar = rendaAnual * 0.15;
            this.setValorImposto(valorAPagar);
        } else {
            valorAPagar = rendaAnual * 0.25;
            this.setValorImposto(valorAPagar);
        }

        if(this.getGastoSaude() > 0) {
            valorAPagar -= this.getGastoSaude() * 0.5;
            this.setValorImposto(valorAPagar);
        }


    }
}
