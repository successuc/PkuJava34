public class Solution {
    public int lengthOfLastWord(String s) {
        String [] sp = s.split(" ");  
            //for(int i=sp.length;i>=0;i--){  
            for(int i=sp.length-1;i>=0;i--){  
                if(sp[i].length()>0)  
                    return sp[i].length();  
            }  
       return 0;  
    }
}