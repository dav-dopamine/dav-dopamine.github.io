package main;
import java.util.ArrayDeque;
import java.util.Deque;

public class Solution3 
{
	
	public int shortestPathLength(int[][] graph) 
    {
        int n = graph.length;
        Deque<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][1 << n];

        for (int i = 0; i < n; ++i) 
        {
            queue.offer(new int[] {i, 1 << i});
            visited[i][1 << i] = true;
        }

        for (int ans = 0; ; ++ans) 
        {
            for (int k = queue.size(); k > 0; --k) 
            {
                var p = queue.poll();
                int currentNode = p[0], state = p[1];

                if (state == (1 << n) - 1) 
                {
                    return ans;
                }

                for (int neighbor : graph[currentNode]) 
                {
                    int newState = state | (1 << neighbor);
                    if (!visited[neighbor][newState]) 
                    {
                        visited[neighbor][newState] = true;
                        queue.offer(new int[] {neighbor, newState});
                    }
                }
            }
        }
    }
	
}