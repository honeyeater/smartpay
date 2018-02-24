package org.apache.jsp.webpage.smp.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class userNotExist_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(2);
    _jspx_dependants.add("/context/mytags.jsp");
    _jspx_dependants.add("/WEB-INF/tld/easyui.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.release();
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

      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;

      out.write('\r');
      out.write('\n');
      //  c:set
      org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
      _jspx_th_c_005fset_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fset_005f0.setParent(null);
      // /context/mytags.jsp(9,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fset_005f0.setVar("webRoot");
      // /context/mytags.jsp(9,0) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
      _jspx_th_c_005fset_005f0.setValue(basePath);
      int _jspx_eval_c_005fset_005f0 = _jspx_th_c_005fset_005f0.doStartTag();
      if (_jspx_th_c_005fset_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
        return;
      }
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta http-equiv=\"x-ua-compatible\" content=\"IE=edge\">\r\n");
      out.write("    <meta name=\"viewport\"\r\n");
      out.write("          content=\"width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no\">\r\n");
      out.write("    <meta name=\"renderer\" content=\"webkit\">\r\n");
      out.write("    <title>理财平台</title>\r\n");
      out.write("    <meta name=\"keywords\" content=\"理财\">\r\n");
      out.write("    <meta name=\"description\" content=\"一家专门从事理财的交易网站\">\r\n");
      out.write("    <!--bootstrape-->\r\n");
      out.write("    <link href=\"plug-in/bootstrap3/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("    <script src=\"plug-in/ace/assets/js/jquery-2.0.3.min.js\"></script>\r\n");
      out.write("    <script src=\"plug-in/bootstrap3/js/bootstrap.min.js\"></script>\r\n");
      out.write("    <style>\r\n");
      out.write("       body {\r\n");
      out.write("           font-family: \"microsoft Yahei\", \"Helvetica Neue\", Helvetica, Arial, sans-serif;\r\n");
      out.write("       }\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"login\">\r\n");
      out.write("    <div class=\"logo\" style=\"width: 100%;\"></div>\r\n");
      out.write("\r\n");
      out.write("    <div class=\"content text-center\" style=\"padding-top: 10%;\">\r\n");
      out.write("        <form class=\"form-vertical login-form\" id=\"Success\">\r\n");
      out.write("            <h3 class=\"erro \" font=\"\">该推荐人不可用</h3>\r\n");
      out.write("            <div class=\"loading\">\r\n");
      out.write("                <div class=\"splash\">\r\n");
      out.write("                    <div class=\"splash-title\">\r\n");
      out.write("                        <br>\r\n");
      out.write("                        <b id=\"wait\">5</b>\r\n");
      out.write("                        秒后返回指定页面！如果浏览器无法跳转，<a id=\"href\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${baseUrl}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("userLoginController.do?login\">请点击此处</a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <script type=\"text/javascript\">\r\n");
      out.write("                    $(function(){\r\n");
      out.write("                        var wait = document.getElementById('wait'),href = document.getElementById('href').href;\r\n");
      out.write("                        var time = --wait.innerHTML;\r\n");
      out.write("                        if(time <= 0) {\r\n");
      out.write("                            location.href = href;\r\n");
      out.write("                        };\r\n");
      out.write("                    })\r\n");
      out.write("                    $(function(){\r\n");
      out.write("                            var wait = document.getElementById('wait'),href = document.getElementById('href').href;\r\n");
      out.write("                            var interval = setInterval(function(){\r\n");
      out.write("                                var time = --wait.innerHTML;\r\n");
      out.write("                                if(time <= 0) {\r\n");
      out.write("                                    location.href = href;\r\n");
      out.write("                                    clearInterval(interval);\r\n");
      out.write("                                };\r\n");
      out.write("                            }, 1000);\r\n");
      out.write("                        }\r\n");
      out.write("                    );\r\n");
      out.write("                </script>\r\n");
      out.write("        </div>\r\n");
      out.write("        </form>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>\r\n");
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
