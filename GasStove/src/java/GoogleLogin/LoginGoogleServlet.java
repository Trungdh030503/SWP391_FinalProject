package GoogleLogin;

import Controller.addToCartController;
import DAO.CartDAO;
import DAO.CustomerDAO;
import DAO.EmployeeDAO;
import Entity.CartItem;
import Entity.Customer;
import Entity.Employee;
import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import GoogleLogin.GooglePojo;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
//import GoogleLogin.GoogleUtils;

@WebServlet("/login-google")
//LoginGoogleServlet.java sẽ nhận đoạn mã trả về từ google,
//đổi mã đó thành access-token rồi dùng access-token để truy cập các thông tin trong tài khoản google như email, name, id…

public class LoginGoogleServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public LoginGoogleServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String code = request.getParameter("code");
        if (code == null || code.isEmpty()) {
            RequestDispatcher dis = request.getRequestDispatcher("authentication-login.jsp");
            dis.forward(request, response);
        } else {
            String accessToken = GoogleUtils.getToken(code);
            GooglePojo googlePojo = GoogleUtils.getUserInfo(accessToken);
//      request.setAttribute("id", googlePojo.getId());
//      request.setAttribute("name", googlePojo.getName());
//      request.setAttribute("email", googlePojo.getEmail());

            EmployeeDAO ed = new EmployeeDAO();
            List<Employee> employee = ed.getAllEmployee();

            for (Employee e : employee) {
                System.out.println(e.getEmail());
                if (e.getEmail().equals(googlePojo.getEmail())) {
                    request.getSession().setAttribute("type", e.getJobTitle());
                    request.getSession().setAttribute("type", "admin");
                    request.getSession().setAttribute("id", e.getEmployeeID());
                    response.sendRedirect("admin/dashboard.jsp");

                    return;
                }
            }

            CustomerDAO cd = new CustomerDAO();
            List<Customer> customers = cd.getAllCustomer();
            for (Customer c : customers) {
                if (c.getEmail().equals(googlePojo.getEmail())) {
                    // Sau khi xác thực thành công, lưu customerID vào session
//                    HttpSession session = request.getSession();
//                    session.setAttribute("customerID", customerID); // Thay customerID bằng giá trị tương ứng

                    request.getSession().setAttribute("type", "Customer");
                    request.getSession().setAttribute("id", c.getCustomerID());
                    request.getSession().setAttribute("email", c.getEmail());
                    CartDAO cartDAO = new CartDAO();
                    HttpSession session = request.getSession(true);
                    List<CartItem> cart = new ArrayList<>();
                    try {
                        cart = cartDAO.getCartItemsByCustomer(c.getCustomerID() + "");
                        System.out.println("cart size : " + cart.size());
                    } catch (SQLException ex) {
                        Logger.getLogger(addToCartController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    // Lưu danh sách CartItem vào session
                    session.setAttribute("cart", cart);
                    response.sendRedirect("productController");
                    return;
                }
            }
//            cd.insertAccountWithGmail(googlePojo.getGiven_name(), googlePojo.getFamily_name(), googlePojo.getEmail());
//            Customer c = cd.findCustomer(googlePojo.getEmail());
//            request.getSession().setAttribute("id", c.getCustomerID());
//            response.sendRedirect("productController");

            cd.insertAccountWithGmail(googlePojo.getGiven_name(), googlePojo.getFamily_name(), googlePojo.getEmail());
            Customer c = cd.findCustomer(googlePojo.getEmail());
//            if (c != null) {
//                
//                response.sendRedirect("productController");
//                
//            } else {
            // Handle error when cannot find inserted customer in database
            request.getSession().setAttribute("email", googlePojo.getEmail());
            response.sendRedirect("homeController");
//            }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
