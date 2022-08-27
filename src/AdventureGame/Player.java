package AdventureGame;

import java.util.Scanner;

public class Player {
    private int ID;
    private String name;
    private int damage;
    private int health;
    private int coin;
    private Inventory inventory;

    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();     // Bunu yaparak null hatasından kurtulduk. Çünkü başka yerden nesne almadığımızdan burada null nesne oluşturuyoruz.
    }


    private Scanner input = new Scanner(System.in);

    public Inventory getInventory() {
        return this.inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
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

    public int getDamage() {    // Burada bunu yaparak hem silahtan 2 tane almayı hemde başka method kullanmadan direk buradan yapmayı sağladık.
        return this.damage + this.getInventory().getWeapon().getDamage();
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

    public int getCoin() {
        return this.coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    Shop shop = new Shop(this);

    public void selectChar() {  // Karakter secme methodu
        boolean isChoose = true;
        while (isChoose) {
            System.out.println("Secmek istediginiz karakterin id sini giriniz");
            int choose = input.nextInt();
            switch (choose) {
                case 1 -> {
                    initPlayer(new Samurai());
                    isChoose = false;
                    break;
                }
                case 2 -> {
                    initPlayer(new Archer());
                    isChoose = false;
                    break;
                }
                case 3 -> {
                    initPlayer(new Knightly());
                    isChoose = false;
                    break;
                }
                default -> System.out.println("Yanlis secim yaptiniz, tekrar seciniz!");
            }

        }

       /* System.out.println(this.name + " isimli karakterinizin ozellikleri\n###############################");
        System.out.println();
        System.out.println("Kakterin ismi:\t" + this.getName()
                + "\t\tKarakterin hasari:\t" + this.getDamage() + "\t\tKarakterin cani:\t"
                + this.getHealth() + "\t\tKarakterin parasi:\t" + this.getCoin());
        System.out.println();

        */
    }

    void initPlayer(GameChar gameChar) {
        this.setName(gameChar.getName());
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setCoin(gameChar.getCoin());
    }

    public static void properties(GameChar[] gameChars) {   // Karakter ozellikleri yazdırma methodu.Polymorphism!
        for (GameChar gameChar : gameChars) {
            System.out.println("Karakterin ID:\t" + gameChar.getID() + "\t\tKakterin ismi:\t" + gameChar.getName()
                    + "\t\tKarakterin hasari:\t" + gameChar.getDamage() + "\t\tKarakterin cani:\t"
                    + gameChar.getHealth() + "\t\tKarakterin parasi:\t" + gameChar.getCoin());
        }
    }

    public void printcharacter() {
        System.out.println(this.name + " isimli karakterinizin ozellikleri");
        System.out.println("Karakterin silahi:\t" + this.getInventory().getWeapon().getName() + "\t\tKarakterin hasari:\t" + this.getDamage()
                + "\t\tKarakterin zirhi:\t" + this.getInventory().getArmor().getName() + "\t\tKarakterin bloklama degeri:\t" + this.getInventory().getArmor().getDodge()
                + "\t\tKarakterin cani:\t"
                + this.getHealth() + "\t\tKarakterin parasi:\t" + this.getCoin());
        System.out.println();
    }
}
