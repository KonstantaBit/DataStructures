import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Deq deq = new Deq(32);
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();
        for (char symbol : string.toCharArray())
            deq.pushFront((int) symbol);
        for (int i = 0; i < string.length() / 2; ++i) {
            if (deq.popFront() != deq.popBack()) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}