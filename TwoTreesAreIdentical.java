package Tree;
import java.util.*;

//-----------[Approach - 1] Using Recursion (DFS)--------------

public class TwoTreesAreIdentical {
    static boolean isIdentical(Node r1 , Node r2){
        if(r1 == null && r2 == null){
            return true;
        }

        if(r1 == null || r2 ==null){
            return false;
        }

        return (r1.data == r2.data) && isIdentical(r1.left,r2.left )&& isIdentical(r1.right, r2.right);

    }

    public static void main(String[] args) {
        Node r1=new Node(6);
        r1.left=new Node(3);
        r1.right=new Node(7);
        r1.left.left=new Node(4);
        r1.left.right=new Node(9);




        Node r2=new Node(6);
        r2.left=new Node(3);
        r2.right=new Node(7);
        r2.left.left=new Node(4);
        r2.left.right=new Node(9);

        if( isIdentical(r1,r2)){
            System.out.println("True");
        }else{
            System.out.println("False");
        }
    }
}
