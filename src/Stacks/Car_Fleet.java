package Stacks;

import java.util.Arrays;
import java.util.Stack;

public class Car_Fleet {

    public int carFleet(int target, int[] position, int[] speed) {
        if (position.length == 1)
            return 1;
        Stack<Double> stack = new Stack<>();
        int[][] pair = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }

        Arrays.sort(pair, (a, b) -> a[0] - b[0]);
        for (int i = pair.length - 1; i >= 0; i--) {
            double currTime = (double) (target - pair[i][0]) / pair[i][1];
            if (!stack.isEmpty() && currTime <= stack.peek())
                continue;
            else
                stack.push(currTime);

        }
        return stack.size();
    }

}
