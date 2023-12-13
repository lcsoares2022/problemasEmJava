import java.io.*;
import java.util.Locale;

public class Main {
    private static final String INPUT_PATH = "L:\\repositories\\programacao-orientada-a-objetos\\7-arquivo\\p36\\in.csv";
    private static final String OUTPUT_DIRECTORY_PATH = "L:\\repositories\\programacao-orientada-a-objetos\\7-arquivo\\p36\\out";
    private static final String OUTPUT_FILE_PATH = OUTPUT_DIRECTORY_PATH + File.separator + "summary.csv";

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        // Criar arquivo e inserir dados nele
        String[] lines = new String[] {
                "TV LED, 1290.99, 1",
                "Video Game Chair, 350.50, 3",
                "Iphone X, 900.00, 2",
                "Samsung Galaxy 9, 850.00, 2"
        };

        fileWriter(INPUT_PATH, lines);

        // Ler arquivo e capturar dados
        String[] newLines = processFile(INPUT_PATH);

        // Fazer pasta out e um arquivo dentro dela para armazenar o resultado
        createOutputDirectory();
        fileWriter(OUTPUT_FILE_PATH, newLines);
    }

    private static void createOutputDirectory() {
        File directory = new File(OUTPUT_DIRECTORY_PATH);
        if (directory.mkdir()) {
            System.out.println("Folder created: " + directory.getAbsolutePath());
        }
    }

    private static String[] processFile(String path) {
        String[] newLines = new String[4];

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = br.readLine();
            int i = 0;

            while (line != null) {
                String[] vetLine = line.split(",\\s+");
                double result = Double.parseDouble(vetLine[vetLine.length - 1]) * Double.parseDouble(vetLine[vetLine.length - 2]);
                newLines[i] = String.format(vetLine[0] + ", %.2f", result);
                i++;
                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error processing file: " + e.getMessage());
        }
        return newLines;
    }

    public static void fileWriter(String path, String[] lines) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
