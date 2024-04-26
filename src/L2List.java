public class L2List extends L1List {
    protected int[] prev; //Массив ссылок на предыдущий элемент

    public L2List(int capacity) {
        array = new int[capacity];
        next = new int[capacity + 2];
        prev = new int[capacity + 2];

        nilList = capacity;
        nilFree = capacity + 1;

        link(nilList, nilList);
        link(nilFree, 0);
        for (int i = 0; i < capacity - 1; i++)
            link(i, i + 1);
        link(capacity - 1, nilFree);

        before = after = nilList;
    }

    public L2List() {
        this(DEFSIZE);
    }

    protected void link(int first, int second) {
        next[first] = second;
        prev[second] = first;
    }

    //Передвнут указатель в конец списка.
    public void toBack() {
        before = prev[nilList];
        after = nilList;
    }

    //Указатель в начале списка?
    public boolean begin() {
        return before == nilList;
    }

    //Передвинуть указатель в конец списка.
    public void backward() throws Exception {
        if (before == nilList)
            throw new Exception();

        after = before;
        before = prev[before];
    }

    //Получить число перед укателем.
    public int before() throws Exception {
        return array[before];
    }

    //Удалить число за указателем
    public int eraseBack() throws Exception {
        return super.erase();
    }

    //Вставить число за указателем
    public void insertBack(int val) throws Exception {
        super.insert(val);
    }

    //Вставить число перед указателем
    public void insertFront(int val) throws Exception {
        int index = mallocIndex();

        link(before, index);
        link(index, after);
        before = index;
        array[index] = val;
    }

    //Удалить число перед указателем
    public int eraseFront() throws Exception {
        int val = array[before];
        int index = before;

        before = prev[index];
        link(before, after);
        freeIndex(index);

        return val;
    }
}