public class Solution {

    public int removeElement(int[] nums, int val) {

            int size=0,length=nums.length;    

            for(int i=0;i<length;i++){           

                if(nums[i]!=val)nums[size++]=nums[i];  

                }      

                return size; 

    }

}
