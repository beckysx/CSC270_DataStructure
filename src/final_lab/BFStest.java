package final_lab;

import java.util.concurrent.TimeUnit;

public class BFStest {


    public static void main(String[] args) {


        for (int i = 0; i < 5; i++) {
            long start = System.nanoTime();

            //BFS
            TheLock two = new TheLock("becky" + i, 10);
            lockTree forTwo = new lockTree(two);
            forTwo.BFS();


            long end = System.nanoTime();
            long diff = end - start;
            System.out.println();
            System.out.println("Time: " + TimeUnit.NANOSECONDS.toMillis(diff));

        }


    }

}