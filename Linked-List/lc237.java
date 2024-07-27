import java.util.*;
class lc237
{
	public void deleteNode(ListNode node) {
        while(node.next!=null)
        {
        	node.val=node.next.val;
        }
        node=null;
    }
}