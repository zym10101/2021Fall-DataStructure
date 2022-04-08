package sort;

public class Bubble {
    public static void sort(Comparable[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (greater(arr[j], arr[j + 1]))
                    exchange(arr, j, j + 1);
            }
        }
    }

    public static boolean greater(Comparable x, Comparable y) {
        return x.compareTo(y) > 0;
    }

    public static void exchange(Comparable[] arr, int i, int j) {
        Comparable temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
