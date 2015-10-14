public class Solution {
    public int reverse(int x) {
        int negative=1;  
        //负数先转正，用negative保存其符号
        if( x<0 ) {  
            negative = -1;  
            x = -x;  
        }  
          
        long y = x%10;  
          
        while( x/10 != 0 ) {  
            x /= 10;  
            y *= 10;  
            y += x%10;  
        }  
          
        //if(y>Integer.MAX_VALUE) {  
        if(y>Integer.MAX_VALUE||y<Integer.MIN_VALUE) { 
            //return -1;
            return 0;
        } else {  
            return (int) (negative*y);  
        }  
    }
}