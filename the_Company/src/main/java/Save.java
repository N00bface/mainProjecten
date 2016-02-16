/**
 * @autor Jari Van Melckebeke
 */
public class Save {
    private int save_id, save_money, save_miners, save_navy, save_guards, save_xp;

    public int getSave_id() {
        return save_id;
    }

    public int getSave_money() {
        return save_money;
    }

    public String getSave_name() {
        return save_name;
    }

    public String getSave_location() {
        return save_location;
    }

    public String getSave_ship() {
        return save_ship;
    }

    private String save_name, save_location, save_ship;

    public int getSave_miners() {
        return save_miners;
    }

    public int getSave_navy() {
        return save_navy;
    }

    public int getSave_guards() {
        return save_guards;
    }

    public int getSave_xp() {
        return save_xp;
    }

    public Save() {

    }

    public Save(int save_id, String save_name, String save_location, int save_money, int save_miners, int save_navy, int save_guards, int save_xp, String save_ship) {
        this.save_id = save_id;
        this.save_name = save_name;
        this.save_location = save_location;
        this.save_money = save_money;
        this.save_ship = save_ship;
        this.save_miners = save_miners;
        this.save_navy = save_navy;
        this.save_guards = save_guards;
        this.save_xp = save_xp;
    }

    @Override
    public String toString() {
        return "id=" + save_id + " , money=" + save_money + " , name=" + save_name + " , location=" + save_location + " , " + "ship=" + save_ship;
    }
}
