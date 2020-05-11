/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spe.mch;

import java.io.IOException;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
@WebServlet(name = "CtrlLogIn", urlPatterns = {"/ctrllogin"})
public class CtrlLogIn extends HttpServlet {

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
        String mUsername = request.getParameter("username");
        mUsername = mUsername.replaceFirst("%40", "@");
        String mPasswort = request.getParameter("passwort");

        ConnectionPool dbPool = (ConnectionPool) getServletContext().getAttribute("dbPool");
        Connection conn = dbPool.getConnection();

        String sql = "select * from kunde where email=?";

        RequestDispatcher view = null;

        HttpSession session = request.getSession();

        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, mUsername);
            ResultSet rs = pstm.executeQuery();
            rs.next();

            int kid = rs.getInt("kid");
            String vorname = rs.getString("vorname");
            String nachname = rs.getString("nachname");
            String strasse = rs.getString("strasse");
            String hausnummer = rs.getString("hausnummer");
            String plz = rs.getString("plz");
            String kontonr = rs.getString("kontonr");
            String email = rs.getString("email");
            String passwort = rs.getString("passwort");

            if (rs.getString("passwort").equals(mPasswort)) {

                Kunde kunde = new Kunde(kid, vorname, nachname, strasse, hausnummer, plz, kontonr, email, passwort);
                session.setAttribute("kunde", kunde);
                view = request.getRequestDispatcher("ctrlselect");
            } else {
                view = request.getRequestDispatcher("loginPage.html");// hier muss der Link zur LogIn Seite hin
            }
            dbPool.releaseConnection(conn);
        } catch (SQLException ex) {
            view = request.getRequestDispatcher("loginPage.html");//hier muss der Link zur LogIn Seite hin
        }
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
