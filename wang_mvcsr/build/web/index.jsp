<%-- 
    Document   : index
    Created on : Jul 26, 2018, 11:43:10 PM
    Author     : Guan Yue Wang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">


<html  lang="en">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Beartooth Hiking Company (BHC)</title>
    <link href="css/hwformat.css" rel="stylesheet" type="text/css">

  </head>
           <h1>Beartooth Hiking Company (BHC)</h1>
    <h1><img src="http://www.jhuep.com/~spiegel/en605681/Images/Beartooth002-01.jpg" alt="TopPic"></h1>  

    
    <table>
      <caption>Route Details</caption>
      <tr>
        <th>Tour</th>
        <th>Length</th>
        <th>Cost</th>
        <th>Difficulty</th>
        <th>Photo</th>
      </tr>
      <tr>
        <td>Gardiner Lake</td>
        <td>3 or 5 days</td>
        <td>$40/day</td>
        <td>Intermediate</td>
        <td><img src="http://www.jhuep.com/~spiegel/en605681/Images/BeartoothIslandLakeTrail_0326_800x600.jpg" width="100" height="80" alt="Route1">
</td>
      </tr>
      <tr>
        <td>The Hellroaring Plateau</td>
        <td>2,3, or 4 days</td>
        <td>$35/day</td>
        <td>Easy</td>
        <td><img src="http://www.jhuep.com/~spiegel/en605681/Images/TetonTrail-2_800x600.jpg" width="100" height="80" alt="Route2">
      </tr>
      <tr>
        <td>The Beaten Path </td>
        <td>5 or 7 days</td>
        <td>$45/day</td>
        <td>Difficult</td>
        <td><img src="http://www.jhuep.com/~spiegel/en605681/Images/BeartoothView_800x600.jpg" width="100" height="80" alt="Route3">
      </tr>
      <tr>
        <td colspan="5">Note: all hikes have a 50% surcharge for Sat/Sun hikes.</td>
      </tr>
    </table>
    
        
        
     <hr>  
    <h2>Get A Quote:</h2>
        
    <form action="Controller" method=GET>
        
    Choose a tour
    <select name="tour">
        <option value="Gardiner Lake">Gardiner Lake</option>
        <option value="Hellroaring Plateau">Hellroaring Plateau</option>
        <option value="Beaten Path">Beaten Path</option>
    </select>
    <br>
    <br>       
     <label>Start date: </label>
       Year
       <input type="TEXT" name="year" value="YYYY">
       Month
       <input type="TEXT" name="month" value="MM">
       Day
       <input type="TEXT" name="day" value="DD">
    <br>
    <br>
       Duration(see chart above for valid durations):
       <input type="TEXT" name="duration" value="X">
       Days
    <br>
    <br>
    <input type="SUBMIT" value="Quote">
    </form>
            <hr>
    
    <p>Why hiking? Check out the video below </p>

  <iframe width="560" height="315" src="https://www.youtube.com/embed/PdCylcA_c40">
  </iframe>

  </body>
</html>
