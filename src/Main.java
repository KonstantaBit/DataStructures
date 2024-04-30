import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (FileReader fileReader = new FileReader("test_5_2.txt")) {
            String regex1 = "[1-9]+\\d*";
            String regex2 = "-?([1-9]+\\d*|0).\\d+";
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
}
