package com.exempla.ars.gathering.states;

import com.exempla.ars.gathering.VendingMachine;
import com.exempla.ars.gathering.entity.Product;

public class ProductSelectState implements VendingMachineState {

    @Override
    public void proceed(VendingMachine vendingMachine) {
        vendingMachine.displayProducts();
        vendingMachine.display("Select product: ");

        int selectedShelfNumber = vendingMachine.selectProductShelf();
        Product selectedProduct = vendingMachine.getProductInfo(selectedShelfNumber).get();

        vendingMachine.setState(new CoinsInsertState(selectedShelfNumber, selectedProduct)).proceed();
    }
}
