public class Solution {
    public void rotate(int[] nums, int k) {
        //int temp;
        //int n=nums.length;
        //for (int step = 0; step < k; step++) {
            //temp = nums[n-1];
            //for (int i = n-1; i > 0; --i)
            //{
                //nums[i] = nums[i-1];
            //}
            //nums[0] = temp;
        //}
        int length = nums.length;
        
        k = k % length;
        
        if(length == 1)
        return;
        
        if(k == 0)
        return;
        
        //reve(nums, 0, length - k);
        reve(nums, 0, length - k - 1);
        reve(nums, length -k, length - 1);
        reve(nums, 0, length - 1);
    }
    public static void reve(int[] nums, int i, int j){
        int t = 0;
        while(i < j  && i >= 0){
            t= nums[i];
            nums[i] = nums[j];
            nums[j] = t;
            i++;
            j--;
        }
    }
}