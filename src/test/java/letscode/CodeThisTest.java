package letscode;

import exceptions.ChocolateException;
import exceptions.ProductNotFoundException;
import exceptions.SaltySnacksException;
import exceptions.SoftDrinkException;
import org.junit.jupiter.api.Test;
import products.Chocolate;
import products.Product;
import products.SaltySnack;
import products.SoftSDrink;

import vendingMachine.MaxiVendingMachine;

import static letscode.CodeThis.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CodeThisTest {

    @Test
    public void shouldBuySoftDrinkFromMaxiMachine() {

        SoftSDrink fanta = new SoftSDrink("barOne");
        MaxiVendingMachine maxiMachine = new MaxiVendingMachine();
        maxiMachine.addStock(fanta);
        try{
            maxiMachine.buy(fanta);
        }catch (SoftDrinkException  e){
            e.printStackTrace();
        }
        assertEquals(0, maxiMachine.getStock(fanta));
    }

    @Test
    public void shouldBuyChocolateFromMaxiMachine() {

        Chocolate barOne = new Chocolate("barOne");
        MaxiVendingMachine maxiMachine = new MaxiVendingMachine();
        maxiMachine.addStock(barOne,5);
        SoftSDrink coke = new SoftSDrink("coke");
        maxiMachine.addStock(coke);
        try{

            maxiMachine.buy(barOne);
            maxiMachine.buy(barOne);
            maxiMachine.buy(barOne);
            maxiMachine.buy(barOne);
            maxiMachine.buy(barOne);

            maxiMachine.getStock(barOne);
        }catch (ChocolateException e){
            e.printStackTrace();
        }
        assertEquals(0, maxiMachine.getStock(barOne));
    }

    @Test
    public void shouldBuySaltySnackFromMaxiMachine() {

        SaltySnack popcorn = new SaltySnack("popcorn");
        MaxiVendingMachine maxiMachine = new MaxiVendingMachine();
        maxiMachine.addStock(popcorn);
        try{
            maxiMachine.buy(popcorn);
            maxiMachine.getStock(popcorn);
        }catch (SaltySnacksException  e){
            e.printStackTrace();
        }
        assertEquals(0, maxiMachine.getStock(popcorn));
    }

    @Test
    public void shouldThrowExceptionForSoftDrink() {
        SoftSDrink cola = new SoftSDrink("cola");

        MaxiVendingMachine maxiMachine = new MaxiVendingMachine();

        maxiMachine.addStock(cola, 5);

        try{
            maxiMachine.buy(cola);
            maxiMachine.buy(cola);
            maxiMachine.buy(cola);
            maxiMachine.buy(cola);
            maxiMachine.buy(cola);
            maxiMachine.buy(cola);

        }  catch (SoftDrinkException ex) {
            ex.printStackTrace();
        }
        assertEquals(0, maxiMachine.getStock(cola));
    }


    @Test
    public void shouldThrowExceptionForSaltySnack() {

        SaltySnack popcorn = new SaltySnack("popcorn");

        MaxiVendingMachine maxiMachine = new MaxiVendingMachine();

        maxiMachine.addStock(popcorn, 5);

        try{
            maxiMachine.buy(popcorn);
            maxiMachine.buy(popcorn);
            maxiMachine.buy(popcorn);
            maxiMachine.buy(popcorn);
            maxiMachine.buy(popcorn);
            maxiMachine.buy(popcorn);

        } catch (SaltySnacksException ex) {
            ex.printStackTrace();
        }
        assertEquals(0, maxiMachine.getStock(popcorn));
    }


    @Test
    public void shouldThrowExceptionForChocolate() {

        Chocolate barOne = new Chocolate("barOne");

        MaxiVendingMachine maxiMachine = new MaxiVendingMachine();

        maxiMachine.addStock(barOne,5);

        try{
            maxiMachine.buy(barOne);
            maxiMachine.buy(barOne);
            maxiMachine.buy(barOne);
            maxiMachine.buy(barOne);
            maxiMachine.buy(barOne);
            maxiMachine.buy(barOne);

        } catch (ChocolateException  ex) {
            ex.printStackTrace();
        }
        assertEquals(0, maxiMachine.getStock(barOne));
    }

    @Test
    public void shouldThrowException() {
        MaxiVendingMachine maxiVendingMachine = new MaxiVendingMachine();

        SoftSDrink fanta = new SoftSDrink("fanta");

        maxiVendingMachine.addStock(fanta);

//        maxiVendingMachine.buy(fanta);
        assertThrows(LetsCodeException.class, () -> greetFailure());
    }
}
