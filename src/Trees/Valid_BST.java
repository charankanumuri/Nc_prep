package Trees;

public class Valid_BST {

    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;

        return validBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean validBST(TreeNode root, long left, long right) {
        if (root == null)
            return true;

        if (left >= root.val || root.val >= right)
            return false;

        return validBST(root.left, left, root.val) && validBST(root.right, root.val, right);
    }
}
