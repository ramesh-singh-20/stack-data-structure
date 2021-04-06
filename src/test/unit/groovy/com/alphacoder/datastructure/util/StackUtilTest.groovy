package com.alphacoder.datastructure.util

import com.alhpacoder.datastructure.util.StackUtil
import spock.lang.Specification

class StackUtilTest extends Specification{

    def 'Test StackUtil | reverse() | Reverse LinkedList'(){
        given:
        def list= new LinkedList()
        list.add(1)
        list.add(2)
        list.add(3)
        list.add(4)

        when:
        StackUtil.reverse(list)

        then:
        !list.isEmpty()
        list.size()== 4

        and:
        list.get(0)== 4
        list.get(1)== 3
        list.get(2)== 2
        list.get(3)== 1
    }

    def 'Test StackUtil | validateBalancedParenthesis() | Empty string'(){
        given:
        def expression= "";

        when:
        def result= StackUtil.validateBalancedParenthesis(expression)

        then:
        !result
    }

    def 'Test StackUtil | validateBalancedParenthesis() | unbalanced parenthesis string'(){
        given:
        def expression= ")(";

        when:
        def result= StackUtil.validateBalancedParenthesis(expression)

        then:
        !result
    }

    def 'Test StackUtil | validateBalancedParenthesis() | balanced parenthesis string'(){
        given:
        def expression= "A+B*(B/C{B*F[R*I]})";

        when:
        def result= StackUtil.validateBalancedParenthesis(expression)

        then:
        result
    }

    def 'Test StackUtil | validateBalancedParenthesis() | unbalanced parenthesis complex string'(){
        given:
        def expression= "A+B*(B/C{B*F[R*I}])";

        when:
        def result= StackUtil.validateBalancedParenthesis(expression)

        then:
        !result
    }
}
