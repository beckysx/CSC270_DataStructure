package Lab8_BSTree;

import java.lang.Comparable;
import java.util.function.Consumer;


/**
 * This is a smart Node that ustilzies generics.
 * Note how we ensured that the type T will always be comparable...
 */
public class BSTNode<T extends Comparable<T>> {

    private T val;
    private BSTNode<T> left;
    private BSTNode<T> right;


    public BSTNode(T val) {
        this(val, null, null);
    }


    public BSTNode(T val, BSTNode<T> l, BSTNode<T> r) {
        this.val = val;
        this.left = l;
        this.right = r;
    }


    /*
      Uses recursion to insert the target into the tree
     */
    public void insert(T target) {
        if ((target.compareTo(val) <= 0) && (this.left == null)) {
            left = new BSTNode(target);
        } else if ((target.compareTo(val) > 0) && (this.right == null)) {
            right = new BSTNode(target);
        } else {
            if (target.compareTo(val) <= 0) {
                left.insert(target);
            } else if (target.compareTo(val) > 0) {
                right.insert(target);
            }
        }

    }


    /*
      Uses recursion to rerived the value target from the tree.
      Returns null if it can't find the value.
     */
    public T retrieve(T target) {

        if ((target.compareTo(val) < 0) && (this.left == null)) {
            return null;
        } else if ((target.compareTo(val) > 0) && (this.right == null)) {
            return null;
        } else if (target == val) {
            return target;
        } else {
            if (target.compareTo(val) < 0) {
                return left.retrieve(target);
            } else {
                return right.retrieve(target);
            }
        }
    }


    /**
     * If it is present, what level is the node?
     * If it is not present, what level would it be placed.
     */
    public int retrieveDepth(T target) {
        if ((target.compareTo(val) < 0) && (this.left == null)) {
            return 1;
        } else if ((target.compareTo(val) > 0) && (this.right == null)) {
            return 1;
        } else if (target == val) {
            return 0;
        } else {
            if (target.compareTo(val) < 0) {
                return 1 + left.retrieveDepth(target);
            } else {
                return 1 + right.retrieveDepth(target);
            }
        }
    }


    /**
     * Uses recursion to return the largest value in the tree
     */
    public T getLargest() {
        if (this.right == null) {
            return this.val;
        } else {
            return right.getLargest();
        }

    }


    /**
     * Uses recursion to do an inorder traverals.
     * consume is part of a stratagy pattern, to determine what the "Visit" should be.
     */
    public void inOrderTraversal(Consumer<T> consume) {
        if (left != null) {
            left.inOrderTraversal(consume);
        }
        consume.accept(val);
        if (right != null) {
            right.inOrderTraversal(consume);
        }

    }


    /**
     * returns true if this tree is equal to that tree.
     * false otherwise.
     * <p>
     * Note: While I must always be non-null.
     * Nothing prevents "that" from being null.
     * <p>
     * This one is long!
     */
    public boolean myEquals(BSTNode<T> that) {
        if (val == that.val) {
            if ((left != null && that.left != null) && (right != null && that.right != null)) {
                boolean flagleft = left.myEquals(that.left);
                boolean flagright = right.myEquals(that.right);
                return flagleft && flagright;
            }
            if ((left != null && that.left != null) && (right == null && that.right == null)) {
                boolean flagleft = left.myEquals(that.left);
                return flagleft;
            }
            if ((left == null && that.left == null) && (right != null && that.right != null)) {
                boolean flagright = right.myEquals(that.right);
                return flagright;
            }
            if (left == null && that.left == null && right == null && that.right == null) {
                return true;
            } else {
                return false;
            }

        }
        return false;
    }
}
