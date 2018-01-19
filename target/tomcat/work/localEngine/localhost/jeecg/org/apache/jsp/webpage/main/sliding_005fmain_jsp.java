package org.apache.jsp.webpage.main;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class sliding_005fmain_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(2);
    _jspx_dependants.add("/context/mytags.jsp");
    _jspx_dependants.add("/WEB-INF/tld/easyui.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005ft_005fbase_0026_005ftype_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005ft_005fbase_0026_005ftype_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005ft_005fbase_0026_005ftype_005fnobody.release();
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
      out.write("<!DOCTYPE html >\n");
      out.write("<html>\n");
      out.write("\t<head>\n");
      out.write("\t\t<title>JEECG 微云快速开发平台</title>\n");
      if (_jspx_meth_t_005fbase_005f0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("<link rel=\"shortcut icon\" href=\"images/favicon.ico\">\n");
      out.write("\t\t<link href=\"plug-in/sliding/css/main.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("\t\t<link href=\"plug-in/sliding/css/themesetting.css\" rel=\"stylesheet\"  type=\"text/css\" >\n");
      out.write("\t\t<link href=\"plug-in/sliding/css/skins/black.css\" rel=\"stylesheet\" />\n");
      out.write("\t\t<link href=\"plug-in/sliding/css/powerFloat.css\" rel=\"stylesheet\" type=\"text/css\"/>\t\n");
      out.write("\t\t<link href=\"plug-in/sliding/css/smartMenu.css\" rel=\"stylesheet\"  type=\"text/css\" />\n");
      out.write("\t\t<link href=\"plug-in/sliding/css/skins/opera.css\" rel=\"stylesheet\"  type=\"text/css\" />\n");
      out.write("        <link href=\"plug-in/sliding/css/scrollStyle.css\" rel=\"stylesheet\"  type=\"text/css\" />\n");
      out.write("\t\t");
      out.write("\n");
      out.write("\t\t<script  type=\"text/javascript\" src=\"plug-in/sliding/js/jquery-powerFloat-min.js\"></script>\n");
      out.write("\t\t<script  type=\"text/javascript\" src=\"plug-in/sliding/js/jquery-smartMenu-min.js\"></script>\n");
      out.write("\t\t<script  type=\"text/javascript\" src=\"plug-in/sliding/js/jquery-class.js\"></script>\n");
      out.write("\t\t");
      out.write('\n');
      out.write('	');
      out.write('	');
      out.write("\n");
      out.write("\t\t<script  type=\"text/javascript\" src=\"plug-in/sliding/js/jquery.ui.core-min.js\"></script>\n");
      out.write("\t\t<script  type=\"text/javascript\" src=\"plug-in/sliding/js/jquery.ui.widget-min.js\"></script>\n");
      out.write("\t\t<script  type=\"text/javascript\" src=\"plug-in/sliding/js/jquery.ui.mouse-min.js\"></script>\n");
      out.write("\t\t<script  type=\"text/javascript\" src=\"plug-in/sliding/js/jquery.ui.draggable-min.js\"></script>\n");
      out.write("\t\t<script  type=\"text/javascript\" src=\"plug-in/sliding/js/jquery.ui.droppable-min.js\"></script>\n");
      out.write("\t\t<script  type=\"text/javascript\" src=\"plug-in/sliding/js/jquery.ui.sortable.js\"></script>\n");
      out.write("\t\t<script  type=\"text/javascript\" src=\"plug-in/sliding/js/jquery.cookie.js\"></script>\n");
      out.write("\t\t<script  type=\"text/javascript\" src=\"plug-in/sliding/js/webos-core.js\"></script>\n");
      out.write("        <script>\n");
      out.write("\n");
      out.write("            $(function(){\n");
      out.write("//                var $script = $(\"script[src='plug-in/jquery/jquery-1.8.3.js']\");\n");
      out.write("//                $($script).remove();\n");
      out.write("//                alert($script.attr(\"src\"));\n");
      out.write("\n");
      out.write("\t\t\t  $(\".dock_tool_theme\").live(\"click\",function(){\n");
      out.write("\t\t\t\t  $(\"#themeSetting_wrap2\").append(\"<div id='themeSetting_wrap' style='display:none;'></div>\");\n");
      out.write("\t\t\t\t  $(\"#themeSetting_wrap\").html($(\"#themeSetting_wrap1\").html());\n");
      out.write("\t\t\t\t  $(\"#themeSetting_wrap\").show();\n");
      out.write("\n");
      out.write("\t\t\t  })\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("\t</head>\n");
      out.write("\t<body>\n");
      out.write("\t <div id='themeSetting_wrap2'>\n");
      out.write("\t <div id='themeSetting_wrap' style='display:none;'></div>\n");
      out.write("\t </div>\n");
      out.write("\t\t<div  id=\"themeSetting_wrap1\" style=\"display:none;\">\t\t\t\n");
      out.write("\t\t\t\t<div id=\"themeSetting_head\" class=\"themeSetting_head\">\t\t\n");
      out.write("\t\t\t\t\t<div id=\"themeSetting_tabTheme\" class=\"themeSetting_tab current\" style=\"display: block;\">系统主题</div>\t\t\n");
      out.write("\t\t\t\t</div>\t\t\t\t\t\n");
      out.write("\t\t\t\t<div id=\"themeSetting_body\" class=\"themeSetting_body\">\t\n");
      out.write("\t\t\t\t\t<div id=\"themeSetting_area\"  class=\"themeSetting_area\" style=\"display: block;\">\t\t\t\t\t\t \n");
      out.write("\t\t\t\t\t<a href=\"###\" themeid=\"theme_blue\" class=\"themeSetting_settingButton\" id=\"themeSetting_theme_blue\">\n");
      out.write("\t\t\t\t\t\t<div style=\"background: url(plug-in/sliding/images/bg/icon/theme_blue.jpg) no-repeat;\" class=\"themeSetting_settingButton_icon\"></div>\n");
      out.write("\t\t\t\t\t\t<div class=\"themeSetting_settingButton_text\">梦幻光影</div>\n");
      out.write("\t\t\t\t\t</a>   \n");
      out.write("\t\t\t\t\t<a href=\"###\" themeid=\"theme_pinky_night\" class=\"themeSetting_settingButton\" id=\"themeSetting_theme_pinky_night\">\n");
      out.write("\t\t\t\t\t\t<div style=\"background: url(plug-in/sliding/images/bg/icon/theme_pinky_night.jpg) no-repeat;\" class=\"themeSetting_settingButton_icon\"></div>\n");
      out.write("\t\t\t\t\t\t<div class=\"themeSetting_settingButton_text\">粉红之夜</div>\n");
      out.write("\t\t\t\t\t</a>      \n");
      out.write("\t\t\t\t\t<a href=\"###\" themeid=\"theme_green\" class=\"themeSetting_settingButton\" id=\"themeSetting_theme_green\">\n");
      out.write("\t\t\t\t\t\t<div style=\"background: url(plug-in/sliding/images/bg/icon/theme_green.jpg) no-repeat;\" class=\"themeSetting_settingButton_icon\"></div>\n");
      out.write("\t\t\t\t\t\t<div class=\"themeSetting_settingButton_text\">青青世界</div>\n");
      out.write("\t\t\t\t\t</a>  \n");
      out.write("\t\t\t\t\t<a href=\"###\" themeid=\"theme_wood1\" class=\"themeSetting_settingButton\" id=\"themeSetting_theme_wood1\">\n");
      out.write("\t\t\t\t\t\t<div style=\"background: url(plug-in/sliding/images/bg/icon/theme_wood1.jpg) no-repeat;\" class=\"themeSetting_settingButton_icon\"></div>\n");
      out.write("\t\t\t\t\t\t<div class=\"themeSetting_settingButton_text\">温馨木纹</div>\n");
      out.write("\t\t\t\t\t</a>         \n");
      out.write("\t\t\t\t\t<a href=\"###\" themeid=\"theme_wood2\" class=\"themeSetting_settingButton\" id=\"themeSetting_theme_wood2\">\n");
      out.write("\t\t\t\t\t\t<div style=\"background: url(plug-in/sliding/images/bg/icon/theme_wood2.jpg) no-repeat;\" class=\"themeSetting_settingButton_icon\"></div>\n");
      out.write("\t\t\t\t\t\t<div class=\"themeSetting_settingButton_text\">黑色木纹</div>\n");
      out.write("\t\t\t\t\t</a>        \n");
      out.write("\t\t\t\t\t<a href=\"###\" themeid=\"theme_universe\" class=\"themeSetting_settingButton\" id=\"themeSetting_theme_universe\">\n");
      out.write("\t\t\t\t\t\t<div style=\"background: url(plug-in/sliding/images/bg/icon/theme_universe.jpg) no-repeat;\" class=\"themeSetting_settingButton_icon\"></div>\n");
      out.write("\t\t\t\t\t\t<div class=\"themeSetting_settingButton_text\">神秘星际</div>\n");
      out.write("\t\t\t\t\t</a>       \n");
      out.write("\t\t\t\t\t<a href=\"###\" themeid=\"theme_metal\" class=\"themeSetting_settingButton\" id=\"themeSetting_theme_metal\">\n");
      out.write("\t\t\t\t\t\t<div style=\"background: url(plug-in/sliding/images/bg/icon/theme_metal.jpg) no-repeat;\" class=\"themeSetting_settingButton_icon\"></div>\n");
      out.write("\t\t\t\t\t\t<div class=\"themeSetting_settingButton_text\">酷炫金属</div>\n");
      out.write("\t\t\t\t\t</a>       \n");
      out.write("\t\t\t\t\t<a href=\"###\" themeid=\"theme_pinky_light\" class=\"themeSetting_settingButton\" id=\"themeSetting_theme_pinky_light\">\n");
      out.write("\t\t\t\t\t\t<div style=\"background: url(plug-in/sliding/images/bg/icon/theme_pinky_light.jpg) no-repeat;\" class=\"themeSetting_settingButton_icon\"></div>\n");
      out.write("\t\t\t\t\t\t<div class=\"themeSetting_settingButton_text\">幻彩荧光</div>\n");
      out.write("\t\t\t\t\t</a>   \n");
      out.write("\t\t\t\t\t<a href=\"###\" themeid=\"theme_pinky_flower\" class=\"themeSetting_settingButton\" id=\"themeSetting_theme_pinky_flower\">\n");
      out.write("\t\t\t\t\t\t<div style=\"background: url(plug-in/sliding/images/bg/icon/theme_pinky_flower.jpg) no-repeat;\" class=\"themeSetting_settingButton_icon\"></div>\n");
      out.write("\t\t\t\t\t\t<div class=\"themeSetting_settingButton_text\">绚烂繁花</div>\n");
      out.write("\t\t\t\t\t</a>      \n");
      out.write("\t\t\t\t\t<a href=\"###\" themeid=\"theme_christmas\" class=\"themeSetting_settingButton\" id=\"themeSetting_theme_christmas\">\n");
      out.write("\t\t\t\t\t\t<div style=\"background: url(plug-in/sliding/images/bg/icon/theme_christmas.jpg) no-repeat;\" class=\"themeSetting_settingButton_icon\"></div>\n");
      out.write("\t\t\t\t\t\t<div class=\"themeSetting_settingButton_text\">圣诞快乐</div>\n");
      out.write("\t\t\t\t\t</a>      \n");
      out.write("\t\t\t\t\t<a href=\"###\" themeid=\"theme_2011\" class=\"themeSetting_settingButton\" id=\"themeSetting_theme_2011\">\n");
      out.write("\t\t\t\t\t\t<div style=\"background: url(plug-in/sliding/images/bg/icon/theme_2011.jpg) no-repeat;\" class=\"themeSetting_settingButton_icon\"></div>\n");
      out.write("\t\t\t\t\t\t<div class=\"themeSetting_settingButton_text\">欢庆元旦</div>\n");
      out.write("\t\t\t\t\t</a> \n");
      out.write("\t\t\t\t\t<a href=\"###\" themeid=\"theme_blue1\" class=\"themeSetting_settingButton\" id=\"themeSetting_theme_blue1\">\n");
      out.write("\t\t\t\t\t\t<div style=\"background: url(plug-in/sliding/images/bg/icon/theme_blue1.jpg) no-repeat;\" class=\"themeSetting_settingButton_icon\"></div>\n");
      out.write("\t\t\t\t\t\t<div class=\"themeSetting_settingButton_text\">幻彩蓝天</div>\n");
      out.write("\t\t\t\t\t</a>         \n");
      out.write("\t\t\t\t\t<a href=\"###\" themeid=\"theme_spring_festival\" class=\"themeSetting_settingButton\" id=\"themeSetting_theme_spring_festival\">\n");
      out.write("\t\t\t\t\t\t<div style=\"background: url(plug-in/sliding/images/bg/icon/theme_spring_festival.jpg) no-repeat;\" class=\"themeSetting_settingButton_icon\"></div>\n");
      out.write("\t\t\t\t\t\t<div class=\"themeSetting_settingButton_text\">喜迎新春</div>\n");
      out.write("\t\t\t\t\t</a>         \n");
      out.write("\t\t\t\t\t<a href=\"###\" themeid=\"theme_blue_glow\" class=\"themeSetting_settingButton themeSetting_selected\" id=\"themeSetting_theme_blue_glow\">\n");
      out.write("\t\t\t\t\t\t<div style=\"background: url(plug-in/sliding/images/bg/icon/theme_blue_glow.jpg) no-repeat;\" class=\"themeSetting_settingButton_icon\"></div>\n");
      out.write("\t\t\t\t\t\t<div class=\"themeSetting_settingButton_text\">深海仰望</div>\n");
      out.write("\t\t\t\t\t</a>\n");
      out.write("\t\t\t\t\t<a href=\"###\" themeid=\"theme_green_glow\" class=\"themeSetting_settingButton\" id=\"themeSetting_theme_green_glow\">\n");
      out.write("\t\t\t\t\t\t<div style=\"background: url(plug-in/sliding/images/bg/icon/theme_green_glow.jpg) no-repeat;\" class=\"themeSetting_settingButton_icon\"></div>\n");
      out.write("\t\t\t\t\t\t<div class=\"themeSetting_settingButton_text\">晨光微曦</div>\n");
      out.write("\t\t\t\t\t</a>        \n");
      out.write("\t\t\t\t\t<a href=\"###\" themeid=\"theme_orange_glow\" class=\"themeSetting_settingButton\" id=\"themeSetting_theme_orange_glow\">\n");
      out.write("\t\t\t\t\t\t<div style=\"background: url(plug-in/sliding/images/bg/icon/theme_orange_glow.jpg) no-repeat;\" class=\"themeSetting_settingButton_icon\"></div>\n");
      out.write("\t\t\t\t\t\t<div class=\"themeSetting_settingButton_text\">梦醒时分</div>\n");
      out.write("\t\t\t\t\t</a>         \n");
      out.write("\t\t\t\t\t<a href=\"###\" themeid=\"theme_valentinesDay\" class=\"themeSetting_settingButton\" id=\"themeSetting_theme_valentinesDay\">\n");
      out.write("\t\t\t\t\t\t<div style=\"background: url(plug-in/sliding/images/bg/icon/theme_valentinesDay.jpg) no-repeat;\" class=\"themeSetting_settingButton_icon\"></div>\n");
      out.write("\t\t\t\t\t\t<div class=\"themeSetting_settingButton_text\">甜蜜情人节</div>\n");
      out.write("\t\t\t\t\t</a>         \n");
      out.write("\t\t\t\t\t<a href=\"###\" themeid=\"theme_cloud\" class=\"themeSetting_settingButton\" id=\"themeSetting_theme_cloud\">\n");
      out.write("\t\t\t\t\t\t<div style=\"background: url(plug-in/sliding/images/bg/icon/theme_cloud.jpg) no-repeat;\" class=\"themeSetting_settingButton_icon\"></div>\n");
      out.write("\t\t\t\t\t\t<div class=\"themeSetting_settingButton_text\">晴空行云</div>\n");
      out.write("\t\t\t\t\t</a>\n");
      out.write("\t\t\t\t\t<a href=\"###\" themeid=\"theme_gravity\" class=\"themeSetting_settingButton\" id=\"themeSetting_theme_gravity\">\n");
      out.write("\t\t\t\t\t\t<div style=\"background: url(plug-in/sliding/images/bg/icon/theme_gravity.jpg) no-repeat;\" class=\"themeSetting_settingButton_icon\"></div>\n");
      out.write("\t\t\t\t\t\t<div class=\"themeSetting_settingButton_text\">蒲公英</div>\n");
      out.write("\t\t\t\t\t</a>         \n");
      out.write("\t\t\t\t\t<a href=\"###\" themeid=\"theme_7_7\" class=\"themeSetting_settingButton\" id=\"themeSetting_theme_7_7\">\n");
      out.write("\t\t\t\t\t\t<div style=\"background: url(plug-in/sliding/images/bg/icon/theme_7_7.jpg) no-repeat;\" class=\"themeSetting_settingButton_icon\"></div>\n");
      out.write("\t\t\t\t\t\t<div class=\"themeSetting_settingButton_text\">七夕</div>\n");
      out.write("\t\t\t\t\t</a>\n");
      out.write("\t\t\t\t\t<a href=\"###\" themeid=\"theme_teachersDay\" class=\"themeSetting_settingButton\" id=\"themeSetting_theme_teachersDay\">\n");
      out.write("\t\t\t\t\t\t<div style=\"background: url(plug-in/sliding/images/bg/icon/theme_teachersDay.jpg) no-repeat;\" class=\"themeSetting_settingButton_icon\"></div>\n");
      out.write("\t\t\t\t\t\t<div class=\"themeSetting_settingButton_text\">教师节</div>\n");
      out.write("\t\t\t\t\t</a>\n");
      out.write("\t\t\t\t\t<a href=\"###\" themeid=\"theme_midAutumn\" class=\"themeSetting_settingButton\" id=\"themeSetting_theme_midAutumn\">\n");
      out.write("\t\t\t\t\t\t<div style=\"background: url(plug-in/sliding/images/bg/icon/theme_midAutumn.jpg) no-repeat;\" class=\"themeSetting_settingButton_icon\"></div>\n");
      out.write("\t\t\t\t\t\t<div class=\"themeSetting_settingButton_text\">中秋节</div>\n");
      out.write("\t\t\t\t\t</a>  \n");
      out.write("\t\t\t\t\t<a href=\"###\" themeid=\"theme_lookUpSky\" class=\"themeSetting_settingButton\" id=\"themeSetting_theme_lookUpSky\">\n");
      out.write("\t\t\t\t\t\t<div style=\"background: url(plug-in/sliding/images/bg/icon/theme_lookUpSky.jpg) no-repeat;\" class=\"themeSetting_settingButton_icon\"></div>\n");
      out.write("\t\t\t\t\t\t<div class=\"themeSetting_settingButton_text\">仰望苍穹</div>\n");
      out.write("\t\t\t\t\t</a>        \n");
      out.write("\t\t\t\t\t<a href=\"###\" themeid=\"theme_grass\" class=\"themeSetting_settingButton\" id=\"themeSetting_theme_grass\">\n");
      out.write("\t\t\t\t\t\t<div style=\"background: url(plug-in/sliding/images/bg/icon/theme_grass.jpg) no-repeat;\" class=\"themeSetting_settingButton_icon\"></div>\n");
      out.write("\t\t\t\t\t\t<div class=\"themeSetting_settingButton_text\">茫茫野草</div>\n");
      out.write("\t\t\t\t\t</a>    \n");
      out.write("\t\t\t\t\t<a href=\"###\" themeid=\"theme_childhood\" class=\"themeSetting_settingButton\" id=\"themeSetting_theme_childhood\">\n");
      out.write("\t\t\t\t\t\t<div style=\"background: url(plug-in/sliding/images/bg/icon/theme_childhood.jpg) no-repeat;\" class=\"themeSetting_settingButton_icon\"></div>\n");
      out.write("\t\t\t\t\t\t<div class=\"themeSetting_settingButton_text\">童年记忆</div>\n");
      out.write("\t\t\t\t\t</a>         \n");
      out.write("\t\t\t\t\t<a href=\"###\" themeid=\"theme_skyBlue\" class=\"themeSetting_settingButton\" id=\"themeSetting_theme_skyBlue\">\n");
      out.write("\t\t\t\t\t\t<div style=\"background: url(plug-in/sliding/images/bg/icon/theme_skyBlue.jpg) no-repeat;\" class=\"themeSetting_settingButton_icon\"></div>\n");
      out.write("\t\t\t\t\t\t<div class=\"themeSetting_settingButton_text\">空灵蓝调</div>\n");
      out.write("\t\t\t\t\t</a>      \n");
      out.write("\t\t\t\t\t<a href=\"###\" themeid=\"theme_dandelionDream\" class=\"themeSetting_settingButton\" id=\"themeSetting_theme_dandelionDream\">\n");
      out.write("\t\t\t\t\t\t<div style=\"background: url(plug-in/sliding/images/bg/icon/theme_dandelionDream.jpg) no-repeat;\" class=\"themeSetting_settingButton_icon\"></div>\n");
      out.write("\t\t\t\t\t\t<div class=\"themeSetting_settingButton_text\">蒲英之梦</div>\n");
      out.write("\t\t\t\t\t</a>          \n");
      out.write("\t\t\t\t\t<a href=\"###\" themeid=\"theme_paintingTime\" class=\"themeSetting_settingButton\" id=\"themeSetting_theme_paintingTime\">\n");
      out.write("\t\t\t\t\t\t<div style=\"background: url(plug-in/sliding/images/bg/icon/theme_paintingTime.jpg) no-repeat;\" class=\"themeSetting_settingButton_icon\"></div>\n");
      out.write("\t\t\t\t\t\t<div class=\"themeSetting_settingButton_text\">水墨年华</div>\n");
      out.write("\t\t\t\t\t</a>  \n");
      out.write("\t\t\t\t\t<a href=\"###\" themeid=\"theme_dreamSky\" class=\"themeSetting_settingButton\" id=\"themeSetting_theme_dreamSky\">\n");
      out.write("\t\t\t\t\t\t<div style=\"background: url(plug-in/sliding/images/bg/icon/theme_dreamSky.jpg) no-repeat;\" class=\"themeSetting_settingButton_icon\"></div>\n");
      out.write("\t\t\t\t\t\t<div class=\"themeSetting_settingButton_text\">梦翔天际</div>\n");
      out.write("\t\t\t\t\t</a>              \n");
      out.write("\t\t\t\t\t</div>\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t<div id=\"themeSetting_wallpaper\" class=\"themeSetting_wallpaper\" style=\"display: none;\"></div>\t\t\t\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div id=\"zoomWallpaperGrid\" class=\"zoomWallpaperGrid\" style=\"position: absolute; z-index: -10; left: 0pt; top: 0pt; overflow: hidden; height: 381px; width: 1440px;\">\n");
      out.write("\t\t\t<img id=\"zoomWallpaper\" class=\"zoomWallpaper\" style=\"position: absolute; top: 0pt; left: 0pt; height: 381px; width: 1440px;\" src=\"plug-in/sliding/images/bg/cloud.jpg\">\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div class=\"taskbar_start_menu_container\" id=\"startMenuContainer\" _olddisplay=\"block\" style=\"display: none;\">  \n");
      out.write("\t\t\t<div class=\"startMenuImg taskbar_start_menu_body\" id=\"taskbar_start_menu_body\">          \n");
      out.write("\t\t\t<div uin=\"0\" class=\"taskbar_start_menu_selfinfo\" id=\"startMenuSelfInfo\">       \n");
      out.write("\t\t\t\t<div style=\"float: left; line-height: 15px;\">\n");
      out.write("                     <span style=\"color: #6DB6D9\">用户: </span>\n");
      out.write("                     <span style=\"color: #FFFFFF\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${userName }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</span><br>\n");
      out.write("                     <!-- \n");
      out.write("                     <span style=\"color: #6DB6D9\">岗位: </span>\n");
      out.write("                     <span style=\"color: #FFFFFF\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentOrgName }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</span><br>\n");
      out.write("                      -->\n");
      out.write("                      \n");
      out.write("                     <span style=\"color: #6DB6D9\">职务: </span>\n");
      out.write("                     <span style=\"color: #FFFFFF\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${roleName }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</span>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t<a title=\"反馈\" href=\"###\" class=\"startMenuImg startMenuTopControl_support\" cmd=\"support\">&nbsp;</a>    \n");
      out.write("\t\t\t\t<a title=\"锁定\" href=\"###\" class=\"startMenuImg startMenuTopControl_lock\" cmd=\"lock\">&nbsp;</a>     \n");
      out.write("\t\t\t</div>       \n");
      out.write("\t\t\t<ul class=\"taskbar_start_menu\">\n");
      out.write("\t\t\t\t<li cmd=\"favorite\">\n");
      out.write("\t\t\t\t\t<div style=\"background: url(plug-in/login/images/exit.png) no-repeat left center;padding-left:30px;\"\n");
      out.write("                         onclick=\"openwindow('用户信息','userController.do?userinfo')\">个人信息</div>\n");
      out.write("\t\t\t\t</li>\n");
      out.write("\t\t\t\t<li cmd=\"favorite\">\n");
      out.write("\t\t\t\t\t<div style=\"background: url(plug-in/login/images/exit.png) no-repeat left center;padding-left:30px;\"\n");
      out.write("                         onclick=\"add('修改密码','userController.do?changepassword',null,560,120)\">修改密码</div>\n");
      out.write("\t\t\t\t</li>\n");
      out.write("\t\t\t\t<li cmd=\"favorite\">\n");
      out.write("\t\t\t\t\t<div style=\"background: url(plug-in/login/images/exit.png) no-repeat left center;padding-left:30px;\"\n");
      out.write("                         onclick=\"openwindow('系统信息','tSSmsController.do?getSysInfos')\">系统信息</div>\n");
      out.write("\t\t\t\t</li>\n");
      out.write("\t\t\t\t<li cmd=\"favorite\">\n");
      out.write("\t\t\t\t\t<div style=\"background: url(plug-in/login/images/exit.png) no-repeat left center;padding-left:30px;\"\n");
      out.write("                         onclick=\"add('修改首页风格','userController.do?changestyle',null,560,200)\">首页风格 </div>\n");
      out.write("\t\t\t\t</li>\n");
      out.write("\t\t\t\t<li cmd=\"favorite\">\n");
      out.write("\t\t\t\t\t<div style=\"background: url(plug-in/login/images/exit.png) no-repeat left center;padding-left:30px;\"\n");
      out.write("                         onclick=\"window.open('http://yun.jeecg.org')\">云应用中心 </div>\n");
      out.write("\t\t\t\t</li>\n");
      out.write("\t\t\t\t<li cmd=\"logout\">\n");
      out.write("\t\t\t\t\t<div class=\"startMenuImg logout_botton\" title=\"注销当前用户\"\n");
      out.write("                         onclick=\"exit('loginController.do?logout','确定退出该系统吗 ?',1);\"></div>\n");
      out.write("\t\t\t\t</li>\n");
      out.write("\t\t\t</ul>  \n");
      out.write("\t\t\t<!--  <a class=\"startMenuImg logout_botton\" title=\"注销当前用户\" onclick=\"exit('loginController.do?logout','确定退出该系统吗 ?',1);\" cmd=\"logout\"></a> -->\t \n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</body>\n");
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

  private boolean _jspx_meth_t_005fbase_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  t:base
    org.jeecgframework.tag.core.easyui.BaseTag _jspx_th_t_005fbase_005f0 = (org.jeecgframework.tag.core.easyui.BaseTag) _005fjspx_005ftagPool_005ft_005fbase_0026_005ftype_005fnobody.get(org.jeecgframework.tag.core.easyui.BaseTag.class);
    _jspx_th_t_005fbase_005f0.setPageContext(_jspx_page_context);
    _jspx_th_t_005fbase_005f0.setParent(null);
    // /webpage/main/sliding_main.jsp(7,0) name = type type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_t_005fbase_005f0.setType("jquery-webos,easyui,tools,DatePicker,autocomplete");
    int _jspx_eval_t_005fbase_005f0 = _jspx_th_t_005fbase_005f0.doStartTag();
    if (_jspx_th_t_005fbase_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ft_005fbase_0026_005ftype_005fnobody.reuse(_jspx_th_t_005fbase_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005ft_005fbase_0026_005ftype_005fnobody.reuse(_jspx_th_t_005fbase_005f0);
    return false;
  }
}
