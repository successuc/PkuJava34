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
    public TreeNode invertTree(TreeNode tn){  
        /*if(tn == null) return null; 
        TreeNode temp = tn.left; 
        tn.left = tn.right; 
        tn.right = temp; 
        invertTree(tn.left); 
        invertTree(tn.right); 
        return tn;*/  
        //0719  
        if(tn == null) return null;  
        Stack<TreeNode> tnStack = new Stack<TreeNode>();  
        tnStack.push(tn);  
        while(!tnStack.isEmpty()){  
            TreeNode cur = tnStack.pop();  
            TreeNode temp = cur.left;  
            cur.left = cur.right;  
            cur.right = temp;  
            if(cur.left != null) tnStack.push(cur.left);  
            if(cur.right != null) tnStack.push(cur.right);  
        }  
        return tn;  
        //0726  
    }  
}