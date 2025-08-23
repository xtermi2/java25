package com.github.xtermi2.java25.jep511moduleimport;

// this will import e.g. all the classes from package java.util, java.util.stream, java.io, java.lang, java.nio.file

import module java.base;

public class ModuleImportDeclaration {
    static void main() {
        List<Serializable> list = new ArrayList<>();
        list.add(new HashMap<>());
        list.forEach(System.out::println);
        File f = new File("test.txt");
        final Path path = f.toPath();
        System.out.println(path);
        Stream.of("a", "b", "c")
                .forEach(System.out::println);
    }
}
