/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.WarrantyDAO;
import Entity.Warranty;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public class feedback extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet editStatus</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet editStatus at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
//        processRequest(request, response);
        int wid = Integer.parseInt(request.getParameter("WarrantyID"));
        int pid = Integer.parseInt(request.getParameter("productID"));
        int oid = Integer.parseInt(request.getParameter("orderID"));
        WarrantyDAO wd = new WarrantyDAO();
        Warranty warranty = wd.getWarrantyBy3ID(wid, pid, oid);
        request.setAttribute("warranty", warranty);
        HttpSession session = request.getSession();
        session.setAttribute("id", wid);
//        request.getRequestDispatcher("admin/editStatus.jsp").forward(request, response);

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
//        processRequest(request, response);
        int WarrantyID = Integer.parseInt(request.getParameter("WarrantyID"));
        int productID = Integer.parseInt(request.getParameter("ProductID"));
        int orderID = Integer.parseInt(request.getParameter("OrderID"));
        String feedbackText = request.getParameter("feedbackText");
//        int WarrantyID = Integer.parseInt(request.getParameter("WarrantyID"));
        WarrantyDAO wd = new WarrantyDAO();

//        Warranty warranty = (Warranty) wd.getAllWarrantyByID(WarrantyID);
        int result = wd.updateWarrantyFeedback(WarrantyID, productID, orderID, feedbackText);
        // Thực hiện khi người dùng gửi phản hồi
//        HttpSession session = request.getSession();
//        session.setAttribute("feedbackStatus", "provided");

        Warranty warranty = wd.getAllWarrantyByID(WarrantyID);
        request.setAttribute("warranty", warranty);
        response.sendRedirect("warrantyTracking");

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
