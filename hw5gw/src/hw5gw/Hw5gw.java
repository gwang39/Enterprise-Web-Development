/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw5gw;


/**
 * This program prompts user to input tour details and provides them a BHC tour quote
 * @author Guan Yue Wang
 */

import javax.swing.*;


public class Hw5gw extends JFrame 
{

    public static void main(String[] args) 
    {
        // create a new GUI frame
        Hw5Frame CostChecker = new Hw5Frame();
        
        // initiate the frame
        
        CostChecker.setTitle("Get A Quote - BHC Tour");
        CostChecker.setSize(450, 400);
        CostChecker.setVisible(true);
        CostChecker.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}


