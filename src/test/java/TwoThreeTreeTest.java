/**
 * @author: Joseph Li @ Dancincloud
 * Date: 11/10/21 12:58
 **/

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.*;

public class TwoThreeTreeTest {
    TwoThreeTree<Integer, String> twoThreeTree = new TwoThreeTree<>();
    @Test
    public void test0(){
        System.out.println("=== Test 0 ===");

        Integer[] keys = new Integer[]{};
        String[] values = new String[]{};

        testHelper(keys, values);
    }

    @Test
    public void test1(){
        System.out.println("=== Test 1 ===");

        Integer[] keys = new Integer[]{ 20 };
        String[] values = new String[]{"oh"};

        testHelper(keys, values);
    }

    @Test
    public void test2(){
        System.out.println("=== Test 2 ===");

        Integer[] keys = new Integer[]{18, 32 ,12, 10, 24, 19};
        String[] values = new String[]{"You", "passed", "the", "test", "case", "!"};

        testHelper(keys, values);
    }

    @Test
    public void test3(){
        System.out.println("=== Test 3 ===");

        Integer[] keys = new Integer[]{18, 32 ,12, 10, 24, 19};
        String[] values = new String[]{"You", "passed", "the", "test", "case", "!"};

        int n = keys.length;

        for(int i = 0; i < n; i++){
            twoThreeTree.put(keys[i], values[i]);
        }

        String[] result = new String[n], expected = new String[n];

        int index = 0;
        for(int i = n - 1; i >= 0; i--) {
            result[index] = twoThreeTree.get(keys[i]);
            expected[index] = values[i];
            index++;
        }

        System.out.println("result = " + Arrays.toString(result));
        System.out.println("expected = " + Arrays.toString(expected));
        Assert.assertTrue(Arrays.equals(result, expected));
    }

    @Test
    public void test4(){
        System.out.println("=== Test 4 ===");

        Integer[] keys = new Integer[]{90, 123 ,12, 2, 89, 78, 65, 66, 13, 42, 27};
        String[] values = new String[]{"have", "you", "finished", "your", "homework", "how", "about", "your", "midterm", "exam", "?"};

        int n = keys.length;

        for(int i = 0; i < n; i++){
            twoThreeTree.put(keys[i], values[i]);
        }

        String[] result = new String[n], expected = new String[n];

        Random random = new Random();
        int index = 0;
        for(int i = n - 1; i >= 0; i--) {
            int r = random.nextInt(n);
            result[index] = twoThreeTree.get(keys[r]);
            expected[index] = values[r];
            index++;
        }

        System.out.println("result = " + Arrays.toString(result));
        System.out.println("expected = " + Arrays.toString(expected));
        Assert.assertTrue(Arrays.equals(result, expected));
    }


    private void testHelper(Integer[] keys, String[] values){
        int n = keys.length;

        for(int i = 0; i < n; i++){
            twoThreeTree.put(keys[i], values[i]);
        }

        String[] result = new String[n];
        for(int i = 0; i < keys.length; i++) {
            result[i] = twoThreeTree.get(keys[i]);
        }

        System.out.println("result = " + Arrays.toString(result));
        System.out.println("expected = " + Arrays.toString(values));
        Assert.assertTrue(Arrays.equals(result, values));
    }
}
