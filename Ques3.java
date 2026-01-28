package Collections;

import java.util.Stack;

class SpecialStack {
//here the key idea is that we have two Stacks one is mainStack and another is minStack
    //in mainStack we store all the element
    private Stack<Integer> mainStack;
    //in minstack we are checking at each state and updating the top
    private Stack<Integer> minStack;
    private int capacity;

    public SpecialStack(int capacity) {
        this.capacity = capacity;
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }

    // push operation
    public void push(int x) {
        if (isFull()) {
            System.out.println("Stack Overflow");
            return;
        }

        mainStack.push(x); //pushing to mainStack
        //checking the top of the stack with the value if it is smaller then insert it
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    // pop operation
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        }
        //popping the element from the mainStack
        int popped = mainStack.pop();
        //checking if the popped element is also present in minStack then pop it
        if (popped == minStack.peek()) {
            minStack.pop();
        }

        return popped;
    }

    // get minimum element
    public int getMin() {
        if (minStack.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        //returning the top of the minstack
        return minStack.peek();
    }

    public boolean isEmpty() {
        return mainStack.isEmpty();
    }

    public boolean isFull() {
        return mainStack.size() == capacity;
    }
}

public class Ques3 {
    public static void main(String[] args) {
        //initializing stack with the capacity of 5
        SpecialStack stack = new SpecialStack(5);

        stack.push(10);
        stack.push(20);
        stack.push(5);
        stack.push(15);
        //getting minimum that will use minstack behind
        System.out.println("Minimum :- " + stack.getMin());

        stack.pop();
        stack.pop();

        System.out.println("Minimum :- " + stack.getMin());
    }
}
