package com.example;

import org.junit.Test;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import com.example.streams.StreamsClass;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class StreamTest {
    
    Set<String> set = Set.of(
            "Elkhart Lake",
            "North Canton",
            "Hammondsport",
            "Reno",
            "Bristol",
            "Manchester",
            "Norcross",
            "Indianapolis",
            "Laurinburg",
            "Salt Lake City"
        );

    // Задание 1
    @Test 
    public void listToAvrTest() {
        StreamsClass streamsClass = new StreamsClass();
        List<Integer> listToAvr0 = List.of(0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        List<Integer> listToAvr1 = List.of(1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
        assertEquals(5.0, streamsClass.getAverage(listToAvr0), 0.1);
        assertEquals(-4.0, streamsClass.getAverage(listToAvr1), 0.1);
    }

    // Задание 2
    @Test
    public void setToMapTest() {
        StreamsClass streamsClass = new StreamsClass();
        Map<String, String> expectMap = new HashMap<>();
        expectMap.put("Salt Lake City", "14");
        expectMap.put("Hammondsport", "12");
        expectMap.put("Elkhart Lake", "12");
        expectMap.put("North Canton", "12");
        expectMap.put("Indianapolis", "12");

        assertEquals(expectMap, streamsClass.setToMap(set));
    }

    // Задание 3
    @Test
    public void mapToList() {
        StreamsClass streamsClass = new StreamsClass();
        Map<String, String> map = streamsClass.setToMap(set);
        List<String> mapToListFormat = streamsClass.mapToListFormat(map);
        List<String> mapToListKeyAndValue = streamsClass.mapToListKeyAndValue(map);
        assertEquals(mapToListFormat.get(0), "Salt Lake City == 14");
        assertEquals(mapToListKeyAndValue.get(1), "14");
    }

    // Задание 4
    @Test
    public void createNewExemplarIfNullTest() {
        StreamsClass streamsClass = new StreamsClass();
        assertNotNull(streamsClass.createNewExemplarIfNull(null));
    }
}
