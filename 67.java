public class Solution {
    public String addBinary(String a, String b) {
        //int alen=a.length;
        //int blen=b.length;
        //int alen=a.size-1;
        //int alen=a.length-1;
        int alen=a.length()-1;
        int blen=b.length()-1;
        int c=0;
        char[] achar=a.toCharArray();
        char[] bchar=b.toCharArray();
        //int rlen=Math.max(achar.length,bchar.length+1);
        //int rlen=Math.max(achar.length,bchar.length+2);
        int rlen=Math.max(achar.length,bchar.length)+2;
        char[] rchar=new char[rlen];
        int k=0;
        while(true){
            if(alen<0 && blen<0 && c==0){
                break;
            }
            int al=0;
            int bl=0;
            //if(alen>0){
            if(alen>=0){
                al=achar[alen]-'0';
            }
            //if(blen>0){
            if(blen>=0){
                //a=achar[blen]-'0';
                bl=bchar[blen]-'0';
            }
            if(al+bl+c>1){
                rchar[k]=(char)('0'+al+bl+c-2);
                c=1;
            }else{
                rchar[k]=(char)('0'+al+bl+c);
                c=0;
            }
            k++;
            alen--;
            blen--;
        }
        return new StringBuffer(new String(rchar, 0, k)).reverse().toString();
    }
}