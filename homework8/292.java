public class Solution {

    public boolean canWinNim(int n) {

        if(n%4==0)  

            return false;  

        else  

            return true;  

    }

}
//��heap����1��2��3��stonesʱһ����ʤ������4��stonesʱһ�����䡣��ô����5��stones//��ʱ�����ǿ������ó���һ��stones����ʱ�൱���������4��stonesʱ�����Ρ�
//���ο������Ƴ�����heap��ǡ����4N��N=1,2,3......����stonesʱ���ҷ�һ�����䡣