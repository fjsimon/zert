package com.exempla.ars.gathering.states;

import com.exempla.ars.gathering.VendingMachine;

public interface VendingMachineState {

    void proceed(VendingMachine vendingMachine);
}