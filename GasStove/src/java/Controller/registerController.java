/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.CustomerDAO;
import Entity.Customer;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.*;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.util.Properties;
import java.util.Random;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import javax.mail.Session;
import javax.mail.Transport;

/**
 *
 * @author DUC ANH
 */
public class registerController extends HttpServlet {

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
            out.println("<title>Servlet registerController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet registerController at " + request.getContextPath() + "</h1>");
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
//        processRequest(request, response);
        request.getRequestDispatcher("client/SignUp.jsp").forward(request, response);
//        response.sendRedirect("client/SignUp.jsp");
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
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();

        //get Information
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String encryptedPassword = encryptPassword(password);
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");
        String city = request.getParameter("city");
        String district = request.getParameter("district");
        String addressDetail = request.getParameter("addressDetail");
        Customer customer = new Customer();
        CustomerDAO customerDAO = new CustomerDAO();
        List<String> usernameList = customerDAO.getUsernameList();
        List<String> emailList = customerDAO.getUserEmailList();

        if (isEmailExists(email, emailList) == true) {
            request.setAttribute("usernameValue", username);
            request.setAttribute("firstNameValue", firstName);
            request.setAttribute("lastNameValue", lastName);
            request.setAttribute("emailValue", email);
            request.setAttribute("phoneNumberValue", phoneNumber);
            request.setAttribute("cityValue", city);
            request.setAttribute("districtValue", district);
            request.setAttribute("addressDetailValue", addressDetail);
            request.setAttribute("passwordValue", password);
            session.setAttribute("emailError", "Email " + email + " đã tồn tại. Vui lòng chọn email khác");
            //response.sendRedirect("SignUp.jsp");
            request.getRequestDispatcher("client/SignUp.jsp").forward(request, response);
        } else {
            if (isUsernameExists(username, usernameList) == true) {
                request.setAttribute("usernameValue", username);
                request.setAttribute("firstNameValue", firstName);
                request.setAttribute("lastNameValue", lastName);
                request.setAttribute("emailValue", email);
                request.setAttribute("phoneNumberValue", phoneNumber);
                request.setAttribute("cityValue", city);
                request.setAttribute("districtValue", district);
                request.setAttribute("addressDetailValue", addressDetail);
                request.setAttribute("passwordValue", password);
                session.setAttribute("usernameError", "Tên đăng nhập " + username + " đã tồn tại. Vui lòng chọn tên đăng nhập khác");
                request.getRequestDispatcher("client/SignUp.jsp").forward(request, response);
            } else {
                session.setAttribute("usernameError", null);
                session.setAttribute("emailError", null);
                customer.setUsername(username);
                customer.setPassword(encryptedPassword);
                customer.setLastName(lastName);
                customer.setFirstName(firstName);
                customer.setEmail(email);
                customer.setPhoneNumber(phoneNumber);
                customer.setCity(city);
                customer.setDistrict(district);
                customer.setAddressDetail(addressDetail);
                CustomerDAO customerDao = new CustomerDAO();
                customerDao.insertCustomer(customer);

                if (email != null || !email.equals("")) {

                    String to = email;// change accordingly
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
                        message.setFrom(new InternetAddress(email));// change accordingly
                        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
                        String subject = "Hello" + lastName + " " + firstName;
                        message.setSubject(MimeUtility.encodeText(subject, "UTF-8", "B"));
                        String content = "Welcome to join into Sale Gas Stoves Online System";
                        message.setContent(content, "text/plain; charset=UTF-8");
                        message.setSubject(MimeUtility.encodeText(subject, "UTF-8", "B"));
                        // send message
                        Transport.send(message);
                        System.out.println("message sent successfully");
                    } catch (MessagingException e) {
                        throw new RuntimeException(e);
                    }
                    //out.print(customer.getLastName() + customer.getFirstName() + customer.getEmail() + customer.getUsername() + customer.getPassword() + customer.getCity() + customer.getDistrict() + customer.getPhoneNumber() + customer.getAddressDetail());
                    session.setAttribute("msg", "Đăng kí thành công!");
//                    response.sendRedirect("client/SignUp.jsp");
                    request.getRequestDispatcher("client/SignUp.jsp").forward(request, response);
                }
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

    public boolean isEmailExists(String email, List<String> list) {
        if (list != null) {
            for (String o : list) {
                if (email.equalsIgnoreCase(o)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public boolean isUsernameExists(String username, List<String> list) {
        if (list != null) {
            for (String o : list) {
                if (username.trim().equalsIgnoreCase(o)) {
                    return true;
                }
            }
            return false;
        }
        return false;
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
