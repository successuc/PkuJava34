//������������һ�ֳ�ʱ�Ľⷨ��������������
//public class Solution {
//     public int singleNumber(int[] nums) {
//         int n = nums.length;
//         boolean flag;
//         for (int i = 0 ; i < n ; i ++) {
//             flag = false;
//             for (int j = 0 ; j < n ; j ++) {
//                 // if (nums[i] == nums[j]) {
//                 if (nums[i] == nums[j]&& j != i) {
//                     flag = true;
//                 }
//             }
//             if (flag == false) {
//                 return nums[i];
//             }
//         }
//         return -1;
//     }
// }

//�Ż�����
public class Solution {
    public int singleNumber(int[] nums) {
        int n = nums.length;
        // boolean flag;
        // for (int i = 0 ; i < n ; i ++) {
        //     flag = false;
        //     for (int j = 0 ; j < n ; j ++) {
        //         // if (nums[i] == nums[j]) {
        //         if (nums[i] == nums[j]&& j != i) {
        //             flag = true;
        //         }
        //     }
        //     if (flag == false) {
        //         return nums[i];
        //     }
        // }
        // return -1;
        if(nums == null || n == 0){
            return -1;
        }
        int result = nums[0];
          
        for(int i = 1 ; i < n ; i ++){
           result = result ^ nums[i];
        }
        return result;
    }
}