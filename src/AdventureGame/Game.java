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
            System.out.println("0\tCikis\n1\tGuvenli ev\n2\tEsya Dukkani\n3\tMagara\n4\tOrman\n5\tNehir\n6\tMaden");
            int selectLocation = input.nextInt();
            boolean isPassLocation = true;      // Bolumu bır daha oynamaması için bool tipi dönduren veri tip.
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
                    if (player.getInventory().getFood().equals("Food")) {
                        System.out.println("Siz zaten bu bolumu gecerek " + player.getInventory().getFood() + " isimli odulun sahibi oldunuz. Bir daha giremezsiniz!!!");
                        isPassLocation = false;
                        break;
                    }
                    location = new Cave(player);
                    break;
                case 4:
                    if (player.getInventory().getFirewood().equals("Firewood")) {
                        System.out.println("Siz zaten bu bolumu gecerek " + player.getInventory().getFirewood() + " isimli odulun sahibi oldunuz. Bir daha giremezsiniz!!!");
                        isPassLocation = false;
                        break;
                    }
                    location = new Forest(player);
                    break;
                case 5:
                    if (player.getInventory().getWater().equals("Water")) {
                        System.out.println("Siz zaten bu bolumu gecerek " + player.getInventory().getWater() + " isimli odulun sahibi oldunuz. Bir daha giremezsiniz!!!");
                        isPassLocation = false;
                        break;
                    }
                    location = new River(player);
                    break;
                case 6:
                    if (player.getInventory().getSnake().equals("treasury")) {
                        System.out.println("Siz zaten bu bolumu gecerek isimli odulun sahibi oldunuz. Bir daha giremezsiniz!!!");
                        isPassLocation = false;
                        break;
                    }
                    location = new Mine(player);
                    break;
                default:
                    System.out.println("Dogru secenegi secin Lutfen");
                    break;
            }
            if (location == null && selectLocation == 0) {
                System.out.println("Game Over, WHY GIVE UP");
                break;
            }
            if (isPassLocation) {
                if (!location.onLocation()) {
                    System.out.println("GAME OVER!");
                    break;
                }
            }
        }
    }
}
