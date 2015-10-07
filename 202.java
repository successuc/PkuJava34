public class Solution {
    public boolean isHappy(int n) {
        Set<Integer> numberSet = new HashSet<Integer>();
         
        while (n!=1){
            //if (numberSet.add(n+1)==false){
                //return false;
            //}
             if (numberSet.add(n)==false){
                return false;
            }
            char[] chars = String.valueOf(n).toCharArray();
            int total = 0;
            for (Character ch: chars){
                total += Math.pow(Integer.parseInt(ch+""),2);
            }
            n = total;
        }
        return true;
    }
}