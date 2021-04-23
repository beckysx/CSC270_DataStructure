package Lab6_Priority_Queue;

public class TestPriorityQueue {
    public static void main(String[] args) {
        Customer c1 = new Customer(10, 10, 10);
        Customer c2 = new Customer(5, 5, 5);
        Customer c3 = new Customer(10, 5, 0);

        //comparators
        Customer.WorthComparator wc = new Customer.WorthComparator();

        assert wc.compare(c1, c2) == 1;
        assert wc.compare(c2, c1) == -1;
        assert wc.compare(c1, c3) == 0;

        Customer.LoyaltyComparator lc = new Customer.LoyaltyComparator();

        assert lc.compare(c1, c2) == 1;
        assert lc.compare(c2, c1) == -1;
        assert lc.compare(c2, c3) == 0;

        Customer.WorthPoliteComparator wpc = new Customer.WorthPoliteComparator();

        assert wpc.compare(c1, c2) == 1;
        assert wpc.compare(c2, c1) == -1;
        assert wpc.compare(c1, c1) == 0;
        assert wpc.compare(c1, c3) == 1;
        assert wpc.compare(c3, c1) == -1;

        //priority queue
        PriorityQueue<Customer> p1 = new PriorityQueue<Customer>(wc);

        p1.push(c1);
        p1.push(c2);
        p1.push(c3);

        assert p1.pop() == c1;
        assert p1.pop() == c3;
        assert p1.pop() == c2;

        PriorityQueue<Customer> p2 = new PriorityQueue<Customer>(lc);

        p2.push(c1);
        p2.push(c2);
        p2.push(c3);

        assert p2.pop() == c1;
        assert p2.pop() == c2;
        assert p2.pop() == c3;

        PriorityQueue<Customer> p3 = new PriorityQueue<Customer>(wpc);

        p3.push(c1);
        p3.push(c2);
        p3.push(c3);

        assert p3.pop() == c1;
        assert p3.pop() == c3;
        assert p3.pop() == c2;

    }
}