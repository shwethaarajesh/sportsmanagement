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
public class addtournament extends HttpServlet {

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
            int cid=Integer.parseInt(request.getParameter("cid"));
            String loc=request.getParameter("loc");
            String from_d=request.getParameter("from");
            String to_d=request.getParameter("to");
            int sid=Integer.parseInt(session.getAttribute("sid").toString());
            TrialDb db=new TrialDb();
            int tid=0;
            Connection con=db.getCon();
            Statement stmt=con.createStatement();
            out.println("before max");
            ResultSet rs=stmt.executeQuery("Select MAX(tournament_id) as tournament_id from tournament;");
            while(rs.next())
            {
                tid=rs.getInt("tournament_id")+1;
            }
            rs.close();
            stmt.executeUpdate("insert into tournament values ('"+tid+"','"+cid+"','"+loc+"','"+from_d+"','"+to_d+"');");
            out.println("Inserted");
            RequestDispatcher dispatcher = request.getRequestDispatcher("adminwelcome.jsp");
            request.setAttribute("sid", Integer.parseInt(session.getAttribute("sid").toString()));
            dispatcher.forward( request, response );
        } catch (SQLException ex) {
            Logger.getLogger(addtournament.class.getName()).log(Level.SEVERE, null, ex);
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
