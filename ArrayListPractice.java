import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.swing.*;

public class ArrayListPractice
{
    public static void problem1()
    {
        System.out.println("Problem 1: ");

        //Initialize the array list
        ArrayList<String> myFamily = new ArrayList<String>();

        //Fill the array list
        myFamily.add("Michael");
        myFamily.add("Maggie");
        myFamily.add("Cindy");
        myFamily.add("Shaofeng");

        //Print size of the array
        System.out.println("Size of family: " + myFamily.size());
        
        //Print name of each person with for loop
        for(int i = 0; i < myFamily.size(); i++)
        {
            System.out.println(myFamily.get(i));
        }
        System.out.println();

        //Print name of each person with for-each loop
        for(String str : myFamily)
        {
            System.out.println(str);
        }
    }

    public static void problem2()
    {
        System.out.println("\n" + "Problem 2: ");
        //Initialize the array list
        ArrayList<String> universities = new ArrayList<String>();

        //Fill the array list
        boolean b = true;
        while(universities.size() <= 3)
        {
            String str = JOptionPane.showInputDialog("Enter a university with a 4-letter name: ");
            while(str.length() != 4)
            {
                str = JOptionPane.showInputDialog("Make sure the university has only 4-letters.");
            }
            universities.add(str);
        }

        while(b)
        {
            String str = JOptionPane.showInputDialog("Enter a university of any length: ");
            universities.add(str);
            if(universities.size() >= 5)
            {
                str = JOptionPane.showInputDialog("Would you like to continue inputting universities (Y or N)?");
                if(!(str.equalsIgnoreCase("Y") || str.equalsIgnoreCase("N")))
                {
                    str = JOptionPane.showInputDialog("Please type Y or N");
                }
                if(str.equalsIgnoreCase("N"))
                {
                    b = false;
                }
            }
        }
        //Print size of array list
        System.out.println("The amount of universities you inputted was " + universities.size());

        //Print array list with for-each loop
        for(String str : universities)
        {
            System.out.println(str);
        }

        //Remove all 4-letter universities
        for(int i = 0; i < universities.size(); i++)
        {
            if(universities.get(i).length() == 4)
            {
                universities.remove(i);
                i--;
            }
        }

        //Print new size of array list
        System.out.println("\n" + "After removing universities with name length of 4, the length of the list is now " + universities.size());

        //Print universities remaining in the list
        for(String str : universities)
        {
            System.out.println(str);
        }
    }

    public static void problem3()
    {
        System.out.println("\n Problem 3: ");

        //Initialize schools
        String uni1 = new String("Stanford");
        String uni2 = new String("UVA");
        String uni3 = new String("UCLA");

        //Comparing
        System.out.println(uni1.compareTo(uni2));
        System.out.println(uni2.compareTo(uni3));

        /*
        a) The compareTo method tells us whether the first string comes before the other in alphabetical order and how many letters away.
        b) When comparing uni2 and uni3 (two schools that started with the same letter but differentiate from there), the compareTo evidently checks one char at a time,
        moving on to the next char.
        */
    }

    public static void problem4()
    {
        //Allow user input of password
        System.out.println();
        String password = JOptionPane.showInputDialog("A valid password is one with at least 6 characters and at least one non-alphanumeric character (+, -, *, /, or @).\n Enter a valid password: ");
        
        //Password not long enough
        while(password.length() < 6)
        {
            password = JOptionPane.showInputDialog("Please enter a password at least 6 characters long: ");
        }

        //Password with no non-alphanumeric character
        boolean noChar = true;
        Set<String> characters = new HashSet<String>();
        characters.add("+");
        characters.add("-");
        characters.add("*");
        characters.add("/");
        characters.add("@");

        outerloop:
        while(noChar)
        {
            for(int i = 0; i < password.length(); i++)
            {
                String s = password.substring(i, i + 1);
                if(characters.contains(s))
                {
                    break outerloop;   
                }
            }
            password = JOptionPane.showInputDialog("Please enter a password with at least one non-alphanumeric character (+, -, *, /, or @).");
        }

        //Print success message
        System.out.println("Password verified!");
    }

    public static void main(String[] args)
    {
        problem1();
        problem2();
        problem3();
        problem4();
    }
}