package TEST1;

public class Test1 {
    public static float division(int a, int b) {
        float result = (float) a / (float) b;
        return result;
    }

    public int divBy3(int[] array, int length) {
        int times = 0;
        for (int i = 0; i < length; i++) {
            int remain = array[i] % 3;
            if (remain != 0) {
                times++;
            }
        }
        if (times == 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public int maxof3(int a, int b, int c) {
        int big = a;
        int compare[] = new int[3];
        compare[0] = a;
        compare[1] = b;
        compare[2] = c;
        for (int i = 0; i < 3; i++) {
            if (compare[i] > big) {
                big = compare[i];
            } else {
                big = big;
            }
        }
        return big;
    }

    public void fillErUp(int[] intArray, int lenArray) {

        int a = 1;
        int b = 1;
        intArray[0] = a;
        intArray[1] = b;
        for (int i = 2; i < lenArray; i++) {
            int c = a + b;
            intArray[i] = c;
            a = b;
            b = c;
            i++;
        }

    }

    public void reverseInPlace(int[] intArray) {
        int len = intArray.length;
        int i = 0;
        int j = len - 1;
        while (i < j) {
            int temp = intArray[i];
            intArray[i] = intArray[j];
            intArray[j] = temp;
            i++;
            j--;
            //1,2,3,4,5
        }
    }

}