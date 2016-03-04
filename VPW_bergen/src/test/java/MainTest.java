import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Jari Van Melckebeke
 */
public class MainTest {

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void getAnswerTest(){
        assert Main.getAnswer().equals("");
    }
}