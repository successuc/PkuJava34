public class Solution {

    public int maxDepth(TreeNode root) {

         int depth = 0;

        if(root != null){

            int leftDepth = maxDepth(root.left);

            int rightDepth = maxDepth(root.right);

            depth ++;

            if(leftDepth < rightDepth){

                depth = depth + rightDepth;

            }else{

                depth = depth + leftDepth;

            }

        }

        return depth;

    }

}
