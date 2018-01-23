<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>系统公告信息表</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="div" action="tSUsernoticeController.do?doAdd" >
			<input id="id" name="id" type="hidden" value="${tSUsernoticePage.id }">
		<fieldset class="step">
			<div class="form">
		      <label class="Validform_label">通知标题:</label>
					     	 <input id="noticeTitle" name="noticeTitle" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">通知公告内容:</label>
				 <textarea id="noticeContent" style="width:600px;" class="inputxt" rows="6" name="noticeContent"  ignore="ignore" ></textarea>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">通知公告类型:</label>
					     	 <input id="noticeType" name="noticeType" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">通告授权级别:</label>
					     	 <input id="noticeLevel" name="noticeLevel" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">阅读期限:</label>
					  <input id="noticeTerm" name="noticeTerm" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()"  ignore="ignore" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">创建者:</label>
					     	 <input id="createUser" name="createUser" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">创建时间:</label>
					  <input id="createTime" name="createTime" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()"  ignore="ignore" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">输入日期:</label>
					  <input id="inputtime" name="inputtime" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()"  ignore="ignore" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">插入时间:</label>
					  <input id="inserttimeforhis" name="inserttimeforhis" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()"  ignore="ignore" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">更新时间:</label>
					  <input id="operatetimeforhis" name="operatetimeforhis" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()"  ignore="ignore" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">扩展字符字段:</label>
					     	 <input id="vfield1" name="vfield1" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">扩展字符字段:</label>
					     	 <input id="vfield2" name="vfield2" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">扩展字符字段:</label>
					     	 <input id="vfield3" name="vfield3" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">扩展字符字段:</label>
					     	 <input id="vfield4" name="vfield4" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">扩展字符字段:</label>
					     	 <input id="vfield5" name="vfield5" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">扩展字符字段:</label>
					     	 <input id="vfield6" name="vfield6" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">扩展金额字段:</label>
					     	 <input id="nfield1" name="nfield1" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">扩展金额字段:</label>
					     	 <input id="nfield2" name="nfield2" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">扩展金额字段:</label>
					     	 <input id="nfield3" name="nfield3" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">扩展金额字段:</label>
					     	 <input id="nfield4" name="nfield4" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">扩展时间字段:</label>
					  <input id="dfield1" name="dfield1" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()"  ignore="ignore" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">扩展时间字段:</label>
					  <input id="dfield2" name="dfield2" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()"  ignore="ignore" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">扩展时间字段:</label>
					  <input id="dfield3" name="dfield3" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()"  ignore="ignore" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">扩展时间字段:</label>
					  <input id="dfield4" name="dfield4" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()"  ignore="ignore" />
		      <span class="Validform_checktip"></span>
		    </div>
	    </fieldset>
  </t:formvalid>
 </body>
  <script src = "webpage//notice/tSUsernotice.js"></script>	
	