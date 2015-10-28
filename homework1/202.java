public class Solution {
    public boolean isHappy(int n) {
        if(n<=0) return false;
        long ln =n,sum;
        Set<Long> set = new HashSet<Long>();
        
        while(ln<=Integer.MAX_VALUE){
            if(set.contains(ln))return false;
            else set.add(ln);
            sum=0;
            while(ln!=0){
                sum += Math.pow(ln%10,2);
                ln=ln/10;
                // ln = sum;
            }
                ln = sum;
                if(ln == 1) return true;
        }
        return false;
    }
}