package Test2;

public class DCAQ<T> {
    int size;
    T[] arr = null;
    int front = 0;
    int back = 0;
    int maxsize;

    public DCAQ(int maxsize) {
        size = 0;
        this.maxsize = maxsize;
        arr = (T[]) new Object[maxsize];

    }

    protected void enlarge() {
        maxsize = maxsize * 2;
        T[] large = (T[]) new Object[maxsize];
        int start = front;
        for (int i = 0; i < size; i++) {
            large[i] = arr[start];
            start = (start + 1) % arr.length;
        }
        arr = large;
        front = 0;
        back = size - 1;
    }

    protected void reduce() {
        maxsize = size;
        T[] reduce = (T[]) new Object[maxsize];
        int start = front;
        for (int i = 0; i < size; i++) {
            reduce[i] = arr[start];
            start = (start + 1) % arr.length;
        }
        arr = reduce;
        front = 0;
        back = size - 1;
    }

    public void push(T val) {
        if (size == maxsize) {
            enlarge();
        }
        back = (back + 1) % maxsize;
        arr[back] = val;
        size++;
    }

    public T pop() {


        T toreturn = arr[front];
        arr[front] = null;
        front = (front + 1) % maxsize;
        size--;
        if (size <= (maxsize / 2)) {
            reduce();
        }
        return toreturn;

    }


}