package org.apache.jsp.webpage.com.jeecg.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class form_005fpopupMultiValue_jsp extends org.apache.jasper.runtime.HttpJspBase
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
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005ft_005fformvalid_0026_005ftiptype_005flayout_005fformid_005fdialog_005faction;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005ft_005fdictSelect_0026_005ftypeGroupCode_005ftitle_005ffield_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005ft_005fbase_0026_005ftype_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005ft_005fformvalid_0026_005ftiptype_005flayout_005fformid_005fdialog_005faction = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005ft_005fdictSelect_0026_005ftypeGroupCode_005ftitle_005ffield_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005ft_005fbase_0026_005ftype_005fnobody.release();
    _005fjspx_005ftagPool_005ft_005fformvalid_0026_005ftiptype_005flayout_005fformid_005fdialog_005faction.release();
    _005fjspx_005ftagPool_005ft_005fdictSelect_0026_005ftypeGroupCode_005ftitle_005ffield_005fnobody.release();
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

      out.write("<!DOCTYPE html>\n");
      out.write("\n");
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
      if (_jspx_meth_t_005fbase_005f0(_jspx_page_context))
        return;
      out.write("\n");
      out.write(" <style type=\"text/css\">\n");
      out.write(" \tth{\n");
      out.write(" \t\ttext-align: center;\n");
      out.write(" \t\tline-height: 25px;\n");
      out.write(" \t}\n");
      out.write(" \t.value{\n");
      out.write(" \t\tpadding: 10px auto 10px 10px;\n");
      out.write(" \t}\n");
      out.write(" \t.inputxt{\n");
      out.write(" \t\twidth: 150px;\n");
      out.write(" \t}\n");
      out.write(" </style>\n");
      out.write(" <script type=\"text/javascript\">\n");
      out.write(" \n");
      out.write("\t //设置表单内容\n");
      out.write("\t function setMultiVlaue(obj,rowTag,selected){\n");
      out.write("\t\n");
      out.write("\t     if (selected == '' || selected == null) {\n");
      out.write("             alert(\"请选择\");\n");
      out.write("             return false;\n");
      out.write("\t     } else {\n");
      out.write("             var str = \"\";\n");
      out.write("             var str1 = \"\";\t\n");
      out.write("             $.each(selected, function(i, n) {\n");
      out.write("\t             if (i == 0) {\n");
      out.write("\t\t             str += n.realname;\n");
      out.write("\t\t             str1 += n.account;\t\n");
      out.write("\t             } else {\n");
      out.write("\t\t             str += \",\" + n.realname;\n");
      out.write("\t\t             str1 += \",\" + n.account;\n");
      out.write("\t             }\t\n");
      out.write("             });\t             \n");
      out.write("             $(\"input[name='\"+rowTag+\".name']\").val(str);\n");
      out.write("             $(\"input[name='\"+rowTag+\".account']\").val(str1);           \n");
      out.write("             return true;\n");
      out.write("\t     }\n");
      out.write("\t }\n");
      out.write("\t \n");
      out.write("\t /**\n");
      out.write("\t  * 弹出popup窗口获取\n");
      out.write("\t  * @param obj\n");
      out.write("\t  * @param rowTag 行标记\n");
      out.write("\t  * @param code  动态报表配置ID\n");
      out.write("\t  */\n");
      out.write("\t function inputClick(obj, rowTag, code) {\n");
      out.write("\t     if (rowTag == null || code == \"\") {\n");
      out.write("\t         alert(\"popup参数配置不全\");\n");
      out.write("\t         return;\n");
      out.write("\t     }\n");
      out.write("\t     var inputClickUrl = basePath + \"/cgReportController.do?popup&id=\" + code;\n");
      out.write("\t     if (typeof (windowapi) == 'undefined') {//页面弹出popup\n");
      out.write("\t         $.dialog({\n");
      out.write("\t\t        content : \"url:\" + inputClickUrl,\n");
      out.write("\t\t        zIndex : getzIndex(),\n");
      out.write("\t\t        lock : true,\n");
      out.write("\t\t        title : \"选择\",\n");
      out.write("\t\t        width : 800,\n");
      out.write("\t\t        height : 400,\n");
      out.write("\t\t        cache : false,\n");
      out.write("\t\t        ok : function() {\n");
      out.write("\t                iframe = this.iframe.contentWindow;\n");
      out.write("\t                var selected = iframe.getSelectRows();//重要，此处获取行数据\n");
      out.write("\t                return setMultiVlaue(obj,rowTag,selected);\n");
      out.write("\t\t        },\n");
      out.write("\t\t        cancelVal : '关闭',\n");
      out.write("\t\t        cancel : true//为true等价于function(){}\n");
      out.write("\t   \t\t});\n");
      out.write("\t     } else {//popup内弹出popup\n");
      out.write("\t         $.dialog({\n");
      out.write("\t\t         content : \"url:\" + inputClickUrl,\n");
      out.write("\t\t         zIndex : getzIndex(),\n");
      out.write("\t\t         lock : true,\n");
      out.write("\t\t         title : \"选择\",\n");
      out.write("\t\t         width : 800,\n");
      out.write("\t\t         height : 400,\n");
      out.write("\t\t         parent : windowapi,//设置弹出popup的openner\n");
      out.write("\t\t         cache : false,\n");
      out.write("\t\t         ok : function() {\n");
      out.write("\t                 iframe = this.iframe.contentWindow;\n");
      out.write("\t                 var selected = iframe.getSelectRows();//重要，此处获取行数据\n");
      out.write("\t                 return setMultiVlaue(obj,rowTag,selected);\n");
      out.write("\t\t         },\n");
      out.write("\t\t         cancelVal : '关闭',\n");
      out.write("\t\t         cancel : true//为true等价于function(){}\n");
      out.write("\t  \t\t});\n");
      out.write("\t     }\n");
      out.write("\t}\n");
      out.write("  \n");
      out.write(" </script>\n");
      out.write("    <div title=\"Popup Demo\" style=\"height:350px;\" name=\"editPanel\" id=\"editPanel\" fit=\"true\" class=\"easyui-panel\">  \t\n");
      out.write("\t\t");
      if (_jspx_meth_t_005fformvalid_005f0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("    </div>");
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
    // /webpage/com/jeecg/demo/form_popupMultiValue.jsp(4,0) name = type type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_t_005fbase_005f0.setType("jquery,easyui,tools,DatePicker,autocomplete");
    int _jspx_eval_t_005fbase_005f0 = _jspx_th_t_005fbase_005f0.doStartTag();
    if (_jspx_th_t_005fbase_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ft_005fbase_0026_005ftype_005fnobody.reuse(_jspx_th_t_005fbase_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005ft_005fbase_0026_005ftype_005fnobody.reuse(_jspx_th_t_005fbase_005f0);
    return false;
  }

  private boolean _jspx_meth_t_005fformvalid_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  t:formvalid
    org.jeecgframework.tag.core.easyui.FormValidationTag _jspx_th_t_005fformvalid_005f0 = (org.jeecgframework.tag.core.easyui.FormValidationTag) _005fjspx_005ftagPool_005ft_005fformvalid_0026_005ftiptype_005flayout_005fformid_005fdialog_005faction.get(org.jeecgframework.tag.core.easyui.FormValidationTag.class);
    _jspx_th_t_005fformvalid_005f0.setPageContext(_jspx_page_context);
    _jspx_th_t_005fformvalid_005f0.setParent(null);
    // /webpage/com/jeecg/demo/form_popupMultiValue.jsp(95,2) name = formid type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_t_005fformvalid_005f0.setFormid("ff");
    // /webpage/com/jeecg/demo/form_popupMultiValue.jsp(95,2) name = dialog type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_t_005fformvalid_005f0.setDialog(true);
    // /webpage/com/jeecg/demo/form_popupMultiValue.jsp(95,2) name = layout type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_t_005fformvalid_005f0.setLayout("table");
    // /webpage/com/jeecg/demo/form_popupMultiValue.jsp(95,2) name = tiptype type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_t_005fformvalid_005f0.setTiptype("4");
    // /webpage/com/jeecg/demo/form_popupMultiValue.jsp(95,2) name = action type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_t_005fformvalid_005f0.setAction("jeecgListDemoController.do?saveRows");
    int _jspx_eval_t_005fformvalid_005f0 = _jspx_th_t_005fformvalid_005f0.doStartTag();
    if (_jspx_eval_t_005fformvalid_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("\t\t\t<table style=\"width: 600px;\" cellpadding=\"0\" cellspacing=\"1\" class=\"formtable\">\n");
        out.write("\t\t\t\t<thead>\n");
        out.write("\t\t\t\t\t<tr><th>姓名</th><th>账号</th><th>生日</th><th>性别</th><th>工资</th><th>入职状态</th></tr>\n");
        out.write("\t\t\t\t</thead>\n");
        out.write("\t\t\t\t<tbody>\n");
        out.write("\t\t\t\t\t<tr>\n");
        out.write("\t\t\t\t\t\t<td class=\"value\">\t\t\t\t\t\t\t\n");
        out.write("\t\t\t\t\t\t\t <input name=\"demos[0].id\" type=\"hidden\" value=\"\" /> \n");
        out.write("\t\t\t\t\t\t     <input onclick=\"inputClick(this,'demos[0]','user_msg');\" placeholder=\"点击选择用户\" name=\"demos[0].name\" type=\"text\" style=\"cursor: pointer;\" class=\"inputxt\" value=\"\">\n");
        out.write("\t\t\t\t\t\t</td>\n");
        out.write("\t\t\t\t\t\t<td class=\"value\">\n");
        out.write("\t\t\t\t\t\t     <input placeholder=\"←\" name=\"demos[0].account\" type=\"text\" class=\"inputxt\" value=\"\">\n");
        out.write("\t\t\t\t\t\t</td>\n");
        out.write("\t\t\t\t\t\t<td class=\"value\">\n");
        out.write("\t\t\t\t\t\t\t<input class=\"easyui-datebox\" type=\"text\" name=\"demos[0].birthday\" id=\"birthday\"/>\n");
        out.write("\t\t\t\t\t\t</td>\n");
        out.write("\t\t\t\t\t\t<td class=\"value\">\n");
        out.write("\t\t\t\t\t\t\t");
        if (_jspx_meth_t_005fdictSelect_005f0(_jspx_th_t_005fformvalid_005f0, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("\t\t\t\t\t\t</td>\n");
        out.write("\t\t\t\t\t\t<td class=\"value\">\n");
        out.write("\t\t\t\t\t\t     \t <input id=\"salary\" name=\"demos[0].salary\" type=\"text\" class=\"inputxt\" value=\"\">\n");
        out.write("\t\t\t\t\t\t</td>\n");
        out.write("\t\t\t\t\t\t<td class=\"value\">\n");
        out.write("\t\t\t\t\t\t\t");
        if (_jspx_meth_t_005fdictSelect_005f1(_jspx_th_t_005fformvalid_005f0, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("\t\t\t\t\t\t</td>\n");
        out.write("\t\t\t\t\t</tr>\n");
        out.write("\t\t\t\t\t<tr>\n");
        out.write("\t\t\t\t\t\t<td class=\"value\">\t\t\t\t\t\t\t\n");
        out.write("\t\t\t\t\t\t\t <input name=\"demos[1].id\" type=\"hidden\" value=\"\" /> \n");
        out.write("\t\t\t\t\t\t     <input onclick=\"inputClick(this,'demos[1]','user_msg');\" placeholder=\"点击选择用户\" name=\"demos[1].name\" type=\"text\" style=\"cursor: pointer;\" class=\"inputxt\" value=\"\">\n");
        out.write("\t\t\t\t\t\t</td>\n");
        out.write("\t\t\t\t\t\t<td class=\"value\">\n");
        out.write("\t\t\t\t\t\t     <input placeholder=\"←\" name=\"demos[1].account\" type=\"text\" class=\"inputxt\" value=\"\">\n");
        out.write("\t\t\t\t\t\t</td>\n");
        out.write("\t\t\t\t\t\t<td class=\"value\">\n");
        out.write("\t\t\t\t\t\t\t<input class=\"easyui-datebox\" type=\"text\" name=\"demos[1].birthday\"/>\n");
        out.write("\t\t\t\t\t\t</td>\n");
        out.write("\t\t\t\t\t\t<td class=\"value\">\n");
        out.write("\t\t\t\t\t\t\t");
        if (_jspx_meth_t_005fdictSelect_005f2(_jspx_th_t_005fformvalid_005f0, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("\t\t\t\t\t\t</td>\n");
        out.write("\t\t\t\t\t\t<td class=\"value\">\n");
        out.write("\t\t\t\t\t\t     \t <input id=\"salary\" name=\"demos[1].salary\" type=\"text\" class=\"inputxt\" value=\"\">\n");
        out.write("\t\t\t\t\t\t</td>\n");
        out.write("\t\t\t\t\t\t<td class=\"value\">\n");
        out.write("\t\t\t\t\t\t\t");
        if (_jspx_meth_t_005fdictSelect_005f3(_jspx_th_t_005fformvalid_005f0, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("\t\t\t\t\t\t</td>\n");
        out.write("\t\t\t\t\t</tr>\n");
        out.write("\t\t\t\t</tbody>\n");
        out.write("\t\t\t</table>\t\t\n");
        out.write("\t\t");
        int evalDoAfterBody = _jspx_th_t_005fformvalid_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_t_005fformvalid_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ft_005fformvalid_0026_005ftiptype_005flayout_005fformid_005fdialog_005faction.reuse(_jspx_th_t_005fformvalid_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005ft_005fformvalid_0026_005ftiptype_005flayout_005fformid_005fdialog_005faction.reuse(_jspx_th_t_005fformvalid_005f0);
    return false;
  }

  private boolean _jspx_meth_t_005fdictSelect_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_t_005fformvalid_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  t:dictSelect
    org.jeecgframework.tag.core.easyui.DictSelectTag _jspx_th_t_005fdictSelect_005f0 = (org.jeecgframework.tag.core.easyui.DictSelectTag) _005fjspx_005ftagPool_005ft_005fdictSelect_0026_005ftypeGroupCode_005ftitle_005ffield_005fnobody.get(org.jeecgframework.tag.core.easyui.DictSelectTag.class);
    _jspx_th_t_005fdictSelect_005f0.setPageContext(_jspx_page_context);
    _jspx_th_t_005fdictSelect_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_t_005fformvalid_005f0);
    // /webpage/com/jeecg/demo/form_popupMultiValue.jsp(113,7) name = field type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_t_005fdictSelect_005f0.setField("demos[0].sex");
    // /webpage/com/jeecg/demo/form_popupMultiValue.jsp(113,7) name = typeGroupCode type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_t_005fdictSelect_005f0.setTypeGroupCode("sex");
    // /webpage/com/jeecg/demo/form_popupMultiValue.jsp(113,7) name = title type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_t_005fdictSelect_005f0.setTitle("性别");
    int _jspx_eval_t_005fdictSelect_005f0 = _jspx_th_t_005fdictSelect_005f0.doStartTag();
    if (_jspx_th_t_005fdictSelect_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ft_005fdictSelect_0026_005ftypeGroupCode_005ftitle_005ffield_005fnobody.reuse(_jspx_th_t_005fdictSelect_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005ft_005fdictSelect_0026_005ftypeGroupCode_005ftitle_005ffield_005fnobody.reuse(_jspx_th_t_005fdictSelect_005f0);
    return false;
  }

  private boolean _jspx_meth_t_005fdictSelect_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_t_005fformvalid_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  t:dictSelect
    org.jeecgframework.tag.core.easyui.DictSelectTag _jspx_th_t_005fdictSelect_005f1 = (org.jeecgframework.tag.core.easyui.DictSelectTag) _005fjspx_005ftagPool_005ft_005fdictSelect_0026_005ftypeGroupCode_005ftitle_005ffield_005fnobody.get(org.jeecgframework.tag.core.easyui.DictSelectTag.class);
    _jspx_th_t_005fdictSelect_005f1.setPageContext(_jspx_page_context);
    _jspx_th_t_005fdictSelect_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_t_005fformvalid_005f0);
    // /webpage/com/jeecg/demo/form_popupMultiValue.jsp(119,7) name = field type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_t_005fdictSelect_005f1.setField("demos[0].status");
    // /webpage/com/jeecg/demo/form_popupMultiValue.jsp(119,7) name = typeGroupCode type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_t_005fdictSelect_005f1.setTypeGroupCode("sf_yn");
    // /webpage/com/jeecg/demo/form_popupMultiValue.jsp(119,7) name = title type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_t_005fdictSelect_005f1.setTitle("入职状态");
    int _jspx_eval_t_005fdictSelect_005f1 = _jspx_th_t_005fdictSelect_005f1.doStartTag();
    if (_jspx_th_t_005fdictSelect_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ft_005fdictSelect_0026_005ftypeGroupCode_005ftitle_005ffield_005fnobody.reuse(_jspx_th_t_005fdictSelect_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005ft_005fdictSelect_0026_005ftypeGroupCode_005ftitle_005ffield_005fnobody.reuse(_jspx_th_t_005fdictSelect_005f1);
    return false;
  }

  private boolean _jspx_meth_t_005fdictSelect_005f2(javax.servlet.jsp.tagext.JspTag _jspx_th_t_005fformvalid_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  t:dictSelect
    org.jeecgframework.tag.core.easyui.DictSelectTag _jspx_th_t_005fdictSelect_005f2 = (org.jeecgframework.tag.core.easyui.DictSelectTag) _005fjspx_005ftagPool_005ft_005fdictSelect_0026_005ftypeGroupCode_005ftitle_005ffield_005fnobody.get(org.jeecgframework.tag.core.easyui.DictSelectTag.class);
    _jspx_th_t_005fdictSelect_005f2.setPageContext(_jspx_page_context);
    _jspx_th_t_005fdictSelect_005f2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_t_005fformvalid_005f0);
    // /webpage/com/jeecg/demo/form_popupMultiValue.jsp(134,7) name = field type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_t_005fdictSelect_005f2.setField("demos[1].sex");
    // /webpage/com/jeecg/demo/form_popupMultiValue.jsp(134,7) name = typeGroupCode type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_t_005fdictSelect_005f2.setTypeGroupCode("sex");
    // /webpage/com/jeecg/demo/form_popupMultiValue.jsp(134,7) name = title type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_t_005fdictSelect_005f2.setTitle("性别");
    int _jspx_eval_t_005fdictSelect_005f2 = _jspx_th_t_005fdictSelect_005f2.doStartTag();
    if (_jspx_th_t_005fdictSelect_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ft_005fdictSelect_0026_005ftypeGroupCode_005ftitle_005ffield_005fnobody.reuse(_jspx_th_t_005fdictSelect_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005ft_005fdictSelect_0026_005ftypeGroupCode_005ftitle_005ffield_005fnobody.reuse(_jspx_th_t_005fdictSelect_005f2);
    return false;
  }

  private boolean _jspx_meth_t_005fdictSelect_005f3(javax.servlet.jsp.tagext.JspTag _jspx_th_t_005fformvalid_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  t:dictSelect
    org.jeecgframework.tag.core.easyui.DictSelectTag _jspx_th_t_005fdictSelect_005f3 = (org.jeecgframework.tag.core.easyui.DictSelectTag) _005fjspx_005ftagPool_005ft_005fdictSelect_0026_005ftypeGroupCode_005ftitle_005ffield_005fnobody.get(org.jeecgframework.tag.core.easyui.DictSelectTag.class);
    _jspx_th_t_005fdictSelect_005f3.setPageContext(_jspx_page_context);
    _jspx_th_t_005fdictSelect_005f3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_t_005fformvalid_005f0);
    // /webpage/com/jeecg/demo/form_popupMultiValue.jsp(140,7) name = field type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_t_005fdictSelect_005f3.setField("demos[1].status");
    // /webpage/com/jeecg/demo/form_popupMultiValue.jsp(140,7) name = typeGroupCode type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_t_005fdictSelect_005f3.setTypeGroupCode("sf_yn");
    // /webpage/com/jeecg/demo/form_popupMultiValue.jsp(140,7) name = title type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_t_005fdictSelect_005f3.setTitle("入职状态");
    int _jspx_eval_t_005fdictSelect_005f3 = _jspx_th_t_005fdictSelect_005f3.doStartTag();
    if (_jspx_th_t_005fdictSelect_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ft_005fdictSelect_0026_005ftypeGroupCode_005ftitle_005ffield_005fnobody.reuse(_jspx_th_t_005fdictSelect_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005ft_005fdictSelect_0026_005ftypeGroupCode_005ftitle_005ffield_005fnobody.reuse(_jspx_th_t_005fdictSelect_005f3);
    return false;
  }
}
