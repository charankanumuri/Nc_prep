package Trees;

import java.util.HashMap;
import java.util.Map;

public class BuildTree_From_Pre_In_Order {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);

        TreeNode root = builder(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
        return root;
    }

    public TreeNode builder(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd,
            Map<Integer, Integer> map) {
        if (preStart > preEnd || inStart > inEnd)
            return null;

        TreeNode node = new TreeNode(preorder[preStart]);
        int inRoot = map.get(node.val);
        int numsLeft = inRoot - inStart;

        node.left = builder(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inRoot - 1, map);

        node.right = builder(preorder, preStart + numsLeft + 1, preEnd, inorder, inRoot + 1, inEnd, map);

        return node;
    }
}
