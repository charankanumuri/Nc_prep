package Stacks;

import java.util.Stack;

public class Valid_Paranthesis {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(char ch: s.toCharArray()) {
            if(ch == '(' || ch == '{' || ch == '[')
                stack.push(ch);
            else {
                if(stack.isEmpty())
                    return false;
                
                if(ch == '}' && stack.pop() != '{'
                    || ch == ')' && stack.pop() != '('
                    || ch == ']' && stack.pop() != '[')
                        return false;

            }
        }
        return stack.isEmpty();
    }
}