
19:20:25
Freya 2015/10/25 19:20:25
public class Solution {
    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        if(num==null||num.length==0)
        return res;
        Arrays.sort(num);//from small to big num 
        for(int i=0;i<num.length;i++){
            ArrayList<Integer> sub=new ArrayList<Integer>();
            if(i>0&&num[i]==num[i-1])
                 continue;
            int n1=num[i];
            int sum=-n1;
            int p=i+1,q=num.length-1;
            while(p<q){
                if(num[q]+num[p]==sum){
                    sub.add(n1);
                    sub.add(num[p]);
                    sub.add(num[q]);
                    res.add((ArrayList<Integer>)sub.clone());
                    sub=new ArrayList<Integer>();
                    while(p+1<q&&num[p+1]==num[p]){
                        p++;
                    }
                    p++;
                        while(q-1>p&&num[q-1]==num[q])
                           q--;
                        q--;
                        }else if(num[q]+num[p]>sum){
                         q--;
                        }else{
                            p++;
                        }
                    }
                }
         return res;
    }
}


// ����two sum�ļбƷ������ȶ������������Ȼ������ѭ������һ�����ÿ��Ԫ�أ�Ȼ���ҵ���������������Ԫ�غ͵��ڸ�Ԫ�ء�
// ����Ҫ����ȥ�ظ������⡣�ڵڶ���ѭ���������ͬԪ�ؾͼ�����ǰ����һ��ѭ��������ͬԪ��Ҳ������ǰ����������ȥ�ظ���


