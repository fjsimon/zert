package com.design.pattern.behavioral.ChainOfResponsability;

public interface DispenseChain {

    void setNextChain(DispenseChain nextChain);

    void dispense(Currency cur);
}
