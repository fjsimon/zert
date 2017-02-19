package com.oca.exam.extra.features.functional.interfaces;

import com.oca.exam.extra.features.common.FuturamaCharacter;

import java.util.function.Consumer;

public class InvertedFullNameConsumer implements Consumer<FuturamaCharacter> {

    @Override
    public void accept(FuturamaCharacter c) {
        c.setLastName(c.getLastName().toUpperCase()); // Introducing a side effect
        System.out.println(c.getLastName() + ", " + c.getFirstName());
    }
}
