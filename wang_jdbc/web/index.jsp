<%-- 
    Document   : index
    Created on : Aug 3, 2018, 1:19:03 PM
    Author     : Guan Yue Wang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html  lang="en">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Beartooth Hiking Company (BHC)</title>
    <link href="css/hwformat.css" rel="stylesheet" type="text/css">
    <script src="js/validation.js"></script>

  </head>

    <body>
        <h1>Beartooth Hiking Company (BHC)</h1>
        <h1><img src="http://www.jhuep.com/~spiegel/en605681/Images/Beartooth002-01.jpg" alt="TopPic"></h1>  
        <h2>Client Data Lookup</h2>

        <form name = "queryForm" onsubmit = "return validation()" action ="clientdata.jsp" METHOD="POST">      
             <label>Please Enter Tour Start Date To Retrieve Client Information: </label>
             <br>
             <br>
               Year
               <input type="TEXT" name="year" value="YYYY">
               Month
               <input type="TEXT" name="month" value="MM">
               Day
               <input type="TEXT" name="day" value="DD">
            <br>
            <br>
                <input type="SUBMIT" value="QUERY">
        </FORM>
    </body>
</html>
