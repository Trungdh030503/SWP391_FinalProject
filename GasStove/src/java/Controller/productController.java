/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.CategoryDAO;
import DAO.EmployeeDAO;
import DAO.ProductDAO;
//import DAO.ProductDAO;
import Entity.Category;
import Entity.Employee;
import Entity.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author 5580
 */
public class productController extends HttpServlet {

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
            out.println("<title>Servlet productController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet productController at " + request.getContextPath() + "</h1>");
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
//        ProductDAO pd = new ProductDAO();
        ProductDAO pd = new ProductDAO();
        CategoryDAO cd = new CategoryDAO();
        ArrayList<ArrayList<Category>> clist = cd.getCategory();
        String type = (String) request.getSession().getAttribute("type");
//        System.out.println(type);

        
        int pageNumber = 1;
        int shownumber = 9;
        String order = "none";
        String brand = "none";
        try {
            pageNumber = Integer.parseInt(request.getParameter("page"));
//            System.out.println(pageNumber);
        } catch (Exception e){
        
        }
        try{
            shownumber = Integer.parseInt(request.getParameter("shownumber"));
//            System.out.println(shownumber);
        } catch (Exception e){
//            System.out.println("can not find number");
        }
        
        if (request.getParameter("order") != null)
        try{
            order = request.getParameter("order");
//            System.out.println(order);
        } catch (Exception e){
//            System.out.println("can not find number");
        }

        List<Product> plist = null;
        
        plist = pd.getAllProducts();
        
        String category = "";
        String subcategory = "";
        
        try {
            category = request.getParameter("category");
        } catch (Exception e){
        }
        
        try {
            subcategory = request.getParameter("subcategory");
            System.out.println(subcategory);
        } catch (Exception e){
        }
        
        // Check if category is provided
        if (category != null && !category.isEmpty()) {
            // Check if subcategory is provided
            if (subcategory != null && !subcategory.isEmpty()) {
                // Apply both category and subcategory filters
                // Perform actions specific to the category and subcategory filters
//                plist = pd.getProductsByCategoryName(Integer.parseInt(category));
                plist = pd.getProductsByCategoryID(Integer.parseInt(category));
                System.out.println("this");
            } else {
                // Apply category filter only
                // Perform actions specific to the category filter
                plist = pd.getProductsByCategoryID(Integer.parseInt(category));
//                System.out.println("category: " + category);
            }
        } else {    
        }
        

        
        
        List<String> blist = pd.getBrandList();
        
        List<Product> list = new ArrayList<>();
        
        if (order.equals("asc")){
            Collections.sort(plist, Comparator.comparingDouble(Product::getPrice));
        } else 
            if(order.equals("des")){
            Collections.sort(plist, Comparator.comparingDouble(Product::getPrice).reversed());
        }
        
        HttpSession session = request.getSession();
        List<Product> searchlist = (List<Product>) session.getAttribute("searchList");
        
        if (searchlist != null) {
            // Perform any necessary operations with the list
            plist = searchlist;
            // Remove the list from the session (optional)
            System.out.println(plist.size());
            session.removeAttribute("searchList");
            
        }
        try {
            for (int i = (pageNumber-1)*shownumber; i < (pageNumber*shownumber); i++){
                list.add(plist.get(i));
//                System.out.println("");
            }
            System.out.println(list.size());
//                System.out.println("size: " + list.size());
        } catch (Exception e) {
            for (int i = (pageNumber-1)*shownumber; i < plist.size(); i++){
                list.add(plist.get(i));
            }
            try{
                list.remove(0);
                
            } catch(Exception n){
                
            }

        }
        request.setAttribute("clist", clist);
        request.setAttribute("list", list);
//      
        if (type==null || type.equals("")){
            request.getSession().setAttribute("activepage", "productlist");
             request.getRequestDispatcher("client/shop.jsp").forward(request, response);
//            response.sendRedirect("client/shop.jsp");
        }
        else
        if (type.equals("Employee") || type.equals("admin")){
            request.getRequestDispatcher("admin/products.jsp").forward(request, response);
//            
        }
        else {
            request.getSession().setAttribute("activepage", "productlist");
            request.getRequestDispatcher("client/shop.jsp").forward(request, response);
//            response.sendRedirect("client/shop.jsp");
        }
    }
   
    void sortasc(List<Product> list){
        Collections.sort(list, Comparator.comparingDouble(Product::getPrice));
    }
    void sortdes(List<Product> list){
        Collections.sort(list, Comparator.comparingDouble(Product::getPrice).reversed());
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
        request.getRequestDispatcher("client/shop.jsp").forward(request, response);
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
