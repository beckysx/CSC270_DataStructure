package Lab6_Priority_Queue;

public class TestQueue {
    public static void main(String[] args) {
        Queue<Integer> queueInt = new Queue<Integer>();

        //push
        assert queueInt.isEmpty() : "The queue should be empty.";
        queueInt.push(1);
        queueInt.push(2);
        queueInt.push(3);
        assert queueInt.pop() == 1 : "It is 1.";
        assert queueInt.pop() == 2 : "It is 2.";
        assert queueInt.pop() == 3 : "It is 3.";

        boolean flag;
        flag = false;

        try {
            queueInt.pop();
        } catch (QueueUnderFlowException e) {
            assert true;
            flag = true;
        }
        assert (flag) : "Cannot pop empty queue.";

    }
}