package com.oca.exam.extra.features.collection.operations;

import com.oca.exam.extra.features.common.FuturamaCharacter;
import com.oca.exam.extra.features.common.Species;

import java.util.*;
import java.util.stream.Collectors;

public class CollectorsMethodsExample {

    public List<FuturamaCharacter> getFuturamaCharacters() {

        List<FuturamaCharacter> characters = Arrays.asList(
                new FuturamaCharacter("Bender", "Rodriguez", 5, Optional.of(Species.ROBOT)),
                new FuturamaCharacter("Philip", "Fry", 126, Optional.of(Species.HUMAN)),
                new FuturamaCharacter("Turanga", "Leela", 22, Optional.of(Species.MUTANT)),
                new FuturamaCharacter("Hubert", "Farnsworth", 161, Optional.of(Species.HUMAN)));

        System.out.println("Futurama characters:");
        characters.forEach(System.out::println);
        return characters;
    }

    public List<FuturamaCharacter> getYoungerThan100Years(List<FuturamaCharacter> characters) {

        System.out.println("\nYounger than 100 years:");
        List<FuturamaCharacter> youngerThan100Years = characters
                .stream()
                .filter(c -> c.getAge() < 100)
                // sorted by age DESC
                .sorted((c1, c2) -> c2.getAge().compareTo(c1.getAge()))
                //.collect(Collectors.toList());
                .collect(Collectors.toCollection(ArrayList::new));
        youngerThan100Years.forEach(System.out::println);
        return youngerThan100Years;
    }

    public Double getAverageAge(List<FuturamaCharacter> characters) {

        Double averageAge = characters
                .stream()
                .collect(Collectors.averagingInt(FuturamaCharacter::getAge));
        System.out.println("\nAverage age: " + averageAge);
        return averageAge;
    }

    public IntSummaryStatistics getSummaryStatistic(List<FuturamaCharacter> characters) {

        IntSummaryStatistics intSummaryStatistics = characters
                .stream()
                .collect(Collectors.summarizingInt(FuturamaCharacter::getAge));
        System.out.println("\nintSummaryStatistics: " + intSummaryStatistics);
        System.out.println("Sum of ages: " + intSummaryStatistics.getSum());
        return intSummaryStatistics;
    }

    public Map<Species, List<FuturamaCharacter>> getSpeciesToFuturamaCharactersMap(List<FuturamaCharacter> characters) {

        Map<Species, List<FuturamaCharacter>> speciesToFuturamaCharactersMap = characters
                .stream()
                .collect(Collectors.groupingBy(c -> c.getSpeciesEnum().get()));
        System.out.println("\nHumans: ");
        speciesToFuturamaCharactersMap.get(Species.HUMAN).forEach(System.out::println);
        return speciesToFuturamaCharactersMap;
    }

    public Map<Boolean, List<FuturamaCharacter>> getIsHumanToFuturamaCharactersMap(List<FuturamaCharacter> characters) {

        Map<Boolean, List<FuturamaCharacter>> isHumanToFuturamaCharactersMap = characters
                .stream()
                .collect(Collectors.partitioningBy(c -> Species.HUMAN.equals(c.getSpeciesEnum().get())));
        System.out.println("\nNon-humans: ");
        isHumanToFuturamaCharactersMap.get(Boolean.FALSE).forEach(System.out::println);
        return isHumanToFuturamaCharactersMap;
    }

    public String getFirstnames(List<FuturamaCharacter> characters) {

        String firstNames = characters
                .stream()
                .map(FuturamaCharacter::getFirstName)
                .sorted()
                .collect(Collectors.joining(", "));
        System.out.println("\nFirst names: " + firstNames);
        return firstNames;
    }

}
