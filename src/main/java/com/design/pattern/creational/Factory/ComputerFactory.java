package com.design.pattern.creational.Factory;

import java.util.Optional;

public class ComputerFactory {

    public static Optional<Computer> getComputer(String type, String ram, String hdd, String cpu){

        if("PC".equalsIgnoreCase(type)) {
            return Optional.of(new PC(ram, hdd, cpu));
        } else if("Server".equalsIgnoreCase(type)){
            return Optional.of(new Server(ram, hdd, cpu));
        }

        return Optional.empty();
    }
}