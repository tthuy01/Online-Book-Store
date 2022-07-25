/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.DoanhThuDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DoanhThu;

/**
 *
 * @author May Tinh Ha Anh
 */
public class DoanhThuServlet extends HttpServlet {

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
            out.println("<title>Servlet DoanhThuServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DoanhThuServlet at " + request.getContextPath() + "</h1>");
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
        DoanhThuDAO dtdao = new DoanhThuDAO();
        List<DoanhThu> list = dtdao.getListTopDoanhThu();
        request.setAttribute("listtopdoanhthu", list);
        List<String> list1 = dtdao.getTime();
        request.setAttribute("listthoigian", list1);
        String time = request.getParameter("time");
        if(time == null) {
            time = list1.get(0);
        }
        String[] t = time.split("/");
        try {
            int m = Integer.parseInt(t[0]);
            int y = Integer.parseInt(t[1]);

            int d = dtdao.doanhThuTheoThang(m, y);
            request.setAttribute("doanhthutheothang", d);
            request.setAttribute("tgian", time);
            request.getRequestDispatcher("doanhthu.jsp").forward(request, response);
        } catch (NumberFormatException e) {
        }
        request.getRequestDispatcher("doanhthu.jsp").forward(request, response);
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
        DoanhThuDAO dtdao = new DoanhThuDAO();
        List<String> list1 = dtdao.getTime();
        request.setAttribute("listthoigian", list1);
        String time = request.getParameter("time");
        if(time == null) {
            time = list1.get(0);
        }
        String[] t = time.split("/");
        try {
            int m = Integer.parseInt(t[0]);
            int y = Integer.parseInt(t[1]);

            List<DoanhThu> list = dtdao.getListTopDoanhThu();
            request.setAttribute("listtopdoanhthu", list);
            int d = dtdao.doanhThuTheoThang(m, y);
            request.setAttribute("doanhthutheothang", d);
            request.setAttribute("tgian", time);
            request.getRequestDispatcher("doanhthu.jsp").forward(request, response);
        } catch (NumberFormatException e) {
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
