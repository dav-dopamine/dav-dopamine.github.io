package main;

import javax.swing.tree.TreeNode;

public class Solution2 
{
	private final int inf = 1 << 30;
    private int ans = inf;
    private int pre = -inf;

    public int getMinimumDifference(TreeNode root) 
    {
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode root) 
    {
        if (root == null) 
        {
            return;
        }

        dfs(root.left);
        ans = Math.min(ans, root.val - pre);
        pre = root.val;
        dfs(root.right);
    }
}
