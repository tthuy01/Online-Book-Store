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
public class FilterNXBServlet extends HttpServlet {

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
            out.println("<title>Servlet FilterNXBServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FilterNXBServlet at " + request.getContextPath() + "</h1>");
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
        String[] maNXB = request.getParameterValues("manxb");
        SachDAO sdao = new SachDAO();
        List<Sach> list = sdao.filterNXB(maNXB);
        NXBDAO ndao = new NXBDAO();
        List<NXB> listnxb = ndao.getAllNXB();
        boolean[] m = new boolean[listnxb.size()]; //m: Ma NXB
        int t = 0;
        for (int i = 0; i < listnxb.size(); i++) {
            if(isCheck(listnxb.get(i).getMaNXB(), maNXB))
            {
                m[i] = true;
            }
            else
            {
                m[i] =false;
            }
        }
        
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
        
//        request.setAttribute("allbook", list1);
        request.setAttribute("allbook", list);
        request.setAttribute("page", page); //De danh dau trang nao
        request.setAttribute("num", num); //De hien thi so trang
        request.setAttribute("action", "4");
        
        TheLoaiDAO tldao = new TheLoaiDAO();
        List<TheLoai> list2 = tldao.getAllTheLoai();
        request.setAttribute("alltheloai", list2);
        
        
        
        request.setAttribute("allnxb", listnxb);
        request.setAttribute("maNXBTF", m);
        request.getRequestDispatcher("allbook.jsp").forward(request, response);
    }
    
    private boolean isCheck(String d, String[] id)
    {
        if(id == null)
        {
            return false; 
        }
        else
        {
            for (int i = 0; i < id.length; i++) {
                if(id[i].equalsIgnoreCase(d))
                    return true;
            }
        }
        return false;
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
