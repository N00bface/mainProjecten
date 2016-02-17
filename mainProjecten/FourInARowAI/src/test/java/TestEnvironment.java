
import org.junit.Test;

/**
 * @autor Jari Van Melckebeke
 */
public class TestEnvironment {
    @Test
    public void environment(){
        assert Main.createField(6,7) == new char[6][7];
        assert Player.newAI() != null;

    }
}
