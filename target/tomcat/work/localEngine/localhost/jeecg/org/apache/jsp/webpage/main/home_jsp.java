package org.apache.jsp.webpage.main;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"plug-in/accordion/css/accordion.css\">\n");
      out.write("<!-- add-begin--Author:jg_renjie  Date:20150610 for：今天需要提醒的【系统信息】 -->\t\n");
      out.write("<script type=\"text/javascript\" src=\"plug-in/login/js/getMsgs.js\"></script>\n");
      out.write("<!-- add-begin--Author:jg_renjie  Date:20150610 for：今天需要提醒的【系统信息】\t -->\n");
      out.write("<div style=\"margin-top: 14px;\">\n");
      out.write("<h3>简介</h3>\n");
      out.write("<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;JEECG（J2EE Code Generation）是一款基于代码生成器的微云快速开发平台，引领新开发模式(智能开发\\在线开发\\插件开发\\移动开发\\流程开发)， 可以帮助解决Java项目80%的重复工作，让开发更多关注业务逻辑。既能快速提高开发效率，帮助公司节省人力成本，同时又不失灵活性。 JEECG快速开发宗旨是：简单功能由代码生成器生成使用; 复杂业务采用表单自定义，业务流程使用工作流实现、扩展出业务接口，供开发编写业务逻辑。 实现了流程任务节点和任务接口的灵活配置，既保证了公司流程的保密性，又减少了开发人员的工作量</p>\n");
      out.write("<h3>适用项目</h3>\n");
      out.write("<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;JEECG快速开发平台，可以应用在任何J2EE项目的开发中，尤其适合企业信息管理系统（MIS）、内部办公系统（OA）、企业资源计划系统（ERP）、客户关系管理系统（CRM）等，其半智能手工Merge的开发方式，可以显著提高开发效率70%以上，极大降低开发成本；JEECG尤为显著的支持SAAS企业级应用开发，插件机制更好的支持了SAAS云应用<font color=\"red\">new</font>需求。</p>\n");
      out.write("<h3>架构说明</h3>\n");
      out.write("<ul>\n");
      out.write("\t<li>JEECG开发平台，采用SpringMVC + Hibernate + Minidao(类Mybatis) + Easyui(UI库)+ Jquery + Boostrap + Ehcache + Redis + Ztree等基础架构,采用面向声明的开发模式， 基于泛型编写极少代码即可实现复杂的数据展示、数据编辑、表单处理等功能，再配合代码生成器的使用,将J2EE的开发效率提高6倍以上，可以将代码减少60%以上。</li>\n");
      out.write("\t<li>JEECG_<font color=\"red\">v_3.7.1 </font>功能点: <b>1.代码生成器</b> <b>2.数据权限</b> <b>3.Online表单</b> <b>4.工作流组件</b> <b>5.移动OA</b> <b>6.EasyPOI工具类</b> <b>7.查询过滤器</b> <b>8.UI库</b> <b>9.国际化</b> <b>10.多数据源</b> <b>11.自定义表单</b> <b>12.在线报表</b> <b>13.移动报表</b> <b>14.日志监控</b> <b>15.首页切换</b> <b>16.插件开发</b></li>\n");
      out.write("\t<li>[1].代码生成器，支持多种数据模型,根据表生成对应的Entity,Service,Dao,Action,JSP等,增删改查功能生成直接使用</li>\n");
      out.write("\t<li>[2].用户权限，强大数据权限<font color=\"red\">new</font>，支持精细化数据权限控制，控制到行级，列表级，表单字段级，实现不同人看不同数据，不同人对同一个页面操作不同字段</li>\n");
      out.write("\t<li>[3].Online表单，通过在线配置实现表模型的增删改查功能，零代码，支持用户自定义表单风格，<font color=\"red\">new</font>表单配置PC样式和移动样式，针对移动端采用移动样式展示</li>\n");
      out.write("\t<li>[4].简易Excel导入导出，支持单表导出和一对多表模式导出，生成的代码自带导入导出功能</li>\n");
      out.write("\t<li>[5].工作流组件，集成activiti工作流引擎，在线画流程，在线制作表单，中国国情流程设计，体系完善，功能灵活</li>\n");
      out.write("\t<li>[6].移动OA<font color=\"red\">new</font>，移动OA审批功能，采用H5技术，实现手机移动办公，无缝对接微信、钉钉、微信企业号、也可以做APP</li>\n");
      out.write("\t<li>[7].查询过滤器，查询功能自动生成，后台动态拼SQL追加查询条件；支持多种匹配方式（全匹配/模糊查询/包含查询/不匹配查询） </li>\n");
      out.write("\t<li>[8].UI标签库，针对WEB UI进行标准封装，页面统一采用UI标签实现功能：数据datagrid,表单校验,Popup,Tab等，实现JSP页面零JS，开发维护非常高效</li>\n");
      out.write("\t<li>[9].国际化，支持多语言，多语言系统切换</li>\n");
      out.write("\t<li>[10].多数据源，在线配置数据源，数据源工作封装,简易调用其他系统数据</li>\n");
      out.write("\t<li>[11].自定义表单<font color=\"red\">new</font>，支持表单自定义，个性化布局，独有的设计模式，可以灵活实现复杂表单实现</li>\n");
      out.write("\t<li>[12].在线报表，无需编码，通过在线配置方式，实现曲线图，柱状图，数据等报表</li>\n");
      out.write("\t<li>[13].移动图表<font color=\"red\">new</font>，在线配置移动报表，采用H5技术，可以手机端查看</li>\n");
      out.write("\t<li>[14].系统日志监控，详细记录操作日志，可支持追查表修改日志</li>\n");
      out.write("\t<li>[15].首页切换，支持自定义首页风格（经典风格、Shortcut风格、ACE bootstrap风格、云桌面风格）</li>\n");
      out.write("\t<li>[16].插件开发<font color=\"red\">new</font>，业务功能组件以插件方式集成平台，也可以单独部署发发布，有力支撑了SAAS云应用系统需求</li>\n");
      out.write("\t<li>JEECG 开发平台，经过专业性能压力测试，保证后台数据的准确性和页面访问速度</li>\n");
      out.write("\t<li>支持多种浏览器: IE, 火狐, Google 等浏览器访问速度都很快</li>\n");
      out.write("\t<li>支持数据库: Mysql,Oracle11g,SqlServer、Postgresql等</li>\n");
      out.write("\t<li>基础权限: 用户，角色，菜单权限，按钮权限，数据权限</li>\n");
      out.write("\t<li>智能报表集成: 简易的图像报表工具和Excel导入导出</li>\n");
      out.write("\t<li>Web容器测试通过的有Jetty和Tomcat6等</li>\n");
      out.write("\t<li>要求JDK1.6+</li>\n");
      out.write("</ul>\n");
      out.write("</div>\n");
      out.write("<div style=\"margin-top: 20px;\">\n");
      out.write("<h3>技术交流</h3>\n");
      out.write("<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;本系统由JEECG开源社区提供，JEECG微云快速开发平台，永久开源免费，为大家提供最好的<b>企业级快速开发平台</b></p>\n");
      out.write("<ul>\n");
      out.write("\t<li>作  者 ：<a href=\"http://www.jeecg.org/forum.php?mod=viewthread&tid=1047\">张代浩</a></li>\n");
      out.write("\t<li>邮  箱 ：jeecg@sina.com</li>\n");
      out.write("\t<li>官  网 ：<a href=\"http://www.jeecg.org\" target=\"_blank\">www.jeecg.org</a></li>\n");
      out.write("\t<li>QQ 群: 176031980、106838471, 106259349, 289782002</li>\n");
      out.write("\t<li><a href=\"http://www.guojusoft.com\" target=\"_blank\" style=\"color: red\"> 【 JEECG针对企业用户提供商业版本，详细咨询请联系官方 】 </a></li>\n");
      out.write("</ul>\n");
      out.write("</div>");
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
