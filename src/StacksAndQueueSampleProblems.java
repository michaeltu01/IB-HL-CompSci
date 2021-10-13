import java.util.*;

public class StacksAndQueueSampleProblems
{
    public static Stack<Object> stack()
    {
        Stack<Object> stack = new Stack<>();
        stack.add("Terry");
        stack.add("Maya");
        stack.add("Jerome");
        stack.add("Roger");
        stack.add("Rita");
        stack.add("Abby");
        stack.add("Zane");
        stack.add("Sasha");
        return stack;
    }

    public static Object matchName()
    {
        Scanner scan = new Scanner(System.in); //Create Scanner object
        
        System.out.println("Enter the name you want to search: ");
        String name = scan.nextLine();

        Stack<Object> temp = new Stack<Object>();
        temp = stack();

        System.out.println(temp);

        int i = 0;
        int cout = 0;
        while(cout < temp.size())
        {
            if(temp.pop().equals(name))
            {
                return i;
            }
            else
            {
                i++;
            }
        }
        return null;
    }

    public static Queue<Object> switchToQueue()
    {
        Queue<Object> queue = new LinkedList<>();
        int i = 0;
        Stack<Object> temp = new Stack<Object>();
        temp = stack();
        Object o = new Object();

        while(i < temp.size())
        {
            o = temp.pop();
            queue.add(o);
        }

        return queue;
    }
    public static void main(String[] args)
    {
        System.out.println(matchName() + "\n");

        System.out.println("After transferring to a queue... ");
        System.out.println(switchToQueue());
    }
}