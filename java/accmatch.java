/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author shwet
 */
public class accmatch extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           HttpSession session = request.getSession();
            int sid=Integer.parseInt(session.getAttribute("sid").toString());
            int mid=Integer.parseInt(request.getParameter("mid"));
            
            TrialDb db=new TrialDb();
            int cid = 0;
            int court_id=0;
            String date = null,time = null;
            int school1_id=0,school2_id=0;
            Connection con=db.getCon();
            out.println("Before query"+mid);
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("Select * from practice_request where practice_id='"+mid+"';");
            while(rs.next())
            {
                court_id=rs.getInt("court_id");
                date=rs.getString("date");
                time=rs.getString("time");
                school1_id=rs.getInt("requestingschool_id");
                school2_id=rs.getInt("acceptingschool_id");
            }
            rs.close();
            
            rs=stmt.executeQuery("Select sports_id from courts where court_id='"+court_id+"';");
            while(rs.next())
            {
                cid=rs.getInt("sports_id");
            }
            rs.close();
            String str_id=null;
            int id=0;
            out.println("Before max");
            rs=stmt.executeQuery("Select MAX(match_id) as match_id from practice_match;");
            while(rs.next())
            {
                out.println("Inside max");
                id=rs.getInt("match_id")+1;
                out.println("afte max");
            }
            rs.close();
            out.println("Before insert");
            out.println(id+" "+cid+" "+court_id+" "+date+" "+time+" "+school1_id+" "+school2_id);
            stmt.executeUpdate("insert into practice_match values ('"+cid+"','"+court_id+"','"+date+"','"+time+"','"+school1_id+"','"+school2_id+"','"+id+"');");
            out.println("Inserted");
            stmt.executeUpdate("delete from practice_request where practice_id='"+mid+"';");
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("adminwelcome.jsp");
            request.setAttribute("sid", Integer.parseInt(session.getAttribute("sid").toString()));
            dispatcher.forward( request, response );
        } catch (SQLException ex) {
            Logger.getLogger(accmatch.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
