public class Solution {
    public boolean isUgly(int num) {
        if (num <= 0)   return false;
        if (num == 1)   return true;
        
        //如果能被2、3、5整除，则为丑数
        // while ( num % 2 == 0 )   num = num / 2;
        // while ( num % 3 == 0 )   num = num / 3;
        // while ( num % 5 == 0 )   num = num / 5;
        if ( num % 2 == 0 )  return isUgly ( num / 2 );
        else if ( num % 3 == 0 )   return isUgly ( num / 3 );
        else if ( num % 5 == 0 )   return isUgly ( num / 5 );
        
        return false;
    }
}