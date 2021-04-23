package final_lab;

import java.util.concurrent.TimeUnit;

public class DLStest {


    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {

            long start = System.nanoTime();
            //DLS
            TheLock one = new TheLock("becky" + i, 14);
            lockTree forOne = new lockTree(one);
            forOne.DLS(14);

            long end = System.nanoTime();
            long diff = end - start;
            System.out.println();
            System.out.println("Time: " + TimeUnit.NANOSECONDS.toMillis(diff));
        }


    }

}