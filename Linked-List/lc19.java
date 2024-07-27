import java.util.*;
class lc19 // Remove Nth Node from End of List
{
	public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
	ListNode findFast(ListNode fast, int n)
	{
		for(int i=1; i<=n; i++)
		{
			fast=fast.next;
			if(fast==null)
				return null;
		}
		return fast;
	}
	public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp=head;
        ListNode fast=head;
        ListNode slow=head;

        for(int i=1; i<=n; i++)
        	fast=fast.next; // Increase fast pointer to n values

        if(fast==null) 
        	return head.next; // If fast pointer reaches null then n=length of LL, so return the second node and delete the first

        while(fast.next!=null) // Move both pointers ahead
        {
        	slow=slow.next; // Slow pointer will be n distance away from the fast pointer
        	fast = fast.next;
        }
        slow.next=slow.next.next; // Delete the required node
        return temp;
    }
}