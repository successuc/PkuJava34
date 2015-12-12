public class Solution {
    public void moveZeroes(int[] nums) {
        int cnt = 0, pos = 0;
        // ����0���ֶ���������ǰ��
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[pos]= nums[i];
                pos++;
            }
        }
        
        // ��ʣ��Ķ���0
        for(;pos<nums.length; pos++){
            nums[pos] = 0;
        }
    }
}

//���Ӷ�  ʱ�� O(N) �ռ� O(1)
//ʵ���Ͼ��ǽ����еķ�0����ǰ�����ܵ�ѹ��������ûѹ�����ǲ���ȫ��0�����ˡ�����//103040����ѹ����134��ʣ���3λȫ��Ϊ0����������Ҫһ��ָ���¼ѹ������λ�á�