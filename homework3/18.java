public class Solution {
    public List<List<Integer>> fourSum(int[] num, int target) {
        Arrays.sort(num);
       // for (int i=0; i<num.length-2; i++) {
           // if(i!=0 && num[i]==num[i-1])
               // continue;
                 
            //int left = i+1;
           // int right = num.length-1;
           // while (left<right) {
                //if (left>i+1 && num[left]==num[left-1]) {
                    //left++;
                    //continue;
                //}
               // if (right<num.length-2 && num[right]==num[right+1]) {
                  //  right--;
                   // continue;
               // }
                 
               // int sum = num[i] + num[left] + num[right];
                //if (sum==0) {
                   // List<Integer> item = new ArrayList<>();
                   // item.add(num[i]);
                   // item.add(num[left]);
                   // item.add(num[right]);
                   // list.add(item);
                     
                   // left++;
                   // right--;
               // } else if (sum>0) {
                   // right--;
               // } else {
                    //left++;
               // }/
          //  }
       // }
         
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for (int i = 0; i <= num.length - 3; i++) {
            if (i != 0 && num[i] == num[i-1])
                continue;
 
            for (int j = i + 1; j <= num.length - 2; j++) {              
                if (j != i + 1 && num[j] == num[j-1])
                    continue;
             
                int left = j + 1, right = num.length - 1;
                while (left < right) {
                    if (left != j + 1 && num[left] == num[left-1]) {
                        left++;
                        continue;
                    }
                    if (right != num.length - 1 && num[right] == num[right+1]) {
                        right--;
                        continue;
                    }
                     
                    int sum = num[i] + num[j] + num[left] + num[right];
                    if (sum == target) {
                        List<Integer> item = new ArrayList<Integer>();
                        item.add(num[i]);
                        item.add(num[j]);
                        item.add(num[left]);
                        item.add(num[right]);
 
                        list.add(item);
                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                } 
            } 
        } 
 
        return list;
    }
}