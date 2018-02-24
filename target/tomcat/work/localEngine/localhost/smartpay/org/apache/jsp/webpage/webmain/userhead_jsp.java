package org.apache.jsp.webpage.webmain;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class userhead_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("<!--页面头部导航-->\n");
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
      out.write("                <a class=\"navbar-brand\" href=\"#\" style=\"font-size: 26px;\">理财社区</a>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"collapse navbar-collapse\" id=\"bs-example-navbar-collapse-1\">\n");
      out.write("                <ul class=\"nav navbar-nav navbar-right\">\n");
      out.write("                    <li class=\"active\"><a href=\"#\">系统首页</a></li>\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"#\" class=\"dropdown\" data-toggle=\"dropdown\" aria-labelledby=\"\"\n");
      out.write("                           role=\"button\" aria-expanded=\"true\" aria-haspopup=\"true\">个人管理</a>\n");
      out.write("                        <ul class=\"dropdown-menu dropdown-menu-left\">\n");
      out.write("                            <li><a href=\"#\">个人资料</a></li>\n");
      out.write("                            <li><a href=\"#\">修改密码</a></li>\n");
      out.write("                        </ul>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"#\" class=\"dropdown\" data-toggle=\"dropdown\" aria-labelledby=\"\"\n");
      out.write("                           role=\"button\" aria-expanded=\"true\" aria-haspopup=\"true\">会员中心</a>\n");
      out.write("                        <ul class=\"dropdown-menu dropdown-menu-left\">\n");
      out.write("                            <li><a href=\"#\">会员注册</a></li>\n");
      out.write("                            <li><a href=\"#\">激活码管理</a></li>\n");
      out.write("                        </ul>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"#\" class=\"dropdown\" data-toggle=\"dropdown\" aria-labelledby=\"\"\n");
      out.write("                           role=\"button\" aria-expanded=\"true\" aria-haspopup=\"true\">财务管理</a>\n");
      out.write("                        <ul class=\"dropdown-menu dropdown-menu-left\">\n");
      out.write("                            <li><a href=\"#\">财务明细</a> </li>\n");
      out.write("                            <li><a href=\"#\">注资列表</a> </li>\n");
      out.write("                            <li><a href=\"#\">提取列表</a> </li>\n");
      out.write("                        </ul>\n");
      out.write("                    </li>\n");
      out.write("                    <li><a href=\"#\" class=\"dropdown\" data-toggle=\"dropdown\" aria-labelledby=\"\"\n");
      out.write("                           role=\"button\" aria-expanded=\"true\" aria-haspopup=\"true\">市场管理</a>\n");
      out.write("                        <ul class=\"dropdown-menu dropdown-menu-left\">\n");
      out.write("                            <li><a href=\"#\">推荐关系</a> </li>\n");
      out.write("                            <li><a href=\"#\">团队业绩</a> </li>\n");
      out.write("                        </ul>\n");
      out.write("                    </li>\n");
      out.write("                    <li><a href=\"#\" class=\"dropdown\" data-toggle=\"dropdown\" aria-labelledby=\"\"\n");
      out.write("                           role=\"button\" aria-expanded=\"true\" aria-haspopup=\"true\">公告留言</a>\n");
      out.write("                        <ul class=\"dropdown-menu dropdown-menu-left\">\n");
      out.write("                            <li><a href=\"#\">最新公告</a> </li>\n");
      out.write("                            <li><a href=\"#\">留言中心</a> </li>\n");
      out.write("                            <li><a href=\"#\">问题反馈</a> </li>\n");
      out.write("                        </ul>\n");
      out.write("                    </li>\n");
      out.write("                    <li><a href=\"#\">常见问题</a></li>\n");
      out.write("                    <li><a href=\"#\" onclick=\"logout();\">安全退出</a></li>\n");
      out.write("                    <li><a href=\"#\" class=\"dropdown\" data-toggle=\"dropdown\" aria-labelledby=\"\"\n");
      out.write("                           role=\"button\" aria-expanded=\"true\" aria-haspopup=\"true\">MOCOTT</a>\n");
      out.write("                        <ul class=\"dropdown-menu dropdown-menu-left\">\n");
      out.write("                            <li><a href=\"#\">修改资料</a> </li>\n");
      out.write("                            <li><a href=\"#\">安全退出</a> </li>\n");
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
