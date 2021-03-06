package com.example.blacksmith;

import org.junit.Test;
import java.lang.reflect.Method;
import org.powermock.api.mockito.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class BlacksmithTest {

    // Задание 1
    @Test
    public void stuffTitleTest() {
        Stuff shovel = mock(Stuff.class);
        Blacksmith blacksmith = new Blacksmith();
        blacksmith.setStuff(shovel);
        doReturn("Лопата").when(shovel).getTitle();
        assertEquals(blacksmith.getStuffTitle(), shovel.getTitle());
    }

    // Задание 2
    @Test
    public void spiedBlacksmithTest() {
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
        Blacksmith blacksmith = PowerMockito.mock(Blacksmith.class);
        Method method = Blacksmith.class.getDeclaredMethod("privateTest");
        method.setAccessible(true);
        String result = (String) method.invoke(blacksmith);
        assertEquals("Private method", result);
    }   
}