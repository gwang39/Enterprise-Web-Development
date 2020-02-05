/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw4gwang;

/**
 * This class constructs a ship
 * @author Guan Yue Wang
 */
public class Ship implements Contact
{
    
    private int length;
    private int speed;
    private String name;
    private String type;

    /**
     * Default constructor for Ship
     */
    public Ship() 
    {
        this.name = "Unknown Ship";
        this.type = "Ship";
        this.length = 0;
        this.speed = 0; 
    }
    
    /**
     * Constructor for Ship
     * @param name      name of the ship
     * @param length    length of the ship
     * @param speed     speed of the ship
     */
    public Ship(String name, String type, int length, int speed) {
        this.name = name;
        this.type = type;
        
        if (length < 0) 
        {
            this.length = 0;
             System.out.println("Invalid length: length is set to 0.");
        } 
        else 
        {
            this.length = length;

        }
        if (speed < 0) 
        {
            this.speed = 0;
            System.out.println("Invalid speed: speed is set to 0.");
        } 
        else 
        {
            this.speed = speed;

        }
    }
    
    /**
     * override string representation for Ship class
     * @return  ship information
     */
    @Override
    public String toString() 
    {
        String info = this.type + " - Name: " + this.name+ "; Length: " + 
                this.length + " ft; Speed " + this.speed +" mph";
        
        return info;
    }
    /**
     * Get length of the ship
     * @return length of the ship
     */
    @Override
    public int getLength() 
    {
        return length;
    }

    /**
     * Set length of the ship
     * @param length length of the ship
     */
    @Override
    public void setLength(int length) 
    {
        if (length < 0) 
        {
            System.out.println("Unable to set length: negative value input");
        } else 
        {
            this.length = length;
        }
    }
    
    /**
     * Get speed of the ship
     * @return the speed of the ship
     */
    @Override
    public int getSpeed()
    {
        return speed;
    }

    /**
     * Set speed of the ship
     * @param speed the speed of the ship
     */
    @Override
    public void setSpeed(int speed) 
    {
        if (speed < 0) 
        {
            System.out.println("Unable to set speed: negative speed input");
        } else 
        {
            this.speed = speed;
        }
    }

    /**
     * Set speed of the ship
     * @param speed string value represents the speed of the ship
     */
    @Override
    public void setSpeed(String speed) 
    {
        try 
        {
            setSpeed(Integer.parseInt(speed));
        } 
        catch (NumberFormatException e) 
        {
            System.out.println("Unable to parse string input: speed is set to 0");
        }
    }
    
    /**
     * Get name of the ship
     * @return the name of the ship
     */
    @Override
    public String getName() 
    {
        return name;
    }

    /**
     * Set name of the ship
     * @param name name of the ship
     */
    @Override
    public void setName(String name) 
    {
        this.name = name;
    }

    /**
     * Get type of the ship
     * @return type of the ship
     */
    @Override
    public String getType() 
    {
        return type;
    }

    /**
     * Set type for the ship
     * @param type type of the ship
     */
    @Override
    public void setType(String type) 
    {
        this.type = type;
    }
    
}
