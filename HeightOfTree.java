package Tree;

class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = null;
        right = null;
    }
}

public class HeightOfTree {

    static int height(Node root) {
        if (root == null)
            return -1;

        int lHeight = height(root.left);
        int rHeight = height(root.right);

        return 1 + Math.max(lHeight, rHeight);
    }

    public static void main(String[] args) {

        Node root = new Node(12);
        root.left = new Node(8);
        root.right = new Node(18);
        root.left.left = new Node(4);
        root.right.right = new Node(7);

        System.out.println(height(root));  // Output: 3
    }
}
