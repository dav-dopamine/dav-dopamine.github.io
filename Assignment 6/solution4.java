package main;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

class solution4 
{
    public List<List<Integer>> findAllPaths(int[][] adjacencyList) 
    {
        int totalNodes = adjacencyList.length;
        Queue<List<Integer>> pathQueue = new ArrayDeque<>();
        pathQueue.offer(Arrays.asList(0));
        
        List<List<Integer>> completePaths = new ArrayList<>();
        
        while (!pathQueue.isEmpty()) 
        {
            List<Integer> currentPath = pathQueue.poll();
            int currentNode = currentPath.get(currentPath.size() - 1);
            
            if (currentNode == totalNodes - 1) 
            {
                completePaths.add(currentPath);
                continue;
            }
            
            for (int neighbor : adjacencyList[currentNode]) 
            {
                List<Integer> newPath = new ArrayList<>(currentPath);
                newPath.add(neighbor);
                pathQueue.offer(newPath);
            }
        }
        
        return completePaths;
    }
}