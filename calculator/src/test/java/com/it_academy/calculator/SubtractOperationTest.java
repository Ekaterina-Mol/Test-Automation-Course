package com.it_academy.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SubtractOperationTest {
    private SubtractOperation subtractOperation;

    @BeforeEach
    public void setUp() throws Exception {
        subtractOperation = new SubtractOperation();
    }

    @org.junit.jupiter.api.Test
    public void testRegularSubtract(){
        assertEquals(6, subtractOperation.calculate(15,9), 0.0000001);
    }

    @Test
    public void testSubtractWithZero(){
        assertEquals(15, subtractOperation.calculate(15,0), 0.0000001);
        assertEquals(-9, subtractOperation.calculate(0,9), 0.0000001);
    }
}
