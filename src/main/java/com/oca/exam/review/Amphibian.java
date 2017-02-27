package com.oca.exam.review;

import java.util.ArrayList;
import java.util.List;

interface CanSwim {
}

public class Amphibian implements CanSwim {
}

class Tadpole extends Amphibian {
}

class FindAllTadpole {
    public static void main(String[] args) {
        List<Tadpole> tadpoleList = new ArrayList<Tadpole>();
        for (Amphibian amphibian : tadpoleList) {
            CanSwim tadpole1 = amphibian;
            Amphibian tadpole2 = amphibian;
            Object tadpole3 = amphibian;
        }
    }
}
