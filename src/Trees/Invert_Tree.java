package Trees;

public class Invert_Tree {
    

    public TreeNode invertTree_1(TreeNode root) {
        if(root == null) return null;
        TreeNode left = invertTree_1(root.left);
        TreeNode right = invertTree_1(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    public TreeNode invertTree_2(TreeNode root) {
        if(root == null) return null;
        TreeNode temp = root.left;
        root.left = invertTree_2(root.right);
        root.right = invertTree_2(temp);
        return root;
    }
}