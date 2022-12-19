package Trees;
// Given a binary tree, determine if it is
// A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.
public class Balanced_BT {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;

        int left = height(root.left);
        int right = height(root.right);

        if (Math.abs(left - right) > 1)
            return false;

        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int height(TreeNode root) {
        if (root == null)
            return 0;

        int left = height(root.left);
        int right = height(root.right);

        return Math.max(left, right) + 1;
    }
}
