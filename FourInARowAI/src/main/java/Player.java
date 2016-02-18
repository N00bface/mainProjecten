/**
 * @autor Jari Van Melckebeke
 */
public class Player {

    private int[] parameters;
    private String name;

    public Player(String name, int[] parameters) {
        setName(name);
        setParameters(parameters);
    }

    public static Player newAI(String name, int[] parameters) {
        return new Player(name, parameters);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setParameters(int[] parameters) {
        this.parameters = parameters;
    }

    public int[] getParameters() {
        return parameters;
    }

    public char[][] getMove(Player player, char[][] speelveld, int[] parameters) {

    }
}
