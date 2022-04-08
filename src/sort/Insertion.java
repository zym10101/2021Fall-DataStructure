package sort;

public class Insertion {
    public static void sort(Comparable[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (greater(arr[j - 1], arr[j]))
                    exchange(arr, j - 1, j);
                else
                    break;
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
