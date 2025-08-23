[![Java CI](https://github.com/xtermi2/java25/actions/workflows/maven.yml/badge.svg)](https://github.com/xtermi2/java25/actions/workflows/maven.yml)

# Schedule

- 2025/08/21 Final Release Candidate
- 2025/09/16 General Availability

# JDK 25 Features

- [JEP 470: PEM Encodings of Cryptographic Objects (Preview)](https://openjdk.org/jeps/470)
    - Introduce an API for encoding objects that represent cryptographic keys, certificates, and certificate revocation lists into the widely-used Privacy-Enhanced Mail (PEM) transport format, and for decoding from that format back into objects.
    - Support standards — Support conversions between PEM text and cryptographic objects that have standard representations in the binary formats PKCS#8 (for private keys), X.509 (public keys, certificates, and certificate revocation lists), and PKCS#8 v2.0 (encrypted private keys and asymmetric keys).
    - see example `PEMTest.java`
- [JEP 502: Stable Values (Preview)](https://openjdk.org/jeps/502)
    - Introduce an API for stable values, which are objects that hold immutable data. Stable values are treated as constants by the JVM, enabling the same performance optimizations that are enabled by declaring a field final. Compared to final fields, however, stable values offer greater flexibility as to the timing of their initialization.
    - see example `StableValues.java`
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
    - Introduce an API to express vector computations that reliably compile at runtime to optimal vector instructions on supported CPUs, thus achieving performance superior to equivalent scalar computations.
    - The Vector API will incubate until necessary features
      of [Project Valhalla](https://openjdk.org/projects/valhalla/) become available as preview features. At
      that time, the Vector API will be adapted and its implementation to use them, and will be promoted from incubation
      to preview.
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
    - Reduce the size of object headers in the HotSpot JVM from between 96 and 128 bits down to 64 bits on 64-bit architectures. This will reduce heap size, improve deployment density, and increase data locality.
    - Part of [project Lilliput](https://openjdk.org/projects/lilliput/)
    - They have been tested at Oracle by running the full JDK test suite. They have also been tested at Amazon by hundreds of services in production, most of them using backports of the feature to JDK 21 and JDK 17.
    - Various experiments demonstrate that enabling compact object headers improves performance:
      - In one setting, the SPECjbb2015 benchmark uses 22% less heap space and 8% less CPU time.
      - In another setting, the number of garbage collections done by SPECjbb2015 is reduced by 15%, with both the G1 and Parallel collectors.
      - A highly parallel JSON parser benchmark runs in 10% less time.
    - It is not a goal to make compact object headers be the default object-header layout.
    - activate via `-XX:+UseCompactObjectHeaders`
- [JEP 520: JFR Method Timing & Tracing](https://openjdk.org/jeps/520)
    - TODO
- [JEP 521: Generational Shenandoah](https://openjdk.org/jeps/521)
    - TODO

----------------------

##### Other References

- https://openjdk.org/projects/jdk/25/
