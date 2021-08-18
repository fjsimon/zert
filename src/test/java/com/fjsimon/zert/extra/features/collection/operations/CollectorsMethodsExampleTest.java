package com.fjsimon.zert.extra.features.collection.operations;

import com.fjsimon.zert.common.FuturamaCharacter;
import com.fjsimon.zert.common.Species;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class CollectorsMethodsExampleTest {

    private final List<FuturamaCharacter> characters = Arrays.asList(
            new FuturamaCharacter("Bender", "Rodriguez", 5, Optional.of(Species.ROBOT)),
            new FuturamaCharacter("Philip", "Fry", 126, Optional.of(Species.HUMAN)),
            new FuturamaCharacter("Turanga", "Leela", 22, Optional.of(Species.MUTANT)),
            new FuturamaCharacter("Hubert", "Farnsworth", 161, Optional.of(Species.HUMAN)));

    @Test
    public void getYoungerThan100Years() {

        System.out.println("\nYounger than 100 years:");
        List<FuturamaCharacter> youngerThan100Years = characters
                .stream()
                .filter(c -> c.getAge() < 100)
                // sorted by age DESC
                .sorted((c1, c2) -> c2.getAge().compareTo(c1.getAge()))
                //.collect(Collectors.toList());
                .collect(Collectors.toCollection(ArrayList::new));
        youngerThan100Years.forEach(System.out::println);

        assertThat(youngerThan100Years.size(), is(2));
    }

    @Test
    public void getAverageAge() {

        Double averageAge = characters
                .stream()
                .collect(Collectors.averagingInt(FuturamaCharacter::getAge));
        System.out.println("\nAverage age: " + averageAge);

        assertThat(averageAge, is(78.5));
    }

    @Test
    public void getSummaryStatistic() {

        IntSummaryStatistics intSummaryStatistics = characters
                .stream()
                .collect(Collectors.summarizingInt(FuturamaCharacter::getAge));
        System.out.println("\nintSummaryStatistics: " + intSummaryStatistics);
        System.out.println("Sum of ages: " + intSummaryStatistics.getSum());

        assertThat(intSummaryStatistics.getCount(), is(4L));
        assertThat(intSummaryStatistics.getSum(), is(314L));
        assertThat(intSummaryStatistics.getAverage(), is(78.5));
        assertThat(intSummaryStatistics.getMin(), is(5));
        assertThat(intSummaryStatistics.getMax(), is(161));
    }

    @Test
    public void getSpeciesToFuturamaCharactersMap() {

        Map<Species, List<FuturamaCharacter>> speciesToFuturamaCharactersMap = characters
                .stream()
                .collect(Collectors.groupingBy(c -> c.getSpeciesEnum().get()));
        System.out.println("\nHumans: ");
        speciesToFuturamaCharactersMap.get(Species.HUMAN).forEach(System.out::println);

        assertThat(speciesToFuturamaCharactersMap.get(Species.HUMAN).size(), is(2));
        assertThat(speciesToFuturamaCharactersMap.get(Species.MUTANT).size(), is(1));
        assertThat(speciesToFuturamaCharactersMap.get(Species.ROBOT).size(), is(1));
    }

    @Test
    public void getIsHumanToFuturamaCharactersMap() {

        Map<Boolean, List<FuturamaCharacter>> isHumanToFuturamaCharactersMap = characters
                .stream()
                .collect(Collectors.partitioningBy(c -> Species.HUMAN.equals(c.getSpeciesEnum().get())));
        System.out.println("\nNon-humans: ");
        isHumanToFuturamaCharactersMap.get(Boolean.FALSE).forEach(System.out::println);

        assertThat(isHumanToFuturamaCharactersMap.get(Boolean.FALSE).size(), is(2));
    }

    @Test
    public void getFirstnames() {

        String firstNames = characters
                .stream()
                .map(FuturamaCharacter::getFirstName)
                .sorted()
                .collect(Collectors.joining(", "));
        System.out.println("\nFirst names: " + firstNames);

        assertThat(firstNames, is("Bender, Hubert, Philip, Turanga"));
    }
}