<%-- 
    Document   : clientdata
    Created on : Aug 3, 2018, 2:13:52 PM
    Author     : Guan Yue Wang
--%>

<%@ page import="java.sql.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html  lang="en">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Beartooth Hiking Company (BHC)</title>
    <link href="css/hwformat.css" rel="stylesheet" type="text/css">

  </head>
    <body>
    <h1>Beartooth Hiking Company (BHC)</h1>
    <h1><img src="http://www.jhuep.com/~spiegel/en605681/Images/Beartooth002-01.jpg" alt="TopPic"></h1>  
    <h2>Query Result</H2>
    <table>
        <caption>Tour Start Date >= <%=request.getParameter("year")%>-<%=request.getParameter("month")%>-<%=request.getParameter("day")%></caption>
    <tr>
        <th>Start Date</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Hiking Location</th>
        <th>Guides Name</th>
    </tr>
        <% 
        try{
           Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://web6.jhuep.com:3306/class", "johncolter", "LetMeIn");
            Statement statement = connection.createStatement();
            
            String year = request.getParameter("year"); 
            String month = request.getParameter("month"); 
            String day = request.getParameter("day"); 
            
            String startDate = year+"-"+month+"-"+day;
            
            ResultSet rs = statement.executeQuery("select reservation.StartDay, reservation.First, reservation.Last, locations.location, guides.First"
                    + " from reservation, guides, locations where reservation.guide = guides.idguides and reservation.location = locations.idlocations"
                    + " and reservation.StartDay >= '"+startDate+"' order by reservation.StartDay") ; 
                
            while(rs.next())
            {
                %>
                <tr>
                   <td><%=rs.getString(1)%></td>    
                   <td><%=rs.getString(2)%></td>    
                   <td><%=rs.getString(3)%></td>     
                   <td><%=rs.getString(4)%></td>      
                   <td><%=rs.getString(5)%></td>     
                </tr>
                <%
            }
        }
        catch(Exception ex){}

        %>
        
        </table>
    </body>
</html>
