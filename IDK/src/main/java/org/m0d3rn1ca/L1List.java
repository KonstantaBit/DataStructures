package org.m0d3rn1ca;

public class L1List {
    protected final static int DEFSIZE = 16;
    protected int[] array; //Массив элементов.
    protected int[] next; //Массив ссылок.
    protected int nilList; //"Нил" списка.
    protected int nilFree; //"Нил" свободного места.
    protected int before; //Индекс элемента до указателя.
    protected int after; //Индекс элемента после указателя.

    public L1List(int capacity) {
        array = new int[capacity];
        next = new int[capacity + 2];

        nilList = capacity;
        nilFree = capacity + 1;

        link(nilList, nilList);
        link(nilFree, 0);
        for (int i = 0; i < capacity - 1; i++)
            link(i, i + 1);
        link(capacity - 1, nilFree);

        before = after = nilList;
    }

    public L1List() {
        this(DEFSIZE);
    }

    //Связать два элемента, заданные индексами.
    private void link(int first, int second) {
        next[first] = second;
    }

    //Захватить место.
    protected int mallocIndex() {
        int index = next[nilFree];
        link(nilFree, next[index]);

        return index;
    }

    //Освободить место.
    protected void freeIndex(int index) {
        link(index, next[nilFree]);
        link(nilFree, index);
    }

    //Пуст ли список.
    public boolean empty() {
        return next[nilList] == nilList;
    }

    //Сделать список пустым.
    public void clear() {
        try {
            toFront();
            while (true)
                erase();
        } catch (Exception e) {
            ;
        }
    }

    //Передвинуть указатель в начало списка.
    public void toFront() {
        before = nilList;
        after = next[nilList];
    }

    //Указатель в конце списка?
    public boolean end() {
        return after == nilList;
    }

    //Передвинуть указатель вперед.
    public void forward() throws Exception {
        if (after == nilList)
            throw new Exception();

        before = after;
        after = next[after];
    }

    //Получить число за указателем.
    public int after() throws Exception {
        return array[after];
    }

    //Добавить число за указателем.
    public void insert(int val) throws Exception {
        int index = mallocIndex();

        link(before, index);
        link(index, after);
        after = index;
        array[index] = val;
    }

    //Удалить число за указателем.
    public int erase() throws Exception {
        int val = array[after];
        int index = after;

        after = next[index];
        link(before, after);
        freeIndex(index);

        return val;
    }
}