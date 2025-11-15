package controller;

import dao.SanPhamDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.SanPham;

/**
 * 
 * @author ADMIN
 */
@WebServlet(name = "HomeServlet", urlPatterns = {"/trang-chu"})
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        // Lấy danh sách 6 sản phẩm khuyến mãi
        SanPhamDAO spDAO = new SanPhamDAO();
        ArrayList<SanPham> listSP = spDAO.getTop6Promotion();
        
        // Gửi dữ liệu lên JSP
        request.setAttribute("listSanPham", listSP);
        
        // Forward đến trang home.jsp
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }
}