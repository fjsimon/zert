package com.design.pattern.creational.Factory;

public class TestFactory {

    public static void main(String[] args) {

        Computer pc = ComputerFactory.getComputer("pc","2 GB","500 GB","2.4 GHz").get();

        Computer server = ComputerFactory.getComputer("server","16 GB","1 TB","2.9 GHz").get();

        System.out.println("Factory PC Config::"+pc);
        System.out.println("Factory Server Config::"+server);
    }

}