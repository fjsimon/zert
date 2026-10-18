package com.exempla.ars.supermarket;

import com.exempla.ars.supermarket.model.Product;

public interface SupermarketCatalog {

    void addProduct(Product product, double price);
    double getUnitPrice(Product product);
}
