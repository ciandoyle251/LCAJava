import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class testing {


    @Test
    public void here(){
        GFG binTree = new GFG();
        for(int i = 1; i < 21; i++){
            binTree.publicInsert(i);
        }

        assertEquals(2, binTree.findLCA(19, 20));
        assertEquals(1, binTree.findLCA(16, 15));
        assertEquals(4, binTree.findLCA(16, 4));
        assertEquals(9, binTree.findLCA(9, 9));
    }
}
