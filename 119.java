public class Solution {
    public List<Integer> getRow(int rowIndex) {
       List<Integer> list = new ArrayList<Integer>();  
        list.add(1);  
          
        List<Integer> pre = new ArrayList<Integer>(list);  
        for (int i = 1; i <= rowIndex; i++) {   
            list.clear();  
            list.add(1);  
            for (int j = 1; j < pre.size(); j++) {  
                list.add(pre.get(j) + pre.get(j-1));  
            }  
            list.add(1);  
            pre.clear();  
            pre.addAll(list);  
        }  
          
        return list;   
    }
}
