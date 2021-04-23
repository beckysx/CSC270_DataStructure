package Lab7_Memory_Manager;

public class MemoryManager {
    protected MemoryAllocation head;

    protected MemoryAllocation first;

    protected final String Free = "Free";

    /* size- how big is the memory space.
     *  Allways assume the position starts at 0
     *
     */
    public MemoryManager(long size) {
        head = new MemoryAllocation("head", -1, 0);
        first = new MemoryAllocation(Free, 0, size);
        head.prev = first;
        head.next = first;
        first.prev = head;
        first.next = head;
    }


    /**
     * takes the size of therequested memory and a string of the process requesting the memory
     * returns a memory allocation that satisfies that request, or
     * returns null if the request cannot be satisfied.
     */

    public MemoryAllocation requestMemory(long size, String requester) {
        MemoryAllocation mem = head.next;
        while (mem != head) {
            //free space bigger than the required size, split free space
            if (size < mem.getLength() && mem.getOwner() == Free) {
                long memsize = mem.getLength();
                MemoryAllocation theNew = new MemoryAllocation(requester, mem.getPosition(), size);
                theNew.prev = mem.prev;
                theNew.next = mem;
                mem.prev.next = theNew;
                mem.prev = theNew;
                mem.pos = theNew.pos + size;
                mem.len = memsize - size;
                return theNew;
            }

            //free space equal to the required size
            else if (size == mem.getLength() && mem.getOwner() == Free) {
                mem.owner = requester;
                return mem;
            }
            //the space is occupied, move to next memory allocation
            mem = mem.next;
        }
        return null;
    }


    /**
     * takes a memoryAllcoation and "returns" it to the system for future allocations.
     * Assumes that memory allocations are only returned once.
     */
    public void returnMemory(MemoryAllocation mem) {
        MemoryAllocation p = mem.prev;
        MemoryAllocation n = mem.next;
        long nlen = n.getLength();
        long plen = p.getLength();
        //both side free,merge three
        if (mem.prev.owner == Free && mem.next.owner == Free) {
            p.next = n.next;
            p.next.prev = p;
            p.len = plen + nlen + mem.getLength();
        }
        // merge last two
        if (mem.prev.owner != Free && mem.next.owner == Free) {
            mem.next = n.next;
            n.next.prev = mem;
            mem.len = mem.getLength() + nlen;
            mem.owner = Free;
        }
        //merge first two
        if (mem.prev.owner == Free && mem.next.owner != Free) {
            p.next = mem.next;
            n.prev = p;
            p.len = plen + mem.getLength();
        }
        //no merge
        if (mem.prev.owner != Free && mem.next.owner != Free) {
            mem.owner = Free;
        }

    }
}
