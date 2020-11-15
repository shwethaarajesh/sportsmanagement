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
public class superadmin extends HttpServlet {

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
             int aid=Integer.parseInt(request.getParameter("admin_id"));
            String pass=request.getParameter("pass");
            
            TrialDb db=new TrialDb();
            int r=-1;
            Connection con=db.getCon();
            Statement stmt=con.createStatement();
            out.println("Before query");
            int school_id=0,club_id=0;
            ResultSet rs=stmt.executeQuery("Select * from super_admin where id='"+aid+"' and password='"+pass+"';");
            while(rs.next())
            {
                r=rs.getInt("id");
            }
            rs.close();
            
            if(r==-1)
            {
                out.println("Incorrect");
                RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
            
            dispatcher.forward( request, response );
            }
            out.println("Inserted");
            HttpSession session = request.getSession();
            session.setAttribute("aid", aid);
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("superadminwelcome.jsp");
            request.setAttribute("aid", aid);
            dispatcher.forward( request, response );
        } catch (SQLException ex) {
            Logger.getLogger(superadmin.class.getName()).log(Level.SEVERE, null, ex);
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
