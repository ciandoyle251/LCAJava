import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class testing {



//                                  1
//                          /               \                              
//                      2                       3
//                  /       \               /       \
//                 4         5             6         7
//                / \       / \           / \       / \
//               8   9     10  11        12  13    14  15
//              /\   /\    /\  /\        /\  /\    /\  /\
//            16 17 18 19  20 
//
//                    

    @Test
    public void here(){
        GFG binTree = new GFG();
        for(int i = 1; i < 21; i++){
            binTree.publicInsert(i);
        }
        assertEquals(9, binTree.findLCA(18,19)); //trivial test
        assertEquals(2, binTree.findLCA(19, 20));//more complicated test
        assertEquals(1, binTree.findLCA(16, 15));//seperate leveled solutions
        assertEquals(4, binTree.findLCA(16, 4)); //ancestors with solution as one of the inputs
        assertEquals(9, binTree.findLCA(9, 9));  //duplicate inputs

        Graph DAG = new Graph(7);
        DAG.addNode(8);
        DAG.addNode(9);
        DAG.addNode(10);
        DAG.addNode(11);
        DAG.addNode(12);
        DAG.addNode(13);
        DAG.addEdge(9, 13);
        DAG.addEdge(7, 8);
        DAG.addEdge(8, 10);
        DAG.addEdge(7, 9);
        DAG.addEdge(9, 13);
        DAG.addEdge(8, 11);
        DAG.addEdge(8, 12);
        DAG.LCA(7, 7);
        // testing dag equivalent
//              7
//          /       \
//         8         9
//       / | \       |
//      10 11 12    13
//
// all lines are directed downwards and dont point back to the parent.
        //assertEquals(7, DAG.LCA(7, 7)); // testing similar input case
        assertEquals(7, DAG.LCA(7, 7));//testing for similar input case
        assertEquals(7, DAG.LCA(8, 9));//testing for trivial case
        assertEquals(7, DAG.LCA(10, 9));//testing for dissimilar depth case
        assertEquals(8, DAG.LCA(10, 8));//testing for solution is ancestor case
        assertEquals(7, DAG.LCA(10, 13));//testing furthest distance from inputs case

    }
}
