package com.ocp.zert;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;


public class AssessmentTest extends BaseTest {

    @Rule
    public TestName name = new TestName();

    @Before
    public void before() {

        System.out.printf("Running %s:%n", name.getMethodName());
    }

    @Test(expected = java.util.ConcurrentModificationException.class)
    public void q05() {

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

    }

    @Test(expected = java.nio.file.NoSuchFileException.class)
    public void q07() throws IOException {

        Path path1 = Paths.get("/bats/night", "../").resolve(Paths.get("./sleep.txt")).normalize();
        Path path2 = new File("../sleep.txt").toPath().toRealPath();

        System.out.println(Files.isSameFile(path1, path2));
        System.out.println("" + path1.equals(path2));

    }

    @Test
    public void q10() {

        Integer x = 10;
        x++;
        assert x == null && x >= 0;
        System.out.println(x);
    }

}





