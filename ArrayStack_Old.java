// ***************************************************************
// ArrayStack.java
//
// An array-based Object stack class with operations push,
// pop, and isEmpty and isFull.
//
// ***************************************************************
public class ArrayStack_Old implements StackADT
    {
    private int stackSize = 5; // capacity of stack
    private int top; // index of slot for next element
    private Object[] elements;
    // ---------------------------------------------------
    // Constructor -- initializes top and creates array
    // ---------------------------------------------------
    public ArrayStack_Old()
    {
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
            outerloop:
            for(int i = 0; i < elements.length; i++)
            {
                if(elements[i] == null)
                {
                    top = i;
                    elements[top] = val;
                    break outerloop;
                }
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
            //Checks for the object at the top of the stack
            for(int i = elements.length - 1; i >= 0; i--)
            {
                if(!(elements[i] == null)) //Search through list for objects not null
                {
                    o = elements[i];
                    elements[i] = null;
                    break;
                }
            }
        }
        return o;
    }
    // ---------------------------------------------------
    // Returns true if stack is empty, false otherwise.
    // ---------------------------------------------------
    public boolean isEmpty()
    {
        // boolean isEmpty = true;
        for(Object o : elements)
        {
            if(o != null)
            {
                return false;
            }
        }

        return true;
    }
    // ---------------------------------------------------
    // Returns true if stack is full, false otherwise.
    // ---------------------------------------------------
    public boolean isFull()
    {
        boolean isFull = true;
        for(Object o: elements)
        {
            if(o == null)
            {
                isFull = false;
            }
        }
        
        return isFull;
    }
}
