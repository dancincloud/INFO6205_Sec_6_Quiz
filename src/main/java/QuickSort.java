/**
 * @author: Joseph Li @ Dancincloud
 * Date: 10/27/21 10:48
 **/

import java.util.*;

public class QuickSort<T extends Comparable> {
    /*
     * This method accepts a list of elements of generic type T which are comparable
     * */
    public void sort(List<T> a)
    {
        sort(a, 0, a.size() - 1);
    }

    private  void sort(List<T> list, int lo, int hi)
    {
        if (hi <= lo) return;
        int pivot = partition(list, lo, hi);
        //TODO
        sort(list, lo, pivot - 1);
        sort(list, pivot + 1, hi);
    }


    /*
     *
     * Implement the partition method that determines the pivot element.
     * For T a and T b,
     * a.compareTo(b) == 0 -> a == b;
     * a.compareTo(b) < 0 -> a < b;
     * a.compareTo(b) > 0 -> a > b
     * */
    public int partition(List<T> list, int lo, int hi)
    {
        //TODO
        T pivot = list.get(lo);

        while (lo < hi){
            while (lo < hi && !less(list.get(hi), pivot)) hi--;
            list.set(lo, list.get(hi));

            while (lo < hi && less(list.get(lo), pivot)) lo++;
            list.set(hi, list.get(lo));
        }

        list.set(lo, pivot);

        return lo;
    }


    private void swap(List<T> list, int i, int j) {
        T t = list.get(i);
        list.set(i, list.get(j));
        list.set(j, t);
    }

    private  boolean less(T a, T b) {
        if(a.compareTo(b) < 0) {
            return true;
        }
        return false;
    }
}
