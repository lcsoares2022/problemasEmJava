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
        try {
            tempoTotal = duracaoDoJogo(qtdHorasIniciais, qtdHorasFinais);
            horasJogando = formatoHora(tempoTotal);
            System.out.println("O JOGO DUROU " + horasJogando);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }     
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
    public static double duracaoDoJogo (double qtdHorasIniciais, double qtdHorasFinais) throws Exception{
        double tempoTotal;
        if(qtdHorasFinais < qtdHorasIniciais) 
            qtdHorasFinais += 24.00;
        tempoTotal = qtdHorasFinais - qtdHorasIniciais;
        
        if(tempoTotal == 0.00) 
            tempoTotal = 24.00;
        else if (tempoTotal < 1.00 || tempoTotal > 24.00) {
            throw new Exception("Tempo inválido! Duração mínima de 1h e máxima de 24h");
        }    
        
        return tempoTotal;
    }

    public static String formatoHora(double qtdHoras) {
        int hora = (int) qtdHoras;
        int minuto = (int) ((qtdHoras - hora) * 60);
        int segundo = (int) ((qtdHoras - hora) * 3600) - (minuto * 60); //remove-se da hora a quantidade de segundos correspondente ao minuto
        String horaFormatada = String.format("%02d:%02d:%02d", hora, minuto, segundo);
        return horaFormatada;
    }    

}
