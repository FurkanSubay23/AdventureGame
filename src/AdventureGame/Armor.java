package AdventureGame;

public class Armor {
    private String name;
    private int id;
    private int dodge;
    private int coin;



    public Armor(int id, String name, int dodge, int coin) {

        this.id = id;
        this.name=name;
        this.dodge = dodge;
        this.coin = coin;
    }

    public static Armor[] armor() {
        Armor[] armors = {new Armor(1,"Hafif", 1, 15),
                new Armor(2,"Orta", 3, 25),
                new Armor(3,"Agir", 5, 40)};
        return armors;
    }
    public static Armor getArmorObjectID(int id) { // Bu method geriye id si eşit bir weapon dondurur.
        for (Armor armor : armor()) {
            if (id == armor.getId()) {
                return armor;
            }
        }
        return null;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDodge() {
        return dodge;
    }

    public void setDodge(int dodge) {
        this.dodge = dodge;
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }
}
