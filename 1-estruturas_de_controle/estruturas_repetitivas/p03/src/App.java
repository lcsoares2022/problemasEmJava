import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int cod, alcool=0, gasolina=0, diesel=0;
        Scanner scanner = new Scanner (System.in);
        do {
            System.out.println("Digite o tipo de combustível abastecido: ");
            System.out.println("1.Álcool\n2.Gasolina\n3.Diesel\n4.Fim");
            cod = scanner.nextInt();
            switch(cod) {
                case 1:
                    alcool++;
                    break;
                case 2:
                    gasolina++;
                    break;
                case 3:
                    diesel++;
                    break;
                case 4:
                    System.out.println("Fim");
                    break;
                default:
                    System.out.println("Código Inválido");
            }
        } while(cod != 4);
        scanner.close();
        System.out.printf("MUITO OBRIGADO\nAlcool: %d\nGasolina: %d\nDiesel: %d", alcool, gasolina, diesel);   
    }  
}
