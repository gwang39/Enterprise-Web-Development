/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codes;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * This program gives quote result based on form input
 * @author Guan Yue Wang
 */
@WebServlet(name = "Controller", urlPatterns = {"/Controller"})
public class Controller extends HttpServlet {
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public Rates rates;
    public String quoteResult = null;
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String tour = null;
        String year = null;
        String month = null;
        String day = null;
        String duration = null;

        int m, d, y;
        int durationNum;
        String quoteResult = null;
        
        
        try { // get form parameters
            tour = request.getParameter("tour");
            if (tour == null) 
            {
                tour = "<none entered>";
            }
            year = request.getParameter("year");
            if (year == null) 
            {
                year = "<none entered>";
            }
            
            month = request.getParameter("month");
            if (month == null) 
            {
                month = "<none entered>";
            }
            
            day = request.getParameter("day");
            if (day == null) 
            {
                day = "<none entered>";
            }
            
            duration = request.getParameter("duration");
            if ( duration == null) 
            {
                 duration = "<none entered>";
            }
            
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

            
        
            out.println("<html>");
            out.println("<head>");
            out.println("<title>BHC Tour Quote</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>BHC Tour Quote Result </h1>");
            out.println("</br>");
            out.println("Tour: " + tour);
            out.println("</br>");
            out.println("Start date: " + year+month+day);
            out.println("</br>");
            out.println("Duration: " + duration);
            out.println("</br>");
            out.println("Quote Result: " + quoteResult);
            out.println("</br>");
            out.println("</body>");
            out.println("</html>");
            

        } 
        finally 
        { 
            out.close();
        }
   }



    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}