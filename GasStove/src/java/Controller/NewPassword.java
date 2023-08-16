package Controller;

import DAO.CustomerDAO;
import Entity.Customer;
import Entity.Status;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/**
 * Servlet implementation class NewPassword
 */
@WebServlet("/newPassword")
public class NewPassword extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String newPassword = request.getParameter("password");
        String confPassword = request.getParameter("confPassword");
         String encryptedPassword = encryptPassword(confPassword);
        
        
        String Email = (String) request.getSession().getAttribute("email");
        CustomerDAO db = new CustomerDAO();
        Customer customer = db.findCustomer(Email);
//        if (newPassword != null && confPassword != null && newPassword.equals(confPassword)) {

//            try {
//                Class.forName("com.mysql.jdbc.Driver");
//                Connection con = DriverManager.getConnection("jdbc:sqlserver://DTRUNG03\\SQLEXPRESS:1433;databaseName=SaleGasStovesOnline", "root",
//                        "root");
//                PreparedStatement pst = con.prepareStatement("UPDATE [dbo].[Customers]\n"
//                        + "   SET [password] = ?\n"
//                        + "WHERE [Customers].Email =?");
//                pst.setString(1, confPassword);
//                pst.setString(2, (String) session.getAttribute("email"));
//
//                int rowCount = pst.executeUpdate();
//                if (rowCount > 0) {
//                    request.setAttribute("status", "resetSuccess");
//                    dispatcher = request.getRequestDispatcher("authentication-login.jsp");
//                } else {
//                    request.setAttribute("status", "resetFailed");
//                    dispatcher = request.getRequestDispatcher("authentication-login.jsp");
//                }
//                dispatcher.forward(request, response);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
        
         if (!newPassword.equals(confPassword)) {
            request.setAttribute("mess", new Status(400, "Confirm password does not match the new password."));
            request.getRequestDispatcher("newPassword.jsp").forward(request, response);
            return;
        }
        System.out.println("3");
        int statusChangePass = db.updateCustomer(encryptedPassword, Email);
        request.setAttribute("mess", new Status(200, "Change password successfull."));
        request.getRequestDispatcher("authentication-login.jsp").forward(request, response);
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

}
