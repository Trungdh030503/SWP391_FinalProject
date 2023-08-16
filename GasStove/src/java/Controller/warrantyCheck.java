///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
// */
//package Controller;
//
//import DAO.CheckoutDAO;
//import DAO.CustomerDAO;
//import DAO.EmployeeDAO;
//import DAO.WarrantyDAO;
//import Entity.Customer;
//import Entity.Employee;
//import Entity.Order;
//import Entity.Status;
//import Entity.Warranty;
//import java.io.IOException;
//import java.io.PrintWriter;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// *
// * @author Lenovo
// */
//public class warrantyCheck extends HttpServlet {
//
//    /**
//     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
//     * methods.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        try ( PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet warrantyCheck</title>");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet warrantyCheck at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
//    }
//
//    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
//    /**
//     * Handles the HTTP <code>GET</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        HttpSession session = request.getSession();
//        String type = (String) session.getAttribute("type");
//        if (type == null) {
//            response.sendRedirect("loginController");
//        } else {
//            CustomerDAO cd= new CustomerDAO();
//            ArrayList<Customer> Customer= cd.getAllCustomer();
//            request.setAttribute("Customer", Customer);
//            request.getRequestDispatcher("client/warrantyCheck.jsp").forward(request, response);
//        }
//    }
//     
//    /**
//     * Handles the HTTP <code>POST</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        String search = request.getParameter("search");
//        if (search == null || search.isEmpty() || !search.matches("\\d+")) {
//            request.setAttribute("mess", new Status(200, "OrderID không hợp lệ"));
//            request.getRequestDispatcher("client/warrantyCheck.jsp").forward(request, response);
//            return;
//        } else {
//            int orderId = Integer.parseInt(search);
//            WarrantyDAO wd = new WarrantyDAO();
////            ArrayList<Warranty> listWarranty = (ArrayList<Warranty>) wd.getAllWarrantyByOrderID(orderId);
//            if (listWarranty.isEmpty()) {
//                request.setAttribute("mess", new Status(200, "Không tìm thấy thông tin bảo hành cho OrderID này"));
//                request.getRequestDispatcher("client/warrantyCheck.jsp").forward(request, response);
//                return;
//            } else {
//                request.setAttribute("listWarranty", listWarranty);
//                // Xóa thông báo trong session
//                request.removeAttribute("mess");
//                request.getRequestDispatcher("client/listWarranty.jsp").forward(request, response);
//            }
//        }
//    }
//
//    /**
//     * Returns a short description of the servlet.
//     *
//     * @return a String containing servlet description
//     */
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>
//
//}
