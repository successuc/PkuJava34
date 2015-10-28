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
        Stack<TreeNode> s= new Stack<TreeNode>(); //��ʼջ
        TreeNode p;
        List<Integer> result= new ArrayList();
        if(root != null) {
            p = root;
            //���ܳ���ջ��״̬����������û����
            while(!s.empty() || p != null) {
                while(p!=null) {
                    s.push(p); 
                    p=p.left;     //����������ٳ�ջ
                }
                //ջ��������³�ջ����������
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