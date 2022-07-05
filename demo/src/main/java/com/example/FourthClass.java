package com.example;

public class FourthClass {
    
    public static boolean ifReturn(){
        if (returnTrue() && SecondClass.returnTrue()) 
            return true;
        return false;
    }

    public static boolean returnTrue() {
        return true;
    }

    private boolean returnFasle(){
        return false;
    }
}
