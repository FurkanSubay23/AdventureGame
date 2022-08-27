package AdventureGame;

public abstract class Monster {
    private int ID;
    private String name;
    private int damage;
    private int health;
    int award;

    public Monster(int ID, String name, int damage, int health, int award) {
        this.ID = ID;
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.award = award;
    }

    public void printMonster() {
        System.out.println(this.name + " isimli canavarin ozellikleri");
        System.out.println("Canavarin hasari:\t" + this.getDamage() + "\t\tCanavarin cani:\t" + this.getHealth() + "\t\tCanavarin odulu:\t" + this.getAward());
        System.out.println();
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
        if (health <= 0) {
            this.health = 0;
        }
        this.health = health;
    }

    public int getAward() {
        return award;
    }

    public void setAward(int award) {
        this.award = award;
    }
}
