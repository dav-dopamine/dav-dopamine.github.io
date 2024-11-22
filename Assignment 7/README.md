1. The goal is to figure out if we can complete all the given courses which we have done by  checking if there’s a cycle in the graph. If there’s a cycle than some courses depend on each other in a loop so we could finish them. We will use a topological sort approach with a queue to solve this issue. We build a graph using an adjacency list and count how many prerequisites each course has. Then we add all courses with no prerequisites to a queue and start processing them. For each course we process, we reduce the in-degree of its dependent courses. If a dependent course ends up with an in-degree of 0, we add it to the queue. In the end, if we’ve processed all the courses, it means there’s no cycle, so we can return true. If we can’t process all the courses, there’s a cycle, and we return false. This method runs in O(V+E) time, where V is the number of courses and Eis the number of prerequisites since we visit each course and edge once. The space complexity is also O(V+E) because of the graph representation and the queue. This approach is simple and works well for this problem.

Test Case 1:  
Input: numCourses \= 2, prerequisites \= \[\[1, 0\]\]  
Output: true

Test Case 2:  
Input: numCourses \= 2, prerequisites \= \[\[1, 0\], \[0, 1\]\]  
Output: false

Test Case 3:  
Input: numCourses \= 4, prerequisites \= \[\[1, 0\], \[2, 0\], \[3, 1\], \[3, 2\]\]  
Output: true

Test Case 4:  
Input: numCourses \= 1, prerequisites \= \[\]  
Output: true

Test Case 5:  
Input: numCourses \= 3, prerequisites \= \[\[0, 1\], \[1, 2\], \[2, 0\]\]  
Output: false

2. We are using Dijkstra's algorithm to find the shortest path in the graph. We begin by sending a signal from a specific node to see how long it takes for the signal to reach all the nodes in the network. This works by starting at the given node and updating the shortest travel times to all other nodes. At the start of it all the distances are set to infinity except for the starting node we are using is set to 0\. Moving through  the algorithm will pick the node with the smallest current distance process it and updates the travel times until all nodes are visited. we return \-1 for any nodes not reached and we return the maximum time it took for the signal to reach the a node. The time complexity of this solution is O((V \+ E) log V)  where V is the number of nodes and E is the number of edges. The space complexity is O(V \+ E) because we need to store the graph’s details on distance and such. 

Test Case 1:  
Input: times \= \[\[1,2,1\]\], n \= 2, k \= 1  
Expected Output: 1

Test Case 2:  
Input: times \= \[\[1,2,1\]\], n \= 2, k \= 2  
Expected Output: \-1

Test Case 3:  
Input: times \= \[\[2,1,1\],\[2,3,1\],\[3,4,1\]\], n \= 4, k \= 2  
Expected Output: 2

Test Case 4:  
Input: times \= \[\[1,2,1\],\[2,3,2\],\[3,4,1\],\[1,3,4\]\], n \= 4, k \= 1  
Expected Output: 4

Test Case 5:  
Input: times \= \[\[1,2,1\],\[2,3,2\],\[3,4,1\]\], n \= 5, k \= 1  
Expected Output: \-1

3. The given problem is modeled as a graph where each house is a node and the pipes and wells are edges that have a cost to them. In this approach we are using a Union Find data structure that will group the houses and avoid cycles. Create a list of edges and combine both the pipes and well costs.The edges are sorted ascending order. The Union Find data connects the nodes (houses) and this approach also ensures we are always adding the cheapest edge (pipe or well). We continue until everything is connected and the final cost is returned. The time complexity is O(E log E) where E is the number of edges. The space complexity is O(V \+ E) where V is the number of nodes (houses) and E is the number of edges (pipes and wells).

   

Test Case 1:  
Input: totalHouses \= 2, wellCosts \= \[1, 2\], pipeCosts \= \[\[1, 2, 1\]\]  
Output: 3

Test Case 2:  
Input: totalHouses \= 3, wellCosts \= \[1, 2, 3\], pipeCosts \= \[\[1, 2, 1\], \[2, 3, 1\]\]  
Output: 3

Test Case 3:  
Input: totalHouses \= 3, wellCosts \= \[3, 3, 3\], pipeCosts \= \[\[1, 2, 2\], \[2, 3, 2\]\]  
Output: 6

Test Case 4:  
Input: totalHouses \= 4, wellCosts \= \[1, 1, 1, 1\], pipeCosts \= \[\[1, 2, 2\], \[2, 3, 2\], \[3, 4, 2\]\]  
Output: 6

Test Case 5:  
Input: totalHouses \= 4, wellCosts \= \[2, 2, 2, 2\], pipeCosts \= \[\[1, 2, 2\], \[2, 3, 2\], \[3, 4, 2\], \[1, 3, 1\]\]  
Output: 6

**Design Uber**

**Available Cabs with Price and ETA:**  
Users should be able to see a list of nearby available cabs, along with the minimum price and estimated time of arrival (ETA) for each cab.

* Drivers will have their location services available   
* User requests a ride and the system will check for nearby drivers and display pricing and ETA.   
* Store the driver’s locations in a list and when a ride is requested the list will be searched for the nearest drivers available.  
* Return the list of valid drivers displaying their price and ETA

**Ride Booking:**  
Users should be able to book a cab for their destination by providing pick-up and drop-off locations.

* When a driver is picked by a rider the system will update the driver’s availability and display confirmation to the rider  
* Both rider and driver will be notified of the updates


**Driver Location Tracking:**  
Users should be able to track the live location of the assigned driver on a map as the driver approaches the pick-up location.

* Driver’s app will send regular updates on location   
* Rider’s will be able to view it through a map scheme with updates of location


**Ride Cancellation:**  
Users should be able to cancel their ride at any time before or after booking, with a clear cancellation policy and any applicable fees.

* System should be able to check if the ride has already started and if so charge cancellation fee and if not no cancellation fee


**Ride History and Receipts:**  
Users should be able to view their past rides, including the trip details (e.g., route, fare, driver), and download receipts for completed rides.

* Store the history of rides in a list including basic details like price, driver, distance of ride, etc…  
* System stores the information 

**Scalability:**

* Distribute the load of users based on their geographical locations so that everything is responsive.  
* We should have multiple servers to distribute the load of incoming requests so that the system does not fail during peak hours  
* Cache the data as much as possible so the database isnt overloaded. 

**Fault Tolerance:**

* Have an active/passive replication to enhance the systems performance and stay efficient in case of failure  
* Have a mechanism for services like payments to make sure we have consistency with the vital services. 

**Latency:** 

* Have a server that will handle requests from users based on close locations so the latency is low  
* Handle real time operations   
* Databases with efficient queries so access is fast and efficient so delays dont occur. 

