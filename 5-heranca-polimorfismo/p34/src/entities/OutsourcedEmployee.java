package entities;

public class OutsourcedEmployee extends Employee{


    private Double additionalChange;

    public OutsourcedEmployee() {
        super();
    }

    public OutsourcedEmployee(String name, Integer hours, Double valuePerHour, Double additionalChange) {
        super(name, hours, valuePerHour);
        this.additionalChange = additionalChange;
    }

    public Double getAdditionalChange() {
        return additionalChange;
    }

    public void setAdditionalChange(Double additionalChange) {
        this.additionalChange = additionalChange;
    }


    @Override
    public Double payment() {
        return super.payment() + (1.1 * this.getAdditionalChange());
    }


}
