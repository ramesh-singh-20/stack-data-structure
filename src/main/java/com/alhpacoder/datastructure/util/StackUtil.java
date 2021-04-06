package com.alhpacoder.datastructure.util;

import java.util.*;

public class StackUtil {

    public static void reverse(LinkedList<Integer> list){
        Stack<Integer> stack= new Stack<>();

        while(!list.isEmpty()){
            stack.push(list.poll());
        }
        list.addFirst(stack.pop());

        while(!stack.isEmpty()){
            list.add(stack.pop());

        }
    }

    public static boolean validateBalancedParenthesis(String expression){
        Stack<Character> charStack= null;

        if(null!= expression && !expression.isEmpty()){
            char[] charArr= expression.toCharArray();
            charStack= new Stack<>();

            for(char ch: charArr) {
                if (ch == '{' || ch == '(' || ch == '[') {
                    charStack.push(ch);
                    continue;
                }
                try {
                    if (ch == '}') {
                        if (charStack.pop() != '{') {
                            return false;
                        }
                    } else if (ch == ']') {
                        if (charStack.pop() != '[') {
                            return false;
                        }
                    } else if (ch == ')') {
                        if (charStack.pop() != '(') {
                            return false;
                        }
                    }
                }catch (EmptyStackException e){
                    return false;
                }
            }
        }
        return (charStack!= null && charStack.isEmpty());
    }

    public static String evaluatePostFixExpression(String expression){
        String[] arr= expression.split(" ");
        Stack<String> stringStack= new Stack<>();
        for(String str: arr){
            if(!(str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/"))){
               stringStack.push(str);
            }else{
                String operand2= stringStack.pop();
                String operand1= stringStack.pop();
                stringStack.push(evaluateExpression
                        (Integer.valueOf(operand1), Integer.valueOf(operand2), str));
            }
        }
        return stringStack.pop();
    }

    private static String evaluateExpression(int operand1, int operand2, String symbol){
        String evaluation="";
        switch(symbol){
            case "+":
                evaluation= String.valueOf(operand1+operand2);
                break;
            case "-":
                evaluation= String.valueOf(operand1-operand2);
                break;
            case "*":
                evaluation= String.valueOf(operand1*operand2);
                break;
            case "/":
                evaluation= String.valueOf(operand1/operand2);
                break;
        }
        return evaluation;
    }
}
