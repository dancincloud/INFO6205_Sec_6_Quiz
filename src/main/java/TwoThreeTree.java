/**
 * @author: Joseph Li @ Dancincloud
 * Date: 11/10/21 01:04
 **/

public class TwoThreeTree<Key extends Comparable<Key>, Value> {
    class TTNode {
        Key leftKey, rightKey;
        Value leftValue, rightValue;
        TTNode left, center, right; // Pointer to left/center/right child
        public TTNode(Key key, Value value){
            this.leftKey = key;
            this.leftValue = value;
        }

        // add a child node to a parent node
        private TTNode add(TTNode node) {
            if(rightKey == null){ // add to current node
                if(leftKey.compareTo(node.leftKey) < 0) {
                    rightKey = node.leftKey;
                    rightValue = node.leftValue;
                    center = node.left;
                    right = node.center;
                }else{
                    rightKey = leftKey;
                    rightValue = leftValue;

                    right = center;

                    leftKey = node.leftKey;
                    leftValue = node.leftValue;
                    center = node.center;
                    left = node.left;
                }

                return this;
            }

            if (leftKey.compareTo(node.leftKey) >= 0) { // Add left
                TTNode node1 = new TTNode(leftKey, leftValue);
                node1.left = node;
                node1.center = this;
                node.left = left;
                left = center;
                center = right;
                right = null;

                leftKey = rightKey;
                leftValue = rightValue;
                rightKey = null;
                rightValue = null;

                return node1;
            }

            if (rightKey.compareTo(node.leftKey) >= 0) { // Add center
                TTNode node_center = new TTNode(rightKey, rightValue);
                node_center.left = node.center;
                node_center.center = right;

                node.center = node_center;

                center = node.left;
                node.left = this;

                rightKey = null;
                rightValue = null;
                right = null;

                return node;
            }
            else { // Add right
                TTNode node1 = new TTNode(rightKey, rightValue);
                node1.left = this;
                node1.center = node;

                node.left = right;
                right = null;
                rightKey = null;
                rightValue = null;

                return node1;
            }
        }
    }

    private TTNode root; // root of 2-3 tree

    public TwoThreeTree(){};

    public void put(Key k, Value v){
        root = put(root, k, v);
    }

    private TTNode put(TTNode parent, Key k, Value v){
        if(parent == null) return new TTNode(k, v);

        if(parent.left == null){
            return parent.add(new TTNode(k, v));
        }

        if(k.compareTo(parent.leftKey) < 0){ // left
            TTNode node = put(parent.left, k, v);
            if(node == parent.left) return parent;
            else return parent.add(node);
        } else if(parent.rightKey == null || k.compareTo(parent.rightKey) < 0){ // center
            TTNode node = put(parent.center, k, v);
            if(node == parent.center) return parent;
            else return parent.add(node);
        }else{ // right
            TTNode node = put(parent.right, k, v);
            if(node == parent.right) return parent;
            else return parent.add(node);
        }
    }

    public Value get(Key key){
        TTNode x = root;
        while (x != null) {
            int cmp1 = key.compareTo(x.leftKey);
            if(cmp1 == 0) return x.leftValue;

            if(x.rightKey != null && key.compareTo(x.rightKey) == 0) return x.rightValue;

            if(cmp1 < 0) x = x.left;
            else if(x.right == null || key.compareTo(x.rightKey) < 0) x = x.center;
            else x = x.right;
        }

        return null;
    }

//    public void print(){
//        print(root);
//    }
//
//    private void print(TTNode node){
//        if(node == null) return;
//
//        System.out.println(node.leftKey.toString() + ", ");
//        if(node.rightKey != null) System.out.println("|" + node.rightKey.toString() + ", ");
//
//        print(node.left);
//        print(node.center);
//        print(node.right);
//    }
//
//    public static void main(String[] args) {
//        TwoThreeTree<Integer, Integer> twoThreeTree = new TwoThreeTree<>();
//        int[] nums = new int[]{90, 123 ,12, 2, 89, 78, 65};
//        for(int i = 0; i < nums.length; i++) twoThreeTree.put(nums[i], nums[i]);
//
//
//        twoThreeTree.print();
//    }
}
