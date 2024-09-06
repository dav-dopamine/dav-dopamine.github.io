
public class RemoveNthNode 
{
    public ListNode removeNthFromEnd(ListNode startNode, int positionFromEnd) {
        ListNode placeholderHead = new ListNode(0, startNode);
        ListNode currentNode = placeholderHead;

        for (int step = 0; step < positionFromEnd; step++) {
            startNode = startNode.next;
        }

        while (startNode != null) {
            startNode = startNode.next;
            currentNode = currentNode.next;
        }

        currentNode.next = currentNode.next.next;

        return placeholderHead.next;
    }
}
