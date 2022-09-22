import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorMainForm {
    private JTextField calculatorTextField;
    private JButton One;
    private JButton Multiply;
    private JButton Subtract;
    private JButton Sum;
    private JButton Two;
    private JButton Four;
    private JButton Seven;
    private JButton Clear;
    private JButton Divide;
    private JButton Five;
    private JButton Eight;
    private JButton Zero;
    private JButton Three;
    private JButton Six;
    private JButton Nine;
    private JButton Equality;
    private JPanel calculatorForm;
    private CalculatorService calculatorService = new CalculatorService();

    private boolean isOperationClicked;

    public static void main(String[] args) {
        JFrame frame = new JFrame("CalculatorMainForm");
        frame.setContentPane(new CalculatorMainForm().calculatorForm);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public CalculatorMainForm() {
        One.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isOperationClicked)
                {
                    calculatorTextField.setText("1");
                    isOperationClicked = false;
                } else {
                    String oldText = calculatorTextField.getText();
                    calculatorTextField.setText(oldText + "1");
                }
            }
        });
        Two.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isOperationClicked)
                {
                    calculatorTextField.setText("2");
                    isOperationClicked = false;
                } else {
                    String oldText = calculatorTextField.getText();
                    calculatorTextField.setText(oldText + "2");
                }
            }
        });
        Three.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isOperationClicked)
                {
                    calculatorTextField.setText("3");
                    isOperationClicked = false;
                } else {
                    String oldText = calculatorTextField.getText();
                    calculatorTextField.setText(oldText + "3");
                }
            }
        });
        Four.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isOperationClicked)
                {
                    calculatorTextField.setText("4");
                    isOperationClicked = false;
                } else {
                    String oldText = calculatorTextField.getText();
                    calculatorTextField.setText(oldText + "4");
                }
            }
        });
        Five.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isOperationClicked)
                {
                    calculatorTextField.setText("5");
                    isOperationClicked = false;
                } else {
                    String oldText = calculatorTextField.getText();
                    calculatorTextField.setText(oldText + "5");
                }
            }
        });
        Six.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isOperationClicked)
                {
                    calculatorTextField.setText("6");
                    isOperationClicked = false;
                } else {
                    String oldText = calculatorTextField.getText();
                    calculatorTextField.setText(oldText + "6");
                }
            }
        });
        Seven.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isOperationClicked)
                {
                    calculatorTextField.setText("7");
                    isOperationClicked = false;
                } else {
                    String oldText = calculatorTextField.getText();
                    calculatorTextField.setText(oldText + "7");
                }
            }
        });
        Eight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isOperationClicked)
                {
                    calculatorTextField.setText("8");
                    isOperationClicked = false;
                } else {
                    String oldText = calculatorTextField.getText();
                    calculatorTextField.setText(oldText + "8");
                }
            }
        });
        Nine.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isOperationClicked)
                {
                    calculatorTextField.setText("9");
                    isOperationClicked = false;
                } else {
                    String oldText = calculatorTextField.getText();
                    calculatorTextField.setText(oldText + "9");
                }
            }
        });
        Zero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isOperationClicked)
                {
                    calculatorTextField.setText("0");
                    isOperationClicked = false;
                } else {
                    String oldText = calculatorTextField.getText();
                    calculatorTextField.setText(oldText + "0");
                }
            }
        });
        Sum.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                var number = Double.parseDouble(calculatorTextField.getText());

                calculatorTextField.setText(Double.toString(calculatorService.calculate(number, new SumOperation())));

                isOperationClicked = true;
            }
        });
        Subtract.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                var number = Double.parseDouble(calculatorTextField.getText());

                calculatorTextField.setText(Double.toString(calculatorService.calculate(number, new SubtractOperation())));

                isOperationClicked = true;
            }
        });
        Multiply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                var number = Double.parseDouble(calculatorTextField.getText());

                calculatorTextField.setText(Double.toString(calculatorService.calculate(number, new MultiplyOperation())));

                isOperationClicked = true;
            }
        });
        Divide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                var number = Double.parseDouble(calculatorTextField.getText());

                calculatorTextField.setText(Double.toString(calculatorService.calculate(number, new DivideOperation())));

                isOperationClicked = true;
            }
        });
        Equality.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                var number = Double.parseDouble(calculatorTextField.getText());

                calculatorTextField.setText(Double.toString(calculatorService.calculate(number)));

                isOperationClicked = true;
            }
        });
    }
}
