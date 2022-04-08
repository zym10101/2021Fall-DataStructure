package sort;

public class Merge {
    public static Comparable[] assist;

    public static void sort(Comparable[] arr) {
        assist = new Comparable[arr.length];
        int low = 0;
        int high = arr.length - 1;
        sort(arr, low, high);
    }

    public static void sort(Comparable[] arr, int low, int high) {
        int mid = (high + low) / 2;
        if (low >= high)
            return;
        sort(arr, low, mid);
        sort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }

    public static boolean less(Comparable x, Comparable y) {
        return x.compareTo(y) < 0;
    }

    public static void merge(Comparable[] arr, int low, int mid, int high) {
        int p1 = low;
        int p2 = mid + 1;
        int i = low;
        while (p1 <= mid && p2 <= high) {
            if (less(arr[p1], arr[p2]))
                assist[i++] = arr[p1++];
            else
                assist[i++] = arr[p2++];
        }
        while (p1 <= mid)
            assist[i++] = arr[p1++];
        while (p2 <= high)
            assist[i++] = arr[p2++];
        for (int n = low; n <= high; n++) {
            arr[n] = assist[n];
        }
    }
}

