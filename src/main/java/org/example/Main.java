package org.example;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print(calc(console.nextLine()));
    }

    public static String calc(String input) {
        String operator = getOperator(input);
        int[] operands = getOperands(input, operator);

        return switch (operator) {
            case "+" -> String.valueOf(operands[0] + operands[1]);
            case "-" -> String.valueOf(operands[0] - operands[1]);
            case "*" -> String.valueOf(operands[0] * operands[1]);
            case "/" -> String.valueOf(operands[0] / operands[1]);
            default -> null;
        };
    }
    //Method for get operands from String
    private static int[] getOperands(String input, String operator){
        String[] parts = input.replaceAll(" ", "").split("[" + operator + "]");
        int[] intParts = new int[2];
        if(parts.length != 2) throw new RuntimeException("В input можно вводить в формате: (a + b)");
        int firstOperand = Integer.parseInt(parts[0]);
        int secondOperand = Integer.parseInt(parts[1]);
        if(firstOperand <= 0 || firstOperand > 10 || secondOperand <= 0 || secondOperand > 10){
            throw new RuntimeException("Операнды выходят за пределы допустимых значений: (от 1 до 10)");
        }
        intParts[0] = firstOperand;
        intParts[1] = secondOperand;
        return intParts;
    }
    private static String getOperator(String input) {
        if (input.contains("+")) return "+";
        if (input.contains("-")) return "-";
        if (input.contains("*")) return "*";
        if (input.contains("/")) return "/";
        else throw new RuntimeException("Нет оператора");
    }
}
