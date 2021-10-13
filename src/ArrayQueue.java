//**********************************************************
// ArrayQueue.java
// An array-based implementation of the classic FIFO queue interface.
//**********************************************************
public class ArrayQueue implements QueueADT
{
private final int DEFAULT_SIZE = 5;
private Object[] elements;
private int numElements;
private int front, back;
//---------------------------------------------
// Constructor; creates array of default size.
//---------------------------------------------
public ArrayQueue()
{
    elements = new Object[DEFAULT_SIZE];
    numElements = 0;
    front = 0;
    back = 0;
}
//---------------------------------------------
// Puts item on end of queue.
//---------------------------------------------
public void enqueue(Object item)
{
    if(!isFull())
    {
        elements[back] = item; //Filling up array; back = the next available position
        if(back < elements.length) //Make sure back doesn't exceed the length of the array
        {
            back++;
        }
        numElements++;
    }
}
//---------------------------------------------
// Removes and returns object from front of queue.
//---------------------------------------------
public Object dequeue()
{
    Object o = new Object();
    Object[] temp = new Object[elements.length];

    if(!isEmpty())
    {
        o = elements[front];
        int j = 0;

        for(int i = front + 1; i < elements.length; i++)
        {
                temp[j] = elements[i];
                j++;
        }
        elements = temp;
        back--;
        numElements--;
    }
    return o;
}
//---------------------------------------------
// Returns true if queue is empty.
//---------------------------------------------
public boolean isEmpty()
{
    if(back == 0)
    {
        return true;
    }
    else
    {
        return false;
    }
}
//-----------------------------------------
// Returns true if queue is full.
//-----------------------------------------
public boolean isFull()
{
    if(back >= elements.length)
    {
        return true;
    }
    else
    {
        return false;
    }
}
//---------------------------------------------
// Returns the number of elements in the queue.
//---------------------------------------------
public int size()
{
    return numElements;
}
//---------------------------------------------
// Returns a string containing the elements of the queue
// from first to last
//---------------------------------------------
public String toString()
{
    String result = "\n";
    for (int i = front, count=0; count < numElements; i=(i+1)%elements.length,count++)
    {
        result = result + elements[i]+ "\n";
    }
    return result;
}
}