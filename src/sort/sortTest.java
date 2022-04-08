package sort;

import DataStructure.Heap;
import sort.*;

import java.util.Arrays;

public class sortTest {
    public static void main(String[] args) {
        Integer[] a = {4, 6, 3, 1, 2, 8, 7, 5, 9, 10, 0};
        Bubble.sort(a);
        System.out.println(Arrays.toString(a));
        Selection.sort(a);
        System.out.println(Arrays.toString(a));
        Insertion.sort(a);
        System.out.println(Arrays.toString(a));
        Shell.sort(a);
        System.out.println(Arrays.toString(a));
        Merge.sort(a);
        System.out.println(Arrays.toString(a));
        Quick.sort(a);
        System.out.println(Arrays.toString(a));
        Heap.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
