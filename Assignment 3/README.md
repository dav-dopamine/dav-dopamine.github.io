1) **Convert Sorted List to Binary Search Tree:** The goal is to convert a sorted singly linked list into a binary search tree. With a recursive route we recursively pick the middle elements of the list root node, and the middle elements will ensure that both left and right subtrees are balanced beforehand, once the middle is chosen the other parts of the subtree will be formed. So first we check if the list contains one node or is empty, handling base cases and returning the correct output. The middle node becomes the root and the left and right parts of the list are recursively formed into the right and left subtrees, we repeat this process until the tree is finished. Time complexity of this is O(n log n) finding the middle element is O(n) since we go through the list to find the middle and the recursion portion is O(log n) since the list splits in half repeatedly.   
     
   Test Case 1:  
   Input: head \= \[-5, \-2, 1, 4, 7\]  
   Expected Output: \[1, \-2, 7, \-5, null, 4\]  
     
   Test Case 2:  
   Input: head \= \[3\]  
   Expected Output: \[3\]  
     
   Test Case 3:  
   Input: head \= \[\]  
   Expected Output: \[\]  
     
   Test Case 4:  
   Input: head \= \[1, 2\]  
   Expected Output: \[1, null, 2\]  
     
   Test Case 5:  
   Input: head \= \[1, 2, 3\]  
   Expected Output: \[2, 1, 3\]  
     
2) **Construct Binary Tree from Preorder and Inorder Traversal:** The goal is to build a binary tree using two arrays one for the preorder and another for the inorder traversal. A recursive approach is used to find the root nodes and create the tree. We then set up a queue to hold the preorder values to access the next root node. We check if the inorder array is empty; if it is then we have no more nodes. If it’s not empty we take the first value from the preorder queue to use as the root node, we then get the value's position in the inorder array. With this it helps us figure out what parts of the array are to the left and right subtrees. We keep doing this until all the nodes are added to the tree. The time complexity is O(n²) since we have to search for each root node's index in the inorder array.  
     
   Test Case 1:  
   Input: preorder \= \[3, 9, 20, 15, 7\], inorder \= \[9, 3, 15, 20, 7\]  
   Output: \[3, 9, 20, null, null, 15, 7\]  
     
   Test Case 2:  
   Input: preorder \= \[-1\], inorder \= \[-1\]  
   Output: \[-1\]  
     
   Test Case 3:  
   Input: preorder \= \[1, 2, 4, 5, 3\], inorder \= \[4, 2, 5, 1, 3\]  
   Output: \[1, 2, 3, 4, 5\]  
     
   Test Case 4:  
   Input: preorder \= \[10, 5, 1, 7, 40, 50\], inorder \= \[1, 5, 7, 10, 40, 50\]  
   Output: \[10, 5, 40, 1, 7, null, 50\]  
     
   Test Case 5:  
   Input: preorder \= \[2, 1\], inorder \= \[1, 2\]  
   Output: \[2, 1\]  
     
3) **Binary Tree Maximum Path Sum:** The goal of this code is to find the maximum path sum in a binary tree. We create a method maxPathSum that initializes the maximum path sum to a small number. With a helper method called calculateMaxPathValue that is recursively. This method checks if the current node is null returning 0 if so. At each node, the maximum path sums from both the left and right child nodes. Then we update the maximum path value by looking at the current node and the left and right paths combined.The method returns the maximum path value starting from that node. We do this until all nodes are checked considering all paths. The time complexity is O(n)  n is the number of nodes in the tree since we visit each node once during the recursion of it.   
     
   Test Case 1:  
   Input: root \= \[1,2,3\]  
   Output: 6  
   Expected Output: 6  
     
     
   Test Case 2:  
   Input: root \= \[-10,9,20,null,null,15,7\]  
   Output: 42  
   Expected Output: 42  
     
   Test Case 3:  
   Input: root \= \[2,-1,-2,-3,-4\]  
   Output: 2  
   Expected Output: 2  
     
   Test Case 4:  
   Input: root \= \[5,4,8,11,null,13,4,7,2,null,null,null,1\]  
   Output: 48  
   Expected Output: 48  
     
   Test Case 5:  
   Input: root \= \[-1,-2,-3\]  
   Output: \-1  
   Expected Output: \-1

4) **Find largest value in each Tree row:** The goal of this code is to find the largest value in each row of a binary tree. We have a method that  uses a breadth-first search approach. First we check if the root node is null and return an empty list if it is. Using a queue to help keep track of the nodes as we go through each level of the tree, initializing a variable to store the maximum value found so far. looping through all nodes at the current level and updating the maximum value when valid. If a node has left or right we add them to the queue for the next level. When done checking all nodes in the current level, we add the maximum value to the list of results.Than return the list of largest values from each row. Time complexity is O(n) n is the number of nodes in the tree visited once. 

	  
	Test Case 1:  
Input: root \= \[1,3,2,5,3,null,9\]  
Output: \[1,3,9\]

Test Case 2:  
Input: root \= \[1,2,3\]  
Output: \[1,3\]

Test Case 3:  
Input: root \= \[1\]  
Output: \[1\]

Test Case 4:  
Input: root \= \[5,1,4,null,2,null,3\]  
Output: \[5,4\]

Test Case 5:  
Input: root \= \[0,-1,-2,-3,-4\]  
Output: \[0,-1,-2\]

5) **Balance a Binary Search Tree:** The goal of the code is to convert an unbalanced binary search tree into a balanced one. We begin with  the balanceBST method, which will take the root of the tree as input and do an in-order traversal of the tree that will collect the values in a sorted order given by the  gatherInOrder method. It will go through each node adding the value to a list. Using the buildBalancedBST method, it recursively selects the middle value from the sorted list to that will go to create the root of the new tree and builds the left and right subtrees using the values to the left and right of the middle values. The overall time complexity of this approach is O(n), n is the number of nodes in the original tree. we visit each node once in the in-order traversal and again when creating the balanced tree. 

	Test Case 1:  
Input: root \= \[1, 2, 3, 4, 5, 6, 7\]  
Expected Output: \[4, 2, 6, 1, 3, 5, 7\]

Test Case 2:  
Input: root \= \[3, 1, 4, null, 2\]  
Expected Output: \[2, 1, 3, 4\]

Test Case 3:  
Input: root \= \[5, 3, 8, 1, 4, 7, 9\]  
Expected Output: \[5, 3, 7, 1, 4, 8, 9\]

Test Case 4:  
Input: root \= \[1\]  
Expected Output: \[1\]

Test Case 5:  
Input: root \= \[\]  
Expected Output: \[\]