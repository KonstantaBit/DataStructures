import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        L2List list = new L2List();

        for (int i = 0; i < 5; i++) {
            list.insertFront(i);
        }

        list.toFront();
        for (int i = 0; i < 4; i++) {
            System.out.println(list.after());
            list.forward();
        }
        list.backward();
        System.out.println(list.before());
        System.out.println('-');
        System.out.printf("%s %s\n", list.before, list.after);
        System.out.println(list.eraseFront());
        System.out.printf("%s %s\n", list.before, list.after);
        System.out.println('-');
        list.toFront();
        for (int i = 0; i < 4; i++) {
            System.out.println(list.after());
            list.forward();
        }
    }
}