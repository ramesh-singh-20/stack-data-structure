package com.alhpacoder.datastructure.util;

import java.util.LinkedList;
import java.util.Stack;

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
}
