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
public class addadmin extends HttpServlet {

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
            int sid=Integer.parseInt(request.getParameter("sid"));
            String name=request.getParameter("name");
            String pass=request.getParameter("pass");
            String email=request.getParameter("email");
            String phno=request.getParameter("ph");
            TrialDb db=new TrialDb();
            int id=0;
            Connection con=db.getCon();
            Statement stmt=con.createStatement();
            out.println("before max");
            ResultSet rs=stmt.executeQuery("Select MAX(id)as id from admin;");
            while(rs.next())
            {
                id=rs.getInt("id")+1;
            }
            rs.close();
            //out.println("after max"+id+" "+cname+" "+gender);
            stmt.executeUpdate("insert into admin values ('"+id+"','"+pass+"','"+name+"','"+phno+"','"+email+"','"+sid+"');");
            out.println("Inserted");
            HttpSession session = request.getSession();
            RequestDispatcher dispatcher = request.getRequestDispatcher("superadminwelcome.jsp");
            request.setAttribute("aid", Integer.parseInt(session.getAttribute("aid").toString()));
            dispatcher.forward( request, response );
        } catch (SQLException ex) {
            Logger.getLogger(addadmin.class.getName()).log(Level.SEVERE, null, ex);
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
