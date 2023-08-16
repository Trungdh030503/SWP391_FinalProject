/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.CategoryDAO;
import DAO.ProductDAO;
import Entity.Category;
import Entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.File;
import java.util.List;

/**
 *
 * @author 5580
 */
@MultipartConfig

public class addProduct extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = resp.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet addProduct</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet addProduct at " + req.getContextPath() + "</h1>");
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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
     

        ProductDAO pd = new ProductDAO();
        CategoryDAO cd = new CategoryDAO();
//        Product p = pd.getProductById(Integer.parseInt(req.getParameter("productID")));

        List<String> brands = pd.getBrandList();

        List<Category> categories = cd.getAllCategory();
        System.out.println("Categorylist: " + categories.size());

//            System.out.println(categories.size());

        req.setAttribute("categories", categories);

        req.setAttribute("brands", brands);

//        req.setAttribute("product", p);

        req.getRequestDispatcher("admin/addproduct.jsp").forward(req, resp);
        
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
//        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String model = request.getParameter("model");
        String category = request.getParameter("category");
        String brand = request.getParameter("brand");
        String price = request.getParameter("price");
        String sale = request.getParameter("sale");
        String stock = request.getParameter("stock");
        String warranty = request.getParameter("warranty");
        String description = request.getParameter("description");
        System.out.println(name + model);
        try{
        price = price.replace(",", "");
            
        }catch (Exception e){
            
        }
        
//         Retrieve file upload
        Part part = request.getPart("imagefile");
        
//        String realPath = request.getServletContext().getRealPath("web/client/img");
        String realPath = request.getServletContext().getRealPath("/");
        String webAppRoot = realPath.substring(0, realPath.lastIndexOf("build"));
        
        String convertedPath = webAppRoot.replace("\\", "/");
        
        String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
        String newFilename = "";
        try{
            String fileExtension = filename.substring(filename.lastIndexOf('.'));
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String prefix = dateFormat.format(new Date());

            newFilename = "img/" + prefix + filename;
            
            String filePath = convertedPath + "web/client/" + newFilename;
            System.out.println(filePath);
            InputStream fileContent = part.getInputStream();
            System.out.println(fileContent);
            try {
                File outputFile = new File(filePath);
                Files.copy(fileContent, outputFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Image saved successfully.");
            } catch (IOException e) {
                System.out.println("Failed to save");
            }
            
        }catch (Exception e){
            
        }
        CategoryDAO cd = new CategoryDAO();
        // Perform further processing with the retrieved form field values and file information
        Product p = new Product();
//        p.setProductID(Integer.parseInt(id));
        p.setProductName(name);
        p.setBrand(brand);
        p.setCategoryID(cd.getCategoryID(category));
        p.setUnitPrice(Double.parseDouble(price));
        p.setSaleoff(Integer.parseInt(sale));
        p.setWarrantyPeriod(warranty);
        p.setStock(Integer.parseInt(stock));
        p.setDescription(description);
        p.setImageURL(newFilename);
        p.setModelNumber(model);
        ProductDAO pd = new ProductDAO();
        pd.insertProduct(p);
        response.sendRedirect("/GasStove/productController");
    }

    private String getFileName(Part part) {
        String contentDisposition = part.getHeader("content-disposition");
        String[] tokens = contentDisposition.split(";");
        for (String token : tokens) {
            if (token.trim().startsWith("filename")) {
                return token.substring(token.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
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
