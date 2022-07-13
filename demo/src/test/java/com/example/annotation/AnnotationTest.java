package com.example.annotation;

import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;

import java.util.Map;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

import org.junit.Test;

public class AnnotationTest {
    
    @CustomAnnotation(command = "firstCommand", queueNumber = 1)
    public String firstCommandMethod() {
        return "firstCommand complete!";
    }

    @CustomAnnotation(command = "secondCommand", queueNumber = 2)
    public String secondCommandMethod() {
        return "secondCommand complete!";
    }

    @CustomAnnotation(command = "thirdCommand", queueNumber = 3)
    public static String thirdCommandMethod() {
        return "thirdCommand complete!";
    }

    public Map<Method, Integer> returnAnnotationMethods() {
        Map<Method, Integer> map = new HashMap<>();
        Arrays.stream(this.getClass().getDeclaredMethods()).forEach(x -> {
            if (x.isAnnotationPresent(CustomAnnotation.class)) {
                map.put(x, x.getAnnotation(CustomAnnotation.class).queueNumber());
            }
        });
        return map;
    }

    @Test
    public void test() {
         Map<Method, Integer> map = returnAnnotationMethods()
        .entrySet()
        .stream()
        .sorted(Map.Entry.<Method, Integer>comparingByValue().reversed()) 
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, 
            (a, b) -> { throw new AssertionError(); }, 
            LinkedHashMap::new 
            ));

        map.entrySet().stream().forEach(x-> {
            try {
                System.out.println(x.getKey().invoke(this, null));;
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        });
    }
}