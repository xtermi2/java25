[![Java CI](https://github.com/xtermi2/java25/actions/workflows/maven.yml/badge.svg)](https://github.com/xtermi2/java25/actions/workflows/maven.yml)

# Schedule

- 2025/08/21 Final Release Candidate
- 2025/09/16 General Availability

# JDK 25 Features

## [JEP 470: PEM Encodings of Cryptographic Objects (Preview)](https://openjdk.org/jeps/470)

- Introduce an API for encoding objects that represent cryptographic keys, certificates, and certificate revocation
  lists into the widely-used Privacy-Enhanced Mail (PEM) transport format, and for decoding from that format back into
  objects.
- Support standards — Support conversions between PEM text and cryptographic objects that have standard representations
  in the binary formats PKCS#8 (for private keys), X.509 (public keys, certificates, and certificate revocation lists),
  and PKCS#8 v2.0 (encrypted private keys and asymmetric keys).
- see example `PEMTest.java`

## [JEP 502: Stable Values (Preview)](https://openjdk.org/jeps/502)
- Introduce an API for stable values, which are objects that hold immutable data. Stable values are treated as constants by the JVM, enabling the same performance optimizations that are enabled by declaring a field final. Compared to final fields, however, stable values offer greater flexibility as to the timing of their initialization.
- see example `StableValues.java`

## [JEP 503: Remove the 32-bit x86 Port](https://openjdk.org/jeps/503)
- Remove the source code and build support for the 32-bit x86 port. This port was deprecated for removal in JDK 24 (JEP 501) with the express intent to remove it in a future release.
- No other 32-bit port for any other architecture is affected.

## [JEP 505: Structured Concurrency (Fifth Preview)](https://openjdk.org/jeps/505)
- Simplify concurrent programming by introducing an API for structured concurrency. Structured concurrency treats
      groups of related tasks running in different threads as a single unit of work, thereby streamlining error handling
      and cancellation, improving reliability, and enhancing observability.
- API changes since last preview in JDK 24:
  - StructuredTaskScope is now opened via static factory methods rather than public constructors
- see example `StructuredConcurrency.java`

## [JEP 506: Scoped Values](https://openjdk.org/jeps/506)
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

## [JEP 507: Primitive Types in Patterns, instanceof, and switch (Third Preview)](https://openjdk.org/jeps/507)
- Enhance pattern matching by allowing primitive type patterns in all pattern contexts, and extend instanceof and
      switch to work with all primitive types.
- No changes since second preview in JDK 24.
- see example `PrimitiveTypesInPatterns.java`

## [JEP 508: Vector API (Tenth Incubator)](https://openjdk.org/jeps/508)
- Introduce an API to express vector computations that reliably compile at runtime to optimal vector instructions on supported CPUs, thus achieving performance superior to equivalent scalar computations.
- The Vector API will incubate until necessary features
      of [Project Valhalla](https://openjdk.org/projects/valhalla/) become available as preview features. At
      that time, the Vector API will be adapted and its implementation to use them, and will be promoted from incubation
      to preview.

## [JEP 509: JFR CPU-Time Profiling (Experimental)](https://openjdk.org/jeps/509)
- Enhance the [JDK Flight Recorder (JFR)](https://dev.java/learn/jvm/jfr/) to capture more accurate CPU-time profiling information on Linux.
  - JDK Flight Recorder (JFR) is an observability and monitoring framework built into the HotSpot JVM. JFR has low overhead, an extensive API, and a large toolset that can provide deep insight into your applications and assist in development.
- To enable JFR on startup with this feature enabled, include the VM argument `-XX:StartFlightRecording=jdk.CPUTimeSample#enabled=true,filename=profile.jfr` to your java command.
  - open the `profile.jfr` file in a Java profiler such as [Java Mission Control (JMC)](https://www.oracle.com/java/technologies/javase/products-jmc8-downloads.html) or IntelliJ IDEA to analyze the recording.
  - Or simply use `jfr view cpu-time-hot-methods profile.jfr` for a quick look at the hottest methods in the recording.

## [JEP 510: Key Derivation Function API](https://openjdk.org/jeps/510)
- Introduce an API for Key Derivation Functions (KDFs), which are cryptographic algorithms for deriving additional keys from a secret key and other data.
- KDF is a building block of Hybrid Public Key Encryption (HPKE) which enables the smooth transition to quantum-safe encryption algorithms.
- no changes since preview in JDK 24.
- see `KeyDerivationFunctionAPI.java`

## [JEP 511: Module Import Declarations](https://openjdk.org/jeps/511)
- Enhance the Java programming language with the ability to succinctly import all of the packages exported by a
      module. This simplifies the reuse of modular libraries, but does not require the importing code to be in a module
      itself.
- No changes since second preview in JDK 24.
- See example `ModuleImportDeclaration.java`

## [JEP 512: Compact Source Files and Instance Main Methods](https://openjdk.org/jeps/512)
- Evolve the Java language so that beginners can write their first programs without needing to understand language
      features designed for large programs. Far from using a separate dialect of Java, beginners can write streamlined
      declarations for single-class programs and then seamlessly expand their programs to use more advanced features as
      their skills grow.
- changes since 4rd preview in JDK 24:
    - The new IO class for basic console I/O is now in the java.lang package rather than the java.io package.
    - The static methods of the IO class are no longer implicitly imported into compact source files. Thus invocations of these methods must name the class, e.g., IO.println("Hello, world!"), unless the methods are explicitly imported.
    - The implementation of the IO class is now based upon System.out and System.in rather than the java.io.Console class.
- see example `UnnamedClasses.java`

## [JEP 513: Flexible Constructor Bodies](https://openjdk.org/jeps/513)
- In constructors in the Java programming language, allow statements that do not reference the instance being
      created to appear before an explicit constructor invocation.
- No changes since 3rd preview in JDK 24.
- see example `FlexibleConstructorBodies.java`

## [JEP 514: Ahead-of-Time Command-Line Ergonomics](https://openjdk.org/jeps/514)
- Make it easier to create [ahead-of-time caches (JEP 483)](https://openjdk.org/jeps/483), which accelerate the startup of Java applications, by simplifying the commands required for common use cases.
- In JEP 483 you have to run java twice in order to create an AOT cache (see example in https://github.com/xtermi2/java24), this can now be done in one command for common use-cases:
- 1st recording run to create the cache `java -XX:AOTCacheOutput=app.aot -cp app.jar com.example.App`
- 2nd run the application with the cache `java -XX:AOTCache=app.aot -cp app.jar com.example.App`
```bash
./mvnw clean package
  
java -XX:AOTCacheOutput=target/app.aot --enable-preview --enable-native-access=ALL-UNNAMED -Dforeign.restricted=permit -cp target/java25-1.0-SNAPSHOT.jar
  
time java -XX:AOTCache=target/app.aot --enable-preview --enable-native-access=ALL-UNNAMED -Dforeign.restricted=permit -cp target/java25-1.0-SNAPSHOT.jar com.github.xtermi2.java25.jep511moduleimport.ModuleImportDeclaration
  
time java --enable-preview --enable-native-access=ALL-UNNAMED -Dforeign.restricted=permit -cp target/java25-1.0-SNAPSHOT.jar com.github.xtermi2.java25.jep511moduleimport.ModuleImportDeclaration
```

## [JEP 515: Ahead-of-Time Method Profiling](https://openjdk.org/jeps/515)
- Improve warmup time by making method-execution profiles from a previous run of an application instantly available, when the HotSpot Java Virtual Machine starts. This will enable the JIT compiler to generate native code immediately upon application startup, rather than having to wait for profiles to be collected.
- Uses the existing AOT workflow from JEP 515 and 483
- see example of JEP 514 above.

## [JEP 518: JFR Cooperative Sampling](https://openjdk.org/jeps/518)

- Improve the stability of the JDK Flight Recorder (JFR) when it asynchronously samples Java thread stacks. Achieve this
  by walking call stacks only at safepoints, while minimizing safepoint bias.

## [JEP 519: Compact Object Headers](https://openjdk.org/jeps/519)
- Reduce the size of object headers in the HotSpot JVM from between 96 and 128 bits down to 64 bits on 64-bit architectures. This will reduce heap size, improve deployment density, and increase data locality.
- Part of [project Lilliput](https://openjdk.org/projects/lilliput/)
- They have been tested at Oracle by running the full JDK test suite. They have also been tested at Amazon by hundreds of services in production, most of them using backports of the feature to JDK 21 and JDK 17.
- Various experiments demonstrate that enabling compact object headers improves performance:
  - In one setting, the SPECjbb2015 benchmark uses 22% less heap space and 8% less CPU time.
  - In another setting, the number of garbage collections done by SPECjbb2015 is reduced by 15%, with both the G1 and Parallel collectors.
  - A highly parallel JSON parser benchmark runs in 10% less time.
- It is not a goal to make compact object headers be the default object-header layout.
- activate via `-XX:+UseCompactObjectHeaders`

## [JEP 520: JFR Method Timing & Tracing](https://openjdk.org/jeps/520)
- Extend the JDK Flight Recorder (JFR) with facilities for method timing and tracing via bytecode instrumentation.
- Introduce two new JFR events, jdk.MethodTiming and jdk.MethodTrace. They both accept a filter to select the methods to time and trace.
- For example, to see what triggers the resize of a HashMap, you can configure the MethodTrace event's filter when making a recording and then use the `jfr` tool to display the recorded event:
  - `java -XX:StartFlightRecording:jdk.MethodTrace#filter=java.util.HashMap::resize,filename=profile.jfr ...`
  - ```bash
    jfr print --events jdk.MethodTrace --stack-depth 20 profile.jfr
    ```

## [JEP 521: Generational Shenandoah](https://openjdk.org/jeps/521)
- Change the generational mode of the Shenandoah garbage collector from an experimental feature to a product feature.
- Since experimental status in JDK 24 there have been implemented many stability and performance improvements.
- activate via `-XX:+UseShenandoahGC -XX:ShenandoahGCMode=generational`

----------------------

##### Other References

- https://openjdk.org/projects/jdk/25/
