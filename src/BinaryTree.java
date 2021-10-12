
import java.util.HashMap;


public class BinaryTree {
    public HashMap<Integer, Node> graph = new HashMap<Integer, Node>();

    BinaryTree(int root){
        graph.put(root, new Node(root));
    }

    public void addTograph(int key, int father){
        graph.put(key, new Node(key, father));
    }
// 
// public void pathfinding{
//      didnt implement this as it was outside the scope of this assignment.
// }
//     

    public Integer getAncestor(Integer key){

        if(key == null){
            return null;
        }
        Integer output = graph.get(key).father;
        return output;
    }

    public Integer getRecursiveAncestor(Integer a, Integer b){
        Integer fb = getAncestor(b);
        if((a == null) || (b == null)){
            return null;
        }
        else if(a == b){
            return a;
        }
        else {
            return getRecursiveAncestor(a, fb);
        }
    }


    public Integer getAncestor(Integer a, Integer b){
        Integer fa = getAncestor(a);
        Integer fb = getAncestor(b);
        if(a == b){
            return a;
        }
        else if(a == fb){
            return fb;
        }
        else if(b == fa){
            return fa;
        }
        else if((fa == null) || (fb == null)){
            Integer fi = getRecursiveAncestor(a, b);
            Integer ft = getRecursiveAncestor(b, a);
            if(fi == null){

                return ft;
            }
            else{

                return fi;
            }
        }
        else if(fa != fb){
            return getAncestor(fa, fb);
        }
        else{
            return fa;
        }
    }
     public static void main(String[] args)
     {
         BinaryTree newbin = new BinaryTree(7);
         newbin.addTograph(6,7);
         newbin.addTograph(8,7);
         newbin.addTograph(5, 7);
         newbin.addTograph(9,8);
         newbin.addTograph(10,6);
         newbin.addTograph(11, 10);
         newbin.addTograph(13, 10);
         newbin.addTograph(23, 6);
         System.out.println(newbin.getAncestor(23,13));






    //          7

    //      /   |    \
    //     /    |     \
    //    6     5      8
    //   /  \           \
    //  10   23          9
//     /  \
//    11   13
     }
}
