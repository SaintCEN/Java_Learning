package DS.practice;

import java.util.Stack;

public class Calculator {
    public static double calculate(String expression) {
        Stack<Double> numStack = new Stack<>();
        Stack<Character> opStack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (Character.isDigit(c) || c == '.') {
                // 解析完整数字（包括小数）
                StringBuilder numStr = new StringBuilder();
                while (i < expression.length() &&
                        (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    numStr.append(expression.charAt(i++));
                }
                i--; // 回退一步，因为外层循环会i++
                numStack.push(Double.parseDouble(numStr.toString()));
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                // 处理运算符优先级
                while (!opStack.isEmpty() && hasPriority(opStack.peek(), c)) {
                    calculateTop(numStack, opStack);
                }
                opStack.push(c);
            }
        }

        // 计算剩余运算
        while (!opStack.isEmpty()) {
            calculateTop(numStack, opStack);
        }

        return numStack.pop();
    }

    // 判断栈顶运算符是否优先于当前运算符
    private static boolean hasPriority(char op1, char op2) {
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) {
            return true;
        }
        return false;
    }

    // 计算栈顶的两个数和运算符
    private static void calculateTop(Stack<Double> numStack, Stack<Character> opStack) {
        double b = numStack.pop();
        double a = numStack.pop();
        char op = opStack.pop();
        double res = 0;
        switch (op) {
            case '+': res = a + b; break;
            case '-': res = a - b; break;
            case '*': res = a * b; break;
            case '/': res = a / b; break;
        }
        numStack.push(res);
    }

    public static void main(String[] args) {
        String expr = "1+4*3/1.321";
        double result = calculate(expr);
        System.out.printf("Result: %.2f\n", result); // 输出: 2.20
    }
}