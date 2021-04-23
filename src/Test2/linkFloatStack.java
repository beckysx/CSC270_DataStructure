package Test2;

public class linkFloatStack {

    class Node {
        Node next;
        float val;
    }

    Node top;
    int size;

    public linkFloatStack() {
        top = null;
        size = 0;
    }

    public void push(float val) {
        Node newNode = new Node();
        newNode.val = val;

        if (size == 0) {
            top = newNode;
            newNode.next = null;
        } else {
            newNode.next = top;
            top = newNode;
        }
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    public void clear() {
        top = null;
        size = 0;
    }

    public float bottom() {
        if (isEmpty()) {
            return 123456;
        } else {
            Node temp = top;
            for (int i = 1; i < size; i++) {
                temp = temp.next;
            }
            return temp.val;
        }
    }


    public static void main(String[] args) {
        linkFloatStack s1 = new linkFloatStack();
        s1.push(1);
        s1.push(2);
        s1.push(3);

        System.out.println(s1.bottom());
        s1.clear();
        System.out.println(s1.bottom());

    }
}
