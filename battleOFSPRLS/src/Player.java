import java.awt.*;
import java.util.HashMap;
import java.util.Random;

/**
 * @author Jari Van Melckebeke
 * @since 23.07.16
 */
public class Player {
    private int id;
    private String team;
    private HashMap<String, Integer> aspects = new HashMap<>();
    private Point target = new Point(0, 0);
    private Point curr_poss = new Point(0, 0);
    private int max_width, max_height;
    private int num_of_ids = 0;
    private boolean isgoing = false;
    private String start_figure;
    private Random random = new Random();

    public void setNum_of_ids(int num_of_ids) {
        this.num_of_ids = num_of_ids;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public HashMap<String, Integer> getAspects() {
        return aspects;
    }

    public void setAspects(HashMap<String, Integer> aspects) {
        this.aspects = aspects;
    }

    public Point getTarget() {
        return target;
    }

    public void setTarget(Point target) {
        this.target = target;
    }

    public Point getCurr_poss() {
        return curr_poss;
    }

    public void setCurr_poss(Point curr_poss) {
        this.curr_poss = curr_poss;
    }

    public int getMax_width() {
        return max_width;
    }

    public void setMax_width(int max_width) {
        this.max_width = max_width;
    }

    public int getMax_height() {
        return max_height;
    }

    public void setMax_height(int max_height) {
        this.max_height = max_height;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public void randomizeTarget() {
        int x = random.nextInt(max_width);
        int y = random.nextInt(max_height);
        target = new Point(x, y);
    }

    public Player(int id, String team, String aspect, int max_width, int max_height) {
        this.id = id;
        this.team = team;
        this.max_width = max_width;
        this.max_height = max_height;
        start_figure = aspect;
        aspects.put(aspect, 1);
    }

    public void makeMove(boolean all) {
        if (aspects.size() == 9 && !isgoing) {
            target = new Point(5, 5);
            isgoing = true;
            makeMove(all);
        }
        if (target.getX() == curr_poss.getX() && target.getY() == curr_poss.getY()) {
            if (curr_poss.getX() == 5 && curr_poss.getY() == 5) {
                for (String k : aspects.keySet()) {
                    aspects.put(k, aspects.get(k) - 1);
                }
                num_of_ids++;
                isgoing = false;
            }
            randomizeTarget();
            //makeMove();
            return;
        }
        if (Math.abs(target.getX() - curr_poss.getX()) > Math.abs(target.getY() - curr_poss.getY())) {
            if (target.getX() - curr_poss.getX() < 0) {
                curr_poss.x--;
            } else {
                curr_poss.x++;
            }
        } else {
            if (target.getY() - curr_poss.getY() < 0) {
                curr_poss.y--;
            } else {
                curr_poss.y++;
            }
        }
    }

    public String makeGuess() {
        String[] guesses = {"rock", "paper", "scissor", "lizard", "spock"};
        return guesses[random.nextInt(5)];
    }

    public HashMap<String, Integer> giveAspects() {
        HashMap<String, Integer> clone = new HashMap<>();
        clone.putAll(aspects);
        aspects.clear();
        aspects.put(start_figure, 1);
        return clone;
    }

    public void addAspects(HashMap<String, Integer> map) {
        for (String k : map.keySet()) {
            if (aspects.containsKey(k))
                aspects.put(k, map.get(k) + aspects.get(k));
            else
                aspects.put(k, map.get(k));
        }
    }

    public int getNum_of_ids() {
        return num_of_ids;
    }
}
