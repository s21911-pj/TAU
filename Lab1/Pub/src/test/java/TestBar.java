import org.junit.After;
import org.junit.Test;
import org.junit.Before;

import java.util.List;



public class TestBar {
    private PubService pubServiceUnderTest;



    @Before
    public void setUp(){

        pubServiceUnderTest = new PubService();

    }
    @Test
    public void addBeer(){
    pubServiceUnderTest.addBeer(3,"ddassadsa",300);
        System.out.println(pubServiceUnderTest.findById(3));
    }
    @Test
    public void testFindingBeers(){
        pubServiceUnderTest.addBeer(1,"fddfsfd",500);
        pubServiceUnderTest.findById(1);
        System.out.println(pubServiceUnderTest.findById(1));
    }
    @Test
    public void testDeleteBeer(){
        pubServiceUnderTest.addBeer(1,"dasdsasdsa",500);
        System.out.println("jest piwo");
        System.out.println(pubServiceUnderTest.findById(1));
        pubServiceUnderTest.deleteBeer(1);
        System.out.println("niema piwa");
        System.out.println(pubServiceUnderTest.findById(1));
    }
    @Test
    public void testFindingAllBeers(){
        pubServiceUnderTest.addBeer(1,"dsasdads",400);
        pubServiceUnderTest.addBeer(2,"dsasdads",400);
        pubServiceUnderTest.addBeer(3,"dsasdads",400);
        pubServiceUnderTest.addBeer(4,"dsasdads",400);
        pubServiceUnderTest.findAll();
        System.out.println(pubServiceUnderTest.findAll());
    }
    @Test
    public void testCreateOrder(){
        pubServiceUnderTest.addBeer(1,"sdasasdsa",200);
        pubServiceUnderTest.createOrder(List.of(1),"Pawel");

    }

    @After
    public void endTesting(){
        System.out.println("Next  test below : ");
    }

}
