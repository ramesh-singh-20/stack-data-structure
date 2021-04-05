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
}
