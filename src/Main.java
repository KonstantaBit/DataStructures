import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AutoSizeStack stack = new AutoSizeStack();
        Scanner scanner = new Scanner(System.in);
        for (char c : scanner.nextLine().toCharArray()) {
            if (c == '(')
                stack.push((int) ')');
            if (c == '{')
                stack.push((int) '}');
            if (c == '[')
                stack.push((int) ']');
            if (c == '<')
                stack.push((int) '>');
            try {
                if (c == ')' || c == '}' || c == ']' || c == '>')
                    if (c == stack.top())
                        stack.pop();
            } catch (Exception exception) {
                System.out.println("NO");
                return;
            }
        }
        if (stack.empty())
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}