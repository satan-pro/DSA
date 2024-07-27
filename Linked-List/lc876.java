import java.util.*;
class lc876 // Find the middle of a linked list
{
	public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  	// Brute Force Approach
	public ListNode middleNode1(ListNode head) { 
        int len=0;
        ListNode temp=head;
        while(head!=null)
        {
        	len++;
        	head=head.next;
        }

        int count=0;
        int mid = len/2+1;
        while(temp!=null)
        {
        	count++;
        	if(count==mid)
        		return temp;
        	temp=temp.next;
        }
        return temp;
    }

    // Optimal Approach (Slow Fast Pointer)
    public ListNode middleNode(ListNode head) { 
    	ListNode slow=head;
    	ListNode fast=head;

    	while(fast!=null && fast.next!=null)
    	{
    		slow=slow.next;
    		fast=fast.next.next;
    	}
    	return slow;
    }
}