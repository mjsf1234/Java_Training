package src.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Before;
import org.junit.Test;

import src.main.models.Cart;
import src.main.models.Item;

public class CartTest {

    Cart cart;

    // Before runs before any Tests and declare all the variable that our test uses
    @Before
    public void setup() {
        cart = new Cart();

        cart.add(new Item("pepsi", 20));
        cart.add(new Item("pizza", 200));
    }

    @Test
    public void itemAdded() {
        assertTrue(cart.contain(new Item("pizza", 200)));
    }

    @Test
    public void skipDuplicate() {
        assertFalse(cart.add(new Item("pizza", 200)));
    }

    @Test
    public void removeItemTest() {
        cart.remove("pizza");
        assertFalse(cart.contain(new Item("pizza", 200)));
    }

}
