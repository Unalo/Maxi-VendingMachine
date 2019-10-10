package vendingMachine;

import exceptions.ChocolateException;
import exceptions.ProductNotFoundException;
import exceptions.SaltySnacksException;
import exceptions.SoftDrinkException;
import products.Chocolate;
import products.Product;
import products.SaltySnack;
import products.SoftSDrink;

public class MaxiVendingMachine extends VendingMachine {

    @Override
    public void buy (Product product) throws ProductNotFoundException {
        if (product instanceof SoftSDrink) {
            if (stockSoftDrink == 0) {
                throw new SoftDrinkException();
            } else {
                stockSoftDrink -=1;
            }
        } else if (product instanceof SaltySnack) {
            if (stockSaltySnacks == 0 ) {
                throw new SaltySnacksException();
            } else {
                stockSaltySnacks -=1;
            }
        } else if (product instanceof Chocolate) {
            if (stockChocolate == 0 ) {
                throw new ChocolateException();
            } else {
                stockChocolate -=1;
            }
        }
    }

    public void buy (SaltySnack saltySnack) throws SaltySnacksException {
        if (stockSaltySnacks == 0) {
            throw new SaltySnacksException();
        } else {
            stockSaltySnacks -= 1;
        }
    }

    public void buy (SoftSDrink softSDrink) throws SoftDrinkException {
        if (stockSoftDrink == 0) {
            throw new SoftDrinkException();
        } else {
            stockSoftDrink -= 1;
        }
    }

    public void buy (Chocolate chocolate) throws ChocolateException {

        if (stockChocolate == 0) {
            throw new ChocolateException();
        } else {
            stockChocolate -= 1;
        }
    }


    public void addStock (Product product, int stock)  {
        if(product instanceof SoftSDrink){
            stockSoftDrink += stock;
        } else  if (product instanceof SaltySnack) {
            stockSaltySnacks += stock;
        } else if (product instanceof Chocolate) {
            stockChocolate += stock;
        }
    }

    public void addStock (SoftSDrink softSDrink ) {
        stockSoftDrink ++;
    }

    public void addStock (SaltySnack saltySnack ) {
        stockSaltySnacks ++;
    }

    public void addStock (Chocolate chocolate ) {
        stockChocolate++;
    }



}
