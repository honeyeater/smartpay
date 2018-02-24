package org.apache.jsp.webpage.webfront;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.jeecgframework.core.util.SysThemesUtil;
import org.jeecgframework.core.enums.SysThemesEnum;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(2);
    _jspx_dependants.add("/context/mytags.jsp");
    _jspx_dependants.add("/WEB-INF/tld/easyui.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005ft_005fmutiLang_0026_005flangKey_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005ft_005fmutiLang_0026_005flangKey_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005ft_005fmutiLang_0026_005flangKey_005fnobody.release();
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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\n');
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
      out.write('\n');

    session.setAttribute("lang","zh-cn");
    SysThemesEnum sysTheme = SysThemesUtil.getSysTheme(request);
    String lhgdialogTheme = SysThemesUtil.getLhgdialogTheme(sysTheme);

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\" />\n");
      out.write("    <meta charset=\"utf-8\" />\n");
      out.write("    <title>");
      if (_jspx_meth_t_005fmutiLang_005f0(_jspx_page_context))
        return;
      out.write("</title>\n");
      out.write("    <link rel=\"shortcut icon\" href=\"images/favicon.ico\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0\" />\n");
      out.write("    <!-- bootstrap & fontawesome -->\n");
      out.write("    <link rel=\"stylesheet\" href=\"plug-in/ace/css/bootstrap.css\" />\n");
      out.write("    <link rel=\"stylesheet\" href=\"plug-in/ace/css/font-awesome.css\" />\n");
      out.write("    ");
      out.write("\n");
      out.write("    <!-- text fonts -->\n");
      out.write("    <link rel=\"stylesheet\" href=\"plug-in/ace/css/ace-fonts.css\" />\n");
      out.write("\n");
      out.write("    <link rel=\"stylesheet\" href=\"plug-in/ace/css/jquery-ui.css\" />\n");
      out.write("    <!-- ace styles -->\n");
      out.write("    <link rel=\"stylesheet\" href=\"plug-in/ace/css/acefront.css\" class=\"ace-main-stylesheet\" id=\"main-ace-style\" />\n");
      out.write("    <!--[if lte IE 9]>\n");
      out.write("    <link rel=\"stylesheet\" href=\"plug-in/ace/css/ace-part2.css\" class=\"ace-main-stylesheet\" />\n");
      out.write("    <![endif]-->\n");
      out.write("\n");
      out.write("    <!--[if lte IE 9]>\n");
      out.write("    <link rel=\"stylesheet\" href=\"plug-in/ace/css/ace-ie.css\" />\n");
      out.write("    <![endif]-->\n");
      out.write("    <!-- ace settings handler -->\n");
      out.write("    <script src=\"plug-in/ace/js/ace-extra.js\"></script>\n");
      out.write("\n");
      out.write("    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->\n");
      out.write("\n");
      out.write("    <!--[if lte IE 8]>\n");
      out.write("    <script src=\"plug-in/ace/js/html5shiv.js\"></script>\n");
      out.write("    <script src=\"plug-in/ace/js/respond.js\"></script>\n");
      out.write("    <![endif]-->\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body class=\"login-layout light-login\">\n");
      out.write("<div class=\"main-container\">\n");
      out.write("    <div class=\"main-content\">\n");
      out.write("        <div class=\"row\">\n");
      out.write("            <div class=\"col-sm-8 col-sm-offset-2\">\n");
      out.write("                <div class=\"login-container top-content\">\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"text\">\n");
      out.write("                            <h1><strong>金润智能理财系统</strong></h1>\n");
      out.write("                            <div class=\"description\">\n");
      out.write("                                <p>\n");
      out.write("                                    您可以放心参与的智能理财社区\n");
      out.write("                                </p>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"space-6\"></div>\n");
      out.write("                    <div class=\"position-relative col-sm-6 col-sm-offset-3\">\n");
      out.write("                        <div id=\"login-box\" class=\"login-box visible widget-box no-border\" >\n");
      out.write("                            <div class=\"widget-body\">\n");
      out.write("                                <form id=\"loinForm\" class=\"form-horizontal\" method=\"post\">\n");
      out.write("                                    <input type=\"hidden\" id=\"ReturnURL\"  name=\"ReturnURL\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ReturnURL }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/>\n");
      out.write("                                    <div class=\"widget-main\">\n");
      out.write("                                        <div class=\"form-top\">\n");
      out.write("                                            <div class=\"form-top-left\">\n");
      out.write("                                                <h4 class=\"header white lighter bigger\">\n");
      out.write("                                                    用户登录\n");
      out.write("                                                </h4>\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"form-top-right\">\n");
      out.write("                                                <i class=\"fa fa-lock\"></i>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"space-6\"></div>\n");
      out.write("                                        <label class=\"block clearfix\">\n");
      out.write("\t\t\t\t\t\t\t\t<span class=\"block input-icon input-icon-right\">\n");
      out.write("                                    <input type=\"text\"  name=\"userName\" iscookie=\"true\" class=\"form-control\" placeholder=\"请输入用户名\"  id=\"userName\" value=\"\"/>\n");
      out.write("\t\t\t\t\t\t\t\t\t");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t\t</span>\n");
      out.write("                                        </label>\n");
      out.write("                                        <label class=\"block clearfix\">\n");
      out.write("\t\t\t\t\t\t\t\t<span class=\"block input-icon input-icon-right\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"password\" name=\"password\" class=\"form-control \" placeholder=\"请输入密码\" id=\"password\" value=\"\"/>\n");
      out.write("\t\t\t\t\t\t\t\t\t");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t\t</span>\n");
      out.write("                                        </label>\n");
      out.write("                                        <label class=\"block clearfix\">\n");
      out.write("                                            <div class=\"input-group\">\n");
      out.write("                                                <input type=\"text\" style=\"width: 98%;-moz-border-radius: 4px; -webkit-border-radius: 4px; border-radius: 4px;\" name=\"randCode\" class=\"form-control\" placeholder=\"请输入验证码\"  id=\"randCode\"/>\n");
      out.write("                                                <span class=\"input-group-addon\" style=\"padding: 0px;\"><img id=\"randCodeImage\" src=\"randCodeImage\"  /></span>\n");
      out.write("                                            </div>\n");
      out.write("                                        </label>\n");
      out.write("                                        <div class=\"clearfix\">\n");
      out.write("                                            <label class=\"inline\">\n");
      out.write("                                                <input type=\"checkbox\" class=\"ace\" id=\"on_off\"  name=\"remember\" value=\"yes\"/>\n");
      out.write("                                                <span class=\"lbl white\">&nbsp;记住用户名</span>\n");
      out.write("                                            </label>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"clearfix\">\n");
      out.write("                                            <button type=\"button\" id=\"but_login\" style=\"width: 100%;\" onclick=\"checkUser()\" class=\"pull-right btn  btn-primary\">\n");
      out.write("                                                <i class=\"ace-icon fa fa-key\"></i>\n");
      out.write("                                                <span class=\"bigger-222\" >登录</span>\n");
      out.write("                                            </button>\n");
      out.write("                                        </div>\n");
      out.write("\n");
      out.write("                                        <div class=\"clearfix\">\n");
      out.write("                                            <div style=\"float: right;margin-right: 10px;\">\n");
      out.write("                                                <label class=\"inline\">\n");
      out.write("                                <span class=\"lbl white\">&nbsp; <a href=\"frontUserRegisterController.do?goForget\" class=\"forgot-password-link\">\n");
      out.write("                                忘记密码</a></span>\n");
      out.write("\n");
      out.write("                                                </label>\n");
      out.write("                                                <i class=\"fa fa-question\" style=\"color: white\"></i>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("\n");
      out.write("                                        <div class=\"space-4\"></div>\n");
      out.write("                                        <div class=\"align-center alert alert-danger alert-dismissible\" role=\"alert\" id=\"errMsgContiner\">\n");
      out.write("                                            <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>\n");
      out.write("                                            <div id=\"showErrMsg\"></div>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("\n");
      out.write("                                </form>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<script type=\"text/javascript\" src=\"plug-in/jquery/jquery-1.8.3.min.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"plug-in/jquery/jquery.cookie.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"plug-in/mutiLang/en.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"plug-in/mutiLang/zh-cn.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"plug-in/login/js/jquery.tipsy.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"plug-in/login/js/iphone.check.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"plug-in/jquery-plugs/backstretch/jquery.backstretch.min.js\"></script>\n");
      out.write("<!-- add-begin--Author:gengjiajia  Date:20160727 for:TASK #1217 【IE兼容】jeecg h+首页兼容性问题,不兼容的浏览器直接切换套shortcut风格 -->\n");
      out.write("<script type=\"text/javascript\" src=\"webpage/webfront/js/login.js\"></script>\n");
      out.write("<!-- add-end--Author:gengjiajia  Date:20160727 for:TASK #1217 【IE兼容】jeecg h+首页兼容性问题,不兼容的浏览器直接切换套shortcut风格 -->\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("    $(function(){\n");
      out.write("        optErrMsg();\n");
      out.write("//        blurStyle();\n");
      out.write("        //设置背景\n");
      out.write("        $.backstretch(\"plug-in/assets/img/background.jpg\");\n");
      out.write("    });\n");
      out.write("    $(\"#errMsgContiner\").hide();\n");
      out.write("    function optErrMsg(){\n");
      out.write("        $(\"#showErrMsg\").html('');\n");
      out.write("        $(\"#errMsgContiner\").hide();\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    //输入验证码，回车登录\n");
      out.write("    $(document).keydown(function(e){\n");
      out.write("        if(e.keyCode == 13) {\n");
      out.write("            setTimeout(\"$('#but_login').click()\",\"100\");\n");
      out.write("        }\n");
      out.write("    });\n");
      out.write("\n");
      out.write("    //验证用户信息\n");
      out.write("    function checkUser(){\n");
      out.write("        if(!validForm()){\n");
      out.write("            return false;\n");
      out.write("        }\n");
      out.write("        newLogin();\n");
      out.write("    }\n");
      out.write("    //表单验证\n");
      out.write("    function validForm(){\n");
      out.write("        if($.trim($(\"#userName\").val()).length==0){\n");
      out.write("            showErrorMsg(\"请输入用户名\");\n");
      out.write("            return false;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        if($.trim($(\"#password\").val()).length==0){\n");
      out.write("            showErrorMsg(\"请输入密码\");\n");
      out.write("            return false;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        if($.trim($(\"#randCode\").val()).length==0){\n");
      out.write("            showErrorMsg(\"请输入验证码\");\n");
      out.write("            return false;\n");
      out.write("        }\n");
      out.write("        return true;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    //登录处理函数\n");
      out.write("    function newLogin(orgId) {\n");
      out.write("        setCookie();\n");
      out.write("\n");
      out.write("        var actionurl=\"userLoginController.do?login\";//提交路径\n");
      out.write("        var checkurl=\"userLoginController.do?checkuser\";//验证路径\n");
      out.write("\n");
      out.write("        var formData = new Object();\n");
      out.write("        var data=$(\":input\").each(function() {\n");
      out.write("            formData[this.name] =$(\"#\"+this.name ).val();\n");
      out.write("        });\n");
      out.write("        formData['orgId'] = orgId ? orgId : \"\";\n");
      out.write("        //语言\n");
      out.write("        formData['langCode']=$(\"#langCode\").val();\n");
      out.write("        formData['langCode'] = $(\"#langCode option:selected\").val();\n");
      out.write("        $.ajax({\n");
      out.write("            async : false,\n");
      out.write("            cache : false,\n");
      out.write("            type : 'POST',\n");
      out.write("            url : checkurl,// 请求的action路径\n");
      out.write("            data : formData,\n");
      out.write("            error : function() {// 请求失败处理函数\n");
      out.write("            },\n");
      out.write("            success : function(data) {\n");
      out.write("                var d = $.parseJSON(data);\n");
      out.write("                if (d.success) {\n");
      out.write("                    if (d.attributes.orgNum > 1) {\n");
      out.write("                        //用户拥有多个部门，需选择部门进行登录\n");
      out.write("                        var title, okButton;\n");
      out.write("                        if($(\"#langCode\").val() == 'en') {\n");
      out.write("                            title = \"Please select Org\";\n");
      out.write("                            okButton = \"Ok\";\n");
      out.write("                        } else {\n");
      out.write("                            title = \"请选择组织机构\";\n");
      out.write("                            okButton = \"确定\";\n");
      out.write("                        }\n");
      out.write("                        $.dialog({\n");
      out.write("                            id: 'LHG1976D',\n");
      out.write("                            title: title,\n");
      out.write("                            max: false,\n");
      out.write("                            min: false,\n");
      out.write("                            drag: false,\n");
      out.write("                            resize: false,\n");
      out.write("                            content: 'url:userController.do?userOrgSelect&userId=' + d.attributes.user.id,\n");
      out.write("                            lock:true,\n");
      out.write("                            button : [ {\n");
      out.write("                                name : okButton,\n");
      out.write("                                focus : true,\n");
      out.write("                                callback : function() {\n");
      out.write("                                    iframe = this.iframe.contentWindow;\n");
      out.write("                                    var orgId = $('#orgId', iframe.document).val();\n");
      out.write("\n");
      out.write("                                    formData['orgId'] = orgId ? orgId : \"\";\n");
      out.write("                                    $.ajax({\n");
      out.write("                                        async : false,\n");
      out.write("                                        cache : false,\n");
      out.write("                                        type : 'POST',\n");
      out.write("                                        url : 'loginController.do?changeDefaultOrg',// 请求的action路径\n");
      out.write("                                        data : formData,\n");
      out.write("                                        error : function() {// 请求失败处理函数\n");
      out.write("                                        },\n");
      out.write("                                        success : function(data) {\n");
      out.write("                                            window.location.href = actionurl;\n");
      out.write("                                        }\n");
      out.write("                                    });\n");
      out.write("\n");
      out.write("                                    this.close();\n");
      out.write("                                    return false;\n");
      out.write("                                }\n");
      out.write("                            }],\n");
      out.write("                            close: function(){\n");
      out.write("                                setTimeout(\"window.location.href='\"+actionurl+\"'\", 10);\n");
      out.write("                            }\n");
      out.write("                        });\n");
      out.write("                    } else {\n");
      out.write("                        window.location.href = actionurl;\n");
      out.write("                    }\n");
      out.write("                } else {\n");
      out.write("                    showErrorMsg(d.msg);\n");
      out.write("\n");
      out.write("                    if(d.msg === \"用户名或密码错误\" || d.msg === \"验证码错误\")\n");
      out.write("                        reloadRandCodeImage();\n");
      out.write("\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        });\n");
      out.write("    }\n");
      out.write("    //登录提示消息显示\n");
      out.write("    function showErrorMsg(msg){\n");
      out.write("        $(\"#errMsgContiner\").show();\n");
      out.write("        $(\"#showErrMsg\").html(msg);\n");
      out.write("        window.setTimeout(optErrMsg,3000);\n");
      out.write("    }\n");
      out.write("    /**\n");
      out.write("     * 刷新验证码\n");
      out.write("     */\n");
      out.write("    $('#randCodeImage').click(function(){\n");
      out.write("        reloadRandCodeImage();\n");
      out.write("    });\n");
      out.write("    function reloadRandCodeImage() {\n");
      out.write("        var date = new Date();\n");
      out.write("        var img = document.getElementById(\"randCodeImage\");\n");
      out.write("        img.src='randCodeImage?a=' + date.getTime();\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    //设置cookie\n");
      out.write("    function setCookie()\n");
      out.write("    {\n");
      out.write("\n");
      out.write("        if ($('#on_off').attr(\"checked\")) {\n");
      out.write("\n");
      out.write("            $(\"input[iscookie='true']\").each(function() {\n");
      out.write("                $.cookie(this.name, $(\"#\"+this.name).val(), \"/\",24);\n");
      out.write("                $.cookie(\"COOKIE_NAME\",\"true\", \"/\",24);\n");
      out.write("            });\n");
      out.write("        } else {\n");
      out.write("            $(\"input[iscookie='true']\").each(function() {\n");
      out.write("                $.cookie(this.name,null);\n");
      out.write("                $.cookie(\"COOKIE_NAME\",null);\n");
      out.write("            });\n");
      out.write("        }\n");
      out.write("    }\n");
      out.write("    //读取cookie\n");
      out.write("    function getCookie()\n");
      out.write("    {\n");
      out.write("        var COOKIE_NAME=$.cookie(\"COOKIE_NAME\");\n");
      out.write("        if (COOKIE_NAME !=null) {\n");
      out.write("            $(\"input[iscookie='true']\").each(function() {\n");
      out.write("                $($(\"#\"+this.name).val( $.cookie(this.name)));\n");
      out.write("                if(\"admin\" == $.cookie(this.name)) {\n");
      out.write("                    $(\"#randCode\").focus();\n");
      out.write("                } else {\n");
      out.write("                    $(\"#password\").val(\"\");\n");
      out.write("                    $(\"#password\").focus();\n");
      out.write("                }\n");
      out.write("            });\n");
      out.write("            $(\"#on_off\").attr(\"checked\", true);\n");
      out.write("            $(\"#on_off\").val(\"1\");\n");
      out.write("        }\n");
      out.write("        else\n");
      out.write("        {\n");
      out.write("            $(\"#on_off\").attr(\"checked\", false);\n");
      out.write("            $(\"#on_off\").val(\"0\");\n");
      out.write("            $(\"#randCode\").focus();\n");
      out.write("        }\n");
      out.write("    }\n");
      out.write("</script>\n");
      out.write("</body>\n");
      out.write("</html>");
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

  private boolean _jspx_meth_t_005fmutiLang_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  t:mutiLang
    org.jeecgframework.tag.core.easyui.MutiLangTag _jspx_th_t_005fmutiLang_005f0 = (org.jeecgframework.tag.core.easyui.MutiLangTag) _005fjspx_005ftagPool_005ft_005fmutiLang_0026_005flangKey_005fnobody.get(org.jeecgframework.tag.core.easyui.MutiLangTag.class);
    _jspx_th_t_005fmutiLang_005f0.setPageContext(_jspx_page_context);
    _jspx_th_t_005fmutiLang_005f0.setParent(null);
    // /webpage/webfront/login.jsp(14,11) name = langKey type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_t_005fmutiLang_005f0.setLangKey("jeect.platform");
    int _jspx_eval_t_005fmutiLang_005f0 = _jspx_th_t_005fmutiLang_005f0.doStartTag();
    if (_jspx_th_t_005fmutiLang_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ft_005fmutiLang_0026_005flangKey_005fnobody.reuse(_jspx_th_t_005fmutiLang_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005ft_005fmutiLang_0026_005flangKey_005fnobody.reuse(_jspx_th_t_005fmutiLang_005f0);
    return false;
  }
}
