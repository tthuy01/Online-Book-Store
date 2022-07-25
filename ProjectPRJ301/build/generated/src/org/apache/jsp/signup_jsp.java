package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class signup_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <link rel=\"icon\" href=\"images/bs.png\">\n");
      out.write("        <style>\n");
      out.write("            body {\n");
      out.write("                margin: 0;\n");
      out.write("                padding: 0;\n");
      out.write("                background-color: orange;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .dk-form {\n");
      out.write("                width: 800px;\n");
      out.write("                padding: 40px;\n");
      out.write("                position: absolute;\n");
      out.write("                top: 50%;\n");
      out.write("                left: 50%;\n");
      out.write("                transform: translate(-50%, -50%);\n");
      out.write("                background-color: rgba(0, 0, 0, 0.8);\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .dk-form h1 {\n");
      out.write("                color: white;\n");
      out.write("                text-transform: uppercase;\n");
      out.write("                font-weight: 500;\n");
      out.write("                text-align: center;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .dk-form input[type=\"text\"], .dk-form input[type=\"password\"] {\n");
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
      out.write("\n");
      out.write("            .dk-form input[type=\"text\"]:focus, .dk-form input[type=\"password\"]:focus{\n");
      out.write("                width: 280px;\n");
      out.write("                border-color: green;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .dk-form input[type=\"submit\"] {\n");
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
      out.write("            .dk-form input[type=\"submit\"]:hover {\n");
      out.write("                background-color: orange;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .content-left {\n");
      out.write("                width: 50%;\n");
      out.write("                float: left;\n");
      out.write("                text-align: center;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .content-right {\n");
      out.write("                width: 50%;\n");
      out.write("                float: right;\n");
      out.write("                text-align: center;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <form class=\"dk-form\" action=\"signup\" method=\"post\">\n");
      out.write("            <h1>Đăng ký</h1>\n");
      out.write("            <div class=\"content-left\">\n");
      out.write("                <input type=\"text\" name=\"name\" placeholder=\"Họ và tên\">\n");
      out.write("                <input type=\"text\" name=\"date\" placeholder=\"Ngày sinh\">\n");
      out.write("                <input type=\"text\" name=\"phone\" placeholder=\"Số điện thoại\">\n");
      out.write("                <input type=\"text\" name=\"email\" placeholder=\"Email\">\n");
      out.write("            </div>\n");
      out.write("            <div class=\"content-right\">\n");
      out.write("                <input type=\"text\" name=\"address\" placeholder=\"Địa chỉ\">\n");
      out.write("                <input type=\"text\" name=\"user\" placeholder=\"Tên đăng nhập\">\n");
      out.write("                <input type=\"password\" name=\"pass\" placeholder=\"Mật khẩu\">\n");
      out.write("                <input type=\"password\" name=\"cfpass\" placeholder=\"Xác nhận mật khẩu\">\n");
      out.write("            </div>\n");
      out.write("            <div style=\"color: white; padding-left: 92px;\">\n");
      out.write("                Giới tính:\n");
      out.write("                <input type=\"radio\" name=\"gender\" checked>Nam\n");
      out.write("                <input type=\"radio\" name=\"gender\">Nữ\n");
      out.write("            </div>\n");
      out.write("            <input type=\"submit\" value=\"Đăng ký\">\n");
      out.write("        </form>\n");
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
