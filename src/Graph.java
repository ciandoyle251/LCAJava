import java.util.ArrayList;
import java.util.Hashtable;

public class Graph {
    int root;
    public Hashtable<Integer, ArrayList<Integer>> graph = new Hashtable<Integer, ArrayList<Integer>>();
    
    Graph(int root){
        this.root = root;
        addNode(root);

    }


    public void addNode(int k){
        ArrayList<Integer> hold = new ArrayList<Integer>();
        graph.put(k, hold);
        //System.out.println(graph.toString());
    }

    public void addEdge(int k, int v){
        graph.get(k).add(v);
    }

    public void snake(int k, int target, boolean finished){
        if(k == target || finished == true){
            finished = true;
            return;
        }
        ArrayList<Integer> hold = graph.get(k);
        int i = 0;
        System.out.println(k);
        while(i < hold.size()){
            if(k == target || finished == true){
                finished = true;
                return;
            }
            snake(hold.get(i), target, finished);
            if(k == target || finished == true){
                finished = true;
                return;
            }
            i++;
        }
    }



    public ArrayList<Integer> shortestPath(int k, int target, ArrayList<Integer> path){
        if(k == target){
            path.add(target);
            return path;
        }
        //System.out.println(k);
        path.add(k);
        int i = 0;
        while(i < graph.get(k).size()){
            if(path.contains(target)){
                return path;
            }
            shortestPath(graph.get(k).get(i), target, path);
            i++;
            if(path.contains(target)){
                return path;
            }
        }
        path.remove(path.size() - 1);
        return path;
    }




    public void LCA(int a, int b){
        ArrayList<Integer> path = new ArrayList<Integer>();
        ArrayList<Integer> path2 = new ArrayList<Integer>();
        path = shortestPath(6, a, path);
        path2 = shortestPath(6, b, path2);
        followPath(path, path2);
    }

    public void followPath(ArrayList<Integer> path1, ArrayList<Integer> path2){
        ArrayList<Integer> big;
        ArrayList<Integer> small;
        if(path2.size() < path1.size()){
            big = path1;
            small = path2;
        }
        else{
            big = path2;
            small = path1;
        }

        for(int i = big.size() - 1; i >= 0; i--){
            for(int j = small.size() - 1; j >= 0; j--){
                if(big.get(i) == small.get(j)){
                    System.out.println(big.get(i));
                    return;
                }
            }
        }
        System.out.println(root);
    }
}
