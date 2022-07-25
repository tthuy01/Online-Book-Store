/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.HoaDonDAO;
import dal.TaiKhoanDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.TaiKhoan;

/**
 *
 * @author May Tinh Ha Anh
 */
public class ChangePasswordServlet extends HttpServlet {

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
            out.println("<title>Servlet ChangePasswordServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ChangePasswordServlet at " + request.getContextPath() + "</h1>");
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
        String old = request.getParameter("old");
        String newpass = request.getParameter("new");
        String renew = request.getParameter("renew");
        HttpSession session = request.getSession();
        TaiKhoan a = (TaiKhoan) session.getAttribute("account");
        if (a == null) {
            response.sendRedirect("login");
        } else {           
            if (old == "" || newpass == "" || renew == "") {
                request.setAttribute("notice", "Bạn chưa điền đủ thông tin!");
                request.getRequestDispatcher("changepassword.jsp").forward(request, response);
            }
            
            if (!old.equals(a.getMatKhau()))
            {
                request.setAttribute("notice", "Mật khẩu cũ không đúng!");
                request.getRequestDispatcher("changepassword.jsp").forward(request, response);
            }

            if (!newpass.equals(renew)) {
                request.setAttribute("notice", "Mật khẩu mới không khớp!");
                request.getRequestDispatcher("changepassword.jsp").forward(request, response);
            }

//            if (old.equals(newpass)) {
//                request.setAttribute("notice", "Mật khẩu không thay đổi");
//                request.getRequestDispatcher("changepassword.jsp").forward(request, response);
//            }
            TaiKhoanDAO tkdao = new TaiKhoanDAO();
            tkdao.changePassword(newpass, a.getMaTaiKhoan());
            request.setAttribute("notice", "Thay đổi thành công");
            request.getRequestDispatcher("changepassword.jsp").forward(request, response);
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
