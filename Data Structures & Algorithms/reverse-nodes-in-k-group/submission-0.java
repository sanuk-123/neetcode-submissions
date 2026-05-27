/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || k==1) return head;
        ListNode cur=head;
        for(int i=0;i<k;i++){
            if(cur==null) return head;
            cur=cur.next;
        }
        ListNode newHead=reverse(head,cur);
        head.next=reverseKGroup(cur,k);
        return newHead;

    }
    public ListNode reverse(ListNode start,ListNode end){
        ListNode cur=start;
        ListNode prev=null;

        while(cur!=end){
            ListNode temp=cur.next;
            cur.next=prev;
            prev=cur;
            cur=temp;
        }
        return prev;
    }
}
