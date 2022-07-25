/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.SachDAO;
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
import model.Sach;

/**
 *
 * @author May Tinh Ha Anh
 */
public class ProcessServlet extends HttpServlet {

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
            out.println("<title>Servlet ProcessServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProcessServlet at " + request.getContextPath() + "</h1>");
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
        List<Sach> list = sdao.getAll();
        Cookie[] arr = request.getCookies();
        String txt = "";
        if (arr != null) {
            for (Cookie o : arr) {
                if (o.getName().equals("cart")) {
                    txt += o.getValue();
                    o.setMaxAge(0);
                    response.addCookie(o);
                }
            }
        }

        GioHang cart = new GioHang(txt, list);
        String soLuong_raw = request.getParameter("soluong");
        String maSach_raw = request.getParameter("masach");
        int maSach, soLuong = 0;
        try {
            maSach = Integer.parseInt(maSach_raw);
            Sach p = sdao.getBookByBookId(maSach);
            int soLuongTonKho = p.getSoLuongTonKho();
            soLuong = Integer.parseInt(soLuong_raw);
            if (soLuong == -1 && (cart.getQuantityById(maSach) <= 1)) {
                cart.removeItem(maSach);
            } else if (soLuong == 0) {
                cart.removeItem(maSach);
            } else {
                if (soLuong == 1 && cart.getQuantityById(maSach) >= soLuongTonKho) {
                    soLuong = 0;
                }
                int gia = p.getGia();
                Item t = new Item(p, soLuong, gia);
                cart.addItem(t);
            }
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
        List<Item> items = cart.getItems();
        txt = "";
        if (items.size() > 0) {
            txt = items.get(0).getSach().getMaSach() + ":"
                    + items.get(0).getSoLuong();
            for (int i = 1; i < items.size(); i++) {
                txt += "," + items.get(i).getSach().getMaSach() + ":"
                        + items.get(i).getSoLuong();
            }
        }
        Cookie c = new Cookie("cart", txt);
        c.setMaxAge(2 * 24 * 60 * 60);
        response.addCookie(c);
        request.setAttribute("cart", cart);
        request.getRequestDispatcher("mycart.jsp").forward(request, response);
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
//        SachDAO sdao = new SachDAO();
//        List<Sach> list = sdao.getAll();
//        Cookie[] arr = request.getCookies();
//        String txt = "";
//        if (arr != null) {
//            for (Cookie o : arr) {
//                if (o.getName().equals("cart")) {
//                    txt += o.getValue();
//                    o.setMaxAge(0);
//                    response.addCookie(o);
//                }
//            }
//        }
//        
//        String id = request.getParameter("masach");
//        String[] ids = txt.split(",");
//        String out = "";
//        for (int i = 0; i < ids.length; i++) {
//            String[] s = ids[i].split(":");
//            if(!s[0].equals(id)) {
//                if(out.isEmpty())
//                {
//                    out = ids[i];
//                }
//                else
//                {
//                    out+=","+ids[i];
//                }
//            }
//        }
//        if(!out.isEmpty())
//        {
//            Cookie c = new Cookie("cart", out);
//            c.setMaxAge(2*24*60*60);
//            response.addCookie(c);
//        }
//        GioHang cart = new GioHang(out, list);
//        request.setAttribute("cart", cart);
//        request.getRequestDispatcher("mycart.jsp").forward(request, response);
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
