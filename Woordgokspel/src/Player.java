import java.util.Random;

/**
 * @author Jari Van Melckebeke
 * @since 21.07.16
 */
public class Player {
    private String name;

    public String getName() {
        return name;
    }

    public int getGok() {
        return gok;
    }

    private int gok;
    public Player(String name) {
        this.name = name;
        gok = 0;
    }

    public int getGuess(){
        gok++;
        return new Random().nextInt(99);
    }
}
