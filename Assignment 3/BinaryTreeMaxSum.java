package trees;
import java.util.ArrayList;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.List;

public class BinaryTreeMaxSum 
{
	class Solution {
	    private int maxSum = Integer.MIN_VALUE;

	    public int maxPathSum(TreeNode root) {
	        if (root == null) return 0;
	        calculateMaxPathSum(root);
	        return maxSum;
	    }

	    private int calculateMaxPathSum(TreeNode node) {
	        if (node == null) return 0;
	        
	        // Calculate left and right path sums
	        int leftSum = calculateMaxPathSum(node.left);
	        int rightSum = calculateMaxPathSum(node.right);
	        
	        // Update maximum sum considering the current node
	        maxSum = Math.max(maxSum, leftSum + rightSum + node.val);
	        
	        // Return the maximum path sum "starting" from this node
	        return Math.max(leftSum, rightSum) + node.val;
	    }
	}
}
