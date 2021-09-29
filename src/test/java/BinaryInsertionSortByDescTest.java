import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class BinaryInsertionSortByDescTest {

    @Test
    public void BISTest1() {
        BinaryInsertionSortByDesc bis = new BinaryInsertionSortByDesc();
        int[] arr = new int[]{1, 5, 3, 2, 4};
        int[] expect = new int[]{5, 4, 3, 2, 1};
        int[] ans = bis.insertionSort(arr, 5);
        List<Integer> ansList = new ArrayList<>();
        List<Integer> expectList = new ArrayList<>();
        for (int n : ans) {
            ansList.add(n);
        }
        for (int n : expect) {
            expectList.add(n);
        }
        Assert.assertEquals(expectList, ansList);
    }

    @Test
    public void BISTest2() {
        BinaryInsertionSortByDesc bis = new BinaryInsertionSortByDesc();
        int[] arr = new int[]{10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        int[] expect = new int[]{100, 90, 80, 70, 60, 50, 40, 30, 20, 10};
        int[] ans = bis.insertionSort(arr, 10);
        List<Integer> ansList = new ArrayList<>();
        List<Integer> expectList = new ArrayList<>();
        for (int n : ans) {
            ansList.add(n);
        }
        for (int n : expect) {
            expectList.add(n);
        }
        Assert.assertEquals(expectList, ansList);
    }

    @Test
    public void BISTest3() {
        BinaryInsertionSortByDesc bis = new BinaryInsertionSortByDesc();
        int[] arr = new int[]{99, 45, 31, 23, 1};
        int[] expect = new int[]{99, 45, 31, 23, 1};
        int[] ans = bis.insertionSort(arr, 5);
        List<Integer> ansList = new ArrayList<>();
        List<Integer> expectList = new ArrayList<>();
        for (int n : ans) {
            ansList.add(n);
        }
        for (int n : expect) {
            expectList.add(n);
        }
        Assert.assertEquals(expectList, ansList);
    }

    @Test
    public void BISTest4() {
        BinaryInsertionSortByDesc bis = new BinaryInsertionSortByDesc();
        int[] arr = new int[]{1011, 1, 27, 67, 872, 456, 122, 77};
        int[] expect = new int[]{1011, 872, 456, 122, 77, 67, 27, 1};
        int[] ans = bis.insertionSort(arr, 8);
        List<Integer> ansList = new ArrayList<>();
        List<Integer> expectList = new ArrayList<>();
        for (int n : ans) {
            ansList.add(n);
        }
        for (int n : expect) {
            expectList.add(n);
        }
        Assert.assertEquals(expectList, ansList);
    }

    @Test
    public void BISTest5() {
        BinaryInsertionSortByDesc bis = new BinaryInsertionSortByDesc();
        int[] arr = new int[]{998, 78, 101, 56, 1, 77};
        int[] expect = new int[]{998, 101, 78, 77, 56, 1};
        int[] ans = bis.insertionSort(arr, 6);
        List<Integer> ansList = new ArrayList<>();
        List<Integer> expectList = new ArrayList<>();
        for (int n : ans) {
            ansList.add(n);
        }
        for (int n : expect) {
            expectList.add(n);
        }
        Assert.assertEquals(expectList, ansList);
    }
}