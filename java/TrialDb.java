
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletResponse;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author shwet
 */
public class TrialDb {
    Connection con;
    public Connection getCon() throws IOException
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sports_management?useTimeZone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false","root","mysoul2000");
       
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(TrialDb.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        return con;
    }
}
