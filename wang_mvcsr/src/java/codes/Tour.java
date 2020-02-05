/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codes;

/**
 * This class captures tour info
 * @author Guan Yue Wang
 */
public class Tour 
{
   private String tour = null;
   private  String year = null;
   private  String month = null;
   private  String day = null;
   private  boolean valid = false;
   private  Rates rates;
    

   private String duration = null;
   private String sizeString = null;
   private int size = 1;
    
   private int m, d, y;
   private int durationNum;
   public String quoteResult = null;
    
   public String result = null;
    
   public void setTour(String tour) 
    {
        this.tour = tour;
    }
    
    public void setYear(String year) 
    {
        this.year = year;
    }
        
    public void setMonth(String month) 
    {
        this.month = month;
    }
    
    public void setDay(String day) 
    {
        this.day=day;
    }
    
    public void setSize(String size) 
    {
        this.sizeString = size;
    }
    
    public void setDuration(String duration) 
    {
        this.duration=duration;
    }
    
    public String getDuration() 
    {
        return duration;
    }
    
    public String getTour() 
    {
        return tour;
    }
    
    public boolean isValid()
    {
        return valid;
    }
       
    
    public String getResult()
    {
            // get corresponding Rates object

            if ("Hellroaring Plateau".equals(tour))
            {
                rates = new Rates(Rates.HIKE.HELLROARING);
            }
            else if ("Beaten Path".equals(tour))
            {
                rates = new Rates(Rates.HIKE.BEATEN);
            }
            else if ("Gardiner Lake".equals(tour))
            {
                rates = new Rates(Rates.HIKE.GARDINER);
            }
            
            else 
            {
                rates = new Rates(Rates.HIKE.GARDINER);
            }
            
            try
                {
                    durationNum = Integer.parseInt(duration);
                    try
                    {
                        m = Integer.parseInt(month);
                        d = Integer.parseInt(day);
                        y = Integer.parseInt(year);

                        
                        BookingDay booking = new BookingDay(y,m,d);
                        
                        // calculate quotes
                        
                        if(booking.isValidDate())
                        {
                            rates.setBeginDate(booking);

                            if(rates.setDuration(durationNum))
                            {
                                if(rates.isValidDates())
                                {

                                    quoteResult = "Total Cost: " + String.format("$%.2f", rates.getCost());

                                }
                                else
                                {
                                    quoteResult = "Unable to obtain quote: dates are not within season";

                                }

                            }
                            else
                        {
                            quoteResult = "Unable to obtain quote: incorrect duration";

                        }

                        }
                        else
                        {

                            quoteResult = "Unable to obtain quote: invalid start date";

                        }

                    } 
                    catch(Exception e) // invalid date format exception
                    {
                        quoteResult = "Unable to obtain quote: invalid date format";

                    }

                }
                catch(Exception e) // invalid dution exception
                {
                    quoteResult = "Unable to obtain quote: invalid duration";
                }



        return tour;
    }
    

}
