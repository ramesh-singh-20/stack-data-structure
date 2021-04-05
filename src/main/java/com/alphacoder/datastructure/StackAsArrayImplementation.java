package com.alphacoder.datastructure;

import lombok.Data;
import lombok.Getter;

@Getter
public class StackAsArrayImplementation {
    private final static int INIT_CAPACITY= 10;
    private static int CURRENT_CAPACITY= INIT_CAPACITY;
    private int arr[];
    private int top;

    public StackAsArrayImplementation(){
        this.arr= new int[CURRENT_CAPACITY];
        this.top= -1;
    }

    public boolean isEmpty(){
        return (top== -1);
    }

    public int top(){
        if(top== -1){
            throw new UnsupportedOperationException("Stack is empty.");
        }
        return this.arr[top];
    }

    public void push(int data){
        this.top++;
        if(top== CURRENT_CAPACITY){
            doubleCurrentCapacity();
        }
        this.arr[top]= data;
    }

    public void pop(){
        if(top== -1){
            throw new UnsupportedOperationException("Stack is empty.");
        }
        this.top--;
    }

    private void doubleCurrentCapacity(){
        CURRENT_CAPACITY*= 2;
        int newArr[]= new int[CURRENT_CAPACITY];

        for(int i=0; i< this.arr.length; i++){
            newArr[i]= this.arr[i];
        }

        this.arr= newArr;
    }

}
