package main;

import java.util.*;


class solution1 {

    public boolean canFinishCourses(int totalCourses, int[][] prerequisites) {
        List<Integer>[] graph = new List[totalCourses];
        Arrays.setAll(graph, course -> new ArrayList<>());

        int[] inDegree = new int[totalCourses];

        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int dependency = prerequisite[1];
            graph[dependency].add(course);
            inDegree[course]++;
        }

        Deque<Integer> queue = new ArrayDeque<>();
        for (int course = 0; course < totalCourses; course++) {
            if (inDegree[course] == 0) {
                queue.offer(course);
            }
        }

        int processedCourses = 0;

        while (!queue.isEmpty()) {
            int currentCourse = queue.poll();
            processedCourses++;

            for (int neighbor : graph[currentCourse]) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return processedCourses == totalCourses;
    }

    public static void main(String[] args) {
    	solution1 solution = new solution1();

        // Test cases
        System.out.println("Test case 1: " + solution.canFinishCourses(2, new int[][]{{1, 0}})); // Expected: true
        System.out.println("Test case 2: " + solution.canFinishCourses(2, new int[][]{{1, 0}, {0, 1}})); // Expected: false
        System.out.println("Test case 3: " + solution.canFinishCourses(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}})); // Expected: true
        System.out.println("Test case 4: " + solution.canFinishCourses(1, new int[][]{})); // Expected: true
        System.out.println("Test case 5: " + solution.canFinishCourses(3, new int[][]{{0, 1}, {1, 2}, {2, 0}})); // Expected: false
    }
}
