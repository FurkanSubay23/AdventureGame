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

    public static Weapon[] weap() {        // Silahlarımızı böyle yaptırıyoruz.Dizi kullanarak
        Weapon[] weapons = {new Weapon("Tabanca", 1, 2, 10),
                new Weapon("Kilic", 2, 3, 35),
                new Weapon("Tufek", 3, 7, 45)};
        return weapons;
    }

    public static void print(Weapon[] weapons) {    // Bu method weaponları yazdırır.
        for (Weapon weapon : weapons) {
            System.out.println("Silahin ID si:\t" + weapon.getID() + "\tSilahin ismi\t" + weapon.getName()
                    + "\t\tSilahin hasari\t" + weapon.getDamage() + "\tSilahin degeri\t" + weapon.getCoin());
        }
    }

    public static Weapon getWeaponObjectID(int id) { // Bu method geriye id si eşit bir weapon dondurur.
        for (Weapon w : weap()) {
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
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }
}
