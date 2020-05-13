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
import java.util.ArrayList;
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
@WebServlet(name = "CtrlUpdateSelectDVD", urlPatterns = {"/ctrlupdateselectdvd"})
public class CtrlUpdateSelectDVD extends HttpServlet {

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

        //Abfrage, ob Admin eingeloggt ist!
        HttpSession session = request.getSession();
        String sessionid = session.getId();
        ConnectionPool dbPool = (ConnectionPool) getServletContext().getAttribute("dbPool");
        Connection conn = dbPool.getConnection();
        String check = "select kid from kunde where sessionId=?";
        try {
            PreparedStatement pstm = conn.prepareStatement(check);

            pstm.setString(1, sessionid);
            ResultSet rs = pstm.executeQuery();
            int kid = 0;
            if (rs.next()) {
                kid = rs.getInt(1);

                if (kid == 0 || kid >= 2) {
                    RequestDispatcher logInView = request.getRequestDispatcher("loginPage.html");
                    logInView.forward(request, response);
                }
            } else {
                RequestDispatcher logInView = request.getRequestDispatcher("loginPage.html");
                logInView.forward(request, response);
            }
        } catch (SQLException ex) {
            response.getWriter().print(ex.getMessage());
        }

        int did = Integer.parseInt(request.getParameter("did"));

        String sql = "select * from genre";
        String sql2 = "select * from sprache";

        ArrayList<Genre> genreList = new ArrayList<>();
        ArrayList<Sprache> spracheList = new ArrayList<>();

        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                genreList.add(new Genre(rs.getInt("gid"), rs.getString("name")));
            }

            pstm = conn.prepareStatement(sql2);
            rs = pstm.executeQuery();
            while (rs.next()) {
                spracheList.add(new Sprache(rs.getInt(1), rs.getString(2)));
            }

            dbPool.releaseConnection(conn);
        } catch (SQLException ex) {
            response.getWriter().print(ex.getMessage());
        }

        DVD dvd = null;

        sql = "select dvd.did, titel, laenge, erscheinungsjahr, sprache.name as sprache_name, genre.name as genre_name, fsk "
                + "from dvd, genre, sprache, dvd_sprache "
                + "where dvd.gid=genre.gid and dvd.did=dvd_sprache.did "
                + "and dvd_sprache.sid=sprache.sid and dvd.did=?";

        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, Integer.parseInt(request.getParameter("did")));

            ResultSet rs = pstm.executeQuery();

            String titel = null;
            int laenge = 0;
            int erscheinungsjahr = 0;
            ArrayList<String> sprache = new ArrayList<>();
            String genre = null;
            int fsk = 0;

            rs.next();

            titel = rs.getString(2);
            laenge = rs.getInt(3);
            erscheinungsjahr = rs.getInt(4);
            sprache.add(rs.getString(5));
            genre = rs.getString(6);
            fsk = rs.getInt(7);

            dvd = new DVD(did, titel, laenge, erscheinungsjahr, sprache, genre, fsk);

            while (rs.next()) {
                dvd.getSprache().add(rs.getString(5));
            }

            //FSK Liste erstellen, damit ausgewähltes Alter ganz oben staht
            ArrayList<Integer> fskList = new ArrayList<>();
            fskList.add(fsk);
            fskList.add(0);
            fskList.add(6);
            fskList.add(12);
            fskList.add(16);
            fskList.add(18);

            //Sprache in zwei ArrayLists teilen , die eine checked die andere die übrigen
            ArrayList<Sprache> spracheChecked = new ArrayList<>();
            ArrayList<Sprache> spracheUnchecked = new ArrayList<>();
            for (int i = 0; i < spracheList.size(); i++) {
                boolean vorhanden = false;
                for (int j = 0; j < dvd.getSprache().size(); j++) {
                    if (spracheList.get(i).getName().equals(dvd.getSprache().get(j))) {
                        spracheChecked.add(spracheList.get(i));
                        vorhanden = true;
                    }

                }
                if (!vorhanden) {
                    spracheUnchecked.add(spracheList.get(i));
                }

            }

            //GenreList sortieren, damit ausgewähltes ganz oben steht 
            Genre temp = null;
            for (int i = 0; i < genreList.size(); i++) {
                if (genreList.get(i).getName().equals(genre)) {
                    temp = genreList.get(i);
                    genreList.remove(i);
                }
            }
            ArrayList<Genre> akku = new ArrayList<>();
            akku.add(temp);
            for (int i = 0; i < genreList.size(); i++) {
                akku.add(genreList.get(i));
            }

            request.setAttribute("genreList", akku);
            request.setAttribute("spracheChecked", spracheChecked);
            request.setAttribute("spracheUnchecked", spracheUnchecked);
            request.setAttribute("dvd", dvd);
            request.setAttribute("fskList", fskList);
            RequestDispatcher view = request.getRequestDispatcher("dvdupdate.jsp");
            view.forward(request, response);

        } catch (SQLException e) {

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
