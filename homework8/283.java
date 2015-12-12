public class Solution {
    public void moveZeroes(int[] nums) {
        int cnt = 0, pos = 0;
        // 将非0数字都尽可能向前排
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[pos]= nums[i];
                pos++;
            }
        }
        
        // 将剩余的都置0
        for(;pos<nums.length; pos++){
            nums[pos] = 0;
        }
    }
}

//复杂度  时间 O(N) 空间 O(1)
//实际上就是将所有的非0数向前尽可能的压缩，最后把没压缩的那部分全置0就行了。比如//103040，先压缩成134，剩余的3位全置为0。过程中需要一个指针记录压缩到的位置。