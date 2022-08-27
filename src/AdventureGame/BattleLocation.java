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
        int obsRandom=randomMonster();
        System.out.println("Burada yasamak icin oldurmelisin. Peki sen buna hazir misin?");
        // System.out.println("Dikkatli ol burada "+this.monster.getName()+" isimli canvarlar var");
        System.out.println("Ayrica burada " + obsRandom + " adet " + this.monster.getName() + " isimli canavar var");
        System.out.println("<S>avas veya <K>ac");
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
        }
        else {
            System.out.println("Canavardan kacarak korkak davrandiniz.");
        }
        return true;
    }
    public boolean war(int obsRandom) {
        int heal= getMonster().getHealth();
        for (int i = 0; i < obsRandom; i++) {
            this.getMonster().setHealth(heal); // Her bir for döngüsü başa aldığında canavarın canını fullemek için yazıldı.
            System.out.println(i+1+". canavar ile karsi karsiyasiniz");
            this.getPlayer().printcharacter();
            this.getMonster().printMonster();

            while (this.getPlayer().getHealth() > 0 && this.getMonster().getHealth() > 0) {
                System.out.println("<V>ur veya <K>ac");
                String run = input.nextLine().toUpperCase(); // Girdigimiz değeri direk büyük hale getiriyor.
                while (!run.equals("V") && !run.equals("K")) {
                    System.out.println("Yanlis secenek girdiniz,bir daha giriniz");
                    run = input.nextLine().toUpperCase();
                }
                if (run.equals("V")) {
                    this.getMonster().setHealth(this.getMonster().getHealth() - this.getPlayer().getDamage());
                    System.out.println("Siz vurdunuz");
                    System.out.println("Kalan Caniniz: " + this.getPlayer().getHealth());
                    System.out.println(this.getMonster().getName() + " kalan cani: " + this.getMonster().getHealth());
                    System.out.println();
                    if (this.getMonster().getHealth() > 0) {
                        this.getPlayer().setHealth(this.getPlayer().getHealth() - this.getMonster().getDamage());
                        System.out.println("Canavar vurdu");
                        System.out.println("Kalan Caniniz: " + this.getPlayer().getHealth());
                        System.out.println(this.getMonster().getName() + " kalan cani: " + this.getMonster().getHealth());
                        System.out.println();
                    }
                }
            }
            if (this.getPlayer().getHealth() <= 0) {
                return false;
            } else {
                System.out.println("TEBRIKLER Canavari oldurdunuz");
                this.getPlayer().setCoin(this.getMonster().getAward()+this.getPlayer().getCoin());      // Canavari oldurdukten sonra gelen parayi bakiyeye ekliyoruz.
                System.out.println("Yeni bakiyeniz: "+this.getPlayer().getCoin());
            }
        }
        return true;
    }

    public int randomMonster() {
        Random r = new Random();
        return r.nextInt(this.maxMonster) + 1;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }
}
