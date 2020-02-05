/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw4gwang;

/**
 * This class constructs a submarine
 * @author Guan Yue Wang
 */
public class Submarine extends Ship 
{
    private int numberTorpedos; 

    /**
     * Default constructor for Submarine
     */
    public Submarine() 
    {
        super();
        this.setType("Submarine");
        this.numberTorpedos = 0;
    }
    
    /**
     * Constructor for Submarine
     * @param name      name of the submarine
     * @param type      type of the submarine
     * @param length    length of the submarine
     * @param speed     speed of the submarine
     * @param torpedosNum number of torpedos of the submarine
     */
    public Submarine(String name, String type, int length, int speed, int torpedosNum) 
    {
        super(name, type, length, speed);
        if (torpedosNum < 0) 
        {
            this.numberTorpedos = 0;
            System.out.println("Invalid number of torpedos: value is set to 0");
        }
        else 
        {
            this.numberTorpedos = torpedosNum;
        }
    }
    
     /**
     * override string representation for Submarine class
     * @return Submarine ship info
     */
    @Override
    public String toString() 
    {
        return super.toString() + "; " + this.numberTorpedos + " torpedos";
    }
    
    /**
     * Get number of torpedos
     * @return number of torpedos
     */
    public int getNumberTorpedos() 
    {
        return numberTorpedos;
    }

    /**
     * Sets the number of torpedos to the given int
     * @param numberTorpedos the numberTorpedos to set
     */
    public void setNumberTorpedos(int numberTorpedos) 
    {
       if (numberTorpedos < 0) 
        {
            System.out.println("Unable to set torpedos: negative input value");
        }
        else 
        {
            this.numberTorpedos = numberTorpedos;
        }
    }
    
    public void setNumberTorpedos(String numberTorpedos) 
    {
        this.numberTorpedos = 2;
        try 
        {
            setNumberTorpedos(Integer.parseInt(numberTorpedos));
        } 
        catch (NumberFormatException e) 
        {
            System.out.println("Unable to parse "+numberTorpedos+" into integer."
                    + " Number of torpedos is set to 2");
        }
    }
    
}
