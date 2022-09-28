package com.it_academy.calculator;

public class CalculatorService {
    private double operand;
    private boolean isOperandFilled;

    private ICalculatorOperation currentOperation;

    public double calculate(double number){
        return this.calculate(number, null);
    }

    public double calculate(double number, ICalculatorOperation operation) {
        if (isOperandFilled){
            operand = this.currentOperation.calculate(this.operand, number);
            isOperandFilled = false;
        }
        else {
            operand = number;
        }

        if (operation != null){
            this.currentOperation = operation;
            isOperandFilled = true;
        }

        return operand;
    }

}
