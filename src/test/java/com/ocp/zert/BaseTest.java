package com.ocp.zert;

import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class BaseTest implements BeforeEachCallback {

    @Override
    public void beforeEach(ExtensionContext context) {

        System.out.printf("Running %s:%n", context.getDisplayName());
    }
}