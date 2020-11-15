<%-- 
    Document   : history
    Created on : 12 Nov, 2020, 2:53:39 PM
    Author     : shwet
--%>

<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="javax.servlet.http.*"%>
<%
int rno=Integer.parseInt(session.getAttribute("rno").toString());
int sid=Integer.parseInt(session.getAttribute("sid").toString());
int cid=Integer.parseInt(session.getAttribute("cid").toString());
String driver = "com.mysql.cj.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/sports_management?useTimeZone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false";
String database = "sports_management";
String userid = "root";
String password = "mysoul2000";
try {
Class.forName(driver);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
ResultSet rs=null;
%>
<!DOCTYPE html>
<html>   <head>
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

<h1>Booked Courts</h1>

<%
try{
connection = DriverManager.getConnection(connectionUrl, userid, password);
statement=connection.createStatement();
//String sql ="select court_id,date,time,requestingschool_id,acceptingschool_id,sport_name from practice_request join courts where courts.court_id=practice_request.court_id and sports_id='"+cid+"' and acceptingschool_id='"+sid+"';";
String sql ="select booking_id,sports_id,courts.court_id,date,time_from,time_to,sport_name from courts,court_booking where courts.court_id=court_booking.court_id  and sports_id='"+cid+"' and court_booking.school_id='"+sid+"';";

resultSet = statement.executeQuery(sql);
if(!resultSet.isBeforeFirst())
{
    %>
    <div>No courts booked</div> 
    <%
}
else{
%>
<table border="1">
<tr>
<td>Booking id</td>
<td>Club id</td>
<td>Court id</td>
<td>Date</td>
<td>Time from</td>
<td>Time to</td>
<td>Sport name</td>
</tr>
<%
while(resultSet.next()){
   
    
%>

<tr>
<td><%=resultSet.getString("booking_id") %></td>
<td><%=resultSet.getInt("sports_id") %></td>
<td><%=resultSet.getInt("court_id") %></td>
<td><%=resultSet.getString("date") %></td>
<td><%=resultSet.getString("time_from") %></td>
<td><%=resultSet.getString("time_to") %></td>
<td><%=resultSet.getString("sport_name") %></td>

</tr>
<%
}
}
connection.close();
} catch (Exception e) {

e.printStackTrace();
}
%>
</table>
</body>
</html>
