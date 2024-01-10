import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter file full path: ");
        String path = sc.nextLine();

        try(BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = br.readLine();
            Map<String, Integer> electionResult = new LinkedHashMap<>();

            while(line != null) {
                String[] data = line.split(",");
                String chaveTemp = data[0];
                int valorTemp = Integer.parseInt(data[1]);

                if(electionResult.containsKey(chaveTemp))
                    electionResult.put(chaveTemp, electionResult.get(chaveTemp) + valorTemp);
                 else
                    electionResult.put(chaveTemp, valorTemp);

                line = br.readLine();
            }

            for(String key : electionResult.keySet()) {
                System.out.println(key + ": " + electionResult.get(key));
            }

        } catch (IOException e) {
            System.out.println("Error processing file: " + e.getMessage());
        }



    }
}