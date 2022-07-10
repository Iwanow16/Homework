package com.example.lambdas;

public class LambdaProgram {
    
    public static int execute(FunctionalInterfaceWithZeroArgs zero) {
        return zero.doSomething();
    }

    public static int execute(FunctionalInterfaceWithOneArg one) {
        return one.doSomething(5);
    }

    public static int execute(FunctionalInterfaceWithTwoArgs two) {
        return two.doSomething(5, 10);
    }
}
