import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        try (FileReader fileReader = new FileReader("test_2_9.txt")) {
            L1ListString list = new L1ListString();
            Scanner scanner = new Scanner(fileReader);
            int appCounter = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.startsWith("Run")) {
                    list.insert(line.substring(4));
                    System.out.println(line.substring(4));
                    appCounter += 1;
                } else if (line.startsWith("Alt")) {
                    int tabCounter = 0;
                    boolean isDelete = false;

                    for (String substring : line.split("\\+"))
                        if (substring.equals("Tab"))
                            tabCounter += 1;
                        else if (substring.equals("Delete"))
                            isDelete = true;

                    list.toFront();

                    for (int i = 0; i < tabCounter % appCounter; ++i)
                        list.forward();
                    if (!isDelete || tabCounter != 0) {
                        String temp = list.erase();
                        list.toFront();
                        if (!isDelete)
                            list.insert(temp);
                        System.out.println(temp);
                    }
                }
            }
        } catch (IOException exception) {
            System.out.println(exception.toString());
        }
    }
}