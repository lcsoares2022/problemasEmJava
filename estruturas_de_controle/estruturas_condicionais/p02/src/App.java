import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        String horaInicio, horaFim, horasJogando;
        double qtdHorasIniciais, qtdHorasFinais, tempoTotal;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o horário de início: ");
        horaInicio = scanner.nextLine();
        System.out.print("Digite o horário do fim: ");
        horaFim = scanner.nextLine();
        scanner.close();
        qtdHorasIniciais = calcQtdHora(horaInicio);
        qtdHorasFinais = calcQtdHora(horaFim);
        tempoTotal = duracaoDoJogo(qtdHorasIniciais, qtdHorasFinais);
        horasJogando = formatoHora(tempoTotal);
        System.out.println("O JOGO DUROU " + horasJogando);     
    }
    public static double calcQtdHora(String horario) {
        String[] partes = horario.split(":");
        int hora = Integer.parseInt(partes[0]);
        int minuto = Integer.parseInt(partes[1]);
        int segundo = Integer.parseInt(partes[2]);
        double minutoParaHora = minuto / 60.00;
        double segundoParaHora = segundo / 3600.00;
        double horaTotal = hora + minutoParaHora + segundoParaHora;
        return horaTotal;
    }
    public static double duracaoDoJogo(double qtdHorasIniciais, double qtdHorasFinais) {
        double tempoTotal=0, aux;
        if(qtdHorasIniciais < 12.00 && qtdHorasFinais > 12){
            aux = 12.00 - qtdHorasIniciais;
            tempoTotal += aux;
            aux = qtdHorasFinais - 12.00;
            tempoTotal += aux;
        } else if (qtdHorasIniciais > 12.00 && qtdHorasFinais < 12.00) {
            aux = 24.00 - qtdHorasIniciais;
            tempoTotal += (aux+qtdHorasFinais);
        } else if (qtdHorasIniciais < 12.00 && qtdHorasFinais < 12.00 && qtdHorasFinais > qtdHorasIniciais) {
            tempoTotal += (qtdHorasFinais-qtdHorasIniciais);
        } else if (qtdHorasIniciais < 12.00 && qtdHorasFinais < 12.00 && qtdHorasFinais < qtdHorasIniciais) {
            aux = 24.00 - qtdHorasIniciais;
            tempoTotal += (aux+qtdHorasFinais);
        } else if(qtdHorasIniciais > 12.00 && qtdHorasFinais > 12.00 && qtdHorasFinais > qtdHorasIniciais) {
             tempoTotal += (qtdHorasFinais-qtdHorasIniciais);
        } else if(qtdHorasIniciais > 12.00 && qtdHorasFinais > 12.00 && qtdHorasFinais < qtdHorasIniciais) {
            aux = 24.00 - qtdHorasIniciais;
            tempoTotal += aux;
            aux = 24.00 - 12.00;
            tempoTotal += aux;
            aux = qtdHorasFinais - 12.00;
            tempoTotal += aux; 
        } else if (qtdHorasFinais == qtdHorasIniciais) {
            tempoTotal = 24.00;
        }       
        return tempoTotal;
    }

    public static String formatoHora(double qtdHoras){
        int hora = (int) qtdHoras;
        int minuto = (int) (qtdHoras - hora) * 60;
        int segundo = (int) ((qtdHoras - hora - minuto / 60.0) * 3600);
        String horaFormatada = String.format("%02d:%02d:%02d", hora, minuto, segundo);
        return horaFormatada;
    }

}
