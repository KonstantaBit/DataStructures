package org.m0d3rn1ca;

public class Deq extends Queue {
    public Deq(int capacity) {
        super(capacity);
    }

    public Deq() {
        this(DEFSIZE);
    }

    protected int backward(int index) {
        return --index < 0 ? array.length - 1 : index;
    }

    public void pushBack(int val) throws Exception {
        super.push(val);
    }

    public void pushFront(int val) throws Exception {
        if (++size > array.length)
            throw new Exception();

        array[head = backward(head)] = val;
    }

    public int popFront() throws Exception {
        return super.pop();
    }

    public int popBack() throws Exception {
        int val = back();
        tail = backward(tail);
        size -= 1;

        return val;
    }

    public int back() throws Exception {
        if (empty())
            throw new Exception();

        return array[tail];
    }
}
