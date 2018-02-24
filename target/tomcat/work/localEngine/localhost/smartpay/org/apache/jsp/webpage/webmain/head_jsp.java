package org.apache.jsp.webpage.webmain;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class head_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!--é¡µé¢å¤´é¨å¯¼èª-->\n");
      out.write("<div id=\"header\">\n");
      out.write("    <nav class=\"navbar navbar-default navbar-fixed-top\">\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"navbar-header\">\n");
      out.write("                <button type=\"button\" class=\"navbar-toggle collapsed\" data-toggle=\"collapse\"\n");
      out.write("                        data-target=\"#bs-example-navbar-collapse-1\" aria-expanded=\"false\">\n");
      out.write("                    <span class=\"sr-only\"></span>\n");
      out.write("                    <span class=\"icon-bar\"></span>\n");
      out.write("                    <span class=\"icon-bar\"></span>\n");
      out.write("                    <span class=\"icon-bar\"></span>\n");
      out.write("                </button>\n");
      out.write("                <a class=\"navbar-brand\" href=\"#\" style=\"font-size: 26px;\">çè´¢ç¤¾åº</a>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"collapse navbar-collapse\" id=\"bs-example-navbar-collapse-1\">\n");
      out.write("                <ul class=\"nav navbar-nav navbar-right\">\n");
      out.write("                    <li class=\"active\"><a href=\"#\">ç³»ç»é¦é¡µ</a></li>\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"#\" class=\"dropdown\" data-toggle=\"dropdown\" aria-labelledby=\"\"\n");
      out.write("                           role=\"button\" aria-expanded=\"true\" aria-haspopup=\"true\">ä¸ªäººç®¡ç</a>\n");
      out.write("                        <ul class=\"dropdown-menu dropdown-menu-left\">\n");
      out.write("                            <li><a href=\"#\">ä¸ªäººèµæ</a></li>\n");
      out.write("                            <li><a href=\"#\">ä¿®æ¹å¯ç </a></li>\n");
      out.write("                        </ul>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"#\" class=\"dropdown\" data-toggle=\"dropdown\" aria-labelledby=\"\"\n");
      out.write("                           role=\"button\" aria-expanded=\"true\" aria-haspopup=\"true\">ä¼åä¸­å¿</a>\n");
      out.write("                        <ul class=\"dropdown-menu dropdown-menu-left\">\n");
      out.write("                            <li><a href=\"#\">ä¼åæ³¨å</a></li>\n");
      out.write("                            <li><a href=\"#\">æ¿æ´»ç ç®¡ç</a></li>\n");
      out.write("                        </ul>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"#\" class=\"dropdown\" data-toggle=\"dropdown\" aria-labelledby=\"\"\n");
      out.write("                           role=\"button\" aria-expanded=\"true\" aria-haspopup=\"true\">è´¢å¡ç®¡ç</a>\n");
      out.write("                        <ul class=\"dropdown-menu dropdown-menu-left\">\n");
      out.write("                            <li><a href=\"#\">è´¢å¡æç»</a> </li>\n");
      out.write("                            <li><a href=\"#\">æ³¨èµåè¡¨</a> </li>\n");
      out.write("                            <li><a href=\"#\">æååè¡¨</a> </li>\n");
      out.write("                        </ul>\n");
      out.write("                    </li>\n");
      out.write("                    <li><a href=\"#\" class=\"dropdown\" data-toggle=\"dropdown\" aria-labelledby=\"\"\n");
      out.write("                           role=\"button\" aria-expanded=\"true\" aria-haspopup=\"true\">å¸åºç®¡ç</a>\n");
      out.write("                        <ul class=\"dropdown-menu dropdown-menu-left\">\n");
      out.write("                            <li><a href=\"#\">æ¨èå³ç³»</a> </li>\n");
      out.write("                            <li><a href=\"#\">å¢éä¸ç»©</a> </li>\n");
      out.write("                        </ul>\n");
      out.write("                    </li>\n");
      out.write("                    <li><a href=\"#\" class=\"dropdown\" data-toggle=\"dropdown\" aria-labelledby=\"\"\n");
      out.write("                           role=\"button\" aria-expanded=\"true\" aria-haspopup=\"true\">å¬åçè¨</a>\n");
      out.write("                        <ul class=\"dropdown-menu dropdown-menu-left\">\n");
      out.write("                            <li><a href=\"#\">ææ°å¬å</a> </li>\n");
      out.write("                            <li><a href=\"#\">çè¨ä¸­å¿</a> </li>\n");
      out.write("                            <li><a href=\"#\">é®é¢åé¦</a> </li>\n");
      out.write("                        </ul>\n");
      out.write("                    </li>\n");
      out.write("                    <li><a href=\"#\">å¸¸è§é®é¢</a></li>\n");
      out.write("                    <li><a href=\"#\" onclick=\"logout();\">å®å¨éåº</a></li>\n");
      out.write("                    <li><a href=\"#\" class=\"dropdown\" data-toggle=\"dropdown\" aria-labelledby=\"\"\n");
      out.write("                           role=\"button\" aria-expanded=\"true\" aria-haspopup=\"true\">MOCOTT</a>\n");
      out.write("                        <ul class=\"dropdown-menu dropdown-menu-left\">\n");
      out.write("                            <li><a href=\"#\">ä¿®æ¹èµæ</a> </li>\n");
      out.write("                            <li><a href=\"#\">å®å¨éåº</a> </li>\n");
      out.write("                        </ul>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </nav>\n");
      out.write("</div>\n");
      out.write("<script>\n");
      out.write("    function logout(){\n");
      out.write("        $(function () {\n");
      out.write("            $(\".dropdown\").mouseover(function (e) {\n");
      out.write("                $(this).click();\n");
      out.write("            });\n");
      out.write("        });\n");
      out.write("    }\n");
      out.write("</script>\n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
