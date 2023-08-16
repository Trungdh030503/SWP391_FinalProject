/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;


import DAO.CartDAO;
import DAO.CustomerDAO;
import DAO.EmployeeDAO;
import Entity.CartItem;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import Entity.Customer;
//import Entity.Customers;
import Entity.Employee;
import jakarta.servlet.http.HttpSession;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Admin
 */
public class loginController extends HttpServlet {

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
            out.println("<title>Servlet loginController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<img src=view/images/cinema.jpg/>");
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
        request.getRequestDispatcher("authentication-login.jsp").forward(request, response);
    }

    /**
     * Handles the HTTPcode>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String encryptedPassword = encryptPassword(password);

        CustomerDAO db = new CustomerDAO();
        EmployeeDAO ed = new EmployeeDAO();

        Customer customer = db.findCustomer(email);
        Employee employee = ed.findEmployee(email, encryptedPassword);//Add find email only

        if (customer != null) {
            request.getSession().setAttribute("id", customer.getCustomerID());
            request.getSession().setAttribute("type", "Customer");
            if (customer.getPassword().equals(encryptedPassword)) {
                CartDAO cartDAO = new CartDAO();
                HttpSession session = request.getSession(true);
                List<CartItem> cart = new ArrayList<>();
                try { 
                    cart = cartDAO.getCartItemsByCustomer(customer.getCustomerID() + "");
                    System.out.println("cart size : " + cart.size());
                } catch (SQLException ex) {
                    Logger.getLogger(addToCartController.class.getName()).log(Level.SEVERE, null, ex);
                }
                // Lưu danh sách CartItem vào session
                session.setAttribute("cart", cart);
                
                response.sendRedirect("productController");
            } else {
                response.sendRedirect("loginController");
            }

        } else {
            if (employee != null) {
                request.getSession().setAttribute("id", employee.getEmployeeID());
                request.getSession().setAttribute("type", employee.getJobTitle());
                request.getSession().setAttribute("type", "admin");
                
                if (employee.getEmail().equals(email) && employee.getPassword().equals(encryptedPassword)) {
                    response.sendRedirect("productController");
                } else {
                    response.sendRedirect("loginController");
                }
            } else {
                response.sendRedirect("loginController");
            }

        }

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
