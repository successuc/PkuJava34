public class Solution {
    public boolean isPalindrome(String s) {
        if (s == null) {  
            return false;  
        }  
        if (s.length() == 0 || s.length() == 1) {  
            return true;  
        }  
        StringBuffer sb = new StringBuffer();                          
        for (int i = 0; i < s.length();i++){  
            Character ch = s.charAt(i);  
                //if(Character.isLetter(ch)){  
                if(Character.isLetter(ch) || Character.isDigit(ch)){  
                sb.append(Character.toUpperCase(ch));  
  
            } else {  
                continue;  
            }  
        }  
        int start = 0 ;  
        int end = sb.length() - 1;  
        while ( start < end) {  
            if (sb.charAt(start) == sb.charAt(end)) {  
                start ++;  
                end --;  
            } else {  
                return false;   
            }  
        }  
        return true;  
    }
}
