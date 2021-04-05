package com.alphacoder.datastructure;

import lombok.Data;
import lombok.Getter;

@Getter
public class StackAsLinkedListImplementation {
    private Node head;

    public boolean isEmpty(){
        return (head==null);
    }

    public int top(){
        if(head== null){
            throw new UnsupportedOperationException("Stack is empty.");
        }
        return this.head.getData();
    }

    public void push(int data){
        Node node= new Node();
        node.setData(data);
        if(head== null){
            this.head= node;
        }else{
            node.setNext(this.head);
            this.head= node;
        }
    }

    public void pop(){
        if(head== null){
            throw new UnsupportedOperationException("Stack is empty.");
        }
        this.head= this.head.getNext();
    }
}
