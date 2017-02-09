package resources;

/**
 * Created by Jari on 28/12/2015.
 */
public class Weapon {
    private String name;
    private int clip;
    private int damage;
    private int movability;
    private Perks[] perks;

    public Weapon(String name, int clip, int damage, int movability, Perks[] perks) {
        this.name = name;
        this.clip = clip;
        this.damage = damage;
        this.movability = movability;
        this.perks = perks;
    }

    public void setPerks(Perks[] perks) {
        this.perks = perks;
    }

    public String getName() {
        return name;
    }

    public int getClip() {
        return clip;
    }

    public int getDamage() {
        return damage;
    }

    public int getMovability() {
        return movability;
    }

    public Perks[] getPerks() {
        return perks;
    }

    public static Weapon handGun = new Weapon("handgun", 5, 1, 95, null);
    public static Weapon rifle = new Weapon("rifle", 15, 5, 50, (new Perks[]{Perks.rapid}));
}
