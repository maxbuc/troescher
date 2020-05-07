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
@WebServlet(name = "CtrlSelectDetail", urlPatterns = {"/ctrlselectdetail"})
public class CtrlSelectDetail extends HttpServlet {

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
        DVD dvd=null;

        String sql = "select dvd.did, titel, laenge, erscheinungsjahr, sprache.name as sprache_name, genre.name as genre_name, fsk, zurueck from dvd, genre, sprache, dvd_sprache , dvd_kunde where dvd.gid=genre.gid and dvd.did=dvd_sprache.did and dvd_sprache.sid=sprache.sid and dvd.did=? and dvd.did=dvd_kunde.did  order by dvd.did";

        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, Integer.parseInt(request.getParameter("did")));

            ResultSet rs = pstm.executeQuery();

            int did = 0;
            String titel = null;
            int laenge = 0;
            int erscheinungsjahr = 0;
            ArrayList<String> sprache = new ArrayList<>();
            String genre = null;
            int fsk = 0;

            rs.next();
            did = rs.getInt(1);
            titel = rs.getString(2);
            laenge = rs.getInt(3);
            erscheinungsjahr = rs.getInt(4);
            sprache.add(rs.getString(5));
            genre = rs.getString(6);
            fsk = rs.getInt(7);

            dvd = new DVD(did, titel, laenge, erscheinungsjahr, sprache, genre, fsk);
            if (rs.getDate(8) == null) {
                dvd.setVerliehen(true);
            }

            while (rs.next()) {
                dvd.getSprache().add(rs.getString(5));
            }
            dbPool.releaseConnection(conn);
        } catch (SQLException ex) {
            response.getWriter().print(ex);
        }
        
        request.setAttribute("dvd", dvd);
        RequestDispatcher view = request.getRequestDispatcher("view_details.jsp");
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
