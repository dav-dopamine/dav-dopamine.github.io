package main;

import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] findOrder(int totalCourses, int[][] prerequisites) {
        List<Integer>[] courseGraph = new List[totalCourses];
        Arrays.setAll(courseGraph, course -> new ArrayList<>());
        int[] inDegrees = new int[totalCourses];

        for (int[] prerequisite : prerequisites) {
            int targetCourse = prerequisite[0], preCourse = prerequisite[1];
            courseGraph[preCourse].add(targetCourse);
            inDegrees[targetCourse]++;
        }

        Deque<Integer> readyCourses = new ArrayDeque<>();
        for (int course = 0; course < totalCourses; course++) {
            if (inDegrees[course] == 0) {
                readyCourses.offer(course);
            }
        }

        int[] courseOrder = new int[totalCourses];
        int completedCourses = 0;

        while (!readyCourses.isEmpty()) {
            int currentCourse = readyCourses.poll();
            courseOrder[completedCourses++] = currentCourse;

            for (int dependentCourse : courseGraph[currentCourse]) {
                if (--inDegrees[dependentCourse] == 0) {
                    readyCourses.offer(dependentCourse);
                }
            }
        }

        return completedCourses == totalCourses ? courseOrder : new int[0];
    }
}