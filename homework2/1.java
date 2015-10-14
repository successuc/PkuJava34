public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int[] result = new int[2];
        //首先想到的就是两层遍历法,时间复杂度是O(n^2)
        for (int i = 0; i < n; i ++) {
            for (int j = i + 1; j < n; j ++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i+1;
                    result[1] = j+1;
                    return result;
                }
            }
        }
        return null;
    }
}

//优化后代码
import java.util.*;
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int[] result = new int[2];
        //首先想到的就是两层遍历法,时间复杂度是O(n^2)
        // for (int i = 0; i < n; i ++) {
        //     for (int j = i + 1; j < n; j ++) {
        //         if (nums[i] + nums[j] == target) {
        //             result[0] = i+1;
        //             result[1] = j+1;
        //             return result;
        //         }
        //     }
        // }
        // return null;
        
        //使用HashMap优化代码
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>(); //map中key为数组值，value为数组的index值
        for (int i = 0; i < n; i ++) {
            //查询nums[i]数值是否已经在map中，如果不在将其加入到map中
            Integer value = map.get(nums[i]);
            if (value == null) {
                map.put(nums[i],i+1);
            }
            //查询map中有无跟nums[i]相加得target的元素
            Integer another_value = map.get(target - nums[i]);
            // if (another_value != null) {
            if (another_value != null && another_value < i+1) {
                result[0] = another_value;
                result[1] = i+1;
                return result;
            }
        }
        return null;
    }
}