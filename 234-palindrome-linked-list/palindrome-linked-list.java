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
 import java.util.*;
class Solution {
    public boolean isPalindrome(ListNode head) {
        // using the stack we will be solving the problem 
        Stack<Integer> nums = new Stack<>();   
        ListNode temp = head;
        while(temp!=null){
            nums.push(temp.val);
            temp=temp.next;
        }
        temp = head;
        while(temp!= null){
            if(temp.val!=nums.pop()){return false;}
            temp=temp.next;
        }
        return true;
        
    }
}