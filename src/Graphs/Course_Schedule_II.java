package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Course_Schedule_II {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        int[] indegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < numCourses; i++)
            adj.add(new ArrayList<>());

        for(int[] prereq: prerequisites) {
            adj.get(prereq[1]).add(prereq[0]);
            indegree[prereq[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0)
                queue.add(i);
        }

        int index = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int course = queue.poll();
                res[index++] = course;
                for(Integer neighbor: adj.get(course)) {
                    indegree[neighbor]--;
                    if(indegree[neighbor] == 0)
                        queue.add(neighbor);
                }
            }
        }
        return index == numCourses ? res : new int[0];
        // return index == numCourses ? true : false;   ** Course_Schedule.java

    }
}
