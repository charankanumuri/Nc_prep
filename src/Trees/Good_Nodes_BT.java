package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class Good_Nodes_BT {
    public int goodNodes(TreeNode root) {

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, Integer.MIN_VALUE));
        int count = 0;
        while (!q.isEmpty()) {
            Pair p = q.poll();
            TreeNode curr = p.node;
            int currMax = p.max;

            if (currMax <= curr.val)
                count++;

            if (curr.left != null)
                q.add(new Pair(curr.left, Math.max(currMax, curr.val)));

            if (curr.right != null)
                q.add(new Pair(curr.right, Math.max(currMax, curr.val)));
        }
        return count;

    }

    class Pair {
        TreeNode node;
        int max;

        public Pair(TreeNode node, int max) {
            this.node = node;
            this.max = max;
        }
    }
}
