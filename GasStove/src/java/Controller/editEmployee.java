/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import static Controller.changePassController.encryptPassword;
import DAO.EmployeeDAO;
import Entity.Employee;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Properties;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 10, // 10 MB
        maxRequestSize = 1024 * 1024 * 10 // 10 MB
)
public class editEmployee extends HttpServlet {

    private static final String SECRET_KEY = "YourSecretKey123";
    private static final String ENCRYPTION_ALGORITHM = "AES";

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
        int id = Integer.parseInt(request.getParameter("EmployeeID"));
        EmployeeDAO ed = new EmployeeDAO();
        Employee employee = ed.findEmployeeByID(id);
        request.setAttribute("employee", employee);
        HttpSession session = request.getSession();
        session.setAttribute("id", id);
        request.getRequestDispatcher("admin/editEmployee.jsp").forward(request, response);
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

        String jobTitle = request.getParameter("JobTitle");
        String email = request.getParameter("Email");
        String username = request.getParameter("Username");
        String password = request.getParameter("Password");
        String encryptedPassword = encryptPassword(password);
        double salary = Double.parseDouble(request.getParameter("Salary"));
        String address = request.getParameter("Address");
        String phoneNumber = request.getParameter("PhoneNumber");
        Part avatarPart = request.getPart("Avatar");
        String avatarFileName = extractFileName(avatarPart);

        if (avatarPart.getSize() > 0) {
            // Lưu file ảnh mới và lấy tên file mới
            avatarFileName = new File(avatarFileName).getName();
            avatarPart.write(getFolderUpload().getAbsolutePath() + File.separator + avatarFileName);
        } else {
            // Không có ảnh mới được chọn, giữ nguyên ảnh hiện tại
            int employeeID = Integer.parseInt(request.getParameter("EmployeeID"));
            EmployeeDAO employeeDAO = new EmployeeDAO();
            Employee employee = employeeDAO.findEmployeeByID(employeeID);
            avatarFileName = employee.getAvatarURL();
        }

        int employeeID = Integer.parseInt(request.getParameter("EmployeeID"));
        EmployeeDAO ed = new EmployeeDAO();
        int result = ed.updateEmployee(jobTitle, email, username, encryptedPassword, salary, address, phoneNumber, avatarFileName, employeeID);
        Employee employee = ed.findEmployeeByID(employeeID);
        request.setAttribute("user", employee);

        response.sendRedirect("listEmployee");

        // Send email to user
        String to = email;
        String from = "anhdd16.cdc@gmail.com";
        String passwordEmail = "sjiqjschwdmymdll";// Put your email id and password here
        
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");
                    Session session1 = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication("anhdd16.cdc@gmail.com", "sjiqjschwdmymdll");// Put your email
                            // id and
                            // password here
                        }
                    });
                    // compose message
                    try {
                        MimeMessage message = new MimeMessage(session1);
                        message.setFrom(new InternetAddress(email));// change accordingly
                        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
                        String subject = "Hello " + username;
                        message.setSubject(MimeUtility.encodeText(subject, "UTF-8", "B"));
                        String content = "Your PassWord for website SellGasStoveOnline is " + password;
                        message.setContent(content, "text/plain; charset=UTF-8");
                        message.setSubject(MimeUtility.encodeText(subject, "UTF-8", "B"));
                        // send message
                        Transport.send(message);
                        System.out.println("message sent successfully");
                    } catch (MessagingException e) {
                        throw new RuntimeException(e);
                    }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
     public File getFolderUpload() {
         
        File folderUpload = new File("E:\\SWP\\Project\\group_6\\GasStove\\web\\avatar");
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

//      private static final String SECRET_KEY = "YourSecretKey123";
//    private static final String ENCRYPTION_ALGORITHM = "AES";
//
//    public static String encryptPassword(String password) {
//        try {
//            SecretKeySpec secretKeySpec = new SecretKeySpec(SECRET_KEY.getBytes(), ENCRYPTION_ALGORITHM);
//            Cipher cipher = Cipher.getInstance(ENCRYPTION_ALGORITHM);
//            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
//            byte[] encryptedBytes = cipher.doFinal(password.getBytes());
//            return Base64.getEncoder().encodeToString(encryptedBytes);
//        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
