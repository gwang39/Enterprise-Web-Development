/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw6gw;


/**
 * This program prompts user to input tour details and provides them a tour quote from BHC server
 * @author Guan Yue Wang
 */

import javax.swing.*;


public class Hw6gw extends JFrame 
{

    public static void main(String[] args) 
    {
        // create a new GUI frame
        Hw6Frame QuoteChecker = new Hw6Frame();
        
        // initiate the frame
        
        QuoteChecker.setTitle("Get A Quote - BHC Tour");
        QuoteChecker.setSize(450, 400);
        QuoteChecker.setVisible(true);
        QuoteChecker.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}


