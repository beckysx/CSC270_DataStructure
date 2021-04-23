package Lab6_Priority_Queue;

public class Queue<T> {
    //node class
    class Node<T> {
        T ele;
        Node<T> next;
    }

    //be sure that your attributes are protected, so subclasses can use them
    protected Node<T> front;
    protected Node<T> back;
    protected int currentSize = 0;

    public Queue() {
        front = null;
        back = null;
    }


    /**
     * Adds val to the end of the queue
     */
    public void push(T val) {
        Node<T> newEle = new Node<T>();
        if (isEmpty()) {
            newEle.ele = val;
            newEle.next = null;
            front = newEle;
            back = newEle;
        } else {
            newEle.ele = val;
            newEle.next = null;
            back.next = newEle;
            back = newEle;
        }
        currentSize++;
    }


    /**
     * removes and returns the oldest value in the queue
     * throws QueueUnderFlowException if the queue is empty
     */
    public T pop() {
        if (isEmpty()) {
            throw new QueueUnderFlowException("The queue is empty.");
        } else {
            T oldEle = front.ele;
            front = front.next;
            currentSize--;
            return oldEle;
        }
    }


    /**
     * returns true if the queue is empty
     */

    public boolean isEmpty() {
        return front == null;
    }


}
