package com.exempla.ars.gathering;


import com.exempla.ars.gathering.entity.Product;
import com.exempla.ars.gathering.states.ProductSelectState;

class DemoApp {

    public static void main(String[] args) {

        new VendingMachine(10)
                .putProductsOnShelf(1, Product.COKE, 5)
                .putProductsOnShelf(2, Product.KOMBUCHA, 2)
                .putProductsOnShelf(3, Product.REDBULL, 5)
                .putProductsOnShelf(4, Product.WATER, 5)
                .putProductsOnShelf(5, Product.WATER, 5)
                .putProductsOnShelf(6, Product.MATUTANO_BOCA_BITS, 3)
                .putProductsOnShelf(7, Product.MATUTANO_FRITOS, 4)
                .putProductsOnShelf(8, Product.KITKAT, 2)
                .start(new ProductSelectState());
    }
}