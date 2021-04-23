package final_lab;

import java.util.concurrent.TimeUnit;

public class IDStest {


    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            long start = System.nanoTime();

            //IDS
            TheLock three = new TheLock("becky" + i, 14);
            lockTree forThree = new lockTree(three);
            forThree.IDS();

            long end = System.nanoTime();
            long diff = end - start;
            System.out.println();
            System.out.println("Time: " + TimeUnit.NANOSECONDS.toMillis(diff));

        }

        // long start = System.nanoTime();
//       
//       //IDS
//          TheLock three=new TheLock("beckyInfinity");
//          lockTree forThree=new lockTree(three);
//          forThree.IDS();
//          
//          long end = System.nanoTime();
//          long diff = end-start;
//          System.out.println();
//          System.out.println("Time: "+TimeUnit.NANOSECONDS.toMillis(diff));
//       


    }

}