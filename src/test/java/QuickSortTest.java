/**
 * @author: Joseph Li @ Dancincloud
 * Date: 10/27/21 10:48
 **/

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class QuickSortTest {

    QuickSort<Integer> qs = null;

    @Before
    public void init() {
        qs = new QuickSort<>();
    }

    @Test
    public void partitionTest1() {
        List<Integer> inputList = Arrays.asList(6,1,5,9,0,10,3,2);
        Assert.assertTrue(checkPartition(inputList));
    }

    @Test
    public void partitionTest2() {
        List<Integer> inputList = Arrays.asList(1,3,2);
        Assert.assertTrue(checkPartition(inputList));
    }

    @Test
    public void partitionTest3(){
        List<Integer> inputList = Arrays.asList(7,7,7,7,7,6);
        Assert.assertTrue(checkPartition(inputList));
    }

    private boolean checkPartition(List<Integer> inputList){
        int pivotIndex = qs.partition(inputList,0,inputList.size() - 1);
        Integer pivot = inputList.get(pivotIndex);

//            System.out.printf("pivot - inputList.get(%d) = %d\n", pivotIndex, pivot);
//
//            for(int i = 0; i < inputList.size(); i++){
//                System.out.print(inputList.get(i) + ", ");
//            }
//
//            System.out.println();

        for(int i = 0; i <= pivotIndex; i++){
            if(inputList.get(i).compareTo(pivot) > 0) return false;
        }

        for(int i = pivotIndex; i <= inputList.size() - 1; i++){
            if(inputList.get(i).compareTo(pivot) < 0) return false;
        }

        return true;
    }

    @Test
    public void quickSortRandomList() {
        List<Integer> inputList = Arrays.asList(6,1,5,9,0,10,3,2);
        List<Integer> expectedList = Arrays.asList(0,1,2,3,5,6,9,10);
        qs.sort(inputList);
        Assert.assertEquals(expectedList,inputList);
    }

    @Test
    public void quickSortReverseSortedTest() {
        List<Integer> inputList = Arrays.asList(10,9,8,7);
        List<Integer> expectedList = Arrays.asList(7,8,9,10);
        qs.sort(inputList);

        Assert.assertEquals(expectedList,inputList);
    }

    @Test
    public void quickSortSortedTest() {

        List<Integer> inputList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        List<Integer> expectedList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        qs.sort(inputList);
        Assert.assertEquals(expectedList,inputList);
    }

    @Test
    public void quickSortedDuplicateElementsTest() {
        List<Integer> inputList = Arrays.asList(7,4,1,2,3,3,7,9,8);
        List<Integer> expectedList = Arrays.asList(1,2,3,3,4,7,7,8,9);
        qs.sort(inputList);
        Assert.assertEquals(expectedList,inputList);
    }
}
