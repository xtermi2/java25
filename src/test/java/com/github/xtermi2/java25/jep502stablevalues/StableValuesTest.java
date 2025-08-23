package com.github.xtermi2.java25.jep502stablevalues;

import org.junit.jupiter.api.Test;

class StableValuesTest {

    @Test
    void access() {
        System.out.println("create StableValues instance in test");
        final StableValues stableValues = new StableValues();
        System.out.println("1st access StableValues instance in test");
        stableValues.access();

        System.out.println("2nd access StableValues instance in test");
        stableValues.access();
    }
}