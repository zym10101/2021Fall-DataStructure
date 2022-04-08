package DataStructure;

public class HashMap<K extends Comparable<K>, V> {
    private class Node {
        public K key;
        public V value;
        public Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private Node head;
    private int N;

    public HashMap() {
        this.head = new Node(null, null, null);
        this.N = 0;
    }

    public int size() {
        return N;
    }

    public void put(K k, V v) {
        Node current = head.next;
        Node pre = head;
        while (current!= null && k.compareTo(current.key) > 0) {
            pre = current;
            current = current.next;
        }
        if (current!= null && k.compareTo(current.key) == 0) {
            current.value = v;
            return;
        }
        Node newNode = new Node(k, v, null);
        pre.next = newNode;
        N++;
    }

    public void delete(K k) {
        Node n = head;
        while (n.next != null) {
            if (n.next.key.equals(k)) {
                n.next = n.next.next;
                N--;
                return;
            }
            n = n.next;
        }
    }

    public V get(K k) {
        Node n = head;
        while (n.next != null) {
            n = n.next;
            if (n.key.equals(k)) {
                return n.value;
            }
        }
        return null;
    }
}

class HashMapTest {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1,"zhangsan");
        map.put(2,"lisi");
        map.put(3,"wangwu");
        map.put(5,"zhaoliu");
        map.put(4,"hhh");
        String s = map.get(5);
        System.out.println(s);
        System.out.println(map.size());
    }
}
