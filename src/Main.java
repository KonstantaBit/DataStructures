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

        list.removeFromIndex(list.find(list.getFromIndex(3))); // Показываю, что фунцкии работают

        for (int i = 0; i < list.getSize(); ++i)
            System.out.println(list.getFromIndex(i).value);
    }
}