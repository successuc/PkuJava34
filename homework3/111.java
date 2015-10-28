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
            //���õݹ��˼�룬�ֱ���������������С��ȣ��Ƚ�֮�󷵻ؽ�Сֵ
            return Math.min(leftDepth, rightDepth) + 1;
        }
    // ��ʼ������������ǲ��ǵ�֧���֣�������������ˣ�������̫�鷳�ˣ����Ծ����˵ݹ����
        // if(root == null) return 0;
        // if(root.left == null && root.right == null) return 1;
        // if((root.left == null && root.right != null) || (root.left != null && root.right == null)) return 2;
        // if(root.left == null && root.right != null) { //������ڵ�ֻ��һ����֧
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