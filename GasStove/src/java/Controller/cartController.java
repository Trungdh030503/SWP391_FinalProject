/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.CouponDAO;
import DAO.MaintenanceDAO;
import Entity.CartItem;
import Entity.Coupon;
import Entity.Maintenance;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 5580
 */
public class cartController extends HttpServlet {

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
            out.println("<title>Servlet cartController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet cartController at " + request.getContextPath() + "</h1>");
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
        request.getSession().setAttribute("activepage", "Cart");
        int customerid = (int) request.getSession().getAttribute("id");
        CouponDAO cd = new CouponDAO();
        
        ArrayList<Coupon> coupons = cd.getCouponforCart(customerid);
        request.setAttribute("coupons", coupons);
        
        request.getRequestDispatcher("client/addToCart.jsp").forward(request, response);
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
        request.getSession().setAttribute("activepage", "Cart");
        int id = (int) request.getSession().getAttribute("id");
        MaintenanceDAO md = new MaintenanceDAO();
        BigDecimal subtract = new BigDecimal("0");
        List<Maintenance> mlist = md.getMaintenanceByCustomerID(id);
        List<CartItem> cart = (List<CartItem>) request.getSession().getAttribute("cart");
        List<Integer> ids = new ArrayList();

        
        for(CartItem c : cart){
            ids.add(Integer.parseInt(c.getProductID()));
        }

        for(Maintenance m : mlist){
            if (ids.contains(m.getProductID())){
                BigDecimal add = new BigDecimal(m.getMaintenanceDetail());

                subtract = subtract.add(add);
            }
        }
        request.setAttribute("subtract", subtract);
        request.getRequestDispatcher("client/addToCart.jsp").forward(request, response);;
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
