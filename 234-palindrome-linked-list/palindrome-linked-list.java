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
    public boolean isPalindrome(ListNode head) {
        //now lets do by using two-pointers 
        ListNode slow =head;
        ListNode fast = head;           //O(n/2)
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // now lets reverse the LL 
        ListNode prev =  null;
        ListNode current = slow;         // O(n/2)
        while(current != null){
            ListNode next = current.next;
            current.next=prev;
            prev = current;
            current = next ;
        }
        // now lets compare the LL
        ListNode first =  head;
        ListNode second = prev;             //O(n)
        while(second != null){
            if(first.val != second.val){
                return false; //because its not a palindrome 
            }
            first = first.next;
            second = second .next;
        }
        return true;

    }
}
//total tc O(2n)