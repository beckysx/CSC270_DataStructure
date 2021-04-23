package Lab6_Priority_Queue;

import java.util.Comparator;

public class PriorityQueue<T> extends Queue<T> {

    Comparator<T> comparator;

    public PriorityQueue(Comparator<T> comp) {
        comparator = comp;
    }


    //@Override
    public void push(T val) //sort from big to small
    {
        int count = currentSize;
        //empty queue, no need to compare
        if (count == 0) {
            super.push(val); //call superclass push method
        }
        //pop all element out one by one
        else {
            boolean pushed = false; //haven't inserted new val
            while (count > 0) {
                //pop the current
                T current = super.pop();
                //new val is bigger than the current
                if (comparator.compare(val, current) == 1 && !pushed) {
                    super.push(val); //push new val
                    pushed = true;
                }
                //push the current
                super.push(current);
                count--; //number of elements that need to pop out and push back
            }
            //new val is the smallest
            if (!pushed) {
                super.push(val);
            }
        }
    }

}
