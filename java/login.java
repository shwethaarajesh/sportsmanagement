/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
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
public class login extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            

            int rno=Integer.parseInt(request.getParameter("rno"));
            String pass=request.getParameter("pass");
            
            TrialDb db=new TrialDb();
            int r=-1;
            Connection con=db.getCon();
            Statement stmt=con.createStatement();
            out.println("Before query");
            int school_id=0,club_id=0;
            ResultSet rs=stmt.executeQuery("Select * from student where rollno='"+rno+"' and password='"+pass+"';");
            while(rs.next())
            {
                r=rs.getInt("rollno");
                school_id=rs.getInt("school_id");
                club_id=rs.getInt("club_id");
            }
            rs.close();
            
            if(r==-1)
            {
                out.println("Incorrect");
                response.sendRedirect("index.html");
            }
            out.println("Inserted");
            HttpSession session = request.getSession();
            session.setAttribute("rno", rno);
            session.setAttribute("sid", school_id);
            session.setAttribute("cid", club_id);
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("welcome.jsp");
            request.setAttribute("schoolid", school_id);
            request.setAttribute("clubid", club_id);// set your String value in the attribute
            request.setAttribute("rno", r);
            dispatcher.forward( request, response );

          //  response.sendRedirect("welcome.html");
        } catch (Exception ex) {
            PrintWriter out = response.getWriter();
            out.println("error"+ex);
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
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
