/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.CustomerDAO;
import Entity.CartItem;
import Entity.Customer;
import DAO.CartDAO;
import DAO.MaintenanceDAO;
import DAO.ProductDAO;
import DAO.WarrantyDAO;
import Entity.CartItem;
import Entity.Maintenance;
import Entity.MaintenanceRequest;
import Entity.Product;
import Entity.Warranty;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DUC ANH
 */
public class addToCartController extends HttpServlet {

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
            out.println("<title>Servlet addToCartController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet addToCartController at " + request.getContextPath() + "</h1>");
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
        String page = request.getParameter("page");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        int customerID = (int) session.getAttribute("id");
        String productName = request.getParameter("productName");
        String productID = request.getParameter("productID");
        String unitPriceStr = request.getParameter("salePrice").replaceAll("[^\\d.]", "").replace(".", "");
        BigDecimal unitPrice;
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");

        // Tìm sản phẩm trong giỏ hàng dựa trên tên sản phẩm
        CartItem existingItem = null;
        if (cart != null) {
            for (CartItem item : cart) {
                if (item.getProductName().equals(productName)) {
                    existingItem = item;
                    break;
                }
            }
        }

        if (existingItem != null) {
            // Tăng số lượng sản phẩm nếu đã tồn tại trong giỏ hàng
            existingItem.increaseQuantity();
            existingItem.calculateTotalPrice();
        } else {
            // Nếu sản phẩm chưa tồn tại trong giỏ hàng, thêm mới
            unitPrice = new BigDecimal(unitPriceStr);
            // Tạo đối tượng CartItem để lưu thông tin sản phẩm
            CartItem item = new CartItem();
            item.setProductName(productName);
            item.setQuantity(1);
            item.setUnitPrice(unitPrice);
            item.setProductID(productID);
            item.calculateTotalPrice();
            //CartItem item = new CartItem(productName, unitPrice, 1); // Số lượng mặc định là 1
            if (cart == null) {
                cart = new ArrayList<>();
            }
            cart.add(item);
            CartDAO cartDAO = new CartDAO();
            cartDAO.addToCart(item, customerID);
        }

        // Lưu lại giỏ hàng vào session
        session.setAttribute("cart", cart);

//        request.getRequestDispatcher("productController").forward(request, response);
        if (page.equals("warrantyTracking")) {

            MaintenanceDAO md = new MaintenanceDAO();
            MaintenanceRequest rq = new MaintenanceRequest();
            rq.setCustomerID(customerID);
            rq.setProductID(Integer.parseInt(productID));

            int orderID = Integer.parseInt(request.getParameter("orderID"));
            int warrantyID = Integer.parseInt(request.getParameter("warrantyID"));

            WarrantyDAO wd = new WarrantyDAO();
            System.out.println("order: " + orderID);
            System.out.println("warranty: " + orderID);

//                int update = wd.updateWarranty(warrantyID, orderID, 4, Integer.parseInt(productID));
//                System.out.println("update: "  +update);
            md.createRequest(rq);
            response.sendRedirect("warrantyTracking");
            return;
        }

        if (page.equals("shop")) {
            response.sendRedirect("productController");
        } else {
            ProductDAO pd = new ProductDAO();
            Product p = pd.getProductById(Integer.parseInt(productID));
            
            response.sendRedirect("/GasStove/Detail/"+p.getProductcode());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int customerID = (int) session.getAttribute("id");
        String productID = request.getParameter("productID");
        System.out.println(productID);
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");

        if (cart != null) {
            // Tìm và xóa mục trong giỏ hàng dựa trên ProductID
            Iterator<CartItem> iterator = cart.iterator();
            while (iterator.hasNext()) {
                CartItem item = iterator.next();
                if (item.getProductID().equals(productID)) {
                    System.out.println("item.getProductID():" + item.getProductID() + " = " + productID + " " + item.getProductName());
                    iterator.remove();
                    // Xóa sản phẩm từ cơ sở dữ liệu
                    CartDAO cartDAO = new CartDAO();
                    try {
                        cartDAO.removeFromCart(productID, customerID);
                    } catch (SQLException ex) {
                        Logger.getLogger(addToCartController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                }
            }

            // Lưu lại giỏ hàng mới vào session
            session.setAttribute("cart", cart);

        }

        request.getRequestDispatcher("/cartController").forward(request, response);
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
