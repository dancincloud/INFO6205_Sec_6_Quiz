/**
 * @author: Joseph Li @ Dancincloud
 * Date: 10/19/21 00:38
 **/

public class MergeSort {
    private Comparable[] aux;

    public void mergeSort(Comparable[] arr){
        aux = new Comparable[arr.length];
        sort(arr,0 ,arr.length - 1);
    }

    private void merge(Comparable[] arr, int lo, int mid, int hi){
        //TODO
        int i = lo, j = mid + 1;
        for(int k = lo; k <= hi; k++) aux[k] = arr[k];

        for(int k = lo; k <= hi; k++){
            if(i > mid) arr[k] = aux[j++];
            else if(j > hi) arr[k] = aux[i++];
            else arr[k] = less(aux[i], aux[j]) ? aux[i++] : aux[j++];
        }
    }

    private void sort(Comparable[] arr, int lo, int hi){
        //TODO
        if(hi<=lo) return;
        int mid = lo + (hi-lo)/2;
        sort(arr,lo,mid);
        sort(arr,mid+1,hi);
        merge(arr, lo, mid, hi);
    }

    private boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    /* Used for testing. Do not modify!!! */
    public boolean testLess(Comparable v, Comparable w) {
        return less(v, w);
    }

    public void testMerge(Comparable[] arr, int lo, int mid, int hi){
        aux = new Comparable[arr.length];
        merge(arr, lo, mid, hi);
    }

    public void testSort(Comparable[] arr, int lo, int hi){
        aux = new Comparable[arr.length];
        sort(arr, lo, hi);
    }
}
