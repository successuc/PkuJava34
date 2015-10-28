/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> s= new Stack<TreeNode>(); //初始栈
        TreeNode p;
        List<Integer> result= new ArrayList();
        if(root != null) {
            p = root;
            //可能出现栈空状态，但遍历还没结束
            while(!s.empty() || p != null) {
                while(p!=null) {
                    s.push(p); 
                    p=p.left;     //左儿子入完再出栈
                }
                //栈不空情况下出栈并加入数组
                if(!s.empty()) {
                    p=s.pop();
                    result.add(p.val);
                    p=p.right;
                }
            }
        }
        return result;
    }
}