package hw3calculator;

import java.lang.Math;

/**
 * This program takes 2 integers as arguments and displays the product of them
 * @author Guan Yue Wang
 * 2018.06.14
 */
public class Hw3calculator 
{

    /**
     * Main entry point for the program
     * @param args the command line arguments take 2 integers for multiplication
     */
    public static void main(String[] args) 
    {
        int num1, num2, product;
        
        System.out.println("First arg： " +args[0]);
        System.out.println("Second arg： " +args[1]);
        
        num1 = Integer.parseInt(args[0]);
        num2 = Integer.parseInt(args[1]); 
        product = multiplication(num1,num2);
        
        if (product <0)
        {
            System.out.println("Result: (" + Math.abs(product) + ")");
        }
        else
        {
            System.out.println("Result: " + product);
        }

    }
 
    /**
     * This method 
     * @param num1 integer to be used in multiplication
     * @param num2 integer to be used in multiplication
     * @return     the product of num1 and num2
     */
    public static int multiplication(int num1, int num2)
    {
        return num1*num2;   
    }
    
}
