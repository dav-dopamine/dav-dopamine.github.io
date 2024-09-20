**1\) Majority Element**

- The goal of the algorithm is to find the number that appears the most in the array. I create two variables: counter to keep track of how often the current candidate number appears, and pos to hold the current candidate number. Then, I use a for loop to iterate through the array. The first condition checks if the current element matches the candidate. If it does, I increase the counter because that means the candidate appeared again. The next condition checks if the counter is zero, meaning the current candidate doesn’t have enough occurrences to be considered the majority anymore. If that's the case, I update pos to the current element and reset the counter to one, since this is the first instance of the new candidate. The last condition decreases the counter if the current element is different from the candidate, indicating it's not contributing to the majority. After finishing the loop, the value in pos will be the number that appears the most in the array.


**2\) Kth Largest element in an Array**

- The goal is to find the kth largest element in an array. I sort the array, which arranges all the elements in order. This gives me the largest element at the end of the array and the second largest before it. After sorting, I can find the kth largest element by the index nums.length \- k, which gives me the position of the kth largest element in the sorted array.

**3\) Maximum Gap**

- The goal is to find the maximum gap between two elements back to back in an array. Similar to the previous problem I sort the array and then have a variable maxGap to keep track of the largest gap at the moment. Using a for loop to go through the sorted array and comparing the elements to the next and updating maxGap when conditions are met and at the end returning maxGap. 


**4\) Remove duplicate letters**

- The goal is to remove duplicate letters from a string while the result is in the smallest alphabetical order. I count how many times each character appears using an array to keep track. Then I go through the string one character at a time. For each character I reduce its count because I'm processing it. If the character isn't already in the result I check if the last character in the result is bigger and still appears later in the string. If it is I remove that last character to keep everything in order. After that I add the current character to the result and mark it as included. I keep doing this until I’ve looked at all the characters. In the end I have a string that has each letter only once and is in the correct order which I return as the final answer.

**5\) Shortest Subarray with Sum at Least K**

- The goal is to find the length of the shortest subarray in an array that has the sum of at least k. I create an array called prefix sums to store all of the sums of the elements from the initial array so that I can calculate the sum of any subarray when needed. Using two nested loop the outer one picks the starting index of the subarray and the inner one checks possible endings that may follow the start index. If the sum is equal to or greater than k, I compare it to the lengths of the previous subarrays I've found. I check all of the subarrays and return the shortest one.