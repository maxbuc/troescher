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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Maximilian
 */
@WebServlet(name = "CtrlDVDInsert", urlPatterns = {"/ctrldvdinsert"})
public class CtrlDVDInsert extends HttpServlet {

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

        String sql = "insert into dvd (titel, laenge, erscheinungsjahr, gid, fsk) values (?,?,?,?,?)";
        String[] sprachen=new String[1];
        sprachen[0]="1";
        if (request.getParameter("sprache") != null) {
            sprachen = request.getParameterValues("sprache");
        }
        ArrayList<Integer> sprachenList = new ArrayList<>();
        for (int i = 0; i < sprachen.length; i++) {
            sprachenList.add(Integer.parseInt(sprachen[i]));
        }

        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, request.getParameter("titel"));
            pstm.setInt(2, Integer.parseInt(request.getParameter("laenge")));
            pstm.setInt(3, Integer.parseInt(request.getParameter("erscheinungsjahr")));
            pstm.setInt(4, Integer.parseInt(request.getParameter("gid")));
            pstm.setInt(5, Integer.parseInt(request.getParameter("fsk")));

            pstm.executeUpdate();
            pstm = null;

            int did = 0;
            sql = "select did from dvd where titel=? and erscheinungsjahr = ?";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, request.getParameter("titel"));
            pstm.setInt(2, Integer.parseInt(request.getParameter("erscheinungsjahr")));
            ResultSet rs = pstm.executeQuery();
            rs.next();
            did = rs.getInt("did");

            pstm = null;
            rs = null;

            for (int i = 0; i < sprachenList.size(); i++) {
                sql = "insert into dvd_sprache values (?,?)";
                pstm = conn.prepareStatement(sql);
                pstm.setInt(1, did);
                pstm.setInt(2, sprachenList.get(i));
                pstm.executeUpdate();
            }

            dbPool.releaseConnection(conn);
            RequestDispatcher view = request.getRequestDispatcher("ctrlselectadmin");
            view.forward(request, response);
        } catch (SQLException ex) {

        } catch (NumberFormatException e) {
            RequestDispatcher view = request.getRequestDispatcher("ctrldvdinsertselect");
            view.forward(request, response);
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
