/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode p,q,r;//���ÿ�������ָ�룬�����ٶȲ�1
        p=head;
        q=head;
        // while(q != NULL && q.next != NULL) {
        while(q != null && q.next != null) {
            p=p.next;
            r=q.next;
            q=r.next;
            if(p == q) return true;
        }
        return false;
        
    }
}