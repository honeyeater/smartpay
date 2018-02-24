package org.apache.jsp.webpage.webmain;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class operatorbar_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"container\" id=\"operatorbar\">\r\n");
      out.write("    <div class=\"row\" style=\"padding-top: 10px;color: white\">\r\n");
      out.write("        <div class=\"col-lg-4\">\r\n");
      out.write("            <div class=\"col-sm-4 col-xs-4\" style=\"text-align: center\">\r\n");
      out.write("                <a href=\"#\">\r\n");
      out.write("                    <img class=\"img-circle navImg\" src=\"plug-in/webfront/images/inject.png\"></a>\r\n");
      out.write("                <h5><strong>注资列表</strong></h5>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"col-sm-4 col-xs-4\" style=\"text-align: center\">\r\n");
      out.write("                <a href=\"#\">\r\n");
      out.write("                    <img class=\"img-circle navImg\" src=\"plug-in/webfront/images/draw.png\">\r\n");
      out.write("                </a>\r\n");
      out.write("                <h5><strong>提现列表</strong></h5>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"col-sm-4 col-xs-4\" style=\"text-align: center\">\r\n");
      out.write("                <a href=\"#\">\r\n");
      out.write("                    <img class=\"img-circle navImg\" src=\"plug-in/webfront/images/trad.png\"></a>\r\n");
      out.write("                <h5><strong>财务明细</strong></h5>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"col-lg-4\">\r\n");
      out.write("            <div class=\"col-sm-4 col-xs-4\" style=\"text-align: center\">\r\n");
      out.write("                <a href=\"#\">\r\n");
      out.write("                    <img class=\"img-circle navImg\" src=\"plug-in/webfront/images/regist.png\"></a>\r\n");
      out.write("                <h5><strong>注册会员</strong></h5>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"col-sm-4 col-xs-4\" style=\"text-align: center\">\r\n");
      out.write("                <a href=\"#\">\r\n");
      out.write("                    <img class=\"img-circle navImg\" src=\"plug-in/webfront/images/ship.png\"></a>\r\n");
      out.write("                <h5><strong>推荐列表</strong></h5>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"col-sm-4 col-xs-4\" style=\"text-align: center\">\r\n");
      out.write("                <a href=\"#\">\r\n");
      out.write("                    <img class=\"img-circle navImg\" src=\"plug-in/webfront/images/team.png\"></a>\r\n");
      out.write("                <h5><strong>团队业绩</strong></h5>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"col-lg-4\">\r\n");
      out.write("            <div class=\"col-sm-4 col-xs-4\" style=\"text-align: center\">\r\n");
      out.write("                <a href=\"#\">\r\n");
      out.write("                    <img class=\"img-circle navImg\" src=\"plug-in/webfront/images/activate.png\"></a>\r\n");
      out.write("                <h5><strong>激活码管理</strong></h5>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"col-sm-4 col-xs-4\" style=\"text-align: center\">\r\n");
      out.write("                <a href=\"#\"><img class=\"img-circle navImg\" src=\"plug-in/webfront/images/pro.png\"></a>\r\n");
      out.write("                <h5><strong>问题反馈</strong></h5>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"col-sm-4 col-xs-4\" style=\"text-align: center\">\r\n");
      out.write("                <a href=\"#\">\r\n");
      out.write("                    <img class=\"img-circle navImg\" src=\"plug-in/webfront/images/notice.png\"></a>\r\n");
      out.write("                <h5><strong>新闻公告</strong></h5>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("<div class=\"container\" id=\"banner\">\r\n");
      out.write("    <div class=\"row\">\r\n");
      out.write("        <ol class=\"breadcrumb\" id=\"navtitle\">\r\n");
      out.write("            <li><a href=\"#\">系统首页</a> </li>\r\n");
      out.write("        </ol>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
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
