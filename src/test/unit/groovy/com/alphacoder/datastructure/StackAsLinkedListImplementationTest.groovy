package com.alphacoder.datastructure

import spock.lang.Specification

class StackAsLinkedListImplementationTest extends Specification{


    def 'Test StackAsLinkedListImplementation | isEmpty() | stack is empty'(){
        given:
        def stack= new StackAsLinkedListImplementation()

        when:
        def result= stack.isEmpty()

        then:
        result
    }

    def 'Test StackAsLinkedListImplementation | isEmpty() | stack is not empty'(){
        given:
        def stack= new StackAsLinkedListImplementation()
        stack.push(2)

        when:
        def result= stack.isEmpty()
        def top= stack.top()

        then:
        !result

        and:
        top== 2
    }

    def 'Test StackAsLinkedListImplementation | top() | stack is empty'(){
        given:
        def stack= new StackAsLinkedListImplementation()

        when:
        stack.top()

        then:
        thrown(UnsupportedOperationException)
    }

    def 'Test StackAsLinkedListImplementation | push()'(){
        given:
        def stack= new StackAsLinkedListImplementation()

        when:
        stack.push(2)
        stack.push(3)
        stack.push(4)

        then:
        !stack.isEmpty()
        stack.top()== 4

    }

    def 'Test StackAsLinkedListImplementation | pop() | stack is empty'(){
        given:
        def stack= new StackAsLinkedListImplementation()

        when:
        stack.pop()

        then:
        thrown(UnsupportedOperationException)
    }

    def 'Test StackAsLinkedListImplementation | pop() | stack is not empty'(){
        given:
        def stack= new StackAsLinkedListImplementation()
        stack.push(2)

        when:
        stack.pop()

        then:
        stack.isEmpty()

    }

    def 'Test StackAsLinkedListImplementation | pop() | multiple elements'(){
        given:
        def stack= new StackAsLinkedListImplementation()
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
}
