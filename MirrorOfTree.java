package Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class MirrorOfTree {

    static void mirror(Node root){
        if(root == null)
            return;

        mirror(root.left);
        mirror(root.right);

        Node temp = root.left;
        root.left = root.right;
        root.right = temp;

    }

    static int getHeight(Node root , int h){
        if(root == null)
            return h-1;

        return Math.max(getHeight(root.left , h+1) , getHeight(root.right,h+1));
    }

    static void levelOrder(Node root){
        Queue<List<Object>> queue = new LinkedList<>();
        queue.offer(List.of(root, 0));

        int lastLevel = 0;

        int height = getHeight(root, 0);

        while( !queue.isEmpty()){
            List<Object> top = queue.poll();

            Node node = (Node) top.get(0);
            int lvl = (int) top.get(1);

            if(lvl > lastLevel){
                System.out.println();
                lastLevel = lvl;
            }

            if(lvl > height) break;

            System.out.print((node.data == -1 ? "N" : node.data) + " ");

            if(node.data == -1)  continue;
            if(node.left==null) queue.offer(List.of(new Node(-1) , lvl+1));
            else queue.offer(List.of(node.left, lvl+1));


            if(node.right == null) queue.offer(List.of(new Node(-1) , lvl+1));
            else queue.offer(List.of(node.right , lvl+1));

        }
    }

    public static void main(String[] args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        mirror(root);

        levelOrder(root);
    }

}
