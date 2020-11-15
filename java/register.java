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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author shwet
 */
public class register extends HttpServlet {

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
            String name=request.getParameter("name");
            String pass=request.getParameter("pass");
            String phno=request.getParameter("phno");
            String email=request.getParameter("email");
            String school=request.getParameter("school");
            String sec=request.getParameter("section");
            int age=Integer.parseInt(request.getParameter("age"));
            String club=request.getParameter("club");
            String gender=request.getParameter("gender");
            int yr=Integer.parseInt(request.getParameter("year"));
            out.println(rno+name+pass+phno+email+school+age+yr);
            HttpSession session = request.getSession();
            session.setAttribute("rno", rno);
            TrialDb db=new TrialDb();
            int school_id = 0,club_id = 0;
            Connection con=db.getCon();
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("Select school_id from school where name='"+school+"';");
            while(rs.next())
            {
                school_id=rs.getInt("school_id");
            }
            rs.close();
            rs=stmt.executeQuery("Select id from sports_club where name='"+club+"' and Gender='"+gender+"';");
            while(rs.next())
            {
                club_id=rs.getInt("id");
            }
            rs.close();
            out.println("a");
            stmt.executeUpdate("insert into student values ('"+rno+"','"+name+"','"+pass+"','"+phno+"','"+email+"','"+yr+"','"+sec+"','"+school+"','"+school_id+"','"+club_id+"','"+age+"','"+gender+"');");
            out.println("Inserted");
            session.setAttribute("sid", school_id);
            session.setAttribute("cid", club_id);
            RequestDispatcher dispatcher = request.getRequestDispatcher("welcome.jsp");
            request.setAttribute("schoolid", school_id);
            request.setAttribute("clubid", club_id);// set your String value in the attribute
            request.setAttribute("rno", rno);
            dispatcher.forward( request, response );
            
        } catch (Exception ex) {
            Logger.getLogger(register.class.getName()).log(Level.SEVERE, null, ex);
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
