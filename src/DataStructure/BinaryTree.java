package DataStructure;

public class BinaryTree<Key extends Comparable<Key>, Value> {
    private Node root;
    private int N;

    private class Node {
        public Key key;
        public Value value;
        public Node left;
        public Node right;

        public Node(Key key, Value value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    public int size() {
        return N;
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    public Node put(Node x, Key key, Value value) {
        if (x == null) {
            N++;
            return new Node(key, value, null, null);
        }
        int cmp = key.compareTo(x.key);
        if (cmp > 0) {
            x.right = put(x.right, key, value);
        } else if (cmp < 0) {
            x.left = put(x.left, key, value);
        } else {
            x.value = value;
        }
        return x;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    public Value get(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp > 0) {
            return get(x.right, key);
        } else if (cmp < 0) {
            return get(x.left, key);
        } else {
            return x.value;
        }
    }

    public void delete(Key key) {
        delete(root, key);
    }

    public Node delete(Node x, Key key) {
        N--;
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp > 0) {
            x.right = delete(x.right, key);
        } else if (cmp < 0) {
            x.left = delete(x.left, key);
        } else {
            N--;
            if (x.left == null) {
                return x.right;
            }
            if (x.right == null) {
                return x.left;
            }
            Node minNode = x.right;
            while (minNode.left != null) {
                minNode = minNode.left;
            }
            Node n = x.right;
            while (n.left != null) {
                if (n.left.left == null) {
                    n.left = n.left.right;
                } else {
                    n = n.left;
                }
            }
            minNode.left = x.left;
            minNode.right = x.right;
            x = minNode;
        }
        return x;
    }
}

class BinaryTreeTest {
    public static void main(String[] args) {
        BinaryTree<Integer, String> tree = new BinaryTree<>();
        tree.put(1, "a");
        tree.put(2, "b");
        tree.put(3, "c");
        tree.put(4, "d");
        tree.put(5, "e");
        System.out.println(tree.size());
        System.out.println(tree.get(2));
        System.out.println(tree.get(4));
        tree.delete(3);
        System.out.println(tree.size());
    }
}