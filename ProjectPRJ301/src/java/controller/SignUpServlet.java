/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.TaiKhoanDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.TaiKhoan;

/**
 *
 * @author May Tinh Ha Anh
 */
public class SignUpServlet extends HttpServlet {

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
            out.println("<title>Servlet SignUpServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SignUpServlet at " + request.getContextPath() + "</h1>");
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
        response.sendRedirect("signup.jsp");
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
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String date = request.getParameter("date");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        String cfpass = request.getParameter("cfpass");
        String gender_raw = request.getParameter("gender");
        Boolean gender;
        if(gender_raw.equals("1"))
        {
            gender = true;
        }
        else
        {
            gender = false;
        }

        if (!pass.equals(cfpass)) {
            request.setAttribute("error", "Mật khẩu không khớp, vui lòng nhập lại");
            request.getRequestDispatcher("signup.jsp").forward(request, response);
        } else {
            TaiKhoanDAO tkdao = new TaiKhoanDAO();
            TaiKhoan tk = tkdao.checkAccountExist(user);
            if (tk != null) {
                request.setAttribute("error", "Tên tài khoản (Tên đăng nhập) đã tồn tại");
                request.getRequestDispatcher("signup.jsp").forward(request, response);
            }
            else
            {
                TaiKhoan tk1 = new TaiKhoan(0, name, gender, date, phone, email, address, user, pass, 0);
                tkdao.signUp(tk1);
                response.sendRedirect("allbook");
            }
        }

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
