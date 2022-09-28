package com.it_academy.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SumOperationTest {
    private SumOperation sumOperation;

    @BeforeEach
    public void setUp() throws Exception {
        sumOperation = new SumOperation();
    }

    @Test
    public void testRegularSum(){
        assertEquals(24, sumOperation.calculate(9,15), 0.0000001);
    }

    @org.junit.jupiter.api.Test
    public void testSumWithZero(){
        assertEquals(9, sumOperation.calculate(9,0), 0.0000001);
        assertEquals(15, sumOperation.calculate(0,15), 0.0000001);
    }
}
