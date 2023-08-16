/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.EmployeeDAO;
import DAO.WarrantyDAO;
import Entity.Employee;
import Entity.Warranty;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Properties;
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
public class editStatus extends HttpServlet {

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
            out.println("<title>Servlet editStatus</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet editStatus at " + request.getContextPath() + "</h1>");
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
//        int wid = Integer.parseInt(request.getParameter("WarrantyID").trim());
//        int pid = Integer.parseInt(request.getParameter("productID").trim());
//        int oid = Integer.parseInt(request.getParameter("orderID"));
        String SerialNumber = request.getParameter("SerialNumber");
//        Date StartDate = Date.valueOf(request.getParameter("StartDate"));
//        Date EndDate = Date.valueOf(request.getParameter("EndDate"));
        WarrantyDAO wd = new WarrantyDAO();
        Warranty warranty = wd.getWarrantyBySerialNumber(SerialNumber);
        System.out.println("SerialNumber: " + SerialNumber);
        System.out.println("status" + warranty.getStatus());
        request.setAttribute("warranty", warranty);
        ArrayList<Warranty> warrantyy = wd.getAllWarranty();
        request.setAttribute("warrantyy", warrantyy);
        HttpSession session = request.getSession();
//        session.setAttribute("id", wid);
        EmployeeDAO ed = new EmployeeDAO();
        ArrayList<Employee> employee = ed.getEmployeeUnassigned();
        request.setAttribute("employee", employee);
        request.getRequestDispatcher("admin/editStatus.jsp").forward(request, response);

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
//        processRequest(request, response);
        int WarrantyID = Integer.parseInt(request.getParameter("WarrantyID"));
        Date StartDate = Date.valueOf(request.getParameter("StartDate"));
        Date EndDate = Date.valueOf(request.getParameter("EndDate"));
        int Status = Integer.parseInt(request.getParameter("Status"));
        int productID = Integer.parseInt(request.getParameter("ProductID"));
        int orderID = Integer.parseInt(request.getParameter("OrderID"));
        int employeeID = Integer.parseInt(request.getParameter("employeeID"));
//        int WarrantyID = Integer.parseInt(request.getParameter("WarrantyID"));
         String CustomerEmail = request.getParameter("CustomerEmail");
         String SerialNumber = request.getParameter("SerialNumber");
         String TicketNumber = request.getParameter("TicketNumber");
         String Description = request.getParameter("Description");
         String name = request.getParameter("name");
        WarrantyDAO wd = new WarrantyDAO();

//        Warranty warranty = (Warranty) wd.getAllWarrantyByID(WarrantyID);
//        int result = wd.updateWarranty(WarrantyID, StartDate, EndDate, Status, orderID, productID);
        int result = wd.updateWarrantyyy(WarrantyID, StartDate, EndDate, Status, employeeID, orderID, productID);
        ArrayList<Warranty> warranty = wd.getAllWarranty();
        request.setAttribute("warranty", warranty);
        response.sendRedirect("adminWarranty");
        //send mail
        if(Status == 1){
            String to = CustomerEmail;
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
            message.setFrom(new InternetAddress(CustomerEmail));// change accordingly
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            
            String subject = "Hello " + CustomerEmail;
            message.setSubject(MimeUtility.encodeText(subject, "UTF-8", "B"));
            String content = "<div style='border: 1px solid black; padding: 10px;'>";
            content += "Thông tin khách hàng" + "<br><br>";
            content += "Tên khách hàng: " + name +  "<br><br>";
            content += "Ngày hẹn trả: " + "<br><br>";
//            content += "Dự kiến khoảng: " + endDate +"<br><br>";
            content += "Thank you for your warranty request. Here are the details of your request:<br><br>";
            content += "<table style='border-collapse: collapse;'>";
            content += "<tr><th>Serial Number</th><th>Ticket Number</th><th>Description</th><th>Start Date</th></tr>";
            content += "<tr>";
            content += "<td>" + SerialNumber + "</td>";
            content += "<td>" + TicketNumber + "</td>";
            content += "<td>" + Description + "</td>";
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            String formattedStartDate = dateFormat.format(StartDate);
            content += "<td>" + formattedStartDate + "</td>";
            content += "</tr>";
            content += "</table><br>";
            content += "We will process your request as soon as possible.<br>";
            content += "Thank you for choosing our warranty service!<br><br>";
            content += "Best regards,<br>";
            content += "Sale Gas Online";
            content += "</div>";
            message.setContent(content, "text/html; charset=UTF-8");
            message.setSubject(MimeUtility.encodeText(subject, "UTF-8", "B"));
            // send message
            Transport.send(message);
            System.out.println("message sent successfully");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        }

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
