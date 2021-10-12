

public class BinaryTree {
     // Root of Binary Tree
     public static Node root;
 
     // Constructors
     BinaryTree(int key)
     {
         root = new Node(key);
     }
  
     BinaryTree()
     {
         root = null;
     }
     public static void reorganise(){
     }

     public static void addToTree(Node parent, int key){
     }
  
     public static void main(String[] args)
     {
        BinaryTree tree = new BinaryTree(5);

        System.out.println(root.left.left.key);
     }
}
