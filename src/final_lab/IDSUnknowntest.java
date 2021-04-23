package final_lab;

import java.util.concurrent.TimeUnit;

public class IDSUnknowntest {


    public static void main(String[] args) {
        long start = System.nanoTime();

        //IDS
        TheLock unknown = new TheLock("beckyunknown");
        lockTree forUnknown = new lockTree(unknown);
        forUnknown.IDS();


        long end = System.nanoTime();
        long diff = end - start;
        System.out.println();
        System.out.println("Time: " + TimeUnit.NANOSECONDS.toMillis(diff));

    }


}