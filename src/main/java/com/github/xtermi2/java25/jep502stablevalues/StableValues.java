package com.github.xtermi2.java25.jep502stablevalues;

import java.util.function.Supplier;

public class StableValues {

    public StableValues() {
        System.out.println("StableValues init...");
    }

    // OLD
    private final SomeService someServiceOld = new SomeService("old");

    // NEW - Specifying initialization in the accessor method
    private final StableValue<SomeService> someServiceNew = StableValue.of();

    // NEW - Specifying initialization at the declaration site
    private final Supplier<SomeService> someServiceNewWithInit = StableValue.supplier(() -> new SomeService("new declaration"));

    private SomeService getSomeServiceNew() {
        return someServiceNew.orElseSet(() -> new SomeService("new accessor"));
    }

    public void access() {
        // OLD
        someServiceOld.doSomething();

        // NEW
        getSomeServiceNew().doSomething();

        // NEW with initialization at declaration site
        someServiceNewWithInit.get().doSomething();
    }
}
