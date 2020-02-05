/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw5gw;

/**
 * This program creates the GUI frame for BHC quote checker
 * @author Guan Yue Wang
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Hw5Frame extends JFrame
{
    
    // creates buttons, combobox, labels, text fields
    private JLabel routeLabel = new JLabel("Please select a route: ");
    private JLabel startDateLabel = new JLabel("Please input your start date: ");;
    private JLabel quoteLabel = new JLabel("                                     Total Cost:    ");
    private JLabel durationLabel = new JLabel("Please select tour duration: ");;
    private JLabel quote = new JLabel("  ");
    private JLabel lineLabel = new JLabel("      ");
    private JTextField yearField;
    private JTextField monthField;
    private JTextField dayField;

    private JComboBox <Integer> durationBox = new JComboBox();

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

    private Rates rates;

    public Hw5Frame()
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


        monthField = new JTextField("MM", 5);
        dayField = new JTextField("DD", 5);
        yearField = new JTextField("YYYY", 5);

        routePanel0.add(routeLabel);
        routePanel.add(routeHP);
        routePanel.add(routeGL);
        routePanel.add(routeBP);

        datePanel0.add(startDateLabel);
        datePanel.add(yearField);
        datePanel.add(monthField);
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

                    rates = new Rates(Rates.HIKE.HELLROARING);

                    durationBox.removeAllItems();
                    durationBox.addItem(2);
                    durationBox.addItem(3);
                    durationBox.addItem(4);

            }


        }
    );
        // action listener for routeGL
        routeGL.addActionListener(new ActionListener()
        {

            public void actionPerformed(ActionEvent evt)
            {

                    rates = new Rates(Rates.HIKE.GARDINER);
                    durationBox.removeAllItems();
                    durationBox.addItem(3);
                    durationBox.addItem(5);


            }


        }
    );
        // action listener for routeBP
        routeBP.addActionListener(new ActionListener()
        {

            public void actionPerformed(ActionEvent evt)
            {

                    rates = new Rates(Rates.HIKE.BEATEN);
                    durationBox.removeAllItems();
                    durationBox.addItem(5);
                    durationBox.addItem(7);

            }


        });

        //action listener for get a quote button
        submit.addActionListener(new ActionListener()
        {

            public void actionPerformed(ActionEvent a)
            {

                int m, d, y;
                 int durationNum;

                try
                {

                    durationNum = (int) durationBox.getSelectedItem();

                    try
                    {

                        m = Integer.parseInt(monthField.getText());
                        d = Integer.parseInt(dayField.getText());
                        y = Integer.parseInt(yearField.getText());

                        BookingDay booking = new BookingDay(y,m,d);

                        if(booking.isValidDate())
                        {

                            rates.setBeginDate(booking);

                            if(rates.setDuration(durationNum))
                            {

                                if(rates.isValidDates())
                                {

                                    quote.setText(String.format("$%.2f", rates.getCost()));
                                    quote.setVisible(true);

                                }
                                else
                                {
                                    JDialog dialog = new JOptionPane("Dates are not within season",
                                            JOptionPane.ERROR_MESSAGE,
                                            JOptionPane.DEFAULT_OPTION).createDialog("Unable to obtain quote"); 
                                    dialog.setAlwaysOnTop(true);
                                    dialog.setVisible(true); 
                                    dialog.dispose();

                                }

                            }
                            else
                        {

                            JDialog dialog = new JOptionPane("Incorrect duration",
                                             JOptionPane.ERROR_MESSAGE,
                                             JOptionPane.DEFAULT_OPTION).createDialog("Unable to obtain quote"); 
                            dialog.setAlwaysOnTop(true);
                            dialog.setVisible(true); 
                            dialog.dispose();

                        }

                        }
                        else
                        {

                            JDialog dialog = new JOptionPane("Invalid start date",
                                                     JOptionPane.ERROR_MESSAGE,
                                                     JOptionPane.DEFAULT_OPTION).createDialog("Unable to obtain quote"); 
                            dialog.setAlwaysOnTop(true);
                            dialog.setVisible(true); 
                            dialog.dispose();


                        }

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


}


