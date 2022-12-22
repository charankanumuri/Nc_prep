package Stacks;

import java.util.Stack;

public class Eval_RPN {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (!("*+-/").contains(token)) {
                Integer num = Integer.valueOf(token);
                stack.push(num);
            } else {
                Integer num2 = stack.pop();
                Integer num1 = stack.pop();
                Integer res = 0;
                switch (token) {
                    case "+":
                        res = num1 + num2;
                        break;
                    case "-":
                        res = num1 - num2;
                        break;
                    case "*":
                        res = num1 * num2;
                        break;
                    case "/":
                        res = num1 / num2;
                        break;
                }
                stack.push(res);
            }
        }
        return stack.pop();
    }

}
