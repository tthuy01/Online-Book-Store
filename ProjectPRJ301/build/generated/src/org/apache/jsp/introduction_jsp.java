package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class introduction_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    </head>\n");
      out.write("    <body style=\"background-color: orange;\">\n");
      out.write("        <div class=\"container\">\n");
      out.write("\n");
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
      out.write("                                </button>\n");
      out.write("                                <a class=\"navbar-brand\" href=\"allbook\">T4BookStore</a>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            <div class=\"collapse navbar-collapse\" id=\"mynavbar\">                       \n");
      out.write("                                <ul class=\"nav navbar-nav navbar-right\">                                   \n");
      out.write("                                    <li>\n");
      out.write("                                        <a href=\"introduction.jsp\"><i class=\"glyphicon glyphicon-book\"></i> Giới thiệu</a>\n");
      out.write("                                    </li>\n");
      out.write("                                    <li>\n");
      out.write("                                        <a href=\"login\"><i class=\"glyphicon glyphicon-log-in\"></i> Đăng Nhập/Đăng ký</a>\n");
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
      out.write("            <!--Nội dung-->\n");
      out.write("            <div class=\"row nd\" style=\"background-color: black; color: white; width: 40%; margin: 0 auto;\">\n");
      out.write("                <div style=\"padding: 5%;\">\n");
      out.write("                    <h1 style=\"text-align: center;\">T4 Book Store</h1>\n");
      out.write("                    <p style=\"margin-top: 2%;\">Cửa hàng sách online. Nhận đặt hàng trực tuyến và ship tận nơi. KHÔNG hỗ trợ đặt mua và nhận hàng trực tiếp tại văn phòng.</p>\n");
      out.write("                    <p>Chi tiết xin liên hệ:</p>\n");
      out.write("                    <p><i class=\"glyphicon glyphicon-envelope\"> <span>admin@gmail.com</span></i></p>\n");
      out.write("                    <p><i class=\"glyphicon glyphicon-phone-alt\"> <span>1900123456</span></i></p>\n");
      out.write("                    <p><i class=\"glyphicon glyphicon-phone\"> <span>012345678</span></i></p>\n");
      out.write("                    <p><img src=\"images/icon-facebook.png\" alt=\"\" height=\"18px\" width=\"18px\"><a\n");
      out.write("                            href=\"https://www.facebook.com/\" style=\"color: white; padding-left: 10px;\">Facebook</a></p>\n");
      out.write("                    <p><img src=\"images/icon-address.jpg\" height=\"18px\" width=\"18px\"><span style=\"padding-left: 10px;\">Thái\n");
      out.write("                            Nguyên</span></p>\n");
      out.write("                    <p style=\"margin-bottom: 5%;\">Cảm ơn mọi người đã ghé thăm.</p>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div style=\"clear: both;\"></div>\n");
      out.write("            <!--Footer-->\n");
      out.write("            <div class=\"row\" style=\"background-color: black; color: white; display: flex; margin-top: 2%;\">\n");
      out.write("                <div class=\"gtfooter\" style=\"flex-grow: 1 ;padding-left: 2%; padding-top: 2%; padding-bottom: 2%;\">\n");
      out.write("                    <img src=\"images/bs.png\">\n");
      out.write("                    <p style=\"margin-top: 2%;\">T4BookStore nhà sách online, nhận đặt hàng trực tuyến và giao hàng tận nơi.\n");
      out.write("                    </p>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"lhfooter\" style=\"flex-grow: 1; padding-right: 2%; padding-top: 2%; padding-bottom: 2%;\">\n");
      out.write("                    <p>Chi tiết xin liên hệ:</p>\n");
      out.write("                    <p><i class=\"glyphicon glyphicon-envelope\"> admin@gmail.com</i></p>\n");
      out.write("                    <p><i class=\"glyphicon glyphicon-phone-alt\"> 1900123456</i></p>\n");
      out.write("                    <p><i class=\"glyphicon glyphicon-phone\"> 012345678</i></p>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <!--Thư viên javascript của Bootstrap-->\n");
      out.write("        <script src=\"js/Jquery.js\"></script>\n");
      out.write("        <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.5.1.min.js\"></script>\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js\"></script>\n");
      out.write("        <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>\n");
      out.write("\n");
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
