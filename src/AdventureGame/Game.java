package AdventureGame;

import java.util.Scanner;

public class Game {
    private Scanner input = new Scanner(System.in);

    public void start() {
        System.out.println("Macera Oyununa Hosgeldiniz");
        System.out.println("Bu Karanlik ve Sisli Dunyada Kaybolacaksiniz!!!!");
        System.out.print("Lutfen bir karakter ismi giriniz ");
        String playerName = input.nextLine();
        Player player = new Player(playerName);
        System.out.println("############################################");
        System.out.println("Karakterler");
        GameChar[] list2 = {new Samurai(), new Archer(), new Knightly()};
        Player.properties(list2);
        player.selectChar();
        System.out.println();
        System.out.println("Mekan secmeden magazaya ugramak ister misiniz?\n1\tEvet\n2\tHayir");
        int isTool = input.nextInt();
        if (isTool == 1) {
            Shop shop = new Shop(player);
            shop.printTool();
            player.outOfInventory();
        }


    }
}
