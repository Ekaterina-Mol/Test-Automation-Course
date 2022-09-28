package com.it_academy.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MultiplyOperationTest {
    private MultiplyOperation multiplyOperation;

    @BeforeEach
    public void setUp() throws Exception {
        multiplyOperation = new MultiplyOperation();
    }

    @Test
    public void testRegularMultiply(){
        assertEquals(45, multiplyOperation.calculate(9,5), 0.0000001);
    }

    @org.junit.jupiter.api.Test
    public void testMultiplyWithZero(){
        assertEquals(0, multiplyOperation.calculate(9,0), 0.0000001);
        assertEquals( 0, multiplyOperation.calculate(0,5), 0.0000001);
    }
}
