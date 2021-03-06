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
    JButton btnFushu,btnDian,btnLog,btnLn,btnAdd,btnSubtract,btnChen,btnChu,btnAc,btnEqual;
    JButton btnSin,btnAsin,btnAcos,btnAtan,btnCos,btnTan;
    JButton b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,b00;
    JButton btnPingFan3,btnPingFan2,btnPingFanGen,btnPingFanGen3;
        // 生成整个计算器模板
    Calculator(){
        panel = new JPanel();
    //  设置背景颜色
        panel.setBackground(Color.BLUE);

    //  初始化operator，为后面判断连续运算提供条件
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
        panel.add(btnEqual);
        panel.add(display);
        panel.add(btnAc);
        panel.add(b0);
        panel.add(b1);
        panel.add(b2);
        panel.add(b3);
        panel.add(b4);
        panel.add(b5);
        panel.add(b6);
        panel.add(b7);
        panel.add(b8);
        panel.add(b9);
        panel.add(btnDian);
        panel.add(b00);
        panel.add(btnFushu);
        panel.add(btnAdd);
        panel.add(btnSubtract);
        panel.add(btnChen);
        panel.add(btnChu);
        panel.add(btnPingFan2);
        panel.add(btnPingFan3);
        panel.add(btnPingFanGen);
        panel.add(btnPingFanGen3);
        panel.add(btnSin);
        panel.add(btnCos);
        panel.add(btnTan);
        panel.add(btnAsin);
        panel.add(btnAcos);
        panel.add(btnAtan);
        panel.add(btnLog);
        panel.add(btnLn);
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
        btnChen.addActionListener(this);
        btnChu.addActionListener(this);
        btnAc.addActionListener(this);
        btnPingFan2.addActionListener(this);
        btnPingFan3.addActionListener(this);
        btnPingFanGen.addActionListener(this);
        btnPingFanGen3.addActionListener(this);
        btnSin.addActionListener(this);
        btnCos.addActionListener(this);
        btnTan.addActionListener(this);
        btnLog.addActionListener(this);
        btnLn.addActionListener(this);
        btnDian.addActionListener(this);
        btnAsin.addActionListener(this);
        btnAcos.addActionListener(this);
        btnAtan.addActionListener(this);
        btnFushu.addActionListener(this);
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
        btnDian = new JButton(".");
        btnAdd = new JButton("+");
        btnEqual = new JButton("=");
        btnSubtract = new JButton("-");
        btnChen = new JButton("×");
        btnChu = new JButton("÷");
        btnAc = new JButton("AC");
        btnPingFan2 = new JButton("二次方");
        btnPingFan3 = new JButton("三次方");
        btnPingFanGen = new JButton("平方根");
        btnPingFanGen3 = new JButton("立方根");
        btnSin = new JButton("Sin");
        btnAsin = new JButton("算ASin");
        btnAcos= new JButton("求Acos");
        btnAtan = new JButton("得Atan");
        btnCos = new JButton("Cos");
        btnTan = new JButton("Tan");
        btnLog = new JButton("常用log");
        btnLn = new JButton("Ln");
        btnFushu = new JButton("负数");
        Font f = new Font("仿宋", Font.BOLD, 20);// 根据指定字体名称、样式和磅值大小，创建一个新 Font
        b0.setFont(f);
        b00.setFont(f);
        b1.setFont(f);
        b2.setFont(f);
        b3.setFont(f);
        b4.setFont(f);
        b5.setFont(f);
        b6.setFont(f);
        b7.setFont(f);
        b8.setFont(f);
        b9.setFont(f);
        btnDian.setFont(f);
        btnAdd.setFont(f);
        btnEqual.setFont(f);
        btnSubtract.setFont(f);
        btnChen.setFont(f);
        btnChu.setFont(f);
        btnAc.setFont(f);
        btnPingFanGen.setFont(f);
        btnPingFan2.setFont(f);
        btnPingFan3.setFont(f);
        btnPingFanGen3.setFont(f);
        btnSin.setFont(f);
        btnAsin.setFont(f);
        btnAcos.setFont(f);
        btnAtan.setFont(f);
        btnCos.setFont(f);
        btnTan.setFont(f);
        btnLog.setFont(f);
        btnLn.setFont(f);
        btnFushu.setFont(f);
                        }
    // main function
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        JFrame frame = new JFrame("Caculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(calculator.panel);
        frame.setSize(330, 600);
        frame.setLocation(700,300);
        frame.setVisible(true);
                                            }
//    主要判断方法
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
        } else if (c == 'A'){
            displayText = "0";
            operator=null;
            operand1 = null;
            shouldAppendDigitToNumber = false;
        }
        else if (c == '.'){
            displayText += command;
            shouldAppendDigitToNumber = true;
        }
        else if (c == '负'){
            Double result = computeResult12();
            displayText = Double.toString(result);
            operator = null;
            operand1 = null;
            shouldAppendDigitToNumber = false;
        }
        else if (c == '二'){
            Double result = computeResult1();
            displayText = Double.toString(result);
            operator = null;
            operand1 = null;
            shouldAppendDigitToNumber = false;
        }
        else if (c == '三'){
            Double result = computeResult8();
            displayText = Double.toString(result);
            operator = null;
            operand1 = null;
            shouldAppendDigitToNumber = false;
        }
        else if (c == 'S'){
            Double result = computeResult3();
            displayText = Double.toString(result);
            operator = null;
            operand1 = null;
            shouldAppendDigitToNumber = false;
        }
        else if (c == '算'){
            Double result = computeResult9();
            displayText = Double.toString(result);
            operator = null;
            operand1 = null;
            shouldAppendDigitToNumber = false;
        }
        else if (c == '求'){
            Double result = computeResult10();
            displayText = Double.toString(result);
            operator = null;
            operand1 = null;
            shouldAppendDigitToNumber = false;
        }
        else if (c == '得'){
            Double result = computeResult11();
            displayText = Double.toString(result);
            operator = null;
            operand1 = null;
            shouldAppendDigitToNumber = false;
        }
        else if (c == 'C'){
            Double result = computeResult4();
            displayText = Double.toString(result);
            operator = null;
            operand1 = null;
            shouldAppendDigitToNumber = false;
        }
        else if (c == 'T'){
            Double result = computeResult5();
            displayText = Double.toString(result);
            operator = null;
            operand1 = null;
            shouldAppendDigitToNumber = false;
        }
        else if (c == '常'){
            Double result = computeResult6();
            displayText = Double.toString(result);
            operator = null;
            operand1 = null;
            shouldAppendDigitToNumber = false;
        }
        else if (c == 'L'){
            Double result = computeResult7();
            displayText = Double.toString(result);
            operator = null;
            operand1 = null;
            shouldAppendDigitToNumber = false;
        }
        else if (c == '平'){
            Double result = computeResult2();
            displayText = Double.toString(result);
            operator = null;
            operand1 = null;
            shouldAppendDigitToNumber = false;
        }
        else if (c == '立'){
            Double result = computeResult13();
            displayText = Double.toString(result);
            operator = null;
            operand1 = null;
            shouldAppendDigitToNumber = false;
        }
//        判断是否连续运算
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
        Double result=0.0;
        switch (operator) {
            case "+":
                result = addNumbers(operand1, operand2);
                break;
            case "-":
                result = SubtractNumbers(operand1, operand2);
                break;
            case "×":
                result = chenNumbers(operand1, operand2);
                break;
            case "÷":
                result = chuNumbers(operand1, operand2);
                break;
                            }
        return result;
                            }
    Double computeResult1() {
        double operand2 = Double.parseDouble(displayText);
        double result;
        result = Math.pow(operand2, 2);
        return result;
                            }
    Double computeResult8() {
        double operand2 = Double.parseDouble(displayText);
        double result;
        result = Math.pow(operand2, 3);
        return result;
    }
    Double computeResult2() {
        double operand2 = Double.parseDouble(displayText);
        double result;
        result = Math.sqrt(operand2);
        return result;
                             }
    Double computeResult3() {
        double operand2 = Double.parseDouble(displayText);
        double result;
        result = Math.sin(operand2*Math.PI/180);
        return result;
    }
    Double computeResult4() {
        double operand2 = Double.parseDouble(displayText);
        double result;
        result = Math.cos(operand2*Math.PI/180);
        return result;
    }
    Double computeResult5() {
        double operand2 = Double.parseDouble(displayText);
        double result;
        result = Math.tan(operand2*Math.PI/180);
        return result;
    }
    Double computeResult6() {
        double operand2 = Double.parseDouble(displayText);
        double result;
        result = Math.log10(operand2);
        return result;
    }
    Double computeResult7() {
        double operand2 = Double.parseDouble(displayText);
        double result;
        result = Math.log(operand2);
        return result;
    }
    Double computeResult9() {
        double operand2 = Double.parseDouble(displayText);
        double result;
        result = Math.asin(operand2);
        return result;
    }
    Double computeResult10() {
        double operand2 = Double.parseDouble(displayText);
        double result;
        result = Math.acos(operand2);
        return result;
    }
    Double computeResult11() {
        double operand2 = Double.parseDouble(displayText);
        double result;
        result = Math.atan(operand2);
        return result;
    }
    Double computeResult12() {
        double operand2 = Double.parseDouble(displayText);
        double result;
        result = operand2-2*operand2;
        return result;
    }
    Double computeResult13() {
        double operand2 = Double.parseDouble(displayText);
        double result;
        result = Math.cbrt(operand2);
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
