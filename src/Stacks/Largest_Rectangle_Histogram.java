package Stacks;

import java.util.Stack;

public class Largest_Rectangle_Histogram {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                int currHeight = heights[stack.pop()];
                int currWidth = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, currHeight * currWidth);
            }
            stack.push(i);
        }

        while (stack.peek() != -1) {
            int currHeight = heights[stack.pop()];
            int currWidth = heights.length - stack.peek() - 1;
            maxArea = Math.max(maxArea, currHeight * currWidth);
        }
        return maxArea;
    }
}
