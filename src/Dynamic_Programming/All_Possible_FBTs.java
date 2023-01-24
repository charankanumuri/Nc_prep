package Dynamic_Programming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Trees.TreeNode;

/**
 * Given an integer n, return a list of all possible full binary trees with n
 * nodes. Each node of each tree in the answer must have Node.val == 0.
 * 
 * Each element of the answer is the root node of one possible tree. You may
 * return the final list of trees in any order.
 * 
 * A full binary tree is a binary tree where each node has exactly 0 or 2
 * children.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 7
 * Output:
 * [[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]
 * Example 2:
 * 
 * Input: n = 3
 * Output: [[0,0,0]]
 * 
 * 
 * Constraints:
 * 
 * 1 <= n <= 20
 */
public class All_Possible_FBTs {

    public List<TreeNode> allPossibleFBT(int n) {
        // 1 <= n <= 20
        Map<Integer, List<TreeNode>> dp = new HashMap<>();
        List<TreeNode> list = new ArrayList<>();
        list.add(new TreeNode(0));
        dp.put(1, list);
        return memorization(dp, n);
    }

    public List<TreeNode> memorization(Map<Integer, List<TreeNode>> dp, int num) {
        if (dp.containsKey(num))
            return dp.get(num);

        List<TreeNode> res = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            List<TreeNode> leftTree = memorization(dp, i);
            List<TreeNode> rightTree = memorization(dp, num - 1 - i);
            for (TreeNode lTree : leftTree) {
                for (TreeNode rTree : rightTree) {
                    res.add(new TreeNode(0, lTree, rTree));
                }
            }
        }
        dp.put(num, res);
        return res;
    }
}