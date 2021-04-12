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

    public static String evaluatePreFixExpression(String expression){
        String[] arr= expression.split(" ");
        Stack<String> stringStack= new Stack<>();
        for(int i=arr.length-1; i>=0; i--){
            if(!(arr[i].equals("+") || arr[i].equals("-") || arr[i].equals("*") || arr[i].equals("/"))){
                stringStack.push(arr[i]);
            }else{
                String operand1= stringStack.pop();
                String operand2= stringStack.pop();
                stringStack.push(evaluateExpression
                        (Integer.valueOf(operand1), Integer.valueOf(operand2), arr[i]));
            }
        }
        return stringStack.pop();
    }

    public static String convertInfixToPostfix(String infixExpression){
        String [] arr= infixExpression.split(" ");
        Stack<String> stringStack= new Stack<>();
        String postFixExpression= "";

        for(String str: arr){
            if(!(str.equalsIgnoreCase("+") || str.equalsIgnoreCase("-")
               || str.equalsIgnoreCase("*") || str.equalsIgnoreCase("/"))){
                postFixExpression+= str;
                postFixExpression+=" ";

            }else{
                if(!stringStack.isEmpty()){
                    if(str.equalsIgnoreCase("*") || str.equalsIgnoreCase("/")){
                        stringStack.push(str);
                    }else{
                        if(stringStack.peek().equalsIgnoreCase("*") ||
                                stringStack.peek().equalsIgnoreCase("/")){
                            while(!stringStack.isEmpty()){
                                postFixExpression+= stringStack.pop();
                                postFixExpression+=" ";
                            }
                            stringStack.push(str);
                        }
                    }
                }else{
                    stringStack.push(str);
                }
            }
        }
        while(!stringStack.isEmpty()){
            postFixExpression+= stringStack.pop();
            postFixExpression+=" ";
        }
        postFixExpression= postFixExpression.substring(0, postFixExpression.length()-1);
        return postFixExpression;
    }
}
