public class Solution {
    public String reverseWords(String s) {
        Stack wordStack = new Stack();      //表示单词的stack
        Stack sentenceStack = new Stack();  //表示句子的stack
        char str[] =  s.toCharArray();
        
        int i=0;
        //while(i <= s.size()) {
        while(i <= s.length()) {  
            //遇到非空格字符时放入word
            //if(s[i] != ' ' && i != s.size() ) {
            //if(s[i] != ' ' && i != s.length() ) {
            //if(s.charAt(i) != ' ' && i != s.length() ) {
            // if(str[i] != ' ' && i < s.length() ) {   这里因为下标越界总是出现runTime错误
                //wordStack.push(s[i]); 
                // wordStack.push(s.charAt(i));
                // wordStack.push(str[i]);
            // }
            //遇到空格情况
            // else { 
                // if(!wordStack.empty()) {
                    // if(!sentenceStack.empty()) {
                        // sentenceStack.push(' ');     //为各字符间添加空格
                    // }
                // }
                // while(!wordStack.empty()) {
                    // sentenceStack.push(wordStack.peek());  //将word中的字符压入sentence中
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
        // };   这里没注意多打了个一行，导致多次提交失败，哎，。。
        return new_str.toString();
    }
}