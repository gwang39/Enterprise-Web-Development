/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw4gwang;
import java.util.*;

/**
 * This program tests the Contact, Ship, Destroyer, Submarine, Aircraft, P3 classes
 * by creatingCreate 2 Destroyers, 2 Submarines, 2 P3s, put them into Contacts 
 * collection and print their toString()
 * @author Guan Yue Wang
 */
public class Hw4gwang {

    public static void main(String[] args) 
    {
                
        int count = 1;
        
        // create collection for destroyer, submarine, ship, and contact
        List<Destroyer> destroyerList = new ArrayList<>();
        List<Submarine> submarineList = new ArrayList<>();
        List<Ship> shipList = new ArrayList<>();
        List<Contact> contactList = new ArrayList<>();
        
        // create two destroyers
        System.out.println("Creating two destroyers... ");
        Destroyer destroyer1 = new Destroyer();
        Destroyer destroyer2 = new Destroyer("DestroyerGW","Destroyer", 100, 60, 10);
        
        
         // create two submarines
        System.out.println("Creating two submarines... ");
        Submarine submarine1 = new Submarine();
        Submarine submarine2 = new Submarine("SubmarineGW","Submarine", 50, 60, 4);
        
         // create two P3s
        System.out.println("Creating two P3s... ");
        P3 P3a = new P3();
        P3 P3b = new P3("P3GW","P3", 100, 150,8000, 2); 
        
        
        // make a collection of destroyers
        destroyerList.add(destroyer1);
        destroyerList.add(destroyer2);
        
        // make a collection of submarines
        submarineList.add(submarine1);
        submarineList.add(submarine2);
        
        // submarine exception handling check
        System.out.println("\nSubmarine setNumberTorpedos exception handling check: ");
        submarine2.setNumberTorpedos("Foo");
        
        shipList.addAll(destroyerList);
        shipList.addAll(submarineList);
        
        contactList.addAll(shipList);
        
        contactList.add(P3a);
        contactList.add(P3b);
       
        System.out.println("\nList of contacts:");

        for (int i=0; i < contactList.size(); i++) 
        {
            System.out.print(count+": ");
            System.out.println(contactList.get(i));
            count++;
        }
    }
    
}
