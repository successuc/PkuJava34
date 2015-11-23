public class Solution {
    public boolean containsDuplicate(int[] nums) {
        int size = nums.length;
        Set<Integer> set = new HashSet<Integer>();
        // for(int i = 0;i < size;i ++) {
        //     for(int j = i+1;j < size;j ++) {
        //         if(nums[i] == nums[j]) {
        //             return true;
        //         }
        //     }
        // }
        for(int i = 0;i < size;i ++) {
            set.add(nums[i]);
        }
        if(set.size() < size) {
            return true;
        }
        return false;
    }
}