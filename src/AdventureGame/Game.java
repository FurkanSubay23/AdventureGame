package AdventureGame;

import java.util.Scanner;

public class Game {
    private Scanner input = new Scanner(System.in);
    Player player=new Player()
    Samurai samurai = new Samurai();
    Archer archer = new Archer();           //Karakter nesneleri
    Knightly knightly = new Knightly();

    public void start() {
        System.out.println("Macera Oyununa Hosgeldiniz");
        System.out.println("Bu Karanlik ve Sisli Dunyada Kaybolacaksiniz!!!!");
        System.out.print("Lutfen bir karakter ismi giriniz ");
        String playerName = input.nextLine();
        System.out.println("############################################");
        System.out.println("Karakterler");
        Player[] list = {new Samurai(), new Archer(), new Knightly()};
        Player.properties(list);
        System.out.println("Secmek istediginiz karakterin id sini giriniz");
        int choose = input.nextInt();


    }
}
