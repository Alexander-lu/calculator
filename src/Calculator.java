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
    Integer operand1;

    // 保存用户输入的运算符号：+-×÷
    String operator;

    // 用来表示应该重新输入一个数字还是往屏幕后面添加数字
    boolean shouldAppendDigitToNumber;

    // 计算器上的按键
    JButton b0, b1, b7;
    JButton btnAdd, btnEqual;

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
        panel.add(b1);
        panel.add(b0);
        panel.add(btnEqual);
        panel.add(b7);
    }

    /**
     * 设置用户点击按键时计算器的反应
     */
    void attachListeners() {
        btnAdd.addActionListener(this);
        b1.addActionListener(this);
        b0.addActionListener(this);
        b7.addActionListener(this);
        btnEqual.addActionListener(this);
    }

    /**
     * 创建好按键（但还没有"贴"到屏幕上）
     */
    void createButtons() {
        b0 = new JButton("0");
        b1 = new JButton("1");
        b7 = new JButton("7");
        btnAdd = new JButton("+");
        btnEqual = new JButton("=");
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
            int result = computeResult();
            displayText = Integer.toString(result);
            operator = null;
            operand1 = null;
            shouldAppendDigitToNumber = false;
        } else {
            operand1 = Integer.parseInt(displayText);
            shouldAppendDigitToNumber = false;
            operator = command;
        }
        display.setText(displayText);
    }

    /**
     * 计算结果
     */
    int computeResult() {
        int operand2 = Integer.parseInt(displayText);
        int result = addNumbers(operand1, operand2);
        return result;
    }

    int addNumbers(int a, int b) {
        return a + b;
    }

    /**
     * 判断按的是数（0123之类）还是运算符（+-=之类）
     */
    boolean isOperand(char c) {
        return Character.isDigit(c);
    }
}
