package trees;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class BinaryTreePreorderInorder 
{
	public TreeNode buildTree(int[] preorder, int[] inorder) 
    {
        Deque<Integer> traversalQueue = new ArrayDeque<>();
        for (int value : preorder) 
        {
            traversalQueue.offer(value);
        }

        return constructTree(traversalQueue, inorder);
    }

    private TreeNode constructTree(Deque<Integer> traversalQueue, int[] inorderSequence) 
    {
        if (inorderSequence.length > 0) 
        {
            int midIndex = findIndex(inorderSequence, traversalQueue.poll());
            TreeNode rootNode = new TreeNode(inorderSequence[midIndex]);

            rootNode.left = constructTree(traversalQueue, Arrays.copyOfRange(inorderSequence, 0, midIndex));
            rootNode.right = constructTree(traversalQueue, Arrays.copyOfRange(inorderSequence, midIndex + 1, inorderSequence.length));

            return rootNode;
        }
        return null;
    }

    private int findIndex(int[] sequence, int targetValue) 
    {
        for (int i = 0; i < sequence.length; i++) 
        {
            if (sequence[i] == targetValue) 
            {
                return i;
            }
        }
        return -1; 
    }

}
