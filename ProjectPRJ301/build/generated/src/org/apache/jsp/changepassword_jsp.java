package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class changepassword_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>T4 Book Store</title>\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <!--Thêm logo vào link-->\n");
      out.write("        <link rel=\"icon\" href=\"images/bs.png\" type=\"image/x-icon\">\n");
      out.write("\n");
      out.write("        <!--Bootstrap-->\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/bootstrap.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/bootstrap.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\n");
      out.write("\n");
      out.write("        <style>\n");
      out.write("            .change-password-form {\n");
      out.write("                width: 400px;\n");
      out.write("                padding: 40px;\n");
      out.write("                position: absolute;\n");
      out.write("                top: 45%;\n");
      out.write("                left: 50%;\n");
      out.write("                transform: translate(-50%, -50%);\n");
      out.write("                background-color: rgba(0, 0, 0, 0.8);\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .change-password-form h1 {\n");
      out.write("                color: white;\n");
      out.write("                text-transform: uppercase;\n");
      out.write("                font-weight: 500;\n");
      out.write("                text-align: center;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .change-password-form input[type=\"text\"] {\n");
      out.write("                border: 0;\n");
      out.write("                background: none;\n");
      out.write("                display: block;\n");
      out.write("                margin: 20px auto;\n");
      out.write("                text-align: center;\n");
      out.write("                border: 2px solid orange;\n");
      out.write("                padding: 14px 10px;\n");
      out.write("                width: 200px;\n");
      out.write("                outline: none;\n");
      out.write("                color: white;\n");
      out.write("                border-radius: 24px;\n");
      out.write("                transform: 0.25s;\n");
      out.write("            }\n");
      out.write("            .change-password-form input[type=\"text\"]:focus {\n");
      out.write("                width: 280px;\n");
      out.write("                border-color: green;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .change-password-form input[type=\"submit\"] {\n");
      out.write("                border: 0;\n");
      out.write("                background: none;\n");
      out.write("                display: block;\n");
      out.write("                margin: 20px auto;\n");
      out.write("                text-align: center;\n");
      out.write("                border: 2px solid orange;\n");
      out.write("                padding: 14px 40px;\n");
      out.write("                outline: none;\n");
      out.write("                color: white;\n");
      out.write("                border-radius: 24px;\n");
      out.write("                transform: 0.25s;\n");
      out.write("                cursor: pointer;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .change-password-form input[type=\"submit\"]:hover {\n");
      out.write("                background-color: orange;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body style=\"background-color: orange\">\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <!--Ảnh bìa-->\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-12\">\n");
      out.write("                    <img src=\"images/ab1.jpg\" class=\"img-responsive img-center\">\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <!--Thanh điều hướng (menu1)-->\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-12\">\n");
      out.write("                    <nav class=\"nav navbar navbar-inverse\" role=\"navigation\">\n");
      out.write("                        <div class=\"container-fluid\"> <!--lớp container-fluif làm cho phần tử có chiều rộng là 100%-->\n");
      out.write("\n");
      out.write("                            <!--Dùng thêm button để responsive-->\n");
      out.write("                            <div class=\"navbar-header\">\n");
      out.write("                                <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"#mynavbar\">\n");
      out.write("                                    <span class=\"icon-bar\"></span>\n");
      out.write("                                    <span class=\"icon-bar\"></span>\n");
      out.write("                                    <span class=\"icon-bar\"></span>\n");
      out.write("                                </button>\n");
      out.write("                                <a class=\"navbar-brand\" href=\"allbook\">T4BookStore</a>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            <div class=\"collapse navbar-collapse\" id=\"mynavbar\">                       \n");
      out.write("                                <ul class=\"nav navbar-nav navbar-right\">\n");
      out.write("                                    <li>\n");
      out.write("                                    <c:if test=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.account == null}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                                        <a href=\"#\"></a>\n");
      out.write("                                    </c:if>\n");
      out.write("                                    <c:if test=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.account != null}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                                        <c:if test=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.account.maPhanQuyen == 0}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                                            <a href=\"showcart\"><i class=\"glyphicon glyphicon-shopping-cart\"></i> Giỏ hàng(");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.cartsize}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(")</a>\n");
      out.write("                                        </c:if>\n");
      out.write("                                        <c:if test=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.account.maPhanQuyen == 1}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                                            <a href=\"#\"><i class=\"glyphicon glyphicon-signal\"></i> Doanh thu</a>\n");
      out.write("                                        </c:if>\n");
      out.write("                                    </c:if>\n");
      out.write("                                    </li>\n");
      out.write("                                    <li>\n");
      out.write("                                    <c:if test=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.account == null}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                                        <a href=\"introduction.jsp\"><i class=\"glyphicon glyphicon-book\"></i> Giới thiệu</a>\n");
      out.write("                                    </c:if>\n");
      out.write("                                    <c:if test=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.account != null}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                                        <a href=\"profile?tendangnhap=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.account.tenDangNhap}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"><i class=\"glyphicon glyphicon-user\"></i> ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.account.tenDangNhap}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</a>\n");
      out.write("                                    </c:if>\n");
      out.write("                                    </li>\n");
      out.write("                                    <li>\n");
      out.write("                                    <c:if test=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.account == null}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                                        <a href=\"login\"><i class=\"glyphicon glyphicon-log-in\"></i> Đăng Nhập/Đăng ký</a>\n");
      out.write("                                    </c:if>\n");
      out.write("                                    <c:if test=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.account != null}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                                        <a href=\"logout\"><i class=\"glyphicon glyphicon-log-out\"></i> Đăng xuất</a>\n");
      out.write("                                    </c:if>\n");
      out.write("                                    </li>\n");
      out.write("                                </ul>\n");
      out.write("\n");
      out.write("                                <!--Search box--> \n");
      out.write("                                <form action=\"search\" class=\"navbar-form\" role=\"search\" style=\"text-align: center;\">\n");
      out.write("                                    <div class=\"form-group\">\n");
      out.write("                                        <input type=\"search\" class=\"form-control\" placeholder=\"Nhập tên sách, tác giả\" name=\"key\" style=\"width: 350px\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.key}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/>\n");
      out.write("                                    </div>\n");
      out.write("                                    <button type=\"submit\" class=\"btn btn-warning glyphicon glyphicon-search\"></button>\n");
      out.write("                                </form>\n");
      out.write("\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </nav>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <!--Change password-->\n");
      out.write("            <div class=\"change-password\">\n");
      out.write("                <form class=\"change-password-form\" action=\"addauthor\">\n");
      out.write("                    <h1>Đổi mật khẩu</h1>\n");
      out.write("                    <input type=\"text\" name=\"old\" placeholder=\"Mật khẩu cũ\">\n");
      out.write("                    <input type=\"text\" name=\"new\" placeholder=\"Mật khẩu mới\">\n");
      out.write("                    <input type=\"text\" name=\"renew\" placeholder=\"Nhập lại mật khẩu mới\">\n");
      out.write("                    <input type=\"submit\" value=\"Change\">\n");
      out.write("                </form>\n");
      out.write("                <div class=\"notice\">\n");
      out.write("                    <p></p>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <!--Footer-->\n");
      out.write("            <div class=\"row\" style=\"background-color: black; color: white; display: flex; margin-top: 2%\">\n");
      out.write("                <div class=\"gtfooter\" style=\"flex-grow: 1 ;padding-left: 2%; padding-top: 2%; padding-bottom: 2%;\">\n");
      out.write("                    <img src=\"images/bs.png\">\n");
      out.write("                    <p style=\"margin-top: 2%;\">T4BookStore nhà sách online, nhận đặt hàng trực tuyến và giao hàng tận nơi. </p>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"lhfooter\" style=\"flex-grow: 1; padding-right: 2%; padding-top: 2%; padding-bottom: 2%;\">\n");
      out.write("                    <p>Chi tiết xin liên hệ:</p>\n");
      out.write("                    <p><i class=\"glyphicon glyphicon-envelope\"> admin@gmail.com</i></p>\n");
      out.write("                    <p><i class=\"glyphicon glyphicon-phone-alt\"> 1900123456</i></p>\n");
      out.write("                    <p><i class=\"glyphicon glyphicon-phone\"> 012345678</i></p>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <!--Thư viên javascript của Bootstrap-->\n");
      out.write("        <script src=\"js/Jquery.js\"></script>\n");
      out.write("        <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.5.1.min.js\"></script>\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js\"></script>\n");
      out.write("        <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
