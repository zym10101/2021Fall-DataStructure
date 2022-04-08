package DataStructure;

import java.util.Iterator;

public class Quene<T> implements Iterable<T> {
    private Node head;
    private Node last;
    private int N;

    public Quene() {
        this.head = new Node(null, null);
        this.last = null;
        this.N = 0;
    }


    private class Node {
        public T data;
        public Node next;

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void enquene(T t) {
        if (last == null) {
            last = new Node(t, null);
            head.next = last;
        } else {
            Node newNode = new Node(t, null);
            Node oldNode = this.last;
            oldNode.next = newNode;
            last = newNode;
        }
        N++;
    }

    public T dequene() {
        if (isEmpty()) {
            return null;
        }
        Node oldFirst = head.next;
        head.next = oldFirst.next;
        N--;
        if (isEmpty()) {
            last = null;
        }
        return oldFirst.data;
    }

    @Override
    public Iterator<T> iterator() {
        return new QIterator();
    }

    private class QIterator implements Iterator {
        private Node n = head;

        @Override
        public boolean hasNext() {
            return n.next != null;
        }

        @Override
        public Object next() {
            n = n.next;
            return n.data;
        }
    }
}

class QueneTest {
    public static void main(String[] args) {
        Quene<String> q = new Quene<>();
        q.enquene("a");
        q.enquene("b");
        q.enquene("c");
        q.enquene("d");
        for (String s : q) {
            System.out.println(s);
        }
        String result = q.dequene();
        System.out.println(result);
        System.out.println(q.size());
    }
}