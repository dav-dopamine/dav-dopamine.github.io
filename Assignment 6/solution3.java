package main;

import java.util.Arrays;
import java.util.Comparator;

class solution3 
{
    private int[] parent;

    public int calculateMinimumCost(int totalNodes, int[][] edges) 
    {
        Arrays.sort(edges, Comparator.comparingInt(edge -> edge[2]));
        parent = new int[totalNodes];
        
        for (int i = 0; i < totalNodes; i++) 
        {
            parent[i] = i;
        }
        
        int minimumCost = 0;
        
        for (int[] edge : edges) 
        {
            int nodeA = edge[0] - 1;
            int nodeB = edge[1] - 1;
            int weight = edge[2];
            
            if (findParent(nodeA) == findParent(nodeB)) 
            {
                continue;
            }
            
            parent[findParent(nodeA)] = findParent(nodeB);
            minimumCost += weight;
            
            if (--totalNodes == 1) 
            {
                return minimumCost;
            }
        }
        
        return -1;
    }

    private int findParent(int node) 
    {
        if (parent[node] != node) 
        {
            parent[node] = findParent(parent[node]);
        }
        return parent[node];
    }
}
