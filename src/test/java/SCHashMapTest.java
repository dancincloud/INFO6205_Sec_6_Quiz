/**
 * @author: Joseph Li @ Dancincloud
 * Date: 11/17/21 00:59
 **/
import org.junit.Assert;
import org.junit.Test;

public class SCHashMapTest {
    @Test
    public void testPut1(){
        SCHashMap map = new SCHashMap();

        String[] keys = new String[]{"Hi", "Do", "you", "like", "coding", "?"};
        Integer[] values = new Integer[]{4, 12, 63, 34, 25, 16};

        for(int i = 0; i < keys.length; i++){
            map.put(keys[i], values[i]);
        }

        SCHashNode[] arr = map.getMap();
        Assert.assertEquals(arr[1].key, "?");
        Assert.assertEquals(arr[8].key, "like");
        Assert.assertEquals(arr[12].key, "Hi");
        Assert.assertEquals(arr[18].key, "Do");
        Assert.assertEquals(arr[24].key, "you");
        Assert.assertEquals(arr[25].key, "coding");
    }

    @Test
    public void testPut2(){
        SCHashMap map = new SCHashMap();

        String[] keys = new String[]{"Hi", "Do", "you", "like", "coding", "?"};
        Integer[] values = new Integer[]{1, 2, 3, 4, 5, 6};
        Integer[] values2 = new Integer[]{11, 12, 13, 14, 15, 16};

        for(int i = 0; i < keys.length; i++){
            map.put(keys[i], values[i]);
        }

        for(int i = 0; i < keys.length; i++){
            map.put(keys[i], values2[i]);
        }

        SCHashNode[] arr = map.getMap();

        Assert.assertTrue(arr[1].value == 16);
        Assert.assertTrue(arr[8].value == 14);
        Assert.assertTrue(arr[12].value == 11);
        Assert.assertTrue(arr[18].value == 12);
        Assert.assertTrue(arr[24].value == 13);
        Assert.assertTrue(arr[25].value == 15);
    }

    @Test
    public void testGet1(){
        SCHashMap map = new SCHashMap();

        String[] keys = new String[]{"Is", "it", "difficult", "for", "you", "?"};
        Integer[] values = new Integer[]{1, 2, 3, 4, 5, 6};


        for(int i = 0; i < keys.length; i++){
            map.put(keys[i], values[i]);
        }

        Assert.assertTrue(map.get("Hi") == -1);
    }

    @Test
    public void testGet2(){
        SCHashMap map = new SCHashMap();

        String[] keys = new String[]{"Is", "it", "difficult", "for", "you", "?"};
        Integer[] values = new Integer[]{1, 2, 3, 4, 5, 6};


        for(int i = 0; i < keys.length; i++){
            map.put(keys[i], values[i]);
        }

        for(int i = 0; i < keys.length; i++){
            Assert.assertEquals(map.get(keys[i]), values[i]);
        }
    }

    @Test
    public void testGet3(){
        SCHashMap map = new SCHashMap();

        String[] keys = new String[]{"Is", "it", "difficult", "for", "you", "?"};
        Integer[] values = new Integer[]{1, 2, 3, 4, 5, 6};
        Integer[] values2 = new Integer[]{4, 12, 63, 34, 25, 16};


        for(int i = 0; i < keys.length; i++){
            map.put(keys[i], values[i]);
        }

        for(int i = 0; i < keys.length; i++){
            map.put(keys[i], values2[i]);
        }

        for(int i = 0; i < keys.length; i++){
            Assert.assertEquals(map.get(keys[i]), values2[i]);
        }
    }

    @Test
    public void testCombine(){
        SCHashMap map = new SCHashMap();

        String[] keys = new String[]{"Is", "it", "difficult", "for", "you", "?"};
        Integer[] values = new Integer[]{1, 2, 3, 4, 5, 6};
        Integer[] values2 = new Integer[]{4, 12, 63, 34, 25, 16};


        for(int i = 0; i < keys.length; i++){
            map.put(keys[i], values[i]);
        }


        for(int i = 1; i < keys.length; i+=2){
            map.put(keys[i], values2[i]);
        }

        Integer[] expected = new Integer[]{1, 12, 3, 34, 5, 16};
        for(int i = 0; i < keys.length; i++){
            Assert.assertEquals(map.get(keys[i]), expected[i]);
        }
    }
}
