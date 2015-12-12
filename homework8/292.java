public class Solution {

    public boolean canWinNim(int n) {

        if(n%4==0)  

            return false;  

        else  

            return true;  

    }

}
//当heap中有1、2、3个stones时一定获胜，当有4个stones时一定会输。那么当有5个stones//的时候，我们可以先拿出来一个stones，此时相当于我们面对4个stones时的情形。
//依次可以类推出，当heap中恰好有4N（N=1,2,3......）个stones时，我方一定会输。