import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите имя пользователя: ");
        String name = scanner.nextLine();

        System.out.print("Введите возраст пользователя: ");
        String age = scanner.nextLine();

        String userData = name + ": " + age;


        try (FileWriter writer = new FileWriter("users.txt", true)) {
            writer.write(userData + "\n");
        } catch (IOException e) {
            System.out.println("Произошла ошибка при записи в файл.");
            e.printStackTrace();
        }

        try (FileReader fr = new FileReader("users.txt");
             BufferedReader reader = new BufferedReader(fr)) {
            System.out.println("\nСодержимое users.txt:");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Произошла ошибка при чтении из файла.");
            e.printStackTrace();
        }

        scanner.close();
    }
}