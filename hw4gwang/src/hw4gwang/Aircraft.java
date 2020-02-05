/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw4gwang;

/**
 * This class constructs a aircraft
 * @author Guan Yue Wang
 */
public class Aircraft implements Contact
{
    private int length;
    private int speed;
    private int altitude;
    private String name;
    private String type;

    
    /**
     * Default constructor for Aircraft
     */
    public Aircraft() 
    {
        this.name = "Unknown Aircraft";
        this.type = "Aircraft";
        this.length = 0;
        this.speed = 0;
        this.altitude = 0;
    }
    
    /**
     * Constructor for Aircraft
     * @param name
     * @param type
     * @param length
     * @param speed
     * @param altitude 
     */
    public Aircraft(String name, String type, int length, int speed,  int altitude) 
    {
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
            this.speed = length;

        }
        
        if (altitude < 0) 
        {
            this.altitude = 0;
            System.out.println("Invalid speed: speed is set to 0.");
        } 
        else 
        {
            this.altitude = altitude;

        }
    }
    
     /**
     * override string representation for Aircraft class
     * @return  aircraft information
     */
    @Override
    public String toString() 
    {
        String info = this.type + " - Name: " + this.name+ "; Length:" + 
                this.length + " ft, Speed " + this.speed +" mph; Altitude: "+
                this.altitude +" ft";
        return info;
    }

     /**
     * Get length of the aircraft
     * @return length of the aircraft
     */
    @Override
    public int getLength() 
    {
        return length;
    }

    /**
     * Set length of the aircraft
     * @param length length of the aircraft
     */
    @Override
    public void setLength(int length) 
    {
        if (length < 0) 
        {
            System.out.println("Unable to set length: negative value input");
        } 
        else 
        {
            this.length = length;
        }
    }
    
    /**
     * Get speed of the aircraft
     * @return the speed of the aircraft
     */
    @Override
    public int getSpeed() 
    {
        return speed;
    }

    /**
     * Set speed of the aircraft
     * @param speed the speed of the aircraft
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
     * Set speed of the aircraft
     * @param speed string value represents the speed of the aircraft
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
     * Get name of the aircraft
     * @return the name of the aircraft
     */
    @Override
    public String getName() 
    {
        return name;
    }

    /**
     * Set name of the aircraft
     * @param name name of the aircraft
     */
    @Override
    public void setName(String name) 
    {
        this.name = name;
    }

    /**
     * Get type of the aircraft
     * @return type of the aircraft
     */
    @Override
    public String getType() 
    {
        return type;
    }

    /**
     * Set type for the aircraft
     * @param type type of the aircraft
     */
    @Override
    public void setType(String type) 
    {
        this.type = type;
    }
        
    /**
     * Get altitude of the aircraft
     * @return altitude of the aircraft
     */
    public int getAltitude() 
    {
        return altitude;
    }

    /**
     * Set altitude of the aircraft
     * @param altitude altitude of the aircaft
     */
    public void setAltitude(int altitude) 
    {
        if (altitude < 0) 
        {
            System.out.println("Unable to set altitude: negative altitude input");
        } else 
        {
            this.altitude = altitude;
        }
    }


}
