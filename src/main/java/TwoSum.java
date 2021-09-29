import java.util.Arrays;
import java.util.Random;

// Quiz 1
public class TwoSum {
    public int countPairs(int[] nums, int target){
        // To do
        if (nums.length <= 1){
            return 0;
        }

        int ans = 0;
        int l = 0, r = nums.length - 1;
        while (l < r){
            int sum = nums[l] + nums[r];
            if(sum > target) r--;
            else if(sum < target) l++;
            else{
                ans++;
                l++;
                r--;
            }
        }

        return ans;
    }

    // personal test
    public static void main(String[] args){
        int[] nums = new int[10000];

        Random random = new Random();
        for (int i = 0; i < nums.length; i++){
            nums[i] = random.nextInt(1000000);
        }

        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++){
            System.out.print(nums[i] + ", ");
        }
        System.out.println();

        int target = 500000;
        int ans = 3;

        System.out.println("ans = " + new TwoSum().countPairs(nums, target));
    }
}
