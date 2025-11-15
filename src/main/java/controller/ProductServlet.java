package controller;

import dao.SanPhamDAO;
import dao.TheLoaiDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.SanPham;
import model.TheLoai;

/**
 * Servlet xử lý trang sản phẩm
 * @author ADMIN
 */
@WebServlet(name = "ProductServlet", urlPatterns = {"/san-pham"})
public class ProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        // Lấy mã loại từ request parameter, mặc định là 1 (Tập luyện)
        String maLoaiParam = request.getParameter("maloai");
        int maLoai = 1; // Mặc định là "Tập luyện"
        
        if (maLoaiParam != null && !maLoaiParam.isEmpty()) {
            try {
                maLoai = Integer.parseInt(maLoaiParam);
            } catch (NumberFormatException e) {
                maLoai = 1; // Nếu parse lỗi thì dùng mặc định
            }
        }
        
        // Khởi tạo DAO
        TheLoaiDAO tlDAO = new TheLoaiDAO();
        SanPhamDAO spDAO = new SanPhamDAO();
        
        // Lấy thông tin thể loại
        TheLoai theLoai = tlDAO.findById(maLoai);
        String tenLoai = (theLoai != null) ? theLoai.getTenLoai() : "Tập luyện";
        
        // Lấy danh sách sản phẩm và số lượng
        ArrayList<SanPham> listSP = spDAO.getByCategory(maLoai);
        int soLuong = spDAO.countByCategory(maLoai);
        
        // Lấy tất cả thể loại để hiển thị menu
        ArrayList<TheLoai> listTheLoai = tlDAO.getAll();
        
        // Gửi dữ liệu lên JSP
        request.setAttribute("listTheLoai", listTheLoai);
        request.setAttribute("listSanPham", listSP);
        request.setAttribute("tenLoai", tenLoai);
        request.setAttribute("soLuong", soLuong);
        request.setAttribute("maLoaiSelected", maLoai);
        
        // Forward đến trang product.jsp
        request.getRequestDispatcher("product.jsp").forward(request, response);
    }
}