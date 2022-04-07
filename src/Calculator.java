import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Calculator implements ActionListener {
    // 整个面板
    JPanel panel;
    // 计算器的显示屏
    JTextField display;
    // 显示屏里的内容
    String displayText;
    // 保存用户输入的第一个数
    Double operand1;
    // 保存用户输入的运算符号：+-×÷
    String operator;

    // 用来表示应该重新输入一个数字还是往屏幕后面添加数字
    boolean shouldAppendDigitToNumber;

    // 计算器上的按键
    JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9,b00;
    JButton btnAdd, btnEqual, btnSubtract, btnchen, btnchu,btnC,btnpingfan,btnpingfangen;

    Calculator() {
        panel = new JPanel();
        panel.setBackground(Color.BLUE);

        operator = null;
        displayText = "0";

        display = new JTextField(20);
        display.setEditable(false);
        display.setText(displayText);

        shouldAppendDigitToNumber = false;

        createButtons();
        attachListeners();
        addComponentsToPanel();
    }

    /**
     * 将屏幕和按键依次添加到计算器上
     */
    void addComponentsToPanel() {
        panel.add(display);
        panel.add(btnAdd);
        panel.add(b0);
        panel.add(b00);
        panel.add(b1);
        panel.add(b2);
        panel.add(b3);
        panel.add(b4);
        panel.add(b5);
        panel.add(b6);
        panel.add(b7);
        panel.add(b8);
        panel.add(b9);
        panel.add(btnEqual);
        panel.add(btnSubtract);
        panel.add(btnchen);
        panel.add(btnchu);
        panel.add(btnC);
        panel.add(btnpingfan);
        panel.add(btnpingfangen);

    }

    /**
     * 设置用户点击按键时计算器的反应
     */
    void attachListeners() {
        btnAdd.addActionListener(this);
        b1.addActionListener(this);
        b0.addActionListener(this);
        b00.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        btnEqual.addActionListener(this);
        btnSubtract.addActionListener(this);
        btnchen.addActionListener(this);
        btnchu.addActionListener(this);
        btnC.addActionListener(this);
        btnpingfan.addActionListener(this);
        btnpingfangen.addActionListener(this);
    }

    /**
     * 创建好按键（但还没有"贴"到屏幕上）
     */
    void createButtons() {
        b0 = new JButton("0");
        b00 = new JButton("00");
        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b7 = new JButton("7");
        b8 = new JButton("8");
        b9 = new JButton("9");
        btnAdd = new JButton("+");
        btnEqual = new JButton("=");
        btnSubtract = new JButton("-");
        btnchen = new JButton("×");
        btnchu = new JButton("÷");
        btnC = new JButton("C");
        btnpingfan = new JButton("平方");
        btnpingfangen = new JButton("求平方根");
    }

    // main function
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(calculator.panel);
        frame.setSize(330, 220);
        frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        var command = e.getActionCommand();
        char c = command.charAt(0);
        if (isOperand(c)) {
            if (shouldAppendDigitToNumber) {
                displayText += command;
            } else {
                displayText = command;
                shouldAppendDigitToNumber = true;
            }
        } else if (c == '=') {
            Double result = computeResult();
            displayText = Double.toString(result);
            operator = null;
            operand1 = null;
            shouldAppendDigitToNumber = false;
        } else if (c == 'C'){
            displayText = "0";
            operator=null;
            operand1 = null;
            shouldAppendDigitToNumber = false;
        }
        else if (c == '平'){
            Double result = computeResult1();
            displayText = Double.toString(result);
            operator = null;
            operand1 = null;
            shouldAppendDigitToNumber = false;
        }
        else if (c == '求'){
            Double result = computeResult2();
            displayText = Double.toString(result);
            operator = null;
            operand1 = null;
            shouldAppendDigitToNumber = false;
        }
        else if (operator != null){
            displayText = Double.toString(computeResult());
            display.setText(displayText);
            operand1 = Double.parseDouble(displayText);
            shouldAppendDigitToNumber = false;
            operator=String.valueOf(c);
            return;
        }
        else {
            operand1 = Double.parseDouble(displayText);
            shouldAppendDigitToNumber = false;
            operator = command;
        }
        display.setText(displayText);
    }

    /**
     * 计算结果
     */
    Double computeResult() {
        Double operand2 = Double.parseDouble(displayText);
        Double result;
        if (operator.equals("+")) {
            result = addNumbers(operand1, operand2);
        } else if (operator.equals("-")){
            result = SubtractNumbers(operand1, operand2);
        } else if (operator.equals("×")){
            result = chenNumbers(operand1, operand2);
        } else {
            result = chuNumbers(operand1, operand2);
        }
        return result;
    }
    Double computeResult1() {
        Double operand2 = Double.parseDouble(displayText);
        Double result;
        result = Math.pow(operand2, 2);
        return result;
    }
    Double computeResult2() {
        Double operand2 = Double.parseDouble(displayText);
        Double result;
        result = Math.sqrt(operand2);
        return result;
    }
    Double addNumbers(Double a, Double b) {
        return a + b;
    }
    Double SubtractNumbers(Double a, Double b) {
        return a - b;
    }
    Double chenNumbers(Double a, Double b) {
        return a * b;
    }
    Double chuNumbers(Double a, Double b) {
        return a / b;
    }

    /**
     * 判断按的是数（0123之类）还是运算符（+-=之类）
     */
    boolean isOperand(char c) {
        return Character.isDigit(c);
    }
}
