import java.util.Scanner;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        HashSet<Integer> hashSet = new HashSet<>();
        while (true) {
            Integer data = scanner.nextInt();
            if (hashSet.contains(data)) {
                System.out.println("Yes");
            } else {
                hashSet.add(data);
                System.out.println("No");
            }
        }
    }
}