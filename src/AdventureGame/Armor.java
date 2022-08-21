package AdventureGame;

public class Armor {
    private int id;
    private int dodge;
    private int coin;

    public Armor(int id, int dodge, int coin) {

        this.id = id;
        this.dodge = dodge;
        this.coin = coin;
    }

    public static Armor[] armor() {
        Armor[] armors = {new Armor(1, 1, 15),
                new Armor(2, 3, 25),
                new Armor(3, 5, 40)};
        return armors;
    }

    public static void printArmor(Armor[] armors) {
        for (Armor armor : armors) {
            System.out.println("Zirhin ID si:\t" + armor.getId() + "\t\tZirhin engellemesi\t" + armor.getDodge() +
                    "\tZirhin degeri\t" + armor.getCoin());
        }
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
