package Test2;

public class Howdy {
    public static void howdy(int a) {
        if (a == 1) {
            System.out.println("Howdy");
        } else if (a <= 0) {
            return;
        } else {
            System.out.println("Howdy");
            howdy(a - 1);
        }
    }

    public static int product(int[] array, int start, int end) {

        if (start < 0 || end >= array.length) {
            return -123;
        } else if (start == end) {
            return array[start];
        } else {
            return product(array, start + 1, end) * array[start];
        }
    }

    public static void main(String[] args) {
        howdy(3);
        int[] arr = {1, 2, 3};
        int value = product(arr, 0, 2);
        System.out.println(value);

    }

}