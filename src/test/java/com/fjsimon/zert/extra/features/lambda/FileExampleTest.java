package com.fjsimon.zert.extra.features.lambda;

import org.junit.Test;

import java.io.File;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class FileExampleTest {

    @Test
    public void fileTest() throws IOException {

        Path start = new File(".").toPath();
        int maxDepth = Integer.MAX_VALUE;
        BiPredicate<Path, BasicFileAttributes> topicDirectoriesMatcher =
                (path, basicFileAttributes) -> basicFileAttributes.isDirectory() && path.toString().contains("java");
        Stream<Path> pathStream = Files.find(start, maxDepth, topicDirectoriesMatcher);

        System.out.println("Topic directories ASC:");
        pathStream.sorted().forEach(System.out::println);

        List<Path> paths = Files.walk(start)
                .filter(p -> p.toString().contains("FileExampleTest.java"))
                .collect(Collectors.toList());

        assertThat(paths.get(0).toString(), is("./src/test/java/com/fjsimon/zert/extra/features/lambda/FileExampleTest.java"));

        System.out.println("\nFile content: ");
        Files.lines(paths.get(0), Charset.defaultCharset())
                .forEach(System.out::println);
    }
}
