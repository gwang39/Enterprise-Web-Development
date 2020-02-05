/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw4gwang;

/**
 * Contact interface for ships and airplanes
 * @author Guan Yue Wang
 */
public interface Contact 
{
    
    /**
     * Get length of the object
     * @return length of the object
     */
    int getLength();
    
    
    /**
     * Set length of the object
     * @param length length of the object
     */
    void setLength(int length);
    
    
    /**
     * Get speed of the object
     * @return 
     */
    int getSpeed();
    
    
    /**
     * Set speed of the object
     * @param speed speed of the object
     */
    void setSpeed(int speed);
    
    
    /**
     * Set speed of the object
     * @param speed String text represents speed of the object
     */
    void setSpeed(String speed);
    
    
    /**
     * Get name of the object
     * @return name of the object
     */
    String getName();
    
    
    /**
     * Set name of the object
     * @param name name of the object
     */
    void setName(String name);
    
    
    /**
     * get type of the object
     * @return type of the object
     */
    String getType();
    
    
    /**
     * Set type of the object
     * @param type type of the object
     */
    void setType(String type);
}
