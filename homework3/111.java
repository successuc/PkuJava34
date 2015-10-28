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
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        else {
            int leftDepth = root.left != null ? minDepth(root.left): Integer.MAX_VALUE;
            int rightDepth = root.right != null ? minDepth(root.right): Integer.MAX_VALUE;
            //采用递归的思想，分别求左右子树的最小深度，比较之后返回较小值
            return Math.min(leftDepth, rightDepth) + 1;
        }
    // 开始想根据整棵树是不是单支划分，后来发现想错了，这样做太麻烦了，所以就用了递归求解
        // if(root == null) return 0;
        // if(root.left == null && root.right == null) return 1;
        // if((root.left == null && root.right != null) || (root.left != null && root.right == null)) return 2;
        // if(root.left == null && root.right != null) { //如果根节点只有一个分支
        //     return getDepth(root.right)+1;
        // }
        // if(root.left != null && root.right == null) {
        //     return getDepth(root.left)+1;
        // }
        // return Math.min(getDepth(root->left), getDepth(root->right)) + 1;
        // return Math.min(minDepth(root.left), getDepth(root.right)) + 1;
    // }
    // public int getDepth(TreeNode p){
    //     int LD,RD;
    //     if(p == null) return 0;
    //     else{
    //         // LD=getDepth(p->left);
    //         // RD=getDepth(p->right);
    //         LD=minDepth(p.left);
    //         RD=minDepth(p.right);
    //         return(LD>RD?LD:RD)+1;
    //     }
    // }
    }
}