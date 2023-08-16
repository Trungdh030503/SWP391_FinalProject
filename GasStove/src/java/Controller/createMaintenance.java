/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.CartDAO;
import DAO.CustomerDAO;
import DAO.MaintenanceDAO;
import DAO.ProductDAO;
import Entity.CartItem;
import Entity.Customer;
import Entity.Maintenance;
import Entity.MaintenanceRequest;
import Entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.math.BigDecimal;

/**
 *
 * @author 5580
 */
public class createMaintenance extends HttpServlet {

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
            out.println("<title>Servlet createMaintenance</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet createMaintenance at " + request.getContextPath() + "</h1>");
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
        int id = Integer.parseInt(request.getParameter("id"));
        MaintenanceDAO md = new MaintenanceDAO();
        CustomerDAO cd = new CustomerDAO();
        ProductDAO pd = new ProductDAO();
        MaintenanceRequest rq = md.getRequestByID(id);
        Customer c = cd.getCustomerById(rq.getCustomerID());
        Product p = pd.getProductById(rq.getProductID());
        request.setAttribute("c", c);
        request.setAttribute("p", p);
        request.setAttribute("id", id);
        request.getRequestDispatcher("admin/createMaintenance.jsp").forward(request, response);
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
        int RequestID = Integer.parseInt(request.getParameter("requestid"));
        int CustomerID = Integer.parseInt(request.getParameter("customerid"));
        int ProductID = Integer.parseInt(request.getParameter("productid"));
        int saleprice = Integer.parseInt(request.getParameter("sale"));
        String description = request.getParameter("description");
        String productname= request.getParameter("productname");
        ProductDAO pd = new ProductDAO();
        CartDAO cd = new CartDAO();
        Product p = new Product();
        p.setCategoryID(13);
        p.setProductName("Sua san pham "+ productname);
        p.setImageURL("fixing.png");
        p.setUnitPrice(saleprice);
        p.setDescription(description);
        p.setModelNumber("ssp");
        p.setBrand("GasStove");
        p.setWarrantyPeriod("");
        
        
        int productid = pd.insertnewProduct(p);
        
        CartItem ci = new CartItem(productname, BigDecimal.valueOf(saleprice), 1, BigDecimal.valueOf(saleprice));
        ci.setProductID(productid+"");
        cd.addToCart(ci, CustomerID);
        
        MaintenanceDAO md = new MaintenanceDAO();
        md.ResolveRequest(RequestID);
        Maintenance m = new Maintenance();
        m.setProductID(ProductID);
        m.setCustomerID(CustomerID);
        m.setMaintenanceDetail(saleprice+"");
        md.CreateMaintenance(m);
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
