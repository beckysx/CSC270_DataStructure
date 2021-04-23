package Test3;

/*
   Meant as a simple example with integers.
   If you'd like a more detailed example, see textbook. ;)
*/
public class IntBST {
    class Node // nested subclass with nodes
    {
        int val; // the data
        Node left = null; // left child/subtree
        Node right = null; // right child/subtree

        Node(int val) {
            this.val = val;
        } // simple node constructor
    }

    Node root = null; // the root of our BST (initially empty)
    float leaves = 0;

    public IntBST() {
    } // always write a constructor; in this case default constructor is fine

    /* Adds a new node to the tree. Doesn't rebalance. */
    public void add(int val) {
        root = add(val, root);
    } // call recursive function

    private Node add(int v, Node n) {
        if (n == null) { // base case: we have reached the place in BST where val goes!
            n = new Node(v); // insert new node with value v
        } else if (v <= n.val) { // recursive case 1: <=
            n.left = add(v, n.left);
        } else { // recursive case 2: >
            n.right = add(v, n.right);
        }
        return n; // note that this is essential: the base case doesn't do this for us!
    }

    public float AVGLDepth() {
        if (root == null) {
            return -1;
        } else {
            return levels(root) / leaves;
        }
    }

    public float levels(Node n) {
        if (n == null) {
            return 0;
        } else if (n.left == null && n.right == null) {
            leaves++;
            return 1;
        } else {
            return 1 + levels(n.left) + levels(n.right);
        }
    }


    public static void main(String[] args) {
        IntBST test1 = new IntBST();
        test1.add(10);
        test1.add(15);
        test1.add(8);
        test1.add(3);
        test1.add(9);
        test1.add(16);
        test1.add(14);
        float averageDepth = test1.AVGLDepth();
        System.out.println(averageDepth);
    }

}