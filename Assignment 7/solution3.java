package main;
import java.util.*;

class solution3 {
    private int[] parent;

    public int minCostToSupplyWater(int totalHouses, int[] wellCosts, int[][] pipeCosts) {
        int[][] edges = Arrays.copyOf(pipeCosts, pipeCosts.length + totalHouses);
        
        for (int i = 0; i < totalHouses; i++) {
            edges[pipeCosts.length + i] = new int[] {0, i + 1, wellCosts[i]};
        }
        
        Arrays.sort(edges, (edge1, edge2) -> edge1[2] - edge2[2]);
        
        parent = new int[totalHouses + 1];
        for (int i = 0; i <= totalHouses; i++) {
            parent[i] = i;
        }
        
        int totalCost = 0;
        for (var edge : edges) {
            int house1 = edge[0], house2 = edge[1], cost = edge[2];
            int root1 = findRoot(house1), root2 = findRoot(house2);
            
            if (root1 != root2) {
                parent[root1] = root2;
                totalCost += cost;
                
                if (--totalHouses == 0) {
                    return totalCost;
                }
            }
        }
        
        return totalCost;
    }

    private int findRoot(int house) {
        if (parent[house] != house) {
            parent[house] = findRoot(parent[house]);
        }
        return parent[house];
    }
}
