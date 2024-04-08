import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.example.Inventory;
import org.example.Item;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class InventoryTest {

    private Inventory inventory;

    @Before
    public void setUp() {
        inventory = new Inventory();
    }

    @Test
    public void testAddItem() {
        Item item = new Item(1, "Item 1", 5, 10.0);
        inventory.addItem(item);
        assertTrue(inventory.getItems().contains(item));
    }

    @Test
    public void testRemoveItem() {
        Item item = new Item(1, "Item 1", 5, 10.0);
        inventory.addItem(item);
        inventory.removeItem(1);
        assertFalse(inventory.getItems().contains(item));
    }

    @Test
    public void testViewItems() {
        Inventory inventory = new Inventory();
        Item item1 = new Item(1, "Item 1", 5, 10.0);
        Item item2 = new Item(2, "Item 2", 10, 20.0);
        inventory.addItem(item1);
        inventory.addItem(item2);

        // Redirect System.out to capture printed output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Call the viewItems method
        inventory.viewItems();

        // Restore normal System.out
        System.setOut(System.out);

        // Verify that the expected output is printed to the console
        String expected = "ID: 1, Name: Item 1, Quantity: 5, Price: $10.0\r\nID: 2, Name: Item 2, Quantity: 10, Price: $20.0\r\n";
        assertEquals(expected, outContent.toString());
    }

    @Test
    public void testUpdateQuantity() {
        Item item = new Item(1, "Item 1", 5, 10.0);
        inventory.addItem(item);
        inventory.updateQuantity(1, 8);
        assertEquals(8, inventory.getItem(1).getQuantity());
    }
}

