public class TemplatedStack <Type> {
    private static final int DEFSIZE = 16;
    private Object[] array;
    private int head;
    public TemplatedStack(int capacity) {
        array = new Object[capacity];
        head = 0;
    }
    public TemplatedStack() {
        this(DEFSIZE);
    }
    //Пуст ли стек?
    public boolean empty() {
        return head == 0;
    }
    //Сделать стек пустым.
    public void clear() {
        head = 0;
    }
    //Добавить элемент на вершину стека.
    public void push(Type val) throws Exception {
        array[head++] = val;
    }
    //Удалить элемент с вершины стека.
    public Type pop() throws Exception {
        return (Type)array[--head];
    }
    //Получить вершину стека.
    public Type top() throws Exception {
        return (Type)array[head - 1];
    }
}
