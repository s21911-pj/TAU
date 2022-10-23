import java.util.List;

public class Main {
    public static void main(String[] args) {

        PubService pubService = new PubService();

        pubService.addBeer(1, "harnas", 500);

        pubService.addBeer(2, "warka", 500);

        pubService.addBeer(3, "okocim", 500);

        pubService.addBeer(4, "harde", 500);

        pubService.addBeer(5, "lech", 500);

        pubService.addBeer(6, "perla", 500);


        pubService.createOrder(List.of(1), "Michał");

        pubService.createOrder(List.of (5),"ha");

        pubService.createOrder(List.of(2),"Rafal");

       // System.out.println(pubService.findAll());

    }

}
