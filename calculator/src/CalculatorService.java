public class CalculatorService {
    private double operand;
    private OperationTypes operationType;
    private boolean isOperandFilled;


    public double Sum(double number){
        if (isOperandFilled){
            operand = Calculate(number);
        }
        else{
            operand = number;
            isOperandFilled = true;
        }
        operationType = OperationTypes.Sum;

        return operand;
    }
    public double Multiply(double number){
        if (isOperandFilled){
            operand = Calculate(number);
        }
        else{
            operand = number;
            isOperandFilled = true;
        }
        operationType = OperationTypes.Multiply;

        return operand;
    }

    public double Divide(double number){
        if (isOperandFilled){
            operand = Calculate(number);
        }
        else{
            operand = number;
            isOperandFilled = true;
        }
        operationType = OperationTypes.Divide;

        return operand;
    }

    public double Subtract(double number){
        if (isOperandFilled){
            operand = Calculate(number);
        }
        else{
            operand = number;
            isOperandFilled = true;
        }
        operationType = OperationTypes.Subtract;

        return operand;
    }

    public double Equality(double number){
        if (isOperandFilled){
            operand = Calculate(number);
            isOperandFilled = false;
        }
        else {
            operand = number;
        }

        return operand;
    }

    private double Calculate(double number){
        double result = 0;

        switch (operationType) {
            case Multiply:
                result = operand * number;
                break;

            case Sum:
                result = operand + number;
                break;

            case Subtract:
                result = operand - number;
                break;

            case Divide:
                result = operand / number;
        }

        return result;
    }
}
