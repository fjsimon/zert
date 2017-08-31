package com.oca.exam.core;

import org.hamcrest.CoreMatchers;
import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;

public class ArrayListExamplesTest {


    @Test
    public void creatingArrayList() {

        ArrayList list1 = new ArrayList();
        ArrayList list2 = new ArrayList(10);
        ArrayList list3 = new ArrayList(list2);
        ArrayList<String> list4 = new ArrayList<String>();
        ArrayList<String> list5 = new ArrayList<>();
        List<String> list6 = new ArrayList<>();
//        ArrayList<String> list7 = new List<>(); DOES NOT COMPILE

        assertThat(list1, instanceOf(ArrayList.class));
        assertThat(list2, instanceOf(ArrayList.class));
        assertThat(list3, instanceOf(ArrayList.class));
        assertThat(list4, instanceOf(ArrayList.class));
        assertThat(list5, instanceOf(ArrayList.class));
        assertThat(list6, instanceOf(ArrayList.class));
    }

    @Test
    public void addingToArrayList() {

        ArrayList list = new ArrayList();
        list.add("hawk");
        list.add(Boolean.TRUE);

        assertThat(list.size(), is(2));
        assertThat(list.get(0), is("hawk"));
        assertThat(list.get(1), is(true));

        ArrayList<String> stringArrayList = new ArrayList();
        stringArrayList.add("sparrow");
//        stringArrayList.add(Boolean.TRUE); // DOES NOT COMPILE
        assertThat(stringArrayList.size(), is(1));
        assertThat(stringArrayList.get(0), is("sparrow"));

        List<String> birds = new ArrayList();
        birds.add("hawk");
        birds.add(1, "robin");
        birds.add(0,"blue jay");
        birds.add(1, "cardinal");
        assertThat(birds.size(), is(4));
        assertThat(birds.get(0), is("blue jay"));
        assertThat(birds.get(1), is("cardinal"));
        assertThat(birds.get(2), is("hawk"));
        assertThat(birds.get(3), is("robin"));

    }

    @Test
    public void ArrayList_remove() {

        List<String> list = new ArrayList();
        list.add("hawk");
        list.add("hawk");
        assertThat(list.remove("cardinal"), is(false));
        assertThat(list.remove("hawk"), is(true));
        assertThat(list.remove(0), is("hawk"));
        assertThat(list.size(), is(0));
    }

    @Test
    public void ArrayList_set() {

        List<String> list = new ArrayList();
        list.add("hawk");
        assertThat(list.size(), is(1));
        list.set(0, "robin");
        assertThat(list.size(), is(1));

        try {
            list.set(1, "robin"); // indexOutOfBoundsException
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void ArrayList_isEmpty_size() {

        List<String> list = new ArrayList();
        assertThat(list.isEmpty(), is(true));
        assertThat(list.size(), is(0));
        list.add("hawk");
        list.add("hawk");
        assertThat(list.isEmpty(), is(false));
        assertThat(list.size(), is(2));
    }

    @Test
    public void ArrayList_clear() {

        List<String> list = new ArrayList();
        list.add("hawk");
        list.add("hawk");
        assertThat(list.isEmpty(), is(false));
        assertThat(list.size(), is(2));
        list.clear();
        assertThat(list.isEmpty(), is(true));
        assertThat(list.size(), is(0));
    }

    @Test
    public void ArrayList_contains() {

        List<String> list = new ArrayList();
        list.add("hawk");
        assertThat(list.contains("hawk"), is(true));
        assertThat(list.contains("robin"), is(false));
    }

    @Test
    public void ArrayList_equals() {

        List<String> one = new ArrayList();
        List<String> two = new ArrayList();
        assertThat(one.equals(two), is(true));
        one.add("a");
        assertThat(one.equals(two), is(false));
        two.add("a");
        assertThat(one.equals(two), is(true));
        one.add("b");
        two.add(0, "b");
        assertThat(one.equals(two), is(false));
    }

    @Test
    public void sorting() {

        List<Integer> numbers = new ArrayList();
        numbers.add(99);
        numbers.add(5);
        numbers.add(81);
        Collections.sort(numbers);


        for(int i = 0; i < numbers.size(); i++) {
            System.out.printf("%d\t", numbers.get(i));
            int j = i;
            if(j++ < numbers.size()-1) {
                assertThat(numbers.get(i) < numbers.get(j), Is.is(true));
            }
        }
    }

    @Test
    public void convertingListToArray() {

        List<String> list = new ArrayList();
        list.add("hawk");
        list.add("robin");
        Object [] objectArray = list.toArray();
        String [] stringArray = list.toArray(new String[0]);

        assertThat(objectArray.length, is(2));
        assertThat(objectArray, CoreMatchers.instanceOf(Object[].class));

        assertThat(stringArray.length, is(2));
        assertThat(stringArray, CoreMatchers.instanceOf(String[].class));

    }

    @Test
    public void convertingArrayToList() {

        String [] array = {"hawk", "robin"};
        List<String> arraylist = Arrays.asList(array);
        assertThat(arraylist, CoreMatchers.instanceOf(List.class));

        List<String> varlist = Arrays.asList("one", "two", "three");
        assertThat(varlist, CoreMatchers.instanceOf(List.class));
    }
}
