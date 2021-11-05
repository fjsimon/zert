package com.fjsimon.zert;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ReportingTest extends BaseTest {

    private static final List<String> MOVIES_TYPE = Arrays.asList("mp4", "avi", "wmv");
    private static final List<String> IMAGES_TYPE = Arrays.asList("jpg", "jpeg", "gif");
    private static final List<String> MUSIC_TYPE = Arrays.asList("mp3", "wma", "wav");

    private static String getCategory(String file) {
        String extension = file.substring(file.lastIndexOf(".") + 1);
        return MUSIC_TYPE.contains(extension) ? "music" :
                IMAGES_TYPE.contains(extension) ? "images" :
                        MOVIES_TYPE.contains(extension) ? "movies" : "other";
    }

    private static void process(String s, Map m) {
        String parts[] = s.split("\\s+");
        String category = getCategory(parts[0]);
        m.put(category, m.containsKey(category) ?
                (Integer) m.get(category) + Integer.parseInt(parts[1].substring(0, parts[1].length() - 1)) :
                Integer.parseInt(parts[1].substring(0, parts[1].length() - 1)));
    }

    public static String solution(String arg){
        Map<String, Integer> map = new HashMap<>();
        Arrays.stream(arg.split("\\n")).forEach(x -> process(x, map));
        return String.format("Music %sb%nMovies %sb%nImages %sb%nOther %sb%n" ,
                map.get("music"), map.get("movies"), map.get("images"), map.get("other"));
    }

    @Test
    public void reporting_test() {

        String arg = "track01.mp3 100450b\n" +
                "track02.wma 500450b\n" +
                "film01.avi 1005000b\n" +
                "doc01.txt 100b\n" +
                "pic01.jpg 1000b\n" +
                "track02.mp3 106700b\n" +
                "movie01.mp4 1767900b\n" +
                "movie02.wmv 3867900b\n" +
                "track03.wav 1000750b\n" +
                "pic02.gif 2456b\n" +
                "pic03.jpeg 5467b\n" +
                "other.doc 3455b";

        assertThat(solution(arg), is("Music 1708350b\nMovies 6640800b\nImages 8923b\nOther 3555b\n"));
    }
}