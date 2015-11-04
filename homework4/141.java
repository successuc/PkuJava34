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
        ListNode p,q,r;//利用快慢两个指针，二者速度差1
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