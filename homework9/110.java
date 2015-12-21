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
    public boolean isBalanced(TreeNode root) {
        if (root == null)  return true;
        if (Math.abs(getHeight(root.left,0)-getHeight(root.right,0)) > 1 ) {
            return false;
        }
        else return isBalanced(root.left) && isBalanced(root.right);
    }
    public int getHeight(TreeNode t,int current) {
        if(t == null) return current;
        return Math.max(getHeight(t.left, current+1),getHeight(t.right, current+1));
    }
}