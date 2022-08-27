package AdventureGame;

import java.util.Scanner;

public class Game {
    private Scanner input = new Scanner(System.in);

    public void start() {

        System.out.println("Macera Oyununa Hosgeldiniz");
        System.out.println("Bu Karanlik ve Sisli Dunyada Kaybolacaksiniz!!!!");
        System.out.print("Lutfen bir karakter ismi giriniz ");
        //  String playerName = input.nextLine();
        Player player = new Player("Furkan");
        //   Shop shop = new Shop(player);
        System.out.println("############################################");

        System.out.println("Karakterler");
        GameChar[] list2 = {new Samurai(), new Archer(), new Knightly()};
        Player.properties(list2);
        player.selectChar();
        // player.selectLoc();
        // Location seçme.
        Location location = null;
        while (true) {
            player.printcharacter();
            System.out.println("Gitmek istediginiz bolgenin ID sini giriniz");
            System.out.println("0\tCikis\n1\tGuvenli ev\n2\tEsya Dukkani\n3\tMagara\n4\tOrman\n5\tNehir");
            int selectLocation = input.nextInt();
            switch (selectLocation) {
                case 0:
                    location = null;
                    break;
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new Shop(player);
                    break;
                case 3:
                    location=new Cave(player);
                    break;
                case 4:
                    location=new Forest(player);
                    break;
                case 5:
                    location=new River(player);
                    break;
                default:
                    location = new SafeHouse(player);
            }
            if (location == null) {
                System.out.println("Game Over, WHY GIVE UP");
                break;
            }
            if (!location.onLocation()) {
                System.out.println("GAME OVER!");
                break;
            }
        }
    }
}
