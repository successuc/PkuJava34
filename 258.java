public class Solution {
    
   // public int addDigits(int num) {
      //  int next = Next(num);
       // while (next >= 10) {
          //  next = Next(next);
       // }
        //return next;
  //  }
    
     //private int Next(int num) {
        //String s = String.valueOf(num);
        //int sum = 0;
        //for (char ch : s.toCharArray()) {
          //  sum += (ch - '0');
       // }
       // return sum;
    //}
    public int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }
}