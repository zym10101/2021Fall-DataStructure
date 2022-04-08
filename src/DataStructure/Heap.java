package DataStructure;

public class Heap {
    public static void exchange(Comparable[] heap, int i, int j) {
        Comparable temp;
        temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public static void createHeap(Comparable[] source, Comparable[] heap) {
        System.arraycopy(source, 0, heap, 1, source.length);
        for (int i = heap.length / 2; i >= 1; i--) {
            sink(heap, i, source.length);
        }
    }

    public static void sort(Comparable[] source) {
        Comparable[] heap = new Comparable[source.length + 1];
        createHeap(source, heap);
        int N = source.length;
        while (N != 1) {
            exchange(heap, N, 1);
            N--;
            sink(heap, 1, N);
        }
        System.arraycopy(heap, 1, source, 0, source.length);
    }

    public static void sink(Comparable[] heap, int target, int range) {
        while (target * 2 <= range) {
            int max;
            if (target * 2 + 1 <= range) {
                if (heap[target * 2 + 1].compareTo(heap[target * 2]) > 0) {
                    max = target * 2 + 1;
                } else {
                    max = target * 2;
                }
            } else {
                max = target * 2;
            }
            if (heap[max].compareTo(heap[target]) > 0) {
                exchange(heap, max, target);
                target = max;
            } else {
                break;
            }
        }
    }
}
