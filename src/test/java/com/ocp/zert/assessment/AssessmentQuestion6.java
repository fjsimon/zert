package com.ocp.zert.assessment;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

// immutable object pattern correct
public class AssessmentQuestion6 { // final
    private String name; // final
    private List<AssessmentQuestion6> ducklings; // final
    public AssessmentQuestion6(String name, List<AssessmentQuestion6> ducklings) {
        this.name = name;
        this.ducklings = new ArrayList<AssessmentQuestion6>(ducklings);
    }
    public String getName() { return name; }
    public List<AssessmentQuestion6> getDucklings() { return ducklings; } // ducklings
    public String hasDucklings(Predicate<AssessmentQuestion6> p) {
        return p.test(this) ? "Quack Quack": "";
    }
}