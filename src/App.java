
public class App {

    public static void main(String[] args) throws Exception {
        Graph here = new Graph(6);
        here.addNode(7);
        here.addNode(8);
        here.addNode(9);
        here.addNode(10);
        here.addNode(11);
        here.addNode(12);
        here.addEdge(7, 11);
        here.addEdge(7, 12);
        here.addEdge(9, 10);
        here.addEdge(6, 7);
        here.addEdge(7, 8);
        here.addEdge(6, 9);
        here.LCA(7,6);
    }
}
