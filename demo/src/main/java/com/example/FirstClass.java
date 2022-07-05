package com.example;

public class FirstClass {
    
    public static boolean ifReturn(){
        if (returnTrue() && SecondClass.returnTrue() && ThirdClass.returnTrue() && FourthClass.returnTrue()) 
            return true;
        return false;
    }

    public static boolean returnTrue() {
        return true;
    }
}
