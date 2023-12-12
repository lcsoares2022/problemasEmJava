import java.io.*;
import java.util.Locale;


/**
 * Esta classe cria um arquivo e gera um subdiretório com um arquivo
 * @author Lucas Cabral Soares
 */
public class Main {
    public static void main(String[] args) {

        //todo(1): criar arquivo e inserir dados nele

        Locale.setDefault(Locale.US);

        String[] lines = new String[] {
                "TV LED, 1290.99, 1",
                "Video Game Chair, 350.50, 3",
                "Iphone X, 900.00, 2",
                "Samsung Galaxy 9, 850.00, 2"
        };

        String path = "L:\\repositories\\programacao-orientada-a-objetos\\7-arquivo\\p36\\in.csv";

        fileWriter(path, lines);


        //todo(2): ler arquivo e capturar dados

        String[] newLines = new String[4];

        try(BufferedReader br = new BufferedReader(new FileReader(path))){

            String line = br.readLine();
            int i = 0;
            while(line != null) {
                String[] vetLine = line.split(",\\s+");
                double result = Double.parseDouble(vetLine[vetLine.length - 1]) * Double.parseDouble(vetLine[vetLine.length - 2]);
                newLines[i] = String.format(vetLine[0] + ", %.2f", result);
                i++;
                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }


        //todo(3): fazer pasta out e um arquivo dentro dela para armazenar o resultado

        String pathNewDirectory = "L:\\repositories\\programacao-orientada-a-objetos\\7-arquivo\\p36" + "\\out";

        File pathFile = new File(pathNewDirectory);

        boolean sucess = pathFile.mkdir();

        String pathNewFile = "L:\\repositories\\programacao-orientada-a-objetos\\7-arquivo\\p36" + "\\out" +
                "\\summary.csv";

        fileWriter(pathNewFile, newLines);


    }


    /**
     * Este método escreve em um arquivo.
     * @param path
     * @param lines
     */
    public static void fileWriter(String path, String[] lines) {

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {

            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }




}