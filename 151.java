public class Solution {
    public String reverseWords(String s) {
        Stack wordStack = new Stack();      //��ʾ���ʵ�stack
        Stack sentenceStack = new Stack();  //��ʾ���ӵ�stack
        char str[] =  s.toCharArray();
        
        int i=0;
        //while(i <= s.size()) {
        while(i <= s.length()) {  
            //�����ǿո��ַ�ʱ����word
            //if(s[i] != ' ' && i != s.size() ) {
            //if(s[i] != ' ' && i != s.length() ) {
            //if(s.charAt(i) != ' ' && i != s.length() ) {
            // if(str[i] != ' ' && i < s.length() ) {   ������Ϊ�±�Խ�����ǳ���runTime����
                //wordStack.push(s[i]); 
                // wordStack.push(s.charAt(i));
                // wordStack.push(str[i]);
            // }
            //�����ո����
            // else { 
                // if(!wordStack.empty()) {
                    // if(!sentenceStack.empty()) {
                        // sentenceStack.push(' ');     //Ϊ���ַ�����ӿո�
                    // }
                // }
                // while(!wordStack.empty()) {
                    // sentenceStack.push(wordStack.peek());  //��word�е��ַ�ѹ��sentence��
                    // wordStack.pop();
                // }
            // }
            if (i == s.length() || str[i] == ' ') {
                if(!wordStack.empty()) {
                    if(!sentenceStack.empty()) {
                      sentenceStack.push(' '); 
                    }
                    while(!wordStack.empty()) {
                        sentenceStack.push(wordStack.peek());
                        wordStack.pop();
                    }
                }
            }else {
                 wordStack.push(str[i]);
            }
            i++;
        }
        //String new_str;  
        StringBuffer new_str = new StringBuffer();
        while(!sentenceStack.empty()){  
                new_str.append(sentenceStack.peek());
                sentenceStack.pop(); 
        }
        // };   ����ûע�����˸�һ�У����¶���ύʧ�ܣ���������
        return new_str.toString();
    }
}