import entities.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static final DateTimeFormatter FMT = DateTimeFormatter.ISO_DATE_TIME;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter file full path: ");
        String path = sc.nextLine();

        try(BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = br.readLine();
            Set<User> users = new HashSet<>();

            while(line != null) {
                String[] vetLine = line.split(" ");
                String name = vetLine[0];
                LocalDateTime moment = LocalDateTime.parse(vetLine[1], FMT);
                users.add(new User(name, moment));
                line = br.readLine();
            }

            System.out.print("Total users: ");
            System.out.println(users.size());

        } catch (IOException e) {
            System.out.println("Error processing file: " + e.getMessage());
        }
    }
}