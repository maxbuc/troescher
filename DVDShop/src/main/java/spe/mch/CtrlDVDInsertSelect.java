/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spe.mch;

import java.io.IOException;
import java.sql.*;
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
@WebServlet(name = "CtrlDVDInsertSelect", urlPatterns = {"/ctrldvdinsertselect"})
public class CtrlDVDInsertSelect extends HttpServlet {

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
        String sql = "select * from genre";
        String sql2 = "select * from sprache";
        ConnectionPool dbPool = (ConnectionPool) getServletContext().getAttribute("dbPool");
        Connection conn = dbPool.getConnection();

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
        
        request.setAttribute("genreList", genreList);
        request.setAttribute("spracheList", spracheList);
        
                
        RequestDispatcher view = request.getRequestDispatcher("dvdinsert.jsp");
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