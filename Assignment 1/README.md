## **1\. TwoSum**

### **Problem Statement**

Find two numbers in the given array that add up to the target sum and return their indices.

### **Algorithm Explanation**

* The solution uses two nested loops to iterate over all possible pairs of elements in the array.  
* For each pair, it checks if their sum equals the target value. If a match is found, it returns the indices of these two elements.

### **Complexity Analysis**

* **Time Complexity**: O(n²) because of the nested loops iterating over the array twice.  
* **Space Complexity**: O(1) since no additional space proportional to the input size is used.

---

## **2\. FindFirstAndLast**

### **Problem Statement**

Find the first and last occurrence of a target value in a sorted array. If the target is not found, return `[-1, -1]`.

### **Algorithm Explanation**

* A binary search is used twice: first to find the position of the target value and second to find the position of the next larger element (target \+ 1).  
* The difference between the indices determines the range where the target exists.

### **Complexity Analysis**

* **Time Complexity**: O(log n) due to the binary search operations.  
* **Space Complexity**: O(1) as it only uses a few variables.

---

## **3\. MedianFinder**

### **Problem Statement**

Find the median of two sorted arrays.

### **Algorithm Explanation**

* The two input arrays are merged into a single array and then sorted.  
* The median is determined based on whether the total length is odd or even:  
  * If odd, the middle element is the median.  
  * If even, the average of the two middle elements is the median.

### **Complexity Analysis**

* **Time Complexity**: O((n \+ m) log (n \+ m)) due to the sorting step after merging.  
* **Space Complexity**: O(n \+ m) because a new array is created to hold the merged elements.

---

**4\. RemoveNthNode**

### **Problem Statement**

Remove the nth node from the end of a linked list.

### **Algorithm Explanation**

* A dummy node is used to handle edge cases (e.g., removing the head node).  
* Two pointers traverse the list; the first pointer moves `n` steps ahead of the second.  
* Both pointers move together until the first pointer reaches the end, positioning the second pointer just before the node to be removed.  
* The target node is then bypassed, effectively removing it from the list.

### **Complexity Analysis**

* **Time Complexity**: O(L), where L is the length of the linked list, as the list is traversed only once.  
* **Space Complexity**: O(1) because only pointers are used without additional data structures.

---

## **4\. MergeKLists**

### **Problem Statement**

Merge k sorted linked lists into a single sorted linked list.

### **Algorithm Explanation**

* A min-heap (priority queue) is used to keep track of the smallest node among the heads of the k lists.  
* Nodes are extracted from the heap one by one and added to the merged list, maintaining the sorted order.  
* If a node has a next node, it is added to the heap.

### **Complexity Analysis**

* **Time Complexity**: O(N log k), where N is the total number of nodes and k is the number of lists. This is because each node is inserted into and extracted from the heap.  
* **Space Complexity**: O(k) due to the heap storing up to k nodes at a time.

