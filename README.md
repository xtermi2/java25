[![Java CI](https://github.com/xtermi2/java25/actions/workflows/maven.yml/badge.svg)](https://github.com/xtermi2/java25/actions/workflows/maven.yml)

# Schedule

- 2025/08/21 Final Release Candidate
- 2025/09/16 General Availability

# JDK 25 Features

- [JEP 470: PEM Encodings of Cryptographic Objects (Preview)](https://openjdk.org/jeps/470)
    - TODO
- [JEP 502: Stable Values (Preview)](https://openjdk.org/jeps/502)
    - TODO
- [JEP 503: Remove the 32-bit x86 Port](https://openjdk.org/jeps/503)
    - TODO
- [JEP 505: Structured Concurrency (Fifth Preview)](https://openjdk.org/jeps/505)
    - Simplify concurrent programming by introducing an API for structured concurrency. Structured concurrency treats
      groups of related tasks running in different threads as a single unit of work, thereby streamlining error handling
      and cancellation, improving reliability, and enhancing observability.
    - API changes since last preview in JDK 24:
      - StructuredTaskScope is now opened via static factory methods rather than public constructors
    - see example `StructuredConcurrency.java`
- [JEP 506: Scoped Values](https://openjdk.org/jeps/506)
    - Enable the sharing of immutable data within and across threads. They are preferred to thread-local variables,
      especially when using large numbers of virtual threads.
    - Unlike a thread-local variable, a scoped value is written once and is then immutable, and is available only for a
      bounded period during execution of the thread.
    - In effect, a scoped value is an implicit method parameter. It is "as if" every method in a sequence of calls has
      an additional, invisible, parameter. None of the methods declare this parameter and only the methods that have
      access to the scoped value object can access its value (the data). Scoped values make it possible to pass data
      securely from a caller to a faraway callee through a sequence of intermediate methods that do not declare a
      parameter for the data and have no access to the data.
    - changes since fourth preview in JDK 24:
        - The `ScopedValue.orElse` method no longer accepts `null` as its argument.
    - see example `ScopedValueServer.java`
- [JEP 507: Primitive Types in Patterns, instanceof, and switch (Third Preview)](https://openjdk.org/jeps/507)
    - TODO
- [JEP 508: Vector API (Tenth Incubator)](https://openjdk.org/jeps/508)
    - TODO
- [JEP 509: JFR CPU-Time Profiling (Experimental)](https://openjdk.org/jeps/509)
    - TODO
- [JEP 510: Key Derivation Function API](https://openjdk.org/jeps/510)
    - TODO
- [JEP 511: Module Import Declarations](https://openjdk.org/jeps/511)
    - TODO
- [JEP 512: Compact Source Files and Instance Main Methods](https://openjdk.org/jeps/512)
    - TODO
- [JEP 513: Flexible Constructor Bodies](https://openjdk.org/jeps/513)
    - TODO
- [JEP 514: Ahead-of-Time Command-Line Ergonomics](https://openjdk.org/jeps/514)
    - TODO
- [JEP 515: Ahead-of-Time Method Profiling](https://openjdk.org/jeps/515)
    - TODO
- [JEP 518: JFR Cooperative Sampling](https://openjdk.org/jeps/518)
    - TODO
- [JEP 519: Compact Object Headers](https://openjdk.org/jeps/519)
    - TODO
- [JEP 520: JFR Method Timing & Tracing](https://openjdk.org/jeps/520)
    - TODO
- [JEP 521: Generational Shenandoah](https://openjdk.org/jeps/521)
    - TODO

----------------------

##### Other References

- https://openjdk.org/projects/jdk/25/
