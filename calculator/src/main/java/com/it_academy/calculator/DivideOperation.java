package com.it_academy.calculator;

public class DivideOperation implements ICalculatorOperation {
    @Override
    public double calculate(double firstOperand, double secondOperand) {
        return firstOperand / secondOperand;
    }
}
