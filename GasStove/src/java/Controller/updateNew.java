/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.NewDAO;
import Entity.New;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author krikn
 */
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 10, // 10 MB
        maxRequestSize = 1024 * 1024 * 10 // 10 MB
)
public class updateNew extends HttpServlet {

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

        HttpSession session = request.getSession();
        String id = (String) session.getAttribute("id");
        int idd = Integer.parseInt(id);

        Part Avatar = request.getPart("Avatar");
        String Avatar1;
        if (!extractFileName(Avatar).equals("")) {
            String fileName = extractFileName(Avatar);
            // refines the fileName in case it is an absolute path
            fileName = new File(fileName).getName();
            Avatar.write(this.getFolderUpload().getAbsolutePath() + File.separator + fileName);
            Avatar1 = fileName;
        } else {
            Avatar1 = null;
        }

        New news = new New();
        news.setNewID(idd);
        news.setType(request.getParameter("type"));
        news.setTitle(request.getParameter("title"));
        news.setDescription(request.getParameter("description"));
        news.setCategoryID(Integer.parseInt(request.getParameter("categoryID")));
        news.setImageURL(Avatar1);
        news.setProductID(Integer.parseInt(request.getParameter("productID")));
        news.setSalePercent(Integer.parseInt(request.getParameter("salePercent")));

        NewDAO nd = new NewDAO();
        nd.updateNew(news);
        request.getRequestDispatcher("listNew").forward(request, response);
    }

    public File getFolderUpload() {

        File folderUpload = new File("E:\\SWP\\Project\\group_6\\GasStove\\web\\newImage");
        if (!folderUpload.exists()) {
            folderUpload.mkdirs();
        }
        return folderUpload;
    }

    private String extractFileName(Part part) {
        String fileName = "";
        if (part != null) {
            String contentDisp = part.getHeader("content-disposition");
            if (contentDisp != null) {
                String[] items = contentDisp.split(";");
                for (String s : items) {
                    if (s.trim().startsWith("filename")) {
                        fileName = s.substring(s.indexOf("=") + 2, s.length() - 1);
                    }
                }
            }
        }
        return fileName;
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