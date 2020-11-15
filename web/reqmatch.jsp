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
<h1>Request practice match</h1>
<h3>Enter details</h3>
        <form action="reqmatch" method="post">
            <div>Request practice Match against </div>
    <%
try{
connection = DriverManager.getConnection(connectionUrl, userid, password);
statement=connection.createStatement();
String sql ="select name from school ;";
resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>

            <select name="a_school">
        <%  while(resultSet.next()){ %>
            <option><%= resultSet.getString("name")%></option>
        <% } %>
        </select>
 <%
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
<div>Date of match</div>
            <input type="date" name="date" placeholder="Date">
            <div>Time</div>
            <input type="text" name="time" placeholder="Time">
            <%
try{
connection = DriverManager.getConnection(connectionUrl, userid, password);
statement=connection.createStatement();
String sql ="select court_id from courts where sports_id='"+cid+"' and school_id='"+sid+"';";
resultSet = statement.executeQuery(sql);

%>
            <div>Court number</div>
            <select name="cno">
        <%  while(resultSet.next()){ %>
            <option><%= resultSet.getString("court_id")%></option>
        <% } %>
        </select>
        <input type="submit" value="Request">
        </form>

<%

connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>

</body>
</html>