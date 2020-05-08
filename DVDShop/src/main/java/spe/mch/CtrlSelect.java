/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spe.mch;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

        String sql = "select dvd.did, titel, laenge, erscheinungsjahr, sprache.name as sprache_name, genre.name as genre_name, fsk from dvd, genre, sprache, dvd_sprache where dvd.gid=genre.gid and dvd.did=dvd_sprache.did and dvd_sprache.sid=sprache.sid order by dvd.did";

        ConnectionPool dbPool = (ConnectionPool) getServletContext().getAttribute("dbPool");
        Connection conn = dbPool.getConnection();
        ArrayList<DVD> akku = new ArrayList<>();
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();

            int did = 0;
            String titel = null;
            int laenge = 0;
            int erscheinungsjahr = 0;
            ArrayList<String> sprache = new ArrayList<>();
            String genre = null;
            int fsk = 0;

            while (rs.next()) {

                did = rs.getInt(1);
                titel = rs.getString(2);
                laenge = rs.getInt(3);
                erscheinungsjahr = rs.getInt(4);
                sprache.add(rs.getString(5));
                genre = rs.getString(6);
                fsk = rs.getInt(7);

                DVD dvd = new DVD(did, titel, laenge, erscheinungsjahr, sprache, genre, fsk);
                akku.add(dvd);
            }
            dbPool.releaseConnection(conn);

//            doppelte DVDs suchen
            for (int i = 0; i < akku.size() - 1; i++) {
                if (!akku.isEmpty() && akku.get(i).getDid() == akku.get(i + 1).getDid()) {
                    akku.get(i).getSprache().add(akku.get(i + 1).getSprache().get(0));
                    akku.remove(i + 1);
                    i--;
                }
            }
            dvdList = akku;

        } catch (SQLException e) {
            response.getWriter().print(e.getMessage());
        }

        request.setAttribute("dvdList", dvdList);
        RequestDispatcher view = request.getRequestDispatcher("dvdausgeben.jsp");
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
