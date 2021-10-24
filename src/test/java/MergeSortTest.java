import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * @author: Joseph Li @ Dancincloud
 * Date: 10/19/21 00:58
 **/

public class MergeSortTest {
    static MergeSort mergeSort = new MergeSort();

//    @Test
//    public void testLess() {
//        Assert.assertTrue(mergeSort.testLess(1, 2));
//        Assert.assertFalse(mergeSort.testLess(1, 0));
//    }

    @Test
    public void testMerge(){
        Integer[] arr = new Integer[]{5, 7, 9, 10, 12, 1, 2, 6, 8, 11};
        mergeSort.testMerge(arr, 0, 4, arr.length - 1);

        Integer[] expect = new Integer[]{1, 2, 5, 6, 7, 8, 9, 10, 11, 12};
        Assert.assertArrayEquals(expect, arr);
    }

    @Test
    public void testSort1(){
        Integer[] arr = new Integer[]{5, 7, 9, 10, 12, 1, 2, 6, 8, 11};
        mergeSort.testSort(arr, 3, 5);

        Integer[] expect = new Integer[]{5, 7, 9, 1, 10, 12, 2, 6, 8, 11};
        Assert.assertArrayEquals(expect, arr);
    }

    @Test
    public void testSort2(){
        Integer[] arr = new Integer[]{6, 5, 1, 9, 19, 8, 17, 8};
        mergeSort.testSort(arr, 0, arr.length - 1);

        Integer[] expect = new Integer[]{1, 5, 6, 8, 8, 9, 17, 19};
        Assert.assertArrayEquals(expect, arr);
    }

    @Test
    public void testSort(){
        Integer[] arr = new Integer[]{1, 123, 89, 28, 8, 0, 1234, 87, 20};

        mergeSort.mergeSort(arr);

        Integer[] expect = new Integer[]{0, 1, 8, 20, 28, 87, 89, 123, 1234};
        Assert.assertArrayEquals(expect, arr);
    }

    @Test
    public void testWithRandom(){
        int n = 100;
        Integer[] arr = new Integer[n];

        Random random = new Random();
        for(int i = 0; i < n; i++) arr[i] = random.nextInt(n * 10);

        mergeSort.mergeSort(arr);

        List<Integer> list = Arrays.asList(arr);
        Collections.sort(list);

        Integer[] expect = new Integer[n];
        for(int i = 0; i < n; i++) expect[i] = list.get(i);

        Assert.assertArrayEquals(expect, arr);
    }
}
