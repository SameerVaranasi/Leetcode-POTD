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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        int count =0 ;
        while(temp!=null){
            count++;
            temp =temp.next;
        }
        int position = count-n+1;
        if(position == 1){
            return head.next;
        }
        temp = head;
        for(int i =1 ; i<position-1 ; i++){
            temp=temp.next;
        }
        temp.next=temp.next.next;
        return head;

    }
}