import java.awt.*;
import java.util.Arrays;

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
        int[] probSpeelveld = new int[speelveld[0].length];
        Point[] vallijn = new Point[6];
        for (int j = speelveld[0].length - 1; j >= 0; j--) {
            for (int i = speelveld.length - 1; i >= 0; i--) {
                if (!isColumFull(speelveld, j)) {
                    if (i == speelveld.length - 1) {
                        vallijn[j] = new Point(j, i);
                    } else {
                        if (speelveld[i][j] != '\0') {
                            vallijn[j] = new Point(j, i-1);
                        }
                    }
                }
            }
        }
        for (Point vak : vallijn) {
            try {
                if (isWinPossible(speelveld, player.getName().toCharArray()[player.getName().length() - 1], vak.x, vak.y)) {
                    probSpeelveld[vak.x] += parameters[0];
                }
            } catch (IndexOutOfBoundsException e) {
                e.printStackTrace();
                System.exit(0);
            }
            try {
                if (isOtherWinPossible(speelveld, player.getName().toCharArray()[player.getName().length() - 1], vak.x, vak.y)) {
                    probSpeelveld[vak.x] += parameters[1];
                }
            } catch (IndexOutOfBoundsException e) {
                e.printStackTrace();System.exit(0);
            }
            try {
                if (is3Possible(speelveld, player.getName().toCharArray()[player.getName().length() - 1], vak.y, vak.x)) {
                    probSpeelveld[vak.x] += parameters[2];
                }
            } catch (IndexOutOfBoundsException e) {
                e.printStackTrace();System.exit(0);
            }
            try {
                if (isOther3Possible(speelveld, player.getName().toCharArray()[player.getName().length() - 1], vak.x, vak.y)) {
                    probSpeelveld[vak.x] += parameters[3];
                }
            } catch (IndexOutOfBoundsException e) {
                e.printStackTrace();System.exit(0);
            }
            try {
                if (is2OptionsPossible(speelveld, player.getName().toCharArray()[player.getName().length() - 1], vak.x, vak.y)) {
                    probSpeelveld[vak.x] += parameters[4];
                }
            } catch (IndexOutOfBoundsException e) {
                e.printStackTrace();System.exit(0);
            }

        }
        int score = 0;
        int maxindex = 0;
        for (int i = 0; i < probSpeelveld.length; i++) {
            if (score < probSpeelveld[i]) {
                score = probSpeelveld[i];
                maxindex = i;
            }
        }
        System.out.println("---------------speelveld---------------");
        for (char[] lijn : speelveld) {
            System.out.println(Arrays.toString(lijn));
        }
        System.out.println("---------------end---------------");
        System.out.println("vallijn = " + Arrays.toString(vallijn));
        System.out.println("probSpeelveld = " + Arrays.toString(probSpeelveld));
        try {
            speelveld[vallijn[maxindex].y][maxindex] = player.getName().toCharArray()[player.getName().length() - 1];
        } catch (NullPointerException e) {
            speelveld[vallijn[maxindex + 1].y][maxindex] = player.getName().toCharArray()[player.getName().length() - 1];
        }
        return speelveld;

    }

    public boolean isColumFull(char[][] speelveld, int colum) {
        return speelveld[colum][0] != '\0';
    }

    private boolean is2OptionsPossible(char[][] speelveld, char team, int x, int y) {
        int count = 0;
        //horizontaal
        try{
        if ((((speelveld[y][x] == speelveld[y][x + 1]) && ((speelveld[y][x + 2] != 'A') || (speelveld[y][x + 2] != 'B')))
                || ((speelveld[y][x + 1] == speelveld[y + 2][x + 2]) && ((speelveld[y][x] != 'A') || (speelveld[y][x] != 'B')))
                || ((speelveld[y][x] == speelveld[y + 2][x + 2]) && ((speelveld[y + 1][x + 1] != 'A') || (speelveld[y][x + 1] != 'B')))
                || ((speelveld[y][x] == speelveld[y][x + 1]) && ((speelveld[y + 2][x + 2] != 'A') || (speelveld[y + 2][x + 2] != 'B')))
        ) && ((speelveld[y][x] == team) || (speelveld[y][x + 1] == team) || (speelveld[y][x + 2] == team))) {
            count++;
        }
        //verticaal
        if ((((speelveld[y + 1][x] == speelveld[y + 2][x + 2]) && ((speelveld[y][x] != 'A') || (speelveld[y][x] != 'B')))
                || ((speelveld[y][x] == speelveld[y + 2][x + 2]) && ((speelveld[y + 3][x + 3] != 'A') || (speelveld[y + 1][x] != 'B')))
                || ((speelveld[y][x] == speelveld[y + 1][x]) && (speelveld[y][x] == speelveld[y + 3][x + 3]) && ((speelveld[y + 2][x + 2] != 'A') || (speelveld[y + 2][x + 2] != 'B')))
        ) && ((speelveld[y][x] == team) || (speelveld[y + 1][x] == team) || (speelveld[y + 2][x + 2] == team) || (speelveld[y + 3][x + 3] == team))) {
            count++;
        }
        //diagonaal
        if ((speelveld[y + 1][x + 1] == speelveld[y + 3][x + 3]) && (speelveld[y + 1][x + 1] == speelveld[y + 2][x + 2]) && ((speelveld[y][x] != 'A') || (speelveld[y][x] != 'B'))
                || ((speelveld[y][x] == speelveld[y + 3][x + 3]) && (speelveld[y][x] == speelveld[y + 2][x + 2]) && ((speelveld[y + 1][x + 1] != 'A') || (speelveld[y + 1][x + 1] != 'B'))
                || ((speelveld[y][x] == speelveld[y + 1][x + 1]) && (speelveld[y][x] == speelveld[y + 3][x + 3]) && ((speelveld[y + 2][x + 2] != 'A') || (speelveld[y + 2][x + 2] != 'B'))
        ) && ((speelveld[y][x] == team) || (speelveld[y + 1][x + 1] == team) || (speelveld[y + 2][x + 2] == team) || (speelveld[y + 3][x + 3] == team))))
            count++;
        return count > 1;}catch (IndexOutOfBoundsException e){
            return false;
        }
    }

    private boolean isOther3Possible(char[][] speelveld, char t, int x, int y) {
        char team;
        if (t == 'A') {
            team = 'B';
        } else {
            team = 'A';
        }
        return is3Possible(speelveld, team, y, x);
    }

    private boolean is3Possible(char[][] speelveld, char team, int y, int x) {
        try {
            //horizontaal
            if ((((speelveld[y][x] == speelveld[y][x + 1]) && ((speelveld[y][x + 2] != 'A') || (speelveld[y][x + 2] != 'B')))
                    || ((speelveld[y][x + 1] == speelveld[y + 2][x + 2]) && ((speelveld[y][x] != 'A') || (speelveld[y][x] != 'B')))
                    || ((speelveld[y][x] == speelveld[y + 2][x + 2]) && ((speelveld[y + 1][x + 1] != 'A') || (speelveld[y][x + 1] != 'B')))
                    || ((speelveld[y][x] == speelveld[y][x + 1]) && ((speelveld[y + 2][x + 2] != 'A') || (speelveld[y + 2][x + 2] != 'B')))
            ) && ((speelveld[y][x] == team) || (speelveld[y][x + 1] == team) || (speelveld[y][x + 2] == team))) {
                return true;
            }
            //verticaal
            if ((((speelveld[y + 1][x] == speelveld[y + 2][x + 2]) && ((speelveld[y][x] != 'A') || (speelveld[y][x] != 'B')))
                    || ((speelveld[y][x] == speelveld[y + 2][x + 2]) && ((speelveld[y + 3][x + 3] != 'A') || (speelveld[y + 1][x] != 'B')))
                    || ((speelveld[y][x] == speelveld[y + 1][x]) && (speelveld[y][x] == speelveld[y + 3][x + 3]) && ((speelveld[y + 2][x + 2] != 'A') || (speelveld[y + 2][x + 2] != 'B')))
            ) && ((speelveld[y][x] == team) || (speelveld[y + 1][x] == team) || (speelveld[y + 2][x + 2] == team) || (speelveld[y + 3][x + 3] == team))) {
                return true;
            }
            //diagonaal
            return (((speelveld[y + 1][x + 1] == speelveld[y + 3][x + 3]) && (speelveld[y + 1][x + 1] == speelveld[y + 2][x + 2]) && ((speelveld[y][x] != 'A') || (speelveld[y][x] != 'B')))
                    || ((speelveld[y][x] == speelveld[y + 3][x + 3]) && (speelveld[y][x] == speelveld[y + 2][x + 2]) && ((speelveld[y + 1][x + 1] != 'A') || (speelveld[y + 1][x + 1] != 'B')))
                    || ((speelveld[y][x] == speelveld[y + 1][x + 1]) && (speelveld[y][x] == speelveld[y + 3][x + 3]) && ((speelveld[y + 2][x + 2] != 'A') || (speelveld[y + 2][x + 2] != 'B')))
            ) && ((speelveld[y][x] == team) || (speelveld[y + 1][x + 1] == team) || (speelveld[y + 2][x + 2] == team) || (speelveld[y + 3][x + 3] == team));
        }catch (IndexOutOfBoundsException e){
            return false;
        }
    }

    private boolean isOtherWinPossible(char[][] speelveld, char t, int x, int y) {
        char team;
        if (t == 'A') {
            team = 'B';
        } else {
            team = 'A';
        }
        return isWinPossible(speelveld, team, y, x);
    }

    private boolean isWinPossible(char[][] speelveld, char team, int i, int j) {
        //horizontaal
        try {
            if ((((speelveld[i][j] == speelveld[i][j + 1]) && (speelveld[i][j] == speelveld[i + 2][j + 2]) && ((speelveld[i + 3][j + 3] != 'A') || (speelveld[i + 3][j + 3] != 'B')))
                    || ((speelveld[i][j + 1] == speelveld[i + 3][j + 3]) && (speelveld[i][j + 1] == speelveld[i + 2][j + 2]) && ((speelveld[i][j] != 'A') || (speelveld[i][j] != 'B')))
                    || ((speelveld[i][j] == speelveld[i + 3][j + 3]) && (speelveld[i][j] == speelveld[i + 2][j + 2]) && ((speelveld[i + 3][j + 3] != 'A') || (speelveld[i][j + 1] != 'B')))
                    || ((speelveld[i][j] == speelveld[i][j + 1]) && (speelveld[i][j] == speelveld[i + 3][j + 3]) && ((speelveld[i + 2][j + 2] != 'A') || (speelveld[i + 2][j + 2] != 'B')))
            ) && ((speelveld[i][j] == team) || (speelveld[i][j + 1] == team) || (speelveld[i + 2][j + 2] == team) || (speelveld[i + 3][j + 3] == team))) {
                return true;
            }
            //verticaal
            if ((((speelveld[i][j] == speelveld[i + 1][j]) && (speelveld[i][j] == speelveld[i + 2][j]) && ((speelveld[i + 3][j + 3] != 'A') || (speelveld[i + 3][j + 3] != 'B')))
                    || ((speelveld[i + 1][j] == speelveld[i + 3][j + 3]) && (speelveld[i + 1][j] == speelveld[i + 2][j + 2]) && ((speelveld[i][j] != 'A') || (speelveld[i][j] != 'B')))
                    || ((speelveld[i][j] == speelveld[i + 3][j + 3]) && (speelveld[i][j] == speelveld[i + 2][j + 2]) && ((speelveld[i + 3][j + 3] != 'A') || (speelveld[i + 1][j] != 'B')))
                    || ((speelveld[i][j] == speelveld[i + 1][j]) && (speelveld[i][j] == speelveld[i + 3][j + 3]) && ((speelveld[i + 2][j + 2] != 'A') || (speelveld[i + 2][j + 2] != 'B')))
            ) && ((speelveld[i][j] == team) || (speelveld[i + 1][j] == team) || (speelveld[i + 2][j + 2] == team) || (speelveld[i + 3][j + 3] == team))) {
                return true;
            }
            //diagonaal
            return (((speelveld[i][j] == speelveld[i + 1][j + 1]) && (speelveld[i][j] == speelveld[i + 2][j + 2]) && ((speelveld[i + 3][j + 3] != 'A') || (speelveld[i + 3][j + 3] != 'B')))
                    || ((speelveld[i + 1][j + 1] == speelveld[i + 3][j + 3]) && (speelveld[i + 1][j + 1] == speelveld[i + 2][j + 2]) && ((speelveld[i][j] != 'A') || (speelveld[i][j] != 'B')))
                    || ((speelveld[i][j] == speelveld[i + 3][j + 3]) && (speelveld[i][j] == speelveld[i + 2][j + 2]) && ((speelveld[i + 3][j + 3] != 'A') || (speelveld[i + 1][j + 1] != 'B')))
                    || ((speelveld[i][j] == speelveld[i + 1][j + 1]) && (speelveld[i][j] == speelveld[i + 3][j + 3]) && ((speelveld[i + 2][j + 2] != 'A') || (speelveld[i + 2][j + 2] != 'B')))
            ) && ((speelveld[i][j] == team) || (speelveld[i + 1][j + 1] == team) || (speelveld[i + 2][j + 2] == team) || (speelveld[i + 3][j + 3] == team));

        }catch (IndexOutOfBoundsException e){
            return false;
        }
    }

    public String getName() {
        return name;
    }
}
