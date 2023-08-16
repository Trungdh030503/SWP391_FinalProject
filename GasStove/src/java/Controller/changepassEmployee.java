/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.CustomerDAO;
import DAO.EmployeeDAO;
import Entity.Customer;
import Entity.Employee;
import Entity.Status;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Lenovo
 */
public class changepassEmployee extends HttpServlet {

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
            out.println("<title>Servlet changepassEmployee</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet changepassEmployee at " + request.getContextPath() + "</h1>");
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
       request.getRequestDispatcher("admin/changepassEmployee.jsp").forward(request, response);
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
        PrintWriter out = response.getWriter();
        String opass = request.getParameter("opass");
        String npass = request.getParameter("npass");
        String cpass = request.getParameter("cpass");
        String encryptedPassword = encryptPassword(opass);
        String encryptedcpass = encryptPassword(cpass);

        int EmployeeId = (int) request.getSession().getAttribute("id");
        EmployeeDAO ed = new EmployeeDAO();
        Employee employee = ed.findEmployeeByID(EmployeeId);

        if (!encryptedPassword.equals(employee.getPassword())) {
            request.setAttribute("mess", new Status(400, "Old Password is not correct."));
            request.getRequestDispatcher("admin/changepassEmployee.jsp").forward(request, response);
            return;
        }
        if (!npass.equals(cpass)) {
            request.setAttribute("mess", new Status(400, "Confirm password does not match the new password."));
            request.getRequestDispatcher("admin/changepassEmployee.jsp").forward(request, response);
            return;
        }
        System.out.println("3");
        int statusChangePass = ed.updateEmpPass(encryptedcpass, EmployeeId);
        request.setAttribute("mess", new Status(200, "Change password successfull."));
        request.getRequestDispatcher("admin/changepassEmployee.jsp").forward(request, response);
        System.out.println(cpass);
        return;
    }
    private static final String SECRET_KEY = "YourSecretKey123";
    private static final String ENCRYPTION_ALGORITHM = "AES";

    public static String encryptPassword(String password) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(SECRET_KEY.getBytes(), ENCRYPTION_ALGORITHM);
            Cipher cipher = Cipher.getInstance(ENCRYPTION_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            byte[] encryptedBytes = cipher.doFinal(password.getBytes());
            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
            e.printStackTrace();
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
