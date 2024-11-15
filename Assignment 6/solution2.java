package main;

import java.util.ArrayList;
import java.util.List;

class solution2
{
    public int findLongestCycle(int[] connections) 
    {
        int nodeCount = connections.length;
        boolean[] visitedNodes = new boolean[nodeCount];
        int longestCycle = -1;
        
        for (int startNode = 0; startNode < nodeCount; startNode++) 
        {
            if (visitedNodes[startNode]) 
            {
                continue;
            }
            
            int currentNode = startNode;
            List<Integer> currentCycle = new ArrayList<>();
            
            while (currentNode != -1 && !visitedNodes[currentNode]) 
            {
                visitedNodes[currentNode] = true;
                currentCycle.add(currentNode);
                currentNode = connections[currentNode];
            }
            
            if (currentNode == -1) 
            {
                continue;
            }
            
            for (int index = 0; index < currentCycle.size(); index++) 
            {
                if (currentCycle.get(index) == currentNode) 
                {
                    longestCycle = Math.max(longestCycle, currentCycle.size() - index);
                    break;
                }
            }
        }
        
        return longestCycle;
    }
}
