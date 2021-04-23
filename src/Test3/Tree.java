package Test3;/*
   Test 3 Prep
   This is not a binary tree.
   Each node can have an arbitrary number of children.
   
   Study the code and infer the design.
   
   Then solve these problems:
   1. Write int numDesc(String label) returns the number of the node's descendants.
   2. Write int numAnc(String label) returns the number of the node's ancestors.
   3. Write int height() returns the height of the tree.
   
   numDesc() and numAnc() throw NodeNotFoundException if node with label doesn't exist.
   
   You will want to write your own test cases. 
   Good luck!
*/

import java.util.ArrayList; // We use Java's class to store children
import java.util.List;

public class Tree {
    Node root; // There will always be a root


    /* Exception if node not found */
    class NodeNotFoundException extends Exception {
        public NodeNotFoundException() {
            super();
        }

        public NodeNotFoundException(String s) {
            super(s);
        }
    }


    public Tree(String label) {
        root = new Node(label); // There will always be a root node
    }

    /*
       Finds Node with label and inserts a new child.
       If label is null then the root is intended.
       Throws an exception if the position is
    */
    public void insert(String childLabel, String parentLabel) throws NodeNotFoundException {
        // call recursive helper function
        // if it returns false then child was not found
        // if it returns true then the action was successful
        if (!insert(childLabel, parentLabel, root))
            throw new NodeNotFoundException("Node " + parentLabel + " not found");
    }

    public boolean insert(String childLabel, String parentLabel, Node node) {
        if (node.label == parentLabel) // found node
        {
            System.out.println("Adding child");
            node.addChild(childLabel); // insert new child of parent
            return true;
        } else {
            for (Node child : node.children) {
                if (insert(childLabel, parentLabel, child))
                    return true;
            }
            return false; // child not found among this node's descendants
        }
    }

    public void display() {
        display(root);
    }

    public void display(Node node) {
        System.out.print(node.label + ": ");
        if (node.children.isEmpty()) {
            System.out.println("No children");
        } else {
            for (Node child : node.children)
                System.out.print(child.label + " ");
            System.out.println();
            for (Node child : node.children)
                display(child);
        }
    }

    //Write int numDesc(String label) returns the number of the node's descendants.
    public static int numDesc(Node node) {
        if (node.children.isEmpty()) {
            return 0;
        } else {
            int sum = 0;
            for (Node child : node.children) {
                sum += 1 + numDesc(child);
            }
            return sum;
        }
    }

    public Node getNodeforDesc(String label, Node node) throws NodeNotFoundException {
        if (node.label == label) {
            return node;
        } else {
            for (Node child : node.children) {
                return getNodeforDesc(label, child);
            }
            throw new NodeNotFoundException("Node " + label + " not found");
        }
    }


    public int numDesc(String label) throws NodeNotFoundException {
        Node found = getNodeforDesc(label, root);
        return numDesc(found);

    }


    //Write int numAnc(String label) returns the number of the node's ancestors.
    public int getNodeforAnc(String label, Node node) throws NodeNotFoundException {
        if (node.label == label) {
            return 0;
        } else {
            for (Node child : node.children) {
                return 1 + getNodeforAnc(label, child);
            }
            throw new NodeNotFoundException("Node " + label + " not found");
        }
    }

    public int numAnc(String label) throws NodeNotFoundException {
        return getNodeforAnc(label, root);
    }

    //Write int height() returns the height of the tree.
    public int height(Node node) {
        int height = 0;
        if (node == null) {
            return 0;
        }
        if (node.children.isEmpty()) {
            return 1;
        } else {
            for (Node child : node.children) {
                height = Math.max(height, height(child));
            }
            return height + 1;
        }

    }

    public int height() {
        return height(root);
    }


    /* Nested Node class */
    class Node {
        String label;
        List<Node> children;

        Node(String s) // constructor
        {
            label = s;
            children = new ArrayList<Node>();
        }

        void addChild(String label) // adds a new child with label
        {
            children.add(new Node(label));
        }

        Node getChild(String label) // returns the child with label
        {
            for (Node child : children) {
                if (child.label == label)
                    return child;
            }
            return null; // no such child
        }
    }


    public static void main(String[] args) throws NodeNotFoundException {
        /* Creates and displays a simple tree */
        Tree t = new Tree("ROOT");
        t.display();
        t.insert("A", "ROOT");
        t.insert("B", "ROOT");
        t.insert("C", "ROOT");
        t.insert("D", "A");
        t.insert("E", "B");
        t.insert("F", "B");
        t.display();
        int rootDec = t.numDesc("ROOT");
        System.out.println(rootDec);
        int rootAnc = t.numAnc("ROOT");
        System.out.println(rootAnc);
        int DAnc = t.numAnc("D");
        System.out.println(DAnc);
        System.out.println(t.height());
    }
}