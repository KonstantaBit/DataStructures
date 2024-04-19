public class L1LinkedList<T> {
    private Node<T> first, last; //Ссылки на первый и последний узлы.
    private int size;

    public L1LinkedList() {
        first = last = null;
        size = 0;
    }

    //Добавить элемент в конец списка.
    public void append(Node<T> node) {
        node.next = null;
        if (first == null) //Первый элемент.
            first = node;
        if (last != null)
            last.next = node;
        last = node;
        size++;
    }

    // Удалить и вернуть элемент из конца списка
    public T pop() throws Exception {
        if (size == 0)
            throw new Exception();
        T answer = last.value;
        Node<T> temp = first;
        for (int i = 0; i < size - 2; ++i)
            temp = temp.next;
        last = temp;
        size--;
        return answer;
    }

    // Вернуть длинну списка
    public int getSize() {
        return size;
    }

    // Получить значение по индексу
    public T getFromIndex(int index) throws IndexOutOfBoundsException {
        if (index - 1 > size)
            throw new IndexOutOfBoundsException();

        Node<T> temp = first;
        for (int i = 0; i < index; ++i)
            temp = temp.next;

        return temp.value;
    }

    // Присвоить значение по индексу
    public void setFromIndex(int index, T value) throws IndexOutOfBoundsException {
        if (index - 1 > size)
            throw new IndexOutOfBoundsException();

        Node<T> temp = first;
        for (int i = 0; i < index; ++i)
            temp = temp.next;

        temp.value = value;
    }

    // Удалить значение по индекс и вернуть его
    public T removeFromIndex(int index) throws IndexOutOfBoundsException {
        if (index - 1 > size)
            throw new IndexOutOfBoundsException();
        --size;
        if (index == 0) {
            T answer = first.value;
            first = first.next;
            return answer;
        }
        Node<T> temp = first;
        Node<T> previous = null;
        for (int i = 0; i < index; ++i) {
            if (i == index - 1)
                previous = temp;
            temp = temp.next;
        }
        previous.next = temp.next;
        return temp.value;
    }
}
