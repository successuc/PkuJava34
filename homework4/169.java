public class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;  
        int candidate = 0;  
        int times = 0;  
        for(int i = 0; i < n; i++){  
            if(times == 0) candidate = nums[i];  
            if(nums[i] != candidate){  
                times--;  
            } else{  
                times++;  
            }  
        }  
        return candidate;  
    }
}


/*思路分析：求主元素的经典算法是Moore投票算法，基本可以理解为将主元素和不同元素一一对应相消，最后剩下来的元素就是主元素。具体做法是，初始计数器times和candidate都是0,然后遍历数组，当times为0时置换新的candidate，遇到和candidate相同元素times++，遇到和candidate相异元素times--，如此操作，如果主元素存在，最后剩下的一定是主元素。时间复杂度O（n）,空间复杂度O（1）.*/