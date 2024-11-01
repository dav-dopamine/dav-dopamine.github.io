package main;

import javax.swing.tree.TreeNode;

class Solution4
{
    private int maxPathValue = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) 
    {
        calculateMaxPath(root);
        return maxPathValue;
    }

    private int calculateMaxPath(TreeNode currentNode) 
    {
        if (currentNode == null) 
        {
            return 0;
        }

        int leftMax = Math.max(0, calculateMaxPath(currentNode.left));
        int rightMax = Math.max(0, calculateMaxPath(currentNode.right));
        
        maxPathValue = Math.max(maxPathValue, currentNode.val + leftMax + rightMax);
        
        return currentNode.val + Math.max(leftMax, rightMax);
    }
}
