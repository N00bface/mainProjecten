
import org.junit.Before;
import org.junit.Test;

/**
 * @autor Jari Van Melckebeke
 */
public class MainTest {
    private Main main;
    private char[][] field = new char[][]{
            {'A', '\0', '\0', '\0', '\0', '\0'},
            {'B', 'A', '\0', '\0', '\0', '\0'},
            {'A', 'A', 'A', '\0', '\0', '\0'},
            {'B', 'B', 'A', 'A', '\0', '\0'},
            {'A', 'B', 'B', 'B', '\0', '\0'},
            {'B', 'A', 'B', 'B', '\0', '\0'},
            {'A', 'B', 'B', 'B', '\0', '\0'}};

    @Before
    public void setUp(){
        this.main = new Main();

    }

    @Test
    public void testMain(){
        assert Main.createField(6,7) == new char[6][7];
    }
    @Test
    public void testIs4InARow(){
        assert Main.is4inARow(field);
    }


}
