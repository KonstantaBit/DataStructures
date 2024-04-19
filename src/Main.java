import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        L1LinkedList<String> list =  new L1LinkedList<>();
        list.append(new Node<>("12"));
        list.append(new Node<>("23"));
        list.append(new Node<>("34"));
        list.append(new Node<>("45"));
        list.append(new Node<>("56"));

        list.removeFromIndex(0);

        for (int i = 0; i < list.getSize(); ++i) {
            System.out.println(list.getFromIndex(i));
        }

        System.out.println('-');

        list.removeFromIndex(1);
        list.pop();

        for (int i = 0; i < list.getSize(); ++i) {
            System.out.println(list.getFromIndex(i));
        }

    }
}