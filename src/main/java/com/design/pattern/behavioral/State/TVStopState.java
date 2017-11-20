package com.design.pattern.behavioral.State;

public class TVStopState implements State {

    @Override
    public void doAction() {
        System.out.println("TV is turned OFF");
    }

}