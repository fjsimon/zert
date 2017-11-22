package com.design.pattern.behavioral.Visitor;

public interface ItemElement {

    int accept(ShoppingCartVisitor visitor);
}
