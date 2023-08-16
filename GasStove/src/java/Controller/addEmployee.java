/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import static Controller.changePassController.encryptPassword;
import DAO.EmployeeDAO;
import Entity.Status;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.File;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
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

/**
 *
 * @author Lenovo
 */
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 10, // 10 MB
        maxRequestSize = 1024 * 1024 * 10 // 10 MB
)
public class addEmployee extends HttpServlet {

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
            out.println("<title>Servlet addEmployee</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet addEmployee at " + request.getContextPath() + "</h1>");
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
        request.getRequestDispatcher("admin/addEmployee.jsp").forward(request, response);
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
        // Extract form data
        String FirstName = request.getParameter("FirstName");
        String LastName = request.getParameter("LastName");
//    int EmployeeID = Integer.parseInt(request.getParameter("EmployeeID"));
//    String id = request.getParameter("EmployeeID");
        String JobTitle = request.getParameter("JobTitle");
        String Username = request.getParameter("Username");
        String Email = request.getParameter("Email");
        String Password = request.getParameter("Password");
        String PhoneNumber = request.getParameter("PhoneNumber");
        String Address = request.getParameter("Address");
        Date HireDate = Date.valueOf(request.getParameter("HireDate"));
        Double Salary = Double.parseDouble(request.getParameter("Salary"));
        Part Avatar = request.getPart("Avatar");
        String Avatar1;
        String encryptedPassword = encryptPassword(Password);
         if (!extractFileName(Avatar).equals("")) {
            String fileName = extractFileName(Avatar);
            // refines the fileName in case it is an absolute path
            fileName = new File(fileName).getName();
            Avatar.write(this.getFolderUpload().getAbsolutePath() + File.separator + fileName);
            Avatar1 = fileName;
        } else {
            Avatar1 = null;
        }
        System.out.println(request.getParameter("EmployeeID"));

        EmployeeDAO ed = new EmployeeDAO();
        int createEmployee = ed.createEmployee(FirstName, LastName, Email, PhoneNumber, Address, HireDate, Salary, JobTitle, Username, encryptedPassword, Avatar1);

        System.out.println(createEmployee);
        if (createEmployee != 1) {
            request.setAttribute("mess", new Status(400, "Create employee not success"));
            return;
        } else {
            request.setAttribute("mess", new Status(200, "Create employee successfull."));
        }

        response.sendRedirect("listEmployee");

        String to = Email;// change accordingly
        // Get the session object
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
            message.setFrom(new InternetAddress(Email));// change accordingly
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            String subject = "Hello " + FirstName + " " + LastName;
            message.setSubject(MimeUtility.encodeText(subject, "UTF-8", "B"));
            String content = "Your PassWord for website SellGasStoveOnline is " + Password;
            message.setContent(content, "text/plain; charset=UTF-8");
            message.setSubject(MimeUtility.encodeText(subject, "UTF-8", "B"));
            // send message
            Transport.send(message);
            System.out.println("message sent successfully");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

//        request.getRequestDispatcher("client/changePass.jsp").forward(request, response);
//       
//request.getRequestDispatcher("listEmployee").forward(request, response);
    }

    public File getFolderUpload() {
        File folderUpload = new File("D:\\Semester5\\SWP\\Project\\group_6\\GasStove\\web\\avatar");
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
