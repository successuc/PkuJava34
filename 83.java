/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // if (head == null || head -> next == null) return head;
        if (head == null || head.next == null) return head;
        ListNode p,q,result;
        p = head;
        result = new ListNode(head.val);
        q = result;
        while( p != null) {
            if(p.val != q.val) {
                q.next = new ListNode(p.val);
                // q = q -> next;
                q = q.next;
            }  
            p = p.next;
        }
        return result;
    }
}