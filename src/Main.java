import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        TemplatedStack<Integer> stack1 = new TemplatedStack<Integer>(5);
        stack1.push(10);
        System.out.println(stack1.top());
        TemplatedStack<Element> stack2 = new TemplatedStack<Element>(5);
        stack2.push(new Element(10, "aaa"));
        System.out.println(stack2.top().key);
        System.out.println(stack2.top().value);
    }
}