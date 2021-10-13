// ***************************************************************
// ArrayStack.java
//
// An array-based Object stack class with operations push,
// pop, and isEmpty and isFull.
//
// ***************************************************************
public class ArrayStack implements StackADT
    {
    private int stackSize; // capacity of stack
    private int top; // index of slot for next element
    private Object[] elements;
    // ---------------------------------------------------
    // Constructor -- initializes top and creates array
    // ---------------------------------------------------
    public ArrayStack(int size)
    {
        stackSize = size;
        elements = new Object[stackSize];
        top = 0;
    }
    // --------------------------------------------------
    // Adds element to top of stack if it's not full, else
    // does nothing.
    // --------------------------------------------------
    public void push(Object val)
    {
        if(!isFull()) //Check if elements is not full
        {
            elements[top] = val;
            if(top < stackSize)
            {
                top++;
            }
        }
    }
    // ---------------------------------------------------
    // Removes and returns value at top of stack. If stack
    // is empty returns null.
    // ---------------------------------------------------
    public Object pop()
    {
        Object o = null;
        if(!isEmpty())
        {
            if(top > 0)
            {
                top--;
            }
            o = elements[top];
            elements[top] = null;
        }
        return o;
    }
    // ---------------------------------------------------
    // Returns true if stack is empty, false otherwise.
    // ---------------------------------------------------
    public boolean isEmpty()
    {
        // boolean isEmpty = true;
        if(top == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    // ---------------------------------------------------
    // Returns true if stack is full, false otherwise.
    // ---------------------------------------------------
    public boolean isFull()
    {
        if(top == stackSize)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
