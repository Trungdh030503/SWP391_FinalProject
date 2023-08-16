/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;


import DAO.ProductDAO;
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
 * @author 5580
 */
public class searchProduct extends HttpServlet {

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
        String keyword = request.getParameter("keyword");
        keyword = keyword.trim();
//        System.out.println("get in");
        ProductDAO pd = new ProductDAO();
        
        // Retrieve product suggestions from the database
        List<String> suggestions = pd.getProductSuggestions(keyword);

        // Convert suggestions to JSON
        String json = convertSuggestionsToJson(suggestions);

        // Set content type and write JSON response
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.print(json);
        out.flush();
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
        String search= request.getParameter("Search");
        ProductDAO pd= new ProductDAO();
//        Product p = pd.getProductByName(search);
        List<Product> plist = pd.getSearch(search);
//        System.out.println(plist.size());
        
        HttpSession session = request.getSession();
        session.setAttribute("searchList", plist);

        response.sendRedirect("productController");
        request.setAttribute("searchlist", plist);
//        request.getRequestDispatcher("productController").forward(request, response);
    }
    
    private String convertSuggestionsToJson(List<String> suggestions) {
    StringBuilder json = new StringBuilder();
    json.append("[");
    for (int i = 0; i < suggestions.size(); i++) {
      json.append("\"").append(suggestions.get(i)).append("\"");
      if (i < suggestions.size() - 1) {
        json.append(",");
      }
    }
    json.append("]");
    return json.toString();
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
