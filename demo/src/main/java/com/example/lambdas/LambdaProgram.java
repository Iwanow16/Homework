package com.example.lambdas;

public class LambdaProgram {
    
    public static int execute(FunctionalInterfaceWithZeroArgs zero) {
        return zero.doSomething();
    }

    public static int execute(FunctionalInterfaceWithOneArg one) {
        return one.doSomething(1);
    }

    public static int execute(FunctionalInterfaceWithTwoArgs two) {
        return two.doSomething(1, 2);
    }

    public static void main(String[] args) {
        
        int zeroTest = execute(() -> 25);
        System.out.println(zeroTest);

        int OneTest = execute((a) -> a);
        System.out.println(OneTest);

        int TwoTest = execute((a, b) -> a + b);
        System.out.println(TwoTest);

    }
}
