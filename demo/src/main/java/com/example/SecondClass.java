package com.example;

public class SecondClass {

    public static boolean ifReturn(){
        if (returnTrue() && SecondClass.returnTrue() && ThirdClass.returnTrue() && FourthClass.returnTrue()) 
            return true;
        return false;
    }

    public static boolean returnTrue() {
        return true;
    }

    public void callMethods(){
        FirstClass.returnTrue();
        ThirdClass.returnTrue();
        FourthClass.returnTrue();
    }
}
