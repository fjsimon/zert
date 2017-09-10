package com.oca.exam.exception;

public class TestClassQ57 {

    public static void main(String args[]){
        int k = 0;
        try{
            int i = 5/k;
        } catch (ArithmeticException e){
            System.out.println("1");
        } catch (RuntimeException e){
            System.out.println("2");
            return ;
        } catch (Exception e){
            System.out.println("3");
        } finally{
            System.out.println("4");
        }

        System.out.println("5");
    }
}