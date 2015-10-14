public class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int count0 = 0, count1 = 0, count2 = 0;  //用三个数字记录数组中值为0,1,2的个数
        
        //扫描数组并记录
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                count0++;
            }
            else if (nums[i] == 1) {
                count1++;
            }
            else count2++;
        }
        //为数组重新赋值
        for(int j = 0; j < n; j++) {
            if (j< count0) 
                nums[j] = 0;
            else if (j>= count0 && j < count0 + count1)
                nums[j] = 1;
            else
                nums[j] = 2;
        }
    }
}

//优化后的代码：
public class Solution {
    public void sortColors(int[] nums) {
        // int n = nums.length;
        // int count0 = 0, count1 = 0, count2 = 0;  //用三个数字记录数组中值为0,1,2的个数
        
        // //扫描数组并记录
        // for (int i = 0; i < n; i++) {
        //     if (nums[i] == 0) {
        //         count0++;
        //     }
        //     else if (nums[i] == 1) {
        //         count1++;
        //     }
        //     else count2++;
        // }
        // //为数组重新赋值
        // for(int j = 0; j < n; j++) {
        //     if (j< count0) 
        //         nums[j] = 0;
        //     else if (j>= count0 && j < count0 + count1)
        //         nums[j] = 1;
        //     else
        //         nums[j] = 2;
        // }
        
        //优化算法：
        int n = nums.length;
        int i=0,front=0,rear=n-1;
        while ( i < n ){
            if ( nums[i] == 0 ) {
                if(i > front) {
                    swap(nums,front,i);
                    front++;
                }else {
                    i++;
                }
            }else if(nums[i] == 2) {
                if(i < rear) {
                    swap(nums,i,rear);
                    rear--;
                }else {
                    i++;
                }
            }else i++;
        }
    }
    private void swap(int nums[],int a,int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}