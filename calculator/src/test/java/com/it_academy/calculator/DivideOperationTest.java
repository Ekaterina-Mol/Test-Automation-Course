package com.it_academy.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DivideOperationTest {
    private DivideOperation divideOperation;

    @BeforeEach
    public void setUp() throws Exception {
        divideOperation = new DivideOperation();
    }

    @Test
    public void testRegularDivide(){

        assertEquals( 3, divideOperation.calculate(15,5), 0.0000001);
    }

    @Test
    public void testDivisionByZero(){
        Assertions.assertThrows(DivisionByZeroException.class, () -> {
            divideOperation.calculate(16,0);
        });
    }

    @Test
    public void testDivideZero(){
        assertEquals(0, divideOperation.calculate(0,5), 0.0000001);
    }
}
