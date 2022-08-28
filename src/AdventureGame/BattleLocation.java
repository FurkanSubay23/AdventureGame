package AdventureGame;

import java.util.Random;

public abstract class BattleLocation extends Location {
    private Monster monster;
    private String award;
    private int maxMonster;

    public BattleLocation(Player player, String name, Monster monster, String award, int maxMonster) {
        super(player, name);
        this.monster = monster;
        this.award = award;
        this.maxMonster = maxMonster;

    }

    @Override
    public boolean onLocation() {
        int obsRandom = randomMonster();
        System.out.println("Burada yasamak icin oldurmelisin. Peki sen buna hazir misin?");
        // System.out.println("Dikkatli ol burada "+this.monster.getName()+" isimli canvarlar var");
        System.out.println("Ayrica burada " + obsRandom + " adet " + this.monster.getName() + " isimli canavar var");
        System.out.println("<S>avas yada <K>ac");
        String run = input.nextLine().toUpperCase(); // Girdigimiz değeri direk büyük hale getiriyor.
        while (!run.equals("S") && !run.equals("K")) {
            System.out.println("Yanlis secenek girdiniz,bir daha giriniz");
            run = input.nextLine().toUpperCase();
        }
        if (run.equals("S")) {
            // Buraya Savas mekanikleri gelicek
            System.out.println("Savasacaksiniz");
            if (!war(obsRandom)) {
                System.out.println("Oldunuz");
            }
        } else {
            System.out.println("Canavardan kacarak korkak davrandiniz.");
        }
        return true;
    }

    public boolean war(int obsRandom) {
        int heal = getMonster().getHealth();
        for (int i = 0; i < obsRandom; i++) {
            int firstHit = firstHit();
            this.getMonster().setHealth(heal); // Her bir for döngüsü başa aldığında canavarın canını fullemek için yazıldı.
            System.out.println(i + 1 + ". canavar ile karsi karsiyasiniz");
            this.getPlayer().printcharacter();
            this.getMonster().printMonster();

            while (this.getPlayer().getHealth() > 0 && this.getMonster().getHealth() > 0) {
                System.out.println("<V>ur yada <K>ac");
                String run = input.nextLine().toUpperCase(); // Girdigimiz değeri direk büyük hale getiriyor.
                while (!run.equals("V") && !run.equals("K")) {
                    System.out.println("Yanlis secenek girdiniz,bir daha giriniz");
                    run = input.nextLine().toUpperCase();
                }
                if (run.equals("V")) {
                    if (firstHit == 0) {            // Yüzde 50 ihtimal var. eğer 0 ise player,1 ise canavar vuracak.
                        this.getMonster().setHealth(this.getMonster().getHealth() - this.getPlayer().getTotalDamage());
                        System.out.println("Siz vurdunuz");
                        System.out.println("Vurdugunuz hasar: " + this.getPlayer().getTotalDamage());
                        System.out.println("Kalan Caniniz: " + this.getPlayer().getHealth());
                        System.out.println(this.getMonster().getName() + " kalan cani: " + this.getMonster().getHealth());
                        System.out.println();
                        if (this.getMonster().getHealth() > 0) {
                            int durability = this.getMonster().getDamage() - this.getPlayer().getInventory().getArmor().getDodge();
                            this.getPlayer().setHealth(this.getPlayer().getHealth() - durability);
                            System.out.println("Canavar vurdu");
                            System.out.println("Canavarin vurdugu hasar: " + this.getMonster().getDamage());
                            System.out.println("Kalan Caniniz: " + this.getPlayer().getHealth());
                            System.out.println(this.getMonster().getName() + " kalan cani: " + this.getMonster().getHealth());
                            System.out.println();
                        }
                    }
                    if (firstHit == 1) {        // Yüzde 50 ihtimal var. eğer 0 ise player,1 ise canavar vuracak.
                        if (this.getPlayer().getHealth() > 0) {
                            int durability = this.getMonster().getDamage() - this.getPlayer().getInventory().getArmor().getDodge();
                            this.getPlayer().setHealth(this.getPlayer().getHealth() - durability);
                            System.out.println("Canavar vurdu");
                            System.out.println("Canavarin vurdugu hasar: " + this.getMonster().getDamage());
                            System.out.println("Kalan Caniniz: " + this.getPlayer().getHealth());
                            System.out.println(this.getMonster().getName() + " kalan cani: " + this.getMonster().getHealth());
                            System.out.println();
                        }
                        this.getMonster().setHealth(this.getMonster().getHealth() - this.getPlayer().getTotalDamage());
                        System.out.println("Siz vurdunuz");
                        System.out.println("Vurdugunuz hasar: " + this.getPlayer().getTotalDamage());
                        System.out.println("Kalan Caniniz: " + this.getPlayer().getHealth());
                        System.out.println(this.getMonster().getName() + " kalan cani: " + this.getMonster().getHealth());
                        System.out.println();
                    }
                } else {
                        System.out.println("Kacarak korkaklik yaptiniz");
                        break;
                    }
                    if (this.getPlayer().getHealth() <= 0) {
                        return false;
                    } else {
                        this.getPlayer().setCoin(this.getMonster().getAward() + this.getPlayer().getCoin());      // Canavari oldurdukten sonra gelen parayi bakiyeye ekliyoruz.
                        System.out.println("Yeni bakiyeniz: " + this.getPlayer().getCoin());
                    }
                    if (i == obsRandom - 1 && this.getMonster().getHealth() <= 0) {             // Böyle diyerek tum canavarların olduruldugunde verilen mesajı içeriyor.
                        System.out.println("Tebrikler " + this.getName() + " isimli lokasyon da bulunan tum canavarlari oldurdunuz!");
                        return true;
                    }
                }

            }
        return true;
        }


        public int firstHit () {    // İlk kimin vuracağını temsil ediyor.
            Random r = new Random();
            return r.nextInt(2);
        }

        public int randomMonster () {
            Random r = new Random();
            return r.nextInt(this.maxMonster) + 1;
        }

        public Monster getMonster () {
            return monster;
        }

        public void setMonster (Monster monster){
            this.monster = monster;
        }

        public String getAward () {
            return award;
        }

        public void setAward (String award){
            this.award = award;
        }
    }