package Lab5_Paint;

import Lab4_NotePad.StackUnderFlowException;

public class IntStack {
    protected Node top;

    public IntStack() {
        this.top = null;
    }


    //pushes val onto the stack
    public void push(int val) {
        Node temp = new Node();
        temp.val = val;
        temp.link = top;
        top = temp;
    }

    //returns the top element from the stack
    //If the stack is empty, it will throw a StackUnderFlowException.
    public int top() {
        if (top == null) {
            throw new StackUnderFlowException("The stack is empty. Can't return top value.");
        } else {
            return top.val;
        }
    }


    //returns the top element from the stack
    //removes the top element from the stack
    //If the stack is empty, it will throw a StackUnderFlowException.
    public int pop() {
        if (top == null) {
            throw new StackUnderFlowException("The stack is empty. Nothing to pop.");
        } else {
            int rmValue = top.val;
            top = top.link;
            return rmValue;
        }
    }

    //reports if the stack is empty
    public boolean isEmpty() {
        if (top == null) {
            return true;
        } else {
            return false;
        }
    }


}

class Node {
    int val;
    Node link;
}
