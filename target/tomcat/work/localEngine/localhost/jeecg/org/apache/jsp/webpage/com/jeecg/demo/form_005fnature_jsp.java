package org.apache.jsp.webpage.com.jeecg.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class form_005fnature_jsp extends org.apache.jasper.runtime.HttpJspBase
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
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005ft_005fformvalid_0026_005flayout_005fformid_005fdialog;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005ft_005fbase_0026_005ftype_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005ft_005fformvalid_0026_005flayout_005fformid_005fdialog = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005ft_005fbase_0026_005ftype_005fnobody.release();
    _005fjspx_005ftagPool_005ft_005fformvalid_0026_005flayout_005fformid_005fdialog.release();
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<title>form_nature</title>\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=9; IE=8; IE=7; IE=EDGE\"/>\n");
      if (_jspx_meth_t_005fbase_005f0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\n");
      out.write("<!-- ztree -->\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"plug-in/ztree/css/zTreeStyle.css\"></link>\n");
      out.write("<script type=\"text/javascript\" src=\"plug-in/ztree/js/jquery.ztree.core-3.5.min.js\" ></script>\n");
      out.write("<script type=\"text/javascript\" src=\"plug-in/ztree/js/jquery.ztree.excheck-3.5.min.js\"></script>\n");
      out.write("\n");
      out.write("<!-- 文件上传 -->\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"plug-in/webuploader/webuploader.css\"></link>\n");
      out.write("<script type=\"text/javascript\" src=\"plug-in/webuploader/webuploader.min.js\" ></script>\n");
      out.write("\n");
      out.write("<!-- 自动补全 -->\n");
      out.write("<link rel=\"stylesheet\" href=\"plug-in/jquery/jquery-autocomplete/jquery.autocomplete.css\" type=\"text/css\"></link>\n");
      out.write("<script type=\"text/javascript\" src=\"plug-in/jquery/jquery-autocomplete/jquery.autocomplete.min.js\"></script>\n");
      out.write("\n");
      out.write("<!-- 联动 -->\n");
      out.write("<script src=\"plug-in/jquery/jquery.regionselect.js\" type=\"text/javascript\"></script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      if (_jspx_meth_t_005fformvalid_005f0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("<!-- update-end--Author:yugwu  Date:20170626 for：[TASK #2135]【浏览器兼容问题】IE8下样式乱了-------------------- -->\n");
      out.write("\n");
      out.write("<!-- update-begin--Author:taoYan  Date:20170803 for：代码格式修改 -->\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("function printobj(obj){\n");
      out.write("\tvar str='[';\n");
      out.write("\tfor(var a in obj){\n");
      out.write("\t\tstr+=a+':'+obj[a]+\",\";\n");
      out.write("\t}\n");
      out.write("\tstr+=0+':0]';\n");
      out.write("\treturn str;\n");
      out.write("}\n");
      out.write("function getTremValueuserName() {\n");
      out.write("\treturn $(\"#userNameAuto\").val();\n");
      out.write("}\n");
      out.write("$(function() {\n");
      out.write("\t//ztree\n");
      out.write("\tvar setting = {\n");
      out.write("\t\tcheck: {\n");
      out.write("\t\t\tenable: true\n");
      out.write("\t\t},\n");
      out.write("\t\tview: {\n");
      out.write("\t\t\tdblClickExpand: true\n");
      out.write("\t\t},\n");
      out.write("\t\tdata: {\n");
      out.write("\t\t\tsimpleData: {\n");
      out.write("\t\t\t\tenable: true\n");
      out.write("\t\t\t}\n");
      out.write("\t\t}\n");
      out.write("\t};\n");
      out.write("\tvar zNodes=jQuery.parseJSON('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${regions}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("');\n");
      out.write("\t$.fn.zTree.init($(\"#treeDemo\"), setting, zNodes);\n");
      out.write("\t\n");
      out.write("\t//省市区下拉\n");
      out.write("\t$(\"#province\").regionselect({\n");
      out.write("\t\t\turl:'");
      out.print(basePath);
      out.write("/jeecgFormDemoController.do?regionSelect'\n");
      out.write("\t});\n");
      out.write("\t\n");
      out.write("\t/*-------------------------------------------文件上传----------------------------------------------*/\n");
      out.write("\tvar urlc= '");
      out.print(basePath);
      out.write("/systemController/filedeal.do';\n");
      out.write("\tvar BASE_URL=\"");
      out.print(basePath);
      out.write("\";\n");
      out.write("\tvar uploader = WebUploader.create({\n");
      out.write("\t    // swf文件路径\n");
      out.write("\t    swf: BASE_URL+'/plug-in/webuploader/Uploader.swf',\n");
      out.write("\t    // 文件接收服务端。\n");
      out.write("\t\tserver: urlc,\n");
      out.write("\t    // 选择文件的按钮。可选。\n");
      out.write("\t    // 内部根据当前运行是创建，可能是input元素，也可能是flash.\n");
      out.write("\t    pick: '#picker',\n");
      out.write("\t    // 不压缩image, 默认如果是jpeg，文件上传前会压缩一把再上传！\n");
      out.write("\t    resize: false,\n");
      out.write("\t    //指明参数名称，后台也用这个参数接收文件\n");
      out.write("\t    duplicate: false,\n");
      out.write("\t    auto: true,\n");
      out.write("\t    //每次上传附带参数\n");
      out.write("\t    formData:{\"uparg\":\"ggfile\"}\n");
      out.write("\t \n");
      out.write("\t});\n");
      out.write("\tuploader.on( 'fileQueued', function( file ) {\n");
      out.write("\t\t$(\"#thelist\").append( '<div id=\"' + file.id + '\" class=\"item\">' +\n");
      out.write("\t        '<div class=\"state\">'+file.name+'---等待上传...</div>' +\n");
      out.write("\t    '</div>' );\n");
      out.write("\t}); \n");
      out.write("\t\n");
      out.write("\t//文件上传过程中创建进度条实时显示.\n");
      out.write("\t uploader.on( 'uploadProgress', function( file, percentage ) {\n");
      out.write("\t    var $li = $( '#'+file.id ),\n");
      out.write("\t        $percent = $li.find('.progress .progress-bar');\n");
      out.write("\t    // 避免重复创建\n");
      out.write("\t    if ( !$percent.length ) {\n");
      out.write("\t        $percent = $('<div class=\"progress progress-striped active\">' +\n");
      out.write("\t          '<div class=\"progress-bar\" role=\"progressbar\" style=\"width: 0%\">' +\n");
      out.write("\t          '</div>' +\n");
      out.write("\t        '</div>').appendTo( $li ).find('.progress-bar');\n");
      out.write("\t    }\n");
      out.write("\t    $li.find('div.state').html(file.name+'---上传中');\n");
      out.write("\t    $percent.css( 'width', percentage * 100 + '%' );\n");
      out.write("\t});\n");
      out.write("\tuploader.on( 'uploadSuccess', function(file) {\n");
      out.write("\t    $( '#'+file.id ).find('div.state').html(file.name+'---上传成功!');\n");
      out.write("\t});\n");
      out.write("\tuploader.on( 'uploadError', function( file) {\n");
      out.write("\t    $( '#'+file.id ).find('div.state').html(file.name+'---上传出错');\n");
      out.write("\t});\n");
      out.write("\tuploader.on( 'uploadComplete', function( file ) {\n");
      out.write("\t   $( '#'+file.id ).find('.progress').fadeOut('slow');\n");
      out.write("\t}); \n");
      out.write("\t/*-------------------------------------------文件上传----------------------------------------------*/\n");
      out.write("\t\n");
      out.write("\t/*-------------------------------------------自动补全----------------------------------------------*/\n");
      out.write("\t$(\"#userNameAuto\").autocomplete(\"jeecgFormDemoController.do?getAutocompleteData\", {\n");
      out.write("        max: 5,\n");
      out.write("        minChars: 1,\n");
      out.write("        width: 200,\n");
      out.write("        scrollHeight: 100,\n");
      out.write("        matchContains: true,\n");
      out.write("        autoFill: false,\n");
      out.write("        extraParams: {\n");
      out.write("            featureClass: \"P\",\n");
      out.write("            style: \"full\",\n");
      out.write("            maxRows: 10,\n");
      out.write("            labelField: \"userName\",\n");
      out.write("            valueField: \"userName\",\n");
      out.write("            searchField: \"userName\",\n");
      out.write("            entityName: \"TSUser\",\n");
      out.write("            trem: getTremValueuserName\n");
      out.write("        },\n");
      out.write("        parse: function(data) {\n");
      out.write("            return jeecgAutoParse.call(this, data);\n");
      out.write("        },\n");
      out.write("        formatItem: function(row, i, max) {\n");
      out.write("            return row['userName'];\n");
      out.write("        }\n");
      out.write("    }).result(function(event, row, formatted) {\n");
      out.write("        $(\"#userNameAuto\").val(row['userName']);\n");
      out.write("    });\n");
      out.write("\t/*-------------------------------------------自动补全----------------------------------------------*/\n");
      out.write("\n");
      out.write("\t$(\"div.webuploader-container\").css(\"width\",\"78px\");\n");
      out.write("\n");
      out.write("});\n");
      out.write("</script>\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("<!-- update-end--Author:taoYan  Date:20170803 for：代码格式修改 -->");
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
    // /webpage/com/jeecg/demo/form_nature.jsp(8,0) name = type type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_t_005fbase_005f0.setType("jquery,easyui,tools");
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
    org.jeecgframework.tag.core.easyui.FormValidationTag _jspx_th_t_005fformvalid_005f0 = (org.jeecgframework.tag.core.easyui.FormValidationTag) _005fjspx_005ftagPool_005ft_005fformvalid_0026_005flayout_005fformid_005fdialog.get(org.jeecgframework.tag.core.easyui.FormValidationTag.class);
    _jspx_th_t_005fformvalid_005f0.setPageContext(_jspx_page_context);
    _jspx_th_t_005fformvalid_005f0.setParent(null);
    // /webpage/com/jeecg/demo/form_nature.jsp(27,0) name = layout type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_t_005fformvalid_005f0.setLayout("div");
    // /webpage/com/jeecg/demo/form_nature.jsp(27,0) name = formid type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_t_005fformvalid_005f0.setFormid("dd");
    // /webpage/com/jeecg/demo/form_nature.jsp(27,0) name = dialog type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_t_005fformvalid_005f0.setDialog(false);
    int _jspx_eval_t_005fformvalid_005f0 = _jspx_th_t_005fformvalid_005f0.doStartTag();
    if (_jspx_eval_t_005fformvalid_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("\n");
        out.write("<!-- update-begin--Author:yugwu  Date:20170626 for：[TASK #2135]【浏览器兼容问题】IE8下样式乱了-------------------- -->\n");
        out.write(" <fieldset>\n");
        out.write(" <legend>文件上传</legend>\n");
        out.write("\t<div id=\"uploader\" class=\"wu-example\">\n");
        out.write("\t    <!--用来存放文件信息-->\n");
        out.write("\t    <div id=\"thelist\" class=\"uploader-list\"></div>\n");
        out.write("\t    <div class=\"btns\">\n");
        out.write("\t        <div id=\"picker\">选择文件</div>\n");
        out.write("\t    </div>\n");
        out.write("\t</div>\n");
        out.write(" </fieldset>\n");
        out.write(" \n");
        out.write(" <fieldset>\n");
        out.write(" <legend>autocomplete</legend>\n");
        out.write("  <table>\n");
        out.write("\t<tr>\n");
        out.write("\t\t<td style=\"width:90px;text-align: right;\">用户名自动补全:</td>\n");
        out.write("\t\t<td>\n");
        out.write("\t\t\t<input type=\"text\" id=\"userNameAuto\" name=\"userName\" class=\"ac_input\">\n");
        out.write("\t\t</td>\n");
        out.write("\t</tr>\n");
        out.write(" </table>\n");
        out.write(" </fieldset>\n");
        out.write("  \n");
        out.write(" <fieldset>\n");
        out.write(" <legend>联动下拉省市区</legend>\n");
        out.write("\t<!-- update-begin_author:taoYan date:20170803 for:修复ie下样式变乱   -->\n");
        out.write(" \t<div style=\"width:80%;margin:5px 0 0 10px;\">\n");
        out.write("\t  <input type=\"text\" id=\"province\" style=\"width:32%;\" value=\"\"/> \n");
        out.write("\t  <input type=\"text\" id=\"city\" style=\"width:32%;\" value=\"\"/> \n");
        out.write("\t  <input type=\"text\" id=\"area\" style=\"width:32%;\" value=\"\"/> \n");
        out.write(" \t</div>\n");
        out.write(" </fieldset>\n");
        out.write(" \n");
        out.write(" <fieldset>\n");
        out.write(" <legend>ztree</legend>\n");
        out.write(" \t<div style=\"clear:both\"></div>\n");
        out.write(" \t<div class=\"zTreeDemoBackground left\">\n");
        out.write("\t\t<ul id=\"treeDemo\" class=\"ztree\"></ul>\n");
        out.write("\t</div>\n");
        out.write(" </fieldset>\n");
        out.write(" <!-- update-end-author:taoYan date:20170803 for:修复ie下样式变乱  -->\n");
        out.write(" \n");
        out.write(" <fieldset>\n");
        out.write(" <legend>ueditor</legend>\n");
        out.write(" \t \t<table>\n");
        out.write("\t<tr>\n");
        out.write("\t\t<!-- <td align=\"right\"><label class=\"Validform_label\">demo:</label> -->\n");
        out.write("\t\t<td>\n");
        out.write("\t\t\t<script type=\"text/javascript\"  charset=\"utf-8\" src=\"plug-in/ueditor/ueditor.config.js\"></script>\n");
        out.write("\t\t\t<script type=\"text/javascript\"  charset=\"utf-8\" src=\"plug-in/ueditor/ueditor.all.min.js\"></script>\n");
        out.write("\t    \t<textarea name=\"ueditorContent\" id=\"ueditorContent\" style=\"width: 650px;\"></textarea>\n");
        out.write("\t\t    <script type=\"text/javascript\">\n");
        out.write("\t\t        var editor = UE.getEditor('ueditorContent');\n");
        out.write("\t\t    </script>\n");
        out.write("\t\t    <span class=\"Validform_checktip\"></span>\n");
        out.write("\t\t</td>\n");
        out.write("\t</tr>\n");
        out.write(" \t</table>\n");
        out.write(" </fieldset>\n");
        int evalDoAfterBody = _jspx_th_t_005fformvalid_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_t_005fformvalid_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ft_005fformvalid_0026_005flayout_005fformid_005fdialog.reuse(_jspx_th_t_005fformvalid_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005ft_005fformvalid_0026_005flayout_005fformid_005fdialog.reuse(_jspx_th_t_005fformvalid_005f0);
    return false;
  }
}
