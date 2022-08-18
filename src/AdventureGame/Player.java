package AdventureGame;

public class Player {
    private int ID;
    private String name;
    private int damage;
    private int health;
    private int coin;

    public Player(int ID, String name, int damage, int health, int coin) {
        this.ID = ID;
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.coin = coin;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    public static void setChar() {  // Karakter secme methodu

    }


    public static void properties(Player[] players) {   // Karakter ozellikleri yazdırma methodu.Polymorphism!
        for (Player player : players) {
            System.out.println("Karakterin ID:\t" + player.getID() + " Kakterin ismi:\t" + player.getName()
                    + "\t\tKarakterin hasari:\t" + player.getDamage() + " Karakterin cani:\t"
                    + player.getHealth() + " Karakterin parasi:\t" + player.getCoin());
        }
    }


}
