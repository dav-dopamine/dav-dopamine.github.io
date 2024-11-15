package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class solution1
{
    private int targetNode;
    private boolean[] visited;
    private List<Integer>[] adjList;

    public boolean doesPathExist(int numNodes, int[][] connections, int startNode, int targetNode) 
    {
        this.targetNode = targetNode;
        visited = new boolean[numNodes];
        adjList = new List[numNodes];
        
        Arrays.setAll(adjList, node -> new ArrayList<>());
        
        for (int[] connection : connections) 
        {
            int nodeA = connection[0];
            int nodeB = connection[1];
            adjList[nodeA].add(nodeB);
            adjList[nodeB].add(nodeA);
        }
        
        return depthFirstSearch(startNode);
    }

    private boolean depthFirstSearch(int currentNode) 
    {
        if (currentNode == targetNode) 
        {
            return true;
        }
        
        visited[currentNode] = true;
        
        for (int neighbor : adjList[currentNode]) 
        {
            if (!visited[neighbor] && depthFirstSearch(neighbor)) 
            {
                return true;
            }
        }
        
        return false;
    }
}
