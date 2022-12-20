package Trees;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Serialize_Deserialize_BT {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    public void serializeHelper(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null,");
            return;
        }

        sb.append(root.val + ",");
        serializeHelper(root.left, sb);
        serializeHelper(root.right, sb);

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> list = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserializeHelper(list);
    }

    public TreeNode deserializeHelper(List<String> list) {
        if (list.get(0).equals("null")) {
            list.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(list.get(0)));
        list.remove(0);

        root.left = deserializeHelper(list);
        root.right = deserializeHelper(list);

        return root;
    }

}
