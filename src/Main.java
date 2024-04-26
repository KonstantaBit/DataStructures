import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws Exception {
        try (FileReader fileReader = new FileReader("test_2_9.txt")) {
            LinkedList<String> list = new LinkedList<>();
            Scanner scanner = new Scanner(fileReader);
            int appCounter = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.startsWith("Run")) {
                    list.add(line.substring(4));
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

                    int shift = list.size() - (tabCounter % appCounter) - 1;
                    if (!isDelete || tabCounter != 0) {
                        String temp = list.remove(shift);
                        if (!isDelete)
                            list.add(temp);
                        else
                            appCounter--;
                        System.out.println(temp);
                    }
                }
            }
        } catch (IOException exception) {
            System.out.println(exception.toString());
        }
    }
}