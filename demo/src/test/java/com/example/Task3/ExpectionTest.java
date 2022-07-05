package com.example.Task3;

import java.io.InterruptedIOException;
import static org.mockito.Mockito.*;
import org.junit.Test;
import com.example.*;

public class ExpectionTest {
    @Test(expected = InterruptedIOException.class)
    public void wasExceptionsThrown() throws InterruptedIOException{
        ThirdClass thirdClass = mock(ThirdClass.class);
        when(thirdClass.throwException()).thenThrow(new InterruptedIOException());
        thirdClass.throwException();
    }
}
