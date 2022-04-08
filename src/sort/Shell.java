package sort;

public class Shell {
    public static void sort(Comparable[] arr) {
        for (int h = arr.length / 2; h >= 1; h /= 2) {
            for (int i = h; i < arr.length; i++) {
                for (int j = i; j >= h; j -= h) {
                    if (greater(arr[j - h], arr[j]))
                        exchange(arr, j - h, j);
                    else
                        break;
                }
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
