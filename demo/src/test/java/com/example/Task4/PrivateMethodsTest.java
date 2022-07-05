package com.example.Task4;

import static org.junit.Assert.assertFalse;
import java.lang.reflect.Method;
import org.junit.Test;
import com.example.*;

public class PrivateMethodsTest {
    @Test
    public void wasExceptionsThrown() {
        try {
            FourthClass fourthClass = new FourthClass();
            Method method = FourthClass.class.getDeclaredMethod("returnFasle");
            method.setAccessible(true);
            assertFalse((boolean)method.invoke(fourthClass));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
