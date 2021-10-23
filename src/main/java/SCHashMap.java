/**
 * @author: Joseph Li @ Dancincloud
 * Date: 11/17/21 00:11
 **/

public class SCHashMap {
    static final int PRIME = 31;

    private SCHashNode[] map;

    public SCHashMap(){
        map = new SCHashNode[SCHashMap.PRIME];
    }

    /* You don't need to implement remove function, and this function can give you some hints.
    public void remove(String key){
        int hashCode = hash(key);
        int index = Math.abs(hashCode % SCHashMap.PRIME);

        SCHashNode dummy = new SCHashNode();
        dummy.next = map[index];

        SCHashNode prev = dummy, curt = dummy.next;
        while (curt != null){
            if(curt.hashCode == hashCode){
              prev.next = curt.next;
            }
            else {
                prev = curt;
                curt = curt.next;
            }
        }

        map[index] = dummy.next;
    }
    */

    // Hint: Get hashCode via hash function and map it to 'SCHashNode[] map'
    public void put(String k, Integer v){
        int hashCode = hash(k);
        int index = Math.abs(hashCode % SCHashMap.PRIME);

        SCHashNode node = new SCHashNode(k, v, hashCode);
        if(map[index] == null){
            map[index] = node;
        }else{
            SCHashNode dummy = new SCHashNode();
            dummy.next = map[index];

            SCHashNode curt = dummy;

            while (curt.next != null){
                if(curt.next.hashCode == hashCode){
                    curt.next.value = v;
                    return;
                }
                curt = curt.next;
            }

            curt.next = node;
        }
    }

    // if key exists, return value, otherwise return -1;
    public Integer get(String key){
        int hashCode = hash(key);
        int index = Math.abs(hashCode % SCHashMap.PRIME);

        SCHashNode curt = map[index];
        while (curt != null){
            if(curt.hashCode == hashCode) return curt.value;
            else curt = curt.next;
        }
        return -1;
    }


    private int hash(String key){
        return key.hashCode();
    }

    /* Used for Testing */
    public void print(){
        for(int i = 0; i < SCHashMap.PRIME; i++){
            if(map[i] == null) continue;
            else {
                System.out.println("index = " + i);

                SCHashNode curt = map[i];
                while (curt != null){
                    System.out.printf("%s : %d\n", curt.key, curt.value);
                    curt = curt.next;
                }

                System.out.println();
            }
        }
    }

    public SCHashNode[] getMap(){
        return map;
    }

    public static void main(String[] args) {
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

          map.print();
    }
}
