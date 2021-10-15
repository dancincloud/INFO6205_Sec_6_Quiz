/**
 * @author: Joseph Li @ Dancincloud
 * Date: 10/13/21 09:25
 **/

public class InsertionSort<T extends Comparable<T>> {

    int swaps = 0;
    /**
     *
     * @param arr   sort the array arr
     */
    public void sort(T[] arr) {
        // TO DO
        for(int i = 1; i < arr.length; i++){
            for(int j = i - 1; j >= 0; j--){
                if(less(arr[j + 1], arr[j])) swap(arr, j, j + 1);
                else break;
            }
        }
    }

    /**
     * Method to determine if one T value is less than another.
     *
     * @param v   the candidate element.
     * @param w   the comparand element.
     * @return true only if v is less than w.
     * Tips:
     * 1. If v > w,  v.compareTo(w) = 1
     * 2. If v == w,  v.compareTo(w) = 0
     * 3. If v < w, v.compareTo(w) = -1;
     */
    private boolean less(T v, T w) {
        // TO DO
        return v.compareTo(w) < 0;
    }

    /**
     * Swap the elements of array a at indices i and j.
     *
     * @param arr   the array.
     * @param i   one of the indices.
     * @param j   the other index.
     */
    public void swap(T[] arr, int i, int j) {
        swaps++;
        // TO DO
        T t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}

