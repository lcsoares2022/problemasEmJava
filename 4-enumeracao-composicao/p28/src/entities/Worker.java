package entities;

import enums.WorkerLevel;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Worker {
    private String name;
    private WorkerLevel level;
    private Double baseSalary;
    private Department department;
    private List<HourContract> contracts;

    public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
        this.name = name;
        this.level = level;
        this.baseSalary = baseSalary;
        this.department = department;
        contracts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkerLevel getLevel() {
        return level;
    }

    public void setLevel(WorkerLevel level) {
        this.level = level;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }


    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<HourContract> getContracts() {
        return contracts;
    }

    private void setContracts(List<HourContract> contracts) {
        this.contracts = contracts;
    }

    public void addContract(HourContract contract) {
        this.contracts.add(contract);
    }

    public void removeContract(HourContract contract) {
        this.contracts.remove(contract);
    }

    public Double income(Integer year, Integer month) {
        List<HourContract> sameYearAndMonth;

        sameYearAndMonth =
                contracts.stream().filter(x -> x.getDate().getMonthValue() == month && x.getDate().getYear() == year).collect(Collectors.toList());

        Double aux = 0.0;
        for(HourContract x : sameYearAndMonth) {
            aux += x.totalValue();
        }
        return aux + getBaseSalary();
    }

    public String toString() {
        return "Name: " +
                this.getName() +
                "\nDepartment: " +
                this.getDepartment().getName();
    }


}
