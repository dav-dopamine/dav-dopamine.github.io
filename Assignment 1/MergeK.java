
public class MergeK 
{
	 public ListNode mergeKLists(ListNode[] listArray) {
	        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((node1, node2) -> node1.val - node2.val);

	        for (ListNode listHead : listArray) {
	            if (listHead != null) {
	                minHeap.offer(listHead);
	            }
	        }

	        ListNode mergedHead = new ListNode();
	        ListNode currentNode = mergedHead;

	        while (!minHeap.isEmpty()) {
	            ListNode smallestNode = minHeap.poll();
	            if (smallestNode.next != null) {
	                minHeap.offer(smallestNode.next);
	            }
	            currentNode.next = smallestNode;
	            currentNode = currentNode.next;
	        }

	        return mergedHead.next;
	    }
}
