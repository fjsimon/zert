package com.fjsimon.zert.methods.typeinference;

import com.fjsimon.zert.BaseTest;
import org.junit.Test;

public class TypeInferenceTest extends BaseTest {

    @Test
    public void typeInferenceTest() {

        Foo<Bar> foo = new Foo<>();

        foo.<String>apply(bar -> bar::setBar);

        // We omit the type String and Java compiler automatically infers
        // (from the method's argument) that the type parameter is String
        foo.apply(bar -> bar::setBar);
    }
}
