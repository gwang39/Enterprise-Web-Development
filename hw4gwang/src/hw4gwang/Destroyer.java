/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw4gwang;

/**
 * This class constructs a destroyer
 * @author Guan Yue Wang
 */
public class Destroyer extends Ship
{
    private int numberMissile;

    /**
     * Default constructor for Destroyer
     */
    public Destroyer() 
    {
        super();
        this.setType("Destroyer");
        this.numberMissile = 0;
    }
    
    /**
     * Constructor for Destroyer
     * @param name      name of the destroyer
     * @param type      type of the destroyer
     * @param length    length of the destroyer
     * @param speed     speed of the destroyer
     * @param missileNum number of missiles of the destroyer
     */
    public Destroyer(String name, String type, int length, int speed, int missileNum) 
    {
        super(name, type, length, speed);
        if (missileNum < 0) 
        {
            this.numberMissile = 0;
            System.out.println("Invalid number of missle: value is set to 0");
        }
        else 
        {
            this.numberMissile = missileNum;
        }
    }
    
    /**
     * override string representation for Destroyer class
     * @return Destroyer ship info
     */
    @Override
    public String toString() 
    {
        return super.toString() + "; " + this.numberMissile + " missiles";
    }
    
    
    /**
     * Get number of missiles of the destroyer
     * @return numer of missiles
     */
    public int getNumberMissiles() 
    {
        return numberMissile;
    }

    /**
     * Set number of missiles
     * @param missileNum number of missiles of the destroyer
     */
    public void setNumberMissiles(int missileNum) {
        if (missileNum < 0) 
        {
            System.out.println("Unable to set missile: negative input value");
        }
        else 
        {
            this.numberMissile = missileNum;
        }
    }
    
    /**
     * Set number of missiles
     * @param missileNum number of missiles of the destroyer
     */
    public void setNumberMissiles(String missileNum) {
        this.numberMissile = 2;
        try 
        {
            setNumberMissiles(Integer.parseInt(missileNum));
        } 
        catch (NumberFormatException e) 
        {
            System.out.println("Unable to parse "+missileNum+" into integer."
                    + " Missile number is set to 2");
        }
    }
}
