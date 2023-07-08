import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        String horaInicio, horaFim;
        double qtdHorasIniciais, qtdHorasFinais, horaTotal;
        Scanner scanner = new Scanner(System.in);
        horaInicio = scanner.nextLine();
        qtdHorasIniciais = calcHora(horaInicio);
        horaFim = scanner.nextLine();
        qtdHorasFinais = calcHora(horaFim);
        horaTotal = Math.abs(qtdHorasFinais-qtdHorasIniciais);
        

        
        
        
        
        
        
        scanner.close();
    }
    public static double calcHora(String horario) {
        String[] partes = horario.split(":");
        int hora = Integer.parseInt(partes[0]);
        int minuto = Integer.parseInt(partes[1]);
        int segundo = Integer.parseInt(partes[2]);
        double minutoParaHora = minuto / 60.00;
        double segundoParaHora = segundo / 3600.00;
        double horaTotal = hora + minutoParaHora + segundoParaHora;
        return horaTotal;
    }
}
