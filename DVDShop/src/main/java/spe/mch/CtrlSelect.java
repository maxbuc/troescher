/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spe.mch;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
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
@WebServlet(name = "CtrlSelect", urlPatterns = {"/ctrlselect"})
public class CtrlSelect extends HttpServlet {

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
        
        ArrayList<DVD> dvdList = new ArrayList<>();
       
        String sql = "select dvd.did, titel, laenge, erscheinungsjahr, sprache.name, genre.name, fsk, kunde.kid, vorname, nachname, strasse, hausnummer, "
                + "plz, kontonr, email from dvd, kunde, genre, sprache, dvd_sprache"
                + "where dvd.gid=genre.gid"
                + "and kunde.kid=dvd.kid"
                + "and dvd.did=dvd_sprache.did and dvd_sprache.sid=sprache.sid"
                + "order by dvd.did";

        ConnectionPool dbPool = (ConnectionPool) getServletContext().getAttribute("dbPool");
        Connection conn = dbPool.getConnection();

        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            
            int did=0;
            String titel=null;
            int laenge=0;
            int erscheinungsjahr=0;
            ArrayList<String> sprache = null;
            String genre=null;
            int fsk=0;
            Kunde kunde = null;
            

            while (rs.next()) {
                
            }
            dbPool.releaseConnection(conn);
        } catch (SQLException e) {
        }
        
        request.setAttribute("dvdList", dvdList);
        RequestDispatcher view = request.getRequestDispatcher("gbausgeben.jsp");
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
