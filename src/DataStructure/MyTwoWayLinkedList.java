package DataStructure;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyTwoWayLinkedList<T> implements Iterable<T> {
    private class Node {
        public T data;
        public Node pre;
        public Node next;

        public Node(T data, Node pre, Node next) {
            this.data = data;
            this.pre = pre;
            this.next = next;
        }
    }

    private Node head;
    private Node last;
    private int theSize;

    public MyTwoWayLinkedList() {
        doClear();
    }

    public void clear() {
        doClear();
    }

    public void doClear() {
        head = new Node(null, null, null);
        last = new Node(null, head, null);
        theSize = 0;
    }

    public int size() {
        return theSize;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public T getFirst() {
        if (isEmpty()) {
            return null;
        }
        return head.next.data;
    }

    public T getLast() {
        if (isEmpty()) {
            return null;
        }
        return last.data;
    }

    public void add(T x) {
        if (isEmpty()) {
            Node newNode = new Node(x, head, null);
            head.next = newNode;
            last = newNode;
        } else {
            Node oldLast = last;
            Node newNode = new Node(x, oldLast, null);
            last = newNode;
            oldLast.next = newNode;
        }
        theSize++;
    }

    public void add(int idx, T x) {
        Node pre = head;
        for (int i = 0; i < idx; i++) {
            pre = pre.next;
        }
        Node current = pre.next;
        Node newNode = new Node(x, pre, current);
        pre.next = newNode;
        current.pre = newNode;
        theSize++;
    }

    public T get(int idx) {
        Node n = head.next;
        for (int i = 0; i < idx; i++) {
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
        current.next.pre = pre;
        theSize--;
        return current.data;
    }

    public int indexOf(T x) {
        Node n = head;
        for (int i = 0; n.next != null; i++) {
            n = n.next;
            if (n.data.equals(x)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyTwoWayLinkedListIterator();
    }

    private class MyTwoWayLinkedListIterator implements Iterator {

        private Node n = head;

        @Override
        public boolean hasNext() {
            return n.next != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            n = n.next;
            return n.data;
        }
    }
}
class test3 {
    public static void main(String[] args) {
        MyTwoWayLinkedList<String> list = new MyTwoWayLinkedList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add(0,"0");
        list.add(3,"sing");
        list.add("5");
        list.remove(3);
        String s1 = list.get(2);
        System.out.println(s1);
        for (String s : list) {
            System.out.print(s);
        }
        System.out.println();
        String first = list.getFirst();
        System.out.println(first);
        String last = list.getLast();
        System.out.println(last);
        int i = list.indexOf("5");
        System.out.println(i);
    }
}