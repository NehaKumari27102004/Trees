package Tree;

public class CountsOfNode {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;

        }
    }
    static class CountNode {
        static int idx = -1;

        public static CountsOfNode.Node buildTree(int nodes[]) {
            idx++;

            if (nodes[idx] == -1) {
                return null;
            }

            CountsOfNode.Node newNode = new CountsOfNode.Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
    }

    public static int CountOfNodes(Node root){
        if(root==null){
            return 0;
        }
        int leftNodes=CountOfNodes(root.left);
        int rightNodes=CountOfNodes(root.right);

        return leftNodes+rightNodes+1;
    }

    public static int sumOfNodes(Node root){
        if(root==null){
            return 0;
        }
        int leftSum=sumOfNodes(root.left);
        int rightSum=sumOfNodes(root.right);

        return leftSum+rightSum+root.data;
    }

    public static int height(Node root){
        if(root == null){
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        int myHeight=Math.max(leftHeight,rightHeight) + 1;
        return myHeight;
    }

    public static int diameter(Node root){
        if(root == null){
            return 0;
        }
        int diam1 = diameter(root.left);
        int diam2 = diameter(root.right);
        int diam3 = height(root.left) + height(root.right) + 1;

        return Math.max(diam3, Math.max(diam1,diam2));
    }

   /* static class TreeInfo{
        int ht;
        int diam;


        TreeInfo(){
            this.ht = ht;
            this.diam = diam;
        }


    }


    public static  TreeInfo diameter2(Node root){
        if(root ==null){
            new TreeInfo(1,1);
        }



        TreeInfo left= diameter2(root.left);
        TreeInfo right = diameter2(root.right);

        int Height= Math.max(left.ht, right.ht);

        int diam1 = left.diam;
        int diam2 = right.diam;
        int diam3 = left.ht + right.ht + 1;

        int diam = Math.max(Math.max(diam1,diam2), diam3);

        TreeInfo myInfo= new TreeInfo();
        return myInfo;
    }

    */

    public static void main(String[] args) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        CountNode tree = new CountNode();

        Node root = tree.buildTree(nodes);
        System.out.println(root.data);
        System.out.println(CountOfNodes(root));
        System.out.println(sumOfNodes(root));
        System.out.println(height(root));
        System.out.println(diameter(root));

    }
}
