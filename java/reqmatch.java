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
public class reqmatch extends HttpServlet {

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
            
            HttpSession session = request.getSession();
            int sid_req=Integer.parseInt(session.getAttribute("sid").toString());
            int sid_acc=0;
            String against=request.getParameter("a_school");
            String date=request.getParameter("date");
            String time=request.getParameter("time");
            int cid=Integer.parseInt(request.getParameter("cno"));
            
            TrialDb db=new TrialDb();
            int school_id = 0;
            Connection con=db.getCon();
            out.println("Before query");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("Select school_id from school where name='"+against+"';");
            while(rs.next())
            {
                sid_acc=rs.getInt("school_id");
            }
            rs.close();
            int id=0;
            out.println("Before max");
            rs=stmt.executeQuery("Select MAX(practice_id) as practice_id from practice_request;");
            while(rs.next())
            {
                out.println("Inside max");
                id=rs.getInt("practice_id")+1;
            }
            rs.close();
            out.println("Before insert");
            stmt.executeUpdate("insert into practice_request values ('"+id+"','"+cid+"','"+date+"','"+time+"','"+sid_req+"','"+sid_acc+"');");
            out.println("Inserted");
            RequestDispatcher dispatcher = request.getRequestDispatcher("welcome.jsp");
            request.setAttribute("schoolid", Integer.parseInt(session.getAttribute("sid").toString()));
            request.setAttribute("clubid", Integer.parseInt(session.getAttribute("cid").toString()));// set your String value in the attribute
            request.setAttribute("rno", Integer.parseInt(session.getAttribute("rno").toString()));
            dispatcher.forward( request, response );
        } catch (SQLException ex) {
            Logger.getLogger(reqmatch.class.getName()).log(Level.SEVERE, null, ex);
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
