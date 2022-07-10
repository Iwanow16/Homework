package com.example.streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsClass {

    // Задание 1
    public double getAverage(List<Integer> list) {
        double avr = list
            .stream()
            .limit(7)
            .mapToInt(x -> (x % 2 == 0) ? x + 5 : x - 5)
            .average()
            .getAsDouble();
        return avr;
    }

    // Задание 2
    public Map<String, String> setToMap(Set<String> set) {
        Map<String, String> setToMap = set
            .stream()
            .filter(x -> x.length() > 10)
            .collect(Collectors.toMap(Function.identity(), x->x.length()+""));
        return setToMap;
    }

    // Задание 3
    public List<String> mapToListFormat(Map<String, String> map) {
        List<String> mapToList = map
            .entrySet()
            .stream()
            .map(x -> x.getKey() + " == " + x.getValue())
            .collect(Collectors.toList());
        return mapToList;
    }

    public List<String> mapToListKeyAndValue(Map<String, String> map) {
        List<String> mapToList = map
            .entrySet()
            .stream()
            .flatMap(x -> Stream.of(x.getKey(), x.getValue()))
            .collect(Collectors.toList());
        return mapToList;
    }

    // Задание 4
    public String createNewExemplarIfNull(String nullName) {
        nullName = null;
        nullName = Optional.ofNullable(nullName).orElseGet(String::new);
        return nullName;
    }
}
