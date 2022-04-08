package DataStructure;

import java.util.Iterator;

public class Stack<T> implements Iterable<T> {
    private Node head;
    private int N;


    private class Node {
        public T data;
        public Node next;

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public Stack() {
        this.head = new Node(null, null);
        this.N = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(T t) {
        if (head.next == null) {
            Node newNode = new Node(t, null);
            head.next = newNode;
        } else {
            Node oldNode = head.next;
            Node newNode = new Node(t, null);
            head.next = newNode;
            newNode.next = oldNode;
        }
        N++;
    }

    public T pop() {
        if (head.next == null) {
            return null;
        } else {
            Node oldNode = head.next;
            head.next = oldNode.next;
            N--;
            return oldNode.data;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new SIterator();
    }

    private class SIterator implements Iterator {
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

class StackTest {
    public static void main(String[] args) {
        Stack<String> s = new Stack<>();
        s.push("a");
        s.push("b");
        s.push("c");
        s.push("d");
        for (String s1 : s) {
            System.out.println(s1);
        }
        String p = s.pop();
        System.out.println(p);
        System.out.println(s.size());
    }
}
