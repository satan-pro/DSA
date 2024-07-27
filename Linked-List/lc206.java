import java.util.*;
class lc206 // Reverse a Linked List
{
	public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  	// Iterative Method
	public ListNode reverseList1(ListNode head) {
        ListNode curr=head;
        ListNode prev=null;

        while(curr!=null)
        {
        	ListNode nextNode=curr.next;
        	curr.next=prev;
        	prev=curr;
        	curr=nextNode;
        }
        return prev;
    }

    // Recursive Method
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null)
            return head;

        ListNode newNode = reverseList(head.next); // Smaller to bigger problem
        // Everytime is returns the program goes back to the previous node 
        ListNode front = head.next;
        front.next=head;
        head.next=null; // Ending the LL
        return newNode;
    }
}