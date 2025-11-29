package Tree;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int i) {
        this.val = i;
    }
}

public class PreOrder {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorder(root, result);
        return result;
    }

    private void preorder(TreeNode node, List<Integer> result) {
        if (node == null) return;

        result.add(node.val);        // Visit root
        preorder(node.left, result); // Visit left
        preorder(node.right, result);// Visit right
    }

    public static void main(String[] args) {

        // Build tree: 1 -> 2, 3
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        PreOrder sol = new PreOrder();
        List<Integer> ans = sol.preorderTraversal(root);

        System.out.println(ans); // Output: [1, 2, 3]
    }
}
