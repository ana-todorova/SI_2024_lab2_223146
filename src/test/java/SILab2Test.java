import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

class SILab2Test {
    private List<Item> create(Item...items){
        return new ArrayList<Item>(Arrays.asList(items));
    }

    @Test
    void EveryBranchTest(){
        RuntimeException ex;
        ex = assertThrows(RuntimeException.class, ()->
                SILab2.checkCart(null, 0));
        assertTrue(ex.getMessage().contains("allItems list can't be null!"));
        assertTrue(SILab2.checkCart(new ArrayList<Item>(), 0));
        assertFalse(SILab2.checkCart(new ArrayList<Item>(), -1));

        ex = assertThrows(RuntimeException.class, ()->
                SILab2.checkCart(create(new Item(" ", null, 10, 0.1f)), 1));
        assertTrue(ex.getMessage().contains("No barcode!"));
        assertFalse(SILab2.checkCart(create(new Item(" ", "0222", 301, 0.2f)), 2));

        ex = assertThrows(RuntimeException.class, ()->
                SILab2.checkCart(create(new Item("ime1", "33bukvi33", 30, 0.3f)), 3));
        assertTrue(ex.getMessage().contains("Invalid character in item barcode!"));
        assertFalse(SILab2.checkCart(create(new Item("ime2", "4444", 40, -4)), 4));
    }

    @Test
    void MultipleConditionTest(){
        assertEquals(true, SILab2.checkCart(create(new Item("ime1", "0111", 1111, 0.1f)), 100));
        assertEquals(false, SILab2.checkCart(create(new Item("ime2", "2222", 2222, 0.1f)), 2));
        assertEquals(false, SILab2.checkCart(create(new Item("ime3", "0323", 3333, 0)), 3));
        assertEquals(false, SILab2.checkCart(create(new Item("ime4", "0333", 111, 0.3f)), 4));
    }
}