import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Deq deq = new Deq(5);

        for (int i = 0; i < 5; ++i) {
            deq.pushBack(i);
        }

        for (int i = 0; i < 5; ++i) {
            System.out.println(deq.popFront());
        }

        System.out.println("---");

        for (int i = 0; i < 5; ++i) {
            deq.pushFront(i);
        }

        for (int i = 0; i < 5; ++i) {
            System.out.println(deq.popFront());
        }
    }
}