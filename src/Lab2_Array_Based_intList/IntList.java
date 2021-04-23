package Lab2_Array_Based_intList;

public class IntList {


    protected int maxSize = 0;
    protected int[] array = null;
    protected int size = 0;

    public IntList(int maxSize) {
        this.maxSize = maxSize;
        array = new int[maxSize];
        size = 0;
    }


    /**
     * returns the maximum number of integers that can be stored in the array
     */

    public int getMaxSize() {
        return maxSize;
    }


    /**
     * returns the element at position, pos.
     * If the position pos does not exist simply return -1
     */
    public int getPos(int pos) {
        if (pos < 0 || pos > size - 1) {
            return -1;
        } else {
            return array[pos];
        }

    }

    public int length() {

        return size;

    }


    /**
     * removes the element at position, pos
     * returns true if the element was removed successfully, and false otherwise.
     */
    public boolean remove(int pos) {
        if (pos < 0 || pos >= size) {
            return false;
        } else if (size == 1 && pos == 0) {
            //no need to move things down.
            size--;
            return true;
        } else {

            for (int i = pos; i < size - 1; i++) {
                array[i] = array[i + 1];
            }
            size--;
            return true;
        }

    }


    /**
     * adds the element right before the positions listed.
     * (I.e) the new element will become the element at position pos.
     * All other elements will be shifted down to make room.
     * If the insert is successful, this will return true.
     * Otherwise, if there is no room in the list or if the insert position occured after empty spaces, return false
     */
    public boolean insertBefore(int element, int pos) {
        if (pos < 0 || pos >= size + 1 || size == maxSize) {
            return false;
        } else {

            for (int i = size; i > pos; i--) {
                array[i] = array[i - 1];
            }
            array[pos] = element;
            size++;
            return true;
        }


    }


}
