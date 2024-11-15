1. In this approach I wanted to figure out if there's a path between two nodes in an undirected graph using depth-first search. I set up an adjacency list for every node so I could keep track of its neighbors and then I used a recursive DFS function to explore the connections starting from the source node. While running the DFS if I hit the target node I know that a path exists. This method works well because it recursively checks each neighboring node and marks nodes as visited to avoid going in circles. The time complexity here is O(V+E) where V is the number of nodes and E is the number of edges since I visit every node and edge once. The space complexity is O(V) because of the visited nodes and the adjacency list.

Test Case 1:  
Input: numNodes \= 3, connections \= \[\[0, 1\], \[1, 2\], \[2, 0\]\], startNode \= 0, targetNode \= 2  
Output: true  
Expected: true

Test Case 2:  
Input: numNodes \= 4, connections \= \[\[0, 1\], \[1, 2\], \[2, 3\]\], startNode \= 0, targetNode \= 3  
Output: true  
Expected: true

Test Case 3:  
Input: numNodes \= 4, connections \= \[\[0, 1\], \[2, 3\]\], startNode \= 0, targetNode \= 3  
Output: false  
Expected: false

Test Case 4:  
Input: numNodes \= 5, connections \= \[\[0, 1\], \[1, 2\], \[2, 3\], \[3, 4\]\], startNode \= 0, targetNode \= 4  
Output: true  
Expected: true

Test Case 5:  
Input: numNodes \= 6, connections \= \[\[0, 1\], \[0, 2\], \[2, 3\], \[3, 4\], \[4, 5\]\], startNode \= 1, targetNode \= 5  
Output: true  
Expected: true

2. The goal here is to find the longest cycle in a directed graph where each index in an array points to the next node. I begin at each unvisited node and follow the path by going through each connection marking the nodes as visited along the way to avoid revisiting them. As I trace the path if I find that a node points back to a previously visited one I know there's a cycle. I calculate the length of the cycle and keep track of the longest one I find. The time complexity of this approach is O(V+E) since I process each node and connection once. The space complexity is O(V) because I need extra storage for the visited nodes and the cycles.  
   

Test Case 1:  
Input: connections \= \[3, 3, 4, 2, 3\]  
Output: 3  
Expected: 3

Test Case 2:  
Input: connections \= \[2, \-1, 3, 1\]  
Output: \-1  
Expected: \-1

Test Case 3:  
Input: connections \= \[1, 2, 0, 4, 5, 3\]  
Output: 3  
Expected: 3

Test Case 4:  
Input: connections \= \[-1, \-1, \-1\]  
Output: \-1  
Expected: \-1

Test Case 5:  
Input: connections \= \[1, 2, 3, 4, 5, 0\]  
Output: 6  
Expected: 6

3. The purpose here is to find the minimum cost to connect all nodes in a weighted graph which is a classic minimum spanning tree problem. First I sort the edges by their weight so I can start with the cheaper connections. Then I use Union-Find to detect and merge connected components as I go through each edge ensuring that no cycles are formed. If two nodes aren't connected already I add the edge’s cost to the total and merge their components. I stop once all the nodes are connected or if it's not possible to connect them all. The time complexity of this approach is O(Elog⁡E) because of sorting the edges where E is the number of edges. The space complexity is O(N) because I store parent references where N is the number of nodes.  
   

Test Case 1:  
Input: totalNodes \= 3, edges \= \[\[1, 2, 5\], \[1, 3, 6\], \[2, 3, 1\]\]  
Output: 6  
Expected: 6

Test Case 2:  
Input: totalNodes \= 4, edges \= \[\[1, 2, 3\], \[3, 4, 4\], \[2, 3, 5\], \[1, 4, 7\]\]  
Output: 12  
Expected: 12

Test Case 3:  
Input: totalNodes \= 4, edges \= \[\[1, 2, 1\], \[2, 3, 2\], \[3, 4, 3\], \[4, 1, 4\]\]  
Output: 6  
Expected: 6

Test Case 4:  
Input: totalNodes \= 4, edges \= \[\[1, 2, 1\], \[2, 3, 2\]\]  
Output: \-1  
Expected: \-1

Test Case 5:  
Input: totalNodes \= 5, edges \= \[\[1, 2, 2\], \[1, 3, 3\], \[2, 4, 4\], \[3, 5, 5\], \[4, 5, 1\]\]  
Output: 10  
Expected: 10

4. In this approach I use breadth-first search to find all the paths from the starting node to the target node in a directed acyclic graph. Starting from node 0 I use a queue to keep track of each path as a list of nodes and explore each node’s neighbors. Every time I hit the last node I know that the path is complete and I save it. I continue this until I’ve explored all possible paths. The time complexity here is O(2N×N) where N is the number of nodes because of the number of possible paths. The space complexity is O(2N×N) as well since all the paths are stored in memory.  
   

Test Case 1:  
Input: adjacencyList \= \[\[1, 2\], \[3\], \[3\], \[\]\]  
Output: \[\[0, 1, 3\], \[0, 2, 3\]\]  
Expected: \[\[0, 1, 3\], \[0, 2, 3\]\]

Test Case 2:  
Input: adjacencyList \= \[\[4, 3, 1\], \[3, 2\], \[3\], \[4\], \[\]\]  
Output: \[\[0, 1, 2, 3, 4\], \[0, 1, 3, 4\], \[0, 3, 4\], \[0, 4\]\]  
Expected: \[\[0, 1, 2, 3, 4\], \[0, 1, 3, 4\], \[0, 3, 4\], \[0, 4\]\]

Test Case 3:  
Input: adjacencyList \= \[\[1\], \[2\], \[3\], \[\]\]  
Output: \[\[0, 1, 2, 3\]\]  
Expected: \[\[0, 1, 2, 3\]\]

Test Case 4:  
Input: adjacencyList \= \[\[1, 2\], \[3\], \[\], \[\]\]  
Output: \[\[0, 1, 3\], \[0, 2\]\]  
Expected: \[\[0, 1, 3\], \[0, 2\]\]

Test Case 5:  
Input: adjacencyList \= \[\[1, 2, 3\], \[4\], \[4\], \[\], \[\]\]  
Output: \[\[0, 1, 4\], \[0, 2, 4\], \[0, 3\]\]  
Expected: \[\[0, 1, 4\], \[0, 2, 4\], \[0, 3\]\]

5. The goal here is to calculate the power of a number in a more efficient way using exponentiation by squaring. Instead of multiplying the base repeatedly for every step I use the binary representation of the exponent to minimize the number of multiplications. If the exponent is odd I multiply the result by the base and then square the base for the next iteration. This approach allows me to calculate the power in O(log⁡n) time which is much faster than the O(n) approach. The time complexity is O(log⁡n) where n is the exponent and the space complexity is O(1) because I only need a few variables for intermediate results.  
   

Test Case 1:  
Input: base \= 2, exponent \= 3  
Output: 8.0  
Expected: 8.0

Test Case 2:  
Input: base \= 2, exponent \= \-2  
Output: 0.25  
Expected: 0.25

Test Case 3:  
Input: base \= 3, exponent \= 0  
Output: 1.0  
Expected: 1.0

Test Case 4:  
Input: base \= 2, exponent \= 10  
Output: 1024.0  
Expected: 1024.0

Test Case 5:  
Input: base \= 5, exponent \= \-3  
Output: 0.008  
Expected: 0.008

