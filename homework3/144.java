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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ls = new ArrayList<Integer>();
          if(root==null)
          return ls;
          Stack<TreeNode> st = new Stack<TreeNode>();
          //HashSet<TreeNode> hs = new HashSet<TreeNode>();
          
          st.push(root);
          while(!st.isEmpty())
         {
             TreeNode temp = st.pop();
            // if(hs.contains(temp))
            // {
                // ls.add(temp.val);
               //  continue;
            // }
            // hs.add(temp);
            // st.push(temp);
             //if(temp.right!=null)
                 ///st.push(temp.right);
            // if(temp.left!=null)
               //  st.push(temp.left);
            ls.add(temp.val);
            if(temp.right!=null)
            st.push(temp.right);
            if(temp.left!=null)
                st.push(temp.left);
            //}
         }
        return ls;
    }
}