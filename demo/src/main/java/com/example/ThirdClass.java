package com.example;

import java.io.InterruptedIOException;

public class ThirdClass {

    public static boolean ifReturn(){
        if (returnTrue() && SecondClass.returnTrue()) 
            return true;
        return false;
    }

    public static boolean returnTrue() {
        return true;
    }

    public boolean throwException() throws InterruptedIOException{
        throw new InterruptedIOException();
    }
}
