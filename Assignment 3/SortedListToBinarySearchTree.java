
public class SortedListToBinarySearchTree 
{
	public TreeNode sortedListToBST(ListNode head) 
	{
        if (head == null) 
        {
            return null;
        }

        if (head.next == null) 
        {
            return new TreeNode(head.val);
        }

        ListNode mid = getMid(head);
        TreeNode root = new TreeNode(mid.val);

        root.left = sortedListToBST(head);
        root.right = sortedListToBST(mid.next);

        return root;
    }

    private ListNode getMid(ListNode node) 
    {
        ListNode prev = null;
        ListNode slow = node;
        ListNode fast = node;

        while (fast != null && fast.next != null) 
        {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if (prev != null) {
            prev.next = null;
        }

        return slow;
    }
}

class ListNode 
{
    int val;
    ListNode next;

    ListNode(int val) 
    {
        this.val = val;
        this.next = null;
    }
}

class TreeNode 
{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) 
    {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
