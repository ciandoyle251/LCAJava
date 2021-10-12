import java.util.ArrayList;

public class Node {
    public ArrayList<Integer> connections = new ArrayList<Integer>();
    int key;
    Integer father;
    Node(int key, int father){
        this.key = key;
        this.father = father;
    }
    Node(int key){
        this.key = key;
    }
}
