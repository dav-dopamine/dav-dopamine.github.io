package main;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution1 
{
	private String s;
    private int n;
    private Set<String> ans = new HashSet<>();

    public List<String> removeInvalidParentheses(String s) 
    {
        this.s = s;
        this.n = s.length();
        int leftCount = 0, rightCount = 0;

        for (char c : s.toCharArray()) 
        {
            if (c == '(') 
            {
                ++leftCount;
            } 
            else if (c == ')') 
            {
                if (leftCount > 0) 
                {
                    --leftCount;
                } 
                else 
                {
                    ++rightCount;
                }
            }
        }

        dfs(0, leftCount, rightCount, 0, 0, "");
        return new ArrayList<>(ans);
    }

    private void dfs(int index, int leftCount, int rightCount, int leftUsed, int rightUsed, String temp) 
    {
        if (index == n) 
        {
            if (leftCount == 0 && rightCount == 0) 
            {
                ans.add(temp);
            }
            return;
        }

        if (n - index < leftCount + rightCount || leftUsed < rightUsed) 
        {
            return;
        }

        char c = s.charAt(index);

        if (c == '(' && leftCount > 0) 
        {
            dfs(index + 1, leftCount - 1, rightCount, leftUsed, rightUsed, temp);
        }

        if (c == ')' && rightCount > 0) 
        {
            dfs(index + 1, leftCount, rightCount - 1, leftUsed, rightUsed, temp);
        }

        int incrementLeft = (c == '(') ? 1 : 0;
        int incrementRight = (c == ')') ? 1 : 0;
        dfs(index + 1, leftCount, rightCount, leftUsed + incrementLeft, rightUsed + incrementRight, temp + c);
    }
}
