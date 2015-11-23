public class Solution {
    public int removeDuplicates(int[] nums) {
        int size = nums.length;
        if (size == 0) return 0;
        // Set<Integer> set = new HashSet<Integer>();
        // for (int i = 0;i < size;i ++) {
        //     set.add(nums[i]);
        // }
        // return set.size();
        
        int count = 1;
        for (int i = 1; i < size; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            }else{
                nums[count] = nums[i];
                count++;
            }
        }
         return count;
    }
}