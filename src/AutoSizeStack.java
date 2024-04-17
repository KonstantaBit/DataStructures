public class AutoSizeStack {
    private int[] data;
    private int head;
    private int capacity;

    public AutoSizeStack() {
        this.data = new int[5];
        this.capacity = 5;
        this.head = 0;
    }

    public void push(int item) {
        this.data[this.head++] = item;
        if (this.head == this.capacity) {
            int[] buff = this.data.clone();
            this.capacity *= 2;
            this.data = new int[this.capacity];
            System.arraycopy(buff, 0, this.data, 0, buff.length);
        }
    }

    public int pop() throws Exception {
        if (this.head == this.capacity / 2) {
            int[] buff = this.data.clone();
            this.capacity /= 2;
            this.data = new int[this.capacity];
            System.arraycopy(buff, 0, this.data, 0, this.capacity);
        }
        return this.data[--this.head];
    }

    public int top() throws Exception {
        return this.data[head - 1];
    }

    public boolean empty() {
        return this.head == 0;
    }

    public void clear() {
        this.head = 0;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int length() {
        return this.data.length;
    }
}
