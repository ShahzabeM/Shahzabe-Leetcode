/**
 * MinStack is a custom stack implementation that supports the following operations in O(1) time:
 * - push(int val): adds a value to the stack
 * - pop(): removes the most recent value
 * - top(): returns the most recent value
 * - getMin(): retrieves the current minimum value in the stack
 *
 * It uses two stacks:
 * 1. stack     → to store all values
 * 2. minStack  → to track the minimum value at each stack level
 *
 * This approach ensures all operations are constant time by syncing both stacks.
 */

class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        // intializing the 2 stacks
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val); // will push the int val to the normal stack
        // if minStack is empty
        if(minStack.isEmpty()){
            // push the int val to the top of the minstack aka new min
            minStack.push(val);
        } else {
            // create int holder for current min val in the top of the stakc via peek
            int currentMin = minStack.peek();
            // will push either val or currentMin, which ever is smaller
            minStack.push(Math.min(val, currentMin));
        }
    }
    
    public void pop() {
        // basic pop off top of the stack for both stacks
        stack.pop();
        minStack.pop();
    }
    
    public int top() {
        // use peek to get the top of a stack
        return stack.peek();
    }
    
    public int getMin() {
        // same as top but for peek
        return minStack.peek();
    }
}

/**
 * This class uses two stacks — one for keeping all the values like a normal stack,
 * and another for keeping track of the smallest value at every step.
 * Every time we add a number, we also update the second stack with the new minimum.
 * That way, we can always get the smallest number instantly, without checking the whole stack.
 */


