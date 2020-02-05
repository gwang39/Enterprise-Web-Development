/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw6gw;

/**
 * This program creates the GUI frame for BHC quote checker
 * @author Guan Yue Wang
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;


public class Hw6Frame extends JFrame
{
    
    // creates buttons, combobox, labels, text fields
    private JLabel routeLabel = new JLabel("Please select a route: ");
    private JLabel startDateLabel = new JLabel("Please input your start date: ");;
    private JLabel quoteLabel = new JLabel("                                     Total Cost:    ");
    private JLabel durationLabel = new JLabel("Please select tour duration: ");;
    private JLabel quote = new JLabel("  ");
    private JLabel lineLabel = new JLabel("      ");
    
    private JLabel yearLabel = new JLabel(" Year ");
    private JLabel monthLabel = new JLabel(" Month ");
    private JLabel dayLabel = new JLabel(" Day ");
    
    private JTextField yearField;
    private JTextField monthField;
    private JTextField dayField;

    private JComboBox durationBox = new JComboBox();

    private JRadioButton routeHP = new JRadioButton("Hellroaring Plateau");
    private JRadioButton routeGL = new JRadioButton("Gardiner Lake");
    private JRadioButton routeBP = new JRadioButton("Beaten Path");
    private ButtonGroup routeGroup = new ButtonGroup();

    private JButton submit = new JButton("Get A Quote");

    private JPanel routePanel0 = new JPanel();
    private JPanel routePanel = new JPanel();

    private JPanel datePanel0 = new JPanel();
    private JPanel datePanel = new JPanel();

    private JPanel durationPanel0 = new JPanel();
    private JPanel durationPanel = new JPanel();

    private JPanel submitPanel0 = new JPanel();
    private JPanel submitPanel = new JPanel();

    private JPanel quotePanel0 = new JPanel();
    private JPanel quotePanel = new JPanel();

    //private Rates rates;
    
    private String hike_id = "";
    private String finalQuote = "";

    public Hw6Frame()
    {
        // create layout
        FlowLayout myFrame = new FlowLayout(FlowLayout.CENTER); 
        setLayout(myFrame);

        routeGroup.add(routeGL);
        routeGroup.add(routeHP);
        routeGroup.add(routeBP);	

        durationBox.setPreferredSize(new Dimension(100,25));
        submit.setPreferredSize(new Dimension(200,25));

        durationPanel.add(durationBox);


        monthField = new JTextField("MM", 3);
        dayField = new JTextField("DD", 3);
        yearField = new JTextField("YYYY", 4);

        routePanel0.add(routeLabel);
        routePanel.add(routeHP);
        routePanel.add(routeGL);
        routePanel.add(routeBP);

        datePanel0.add(startDateLabel);
        datePanel.add(yearLabel);
        datePanel.add(yearField);
        datePanel.add(monthLabel);
        datePanel.add(monthField);
        datePanel.add(dayLabel);
        datePanel.add(dayField);

        durationPanel0.add(durationLabel);
        durationPanel.add(durationBox);

        submitPanel.add(lineLabel);
        submitPanel.add(submit);
        submitPanel.add(lineLabel);

        quotePanel0.add(quoteLabel);
        quotePanel.add(quote);


        this.setLayout(new FlowLayout());
        this.add(routePanel0);
        this.add(routePanel);
        this.add(datePanel0);
        this.add(datePanel);
        this.add(durationPanel0);
        this.add(durationPanel);
        this.add(submitPanel0);
        this.add(submitPanel);
        this.add(quotePanel0);
        this.add(quotePanel);

        // action listener for routeHP

        routeHP.addActionListener(new ActionListener()
        {

            public void actionPerformed(ActionEvent evt)
            {

                    //rates = new Rates(Rates.HIKE.HELLROARING);
                    hike_id = "1";
                    durationBox.removeAllItems();
                    durationBox.addItem("2");
                    durationBox.addItem("3");
                    durationBox.addItem("4");

            }


        }
    );
        // action listener for routeGL
        routeGL.addActionListener(new ActionListener()
        {

            public void actionPerformed(ActionEvent evt)
            {

                    //rates = new Rates(Rates.HIKE.GARDINER);
                    hike_id = "0";
                    durationBox.removeAllItems();
                    durationBox.addItem("3");
                    durationBox.addItem("5");


            }


        }
    );
        // action listener for routeBP
        routeBP.addActionListener(new ActionListener()
        {

            public void actionPerformed(ActionEvent evt)
            {

                    //rates = new Rates(Rates.HIKE.BEATEN);
                    hike_id = "2";
                    durationBox.removeAllItems();
                    durationBox.addItem("5");
                    durationBox.addItem("7");

            }


        });

        //action listener for get a quote button
        submit.addActionListener(new ActionListener()
        {

            public void actionPerformed(ActionEvent a)
            {
                String m, d, y;
                String durationNum;

                try
                {
                    durationNum =  (String) durationBox.getSelectedItem();
                    try
                    {

                        m = monthField.getText();
                        d = dayField.getText();
                        y = yearField.getText();
                        
                        // adjust month and day text
                        if ("0".equals(m.substring(0,1))) 
                        {
                            m=m.substring(1,m.length());
                        }
                        
                        if ("0".equals(d.substring(0,1))) 
                        {
                            d=d.substring(1,d.length());
                        }
                        
                        // use finalQuote method to obtain quote info from BHC server
                        
                        finalQuote = requestQuote(hike_id+":"+y+":"+m+":"+d+":"+durationNum);

                        quote.setText(finalQuote);
                        quote.setVisible(true);
                        

                    } 
                    catch(Exception e) // invalid date format exception
                    {
                        JDialog dialog = new JOptionPane("Invalid date format",
                                                         JOptionPane.ERROR_MESSAGE,
                                                         JOptionPane.DEFAULT_OPTION).createDialog("Unable to obtain quote"); 
                        dialog.setAlwaysOnTop(true);
                        dialog.setVisible(true); 
                        dialog.dispose();

                    }

                }
                catch(Exception e) // invalid dution exception
                {

                    JDialog dialog = new JOptionPane("Invalid duration",
                                     JOptionPane.ERROR_MESSAGE,
                                     JOptionPane.DEFAULT_OPTION).createDialog("Unable to obtain quote"); 
                    dialog.setAlwaysOnTop(true);
                    dialog.setVisible(true); 
                    dialog.dispose();

                }

            }

        }
    );
        
        


    }
    
    /**
     * This method obtain quote info from BHC server based on intake request text
     * @param requestString string represents the request data in the form of hike_id:begin_year:begin_month:begin_day:duration (e.g: 1:2008:7:1:3)
     * @return quote information from the server 
     */
    public static String requestQuote( String requestString ) throws IOException
    {
    	String result = "";
        Socket quoteSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try 
        {// connect to BHC server
            quoteSocket = new Socket("web6.jhuep.com", 20025);           
            out = new PrintWriter(quoteSocket.getOutputStream(), true);                      
            in = new BufferedReader(new InputStreamReader(quoteSocket.getInputStream()));
        } 
        catch (UnknownHostException e) 
        {
            System.err.println("Don't know about host: web6.jhuep.com");
            System.exit(1);
        } 
        catch (IOException e) 
        {
            System.err.println("Couldn't get I/O for " + "the connection to: web6.jhuep.com.");
            System.exit(1);
        }
        
        // send request text
        out.println(requestString);
        
        // obtain quote request result
        result = in.readLine();
        
	out.close();
	in.close();
	quoteSocket.close();
        
        
        // parse result based on whether it's a quote or error
        if (result.contains("-0.01"))
        {// parse text if it's error
            result = ("Unable to get quote: " + result.substring(6,result.length()));
        }

        else
        {// parse text if it's quote info
            result = result.substring(0,5);
        }

        return result;
    }

}


