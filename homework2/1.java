public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int[] result = new int[2];
        //�����뵽�ľ������������,ʱ�临�Ӷ���O(n^2)
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

//�Ż������
import java.util.*;
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int[] result = new int[2];
        //�����뵽�ľ������������,ʱ�临�Ӷ���O(n^2)
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
        
        //ʹ��HashMap�Ż�����
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>(); //map��keyΪ����ֵ��valueΪ�����indexֵ
        for (int i = 0; i < n; i ++) {
            //��ѯnums[i]��ֵ�Ƿ��Ѿ���map�У�������ڽ�����뵽map��
            Integer value = map.get(nums[i]);
            if (value == null) {
                map.put(nums[i],i+1);
            }
            //��ѯmap�����޸�nums[i]��ӵ�target��Ԫ��
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