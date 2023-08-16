/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller;

import DAO.CartDAO;
import DAO.CheckoutDAO;
import Entity.CartItem;
import Entity.Order;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author 5580
 */


public class checkoutController extends HttpServlet {
   
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
            out.println("<title>Servlet checkOutController</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet checkOutController at " + request.getContextPath () + "</h1>");
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
                HttpSession session = request.getSession(true);
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        System.out.println("size of cart is: " + cart.size());
        for (CartItem cartItem : cart) {
            System.out.println(cartItem.getProductName() + " " + cartItem.getProductID() + "\n");
        }
        
        try{
            String subtract = request.getParameter("subtract");
            BigDecimal ret = new BigDecimal(subtract);
            request.setAttribute("subtract", ret);
        } catch(Exception e){
//            session.setAttribute("subtract", "0");
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
        request.getRequestDispatcher("client/checkout.jsp").forward(request, response);
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
        try {
            String paymentMethod = request.getParameter("payment");
            PrintWriter out = response.getWriter();
            response.setContentType("text/html;charset=UTF-8");
            HttpSession session = request.getSession();
            List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
            int customerID = (int)session.getAttribute("id");

            int totalPrice = Integer.parseInt(request.getParameter("totalPrice"));
            //get Information
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");
            String phoneNumber = request.getParameter("phoneNumber");
            String city = request.getParameter("city");
            String district = request.getParameter("district");
            String addressDetail = request.getParameter("addressDetail");
            String dateRequired = request.getParameter("dateRequired");
            //out.print(paymentMethod + firstName + " " + lastName + " " + email + " " + phoneNumber + " " + city + " " + district + " " + addressDetail + " " + dateRequired + " " + totalPrice);
            
            Order order = new Order();
            order.setCustomerID(customerID);
            order.setTotalPrice(totalPrice);
            order.setShipName(addressDetail);
            order.setShipCity(city);
            order.setShipAddress(district);
            request.getSession().setAttribute("order", order);
            CheckoutDAO checkoutDAO = new CheckoutDAO();
            if(paymentMethod.equals("paypal")){
                session.setAttribute("priceCheckout", totalPrice);
                session.setAttribute("dateRequired", dateRequired);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }else{
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
            }
        } catch (ParseException ex) {
            Logger.getLogger(checkoutController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
