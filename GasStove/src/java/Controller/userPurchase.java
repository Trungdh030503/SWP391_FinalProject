/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.DeliveryDAO;
import DAO.PurchaseDAO;
import Entity.Order;
import Entity.OrderDetail;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 5580
 */
public class userPurchase extends HttpServlet {

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
            out.println("<title>Servlet userPurchase</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet userPurchase at " + request.getContextPath() + "</h1>");
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
        String type = (String) request.getSession().getAttribute("type");
        PurchaseDAO pcd = new PurchaseDAO();
        HttpSession session = request.getSession();
        int id = (int) session.getAttribute("id");
        try {
            List<OrderDetail> orderlist = pcd.getOrdersyCustomerID(id);
            request.setAttribute("olist", orderlist);
        } catch (SQLException ex) {
//            Logger.getLogger(userPurchase.class.getName()).log(Level.SEVERE, null, ex);
        }
        DeliveryDAO dd = new DeliveryDAO();
        List<Order> list;
        if (type == null || type.equals("")) {
            list = dd.getOrderByCustomerID(id);
        } else if (type.equals("Employee") || type.equals("admin")) {
            list = dd.getAllOrders();
//            
        } else {
            list = dd.getOrderByCustomerID(id);
        }
        List<Order> list1 = new ArrayList<>();
        List<Order> list2 = new ArrayList<>();
        List<Order> list3 = new ArrayList<>();
        List<Order> list4 = new ArrayList<>();
        request.setAttribute("list", list);
        for (Order o : list) {
            if (o.getStatus().equals("Waiting")) {
                list1.add(o);
            } else if (o.getStatus().equals("Shipping") || o.getStatus().equals("Shipped")) {
                list2.add(o);
            } else if (o.getStatus().equals("Completed")) {
                list3.add(o);
            } else if (o.getStatus().equals("Canceled")) {
                list4.add(o);
            }
        }
        request.setAttribute("l1", list1);
        request.setAttribute("l2", list2);
        request.setAttribute("l3", list3);
        if (type == null || type.equals("")) {
            request.getSession().setAttribute("activepage", "productlist");
//            request.getRequestDispatcher("client/shop.jsp").forward(request, response);
            request.getRequestDispatcher("client/userpurchase.jsp").forward(request, response);
//            response.sendRedirect("client/shop.jsp");
        } else if (type.equals("Employee") || type.equals("admin")) {
            request.getRequestDispatcher("admin/ManageOrders.jsp").forward(request, response);
//            
        } else {
//            request.getSession().setAttribute("activepage", "productlist");
            request.getRequestDispatcher("client/userpurchase.jsp").forward(request, response);
//            response.sendRedirect("client/shop.jsp");
        }
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
