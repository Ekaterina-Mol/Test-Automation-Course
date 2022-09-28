package com.it_academy.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorServiceTest {
    private CalculatorService calculatorService;

    @BeforeEach
    public void setUp() throws Exception {
        calculatorService = new CalculatorService();
    }

    @Test
    public void testRegularDivision(){
        assertEquals( 15, calculatorService.calculate(15, new DivideOperation()), 0.0000001);
        assertEquals( 5, calculatorService.calculate(3), 0.0000001);
    }

    @Test
    public void testRegularSum(){
        assertEquals( 15, calculatorService.calculate(15, new SumOperation()), 0.0000001);
        assertEquals( 18, calculatorService.calculate(3), 0.0000001);
    }

    @Test
    public void testRegularMultiply(){
        assertEquals( 15, calculatorService.calculate(15, new MultiplyOperation()), 0.0000001);
        assertEquals( 45, calculatorService.calculate(3), 0.0000001);
    }

    @Test
    public void testRegularSubtract(){
        assertEquals( 15, calculatorService.calculate(15, new SubtractOperation()), 0.0000001);
        assertEquals( 12, calculatorService.calculate(3), 0.0000001);
    }

    @Test
    public void testEqualityRightAfterOperation(){
        var divisionResult = calculatorService.calculate(15, new DivideOperation());
        assertEquals( 1, calculatorService.calculate(divisionResult), 0.0000001);

        var sumResult = calculatorService.calculate(15, new SumOperation());
        assertEquals( 30, calculatorService.calculate(sumResult), 0.0000001);

        var subtractResult = calculatorService.calculate(15, new SubtractOperation());
        assertEquals( 0, calculatorService.calculate(subtractResult), 0.0000001);

        var multiplyResult = calculatorService.calculate(15, new MultiplyOperation());
        assertEquals( 225, calculatorService.calculate(multiplyResult), 0.0000001);
    }

    @Test
    public void testCalculateWithTwoConsecutiveOperations(){
        var sumResult = calculatorService.calculate(15, new SumOperation());
        assertEquals(30, calculatorService.calculate(15, new SumOperation()), 0.0000001);
        assertEquals( 45, calculatorService.calculate(15), 0.0000001);
    }
}
