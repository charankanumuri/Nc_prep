package Stacks;

import java.util.ArrayList;
import java.util.List;

public class Generate_Paranthesis {

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(res, n, n, "");
        return res;
    }

    public static void dfs(List<String> res, int left, int right, String str) {
        if (left > right)
            return;

        if (left == 0 && right == 0) {
            res.add(str);
            return;
        }

        if (left > 0)
            dfs(res, left - 1, right, str + "(");

        if (right > 0)
            dfs(res, left, right - 1, str + ")");

    }

    public static void main(String[] args) {
        List<String> res = generateParenthesis(3);
        System.out.println(res.toString());
    }
}
