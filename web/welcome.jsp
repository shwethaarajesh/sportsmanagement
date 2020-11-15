<%-- 
    Document   : welcome
    Created on : 12 Nov, 2020, 3:13:43 PM
    Author     : shwet
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
       <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <style>
body {
  background-image: url('bg.jpg');
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-size: cover;
  width: 300px;
    margin: 0 auto;
}
h1 {
    color : #000000;
    text-align : center;
    font-family: "SIMPSON";
}
.center {
  margin-left: auto;
  margin-right: auto;
}
.container {
  max-width: 1000px;
  margin-left: auto;
  margin-right: auto;
  padding-left: 10px;
  padding-right: 10px;
}
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 200%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

form {
    width: 300px;
    margin: 0 auto;
}
.content {
  max-width: 500px;
  margin: auto;
}
input[type=text] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  box-sizing: border-box;
}
input[type=number] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  box-sizing: border-box;
}
input,select,li {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  box-sizing: border-box;
}
</style>
    </head>

    <body>
        <h1>Enter choice</h1>
    <ol>
        <b>
        <li><a href="medical.html">Medical Assistance</a></li>
        <li><a href="history.jsp">Medical History</a></li>
        <li><a href="bookcourt.jsp">Book Court</a></li>
        <li><a href="viewbooked.jsp">View Booked Court</a></li>
        <li><a href="reqmatch.jsp">Request practice match </a></li>
        <li><a href="viewsentreq.jsp">View sent Practice Requests </a></li>
        <li><a href="viewreq.jsp">View Practice Requests </a></li>
        <li><a href="viewmatch.jsp">View Upcoming Matches </a></li>
        <li><a href="viewtournaments.jsp">View Upcoming Tournaments </a></li>
        <li><a href="viewregtournaments.jsp">View Tournaments registered for</a></li>
        <li><a href="teammates.jsp">View Teammates Details</a></li></b>
        <br><br>
        
    </ol>
        <a href="index.html">Logout</a>
        <!-<!-- View booked courts  -->
    </body>
</html>
