package Trees;

public class Diameter_of_BT {

    int diameter;

    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        height(root);
        return diameter;
    }

    public int height(TreeNode root) {
        if (root == null)
            return 0;

        int left = height(root.left);
        int right = height(root.right);

        diameter = Math.max(diameter, left + right);

        return Math.max(left, right) + 1;
    }

}
