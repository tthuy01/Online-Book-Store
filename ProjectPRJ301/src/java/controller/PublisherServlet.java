/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.NXBDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.NXB;

/**
 *
 * @author May Tinh Ha Anh
 */
public class PublisherServlet extends HttpServlet {

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
            out.println("<title>Servlet PublisherServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PublisherServlet at " + request.getContextPath() + "</h1>");
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
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        NXBDAO ndao = new NXBDAO();
        List<NXB> list = ndao.getAllNXB();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMaNXB().equalsIgnoreCase(id)) {
                if (list.get(i).getTenNXB().equalsIgnoreCase(name) && list.get(i).getDiaChi().equalsIgnoreCase(address)) {
                    request.setAttribute("error", "Nhà xuất bản đã tồn tại trong database");
                    request.getRequestDispatcher("addpublisher.jsp").forward(request, response);
                } else {
                    request.setAttribute("error", "Mã nhà xuất bản = " + id + " đã tồn tại trong database");
                    request.getRequestDispatcher("addpublisher.jsp").forward(request, response);
                }
            }
        }
        NXB n = new NXB(id, name, address);
        ndao.insertNXB(n);
        response.sendRedirect("addmenu.jsp");
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
