package com.oca.exam.exception;


public class TestClassQ65 {
    public static void main(String[] args) throws Exception{
        TestClassQ65 tc = new TestClassQ65();
        tc.myMethod();
    }

    public void myMethod() throws Exception{
        yourMethod();
    }

    public void yourMethod() throws Exception{
        throw new Exception();
    }
}
