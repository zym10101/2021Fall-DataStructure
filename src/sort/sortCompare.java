package sort;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class sortCompare {
    public static void BubbleTest(Integer[] arr) {
        long start = System.currentTimeMillis();
        Bubble.sort(arr);
        long end = System.currentTimeMillis();
        System.out.println("冒泡排序时间：" + (end - start) + "毫秒");
    }

    public static void SelectionTest(Integer[] arr) {
        long start = System.currentTimeMillis();
        Selection.sort(arr);
        long end = System.currentTimeMillis();
        System.out.println("选择排序时间：" + (end - start) + "毫秒");
    }

    public static void InsertionTest(Integer[] arr) {
        long start = System.currentTimeMillis();
        Insertion.sort(arr);
        long end = System.currentTimeMillis();
        System.out.println("插入排序时间：" + (end - start) + "毫秒");
    }

    public static void ShellTest(Integer[] arr) {
        long start = System.currentTimeMillis();
        Shell.sort(arr);
        long end = System.currentTimeMillis();
        System.out.println("希尔排序时间：" + (end - start) + "毫秒");
    }
    public static void MergeTest(Integer[] arr) {
        long start = System.currentTimeMillis();
        Merge.sort(arr);
        long end = System.currentTimeMillis();
        System.out.println("归并排序时间：" + (end - start) + "毫秒");
    }
    public static void QuickTest(Integer[] arr) {
        long start = System.currentTimeMillis();
        Quick.sort(arr);
        long end = System.currentTimeMillis();
        System.out.println("快速排序时间：" + (end - start) + "毫秒");
    }

    public static void main(String[] args) throws Exception {
        ArrayList<Integer> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("data.txt")));
        String line = null;
        while ((line = reader.readLine()) != null) {
            int i = Integer.parseInt(line.trim());
            list.add(i);
        }
        reader.close();
        Integer[] arr = new Integer[list.size()];
        list.toArray(arr);
        //BubbleTest(arr);
        SelectionTest(arr);
        //InsertionTest(arr);
        //ShellTest(arr);
        //MergeTest(arr);
        //QuickTest(arr);
    }
}

