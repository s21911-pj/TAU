import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;




public class PubService {
    private List<Beer> beerList = new ArrayList<>();
    public PubService() {

    }
    public List<Beer> findAll() {

        return this.beerList;

    }
    public void addBeer(int id, String name, int size) {

        beerList.add(new Beer(id, name, size));

    }
    public void beerServe(int id, String custommerName) {

        Optional<Beer> optionalBeer = findById(id);

        if (optionalBeer.isPresent()) {

            System.out.println("Serving " + optionalBeer.get() + " to " + custommerName);

            deleteBeer(id);

        } else {

            System.out.println("Beer not found");

        }

    }
    public Optional<Beer> findById(int id) {

        return beerList.stream().filter(beer -> beer.getId() == id).findFirst();

    }
    public void deleteBeer(int id) {

        findById(id).ifPresentOrElse(

                beer -> beerList.remove(beer),

                () -> System.out.println("Beer not found")

        );

    }
    public void createOrder(List<Integer> ids, String customer) {

        List<Optional<Beer>> listOfBeers = ids.stream().map(this::findById).collect(Collectors.toList());

        orderBeers(listOfBeers, customer);

    }
    public void orderBeers(List<Optional<Beer>> beersToOrder, String custommerName) {

        if (beersToOrder.size() >= 5) {

            System.out.println("Panu juz dziekujemy");

        } else {

            Table table = new Table();

            beersToOrder.forEach(beer -> {

                if (beer.isPresent()) {

                    System.out.println("Serving " + beer.get() + " to " + custommerName);

                    table.setClean(false);

                    deleteBeer(beer.get().getId());

                } else {

                    System.out.println("Beer not found");

                }




            });

        }

    }




}


