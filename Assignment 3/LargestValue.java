package trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LargestValue 
{
	class Solution 
    {
        public List<Integer> findLargestValues(TreeNode rootNode) 
        {
            List<Integer> largestValues = new ArrayList<>();
            if (rootNode == null) 
            {
                return largestValues;
            }
            Deque<TreeNode> nodeQueue = new ArrayDeque<>();
            nodeQueue.offer(rootNode);
            while (!nodeQueue.isEmpty()) 
            {
                int maxVal = nodeQueue.peek().val;
                for (int i = nodeQueue.size(); i > 0; --i) 
                {
                    TreeNode currentNode = nodeQueue.poll();
                    maxVal = Math.max(maxVal, currentNode.val);
                    if (currentNode.left != null) 
                    {
                        nodeQueue.offer(currentNode.left);
                    }
                    if (currentNode.right != null) 
                    {
                        nodeQueue.offer(currentNode.right);
                    }
                }
                largestValues.add(maxVal);
            }
            return largestValues;
        }
    }

}
