/**
 * @author: Joseph Li @ Dancincloud
 * Date: 11/17/21 01:03
 **/

public class SCHashNode {
    String key;
    Integer value;
    int hashCode;

    SCHashNode next;

    public SCHashNode(){};

    public SCHashNode(String k, Integer v, int hashCode) {
        this.key = k;
        this.value = v;
        this.hashCode = hashCode;
    }
}
