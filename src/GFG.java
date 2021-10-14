// Java program to insert element in binary tree
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.List;

public class GFG {

    private List<Integer> path1 = new ArrayList<>();
    private List<Integer> path2 = new ArrayList<>();

    public void publicInOrder(){
        inorder(root);
    }

    public void publicInsert(int key){
        insert(root, key);
    }
    private boolean findPath(Node root, int n, List<Integer> path)
    {
        // base case
        if (root == null) {
            return false;
        }
         
        // Store this node . The node will be removed if
        // not in path from root to n.
        path.add(root.key);
 
        if (root.key == n) {
            return true;
        }
 
        if (root.left != null && findPath(root.left, n, path)) {
            return true;
        }
 
        if (root.right != null && findPath(root.right, n, path)) {
            return true;
        }
 
        // If not present in subtree rooted with root, remove root from
        // path[] and return false
        path.remove(path.size()-1);
 
        return false;
    }

    int findLCA(int n1, int n2) {
        path1.clear();
        path2.clear();
        return findLCAInternal(root, n1, n2);
    }
 
    private int findLCAInternal(Node root, int n1, int n2) {
 
        if (!findPath(root, n1, path1) || !findPath(root, n2, path2)) {
            System.out.println((path1.size() > 0) ? "n1 is present" : "n1 is missing");
            System.out.println((path2.size() > 0) ? "n2 is present" : "n2 is missing");
            return -1;
        }
 
        int i;
        for (i = 0; i < path1.size() && i < path2.size(); i++) {
             
        // System.out.println(path1.get(i) + " " + path2.get(i));
            if (!path1.get(i).equals(path2.get(i)))
                break;
        }
 
        return path1.get(i-1);
    }
    /* A binary tree node has key, pointer to
    left child and a pointer to right child */
    static class Node {
        int key;
        Node left, right;
 
        // constructor
        Node(int key)
        {
            this.key = key;
            left = null;
            right = null;
        }
    }
    static Node root;
    static Node temp = root;
 
    /* Inorder traversal of a binary tree*/
    public static void inorder(Node temp)
    {
        if (temp == null)
            return;
 
        inorder(temp.left);
        System.out.print(temp.key + " ");
        inorder(temp.right);
    }
 
    /*function to insert element in binary tree */
    static void insert(Node temp, int key)
    {
 
        if (temp == null) {
            root = new Node(key);
            return;
        }
        Queue<Node> q = new LinkedList<Node>();
        q.add(temp);
 
        // Do level order traversal until we find
        // an empty place.
        while (!q.isEmpty()) {
            temp = q.peek();
            q.remove();
 
            if (temp.left == null) {
                temp.left = new Node(key);
                break;
            }
            else
                q.add(temp.left);
 
            if (temp.right == null) {
                temp.right = new Node(key);
                break;
            }
            else
                q.add(temp.right);
        }
    }

    
 
    // Driver code
    // public static void main(String args[])
    // {
    //     // root = new Node(10);
    //     // root.left = new Node(11);
    //     // root.left.left = new Node(7);
    //     // root.right = new Node(9);
    //     // root.right.left = new Node(15);
    //     // root.right.right = new Node(8);
 
    //     // System.out.print(
    //     //     "Inorder traversal before insertion:");
    //     // inorder(root);
 
    //     // int key = 12;
    //     // insert(root, key);
    //     // key = 13;
    //     // insert(root, key);
    //     // System.out.print(
    //     //     "\nInorder traversal after insertion:");
    //     // inorder(root);
    //     GFG binTree = new GFG();
    //     for(int i = 1; i < 21; i++){
    //         binTree.insert(root, i);
    //     }

        
    //     System.out.println(binTree.findLCA(20, 19));
    // }
}