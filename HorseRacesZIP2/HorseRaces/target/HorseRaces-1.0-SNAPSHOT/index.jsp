
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Race Assistant</title>
        <style>
            body{
                background-color: gray
            }
            h1 {
                font-size:60px;
                color: red;
                background-color: black;
                text-align: center;
                font-family:papyrus,fantasy;
            }
            table, th, td {
                border: 3px solid black;
                cellpadding:5;
            }
        </style>
    </head>
    <body>
        <h1>Race Assistant</h1>
        <h2>Show Races:</h2>
        
      
        <form  action="show">

            <input type="submit" value =" All Races" />

        </form>
        <br>
        <form action = "get"><input type="text" name="ID" size = "7"/><input type= "submit" value="Find by ID"/></form>
        <h2>Add New Race: </h2>
        <form action = "addrace">
            <table >
                <tr>
                    <th>Race Name</th>
                    <th>Track Name</th>
                    <th>Date</th>
                    <th>Action</th>
                </tr>

                <tr>
                    <td><input type="text" name="raceName" id="raceName" />
                    <td><input type="text" name="trackName" id="trackName" />
                    <td><input type="text" name="date" id="date" />
                    <td>  <input type="submit" value ="Submit New Race" /></td>>
                </tr>
            </table>
        </form>
        <h2>Update Existing Race: </h2>
        <form action= "update" >
            <table  >
                <tr>
                    <th>ID</th>
                    <th>Race Name</th>
                    <th>Track Name</th>
                    <th>Date</th>
                    <th>Action</th>
                </tr>

                <tr>
                    <td><input type="text" name="ID" id="ID" size = "7"/>
                    <td><input type="text" name="raceName" id="raceName" />
                    <td><input type="text" name="trackName" id="trackName" />
                    <td><input type="text" name="date" id="date" />
                    <td><input type="submit" value="Update Race List"/></td>
                </tr>
            </table>

        </form>	
        <h2>Delete Race By ID: </h2>
        <form action ="delete">
            <input type="text" name= "ID" size = "7"/><input type="submit" value="Delete Race">
        </form>
    </body>
</html>