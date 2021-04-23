package Lab7_Memory_Manager;

public class TestMemoryManager {
    public static void main(String[] args) {
        //test 1
        MemoryManager test = new MemoryManager(30);
        MemoryAllocation a = test.requestMemory(10, "a");
        assert a.getOwner() == "a" : "should be a not " + a.getOwner();
        assert a.getLength() == 10 : "should be 10 not " + a.getLength();
        MemoryAllocation b = test.requestMemory(20, "b");
        assert b.getPosition() == 10 : "should be 10 not " + b.getPosition();

        //insert when there is no free space
        assert test.requestMemory(10, "d") == null : "no free space";

        //return a first
        test.returnMemory(a);
        assert a.getOwner() == "Free" : "a is free space now not" + a.getOwner();
        test.returnMemory(b);
        MemoryAllocation d = test.requestMemory(30, "ddd");
        assert d.getOwner() == "ddd" : "should be ddd not " + d.getOwner();

        //test 2
        MemoryManager test2 = new MemoryManager(10);
        MemoryAllocation x = test2.requestMemory(5, "a");
        MemoryAllocation y = test2.requestMemory(5, "a");

        //return y first
        test2.returnMemory(y);
        test2.returnMemory(x);
        MemoryAllocation e = test2.requestMemory(10, "e");

        //test 3
        MemoryManager test3 = new MemoryManager(15);
        MemoryAllocation aa = test3.requestMemory(5, "aa");
        MemoryAllocation bb = test3.requestMemory(5, "bb");
        MemoryAllocation cc = test3.requestMemory(5, "cc");

        //return the middle at last
        test3.returnMemory(aa);
        test3.returnMemory(cc);
        test3.returnMemory(bb);
        MemoryAllocation g = test3.requestMemory(15, "e");
        assert g.getPosition() == 0;


    }
}