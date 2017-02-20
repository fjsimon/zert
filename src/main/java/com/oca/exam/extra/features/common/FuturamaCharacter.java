package com.oca.exam.extra.features.common;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.util.Comparator;
import java.util.Optional;
import java.util.function.Function;
import static java.lang.String.format;

public class FuturamaCharacter {

    private String firstName;
    private String lastName;
    private String species = "human";
    private Optional<Species> speciesEnum;
    private int age = 0;

    public FuturamaCharacter(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public FuturamaCharacter(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public FuturamaCharacter(String firstName, String lastName, int age, Optional<Species> species) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.speciesEnum = species;
        if(species.isPresent()) {
            this.species = species.get().toString();
        }
    }

    public FuturamaCharacter(String firstName, String lastName, String species) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.species = species;
    }

    public FuturamaCharacter(String firstName, String lastName, Optional<Species> species) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.speciesEnum = species;
        if(species.isPresent()) {
            this.species = species.get().toString();
        }
    }

    public String getFullName(Function<FuturamaCharacter, String> function) {
        return function.apply(this);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSpecies() {
        return species;
    }

    public Optional<Species> getSpeciesEnum() {
        return speciesEnum;
    }

    public Integer getAge() {
        return age;
    }

    public boolean isAlienSpecies() {
        return "alien".equals(species);
    }

    public boolean isHumanSpecies() {
        return "human".equals(species);
    }

    @Override
    public String toString() {

        return format("%s %s [%s]", firstName, lastName, species);
    }

    public void print() {

        System.out.println(lastName + ", " + firstName);
    }

    public static class FirstNameAscComparator implements Comparator<FuturamaCharacter> {

        @Override
        public int compare(FuturamaCharacter o1, FuturamaCharacter o2) {
            return o1.getFirstName().compareTo(o2.getFirstName());
        }
    }

    @Override
    public boolean equals(Object o) {

        return EqualsBuilder.reflectionEquals(this, o);
    }

    @Override
    public int hashCode() {

        return HashCodeBuilder.reflectionHashCode(this);
    }
}