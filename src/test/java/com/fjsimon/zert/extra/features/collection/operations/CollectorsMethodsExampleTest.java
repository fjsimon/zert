package com.fjsimon.zert.extra.features.collection.operations;

import com.fjsimon.zert.extra.features.common.FuturamaCharacter;
import com.fjsimon.zert.extra.features.common.Species;
import org.junit.Test;

import java.util.IntSummaryStatistics;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CollectorsMethodsExampleTest {

    @Test
    public void futuramaCharactersCollectorsTest(){

        CollectorsMethodsExample ex = new CollectorsMethodsExample();
        List<FuturamaCharacter> characters = ex.getFuturamaCharacters();
        assertThat(characters.size(), is(4));
        assertThat(ex.getYoungerThan100Years(characters).size(), is(2));
        assertThat(ex.getAverageAge(characters), is(78.5));


        IntSummaryStatistics summaryStatistic = ex.getSummaryStatistic(characters);
        assertThat(summaryStatistic.getCount(), is(4L));
        assertThat(summaryStatistic.getSum(), is(314L));
        assertThat(summaryStatistic.getAverage(), is(78.5));
        assertThat(summaryStatistic.getMin(), is(5));
        assertThat(summaryStatistic.getMax(), is(161));

        assertThat(ex.getSpeciesToFuturamaCharactersMap(characters).get(Species.HUMAN).size(), is(2));
        assertThat(ex.getIsHumanToFuturamaCharactersMap(characters).get(Boolean.FALSE).size(), is(2));
        assertThat(ex.getFirstnames(characters), is("Bender, Hubert, Philip, Turanga"));
    }
}