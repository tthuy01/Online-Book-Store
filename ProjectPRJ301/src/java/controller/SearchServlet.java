/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.NXBDAO;
import dal.SachDAO;
import dal.TheLoaiDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.NXB;
import model.Sach;
import model.TheLoai;

/**
 *
 * @author May Tinh Ha Anh
 */
public class SearchServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SearchServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SearchServlet at " + request.getContextPath() + "</h1>");
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
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String key = request.getParameter("key");
        if(key == null)
        {
            key = "";//Tim tat ca
        }
        SachDAO sdao = new SachDAO();
        List<Sach> list = sdao.searchByTacGia(key);
        int page, numPerPage = 8; //numPerPage: So sach trong 1 trang
        int size = list.size(); //size: so sach trong list
        int num = size % 8 == 0 ? size / 8 : ((size / 8) + 1); //num: so trang
        String xpage = request.getParameter("page");
        if (xpage == null) {
            page = 1;
        } else {
            try {
                page = Integer.parseInt(xpage);
            } catch (NumberFormatException e) {
                page = 1;
            }
        }
        int start, end;
        start = (page - 1) * numPerPage; //Lay ra phan tu dau tien cua trang
        end = Math.min(page * numPerPage, size); //Lay phan tu cuoi cung cua trang
        List<Sach> list1 = sdao.getListByPage(list, start, end);

        TheLoaiDAO tldao = new TheLoaiDAO();
        List<TheLoai> list2 = tldao.getAllTheLoai();
        request.setAttribute("alltheloai", list2);

        request.setAttribute("allbook", list1);
        request.setAttribute("page", page); //De danh dau trang nao
        request.setAttribute("num", num); //De hien thi so trang
        request.setAttribute("key", key);
        request.setAttribute("action", "3");
        
        NXBDAO n = new NXBDAO();
        List<NXB> listnxb = n.getAllNXB();
        request.setAttribute("allnxb", listnxb);
        
        request.getRequestDispatcher("allbook.jsp").forward(request, response);
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
