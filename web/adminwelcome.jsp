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
        
        <li><a href="admin_history.jsp">View All Medical History</a></li> <!-- done -->
        <li><a href="admin_bookcourt.jsp">View Booked Court</a></li> <!-- done -->
        <li><a href="accmatch.jsp">Accept practice match </a></li><!-- done -->
        <li><a href="addclub.jsp">Add new club </a></li><!-- done -->
        <li><a href="removeclub.jsp">Remove club </a></li><!-- done -->
        <li><a href="viewclub.jsp">View all clubs </a></li><!-- done -->
        <li><a href="admin_viewmatch.jsp">View Upcoming Matches </a></li><!-- done -->
        <li><a href="admin_viewtournaments.jsp">View Upcoming Tournaments </a></li><!-- done -->
        <li><a href="admin_viewregtournaments.jsp">View Tournaments registered for</a></li><!-- done -->
        <li><a href="register_tournament.jsp">Register for tournament</a></li><!-- done -->
        <li><a href="addtournament.jsp">Add new tournament</a></li>
        <li><a href="teams.jsp">View Team Details</a></li><!-- done -->
        
    </ol>
        
    </body>
</html>
