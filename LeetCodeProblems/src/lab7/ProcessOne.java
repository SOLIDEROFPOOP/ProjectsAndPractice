package lab7;

import java.io.*;
import java.util.*;

public class ProcessOne {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            Random random = new Random();

            while (true) {
                System.out.println("Enter a symbol: ");
                char symbol = scanner.next().charAt(0);
                String fileName = "random_numbers.txt";
                try (PrintWriter writer = new PrintWriter(new FileWriter(fileName, true))) {
                    int randomNumber = random.nextInt(100);
                    writer.println(symbol + ": " + randomNumber);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (NoSuchElementException e) {
            System.out.println("Input stream closed. Exiting...");
        }
    }
}
