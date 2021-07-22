package com.fjsimon.zert.methods.typeinference;

import java.util.function.Consumer;
import java.util.function.Function;

class Foo<T> {
    <U> void apply(Function<T, Consumer<U>> bar) {}
}