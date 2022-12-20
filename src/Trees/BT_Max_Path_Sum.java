package Trees;

public class BT_Max_Path_Sum {

    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        inorderSum(root);
        return res;
    }

    public int inorderSum(TreeNode root) {

        if (root == null)
            return 0;
        int sum = 0;
        int leftSum = Math.max(inorderSum(root.left), 0);
        sum += root.val;
        int rightSum = Math.max(inorderSum(root.right), 0);
        res = Math.max(res, sum + leftSum + rightSum);

        return sum + Math.max(leftSum, rightSum);
    }

}
