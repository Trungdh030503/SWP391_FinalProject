/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.CartDAO;
import Entity.CartItem;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Admin
 */
public class logoutController extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet logoutController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet logoutController at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession(true);
        
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        
        if (cart == null) {
            request.getSession().setAttribute("id", null);
            request.getSession().setAttribute("type", null);
            response.sendRedirect("productController");
            return;
        }
        System.out.println("size of cart is: " + cart.size());
        for (CartItem cartItem : cart) {
            System.out.println(cartItem.getProductName() + " " + cartItem.getProductID() + "\n");
        }
        if (cart != null && !cart.isEmpty()) {
            // Duyệt qua tất cả các sản phẩm trong giỏ hàng
            for (CartItem item : cart) {
                // Cập nhật sản phẩm trong cơ sở dữ liệu
                String productID = item.getProductID();
                int quantity = item.getQuantity();
                BigDecimal unitPrice = item.getUnitPrice();
                BigDecimal totalPrice = item.getTotalPrice();
                CartItem cartUpdate = new CartItem();
                cartUpdate.setProductID(productID);
                cartUpdate.setQuantity(quantity);
                cartUpdate.setTotalPrice(totalPrice);
                cartUpdate.setUnitPrice(unitPrice);
                CartDAO cartDAO = new CartDAO();
                cartDAO.updateCartItem(cartUpdate, (int)request.getSession().getAttribute("id"));
            }
        }
        session.removeAttribute("cart");
        request.getSession().setAttribute("id", null);
        request.getSession().setAttribute("type", null);
        // Hoặc hủy toàn bộ session
        session.invalidate();
        response.sendRedirect("productController");
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
