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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ls = new ArrayList<Integer>();
        if(root==null)
              return ls;
         Stack<TreeNode> st = new Stack<TreeNode>();
          HashSet<TreeNode> hs = new HashSet<TreeNode>(); 
         st.push(root);
          while(!st.isEmpty())
         {
             TreeNode temp = st.pop();
             if(hs.contains(temp))
             {
                 ls.add(temp.val);
                 continue;
             }
             hs.add(temp);
             st.push(temp);
             if(temp.right!=null)
                 st.push(temp.right);
             if(temp.left!=null)
                 st.push(temp.left);
         }
         return ls;
       }
}     

//后序遍历顺序为左，右，根,主要是需要区分得到的节点是需要展开还是直接遍历。一般来说第一次访问节点则展开，并且自己重新入栈，第二次从栈中访问到则计入遍历。这里采用HashSet来判断是否已经访问过。
