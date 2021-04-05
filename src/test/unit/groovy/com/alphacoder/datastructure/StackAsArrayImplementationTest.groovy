package com.alphacoder.datastructure

import spock.lang.Specification

class StackAsArrayImplementationTest extends  Specification{

    def 'Test StackAsArrayImplementation | isEmpty() | stack is empty'(){
        given:
        def stack= new StackAsArrayImplementation()

        when:
        def result= stack.isEmpty()

        then:
        result
    }

    def 'Test StackAsArrayImplementation | isEmpty() | stack is not empty'(){
        given:
        def stack= new StackAsArrayImplementation()
        stack.push(2)

        when:
        def result= stack.isEmpty()
        def top= stack.top()

        then:
        !result

        and:
        top== 2
    }

    def 'Test StackAsArrayImplementation | top() | stack is empty'(){
        given:
        def stack= new StackAsArrayImplementation()

        when:
        stack.top()

        then:
        thrown(UnsupportedOperationException)
    }

    def 'Test StackAsArrayImplementation | push()'(){
        given:
        def stack= new StackAsArrayImplementation()

        when:
        stack.push(2)
        stack.push(3)
        stack.push(4)

        then:
        !stack.isEmpty()
        stack.top()== 4

    }

    def 'Test StackAsArrayImplementation | pop() | stack is empty'(){
        given:
        def stack= new StackAsArrayImplementation()

        when:
        stack.pop()

        then:
        thrown(UnsupportedOperationException)
    }

    def 'Test StackAsArrayImplementation | pop() | stack is not empty'(){
        given:
        def stack= new StackAsArrayImplementation()
        stack.push(2)

        when:
        stack.pop()

        then:
        stack.isEmpty()

    }

    def 'Test StackAsArrayImplementation | pop() | multiple elements'(){
        given:
        def stack= new StackAsArrayImplementation()
        stack.push(2)
        stack.push(4)
        stack.push(5)
        stack.push(8)

        when:
        stack.pop()
        stack.pop()

        then:
        !stack.isEmpty()

        and:
        stack.top()== 4

    }

    def 'Test StackAsArrayImplementation | push() | elements greater than initial size'(){
        given:
        def stack= new StackAsArrayImplementation()
        stack.push(2)
        stack.push(4)
        stack.push(5)
        stack.push(8)
        stack.push(3)
        stack.push(7)
        stack.push(9)
        stack.push(1)
        stack.push(9)
        stack.push(3)
        stack.push(5)

        when:
        stack.pop()
        stack.pop()

        then:
        !stack.isEmpty()

        and:
        stack.top()== 9

    }

    def 'Test StackAsArrayImplementation | push() | elements greater than double the initial size'(){
        given:
        def stack= new StackAsArrayImplementation()
        stack.push(2)
        stack.push(4)
        stack.push(5)
        stack.push(8)
        stack.push(3)
        stack.push(7)
        stack.push(9)
        stack.push(1)
        stack.push(9)
        stack.push(3)
        stack.push(5)
        stack.push(2)
        stack.push(4)
        stack.push(5)
        stack.push(8)
        stack.push(3)
        stack.push(7)
        stack.push(9)
        stack.push(1)
        stack.push(9)
        stack.push(3)
        stack.push(5)

        when:
        stack.pop()
        stack.pop()
        stack.pop()
        stack.pop()
        stack.pop()
        stack.pop()
        stack.pop()
        stack.pop()
        stack.pop()
        stack.pop()

        then:
        !stack.isEmpty()

        and:
        stack.top()== 2

    }
}
