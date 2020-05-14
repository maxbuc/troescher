/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spe.mch;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Maximilian
 */
@WebServlet(name = "CtrlReserve", urlPatterns = {"/ctrlreserve"})
public class CtrlReserve extends HttpServlet {

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
        //Abfrage, ob User eingeloggt ist!
        HttpSession session = request.getSession();
        String sessionid = session.getId();
        ConnectionPool dbPool = (ConnectionPool) getServletContext().getAttribute("dbPool");
        Connection conn = dbPool.getConnection();
        String check = "select kid from kunde where sessionId=?";
        int kid=0;
        try {
            PreparedStatement pstm = conn.prepareStatement(check);

            pstm.setString(1, sessionid);
            ResultSet rs = pstm.executeQuery();
            kid = 0;
            if (rs.next()) {
                kid = rs.getInt(1);
            }
            if (kid <= 1) {
                RequestDispatcher logInView = request.getRequestDispatcher("loginPage.html");
                logInView.forward(request, response);
            }
        } catch (SQLException ex) {
            response.getWriter().print(ex.getMessage());
        }

        String sql = "insert into dvd_kunde (did, kid, ausgeliehen) values (?,?, current_date)";
        

        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, Integer.parseInt(request.getParameter("did")));
            pstm.setInt(2, kid);
            pstm.executeUpdate();

            RequestDispatcher view = request.getRequestDispatcher("ctrlselectausgeliehen");
            view.forward(request, response);
        } catch (SQLException ex) {
            response.getWriter().print(ex.getMessage());
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
