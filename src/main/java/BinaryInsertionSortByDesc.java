public class BinaryInsertionSortByDesc {
    public int binarySearch(int[] a, int item, int low, int high)
    {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (item == a[mid])
                return mid;
            else if (item < a[mid])
                low = mid + 1;
            else
                high = mid - 1;
        }
        return low;
    }


    public int[] insertionSort(int[] nums, int length) {
        // to do
        for (int i = 1; i < length; i++) {
            int target = nums[i];

            int p = binarySearch(nums, target, 0, i);
            if (p != i) {
                for (int j = i - 1; j >= p; j--) {
                    nums[j + 1] = nums[j];
                }
                nums[p] = target;
            }
        }

        return nums;
    }

    // personal test
    public static void main(String args[]) {

        BinaryInsertionSortByDesc bis = new BinaryInsertionSortByDesc();
        int[] arr = new int[]{1, 4, 3, 7, 5, 9, 2, 0};
        int[] ans = bis.insertionSort(arr, arr.length);

        for(int i : ans){
            System.out.print(i + ", ");
        }
        System.out.println();
        System.out.println("!!! Please click the run unit test button and NOT \"Execute main()\" button");
    }
}
