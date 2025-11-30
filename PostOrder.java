package Tree;


import java.util.*;


public class PostOrder {

    public List<Integer> postorderTraversal(TreeNode root){
        List<Integer> result=new ArrayList<>();
        postorder(root, result);
        return result;
    }

    private void postorder(TreeNode node, List<Integer> result){
        if(node ==  null){
            return;
        }
        postorder(node.left , result);
        postorder(node.right , result);
        result.add(node.val);
    }

    public static void main(String [] args){
        TreeNode root= new TreeNode(1);
        root.left =  new TreeNode(2);
        root.right =  new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(8);

        PostOrder sol= new PostOrder();
        List<Integer> ans = sol.postorderTraversal(root);
        System.out.println(ans);
    }
}
