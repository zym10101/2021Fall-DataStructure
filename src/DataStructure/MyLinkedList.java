package DataStructure;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T> implements Iterable<T> {
    private class Node {
        public T data;
        public Node next;

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node head;
    private int theSize;

    public MyLinkedList() {
        doClear();
    }

    public void clear() {
        doClear();
    }

    public void doClear() {
        head = new Node(null, null);
        theSize = 0;
    }

    public int size() {
        return theSize;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean add(T x) {
        add(size(), x);
        return true;
    }

    public void add(int idx, T x) {
        Node pre = head;
        for (int i = 0; i < idx; i++) {
            pre = pre.next;
        }
        Node current = pre.next;
        Node newNode = new Node(x, current);
        pre.next = newNode;
        theSize++;
    }

    public T get(int idx) {
        Node n = head;
        for (int i = 0; i <= idx; i++) {
            n = n.next;
        }
        return n.data;
    }

    public T remove(int idx) {
        Node pre = head;
        for (int i = 0; i < idx; i++) {
            pre = pre.next;
        }
        Node current = pre.next;
        pre.next = current.next;
        theSize--;
        return current.data;
    }

    public int indexOf(T x) {
        Node n = head;
        for (int i = 0; i < size(); i++) {
            n = n.next;
            if (n.data.equals(x)) {
                return i;
            }
        }
        return -1;
    }

    public void reverse() {
        if (isEmpty()) {
            return;
        }
        reverse(head.next);
    }

    public Node reverse(Node current) {
        if (current.next == null) {
            head.next=current;
            return current;
        }
        Node pre = reverse(current.next);
        pre.next=current;
        current.next=null;
        return current;
    }

    public Iterator<T> iterator() {
        return new MyLinkedListIterator();
    }

    private class MyLinkedListIterator implements Iterator<T> {
        private Node n = head;

        @Override
        public boolean hasNext() {
            return n.next != null;
        }

        @Override
        public T next() {
            if (!hasNext())
                throw new NoSuchElementException();
            n = n.next;
            return (T) n.data;
        }
    }
}

class test2 {
    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.reverse();
        for (String s : list) {
            System.out.println(s);
        }
    }
}
