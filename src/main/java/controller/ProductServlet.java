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
        
        String maLoaiParam = request.getParameter("maloai");
        int maLoai = 1; 
        
        if (maLoaiParam != null && !maLoaiParam.isEmpty()) {
            try {
                maLoai = Integer.parseInt(maLoaiParam);
            } catch (NumberFormatException e) {
                maLoai = 1;
            }
        }
        
        TheLoaiDAO tlDAO = new TheLoaiDAO();
        SanPhamDAO spDAO = new SanPhamDAO();
        
        TheLoai theLoai = tlDAO.findById(maLoai);
        String tenLoai = (theLoai != null) ? theLoai.getTenLoai() : "Tập luyện";
        
        ArrayList<SanPham> listSP = spDAO.getByCategory(maLoai);
        int soLuong = spDAO.countByCategory(maLoai);
        
        ArrayList<TheLoai> listTheLoai = tlDAO.getAll();
        
        request.setAttribute("listTheLoai", listTheLoai);
        request.setAttribute("listSanPham", listSP);
        request.setAttribute("tenLoai", tenLoai);
        request.setAttribute("soLuong", soLuong);
        request.setAttribute("maLoaiSelected", maLoai);
        
        request.getRequestDispatcher("product.jsp").forward(request, response);
    }
}