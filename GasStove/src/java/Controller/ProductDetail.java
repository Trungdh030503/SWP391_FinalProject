/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.CategoryDAO;
import DAO.FeedBackDAO;
import DAO.ProductDAO;
import Entity.Category;
import Entity.Feedback;
import Entity.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import javax.imageio.ImageIO;

/**
 *
 * @author 5580
 */
@MultipartConfig

public class ProductDetail extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String model = request.getParameter("model");
        String category = request.getParameter("category");
        String brand = request.getParameter("brand");
        String price = request.getParameter("price");
        String sale = request.getParameter("sale");
        String stock = request.getParameter("stock");
        String warranty = request.getParameter("warranty");
        String description = request.getParameter("description");

        price = price.replace(",", "");

        // Retrieve file upload
        Part part = request.getPart("imagefile");

//        String realPath = request.getServletContext().getRealPath("web/client/img");
        String realPath = request.getServletContext().getRealPath("/");
        String webAppRoot = realPath.substring(0, realPath.lastIndexOf("build"));

        String convertedPath = webAppRoot.replace("\\", "/");

        String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();

        String newFilename = "";
        try {
            String fileExtension = filename.substring(filename.lastIndexOf('.'));
            newFilename = "img/imgno" + id + fileExtension;
            String filePath = convertedPath + "web/client/" + newFilename;
            InputStream fileContent = part.getInputStream();
            System.out.println(fileContent);
            try {
                File outputFile = new File(filePath);
                Files.copy(fileContent, outputFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Image saved successfully.");
            } catch (IOException e) {
                System.out.println("Failed to save");
            }

        } catch (Exception e) {

        }
        CategoryDAO cd = new CategoryDAO();
        // Perform further processing with the retrieved form field values and file information
        ProductDAO pd = new ProductDAO();
        Product p = pd.getProductById(Integer.parseInt(id));
        p.setProductName(name);
        p.setBrand(brand);
        p.setCategoryID(cd.getCategoryID(category));
        p.setUnitPrice(Double.parseDouble(price));
        p.setSaleoff(Integer.parseInt(sale));
        p.setWarrantyPeriod(warranty);
        p.setStock(Integer.parseInt(stock) + p.getStock());
        p.setDescription(description);
        p.setImageURL(p.getImageURLsString() + " "+newFilename);
        p.setModelNumber(model);
        
        pd.generateSerialNumber(p, Integer.parseInt(stock));
        
//        System.out.println("Product: " + p.toString());
        System.out.println(name);
        System.out.println(model);
        System.out.println();
        pd.updateProduct(p);
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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String role = req.getParameter("role");

        String type = (String) req.getSession().getAttribute("type");
        String pathInfo = req.getPathInfo();
        String segment = "";
        if (pathInfo != null && pathInfo.length() > 1) {
            // Remove the leading slash '/'
            segment = pathInfo.substring(1);
        }
        ProductDAO pd = new ProductDAO();
        CategoryDAO cd = new CategoryDAO();
//      
        Product p = pd.getProductByCode(segment);
        String category = cd.getCategory(p.getCategoryID());
        
        FeedBackDAO fb = new FeedBackDAO();
        List<Feedback> flist = fb.getFeedbackbyProductID(p.getProductID());
        req.setAttribute("flist", flist);
        
        if (type == null || type.equals("")) {
            req.setAttribute("product", p);
            req.setAttribute("category", category);
            req.getSession().setAttribute("activepage", "product");
            req.getRequestDispatcher("../client/detail.jsp").forward(req, resp);
        } //        System.out.println(category);
        else if (type.equals("Employee") || type.equals("admin")) {
            List<String> brands = pd.getBrandList();

            List<Category> categories = cd.getAllCategory();

            req.setAttribute("categories", categories);

            req.setAttribute("brands", brands);

            req.setAttribute("product", p);

            req.getRequestDispatcher("../admin/product-edit.jsp").forward(req, resp);
//            
        } else {
            req.setAttribute("product", p);
            req.setAttribute("category", category);
            req.getSession().setAttribute("activepage", "product");
            req.getRequestDispatcher("../client/detail.jsp").forward(req, resp);
        }

    }

}
