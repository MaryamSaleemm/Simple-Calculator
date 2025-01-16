import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
import java.awt.event.*;
import java.util.ArrayList;

class Calculator {
    JFrame frame = new JFrame("Calculator");
    JTextField textField = new JTextField();
    JRadioButton radioOn = new JRadioButton("ON");
    JRadioButton radioOff = new JRadioButton("OFF");
    JButton buttonHistory = new JButton("His");
    JButton buttonZero = new JButton("0");
    JButton buttonOne = new JButton("1");
    JButton buttonTwo = new JButton("2");
    JButton buttonThree = new JButton("3");
    JButton buttonFour = new JButton("4");
    JButton buttonFive = new JButton("5");
    JButton buttonSix = new JButton("6");
    JButton buttonSeven = new JButton("7");
    JButton buttonEight = new JButton("8");
    JButton buttonNine = new JButton("9");
    JButton buttonDot = new JButton(".");
    JButton buttonClear = new JButton("CLR");
    JButton buttonAdd = new JButton("+");
    JButton buttonSub = new JButton("-");
    JButton buttonMul = new JButton("*");
    JButton buttonDiv = new JButton("/");
    JButton buttonAns = new JButton("Ans");
    JButton buttonSqrt = new JButton("√");
    JButton buttonSin = new JButton("sin");
    JButton buttonCos = new JButton("cos");
    JButton buttonTan = new JButton("tan");

    ArrayList<String> history = new ArrayList<>();
    String currentExpression = "";

    Calculator() {
        prepareGUI();
        addComponents();
        addActionListeners();
    }
    public void prepareGUI() {
        frame.setSize(305, 530);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(new Color(0xE6E6FA));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    public void addComponents() {
        textField.setBounds(10, 40, 270, 50);
        textField.setFont(new Font("Arial", Font.BOLD, 20));
        textField.setBackground(new Color(0xE5E5ED));
        Border blackBorder = BorderFactory.createLineBorder(Color.BLACK, 1);
        textField.setBorder(blackBorder);
        textField.setEditable(false);
        textField.setHorizontalAlignment(SwingConstants.LEFT);
        frame.add(textField);

        // Radio Buttons for ON/OFF
        radioOn.setBounds(10, 110, 60, 20);
        radioOff.setBounds(80, 110, 60, 20);
        radioOn.setForeground(Color.black);
        radioOn.setBackground(new Color(0xE5E5ED));
        radioOff.setForeground(Color.black);
        radioOff.setBackground(new Color(0xE5E5ED));

        ButtonGroup radioGroup = new ButtonGroup();
        radioGroup.add(radioOn);
        radioGroup.add(radioOff);
        frame.add(radioOn);
        frame.add(radioOff);

        // History Button
        buttonHistory.setBounds(150, 110, 60, 40);
        buttonHistory.setBackground(new Color(0x9999E1));
        frame.add(buttonHistory);

        // Scientific Buttons
        buttonSqrt.setBounds(10, 170, 60, 40);
        buttonSqrt.setBackground(new Color(0xFDD3C7));
        frame.add(buttonSqrt);

        buttonSin.setBounds(80, 170, 60, 40);
        buttonSin.setBackground(new Color(0xFDD3C7));
        frame.add(buttonSin);

        buttonCos.setBounds(150, 170, 60, 40);
        buttonCos.setBackground(new Color(0xFDD3C7));
        frame.add(buttonCos);

        buttonTan.setBounds(220, 170, 60, 40);
        buttonTan.setBackground(new Color(0xFDD3C7));
        frame.add(buttonTan);

        // Number Buttons
        buttonSeven.setBounds(10, 230, 60, 40);
        buttonSeven.setBackground(new Color(0xFDC7DB));
        frame.add(buttonSeven);
        buttonEight.setBounds(80, 230, 60, 40);
        buttonEight.setBackground(new Color(0xFDC7DB));
        frame.add(buttonEight);
        buttonNine.setBounds(150, 230, 60, 40);
        buttonNine.setBackground(new Color(0xFDC7DB));
        frame.add(buttonNine);

        buttonFour.setBounds(10, 290, 60, 40);
        buttonFour.setBackground(new Color(0xC7F7DB));
        frame.add(buttonFour);
        buttonFive.setBounds(80, 290, 60, 40);
        buttonFive.setBackground(new Color(0xC7F7DB));
        frame.add(buttonFive);
        buttonSix.setBounds(150, 290, 60, 40);
        buttonSix.setBackground(new Color(0xC7F7DB));
        frame.add(buttonSix);

        buttonOne.setBounds(10, 350, 60, 40);
        buttonOne.setBackground(new Color(0xFDF6C7));
        frame.add(buttonOne);
        buttonTwo.setBounds(80, 350, 60, 40);
        buttonTwo.setBackground(new Color(0xFDF6C7));
        frame.add(buttonTwo);
        buttonThree.setBounds(150, 350, 60, 40);
        buttonThree.setBackground(new Color(0xFDF6C7));
        frame.add(buttonThree);

        buttonZero.setBounds(80, 410, 60, 40);
        buttonZero.setBackground(new Color(0xC7E8FD));
        frame.add(buttonZero);
        buttonDot.setBounds(10, 410, 60, 40);
        buttonDot.setBackground(new Color(0xC7E8FD));
        frame.add(buttonDot);

        // Operation Buttons
        buttonAdd.setBounds(220, 230, 60, 40);
        buttonAdd.setBackground(new Color(0xFDC7DB));
        buttonAdd.setForeground(Color.black);
        frame.add(buttonAdd);

        buttonSub.setBounds(220, 290, 60, 40);
        buttonSub.setBackground(new Color(0xC7F7DB));
        buttonSub.setForeground(Color.BLACK);
        frame.add(buttonSub);

        buttonMul.setBounds(220, 350, 60, 40);
        buttonMul.setBackground(new Color(0xFDF6C7));
        buttonMul.setForeground(Color.black);
        frame.add(buttonMul);

        buttonDiv.setBounds(220, 410, 60, 40);
        buttonDiv.setBackground(new Color(0xC7E8FD));
        buttonDiv.setForeground(Color. BLACK);
        frame.add(buttonDiv);

        buttonAns.setBounds(150, 410, 60, 40);
        buttonAns.setBackground(new Color(0xC7E8FD));
        frame.add(buttonAns);

        buttonClear.setBounds(220, 110, 60, 40);
        buttonClear.setBackground(new Color(0x9999E1));
        frame.add(buttonClear);
    }
    public void addActionListeners() {
        ActionListener numberListener = e -> {
            String value = e.getActionCommand();
            currentExpression += value;
            textField.setText(currentExpression);
        };

        buttonZero.addActionListener(numberListener);
        buttonOne.addActionListener(numberListener);
        buttonTwo.addActionListener(numberListener);
        buttonThree.addActionListener(numberListener);
        buttonFour.addActionListener(numberListener);
        buttonFive.addActionListener(numberListener);
        buttonSix.addActionListener(numberListener);
        buttonSeven.addActionListener(numberListener);
        buttonEight.addActionListener(numberListener);
        buttonNine.addActionListener(numberListener);
        buttonDot.addActionListener(numberListener);

        buttonAdd.addActionListener(e -> addOperator('+'));
        buttonSub.addActionListener(e -> addOperator('-'));
        buttonMul.addActionListener(e -> addOperator('*'));
        buttonDiv.addActionListener(e -> addOperator('/'));

        buttonAns.addActionListener(e -> calculateResult());
        buttonClear.addActionListener(e -> clearCalculator());

        buttonSqrt.addActionListener(e -> calculateSqrt());
        buttonSin.addActionListener(e -> calculateTrig("sin"));
        buttonCos.addActionListener(e -> calculateTrig("cos"));
        buttonTan.addActionListener(e -> calculateTrig("tan"));

        buttonHistory.addActionListener(e -> showHistory());
        radioOn.addActionListener(e -> enableCalculator());
        radioOff.addActionListener(e -> disableCalculator());
    }

    private void addOperator(char operator) {
        currentExpression += " " + operator + " ";
        textField.setText(currentExpression);
    }

    private void calculateResult() {
        try {
            String[] tokens = currentExpression.split(" ");
            double result = Double.parseDouble(tokens[0]);
            for (int i = 1; i < tokens.length; i += 2) {
                String op = tokens[i];
                double num = Double.parseDouble(tokens[i + 1]);
                switch (op) {
                    case "+" -> result += num;
                    case "-" -> result -= num;
                    case "*" -> result *= num;
                    case "/" -> result /= num;
                }
            }
            history.add(currentExpression + " = " + result);
            textField.setText(String.valueOf(result));
            currentExpression = String.valueOf(result);
        } catch (Exception e) {
            textField.setText("Error");
        }
    }
    private void calculateSqrt() {
        try {
            double value = Double.parseDouble(textField.getText());
            double sqrtResult = Math.sqrt(value);
            history.add("√" + value + " = " + sqrtResult);
            textField.setText(String.valueOf(sqrtResult));
            currentExpression = String.valueOf(sqrtResult);
        } catch (Exception e) {
            textField.setText("Error");
        }
    }
    private void calculateTrig(String function) {
        try {
            double value = Double.parseDouble(textField.getText());
            double result;
            switch (function) {
                case "sin" -> result = Math.sin(Math.toRadians(value));
                case "cos" -> result = Math.cos(Math.toRadians(value));
                case "tan" -> result = Math.tan(Math.toRadians(value));
                default -> throw new IllegalStateException("Unexpected value: " + function);
            }
            history.add(function + "(" + value + ") = " + result);
            textField.setText(String.valueOf(result));
            currentExpression = String.valueOf(result);
        } catch (Exception e) {
            textField.setText("Error");
        }
    }
    private void clearCalculator() {
        currentExpression = "";
        textField.setText("");
    }
    private void showHistory() {
        StringBuilder historyText = new StringBuilder();
        for (String entry : history) {
            historyText.append(entry).append("\n");
        }
        JOptionPane.showMessageDialog(frame, historyText.toString(), "History", JOptionPane.INFORMATION_MESSAGE);
    }
    private void enableCalculator() {
        textField.setEnabled(true);
        for (Component c : frame.getContentPane().getComponents()) {
            c.setEnabled(true);
        }
    }
    private void disableCalculator() {
        textField.setText("");
        textField.setEnabled(false);
        for (Component c : frame.getContentPane().getComponents()) {
            if (!(c instanceof JRadioButton)) {
                c.setEnabled(false);
            }
        }
    }
    public static void main(String[] args) {
        new Calculator();
    }
}
