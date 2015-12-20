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

    public boolean isSymmetric(TreeNode root) {

        if (root == null) {

            return true;

        } else {

            return isSame(root.left, root.right);

        }

    }

    private boolean isSame(TreeNode left, TreeNode right) {

        if (left == null && right == null) {

            return true;

        }  if (left != null && right == null || left == null && right != null){

            return false;

        } else {

    return left.val == right.val && isSame(left.left, right.right) && isSame(left.right, right.left);

        }

    }

}
/**ʹ�õݹ������⣬���ж������ӽ���Ƿ���ȣ����Ⱦͷ���false����Ⱦͽ����ӽ��������������ӽ�������ӽ����бȽϲ�����ͬʱ�����ӽ��������������ӽ������������бȽϣ�ֻ������ͬʱΪ���ǲŷ���true�����򷵻�false��**/

