package com.ocp.zert;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

@ExtendWith(BaseTest.class)
public class AssessmentTest {

    @Test()
    public void q05() {

        Assertions.assertThrows(java.util.ConcurrentModificationException.class, () -> {
            List<Integer> source = new ArrayList<>(Arrays.asList(1,2,3,4));
            List<Integer> fish = new CopyOnWriteArrayList<>(source);
            List<Integer> mammals = Collections.synchronizedList(source);
            Set<Integer> birds = new ConcurrentSkipListSet<>();
            birds.addAll(source);
            synchronized(new Integer(10)) {
                for(Integer f: fish) fish.add(4); // c1
                for(Integer m: mammals) mammals.add(4); // c2
                for(Integer b: birds) birds.add(5); // c3
                System.out.println(fish.size()+" "+mammals.size()+" "+birds.size());
            }
        });
    }

    @Test()
    public void q07() throws IOException {

        Assertions.assertThrows(java.nio.file.NoSuchFileException.class, () -> {
            Path path1 = Paths.get("/bats/night", "../").resolve(Paths.get("./sleep.txt")).normalize();
            Path path2 = new File("../sleep.txt").toPath().toRealPath();

            System.out.println(Files.isSameFile(path1, path2));
            System.out.println("" + path1.equals(path2));
        });
    }

    @Test()
    public void q10() {

        Assertions.assertThrows(AssertionError.class, () -> {
            Integer x = 10;
            x++;
            assert x == null && x >= 0;
            System.out.println(x);
        });
    }


    @Test()
    public void q13() {

        Assertions.assertThrows(NullPointerException.class, () -> {
            String line;
            Console c = System.console();
            if ((line = c.readLine()) != null)
                System.out.println(line);
        });
    }

    @Test
    public void q16() {

        String d = Duration.ofDays(1).toString();
        String p = Period.ofDays(1).toString();
        System.out.printf("%s %s \n", d, p);
        boolean b1 = d == p;
        boolean b2 = d.equals(p);
        System.out.println(b1 + " " + b2);
    }

    @Test
    public void q18() throws Exception {

//        Set<? extends RuntimeException> set1 = new HashSet<? extends RuntimeException>();
//        Set<? extends RuntimeException> set2 = new HashSet<Exception>();
        Set<? extends RuntimeException> set3 = new TreeSet<RuntimeException>();
        Set<? extends RuntimeException> set4 = new TreeSet<NullPointerException>();
    }

    @Test
    public void q20() throws Exception {

        Stream<LocalDate> s = Stream.of(LocalDate.now());
        UnaryOperator<LocalDate> u = l -> l;
        s.filter(l -> l != null).map(u).peek(System.out::println);
    }

}





