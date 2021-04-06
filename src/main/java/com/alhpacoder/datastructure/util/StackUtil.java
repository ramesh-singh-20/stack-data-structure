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
}
