package com.design.pattern.creational.Prototype;

import java.util.List;

public class PrototypePatternTest {

    public static void main(String[] args) throws CloneNotSupportedException {
        Employees emps = new Employees();
        emps.loadData();

        //Use the clone method to get the Employee object
        Employees empsNewAdded = (Employees) emps.clone();
        Employees empsNewRemoved = (Employees) emps.clone();
        List<String> listAdded = empsNewAdded.getEmpList();
        listAdded.add("John");
        List<String> listRemoved = empsNewRemoved.getEmpList();
        listRemoved.remove("Pankaj");

        System.out.println("emps List: " + emps.getEmpList());
        System.out.println("empsNewAdded List: " + listAdded);
        System.out.println("empsNewRemoved List: " + listRemoved);
    }
}