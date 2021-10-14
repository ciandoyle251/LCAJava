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
        assertEquals(4, binTree.findLCA(16, 4));//ancestors with solution as one of the inputs
        assertEquals(9, binTree.findLCA(9, 9));//duplicate inputs
    }
}
