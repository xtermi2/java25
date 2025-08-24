String greeting = "Hello, World!";

public String greeting() {
    return greeting;
}

void main() {
    // java.io.IO static methods are no longer automatically imported since JDK 25
    IO.println(greeting());

    // use classes from java.base module, they are automatically import
    List<Serializable> list = new ArrayList<>();
    list.add(new HashMap<>());
    list.forEach(IO::println);
    File f = new File("test.txt");
    final Path path = f.toPath();
    System.out.println(path);
    Stream.of("a", "b", "c")
            .forEach(IO::println);
}
