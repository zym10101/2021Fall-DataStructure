package sort;

public class Selection {
    public static void sort(Comparable[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (greater(arr[minIndex], arr[j]))
                    minIndex = j;
            }
            exchange(arr, minIndex, i);
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
