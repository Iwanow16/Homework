package com.example.Task2;

import static org.mockito.Mockito.*;
import org.junit.Test;
import com.example.*;

public class CountTest {
    
    @Test
    public void howManyTimesWasCalled(){
        SecondClass secondClass = mock(SecondClass.class);
        secondClass.callMethods();
        verify(secondClass).callMethods();
    }
}
