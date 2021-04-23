package Lab8_BSTree;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class TestBSTree {
    // check the inorder
    public static boolean testInorder(List<Integer> list) {
        boolean isInorder = true;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < list.get(i - 1)) {
                isInorder = false;
                return isInorder;
            }
        }
        return isInorder;
    }

    //generate random tree
    public static BSTree randomtree() {
        BSTree tree = new BSTree();
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            int random = rand.nextInt(100);
            System.out.println(random);
            tree.insert(random);
        }
        return tree;
    }

    //sum of list
    public static int sum(List<Integer> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum = sum + list.get(i);
        }
        return sum;
    }

    // test largest, size, inorder and sum
    public static void testTree(BSTree tree) {
        List<Integer> list = tree.toList();
        assert tree.getSize() == list.size();
        if (tree.isEmpty()) {
            //test largest
            assert tree.largest() == null : "is null not " + tree.largest();
            //test size
            assert tree.getSize() == 0 : "is 0 not " + tree.getSize();
            //test sum
            assert tree.sum() == 0 : "is 0 not " + tree.sum();
        } else {
            //test inorder
            assert testInorder(list);
            //test largest 
            assert tree.largest() == Collections.max(list);
            //test size
            assert tree.getSize() == list.size();
            //test sum
            assert tree.sum() == sum(list);
            ;
        }
    }

    public static void treeEquals(BSTree tree1, BSTree tree2, boolean equal) {
        assert tree1.myEquals(tree2) == equal;
        assert tree2.myEquals(tree1) == equal;
    }

    public static BSTree makeTree(int[] arr) {
        BSTree tree = new BSTree();
        for (int i = 0; i < arr.length; i++) {
            tree.insert(arr[i]);
        }
        return tree;
    }

    public static void main(String[] args) {
        BSTree test1 = new BSTree();
        BSTree test2 = new BSTree();
        //assert test1.myEquals(test2)==true;
        assert test1.isEmpty() == true;
        testTree(test1);
        test1.insert(1);
        test1.insert(5);
        test1.insert(10);
        assert test1.isEmpty() == false;
        assert test1.retrieve(5) == 5;
        assert test1.retrieve(20) == null;
        assert test1.retrieveDepth(5) == 1;
        assert test1.retrieveDepth(6) == 3 : "is 3 not " + test1.retrieveDepth(6);
        //assert test2.myEquals(test1)==false;


        BSTree test4 = randomtree();
        testTree(test4);
      
      /*int[] A={50,72,96,94,107,26,12,11,9,10,25,51,16,17,95};
      int[] B={50,72,96,94,107,26,12,11,9,25,51,16,17,95};
      int[] C={50,72,96,94,107,26,12,11,9,10,25,51,16,17,95,18};
      int[] D={50,72,96,94,107,26,12,11,9,10,25,16,17,95};
      int[] E={50,72,96,94,107,26,12,11,9,10,25,51,16,17,95,51};
      
      BSTree aT=makeTree(A);
      BSTree bT=makeTree(B);
      BSTree cT=makeTree(C);
      BSTree dT=makeTree(D);
      BSTree eT=makeTree(E);
      
      treeEquals(aT,bT, false);
      treeEquals(aT,cT, false);
      treeEquals(aT,dT, false);
      treeEquals(aT,eT, false);
      treeEquals(aT,aT, true);*/


    }
}
      
      
      