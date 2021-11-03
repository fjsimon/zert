package com.fjsimon.zert.methods;

import com.fjsimon.zert.BaseTest;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ReferenceTest extends BaseTest {

    @Test
    public void reference_test() {
        int[] a = {1};
        ReferenceTest t = new ReferenceTest();
        t.incrementContent(a);
        System.out.printf("a[a.length - 1] = %s%n", a[a.length - 1]);
        assertThat(a[a.length - 1], is(2));
    }

    @Test
    public void reference_change_test() {
        int[] a = {1};
        ReferenceTest t = new ReferenceTest();
        t.incrementChangeRef(a);
        System.out.printf("a[a.length - 1] = %s%n", a[a.length - 1]);
        assertThat(a[a.length - 1], is(1));
        assertThat(a.length, is(1));
    }

    void incrementContent(int[] arr) {

        // If we change the content of arr.
        arr[arr.length - 1]++;  // Will change the content of array
    }

    void incrementChangeRef(int[] arr) {
        // If we change the reference
        arr = new int[2];  // Will not change the array in main()
        arr[0] = 15;
    }
}
