package com.example.lambdaTest;

import org.junit.Test;

import com.example.lambdas.FunctionalInterfaceWithOneArg;
import com.example.lambdas.FunctionalInterfaceWithTwoArgs;
import com.example.lambdas.LambdaProgram;

import static org.junit.Assert.assertEquals;

public class LambdasTest {
    
    @Test
    public void zeroTest() {
        assertEquals(25, LambdaProgram.execute(() -> 25));
        assertEquals(0, LambdaProgram.execute(() -> 0));
    }

    @Test
    public void oneTest() {
        assertEquals(25, LambdaProgram.execute(a -> a * 5));
        assertEquals(10, LambdaProgram.execute(
            new FunctionalInterfaceWithOneArg() {
                @Override
                public int doSomething(int a) {
                    return a + 5;
                }
            }
        ));
        }

    @Test
    public void twoTest() {
        assertEquals(75, LambdaProgram.execute((a, b) -> a * 5 + b * 5));
        assertEquals(15, LambdaProgram.execute(
            new FunctionalInterfaceWithTwoArgs() {
                @Override
                public int doSomething(int a, int b) {
                    return a + b;
                }
            }
        ));
    }
}
