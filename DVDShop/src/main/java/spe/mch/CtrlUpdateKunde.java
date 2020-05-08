/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spe.mch;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Maximilian
 */
@WebServlet(name = "CtrlUpdateKunde", urlPatterns = {"/ctrlupdatekunde"})
public class CtrlUpdateKunde extends HttpServlet {

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
        
        String sql = "update kunde set vorname=?, nachname=?, strasse=?, hausnummer=?, plz=?, kontonr=?, email=?, passwort=? where kid =?";
        
        String vorname=request.getParameter("vorname");
        String nachname=request.getParameter("nachname");
        String strasse=request.getParameter("strasse");
        String hausnummer=request.getParameter("hausnummer");
        String plz=request.getParameter("plz");
        String kontonr=request.getParameter("kontonr");
        String email=request.getParameter("email");
        String passwort=request.getParameter("passwort");
        int kid = Integer.parseInt(request.getParameter("passwort"));
        
        
        ConnectionPool dbPool = (ConnectionPool) getServletContext().getAttribute("dbPool");
        Connection conn = dbPool.getConnection();
        
        try{
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, vorname);
            pstm.setString(2, nachname);
            pstm.setString(3, strasse);
            pstm.setString(4, hausnummer);
            pstm.setString(5, plz);
            pstm.setString(6, kontonr);
            pstm.setString(7, email);
            pstm.setString(8, passwort);
            pstm.setInt(9, kid);
            
            pstm.executeUpdate();
            conn.commit();
            dbPool.releaseConnection(conn);
        }catch(SQLException e){
            response.getWriter().print("SQLFEHLER");
        }
        
        RequestDispatcher view = request.getRequestDispatcher("ctrlselect");
        view.forward(request, response);
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
