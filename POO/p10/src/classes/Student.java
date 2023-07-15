package classes;

public class Student {
    public String name;
    public double nota1;
    public double nota2;
    public double nota3;


    public double notaFinal() {
        return nota1+nota2+nota3;
    }

    public double pontosFaltantes() {
        return 60.00 - notaFinal();
    }

    public String toString() {
        if(notaFinal() >= 60.00 && notaFinal() <= 100.00) {
            return "\nFINAL GRADE = "
            + String.format("%.2f",notaFinal())
            + "\nPASS";
        } else if (notaFinal() < 60.00 && notaFinal() > 0.00) {
            return "\nFINAL GRADE = "
            + String.format("%.2f",notaFinal())
            + "\nFAILED"
            + "\nMISSING "
            + String.format("%.2f",pontosFaltantes())
            + " POINTS";
        } else {
            return "\nNOTA INVÁLIDA";
        }
    }

}
