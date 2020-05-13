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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "CtrlRegister", urlPatterns = {"/ctrlregister"})
public class CtrlRegister extends HttpServlet {

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
        ConnectionPool dbPool = (ConnectionPool) getServletContext().getAttribute("dbPool");
        Connection conn = dbPool.getConnection();
        String sql1 = "select email from kunde";
        String sql = "insert into kunde(vorname, nachname, strasse, hausnummer, plz, kontonr, email, passwort) "
                + "values (?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement check = conn.prepareStatement(sql1);
            ResultSet rs = check.executeQuery();
            

            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, request.getParameter("vorname"));
            pstm.setString(2, request.getParameter("nachname"));
            pstm.setString(3, request.getParameter("strasse"));
            pstm.setString(4, request.getParameter("hausnummer"));
            pstm.setString(5, request.getParameter("plz"));
            pstm.setString(6, request.getParameter("kontonr"));
            pstm.setString(7, request.getParameter("email"));
            pstm.setString(8, request.getParameter("passwort"));
            boolean insert= true;
            while (rs.next()) {
                if (rs.getString("email").equals(request.getParameter("email"))) {
                    insert=false;
                }
            }
            RequestDispatcher view;
            if(insert){
                pstm.executeUpdate();
                view = request.getRequestDispatcher("loginPage.html");
            }else{
                view = request.getRequestDispatcher("register.html");
            }

            dbPool.releaseConnection(conn);

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
