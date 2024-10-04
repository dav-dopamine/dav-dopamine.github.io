package trees;

import java.util.ArrayList;
import java.util.List;

public class BalanceBST 
{
	 class Solution 
	    {
	        public TreeNode balanceBST(TreeNode root) 
	        {
	            List<Integer> orderedValues = new ArrayList<>();
	            gatherInOrder(root, orderedValues);
	            return buildBalancedBST(orderedValues, 0, orderedValues.size() - 1);
	        }

	        private void gatherInOrder(TreeNode currentNode, List<Integer> orderedValues) 
	        {
	            if (currentNode == null) 
	            {
	                return;
	            }
	            gatherInOrder(currentNode.left, orderedValues);
	            orderedValues.add(currentNode.val);
	            gatherInOrder(currentNode.right, orderedValues);
	        }

	        private TreeNode buildBalancedBST(List<Integer> elements, int startIndex, int endIndex) 
	        {
	            if (startIndex > endIndex) 
	            {
	                return null;
	            }
	            int midIndex = startIndex + (endIndex - startIndex) / 2;
	            TreeNode newNode = new TreeNode(elements.get(midIndex));
	            newNode.left = buildBalancedBST(elements, startIndex, midIndex - 1);
	            newNode.right = buildBalancedBST(elements, midIndex + 1, endIndex);
	            return newNode;
	        }
	    }

	    class TreeNode 
	    {
	        int val;
	        TreeNode left;
	        TreeNode right;

	        TreeNode() {}

	        TreeNode(int val) 
	        {
	            this.val = val;
	        }

	        TreeNode(int val, TreeNode left, TreeNode right) 
	        {
	            this.val = val;
	            this.left = left;
	            this.right = right;
	        }
	    }
	}

