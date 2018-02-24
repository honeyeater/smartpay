package org.apache.jsp.webpage.smp.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class userInfoMain_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(7);
    _jspx_dependants.add("/context/mytags.jsp");
    _jspx_dependants.add("/webpage/webmain/head.jsp");
    _jspx_dependants.add("/webpage/webmain/operatorbar.jsp");
    _jspx_dependants.add("/webpage/smp/user/userinfoBase.jsp");
    _jspx_dependants.add("/webpage/smp/user/userinfo.jsp");
    _jspx_dependants.add("/webpage/webmain/foot.jsp");
    _jspx_dependants.add("/WEB-INF/tld/easyui.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
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

      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;

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
      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta http-equiv=\"x-ua-compatible\" content=\"IE=edge\">\n");
      out.write("    <meta name=\"viewport\"\n");
      out.write("          content=\"width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no\">\n");
      out.write("    <meta name=\"renderer\" content=\"webkit\">\n");
      out.write("    <title>金润理财</title>\n");
      out.write("    <meta name=\"keywords\" content=\"理财\">\n");
      out.write("    <meta name=\"description\" content=\"一家专门从事理财的交易网站\">\n");
      out.write("    <!--bootstrape-->\n");
      out.write("    <link href=\"plug-in/bootstrap3/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("    <link href=\"plug-in/webfront/css/common.css\" rel=\"stylesheet\">\n");
      out.write("    <script src=\"plug-in/ace/assets/js/jquery-2.0.3.min.js\"></script>\n");
      out.write("    <script src=\"plug-in/bootstrap3/js/bootstrap.min.js\"></script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write('\n');
      out.write("\n");
      out.write("<!--页面头部导航-->\n");
      out.write("<div id=\"header\">\n");
      out.write("    <nav class=\"navbar navbar-default navbar-fixed-top\" >\n");
      out.write("        <div class=\"container\" style=\"width: 90%;\">\n");
      out.write("            <div class=\"navbar-header\">\n");
      out.write("                <button type=\"button\" class=\"navbar-toggle collapsed\" data-toggle=\"collapse\"\n");
      out.write("                        data-target=\"#bs-example-navbar-collapse-1\" aria-expanded=\"false\">\n");
      out.write("                    <span class=\"sr-only\"></span>\n");
      out.write("                    <span class=\"icon-bar\"></span>\n");
      out.write("                    <span class=\"icon-bar\"></span>\n");
      out.write("                    <span class=\"icon-bar\"></span>\n");
      out.write("                </button>\n");
      out.write("                <a class=\"navbar-brand\" href=\"userLoginController.do?toIndex\" style=\"font-size: 24px;\">金润理财</a>\n");
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
      out.write("                    <li><a href=\"tSUserquestionController.do?toIssueList\">常见问题</a></li>\n");
      out.write("                    <li><a href=\"#\" onclick=\"logout();\">安全退出</a></li>\n");
      out.write("                    <li><a href=\"#\" class=\"dropdown\" data-toggle=\"dropdown\" aria-labelledby=\"\"\n");
      out.write("                           role=\"button\" aria-expanded=\"true\" aria-haspopup=\"true\">\n");
      out.write("                            ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentUser.userName}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\n");
      out.write("                        <input type=\"hidden\" id=\"currentUserId\" name=\"currentUserId\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentUser.id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\">\n");
      out.write("                        <input type=\"hidden\" id=\"currentUserName\" name=\"currentUserName\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentUser.userName}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\">\n");
      out.write("                    </a>\n");
      out.write("                        <ul class=\"dropdown-menu dropdown-menu-left\">\n");
      out.write("                            <li><a href=\"frontUserRegisterController.do?gouserinfo\">修改资料</a></li>\n");
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
      out.write("\n");
      out.write("\n");
      out.write("<div id=\"content\">\n");
      out.write("    ");
      out.write("\n");
      out.write("    ");
      out.write("\n");
      out.write("\n");
      out.write("<div class=\"container\" id=\"operatorbar\">\n");
      out.write("    <div class=\"row\" style=\"padding-top: 10px;color: white\">\n");
      out.write("        <div class=\"col-lg-4\">\n");
      out.write("            <div class=\"col-sm-4 col-xs-4\" style=\"text-align: center\">\n");
      out.write("                <a href=\"orderInjectInfoController.do?toInjectList\">\n");
      out.write("                    <img class=\"img-circle navImg\" src=\"plug-in/webfront/images/inject.png\"></a>\n");
      out.write("                <h5><strong>注资列表</strong></h5>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-sm-4 col-xs-4\" style=\"text-align: center\">\n");
      out.write("                <a href=\"orderDrawInfoController.do?toDrawList\">\n");
      out.write("                    <img class=\"img-circle navImg\" src=\"plug-in/webfront/images/draw.png\">\n");
      out.write("                </a>\n");
      out.write("                <h5><strong>提现列表</strong></h5>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-sm-4 col-xs-4\" style=\"text-align: center\">\n");
      out.write("                <a href=\"orderInjectInfoController.do?tofinancelist\">\n");
      out.write("                    <img class=\"img-circle navImg\" src=\"plug-in/webfront/images/trad.png\"></a>\n");
      out.write("                <h5><strong>财务明细</strong></h5>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"col-lg-4\">\n");
      out.write("            <div class=\"col-sm-4 col-xs-4\" style=\"text-align: center\">\n");
      out.write("                <a href=\"frontUserRegisterController.do?tousergeneral\">\n");
      out.write("                    <img class=\"img-circle navImg\" src=\"plug-in/webfront/images/regist.png\"></a>\n");
      out.write("                <h5><strong>注册会员</strong></h5>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-sm-4 col-xs-4\" style=\"text-align: center\">\n");
      out.write("                <a href=\"frontUserMemberController.do?toMemberShip\">\n");
      out.write("                    <img class=\"img-circle navImg\" src=\"plug-in/webfront/images/ship.png\"></a>\n");
      out.write("                <h5><strong>推荐列表</strong></h5>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-sm-4 col-xs-4\" style=\"text-align: center\">\n");
      out.write("                <a href=\"orderInjectInfoController.do?toTeamList\">\n");
      out.write("                    <img class=\"img-circle navImg\" src=\"plug-in/webfront/images/team.png\"></a>\n");
      out.write("                <h5><strong>团队业绩</strong></h5>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"col-lg-4\">\n");
      out.write("            <div class=\"col-sm-4 col-xs-4\" style=\"text-align: center\">\n");
      out.write("                <a href=\"frontUserActivatecodeController.do?activatecode\">\n");
      out.write("                    <img class=\"img-circle navImg\" src=\"plug-in/webfront/images/activate.png\"></a>\n");
      out.write("                <h5><strong>激活码管理</strong></h5>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-sm-4 col-xs-4\" style=\"text-align: center\">\n");
      out.write("                <a href=\"tSFeedbackController.do?toFeedback\">\n");
      out.write("                    <img class=\"img-circle navImg\" src=\"plug-in/webfront/images/pro.png\"></a>\n");
      out.write("                <h5><strong>问题反馈</strong></h5>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-sm-4 col-xs-4\" style=\"text-align: center\">\n");
      out.write("                <a href=\"tSUsernoticeController.do?toNoticeList\">\n");
      out.write("                    <img class=\"img-circle navImg\" src=\"plug-in/webfront/images/notice.png\"></a>\n");
      out.write("                <h5><strong>新闻公告</strong></h5>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("    ");
      out.write("\n");
      out.write("        ");
      out.write("\n");
      out.write("            ");
      out.write("\n");
      out.write("        ");
      out.write("\n");
      out.write("    ");
      out.write('\n');
      out.write('\n');
      out.write("\n");
      out.write("    ");
      out.write("\n");
      out.write("    ");
      out.write("\n");
      out.write("\n");
      out.write("<div class=\"container\" id=\"baseinfo\">\n");
      out.write("    <div class=\"row\" style=\"margin-top: 10px;padding-top: 10px;padding-bottom: 20px\">\n");
      out.write("        <div class=\"col-sm-6\" style=\"margin-bottom:-20px;margin-top: -20px;\">\n");
      out.write("            <div class=\"panel panel-warning panel-base\">\n");
      out.write("                <div class=\"panel-heading panel-base-heading\">\n");
      out.write("                    <i class=\"glyphicon glyphicon-user\"></i> 会员信息\n");
      out.write("                </div>\n");
      out.write("                <input type=\"hidden\" name=\"validFlag\" id=\"validFlag\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${frontUser.validFlag}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\">\n");
      out.write("                <div class=\"panel-body\" style=\"padding: 2px;\">\n");
      out.write("                    <table width=\"100%\" class=\"table-bordered table-striped table-condensed flip-content\" style=\"border: 1px solid #555555\">\n");
      out.write("                        <tbody>\n");
      out.write("                        <tr>\n");
      out.write("                            <td style=\"font-size: 10px\" class=\"tit\" width=\"21%\"><i class=\"glyphicon glyphicon-king\"></i> 会员级别</td>\n");
      out.write("                            <td style=\"text-align:center;font-size: 10px\" width=\"29%\">\n");
      out.write("                                ");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                                ");
      if (_jspx_meth_c_005fif_005f1(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                                ");
      if (_jspx_meth_c_005fif_005f2(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                                ");
      if (_jspx_meth_c_005fif_005f3(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\n");
      out.write("                            </td>\n");
      out.write("                            <td style=\"font-size: 10px\" class=\"tit\" width=\"21%\"><i class=\"glyphicon glyphicon-yen\"></i> 账户总值</td>\n");
      out.write("                            <td style=\"text-align:center;font-size: 10px\" width=\"29%\"><span id=\"AccountNickName\">\n");
      out.write("                                ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${userMember.sumAmount}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\n");
      out.write("                            </span> <!--<i class=\"icon-refresh\" id=\"todo\" style=\"color:red;\"></i>--></td>\n");
      out.write("                        </tr>\n");
      out.write("\n");
      out.write("                        <tr>\n");
      out.write("                            <td style=\"font-size: 10px\" class=\"tit\"><i class=\"glyphicon glyphicon-object-align-vertical\"></i> 直推人数</td>\n");
      out.write("                            <td style=\"text-align: center;font-size: 10px\">\n");
      out.write("                                ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${userMember.introNums}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\n");
      out.write("                            </td>\n");
      out.write("                            <td style=\"font-size: 10px\" class=\"tit\"><i class=\"glyphicon glyphicon-align-justify\"></i> 团队人数</td>\n");
      out.write("                            <td style=\"text-align: center;font-size: 10px\">\n");
      out.write("                                ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${userMember.teamNums}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td style=\"font-size: 10px\" class=\"tit\"><i class=\"glyphicon glyphicon-lock\"></i> 本息钱包</td>\n");
      out.write("                            <td style=\"text-align: center;font-size: 10px\">\n");
      out.write("                                ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${userMember.couponWallet}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\n");
      out.write("                            </td>\n");
      out.write("                            <td style=\"font-size: 10px\" class=\"tit\"><i class=\"glyphicon glyphicon-lock\"></i> 直推钱包</td>\n");
      out.write("                            <td style=\"text-align: center;font-size: 10px\">\n");
      out.write("                                ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${userMember.introWallet}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\n");
      out.write("\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("\n");
      out.write("                        <tr>\n");
      out.write("                            <td style=\"font-size: 10px\" class=\"tit\"><i class=\"glyphicon glyphicon-lock\"></i> 冻结钱包</td>\n");
      out.write("                            <td style=\"text-align: center;font-size: 10px\">\n");
      out.write("                                ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${userMember.blockWallet}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\n");
      out.write("                            </td>\n");
      out.write("                            <td style=\"font-size: 10px\" class=\"tit\"><i class=\"glyphicon glyphicon-lock\"></i> 红包钱包</td>\n");
      out.write("                            <td style=\"text-align: center;font-size: 10px\">\n");
      out.write("                                ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${userMember.redWallet}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td style=\"font-size: 10px\" class=\"tit\"><i class=\"glyphicon glyphicon-yen\"></i> 待返钱包</td>\n");
      out.write("                            <td style=\"text-align: center;font-size: 10px\">\n");
      out.write("                                ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${userMember.backWallet}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\n");
      out.write("                            </td>\n");
      out.write("                            <td style=\"font-size: 10px\" class=\"tit\"><i class=\"glyphicon glyphicon-yen\"></i> 激活资金</td>\n");
      out.write("                            <td style=\"text-align: center;font-size: 10px\">\n");
      out.write("                                ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${userMember.activeCost}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("\n");
      out.write("                        </tbody>\n");
      out.write("                    </table>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"col-sm-6\" style=\"margin-bottom:-20px;margin-top: -20px\">\n");
      out.write("            <div class=\"panel panel-warning panel-base\">\n");
      out.write("                <!-- Default panel contents -->\n");
      out.write("                <div class=\"panel-heading panel-base-heading\">\n");
      out.write("                    <i class=\"glyphicon glyphicon-comment\"></i> 新闻公告\n");
      out.write("                </div>\n");
      out.write("                <div class=\"panel-body\" style=\";padding: 2px;\">\n");
      out.write("                    <table width=\"100%\" class=\"table-bordered table-striped table-condensed flip-content\" style=\"border: 1px solid #555555\">\n");
      out.write("                        <tbody>\n");
      out.write("                            ");
      if (_jspx_meth_c_005fif_005f4(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                        </tbody>\n");
      out.write("                    </table>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("    $(function() {\n");
      out.write("       var validFlag = $(\"#validFlag\").val();\n");
      out.write("        if(validFlag != \"1\") {\n");
      out.write("            layer.alert(\"用户被冻结,请联系管理员购买激活码激活账户!\", {\n");
      out.write("               offset:'25%',\n");
      out.write("                closeBtn: 0\n");
      out.write("            });\n");
      out.write("        }\n");
      out.write("    });\n");
      out.write("</script>");
      out.write("\n");
      out.write("    ");
      out.write("\n");
      out.write("    ");
      out.write("\n");
      out.write("\n");
      out.write("<div class=\"container\" id=\"userinfo\">\n");
      out.write("    <div class=\"row\" style=\"margin-top: 20px\">\n");
      out.write("        <div class=\"col-sm-1\"></div>\n");
      out.write("        <div class=\"col-sm-10\">\n");
      out.write("            <div class=\"panel panel-warning\">\n");
      out.write("                <div class=\"panel-heading\">\n");
      out.write("                    <h3 class=\"panel-title\">账户信息</h3>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"panel-body\" style=\"min-height: 450px\">\n");
      out.write("                    <div class=\"col-sm-12\">\n");
      out.write("                        <ul class=\"list-group\">\n");
      out.write("                            <li class=\"list-group-item\">用户名：");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${userinfo.userName}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</li>\n");
      out.write("                            <li class=\"list-group-item\">推荐人：");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${userinfo.introducer}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</li>\n");
      out.write("                            <li class=\"list-group-item\">真实名：");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${userinfo.realname}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</li>\n");
      out.write("                            <li class=\"list-group-item\">手机号：");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${userinfo.phoneno}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</li>\n");
      out.write("                            <li class=\"list-group-item\">身份证：");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${userinfo.identityNo}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</li>\n");
      out.write("                            <li class=\"list-group-item\">银行卡：");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${userinfo.bankCard}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</li>\n");
      out.write("                            <li class=\"list-group-item\">开户行省市：");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${userinfo.province}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write('-');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${userinfo.city}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</li>\n");
      out.write("                            <li class=\"list-group-item\">开户行详址：");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${userinfo.bankAddress}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</li>\n");
      out.write("                            <li class=\"list-group-item\">开户行名称：");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${userinfo.bankCode}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"col-sm-1\"></div>\n");
      out.write("        <div class=\"col-sm-12\" style=\"text-align: center\">\n");
      out.write("            <button type=\"button\" class=\"btn btn-primary\" onclick=\"editUser()\">修改资料</button>\n");
      out.write("            <button type=\"button\" class=\"btn btn-primary\" data-toggle=\"modal\" data-target=\"#changeInfo\" id=\"editUser\" style=\"display: none\">修改资料</button>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<div class=\"modal fade\" id=\"changeInfo\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"changeInfo\" style=\"display: none;\">\n");
      out.write("    <div class=\"modal-dialog\" role=\"document\">\n");
      out.write("        <div class=\"modal-content\">\n");
      out.write("            <div class=\"modal-header\">\n");
      out.write("                <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>\n");
      out.write("                <h4 class=\"modal-title\" id=\"changeInfoLabel\">修改资料</h4>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"modal-body\">\n");
      out.write("                <form method=\"post\" id=\"changeInfoFrom\">\n");
      out.write("                    <input type=\"hidden\" id=\"userInfoId\" name=\"userInfoId\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${userinfo.id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\">\n");
      out.write("                    <div data-toggle=\"distpicker\">\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label class=\"control-label\" for=\"province\">银行省份:</label>\n");
      out.write("                            <select class=\"form-control\" id=\"province\" name=\"province\"></select>\n");
      out.write("                            <input type=\"hidden\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${userinfo.province}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" name=\"province1\" id=\"province1\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label class=\"control-label\" for=\"city\">银行城市:</label>\n");
      out.write("                            <select class=\"form-control\" id=\"city\" name=\"city\"></select>\n");
      out.write("                            <input type=\"hidden\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${userinfo.city}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" name=\"city1\" id=\"city1\">\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <label class=\"control-label\" for=\"bankAddress\">银行详细地址:</label>\n");
      out.write("                        <input class=\"form-control\" id=\"bankAddress\" name=\"bankAddress\" type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${userinfo.bankAddress}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\">\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <input type=\"hidden\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${userinfo.bankCode}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" name=\"bankCode1\" id=\"bankCode1\">\n");
      out.write("                        <label class=\"control-label\" for=\"bankCode\">开户银行:</label>\n");
      out.write("                        <select id=\"bankCode\" name=\"bankCode\" class=\"form-control\">\n");
      out.write("                                <option></option>\n");
      out.write("                                <option value=\"中国人民银行\">中国人民银行</option>\n");
      out.write("                                <option value=\"中国工商银行\">中国工商银行</option>\n");
      out.write("                                <option value=\"中国工商银行\">中国工商银行</option>\n");
      out.write("                                <option value=\"中国银行\">中国银行</option>\n");
      out.write("                                <option value=\"中国建设银行\">中国建设银行</option>\n");
      out.write("                                <option value=\"中国进出口银行\">中国进出口银行</option>\n");
      out.write("                                <option value=\"交通银行\">交通银行</option>\n");
      out.write("                                <option value=\"中信银行\">中信银行</option>\n");
      out.write("                                <option value=\"中国光大银行\">中国光大银行</option>\n");
      out.write("                                <option value=\"华夏银行\">华夏银行</option>\n");
      out.write("                                <option value=\"中国民生银行\">中国民生银行</option>\n");
      out.write("                                <option value=\"广东发展银行\">广东发展银行</option>\n");
      out.write("                                <option value=\"深圳发展银行\">深圳发展银行</option>\n");
      out.write("                                <option value=\"招商银行\">招商银行</option>\n");
      out.write("                                <option value=\"兴业银行\">兴业银行</option>\n");
      out.write("                                <option value=\"农村商业银行\">农村商业</option>\n");
      out.write("                                <option value=\"恒丰银行\">恒丰银行</option>\n");
      out.write("                                <option value=\"浙商银行\">浙商银行</option>\n");
      out.write("                                <option value=\"农村合作银行\">农村合作银行</option>\n");
      out.write("                                <option value=\"渤海银行\">渤海银行</option>\n");
      out.write("                                <option value=\"徽商银行\">徽商银行</option>\n");
      out.write("                                <option value=\"城市信用社\">城市信用社</option>\n");
      out.write("                                <option value=\"农村信用联社\">农村信用联社</option>\n");
      out.write("                                <option value=\"中国邮政储蓄银行\">中国邮政储蓄银行</option>\n");
      out.write("                                <option value=\"恒生银行\">恒生银行</option>\n");
      out.write("                                <option value=\"平安银行\">平安银行</option>\n");
      out.write("                                <option value=\"华商银行\">华商银行</option>\n");
      out.write("                                <option value=\"青岛国际银行\">青岛国际银行</option>\n");
      out.write("                                <option value=\"华一银行\">华一银行</option>\n");
      out.write("                                <option value=\"宁波银行\">宁波银行</option>\n");
      out.write("                                <option value=\"杭州银行\">杭州银行</option>\n");
      out.write("                                <option value=\"深圳农村银行\">深圳农村银行</option>\n");
      out.write("                                <option value=\"南京银行\">南京银行</option>\n");
      out.write("                                <option value=\"上海银行\">上海银行</option>\n");
      out.write("                                <option value=\"北京银行\">北京银行</option>\n");
      out.write("                                <option value=\"齐鲁银行\">齐鲁银行</option>\n");
      out.write("                                <option value=\"成都银行\">成都银行</option>\n");
      out.write("                                <option value=\"烟台银行\">烟台银行</option>\n");
      out.write("                                <option value=\"河北银行\">河北银行</option>\n");
      out.write("                                <option value=\"湖北银行\">湖北银行</option>\n");
      out.write("                                <option value=\"天津银行\">天津银行</option>\n");
      out.write("                                <option value=\"大连银行\">大连银行</option>\n");
      out.write("                                <option value=\"重庆银行\">重庆银行</option>\n");
      out.write("                                <option value=\"东莞银行\">东莞银行</option>\n");
      out.write("                                <option value=\"哈尔滨银行\">哈尔滨银行</option>\n");
      out.write("                                <option value=\"包商银行\">包商银行</option>\n");
      out.write("                                <option value=\"南昌银行\">南昌银行</option>\n");
      out.write("                                <option value=\"兰州银行\">兰州银行</option>\n");
      out.write("                                <option value=\"青岛银行\">青岛银行</option>\n");
      out.write("                                <option value=\"齐商银行\">齐商银行</option>\n");
      out.write("                                <option value=\"温州银行\">温州银行</option>\n");
      out.write("                                <option value=\"宁夏银行\">宁夏银行</option>\n");
      out.write("                                <option value=\"临商银行\">临商银行</option>\n");
      out.write("                                <option value=\"富滇银行\">富滇银行</option>\n");
      out.write("                                <option value=\"长沙银行\">长沙银行</option>\n");
      out.write("                            </select>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <label class=\"control-label\" for=\"bankCard\">银行卡号:</label>\n");
      out.write("                        <input id=\"bankCard\" name=\"bankCard\" type=\"text\"  class=\"form-control\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${userinfo.bankCard}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <label class=\"control-label\" for=\"randcode\">验证码</label>\n");
      out.write("                        <div class=\"input-group\" style=\"width: 100%;\">\n");
      out.write("                            <input type=\"text\" class=\"form-control\" placeholder=\"验证码\" aria-describedby=\"basic-addon2\" name=\"randcode\" id=\"randcode\">\n");
      out.write("                                <span class=\"input-group-addon\" id=\"basic-addon-in\" style=\"width: 80px;padding:0px\">\n");
      out.write("                                    <img id=\"codeImg\" alt=\"看不清?点击切换\" src=\"randCodeImage\" style=\"width: 80px;height: 32px;\">\n");
      out.write("                                </span>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <label class=\"control-label\" for=\"saftPassword\">安全密码</label>\n");
      out.write("                        <input class=\"form-control\" id=\"saftPassword\" name=\"saftPassword\" type=\"password\" value=\"\" required=\"\">\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"alert alert-danger\" role=\"alert\">\n");
      out.write("                        <strong>温馨提示：</strong>修改资料请留言联系管理员!\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-actions\">\n");
      out.write("                        <button id=\"changerInfoSave\" class=\"btn btn-primary btn-block\" onclick=\"return validateCallback();\">确定</button>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("<script src=\"plug-in/webfront/js/address/distpicker.data.js\"></script>\n");
      out.write("<script src=\"plug-in/webfront/js/address/distpicker.js\"></script>\n");
      out.write("<script src=\"plug-in/webfront/js/address/main.js\"></script>\n");
      out.write("\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("    function editUser() {\n");
      out.write("        $(\"#editUser\").click();\n");
      out.write("        $(\"#bankCode\").val($(\"#bankCode1\").val());\n");
      out.write("        $(\"#province\").val($(\"#province1\").val());\n");
      out.write("        $(\"#province\").onclick();\n");
      out.write("        $(\"#city\").val($(\"#city1\").val());\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    function validateCallback(form, callback, confirmMsg) {\n");
      out.write("        var $form = $(form);\n");
      out.write("        // 提交信息\n");
      out.write("        var url=\"frontUserRegisterController.do?doUpdate\";\n");
      out.write("        var fromData = $('#changeInfoFrom').serialize();\n");
      out.write("        $.ajax({\n");
      out.write("            cache: false,\n");
      out.write("            async : false,\n");
      out.write("            type : 'POST',\n");
      out.write("            url : url,// 请求的action路径\n");
      out.write("            data : fromData,\n");
      out.write("            error : function() {// 请求失败处理函数\n");
      out.write("                alert(\"服务器异常,请稍后重试!\");\n");
      out.write("            },\n");
      out.write("            success : function(data) {\n");
      out.write("                var d = $.parseJSON(data);\n");
      out.write("                if (d.success) {\n");
      out.write("                    layer.alert(\n");
      out.write("                        d.msg,\n");
      out.write("                        {\n");
      out.write("                            offset: '240px',\n");
      out.write("                            closeBtn: 0\n");
      out.write("                        },\n");
      out.write("                        function(){\n");
      out.write("                            location.href=\"frontUserRegisterController.do?gouserinfo\";\n");
      out.write("                        }\n");
      out.write("                    );\n");
      out.write("                } else {\n");
      out.write("                    layer.alert(d.msg);\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        });\n");
      out.write("        return false;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<footer style=\"padding: 20px\">\n");
      out.write("    <p class=\"pull-right\" style=\"color: white\"><a href=\"#\">top</a></p>\n");
      out.write("    <p style=\"text-align: center; color: white\">Copyright © 2017 Smartpay.com All Rights Reversed.</p>\n");
      out.write("</footer>\n");
      out.write("\n");
      out.write("\n");
      out.write("<script src=\"plug-in-ui/hplus/js/plugins/layer/layer.min.js\"></script>\n");
      out.write("<!-- 第三方插件 -->\n");
      out.write("<script src=\"plug-in-ui/hplus/js/plugins/pace/pace.min.js\"></script>\n");
      out.write("<!-- Sweet alert -->\n");
      out.write("<script src=\"plug-in-ui/hplus/js/plugins/sweetalert/sweetalert.min.js\"></script>\n");
      out.write("<script src=\"plug-in/jquery-plugs/storage/jquery.storageapi.min.js\"></script>\n");
      out.write("<!-- 弹出TAB -->\n");
      out.write("<script type=\"text/javascript\" src=\"plug-in/hplus/hplus-tab.js\"></script>\n");
      out.write("<!-- 在线聊天 -->\n");
      out.write("\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("</html>\n");
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

  private boolean _jspx_meth_c_005fif_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f0.setParent(null);
    // /webpage/smp/user/userinfoBase.jsp(17,32) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${userMember.userLevel == '1'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
    if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                    普通\n");
        out.write("                                ");
        int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f1.setParent(null);
    // /webpage/smp/user/userinfoBase.jsp(20,32) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${userMember.userLevel == '2'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f1 = _jspx_th_c_005fif_005f1.doStartTag();
    if (_jspx_eval_c_005fif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                    中级\n");
        out.write("                                ");
        int evalDoAfterBody = _jspx_th_c_005fif_005f1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f2 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f2.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f2.setParent(null);
    // /webpage/smp/user/userinfoBase.jsp(23,32) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${userMember.userLevel == '3'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f2 = _jspx_th_c_005fif_005f2.doStartTag();
    if (_jspx_eval_c_005fif_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                    高级\n");
        out.write("                                ");
        int evalDoAfterBody = _jspx_th_c_005fif_005f2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f2);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f3 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f3.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f3.setParent(null);
    // /webpage/smp/user/userinfoBase.jsp(26,32) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f3.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${userMember.userLevel == '4'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f3 = _jspx_th_c_005fif_005f3.doStartTag();
    if (_jspx_eval_c_005fif_005f3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                    VIP\n");
        out.write("                                ");
        int evalDoAfterBody = _jspx_th_c_005fif_005f3.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f3);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f4(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f4 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f4.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f4.setParent(null);
    // /webpage/smp/user/userinfoBase.jsp(94,28) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f4.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${not empty userNotices}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f4 = _jspx_th_c_005fif_005f4.doStartTag();
    if (_jspx_eval_c_005fif_005f4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                ");
        if (_jspx_meth_c_005fforEach_005f0(_jspx_th_c_005fif_005f4, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("                            ");
        int evalDoAfterBody = _jspx_th_c_005fif_005f4.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f4);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f4);
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f4, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f4);
    // /webpage/smp/user/userinfoBase.jsp(95,32) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/webpage/smp/user/userinfoBase.jsp(95,32) '${userNotices}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${userNotices}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    // /webpage/smp/user/userinfoBase.jsp(95,32) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("userNotice");
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                                    <tr>\n");
          out.write("                                        <td class=\"tit\" colspan=\"4\" style=\"text-align: left;font-size: 10px\">\n");
          out.write("                                        <span style=\"color: #bbb;font-size: 10px;display: block;float: left;width: 40%; font-style: italic; margin-right: 10px\">\n");
          out.write("                                            ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${userNotice.createTime}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\n");
          out.write("                                        </span>\n");
          out.write("                                            <a href=\"tSUsernoticeController.do?toNoticeList\" style=\"color: #8a6d3b\">  <i class=\"icon-file-alt\"></i> ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${userNotice.noticeTitle}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("</a>\n");
          out.write("                                        </td>\n");
          out.write("                                    </tr>\n");
          out.write("                                ");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f0.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
    }
    return false;
  }
}
