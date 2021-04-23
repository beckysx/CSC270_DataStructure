package Lab6_Priority_Queue;

import java.util.Comparator;

public class PriorityQueueOLD<T> extends Queue<T> {

    Comparator<T> comparator;

    public PriorityQueueOLD(Comparator<T> comp) {
        super(); //call the queue construtor
        this.comparator = comp;
    }


    @Override
    public void push(T val) {
        Node<T> newEle = new Node<T>(); //new node that needs to push
        //empty queue: no need to sort
        if (isEmpty()) {
            newEle.ele = val;
            newEle.next = null;
            front = newEle;
            back = newEle;
        }

        //sort from big to smallest
        else {
            Node<T> current = front; // node from the front
            Node<T> previous = null; // the current will become the previous after each round

            while (current != null) {
                // if the current is smaller than the new
                if (comparator.compare(current.ele, newEle.ele) == -1) {
                    // first pair: front vs new
                    if (previous == null) {
                        newEle.next = front;
                        front = newEle;
                        //break;
                    } else {
                        previous.next = newEle;
                        newEle.next = current;
                        //break;
                    }
                }
                // if the current is equal to the new
                else if (comparator.compare(current.ele, newEle.ele) == 0) {
                    newEle.next = current.next;
                    current.next = newEle;
                    //break;

                }

                previous = current;
                current = current.next;
            }

            //if the new is the smallest
            if (current == null) {
                back.next = newEle;
                back = newEle;
            }


        }
        currentSize++;
    }

}