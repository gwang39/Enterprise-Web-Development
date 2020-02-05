<%-- 
    Document   : q
    Created on : Jul 26, 2018, 10:14:56 PM
    Author     : guany
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Succesful login!</title>
        <jsp:useBean id="tour" class="MVC.Tour" scope="session" />        
    </head>
    <body>
        <h2>You are logged in as user <jsp:getProperty name="tour" property="name" /></h2>
    </body>
</html>
