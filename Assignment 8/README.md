1. To solve this problem, we treat it like organizing tasks with dependencies, using a graph to represent the courses and their prerequisites. Each course is a node, and each prerequisite is a directed edge showing which course must be completed first. We start by creating an adjacency list to store these relationships and an array to track how many prerequisites each course has (called in-degree). Courses with no prerequisites are added to a queue because they can be taken immediately. From there, we process the queue, adding courses to the result list and updating the in-degree of other courses that depend on them. If a course’s in-degree becomes zero, it’s added to the queue. This continues until all courses are processed or we detect a cycle, meaning it’s impossible to complete all courses. The algorithm is efficient, with a time complexity of O(V+E), where V is the number of courses and E is the number of prerequisites, and a space complexity of O(V+E) for the graph and queue.  
   

Input: numCourses \= 4, prerequisites \= \[\[1, 0\], \[2, 0\], \[3, 1\], \[3, 2\]\]  
Output: \[0, 1, 2, 3\] (or any valid order)  
Expected: \[0, 1, 2, 3\]

Input: numCourses \= 2, prerequisites \= \[\[1, 0\]\]  
Output: \[0, 1\]  
Expected: \[0, 1\]

Input: numCourses \= 2, prerequisites \= \[\[0, 1\], \[1, 0\]\]  
Output: \[\]  
Expected: \[\]

Input: numCourses \= 1, prerequisites \= \[\]  
Output: \[0\]  
Expected: \[0\]

Input: numCourses \= 3, prerequisites \= \[\[1, 0\], \[2, 1\]\]  
Output: \[0, 1, 2\]  
Expected: \[0, 1, 2\]

2. The solution is designed to perform division without using the division or modulo operators. The idea is to repeatedly subtract the divisor from the dividend while doubling the divisor each time to speed up the process. First, special cases are handled, such as dividing by 1 or dividing the minimum integer by \-1, which would cause an overflow. Then, the signs of the inputs are considered to determine the sign of the result. Both the dividend and divisor are converted to negative values to handle edge cases and prevent overflow during shifts. A loop subtracts the largest possible multiple of the divisor from the dividend until it is no longer greater than or equal to the divisor. Finally, the computed quotient is returned with the appropriate sign. The time complexity of this approach is O(log⁡(∣dividend∣), as the divisor is doubled in each step, and the space complexity is O(1) since no extra space is used apart from a few variables.

Input: dividend \= 10, divisor \= 3  
Output: 3  
Expected: 3

Input: dividend \= 7, divisor \= \-3  
Output: \-2  
Expected: \-2

Input: dividend \= 1, divisor \= 1  
Output: 1  
Expected: 1

Input: dividend \= Integer.MIN\_VALUE, divisor \= \-1  
Output: 2147483647  
Expected: 2147483647

Input: dividend \= 0, divisor \= 5  
Output: 0  
Expected: 0

3. The problem is approached using dynamic programming, where we aim to find the minimum number of coins required to achieve a given amount. A 2D array dp is used, where dp\[i\]\[j\] represents the minimum coins needed to make amount j using the first i coins. Initially, we set all values in the array to a very large number (a proxy for infinity) except for dp\[0\]\[0\], which is zero since no coins are needed to make an amount of zero. We iterate through the coins and amounts, updating the array by either including or excluding the current coin. The result is stored in dp\[numCoins\]\[totalAmount\], and if it remains a large value, it means the amount cannot be formed. The time complexity of this solution is O(m×n) where mmm is the number of coin types and n is the target amount. The space complexity is also O(m×n) due to the 2D array.

Input: denominations \= \[1, 2, 5\], totalAmount \= 11  
Output: 3  
Expected: 3

Input: denominations \= \[2\], totalAmount \= 3  
Output: \-1  
Expected: \-1

Input: denominations \= \[1\], totalAmount \= 0  
Output: 0  
Expected: 0

Input: denominations \= \[186, 419, 83, 408\], totalAmount \= 6249  
Output: 20  
Expected: 20

Input: denominations \= \[3, 7\], totalAmount \= 9  
Output: 3  
Expected: 3

4. **Design Facebook, Twitter, or Instagram**  
   

Features and Functionality:  
1\. User Posts and Privacy Controls:  
Users can post tweets or create posts, and they should be able to control who sees them. Like, they can set posts to public, private, or even make them visible to just certain groups of friends or followers. Replies to posts are grouped together, which helps make conversations easier to follow.

2\. News Feed:  
The news feed shows posts from friends or people you follow. It should also suggest trending posts based on what's popular. The feed should feel personal, so posts are ranked by relevance, like how much you interact with someone or the content they share.

3\. Trending Content:  
The app needs to show what’s trending. Like trending hashtags, popular posts, or topics. Users can also check trends filtered by location or categories if they want.

4\. Messaging:  
People should be able to send private messages to each other, like DMs. These messages can include text, photos, or even videos. There should be notifications so users don’t miss any messages.

5\. Mentions and Tagging:  
Users should be able to tag friends in photos or mention them in posts with the @ symbol. Tagged people get notified, and they should have control over what gets tagged on their profile.

6\. Follow/Connections:  
Users can follow others or send friend requests to connect. The app keeps track of followers and follows for everyone. This data should be stored in a way that makes it fast to search or update.

System Analysis:  
Handling billions of users is tough, especially when some users, like celebrities, have millions of followers. The app needs to be super fast and reliable. News feed generation is one of the hardest parts since it needs to combine data from different sources and rank it for each user. We’d need servers distributed across the world to handle so many people at once.

Storage is also tricky. Posts, likes, comments, and user relationships have to be saved in different ways that let us pull them up quickly. For example, graph databases are perfect for managing who follows who, but NoSQL databases work better for likes and comments because they’re faster for some tasks. Everything has to work together smoothly to keep the app running fast, even when tons of people are using it at the same time.

Components:  
News Feed Generator: Handles what posts show up in someone’s feed and ranks them.  
Social Graph Service: Keeps track of relationships, like who follows who, and is optimized to handle millions of connections.  
Trending Service: Figures out what’s trending based on engagement—like shares, comments, and likes.  
Storage Systems: Saves posts, messages, and relationships in databases that are built to handle lots of data.  
When it all comes together, the system can support billions of users sharing posts, messaging friends, and following their favorite celebrities daily.

5. **Design Youtube/Netflix** 

   ### 1\. Uploading and Viewing Videos

Users need to upload and view videos without experiencing huge lags or delays. To do this we need to use a scalable cloud system to store the data. Videos should be encoded in different formats to work on all kinds of devices like phones, TVs, and laptops.

### 2\. Scaling for Large Traffic

When tons of people are watching at the same time the system needs to be able to handle that. We can do this by load balancing, caching, and using a CDN. The CDN stores copies of videos in different parts of the world so that people can watch videos without having to suffer buffering. 

### 3\. Recording Video Stats

To track how well a video is doing we keep stats like the total number of views, upvotes, and downvotes. Every time someone watches a video the system should record that maybe in real time. We can probably do this by using a database like MySQL or Redis to quickly update and show real time stats.

### 4\. Real-Time Comments

People want to comment on videos, and we need that to happen instantly. This can be achieved using WebSockets for real-time data streaming, so comments pop up immediately without needing to refresh. These comments should be stored in the database connected to the specific video so users can easily interact with them.

### 5\. Search Feature

A good search system is essential for users to find videos. Users should be able to search based on keywords, tags, or categories. To do this, we’ll need a good search engine and indexing, like Elasticsearch, which can handle searches quickly even with a lot of users.

### 6\. Monetization & Privacy

For revenue, ads or premium subscriptions could be added, like YouTube does. The system would need to manage ads in the videos and also track how many people interact with them. User privacy and security would be super important, especially for handling payment details and other sensitive info.

