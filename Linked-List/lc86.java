import java.util.*;
class lc86  // Partition List
{
	public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
	public ListNode partition(ListNode head, int x) {
		// pointer to the first node of the first half
        ListNode beforeHead = new ListNode(0);
        ListNode before = beforeHead;

        // pointer to the first node of the second half
        ListNode afterHead = new ListNode(0);
        ListNode after = afterHead;

        while(head!=null)
        {
        	// if value is less than x add node to first half
        	if(head.val<x)
        	{
        		before.next = head;
        		before = before.next;
        	}
        	// if value>=x add node to the second half
        	else {
        		after.next = head;
        		after = after.next;
        	}
        	head = head.next;
        }

        after.next = null;

        // merge both the first half and second half
        before.next = afterHead.next;

        // return the pointer to the head of the first half
        return beforeHead.next;
    }
}