import java.util.ArrayList;

/**
 * @author Jari Van Melckebeke
 */
public class Main {
    private static ArrayList<Player> winnerList = new ArrayList<Player>();

    public static void main(String[] args) {
        char[][] speelveld = createField(6, 7);
        int count = 1;

        for (int i = 0; i < 1; i++) {
            Player player1 = new Player("ai" + i + "A", SQLResources.getParameters(count));
            count++;
            Player player2 = new Player("ai" + i + "B", SQLResources.getParameters(count));
            ArrayList<Player> tempList = new ArrayList<Player>();
            for (int j = 0; j < 5; j++) {
                while (!is4inARow(speelveld)) {

                    speelveld = player1.getMove(player1, speelveld, player1.getParameters());
                    if (is4inARow(speelveld)) {
                        tempList.add(whoWins(speelveld, player1, player2));
                        break;
                    } else {
                        speelveld = player2.getMove(player2, speelveld, player2.getParameters());
                        if (is4inARow(speelveld)) {
                            tempList.add(whoWins(speelveld, player1, player2));
                            break;
                        }

                    }
                }
                System.out.println("------------" + i + " game:" + j + "----------------");
                for (Player item : winnerList) {
                    System.out.println(item.getName());
                }
            }
            winnerList.add(getWinner(tempList));
            //System.out.println("tempList = " + Arrays.toString(tempList.toArray()));
            //System.out.println("winnerList = " + Arrays.toString(winnerList.toArray()));
        }
    }

    private static Player getWinner(ArrayList<Player> tempList) {
        int teamA = 0, teamB = 0;
        for (Player player : tempList) {
            if (player.getName().endsWith("A")) {
                teamA++;
            } else {
                teamB++;
            }
        }
        if (teamA > teamB) {
            for (Player player : tempList) {
                if (player.getName().endsWith("A")) {
                    return player;
                }
            }
        } else {
            for (Player player : tempList) {
                if (player.getName().endsWith("B")) {
                    return player;
                }
            }
        }
        return null;
    }

    private static Player whoWins(char[][] speelveld, Player player1, Player player2) {
        //horizontaal
        for (char[] aSpeelveld : speelveld) {
            for (int j = 0; j < aSpeelveld.length - 4; j++) {
                if (aSpeelveld[j] == aSpeelveld[j + 1] && aSpeelveld[j] == aSpeelveld[j + 2] && aSpeelveld[j] == aSpeelveld[j + 3]) {
                    if (aSpeelveld[j] == 'A') {
                        return player1;
                    } else {
                        return player2;
                    }
                }
            }
        }
        //verticaal
        for (int i = 0; i < speelveld.length - 4; i++) {
            for (int j = 0; j < speelveld[i].length; j++) {
                if (speelveld[i][j] == speelveld[i + 1][j] && speelveld[i][j] == speelveld[i + 2][j] && speelveld[i][j] == speelveld[i + 3][j]) {
                    if (speelveld[i][j] == 'A') {
                        return player1;
                    } else {
                        return player2;
                    }
                }
            }
        }
        //diagonaal
        for (int i = 0; i < speelveld.length - 4; i++) {
            for (int j = 0; j < speelveld[i].length - 4; j++) {
                if (speelveld[i][j] == speelveld[i + 1][j + 1] && speelveld[i][j] == speelveld[i + 2][j + 2] && speelveld[i][j] == speelveld[i + 3][j + 3]) {
                    if (speelveld[i][j] == 'A') {
                        return player1;
                    } else {
                        return player2;
                    }
                }
            }
        }
        return null;
    }

    public static boolean is4inARow(char[][] speelveld) {
        //horizontaal
        for (char[] aSpeelveld : speelveld) {
            for (int j = 0; j < aSpeelveld.length - 4; j++) {
                if ((aSpeelveld[j] == aSpeelveld[j + 1] && aSpeelveld[j] == aSpeelveld[j + 2] && aSpeelveld[j] == aSpeelveld[j + 3]) && (aSpeelveld[j] == 'A' || aSpeelveld[j] == 'B')) {
                    return true;
                }
            }
        }
        //verticaal
        for (int i = 0; i < speelveld.length - 4; i++) {
            for (int j = 0; j < speelveld[i].length; j++) {
                if (speelveld[i][j] == speelveld[i + 1][j] && speelveld[i][j] == speelveld[i + 2][j] && speelveld[i][j] == speelveld[i + 3][j] && (speelveld[i][j] == 'A' || speelveld[i][j] == 'B')) {
                    return true;
                }
            }
        }
        //diagonaal
        for (int i = 0; i < speelveld.length - 4; i++) {
            for (int j = 0; j < speelveld[i].length - 4; j++) {
                if (speelveld[i][j] == speelveld[i + 1][j + 1] && speelveld[i][j] == speelveld[i + 2][j + 2] && speelveld[i][j] == speelveld[i + 3][j + 3] && (speelveld[i][j] == 'A' || speelveld[i][j] == 'B')) {
                    return true;
                }
            }
        }
        return false;
    }

    public static char[][] createField(int x, int y) {
        return new char[y][x];
    }
}
