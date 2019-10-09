package letscode;

import exceptions.ProductNotFoundException;
import exceptions.SoftDrinkException;
import org.junit.jupiter.api.Test;
import products.SoftSDrink;
import vendingMachine.VendingMachine;

import static letscode.CodeThis.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CodeThisTest {

    @Test
    public void shouldGreet() {
        SoftSDrink coke = new SoftSDrink("coke");
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.addStock(coke,5);
        try{
            vendingMachine.buy(coke);
            vendingMachine.buy(coke);
            vendingMachine.buy(coke);
            vendingMachine.buy(coke);
            vendingMachine.buy(coke);
            vendingMachine.buy(coke);
        }catch (ProductNotFoundException  e){
            e.printStackTrace();
        }

        assertEquals("Hello, Joe", greet("Joe"));
    }

    @Test
    public void shouldThrowException() {
        assertThrows(LetsCodeException.class,
                () -> greetFailure());
    }
}
