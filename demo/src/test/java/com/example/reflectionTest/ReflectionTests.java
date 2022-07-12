package com.example.reflectionTest;

import org.junit.Test;
import java.util.Arrays;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import com.example.reflection.Reflection;

public class ReflectionTests {
    
    private static final Reflection reflection = new Reflection();
    private static final Class<? extends Reflection> clazz = reflection.getClass();

    // Задание 1
    @Test 
    public void firstTaskTest() throws NoSuchFieldException, IllegalAccessException {
        Field privateField = clazz.getDeclaredField("privateField");
        privateField.setAccessible(true);
        privateField.set(reflection, (String) "new value");
        
        System.out.println(privateField.get(reflection));
        System.out.println(clazz.getDeclaredField("publicField").getName());
        System.out.println(clazz.getDeclaredField("protectedField").getType().getSimpleName());
    }

    // Задание 2
    @Test
    public void secondTaskTest() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Method method = clazz.getDeclaredMethod("privateMethod");
        method.setAccessible(true);
        System.out.println(method.invoke(reflection));

        Arrays.stream(clazz.getSuperclass().getMethods()).forEach(x -> System.out.println(x.getName()));
        Arrays.stream(method.getExceptionTypes()).forEach(x -> System.out.println(x.getSimpleName()));
    }

    // Задание 3
    @Test
    public void thirdTaskTest() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        Constructor<Reflection> constructor = Reflection.class.getDeclaredConstructor(String.class);
        System.out.println(constructor);
        
        Constructor<Reflection> privateConstructor = Reflection.class.getDeclaredConstructor(String.class, String.class, String.class); 
        privateConstructor.setAccessible(true);
        Reflection ref = privateConstructor.newInstance("three", "two", "one");
        System.out.println(ref.publicField);
        
        Arrays.stream(constructor.getParameterTypes()).forEach(x -> System.out.println(x.getSimpleName()));
    }
}
