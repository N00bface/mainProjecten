import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @autor Jari Van Melckebeke
 */
public class PlayerTest {
    private Player player;
    private int[] parameters = new int[]{0, 1, 2, 3, 4};
    private char[][] field = new char[][]{
            {'\0', '\0', '\0', '\0', '\0', '\0'},
            {'\0', '\0', '\0', '\0', '\0', '\0'},
            {'\0', '\0', '\0', '\0', '\0', '\0'},
            {'\0', '\0', '\0', '\0', '\0', '\0'},
            {'\0', '\0', '\0', '\0', '\0', '\0'},
            {'\0', '\0', '\0', '\0', '\0', '\0'},
            {'\0', '\0', '\0', '\0', '\0', '\0'}};
    private char[][] columfield = new char[][]{
            {'A', '\0', '\0', '\0', '\0', '\0'},
            {'B', '\0', '\0', '\0', '\0', '\0'},
            {'A', '\0', '\0', '\0', '\0', '\0'},
            {'A', '\0', '\0', '\0', '\0', '\0'},
            {'B', '\0', '\0', '\0', '\0', '\0'},
            {'B', '\0', '\0', '\0', '\0', '\0'},
            {'B', '\0', '\0', '\0', '\0', '\0'}};

    @Before
    public void setUp() throws Exception {
        this.player = new Player("testA", parameters);
        field[6] = new char[]{'A', 'A', '\0', 'A', '\0', '\0'};

    }

    @Test
    public void testGetName() throws Exception {
        assert player.getName().equals("testA");
    }

    @Test
    public void testGetMove() throws Exception {
        assert player.getMove(player, field, parameters) == new char[][]{
                {'\0', '\0', '\0', '\0', '\0', '\0'},
                {'\0', '\0', '\0', '\0', '\0', '\0'},
                {'\0', '\0', '\0', '\0', '\0', '\0'},
                {'\0', '\0', '\0', '\0', '\0', '\0'},
                {'\0', '\0', '\0', '\0', '\0', '\0'},
                {'\0', '\0', '\0', '\0', '\0', '\0'},
                {'A', 'A', '\0', 'A', '\0', '\0'}
        };
    }

    @Test
    public void testIsColumFull() {
        assert player.isColumFull(columfield, 0);
    }
}