public class Solution {
    public int climbStairs(int n) {
        // if (n < 0) return 0; 
        // if (n == 0 || n == 1) return 1;
        // return climbStairs(n-1) + climbStairs(n-2);
        if (n == 0 || n == 1) return 1;
        int[] step = new int[n];
        step[0]=1;
        step[1]=2;
        for(int i=2;i<n;i++) {
            step[i] = step[i-1] +step[i-2];
        }
        return step[n-1];
    }
}}