package AdventureGame;

public class Inventory {
    Player player;
    String weaponName;
    String armorName;
    int weaponDamage;
    int armorDefence;
    int water;
    int food;

    public Inventory(Player player) {
        this.player = player;
    }

    Shop shop = new Shop(this.player);

    public int weaponInventor() {
        this.setWeaponDamage(shop.buyWeapon().getDamage());
        this.setWeaponName(shop.buyWeapon().getName());
        return getWeaponDamage();
    }

    public String getWeaponName() {
        return weaponName;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

    public String getArmorName() {
        return armorName;
    }

    public void setArmorName(String armorName) {
        this.armorName = armorName;
    }

    public int getWeaponDamage() {
        return weaponDamage;
    }

    public void setWeaponDamage(int weaponDamage) {
        this.weaponDamage = weaponDamage;
    }

    public int getArmorDefence() {
        return armorDefence;
    }

    public void setArmorDefence(int armorDefence) {
        this.armorDefence = armorDefence;
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }
}
