/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller;

import DAO.CartDAO;
import DAO.CheckoutDAO;
import Entity.CartItem;
import Entity.Order;
import com.vnpay.common.Config;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author DUC ANH
 */
public class checkoutVnpayController extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
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
            out.println("<title>Servlet checkoutVnpayController</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet checkoutVnpayController at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        PrintWriter out = response.getWriter();
            Map fields = new HashMap();
            for (Enumeration params = request.getParameterNames(); params.hasMoreElements();) {
                String fieldName = URLEncoder.encode((String) params.nextElement(), StandardCharsets.US_ASCII.toString());
                String fieldValue = URLEncoder.encode(request.getParameter(fieldName), StandardCharsets.US_ASCII.toString());
                if ((fieldValue != null) && (fieldValue.length() > 0)) {
                    fields.put(fieldName, fieldValue);
                }
            }

            String vnp_SecureHash = request.getParameter("vnp_SecureHash");
            if (fields.containsKey("vnp_SecureHashType")) {
                fields.remove("vnp_SecureHashType");
            }
            if (fields.containsKey("vnp_SecureHash")) {
                fields.remove("vnp_SecureHash");
            }
            String signValue = Config.hashAllFields(fields);
            
            if (signValue.equals(vnp_SecureHash)) {
            if ("00".equals(request.getParameter("vnp_TransactionStatus"))) {
                HttpSession session = request.getSession();
                int customerID = (int)session.getAttribute("id");
                Order order = (Order) session.getAttribute("order");
                String dateRequired = (String)session.getAttribute("dateRequired");
                List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
                // Sử dụng đối tượng order
                CheckoutDAO checkoutDAO = new CheckoutDAO();
                try { 
                    checkoutDAO.createOrder(order, dateRequired, cart);
                    Iterator<CartItem> iterator = cart.iterator();
                while (iterator.hasNext()) {
                    CartItem item = iterator.next();
                    iterator.remove();
                    // Xóa sản phẩm từ cơ sở dữ liệu
                    CartDAO cartDAO = new CartDAO();
                    try {
                        cartDAO.removeFromCart(item.getProductID(), customerID);
                    } catch (SQLException ex) {
                        Logger.getLogger(addToCartController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                // Step 3: Clear the cart stored in the session
                session.removeAttribute("cart");
                response.sendRedirect("./client/checkoutNotify.html");
                } catch (ParseException ex) {
                    Logger.getLogger(checkoutVnpayController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                out.print("Failed");
            }

            } else {
                out.print("invalid signature");
            }
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
