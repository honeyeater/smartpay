package org.apache.jsp.webpage.smp.feedback;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class messageCenterMain_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(7);
    _jspx_dependants.add("/context/mytags.jsp");
    _jspx_dependants.add("/webpage/webmain/head.jsp");
    _jspx_dependants.add("/webpage/webmain/operatorbar.jsp");
    _jspx_dependants.add("/webpage/smp/user/userinfoBase.jsp");
    _jspx_dependants.add("/webpage/smp/feedback/messageCenter.jsp");
    _jspx_dependants.add("/webpage/webmain/foot.jsp");
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
      out.write("    <link href=\"plug-in/webfront/css/common.css\" rel=\"stylesheet\">\r\n");
      out.write("    <script src=\"plug-in/ace/assets/js/jquery-2.0.3.min.js\"></script>\r\n");
      out.write("    <script src=\"plug-in/bootstrap3/js/bootstrap.min.js\"></script>\r\n");
      out.write("    <style>\r\n");
      out.write("\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write('\r');
      out.write('\n');
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
      out.write("                    <li class=\"active\"><a href=\"userLoginController.do?toIndex\">系统首页</a></li>\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"#\" class=\"dropdown\" data-toggle=\"dropdown\" aria-labelledby=\"\"\n");
      out.write("                           role=\"button\" aria-expanded=\"true\" aria-haspopup=\"true\">个人管理</a>\n");
      out.write("                        <ul class=\"dropdown-menu dropdown-menu-left\">\n");
      out.write("                            <li><a href=\"frontUserRegisterController.do?gouserinfo\">个人资料</a></li>\n");
      out.write("                            <li><a href=\"frontUserRegisterController.do?updatepwd\">修改密码</a></li>\n");
      out.write("                        </ul>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"#\" class=\"dropdown\" data-toggle=\"dropdown\" aria-labelledby=\"\"\n");
      out.write("                           role=\"button\" aria-expanded=\"true\" aria-haspopup=\"true\">会员中心</a>\n");
      out.write("                        <ul class=\"dropdown-menu dropdown-menu-left\">\n");
      out.write("                            <li><a href=\"frontUserRegisterController.do?tousergeneral\">会员注册</a></li>\n");
      out.write("                            <li><a href=\"frontUserActivatecodeController.do?activatecode\">激活码管理</a></li>\n");
      out.write("                        </ul>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"#\" class=\"dropdown\" data-toggle=\"dropdown\" aria-labelledby=\"\"\n");
      out.write("                           role=\"button\" aria-expanded=\"true\" aria-haspopup=\"true\">财务管理</a>\n");
      out.write("                        <ul class=\"dropdown-menu dropdown-menu-left\">\n");
      out.write("                            <li><a href=\"orderInjectInfoController.do?tofinancelist\">财务明细</a> </li>\n");
      out.write("                            <li><a href=\"orderInjectInfoController.do?toInjectList\">注资列表</a> </li>\n");
      out.write("                            <li><a href=\"orderDrawInfoController.do?toDrawList\">提取列表</a> </li>\n");
      out.write("                        </ul>\n");
      out.write("                    </li>\n");
      out.write("                    <li><a href=\"#\" class=\"dropdown\" data-toggle=\"dropdown\" aria-labelledby=\"\"\n");
      out.write("                           role=\"button\" aria-expanded=\"true\" aria-haspopup=\"true\">市场管理</a>\n");
      out.write("                        <ul class=\"dropdown-menu dropdown-menu-left\">\n");
      out.write("                            <li><a href=\"frontUserMemberController.do?toMemberShip\">推荐关系</a> </li>\n");
      out.write("                            <li><a href=\"orderInjectInfoController.do?toTeamList\">团队业绩</a> </li>\n");
      out.write("                        </ul>\n");
      out.write("                    </li>\n");
      out.write("                    <li><a href=\"#\" class=\"dropdown\" data-toggle=\"dropdown\" aria-labelledby=\"\"\n");
      out.write("                           role=\"button\" aria-expanded=\"true\" aria-haspopup=\"true\">公告留言</a>\n");
      out.write("                        <ul class=\"dropdown-menu dropdown-menu-left\">\n");
      out.write("                            <li><a href=\"tSUsernoticeController.do?toNoticeList\">最新公告</a> </li>\n");
      out.write("                            <li><a href=\"tSFeedreplyController.do?toMessagelist\">留言中心</a> </li>\n");
      out.write("                            <li><a href=\"tSFeedbackController.do?toFeedback\">问题反馈</a> </li>\n");
      out.write("                        </ul>\n");
      out.write("                    </li>\n");
      out.write("                    <li><a href=\"#\">常见问题</a></li>\n");
      out.write("                    <li><a href=\"#\" onclick=\"logout();\">安全退出</a></li>\n");
      out.write("                    <li><a href=\"#\" class=\"dropdown\" data-toggle=\"dropdown\" aria-labelledby=\"\"\n");
      out.write("                           role=\"button\" aria-expanded=\"true\" aria-haspopup=\"true\">MOCOTT</a>\n");
      out.write("                        <ul class=\"dropdown-menu dropdown-menu-left\">\n");
      out.write("                            <li><a href=\"frontUserRegisterController.do?updatepwd\">修改资料</a></li>\n");
      out.write("                            <li><a href=\"#\" onclick=\"logout();\">安全退出</a> </li>\n");
      out.write("                        </ul>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </nav>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("<script>\n");
      out.write("    $(function () {\n");
      out.write("        $(\".dropdown\").mouseover(function (e) {\n");
      out.write("            $(this).click();\n");
      out.write("        });\n");
      out.write("    });\n");
      out.write("    function logout(){\n");
      out.write("        layer.confirm('您确定要退出登录吗？', {\n");
      out.write("            offset: '240px',\n");
      out.write("            scrollbar: false,\n");
      out.write("            btn: ['确定','取消'], //按钮\n");
      out.write("            shade: 0.3 //不显示遮罩\n");
      out.write("        }, function(){\n");
      out.write("            location.href=\"userLoginController.do?logout\";\n");
      out.write("        }, function(){\n");
      out.write("            return;\n");
      out.write("        });\n");
      out.write("    }\n");
      out.write("</script>\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div id=\"content\">\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("    ");
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
      out.write("\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"container\" id=\"baseinfo\">\r\n");
      out.write("    <div class=\"row\" style=\"margin-top: 10px;padding-top: 10px;padding-bottom: 20px\">\r\n");
      out.write("        <div class=\"col-sm-6\" style=\"margin-bottom:-20px;margin-top: -20px;\">\r\n");
      out.write("            <div class=\"panel panel-warning panel-base\">\r\n");
      out.write("                <div class=\"panel-heading panel-base-heading\">\r\n");
      out.write("                    <i class=\"glyphicon glyphicon-user\"></i> 会员信息\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"panel-body\" style=\"padding: 2px;\">\r\n");
      out.write("                    <table width=\"100%\" class=\"table-bordered table-striped table-condensed flip-content\" style=\"border: 1px solid #555555\">\r\n");
      out.write("                        <tbody>\r\n");
      out.write("                        <tr>\r\n");
      out.write("                            <td style=\"font-size: 10px\" class=\"tit\" width=\"21%\"><i class=\"glyphicon glyphicon-king\"></i> 会员级别</td>\r\n");
      out.write("                            <td style=\"text-align:center;font-size: 10px\" width=\"29%\">初级</td>\r\n");
      out.write("                            <td style=\"font-size: 10px\" class=\"tit\" width=\"21%\"><i class=\"glyphicon glyphicon-yen\"></i> 账户总值</td>\r\n");
      out.write("                            <td style=\"text-align:center;font-size: 10px\" width=\"29%\"><span id=\"AccountNickName\">29424</span> <!--<i class=\"icon-refresh\" id=\"todo\" style=\"color:red;\"></i>--></td>\r\n");
      out.write("                        </tr>\r\n");
      out.write("\r\n");
      out.write("                        <tr>\r\n");
      out.write("                            <td style=\"font-size: 10px\" class=\"tit\"><i class=\"glyphicon glyphicon-object-align-vertical\"></i> 直推人数</td>\r\n");
      out.write("                            <td style=\"text-align: center;font-size: 10px\">5</td>\r\n");
      out.write("                            <td style=\"font-size: 10px\" class=\"tit\"><i class=\"glyphicon glyphicon-align-justify\"></i> 团队人数</td>\r\n");
      out.write("                            <td style=\"text-align: center;font-size: 10px\">8</td>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                        <tr>\r\n");
      out.write("                            <td style=\"font-size: 10px\" class=\"tit\"><i class=\"glyphicon glyphicon-lock\"></i> 本息钱包</td>\r\n");
      out.write("                            <td style=\"text-align: center;font-size: 10px\">39150</td>\r\n");
      out.write("                            <td style=\"font-size: 10px\" class=\"tit\"><i class=\"glyphicon glyphicon-lock\"></i> 直推钱包</td>\r\n");
      out.write("                            <td style=\"text-align: center;font-size: 10px\">100</td>\r\n");
      out.write("                        </tr>\r\n");
      out.write("\r\n");
      out.write("                        <tr>\r\n");
      out.write("                            <td style=\"font-size: 10px\" class=\"tit\"><i class=\"glyphicon glyphicon-lock\"></i> 冻结钱包</td>\r\n");
      out.write("                            <td style=\"text-align: center;font-size: 10px\">600</td>\r\n");
      out.write("                            <td style=\"font-size: 10px\" class=\"tit\"><i class=\"glyphicon glyphicon-lock\"></i> 红包钱包</td>\r\n");
      out.write("                            <td style=\"text-align: center;font-size: 10px\">904</td>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                        <tr>\r\n");
      out.write("                            <td style=\"font-size: 10px\" class=\"tit\"><i class=\"glyphicon glyphicon-yen\"></i> 待返钱包</td>\r\n");
      out.write("                            <td style=\"text-align: center;font-size: 10px\">0</td>\r\n");
      out.write("                            <td style=\"font-size: 10px\" class=\"tit\"><i class=\"glyphicon glyphicon-yen\"></i> 激活资金</td>\r\n");
      out.write("                            <td style=\"text-align: center;font-size: 10px\">3963</td>\r\n");
      out.write("                        </tr>\r\n");
      out.write("\r\n");
      out.write("                        </tbody>\r\n");
      out.write("                    </table>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"col-sm-6\" style=\"margin-bottom:-20px;margin-top: -20px\">\r\n");
      out.write("            <div class=\"panel panel-warning panel-base\">\r\n");
      out.write("                <!-- Default panel contents -->\r\n");
      out.write("                <div class=\"panel-heading panel-base-heading\">\r\n");
      out.write("                    <i class=\"glyphicon glyphicon-comment\"></i> 新闻公告\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"panel-body\" style=\";padding: 2px;\">\r\n");
      out.write("                    <table width=\"100%\" class=\"table-bordered table-striped table-condensed flip-content\" style=\"border: 1px solid #555555\">\r\n");
      out.write("                        <tbody>\r\n");
      out.write("                        <tr>\r\n");
      out.write("                            <td class=\"tit\" colspan=\"4\" style=\"text-align: left;font-size: 10px\">\r\n");
      out.write("                                    <span style=\"color: #bbb;font-size: 10px;display: block;float: left;width: 80px; font-style: italic; margin-right: 10px\">\r\n");
      out.write("                                        2017-12-21\r\n");
      out.write("                                    </span>\r\n");
      out.write("                                <a href=\"https://www.vipzftaab.com/index/adList/?s=204\" style=\"color: #8a6d3b\">  <i class=\"icon-file-alt\"></i> 【留言咨询必看】</a>\r\n");
      out.write("                            </td>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                        <tr>\r\n");
      out.write("                            <td class=\"tit\" colspan=\"4\" style=\"text-align: left;font-size: 10px\">\r\n");
      out.write("                                    <span style=\"color: #bbb;font-size: 10px;display: block;float: left;width: 80px; font-style: italic; margin-right: 10px\">\r\n");
      out.write("                                        2018-01-10\r\n");
      out.write("                                    </span>\r\n");
      out.write("                                <a href=\"https://www.vipzftaab.com/index/adList/?s=222\" style=\"color: #8a6d3b\">  <i class=\"icon-file-alt\"></i> 【敬告】【警告】！！！</a>\r\n");
      out.write("                            </td>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                        <tr>\r\n");
      out.write("                            <td class=\"tit\" colspan=\"4\" style=\"text-align: left;font-size: 10px\">\r\n");
      out.write("                                    <span style=\"color: #bbb;font-size: 10px;display: block;float: left;width: 80px; font-style: italic; margin-right: 10px\">\r\n");
      out.write("                                        2018-01-06\r\n");
      out.write("                                    </span>\r\n");
      out.write("                                <a href=\"https://www.vipzftaab.com/index/adList/?s=221\" style=\"color: #8a6d3b\">  <i class=\"icon-file-alt\"></i> 【通知】</a>\r\n");
      out.write("                            </td>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                        <tr>\r\n");
      out.write("                            <td class=\"tit\" colspan=\"4\" style=\"text-align: left;font-size: 10px\">\r\n");
      out.write("                                    <span style=\"color: #bbb;font-size: 10px;display: block;float: left;width: 80px; font-style: italic; margin-right: 10px\">\r\n");
      out.write("                                        2018-01-04\r\n");
      out.write("                                    </span>\r\n");
      out.write("                                <a href=\"https://www.vipzftaab.com/index/adList/?s=220\" style=\"color: #8a6d3b\">  <i class=\"icon-file-alt\"></i> 【通知】</a>\r\n");
      out.write("                            </td>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                        <tr>\r\n");
      out.write("                            <td class=\"tit\" colspan=\"4\" style=\"text-align: left;font-size: 10px\">\r\n");
      out.write("                                    <span style=\"color: #bbb;font-size: 10px;display: block;float: left;width: 80px; font-style: italic; margin-right: 10px\">\r\n");
      out.write("                                        2018-01-01\r\n");
      out.write("                                    </span>\r\n");
      out.write("                                <a href=\"https://www.vipzftaab.com/index/adList/?s=217\" style=\"color: #8a6d3b\">  <i class=\"icon-file-alt\"></i> 【支付渠道网络故障】</a>\r\n");
      out.write("                            </td>\r\n");
      out.write("                        </tr>\r\n");
      out.write("\r\n");
      out.write("                        </tbody>\r\n");
      out.write("                    </table>\r\n");
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"container\" id=\"messagelist\">\r\n");
      out.write("    <div class=\"row\">\r\n");
      out.write("\r\n");
      out.write("        <div class=\"col-sm-1\"></div>\r\n");
      out.write("        <div class=\"col-sm-10\">\r\n");
      out.write("            <div class=\"col-sm-12\" style=\"background:rgba(250,250,250,0.5);padding-top: 20px\">\r\n");
      out.write("                <div class=\"alert alert-danger\" role=\"alert\">\r\n");
      out.write("                    说明：点击留言标题可查看客服回复！<br>\r\n");
      out.write("                    客服工作时间每日上午<strong>9:00</strong>-中午<strong>12:00</strong> 下午<strong>14:00</strong>-晚上<strong>21:00</strong><br>\r\n");
      out.write("                    1、针对不同问题的留言，处理回复的时间也有所不同，请耐心等待回复！<br>\r\n");
      out.write("                    2、同一问题不要重复提交多条留言，以免被系统刪除而全部得不到处理。<br>\r\n");
      out.write("                    3、如果问题您已自行处理好，那可以及时关闭留言！<br>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-lg-12\" style=\"text-align: center\">\r\n");
      out.write("                    暂无记录\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"col-sm-1\"></div>\r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<footer style=\"padding: 20px\">\r\n");
      out.write("    <p class=\"pull-right\" style=\"color: white\"><a href=\"#\">top</a></p>\r\n");
      out.write("    <p style=\"text-align: center; color: white\">Copyright © 2017 Smartpay.com All Rights Reversed.</p>\r\n");
      out.write("</footer>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script src=\"plug-in-ui/hplus/js/plugins/layer/layer.min.js\"></script>\r\n");
      out.write("<!-- 第三方插件 -->\r\n");
      out.write("<script src=\"plug-in-ui/hplus/js/plugins/pace/pace.min.js\"></script>\r\n");
      out.write("<!-- Sweet alert -->\r\n");
      out.write("<script src=\"plug-in-ui/hplus/js/plugins/sweetalert/sweetalert.min.js\"></script>\r\n");
      out.write("<script src=\"plug-in/jquery-plugs/storage/jquery.storageapi.min.js\"></script>\r\n");
      out.write("<!-- 弹出TAB -->\r\n");
      out.write("<script type=\"text/javascript\" src=\"plug-in/hplus/hplus-tab.js\"></script>\r\n");
      out.write("<!-- 在线聊天 -->\r\n");
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
