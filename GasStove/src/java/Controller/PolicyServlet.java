/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.CategoryDAO;
import DAO.ProductDAO;
import Entity.Category;
import Entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author asus
 */
@WebServlet(name = "PolicyServlet", urlPatterns = {"/policy/*"})
public class PolicyServlet extends HttpServlet {

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
            out.println("<title>Servlet PolicyServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PolicyServlet at " + request.getContextPath() + "</h1>");
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
        CategoryDAO cd = new CategoryDAO();
        ProductDAO pd= new ProductDAO();
         ArrayList<ArrayList<Category>> clist = cd.getCategory();
         List<Product> plist = null;
          String category = "";
        String subcategory = "";
        
        try {
            category = request.getParameter("category");
        } catch (Exception e){
        }
        
        try {
            subcategory = request.getParameter("subcategory");
        } catch (Exception e){
        }
        
        // Check if category is provided
        if (category != null && !category.isEmpty()) {
            // Check if subcategory is provided
            if (subcategory != null && !subcategory.isEmpty()) {
                // Apply both category and subcategory filters
                // Perform actions specific to the category and subcategory filters
                plist = pd.getProductsByCategoryName(Integer.parseInt(category));
            } else {
                // Apply category filter only
                // Perform actions specific to the category filter
                plist = pd.getProductsByCategoryID(Integer.parseInt(category));
//                System.out.println("category: " + category);
            }
        } else {
            System.out.println("cannot get");
            // No category provided, retrieve all products
            // Perform actions to retrieve all products
            // Example:
            // query = "SELECT * FROM products";
        }
        
        request.getSession().setAttribute("activepage", "home");
        ////////////////////////////////////////////
        
        
        request.setAttribute("clist", clist);
        
        
        
        String id = request.getPathInfo();
        System.out.println(id);
        String policy = "";
        if (id.equals("/Privacy")) {
            policy = "<h1 style=\"text-align:center\">Privacy Policy</h1></br>\n" +
"    <h3>CÔNG TY TNHH TRUYỀN THÔNG SỐ (Chủ quản website: LocalHost) luôn hiểu được tầm quan trọng của việc bảo mật\n" +
"        thông tin khách hàng, đó là một phần thể hiện sự quan tâm khách hàng và uy tín của Shop2banh.vn. Vì thông tin\n" +
"        khách hàng giúp LocalHost nâng cao dịch vụ chăm sóc khách hàng tốt hơn, chuyên nghiệp hơn, mang lại nhiều\n" +
"        niềm vui mua sắm tại LocalHost hơn nữa, đồng thời tiện lợi hơn, tiết kiệm thời gian hơn cho khách hàng.</h3>\n" +
"    <ul>\n" +
"        <li>\n" +
"            <h3>1. MỤC ĐÍCH THU THẬP THÔNG TIN:</h3>\n" +
"        </li>\n" +
"        <li>\n" +
"            <p>1.1 Chúng tôi thu thập Thông tin của Khách hàng chủ yếu phục vụ cho mục đích hỗ trợ, duy trì mối liên hệ\n" +
"                với Khách hàng như: 1.2 Chúng tôi thu thập Thông tin để phục vụ cho các mục đích kiểm soát, nâng cao\n" +
"                chất lượng Dịch vụ như: </p>\n" +
"            <ul>\n" +
"                <li>Thông báo đến Khách hàng các Thông tin khuyến mại, quảng cáo hoặc cho các mục đích tiếp thị trực\n" +
"                    tiếp, xúc tiến thương mại khác;</li>\n" +
"                <li>Thông báo đến Khách hàng các Thông tin khuyến mại, quảng cáo hoặc cho các mục đích tiếp thị trực\n" +
"                    tiếp, xúc tiến thương mại khác;</li>\n" +
"                <li>Hỗ trợ khi Khách hàng mua sản phẩm và/hoặc sử dụng Dịch vụ của Chúng tôi.</li>\n" +
"                <li>Kiểm soát người truy cập, sử dụng Dịch vụ của Chúng tôi;</li>\n" +
"                <li>Phân tích và tối ưu hóa các Dịch vụ của Chúng tôi;</li>\n" +
"                <li>Nâng cao chất lượng Dịch vụ của Chúng tôi và Chúng tôi cũng có thể thu thập Thông tin để phục vụ các\n" +
"                    mục đích khác không trái với quy định pháp luật.</li>\n" +
"            </ul>\n" +
"        </li>\n" +
"        <li>\n" +
"            <h3>2. PHẠM VI THU THẬP THÔNG TIN:</h3>\n" +
"        </li>\n" +
"        <li>2.1 Thông tin của Khách hàng mà Chúng tôi sẽ thu thập bao gồm: 2.2 Cho từng Dịch vụ, mục đích thu thập\n" +
"            cụ\n" +
"            thể khác, tùy từng thời điểm Chúng tôi có thể yêu cầu Khách hàng cung cấp thêm một số Thông tin nhằm đảm\n" +
"            bảo\n" +
"            việc sử dụng Dịch vụ của chính Khách hàng hoặc đảm bảo sự liên hệ, giao dịch giữa Chúng tôi và Khách\n" +
"            hàng\n" +
"            được thông suốt, thuận tiện ví dụ như: loại xe Khách hàng sở hữu; số km đã đi và/hoặc các Thông tin cần\n" +
"            thiết khác.</li>\n" +
"        <li>\n" +
"            <p>2.3 Đối với phạm vi thu thập Thông tin đề cập tại Chính sách này, Chúng tôi sẽ luôn tạo điều kiện\n" +
"                bằng\n" +
"                cách thiết lập những tính năng trên giao diện Website để Khách hàng tùy chọn để quyết định việc cung\n" +
"                cấp\n" +
"                hoặc từ chối cung cấp Thông tin cho Chúng tôi.</p>\n" +
"            <ul>\n" +
"                <li>Họ tên;</li>\n" +
"                <li>Số điện thoại;</li>\n" +
"                <li>Email;</li>\n" +
"                <li>Địa chỉ;</li>\n" +
"            </ul>\n" +
"        </li>\n" +
"        <li>\n" +
"            <h3>3. PHƯƠNG THỨC THU THẬP THÔNG TIN:</h3>\n" +
"        </li>\n" +
"        <p>Nhằm đảm bảo Thông tin được thu thập là đầy đủ, chính xác, tùy trường hợp Chúng tôi có thể lựa chọn sử dụng\n" +
"            đơn lẻ hoặc tổng hợp các phương thức thu thập Thông tin của Khách hàng như sau:</p>\n" +
"        <li>\n" +
"            <p>3.1 Đề nghị Khách hàng cung cấp Thông tin: 3.2 Chúng tôi tự thu thập Thông tin: 3.3 Hợp nhất Thông tin:\n" +
"            </p>\n" +
"            <ul>\n" +
"                <li>Một số Dịch vụ của Chúng tôi cho phép/đề nghị Khách hàng tạo tài khoản hoặc hồ sơ cá nhân và để sử\n" +
"                    dụng một cách tốt nhất các Dịch vụ này, Chúng tôi có thể yêu cầu Khách hàng cung cấp các Thông tin\n" +
"                    đề cập tại Mục 2 nêu trên để đáp ứng nhu cầu sử dụng Dịch vụ của Khách hàng.</li>\n" +
"                <li>Trường hợp Khách hàng yêu cầu Chúng tôi giải đáp các thắc mắc liên quan đến Dịch vụ/Sản phẩm của\n" +
"                    Chúng tôi hoặc Khách hàng yêu cầu Chúng tôi cung cấp Dịch vụ ví dụ: đặt hàng mua trực tuyến, yêu cầu\n" +
"                    hỗ trợ thông tin giao hàng... thì Chúng tôi có thể yêu cầu Khách hàng cung cấp Thông tin để xử lý\n" +
"                    các yêu cầu của Khách hàng một cách nhanh chóng, chính xác;</li>\n" +
"                <li>Các trường hợp yêu cầu thu thập Thông tin khác tùy theo nhu cầu thu thập của Chúng tôi.</li>\n" +
"                <li>Chúng tôi sẽ luôn đưa ra tùy chọn về việc quyết định cung cấp hay không cung cấp Thông tin đối với\n" +
"                    Khách hàng. Trường hợp Khách hàng lựa chọn không cung cấp Thông tin có thể sẽ có một số Dịch vụ,\n" +
"                    giao dịch không thể thực hiện được hoặc một số giao dịch Khách hàng sẽ được truy cập, thực hiện dưới\n" +
"                    chế độ ẩn danh (Guest).</li>\n" +
"                <li>Thu thập Thông tin từ các nguồn của bên thứ ba: Chúng tôi có thể nhận Thông tin về Khách hàng đã\n" +
"                    công bố công khai trên các website thương mại điện tử của bất kỳ bên thứ ba nào hoặc nhận Thông tin\n" +
"                    của Khách hàng từ bên thứ ba khi Chúng tôi tham gia vào các giao dịch có sự chuyển giao Thông tin\n" +
"                    đó.</li>\n" +
"                <li>Thu thập trong quá trình thực hiện Dịch vụ: Trong quá trình thực hiện Dịch vụ, Chúng tôi cũng có thể\n" +
"                    thu thập các Thông tin của Khách hàng bằng các cách thức phù hợp khác với sự đồng ý của Khách hàng\n" +
"                    với cách thức thu thập đó.</li>\n" +
"                <li>Thu thập trong quá trình Khách hàng sử dụng Dịch vụ: Một số Dịch vụ của Chúng tôi cho phép Khách\n" +
"                    hàng liên lạc với bên thứ ba, những lần liên lạc đó sẽ được truyền qua và những Thông tin phát sinh\n" +
"                    trong quá trình liên lạc đó có thể được lưu trữ trên hệ thống của Chúng tôi.</li>\n" +
"                <li>Chúng tôi có thể hợp nhất Thông tin Khách hàng mà Chúng tôi có được từ việc thu thập bằng nhiều\n" +
"                    phương thức khác nhau đề cập tại Mục này như một thao tác hoàn thiện Thông tin để phục vụ cho các\n" +
"                    mục đích được đề cập tại Chính sách này mà không cần sự đồng ý trước của Khách hàng. Tuy nhiên Khách\n" +
"                    hàng luôn có quyền lựa chọn điều chỉnh Thông tin của mình theo quy định tại Mục 9.1 Chính sách này.\n" +
"                </li>\n" +
"            </ul>\n" +
"        </li>\n" +
"        <li>\n" +
"            <h3>4. PHẠM VI SỬ DỤNG THÔNG TIN:</h3>\n" +
"        </li>\n" +
"        <li>\n" +
"            <p>Chúng tôi sử dụng các Thông tin của Khách hàng thu thập được để: </p>\n" +
"            <ul>\n" +
"                <li>Thực hiện các biện pháp để hoàn thiện Dịch vụ của Chúng tôi;</li>\n" +
"                <li>Thiết lập các chương trình hỗ trợ khách hàng thân thiết hoặc các chương trình xúc tiến thương mại\n" +
"                    khác;</li>\n" +
"                <li>Xử lý các vấn đề liên quan đến việc sử dụng Dịch vụ của Khách hàng hoặc giao dịch giữa Chúng tôi và\n" +
"                    Khách hàng;</li>\n" +
"                <li>Gửi thư ngỏ, đơn đặt hàng, thư cảm ơn;</li>\n" +
"                <li>Gửi các Thông tin khuyến mãi hoặc các Thông tin khác cho Khách hàng khi có sự đồng ý trước của Khách\n" +
"                    hàng.</li>\n" +
"                <li>Thông báo về các thông tin tuyển dụng của Chúng tôi nếu Khách hàng đăng kí nhận email thông báo.\n" +
"                </li>\n" +
"                <li>Đánh giá và phân tích thị trường, khách hàng, Dịch vụ của Chúng tôi</li>\n" +
"                <li>Các nội dung khác mà Chúng tôi được phép sử dụng Thông tin không trái với quy định của pháp luật.\n" +
"                </li>\n" +
"            </ul>\n" +
"            \n" +
"        </li>\n" +
"        <li>\n" +
"            <h3>5. ĐỐI TƯỢNG TIẾP CẬN THÔNG TIN:</h3>\n" +
"        </li>\n" +
"        <li>\n" +
"        <p>5.1 Để thực hiện mục đích thu thập Thông tin đề cập tại Chính sách này Chúng tôi có thể cần sự hỗ trợ từ bên thứ ba để phân tích dữ liệu, tiếp thị và hỗ trợ dịch vụ khách hàng và/hoặc cung cấp Dịch vụ tốt hơn cho Khách hàng. Trong quá trình hỗ trợ, Thông tin của Khách hàng có thể được Chúng tôi tiết lộ cho các đối tượng được đề cập dưới đây:</p>\n" +
"        <p>5.2 Chúng tôi sẽ phải tiết lộ Thông tin của Khách hàng cho Bên thứ ba hoặc cho cơ quan có thẩm quyền khi được cơ quan có thẩm quyền yêu cầu hoặc các trường hợp khác theo quy định của pháp luật hoặc Chúng tôi có cơ sở để tin rằng việc tiết lộ Thông tin có thể bảo vệ quyền, tài sản hoặc an toàn của chính Khách hàng hoặc của Chúng tôi</p>\n" +
"        <p>5.3 Các bên khác khi có sự đồng ý hoặc theo hướng dẫn của Khách hàng.</p>\n" +
"        <ul>\n" +
"            <li>Đơn vị trực thuộc của Chúng tôi khi sự tham gia của Đơn vị trực thuộc là cần thiết để thực hiện/hoàn thiện giao dịch đã thiết lập giữa Chúng tôi với Khách hàng.</li>\n" +
"            <li>Đối tác kinh doanh mà Chúng tôi tin tưởng, việc tiết lộ và trách nhiệm bảo mật Thông tin của Khách hàng sẽ được thực hiện theo thỏa thuận giữa Chúng tôi và đối tác kinh doanh của Chúng tôi.</li>\n" +
"            \n" +
"        </ul>\n" +
"    </li>\n" +
"    <li>\n" +
"        <h3>6. THỜI GIAN LƯU TRỮ THÔNG TIN:</h3>\n" +
"    </li>\n" +
"    <li>\n" +
"        <p>Chúng tôi chỉ lưu giữ Thông tin về Khách hàng trong thời gian cần thiết cho mục đích mà Thông tin được thu thập hoặc theo yêu cầu của Hợp đồng hoặc theo quy định của pháp luật hiện hành.</p>\n" +
"    </li>\n" +
"\n" +
"    <li>\n" +
"        <h3>7. CÁC LIÊN KẾT VÀ SẢN PHẨM CỦA BÊN THỨ BA TRÊN WEBSITE:</h3>\n" +
"    </li>\n" +
"    <li>\n" +
"        <p>Một số nội dung, quảng cáo và tính năng trên trang web của Chúng tôi có thể được cung cấp bởi các bên thứ ba có hoặc không liên kết với Chúng tôi. Các bên thứ ba này có thể thu thập hoặc nhận Thông tin nhất định về việc Khách hàng sử dụng Dịch vụ, kể cả thông qua việc sử dụng Cookie…, và các công nghệ tương tự và Thông tin này có thể được thu thập theo thời gian, đồng thời được kết hợp với Thông tin được thu thập trên các Website và dịch vụ trực tuyến khác nhau.</p>\n" +
"        <p>Nếu Khách hàng kết nối với dịch vụ mạng xã hội, Chúng tôi có thể nhận và lưu trữ Thông tin xác thực từ dịch vụ đó để cho phép Khách hàng đăng nhập, cũng như Thông tin khác mà Khách hàng cho phép Chúng tôi nhận khi Khách hàng kết nối với các dịch vụ đó.</p>\n" +
"        <p>Bằng cách truy cập và/hoặc sử dụng Dịch vụ của Chúng tôi, Khách hàng đồng ý lưu trữ Cookie..., các công nghệ lưu trữ cục bộ khác. Khách hàng cũng đồng ý quyền truy cập Cooki..., công nghệ lưu trữ cục bộ của Chúng tôi và các bên thứ ba được đề cập ở trên.</p>\n" +
"        <p>Như đã nêu trên, Dịch vụ của Chúng tôi có thể có các liên kết đến các website của Bên thứ ba khác không thuộc quyền kiểm soát của Chúng tôi, do đó Chúng tôi sẽ không chịu trách nhiệm về sự an toàn hoặc bảo mật của bất kỳ Thông tin nào được thu thập bởi các Bên thứ ba đó, không được thực hiện trên giao diện website hoặc Chúng tôi có quyền quản lý và/hoặc kiểm soát. Chúng tôi khuyên Khách hàng nên thận trọng và xem xét các quyết định về bảo mật Thông tin áp dụng cho các Website và dịch vụ của Bên thứ ba mà Khách hàng sử dụng.</p>\n" +
"    </li>\n" +
"    <li>\n" +
"        <h3>8. CAM KẾT BẢO MẬT THÔNG TIN:</h3>\n" +
"    </li>\n" +
"    <li>\n" +
"    <p>Chúng tôi cam kết bảo mật Thông tin của Khách hàng theo đúng các nội dung được quy định tại Chính sách này và quy định của pháp luật.</p>\n" +
"    <p>Chúng tôi sẽ áp dụng phương án và giải pháp thích hợp về kỹ thuật và an ninh để bảo vệ hiệu quả nhất Thông tin của Khách hàng. Tuy nhiên, lưu ý rằng mặc dù Chúng tôi thực hiện các phương thức hợp lý để bảo vệ Thông tin của Khách hàng, nhưng không có trang web, đường truyền Internet, hệ thống máy vi tính hay kết nối không dây nào là an toàn tuyệt đối. Do vậy, Chúng tôi không thể đưa ra một cam kết chắc chắn rằng thông tin Khách hàng cung cấp cho Chúng tôi sẽ được bảo mật một cách tuyệt đối an toàn, và Chúng tôi không thể chịu trách nhiệm trong trường hợp có sự truy cập trái phép, rò rỉ Thông tin của Khách hàng mà không do lỗi của Chúng tôi. Nếu Khách hàng không đồng ý với các điều khoản như đã mô tả ở trên, Chúng tôi khuyến nghị Khách hàng không nên gửi Thông tin đến cho Chúng tôi</p>\n" +
"    </li>\n" +
"\n" +
"            \n" +
"\n" +
"    </ul>" 
;
        }
        if (id.equals("/Shipping")) {
            policy = "Shipping Policy: The website should have a shipping policy that outlines estimated delivery times, shipping rates, and any applicable restrictions or fees. Customers should also be informed of any delays or issues with their order.";
        }
        if (id.equals("/Return")) {
            policy = "The website should have a clear and concise return policy that outlines how customers can initiate a return, what products are eligible for returns, and any conditions or restrictions that may apply. This policy should also include details on refunds, exchanges, and restocking fees.";
        }
        if (id.equals("/Security")) {
            policy = "Security Policy: The website should have a security policy that outlines the measures taken to protect customer data and prevent unauthorized access. This policy should include details on data encryption, firewalls, and other security measures.";
        }
        if (id.equals("/Customer")) {
            policy = "Customer Service Policy: The website should have a customer service policy that outlines how customer inquiries and issues will be handled. This policy should include information on response times, escalation procedures, and how to contact customer support.";
        }
        if (id.equals("/Affiliate")) {
            policy = "Affiliate Policy: If the website has an affiliate program, there should be a policy that outlines the terms and conditions of the program, including commission rates, payment schedules, and any restrictions or requirements for participating.";
        }
        if (id.equals("/SocialMedia")) {
            policy = "Social Media Policy: If the website has social media channels, there should be a policy that outlines the acceptable use of these channels, any prohibited activities, and the consequences of violating the policy. This policy should also include information on how customer inquiries and complaints will be handled through social media channels.";
        }
        request.setAttribute("policy", policy);
        request.getRequestDispatcher("/client/policy.jsp").forward(request, response);
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
        processRequest(request, response);
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
