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


/*˼·����������Ԫ�صľ����㷨��MooreͶƱ�㷨�������������Ϊ����Ԫ�غͲ�ͬԪ��һһ��Ӧ���������ʣ������Ԫ�ؾ�����Ԫ�ء����������ǣ���ʼ������times��candidate����0,Ȼ��������飬��timesΪ0ʱ�û��µ�candidate��������candidate��ͬԪ��times++��������candidate����Ԫ��times--����˲����������Ԫ�ش��ڣ����ʣ�µ�һ������Ԫ�ء�ʱ�临�Ӷ�O��n��,�ռ临�Ӷ�O��1��.*/