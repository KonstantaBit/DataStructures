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
    public Node<T> pop() throws Exception {
        if (size == 0)
            throw new Exception();
        Node<T> answer = last;
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

    // Получить узел по индексу
    public Node<T> getFromIndex(int index) throws IndexOutOfBoundsException {
        if (index - 1 > size)
            throw new IndexOutOfBoundsException();

        Node<T> temp = first;
        for (int i = 0; i < index; ++i)
            temp = temp.next;

        return temp;
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

    // Удалить узел по индексу и вернуть его
    public Node<T> removeFromIndex(int index) throws IndexOutOfBoundsException {
        if (index - 1 > size)
            throw new IndexOutOfBoundsException();
        --size;
        if (index == 0) {
            Node<T> answer = first;
            first = first.next;
            return answer;
        }
        Node<T> temp = first;
        Node<T> previous = null;
        for (int i = 0; i < index; ++i) {
            previous = temp;
            temp = temp.next;
        }
        previous.next = temp.next;
        return temp;
    }

    // Вставить узел по индексу
    public void insertFromIndex(int index, Node<T> node) throws IndexOutOfBoundsException {
        if (index - 1 > size)
            throw new IndexOutOfBoundsException();
        ++size;
        if (index == 0) {
            node.next = first;
            first = node;
            return;
        }
        Node<T> temp = first;
        Node<T> previous = null;
        for (int i = 0; i < index; ++i) {
            previous = temp;
            temp = temp.next;
        }
        previous.next = node;
        node.next = temp;
    }

    // Найти индекс узла, если таковая существует
    public int find(Node<T> node) throws Exception {
        Node<T> temp = first;
        for (int i = 0; i < size; ++i) {
            if (temp.equals(node))
                return i;
            temp = temp.next;
        }
        throw new Exception();
    }
}
