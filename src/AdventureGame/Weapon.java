package AdventureGame;

public class Weapon {

    private int ID;
    private int damage;
    private int coin;
    String name;

    public Weapon(String name, int ID, int damage, int coin) {
        this.ID = ID;
        this.damage = damage;
        this.coin = coin;
        this.name = name;
    }

    public static Weapon[] weapons() {        // Silahlarımızı böyle yaptırıyoruz.Dizi kullanarak
        Weapon[] weapons = {new Weapon("Tabanca", 1, 2, 15),
                new Weapon("Kilic", 2, 3, 35),
                new Weapon("Tufek", 3, 7, 45)};
        return weapons;
    }
    public static Weapon getWeaponObjectID(int id) { // Bu method geriye id si eşit bir weapon dondurur.
        // Weapon weapon=null; diyip nesneyi döndürebiliriz.
        for (Weapon w : weapons()) {
            if (id == w.getID()) {
                return w;
            }
        }
        return null;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getDamage() {
        return this.damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getCoin() {
        return this.coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }
}
