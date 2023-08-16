/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.CategoryDAO;
import Entity.Category;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 5580
 */
public class CategoryController extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String Category = request.getParameter("category");
        CategoryDAO cd = new CategoryDAO();
//        ArrayList<ArrayList<Category>> clist = cd.getCategory();
        int pageNumber = 1;
        int shownumber = 9;
         try {
            pageNumber = Integer.parseInt(request.getParameter("page"));
//            System.out.println(pageNumber);
        } catch (Exception e){
        
        }
        try{
            shownumber = Integer.parseInt(request.getParameter("shownumber"));
//            System.out.println(shownumber);
        } catch (Exception e){
//            System.out.println("can not find number");
        }
        ArrayList<ArrayList<Category>> list = cd.getCategory();
        
        List<Category> clist = cd.getAllCategory();
        
        request.setAttribute("clist", clist);
        request.setAttribute("list", list);
        
        request.getRequestDispatcher("admin/categories.jsp").forward(request, response);
    }
    
}
