package sort;

public class Quick {
    public static void sort(Comparable[] arr) {
        int low = 0;
        int high = arr.length - 1;
        sort(arr, low, high);
    }

    public static void sort(Comparable[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int partition = partition(arr, low, high);
        sort(arr, low, partition - 1);
        sort(arr, partition + 1, high);
    }

    public static boolean less(Comparable x, Comparable y) {
        return x.compareTo(y) < 0;
    }

    public static void exchange(Comparable[] arr, int i, int j) {
        Comparable temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int partition(Comparable[] arr, int low, int high) {
        Comparable key = arr[low];
        int left = low;
        int right = high + 1;
        while (true) {
            while (less(key, arr[--right])) {
                if (right == low)
                    break;
            }
            while (less(arr[++left], key)) {
                if (left == high)
                    break;
            }
            if (left >= right)
                break;
            else
                exchange(arr, left, right);
        }
        exchange(arr,low,right);
        return right;
    }
}
