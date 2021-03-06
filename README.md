# stack-data-structure

**Abstract Data Definition**

Stack is a list that has a restriction that insertion and deletion will happen only at one end that is called as Top.

**Operations**

push(int data): Time complexity should be O(1).

pop(int data): Time complexity should be O(1).

top(): return the element at the top. Time complexity should be O(1).

isEmpty(): returns true when list is empty. Time complexity should be O(1).

**Utilities**

Reverse LinkedList using Stack. Assumptions are that top() is returning top element without removing and pop() is returning the deleted element.

Check for balanced parenthesis in a given string.

Evaluate post-fix expression. Assumption is expression uses space as a separator.

Conversion of infix to postfix expression. Assumption is expression uses space as a separator.


**Note**

In array implementation of stack push has worst case scenario of O(n) when stack is full.

**Testing**

Spock framework with Groovy is used for unit testing.

**Note**

To run test cases please mark test/unit/groovy folder as Test Resources Root.