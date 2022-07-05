package com.example.Task1;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import com.example.*;

public class MethodTest {
    @Test
    public void getAnswerFromFirst(){
        assertTrue(FirstClass.ifReturn() );
    }

    @Test
    public void getAnswerFromSecond(){
        assertTrue(SecondClass.ifReturn());
    }

    @Test
    public void getAnswerFromThird(){
        assertTrue(ThirdClass.ifReturn());
    }

    @Test
    public void getAnswerFromFourth(){
        assertTrue(FourthClass.ifReturn());
    }
}
