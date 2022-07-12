package com.example.streams;

import java.util.Map;
import java.util.Set;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsClass {

    // Задание 1
    public double getAverage(List<Integer> list) {
        return list
            .stream()
            .limit(7)
            .mapToInt(x -> (x % 2 == 0) ? x + 5 : x - 5)
            .average()
            .getAsDouble();
    }

    // Задание 2
    public Map<String, String> setToMap(Set<String> set) {
        return set
            .stream()
            .filter(x -> x.length() > 10)
            .collect(Collectors.toMap(Function.identity(), x->x.length()+""));
    }

    // Задание 3
    public List<String> mapToListFormat(Map<String, String> map) {
        return map
            .entrySet()
            .stream()
            .map(x -> x.getKey() + " == " + x.getValue())
            .collect(Collectors.toList());
    }

    public List<String> mapToListKeyAndValue(Map<String, String> map) {
        return map
            .entrySet()
            .stream()
            .flatMap(x -> Stream.of(x.getKey(), x.getValue()))
            .collect(Collectors.toList());
    }

    // Задание 4
    public String createNewExemplarIfNull(String nullName) {
        return Optional.ofNullable(nullName).orElseGet(String::new);
    }
}
