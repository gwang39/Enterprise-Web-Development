/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.quote;


import java.io.PrintWriter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 * This web service calculates the quote based on tour information
 * @author Guan Yue Wang
 */
@Path("quote")
public class QuoteCalculator {
    public Rates rates;
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of QuoteCalculator
     */
    public QuoteCalculator() {
    }

    /**
     * Retrieves representation of an instance of edu.rfs.quote.QuoteCalculator
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getText() 
    {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }
    
    
    @POST
    @Produces(MediaType.TEXT_HTML)
    public String getParamText(@FormParam("tour") String tour, @FormParam("size") String p_size, 
            @FormParam("year") String year,@FormParam("month") String month,
            @FormParam("day") String day, @FormParam("duration") String duration) 
    {
        
        int size = 1;
        int m, d, y;
        int durationNum;
        String quoteResult = null;


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

                    size = Integer.parseInt(p_size);

                    BookingDay booking = new BookingDay(y,m,d);


                    // calculate quotes

                    if(booking.isValidDate())
                    {

                        rates.setBeginDate(booking);

                        if(rates.setDuration(durationNum))
                        {
                            if(rates.isValidDates())
                            {

                                quoteResult = "Total Cost: " + String.format("$%.2f", rates.getCost()*size)
                                        +" (" +String.format("$%.2f", rates.getCost()) + " Per Person)";

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
        
        quoteResult = 
"<html  lang=\"en\">\n" +
"  <head>\n" +
"    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
"    <title>Beartooth Hiking Company (BHC)</title>\n" +
"  </head>\n" +
"\n" +
"\n" +
"  <body>" +
"    <h1>Beartooth Hiking Company (BHC)</h1> \n" +
"    <h1><img src=\"http://www.jhuep.com/~spiegel/en605681/Images/Beartooth002-01.jpg\" alt=\"TopPic\"></h1>  \n" +
"        \n" +
"     <hr>  \n" +
"    <h2>Get A Quote:</h2>\n" +
"    \n" +
"    <form action=\"/wang_hw12/webresources/quote/\" method=POST>\n" +
"        \n" +
"    Choose a tour\n" +
"    <select name=\"tour\">\n" +
"        <option value=\"Gardiner Lake\">Gardiner Lake</option>\n" +
"        <option value=\"Hellroaring Plateau\">Hellroaring Plateau</option>\n" +
"        <option value=\"Beaten Path\">Beaten Path</option>\n" +
"    </select>\n" +
"    <br>\n" +
"    <br>\n" +
"       Party Size(1-10)\n" +
"       <input type=\"TEXT\" name=\"size\" value=\"\">\n" +
"    <br>\n" +
"    <br>       \n" +
"     <label>Start date: </label>\n" +
"       Year\n" +
"       <input type=\"TEXT\" name=\"year\" value=\"YYYY\">\n" +
"       Month\n" +
"       <input type=\"TEXT\" name=\"month\" value=\"MM\">\n" +
"       Day\n" +
"       <input type=\"TEXT\" name=\"day\" value=\"DD\">\n" +
"    <br>\n" +
"    <br>\n" +
"       Duration(see chart above for valid durations):\n" +
"       <input type=\"TEXT\" name=\"duration\" value=\"X\">\n" +
"       Days\n" +
"    <br>\n" +
"    <br>\n" +
"    <input type=\"SUBMIT\" value=\"Get A Quote\">\n" +
"    </form>\n" +
"    \n" +
"    <hr>\n" +
"    \nQuote Result - " + quoteResult +
"  </body>\n" +
"</html>";
        
        
        return quoteResult;
    }

    /**
     * PUT method for updating or creating an instance of QuoteCalculator
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.TEXT_PLAIN)
    public void putText(String content) {
    }
}
