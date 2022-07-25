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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.GioHang;
import model.Item;
import model.NXB;
import model.Sach;
import model.TheLoai;

/**
 *
 * @author May Tinh Ha Anh
 */
public class AllBookServlet extends HttpServlet {

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
            out.println("<title>Servlet AllBookServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AllBookServlet at " + request.getContextPath() + "</h1>");
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
        SachDAO sdao = new SachDAO();
        String sort = request.getParameter("sort");
        List<Sach> list = sdao.getAll();
        if (sort != null) {
            if (sort.equals("asc")) {
                list = sdao.getListBookByPriceAsc();
            }
            if (sort.equals("desc")) {
                list = sdao.getListBookByPriceDesc();
            }
        }
//            List<Sach> list = sdao.getAll();
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

        NXBDAO ndao = new NXBDAO();
        List<NXB> list3 = ndao.getAllNXB();
        request.setAttribute("allnxb", list3);

        request.setAttribute("allbook", list1);
        request.setAttribute("page", page); //De danh dau trang nao
        request.setAttribute("num", num); //De hien thi so trang
        request.setAttribute("action", "1");

        Cookie[] arr = request.getCookies();
        String txt = "";
        if (arr != null) {
            for (Cookie o : arr) {
                if (o.getName().equals("cart")) {
                    txt += o.getValue();
                }
            }
        }
        GioHang cart = new GioHang(txt, list);
        List<Item> listItem = cart.getItems();
        int n; //So luong sach trong gio hang
        if (listItem != null) {
            n = listItem.size();
        } else {
            n = 0;
        }
        request.setAttribute("cartsize", n);

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
