<%-- 
    Document   : addclub
    Created on : 14 Nov, 2020, 11:28:38 AM
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
         <h1>New club</h1>
        <h3>Enter details</h3>
        <form action="addclub" method="post">
            <div>Club name</div>
            <input type="text" name="cname" placeholder="Club name">
            <div>Student name</div>
            <select name="gender">
                <option>Male</option>
                <option>Female</option>
                <option>Other</option>
            </select>
            <input type="submit" value="Add club">
        </form>
    </body>
</html>