package AdventureGame;

import java.util.Scanner;

public class Shop extends NormalLocation {

    public Shop(Player player) {
        super(player, "Shopify");
    }

    @Override
    public boolean onLocation() {
        boolean showMenu = true;
        while (showMenu) {
            System.out.println("Magazaya hosgeldiniz");
            System.out.println("1\tSilahlar\n2\tZirhlar\n3\tCikis yap");
            int selectCase = input.nextInt();
            while (selectCase < 1 && selectCase > 3) {
                System.out.println("Yanlis secim yaptiniz, tekrar deneyiniz");
                selectCase = input.nextInt();
            }
            switch (selectCase) {
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    break;
                case 3:
                    System.out.println("Bir daha bekleriz");
                    showMenu = false;
                    return true;
            }
        }
        return true;
    }

    public void printWeapon() {
        System.out.println("Silahlar");
        for (Weapon weapon : Weapon.weapons()) {
            System.out.println("Silahin ID si:\t" + weapon.getID() + "\tSilahin ismi\t" + weapon.getName()
                    + "\t\tSilahin hasari\t" + weapon.getDamage() + "\tSilahin degeri\t" + weapon.getCoin());
        }
        System.out.println("0\t Cikis Yap");
    }

    public void buyWeapon() {
        System.out.println();
        System.out.print("Almak istediginiz silahin ID sini giriniz: ");
        int selectWeaponID = input.nextInt();
        while (selectWeaponID < 0 || selectWeaponID > Weapon.weapons().length) {
            System.out.println("Yanlis deger girdiniz, tekrar giriniz");
            selectWeaponID = input.nextInt();
        }
        if (selectWeaponID != 0) {      // Bunu yaparak 0 a tıklayınca cıkmasını saglıyoruz.
            Weapon selectWeapon = Weapon.getWeaponObjectID(selectWeaponID);
            // Satın almanın gerçekleştiği alan.
            if (selectWeapon != null) {
                if (selectWeapon.getCoin() > this.getPlayer().getCoin()) {
                    System.out.println("Bakiyeniz yetmemektedir");
                } else {
                    System.out.println("Satin aldiginiz silah: " + selectWeapon.getName());
                    int balance = (this.getPlayer().getCoin()) - (selectWeapon.getCoin());
                    this.getPlayer().setCoin(balance);
                    System.out.println("Kalan paraniz: " + this.getPlayer().getCoin());
                    System.out.println("Eski silahiniz: " + this.getPlayer().getInventory().getWeapon().getName());
                    System.out.println();
                    this.getPlayer().getInventory().setWeapon(selectWeapon);
                    System.out.println("Yeni silahiniz: " + this.getPlayer().getInventory().getWeapon().getName());
                }
            }
        }
    }

    public void printArmor() {
        System.out.println("Zirhlar");
        for (Armor armor : Armor.armor()) {
            System.out.println("Zirhin ID si:\t" + armor.getId() + "\t\tZirhin ismi:\t" + armor.getName() + "\t\tZirhin engellemesi\t" + armor.getDodge() +
                    "\tZirhin degeri\t" + armor.getCoin());
        }
        System.out.println("0\t Cikis Yap");

    }

    public void buyArmor() {
        System.out.println("Almak istediginiz zirhin degerini girin");
        int selectArmorID = input.nextInt();
        while (selectArmorID < 0 || selectArmorID > 3) {
            System.out.println("Yanlis deger girdiniz tekrar girin");
            selectArmorID = input.nextInt();
        }
        if (selectArmorID != 0) {        // Bunu yaparak 0 a tıklayınca cıkmasını saglıyoruz.
            Armor selectArmor = Armor.getArmorObjectID(selectArmorID);
            if (selectArmor != null) {
                if (selectArmor.getCoin() > this.getPlayer().getCoin()) {
                    System.out.println("Bakiyeniz yetersiz");
                } else {
                    System.out.println("Satin aldiginiz zirh: " + selectArmor.getName());
                    this.getPlayer().setCoin(this.getPlayer().getCoin() - selectArmor.getCoin());
                    System.out.println("Kalan paraniz: " + this.getPlayer().getCoin());
                    System.out.println("Eski zirhiniz: " + this.getPlayer().getInventory().getArmor().getName());
                    this.getPlayer().getInventory().setArmor(selectArmor);
                    System.out.println("Yeni zirhiniz: " + this.getPlayer().getInventory().getArmor().getName());
                }
            }
        }
    }
}
