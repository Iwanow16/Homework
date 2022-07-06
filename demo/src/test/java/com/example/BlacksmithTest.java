package com.example;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import java.lang.reflect.Method;
import org.junit.Test;

public class BlacksmithTest {

    // Задание 1
    @Test
    public void stuffTitleTest() {
        Blacksmith blacksmith = mock(Blacksmith.class);
        Stuff shovel = new Stuff("Лопата", "Сталь");
        blacksmith.orderStuff("Лопата", "Железо");
        doReturn("Лопата").when(blacksmith).getStuffTitle();
        doReturn("Железо").when(blacksmith).getStuffMaterial();
        assertEquals(blacksmith.getStuffTitle(), shovel.getTitle());
    }

    // Задание 2
    @Test
    public void spyBlacksmithTest() {
        Blacksmith blacksmith = spy(Blacksmith.class);
        blacksmith.orderStuff("Лопата", "Сталь");
        blacksmith.checkOrder();
        verify(blacksmith, times(1)).checkOrder();
    }

    // Задание 3
    @Test(expected = NullPointerException.class)
    public void throwExceptionTest() {
        Blacksmith blacksmith = mock(Blacksmith.class);
        when(blacksmith.getStuff()).thenThrow(new NullPointerException());
        blacksmith.getStuff();
    }

    // Задание 4
    @Test
    public void privateMethodTest() throws Exception {
        Blacksmith blacksmith = new Blacksmith("Nugget");
        Method method = Blacksmith.class.getDeclaredMethod("privateMethod");
        method.setAccessible(true);
        assertEquals("Private method", (String) method.invoke(blacksmith));
    }   
}