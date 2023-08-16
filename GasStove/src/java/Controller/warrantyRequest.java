/*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.CustomerDAO;
import DAO.DeliveryDAO;
import DAO.WarrantyDAO;
import Entity.Customer;
import Entity.Order;
import Entity.OrderDetail;
import Entity.Status;
import Entity.Warranty;
import Entity.WarrantyPolicy;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class warrantyRequest extends HttpServlet {

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
        String type = (String) session.getAttribute("type");
        if (type == null) {
            response.sendRedirect("loginController");
        } else {
            CustomerDAO cd = new CustomerDAO();
            ArrayList<Customer> Customer = cd.getAllCustomer();
            request.setAttribute("Customer", Customer);
            request.getRequestDispatcher("client/warrantyRequest.jsp").forward(request, response);
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
        HttpSession session = request.getSession();
        Integer id = (Integer) session.getAttribute("id");
        if (id == null) {
            // User is not logged in, redirect to the login page
            response.sendRedirect("loginController");
        } else {
            int customerID = id.intValue(); // Convert Integer to int
            CustomerDAO cd = new CustomerDAO();
            Customer customer = cd.findCustomer(customerID);
            request.setAttribute("customer", customer);

            request.getSession().setAttribute("activepage", "warranty");

            WarrantyDAO wd = new WarrantyDAO();
            ArrayList<String> serialNumbers = wd.getSerialNumbersByCustomerID(customerID);
            request.setAttribute("serialNumbers", serialNumbers);
            request.getRequestDispatcher("client/warrantyRequest.jsp").forward(request, response);
        }
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
        // lay thong tin nguoi dung tu session
        HttpSession session = request.getSession();
        int customerID = (int) session.getAttribute("id");

        // Lấy thông tin từ request
        String SerialNumber = request.getParameter("serialNumber");
        String TicketNumber = request.getParameter("TicketNumber");
        System.out.println("Ticketnumber : " + TicketNumber);
        String description = request.getParameter("description");
        String email = request.getParameter("Email");
        String Name = request.getParameter("name");
        int status = Integer.parseInt(request.getParameter("status"));

//        Date startDate = Date.valueOf(request.getParameter("startDate"));

//        Date endDate = Date.valueOf(request.getParameter("endDate"));

        // Lưu đối tượng Warranty vào cơ sở dữ liệu
        WarrantyDAO warrantyDAO = new WarrantyDAO();
        int success = warrantyDAO.updateWarrantyy(SerialNumber, TicketNumber, description, status, customerID);
        response.sendRedirect("warrantyRequest");
        // send mail to user    

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
