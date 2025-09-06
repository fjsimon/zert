package com.ocp.zert.assessment;

public class AssessmentQuestion4<T>
{
    T value;

    public AssessmentQuestion4(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public static void main(String[] args) {
        AssessmentQuestion4<String> one = new AssessmentQuestion4<String>("a string");
        AssessmentQuestion4<Integer> two = new AssessmentQuestion4<>(123);
        System.out.print(one.getValue());
        System.out.print(two.getValue());
    }
}
