import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

/**
 * @author Jari Van Melckebeke
 * @since 23.07.16
 */
public class Startup {
    private static final int MAP_WIDTH = 25000;
    private static final int MAP_HEIGHT = 25000;
    private static final int NUM_PLAYERS = 1000;
    private static final int STEPS_UNTIL_END = 1000;

    private static Player[] players = new Player[NUM_PLAYERS];

    private static boolean endresult = true, all = false;
    private static int bullies = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("debug level: ");
        int debuglevel = sc.nextInt();
        makeLayers(debuglevel);
        int k = 1;
        for (int i = 1; i < NUM_PLAYERS; i++) {
            if (i > NUM_PLAYERS / 9 * k) {
                k++;
            }
            if (i >= NUM_PLAYERS - 2) {
                players[i] = new Player(i, "none", "none", MAP_WIDTH, MAP_HEIGHT);
            }
            switch (k) {
                case 1:
                    players[i] = new Player(i, "red", "photo", MAP_WIDTH, MAP_HEIGHT);
                    break;
                case 2:
                    players[i] = new Player(i, "green", "card", MAP_WIDTH, MAP_HEIGHT);
                    break;
                case 3:
                    players[i] = new Player(i, "blue", "id-number", MAP_WIDTH, MAP_HEIGHT);
                    break;
                case 4:
                    players[i] = new Player(i, "black", "national-number", MAP_WIDTH, MAP_HEIGHT);
                    break;
                case 5:
                    players[i] = new Player(i, "white", "name", MAP_WIDTH, MAP_HEIGHT);
                    break;
                case 6:
                    players[i] = new Player(i, "purple", "nationality", MAP_WIDTH, MAP_HEIGHT);
                    break;
                case 7:
                    players[i] = new Player(i, "yellow", "date of birth", MAP_WIDTH, MAP_HEIGHT);
                    break;
                case 8:
                    players[i] = new Player(i, "cyan", "chip", MAP_WIDTH, MAP_HEIGHT);
                    break;
                case 9:
                    players[i] = new Player(i, "pink", "gender", MAP_WIDTH, MAP_HEIGHT);
                    break;
            }
        }
        run();
    }

    private static void makeLayers(int debuglevel) {
        switch (debuglevel) {
            case 2:
                all = true;
            case 1:
                endresult = true;
        }
    }

    private static void run() {
        for (int i = 0; i < STEPS_UNTIL_END; i++) {
            for (int i1 = 1; i1 < players.length; i1++) {
                Player player = players[i1];
                player.makeMove(all);
            }
            checkSamePlace();
        }
        //check winner
        int[] arr = new int[10];
        Arrays.fill(arr, 0);
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < (NUM_PLAYERS / 9) + 1; j++) {
                arr[i] += players[i * j].getNum_of_ids();
            }
        }
        int index = 0, max = 0;
        for (int i = 0; i < arr.length; i++) {
            index = (arr[i] > max) ? i : index;
            max = Math.max(max, arr[i]);
        }
        if (all) {
            System.out.println(Arrays.toString(arr));
            System.out.println(bullies);
        }
        if (endresult) {
            System.out.println("team " + index + " has won with " + max + " ids");
        }
    }

    private static void checkSamePlace() {
        for (int i = 1; i < players.length; i++) {
            for (int j = 1; j < players.length; j++) {
                if (i == j)
                    continue;
                if (players[i].getCurr_poss().getX() == players[j].getCurr_poss().getX() && players[i].getCurr_poss().getY() == players[j].getCurr_poss().getY()) {
                    battle(players[i], players[j]);
                }
            }
        }
    }

    private static void battle(Player player1, Player player2) {
        if (Objects.equals(player1.getTeam(), player2.getTeam()))
            return;
        boolean winner = false;
        if (player1.getId() >= NUM_PLAYERS - 2) {
            System.out.println("Theo Plancken or Filip De Zomer has bullied player 1");
            player2.getAspects();
            player2.makeMove(all);
            bullies++;
            return;
        }
        if (player2.getId() >= NUM_PLAYERS - 2) {
            System.out.println("Theo Plancken or Filip De Zomer has bullied player 2");
            player1.getAspects();
            player1.makeMove(all);
            bullies++;
            return;
        }
        while (!winner) {
            String take1 = player1.makeGuess();
            String take2 = player2.makeGuess();
            if (Objects.equals(take1, take2)) {
                if (all)
                    System.out.println("player1 and player2 had a draw");
                continue;
            }
            if (Objects.equals(take1, "lizard") && (Objects.equals(take2, "spock") || Objects.equals(take2, "paper"))) {
                player1.addAspects(player2.giveAspects());
                winner = true;
                if (all)
                    System.out.println("player1 has won from player 2");
                continue;
            }
            if (Objects.equals(take1, "spock") && (Objects.equals(take2, "scissors") || Objects.equals(take2, "rock"))) {
                player1.addAspects(player2.giveAspects());
                winner = true;
                if (all)
                    System.out.println("player1 has won from player 2");
                continue;
            }
            if (Objects.equals(take1, "scissors") && (Objects.equals(take2, "lizard") || Objects.equals(take2, "paper"))) {
                player1.addAspects(player2.giveAspects());
                winner = true;
                if (all)
                    System.out.println("player1 has won from player 2");
                continue;
            }
            if (Objects.equals(take1, "paper") && (Objects.equals(take2, "spock") || Objects.equals(take2, "rock"))) {
                player1.addAspects(player2.giveAspects());
                winner = true;
                if (all)
                    System.out.println("player1 has won from player 2");
                continue;
            }
            if (Objects.equals(take1, "rock") && (Objects.equals(take2, "lizard") || Objects.equals(take2, "scissors"))) {
                player1.addAspects(player2.giveAspects());
                winner = true;
                if (all)
                    System.out.println("player1 has won from player 2");
                continue;
            }
            if (all)
                System.out.println("player2 has won from player 1");
            player2.addAspects(player1.giveAspects());
            winner = true;
        }
    }
}
