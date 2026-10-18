package com.exempla.ars.supermarket.processor;

import com.exempla.ars.supermarket.model.Receipt;
import com.exempla.ars.supermarket.model.Request;

public interface OfferChecker {

    void check(Receipt receipt, Request request);
}
