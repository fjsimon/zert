package com.design.pattern.behavioral.Visitor;

public interface ShoppingCartVisitor {

    int visit(Book book);
    int visit(Fruit fruit);
}