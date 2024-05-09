package org.m0d3rn1ca;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (FileReader fileReader = new FileReader("test_5_2.txt")) {
            String regex1 = "[1-9]+\\d*";
            String regex2 = "-?([1-9]+\\d*|0)\\.(0*[1-9]*|0)";
            String regex3 = "[\\w\\-.]+@([\\w-]+\\.)+\\w{2,}";

            Scanner scanner = new Scanner(fileReader);

            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                Boolean state = data.matches(regex3); // Тут меняете цифру и прогоняете через тесты
                System.out.printf("%s - %s\n", state, data);
            }
        }
        catch (IOException exception) {
            System.out.println(exception.toString());
        }
    }

    public static boolean regexNatural(String string) {
        String regex = "[1-9]+\\d*";
        return string.matches(regex);
    }

    public static boolean regexFloat(String string) {
        String regex = "-?([1-9]+\\d*|0)\\.(0*[1-9]*|0)";
        return string.matches(regex);
    }

    public static boolean regexEmail(String string) {
        String regex = "[\\w\\-.]+@([\\w-]+\\.)+\\w{2,}";
        return string.matches(regex);
    }
}