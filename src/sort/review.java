package sort;

import java.util.Arrays;

public class review {
    //交换arr数组中下标i和j的值
    public static void exchange(Comparable[] arr, int i, int j) {
        Comparable temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //1.冒泡排序
    public static void BubbleSort(Comparable[] arr) {
        for (int i = arr.length - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0)
                    exchange(arr, j, j + 1);
            }
        }
    }

    //2.选择排序
    public static void SelectionSort(Comparable[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex].compareTo(arr[j]) > 0) {
                    minIndex = j;
                }
                exchange(arr, i, minIndex);
            }
        }
    }

    //3.插入排序
    public static void InsertionSort(Comparable[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j >= 1; j--) {
                if (arr[j - 1].compareTo(arr[j]) > 0) {
                    exchange(arr, j - 1, j);
                } else
                    break;
            }
        }
    }

    //4.希尔排序
    public static void ShellSort(Comparable[] arr) {
        for (int h = arr.length / 2; h >= 1; h /= 2) {
            for (int i = h; i < arr.length; i++) {
                for (int j = i; j >= h; j -= h) {
                    if (arr[j - h].compareTo(arr[j]) > 0) {
                        exchange(arr, j - h, j);
                    } else
                        break;
                }
            }
        }
    }

    //5.归并排序
    public static Comparable[] assist;

    public static void MergeSort(Comparable[] arr) {
        int low = 0;
        int high = arr.length - 1;
        MergeSort(arr, low, high);
    }

    public static void MergeSort(Comparable[] arr, int low, int high) {
        int mid = (low + high) / 2;
        if (low >= high)
            return;
        MergeSort(arr, low, mid);
        MergeSort(arr, mid + 1, high);
        Merge(arr, low, mid, high);
    }

    public static void Merge(Comparable[] arr, int low, int mid, int high) {
        int p1 = low;
        int p2 = mid + 1;
        int i = low;
        assist = new Comparable[arr.length];
        while (p1 <= mid && p2 <= high) {
            if (arr[p1].compareTo(arr[p2]) < 0) {
                assist[i++] = arr[p1++];
            } else
                assist[i++] = arr[p2++];
        }
        while (p1 <= mid) {
            assist[i++] = arr[p1++];
        }
        while (p2 <= high) {
            assist[i++] = arr[p2++];
        }
        for (int n = low; n <= high; n++) {
            arr[n] = assist[n];
        }
    }

    //6.快速排序
    public static void QuickSort(Comparable[] arr) {
        int low = 0;
        int high = arr.length - 1;
        QuickSort(arr, low, high);
    }

    public static void QuickSort(Comparable[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int partition = partition(arr, low, high);
        QuickSort(arr, low, partition - 1);
        QuickSort(arr, partition + 1, high);
    }

    public static int partition(Comparable[] arr, int low, int high) {
        Comparable key = arr[low];
        while (low < high) {
            while (low < high && arr[high].compareTo(key) >= 0) {
                high--;
            }
            exchange(arr, low, high);
            while (low < high && arr[low].compareTo(key) <= 0) {
                low++;
            }
            exchange(arr, low, high);
        }
        return low;
    }

    //测试程序
    public static void main(String[] args) {
        Integer[] a1 = {5, 4, 3, 8, 7, 6, 2, 1};
        review.BubbleSort(a1);
        System.out.println(Arrays.toString(a1));
        Integer[] a2 = {5, 4, 3, 8, 7, 6, 2, 1};
        review.SelectionSort(a2);
        System.out.println(Arrays.toString(a2));
        Integer[] a3 = {5, 4, 3, 8, 7, 6, 2, 1};
        review.InsertionSort(a3);
        System.out.println(Arrays.toString(a3));
        Integer[] a4 = {5, 4, 3, 8, 7, 6, 2, 1};
        review.ShellSort(a4);
        System.out.println(Arrays.toString(a4));
        Integer[] a5 = {5, 4, 3, 8, 7, 6, 2, 1};
        review.MergeSort(a5);
        System.out.println(Arrays.toString(a5));
        Integer[] a6 = {5, 4, 3, 8, 7, 6, 2, 1};
        review.QuickSort(a6);
        System.out.println(Arrays.toString(a6));
    }
}
