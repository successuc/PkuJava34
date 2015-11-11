public class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (i == 0) {
                result += map.get(ch);
            } else {
                char prev = s.charAt(i - 1);
                if (map.get(ch) > map.get(prev)) {
                    result += map.get(ch);
                    result -= map.get(prev) * 2;
                } else {
                    result += map.get(ch);
                }
            }
        }
 
        return result;
    }
}