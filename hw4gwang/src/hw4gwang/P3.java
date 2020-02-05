/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw4gwang;

/**
 * This class constructs a P3 aircraft
 * @author Guan Yue Wang
 */
public class P3 extends Aircraft{

    private int numberEngines;

    public P3() 
    {
        super();
        this.numberEngines = 1;
        this.setName("Unknown P3");
        this.setType("P3");
    }
    
    public P3(String name, String type, int length, int speed, int altitude, int numberEngines) {
        super(name, type, length, speed, altitude);
        if (numberEngines < 0) 
        {
            this.numberEngines = 1;
            System.out.println("Invalid number of engines: value is set to 1");
        }
        else 
        {
            this.numberEngines = numberEngines;
        }
    }
    
    /**
     * override string representation for Destroyer class
     * @return Destroyer ship info
     */
    @Override
    public String toString() 
    {
        return super.toString() + " ," + this.numberEngines + " engines";
    }
    
    /**
     * Get number of engines
     * @return number of engines
     */
    public int getNumberEngines() 
    {
        return numberEngines;
    }

    /**
     * Sets the number of engines
     * @param numberEngines the numberEngines to set
     */
    public void setNumberEngines(int numberEngines) {
       if (numberEngines < 0) 
        {
            System.out.println("Unable to set torpedos: negative input value");
        }
        else 
        {
            this.numberEngines = numberEngines;
        }
    } 
}
