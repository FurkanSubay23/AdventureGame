package AdventureGame;

import java.util.Scanner;

public class Shop extends Location {

    public Shop(Player player) {
        super(player, "Shopify");
    }

    private Scanner input = new Scanner(System.in);

    //dk = 41.43 var seçme methodu.
    public void printTool() {

        while (true) {
            System.out.println("Magazaya Hosgeldiniz");
            System.out.println("Secim Yapiniz");
            System.out.println("1\tSilahlar\n2\tZirhlar\n3\tCikis yap");
            int tool = input.nextInt();
            switch (tool) {
                case 1:
                    Weapon.print(Weapon.weap());
                    this.player.outOfInventory();
                    break;
                case 2:
                    Armor.printArmor(Armor.armor());
                    break;
                case 3:
                    System.out.println("Gule Gule");
            }
            if (tool == 3) {
                break;
            }
        }
    }



    public Weapon buyWeapon() {         // Almak istedigimiz silahları söyler.
        System.out.println("Almak istediginiz silahin ID'sini giriniz");
        int id = input.nextInt();
        while (id > 3 && id < 1) {
            System.out.println("Yanlis secim tekrar deneyin");
            id = input.nextInt();
        }
        if (id == Weapon.getWeaponObjectID(id).getID())  {
            if (this.player.getCoin() > Weapon.getWeaponObjectID(id).getCoin()){
                return Weapon.getWeaponObjectID(id);
            }

        }
        System.out.println("Bakiye yetersiz");
        return null;

    }

}
