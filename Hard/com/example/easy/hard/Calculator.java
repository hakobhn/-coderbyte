package com.example.easy.hard;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Using the Java language, have the function Calculator(str) take the str parameter being passed and evaluate the
 * mathematical expression within in. For example, if str were "2+(3-1)*3" the output should be 8.
 * Another example: if str were "(2-0)(6/2)" the output should be 6. There can be parenthesis within the string so you
 * must evaluate it properly according to the rules of arithmetic.
 * The string will contain the operators: +, -, /, *, (, and ). If you have a string like this: #/#*# or #+#(#)/#,
 * then evaluate from left to right. So divide then multiply, and for the second one multiply, divide, then add.
 * The evaluations will be such that there will not be any decimal operations, so you do not need to account for
 * rounding and whatnot.
 *
 * @author Nick Livens
 */
class Calculator {

    private static final Stack<String> stack = new Stack<>();

    private static String[] parseConsoleInput(String input) {
        return input
                .toLowerCase()
                .replaceAll("(\\)\\()", ") * (")
                .replaceAll("([0-9])(?=[(])", "$1 *")
                .replaceAll("([\\p{P}\\p{S}a-z0-9])(?=[\\p{P}\\p{S}a-z])", "$1 ")
                .replaceAll("([^0-9])(?=[0-9])", "$1 ")
                .replaceAll(" +", " ")
                .trim()
                .split(" ");
    }

    private static void printInputError(String op) {
        System.out.println("Unrecognised operator or operand: \"" + op + "\".");
    }

    public static long reduceOperands(long a, long b, String operator) {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                if (b == 0) {
                    System.out.println("Divide by 0.");
                    throw new ArithmeticException();
                }
                return a / b;
            default:
                return 0;
        }
    }

    private static boolean isOperand(String op) {
        Pattern pattern = Pattern.compile("^[\\d]|^-[\\d]");
        Matcher matcher = pattern.matcher(op);
        return matcher.find();
    }

    private static boolean isOperator(String op) {
        Pattern pattern = Pattern.compile("^[+\\-*/^%]");
        Matcher matcher = pattern.matcher(op);
        return matcher.find();
    }

    private static String[] convertToPostfix(String[] tokens) {
        Stack<String> infStack = new Stack<>();
        String terminating = "#";
        Dictionary<String, Integer> precedence = new Hashtable<>() {
            {
                put(terminating, 0);
                put("(", 0);
                put(")", 0);
                put("+", 1);
                put("-", 1);
                put("*", 2);
                put("/", 2);
            }
        };

        ArrayList<String> output = new ArrayList<>();
        infStack.push(terminating);
        for (String token : tokens) {
            if (isOperand(token)) {
                output.add(token);
                continue;
            }
            if (token.equals("(")) {
                infStack.push(token);
                continue;
            }
            if (token.equals(")")) {
                while (true) {
                    String op = infStack.pop();
                    if (op.equals("(")) {
                        break;
                    } else {
                        output.add(op);
                    }
                }
                continue;
            }

            if (isOperator(token)) {
                int cmp1 = precedence.get(token);
                while (true) {
                    int cmp2 = precedence.get(infStack.peek());
                    if (cmp1 > cmp2) {
                        infStack.push(token);
                        break;
                    } else {
                        output.add(infStack.pop());
                    }
                }
            }
        }

        while (!infStack.empty() && !infStack.peek().equals(terminating)) {
            output.add(infStack.pop());
        }
        return output.toArray(new String[0]);
    }

    private static String performArithOperation(String operator) {
        if (stack.size() >= 2) {
            String elementB = stack.pop();
            String elementA = stack.pop();
            long opB = Long.parseLong(elementB);
            long opA = Long.parseLong(elementA);
            long result = reduceOperands(opA, opB, operator);
            return Long.toString(result);
        } else {
            return null;
        }
    }

    private static Long evaluateExpression(String[] tokens) {
        for (String token : tokens) {
            if (isOperand(token)) {
                stack.push(token);
                continue;
            }
            if (isOperator(token)) {
                String result = performArithOperation(token);
                if (result != null) {
                    stack.push(result);
                }
                continue;
            }
            printInputError(token);
        }
        if (stack.isEmpty()) {
            return null;
        }
        return Long.parseLong(stack.peek());
    }

    public static String Calculator(String str) {
        String[] tokens = parseConsoleInput(str);
        String[] postfix = convertToPostfix(tokens);
        Long result = evaluateExpression(postfix);
        return result == null ? "" : result.toString();
    }

    public static void main(String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.println(Calculator(s.nextLine()));
    }
}