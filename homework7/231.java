public class Solution {
    public boolean isPowerOfTwo(int n) {
        int x=0;
        while(n>0){
            x += (n&1);
            n>>=1;
        }
        return x==1;
    }
}