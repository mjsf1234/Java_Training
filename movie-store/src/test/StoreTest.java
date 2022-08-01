package src.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Before;
import org.junit.Test;

import src.main.models.Movie;
import src.main.models.Store;

public class StoreTest {

    Store store;

    @Before

    public void setup() {
        store = new Store();

        store.addMovies(new Movie("Resdidential Evil", "Blue-Ray", 9.4));
        store.addMovies(new Movie("Uncharted", "Blue-Ray", 9));

    }

    @Test

    public void movieAdded() {
        assertTrue(store.contain(new Movie("Resdidential Evil", "Blue-Ray", 9.4)));
    }

    @Test

    public void sellMoviesTest() {
        store.sellMovies("Resdidential Evil");
        assertFalse(store.contain(new Movie("Resdidential Evil", "Blue-Ray", 9.4)));
    }

}
