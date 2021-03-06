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
        
        String sql = "update kunde set vorname=?, nachname=?, strasse=?, hausnummer=?, plz=?, kontonr=?, email=?, passwort=? where kid =?";

        Kunde kunde=null;
        
        String vorname = request.getParameter("vorname");
        String nachname = request.getParameter("nachname");
        String strasse = request.getParameter("strasse");
        String hausnummer = request.getParameter("hausnummer");
        String plz = request.getParameter("plz");
        String kontonr = request.getParameter("kontonr");
        String email = request.getParameter("email");
        String passwort = request.getParameter("passwort");
        
        
        kunde = new Kunde(kid, vorname, nachname, strasse, hausnummer, plz, kontonr, email, passwort);
        kunde.setSessionid(sessionid);
        
        session.removeAttribute("kunde");
        session.setAttribute("kunde", kunde);


        try {
            PreparedStatement pstm = conn.prepareStatement("update kunde set vorname=?, nachname=?, strasse=?, hausnummer=?, plz=?, kontonr=?, email=?, passwort=? where kid =?");
            pstm.setString(1, kunde.getVorname());
            pstm.setString(2, kunde.getNachname());
            pstm.setString(3, kunde.getStrasse());
            pstm.setString(4, kunde.getHausnummer());
            pstm.setString(5, kunde.getPlz());
            pstm.setString(6, kunde.getKontonr());
            pstm.setString(7, kunde.getEmail());
            pstm.setString(8, kunde.getPasswort());
            pstm.setInt(9, kunde.getKid());

            pstm.executeUpdate();
            conn.commit();
            dbPool.releaseConnection(conn);
        } catch (SQLException e) {
            RequestDispatcher view = request.getRequestDispatcher("index.html");
            view.forward(request, response);
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
