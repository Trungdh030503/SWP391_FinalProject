/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.CategoryDAO;
import DAO.CustomerDAO;
import DAO.NewDAO;
import DAO.ProductDAO;
import Entity.Category;
import Entity.Customer;
import Entity.New;
import Entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author krikn
 */
public class indexController extends HttpServlet {

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

        CategoryDAO cd = new CategoryDAO();
        ProductDAO pd= new ProductDAO();
        NewDAO nd= new NewDAO();
        
        ArrayList<ArrayList<Category>> clist = cd.getCategory();
        ArrayList<New> info= nd.getInfoNew("info");
        ArrayList<New> discount= nd.getDiscountNew("discount");
        List<Product> plist = null;
        
        String category = "";
        String subcategory = "";
        
        try {
            category = request.getParameter("category");
        } catch (Exception e){
        }
        
        try {
            subcategory = request.getParameter("subcategory");
        } catch (Exception e){
        }
        
        // Check if category is provided
        if (category != null && !category.isEmpty()) {
            // Check if subcategory is provided
            if (subcategory != null && !subcategory.isEmpty()) {
                // Apply both category and subcategory filters
                // Perform actions specific to the category and subcategory filters
                plist = pd.getProductsByCategoryName(Integer.parseInt(category));
            } else {
                // Apply category filter only
                // Perform actions specific to the category filter
                plist = pd.getProductsByCategoryID(Integer.parseInt(category));
//                System.out.println("category: " + category);
            }
        } else {
            System.out.println("cannot get");
            // No category provided, retrieve all products
            // Perform actions to retrieve all products
            // Example:
            // query = "SELECT * FROM products";
        }
        
        request.getSession().setAttribute("activepage", "home");
        ////////////////////////////////////////////
        
        
        request.setAttribute("clist", clist);
        request.setAttribute("info", info);
        request.setAttribute("discount", discount);
        request.getRequestDispatcher("client/index.jsp").forward(request, response);
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
