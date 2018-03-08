<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>USDT交易信息</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="usdtTradeController.do?doAdd" >
					<input id="id" name="id" type="hidden" value="${usdtTradePage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							用户名:
						</label>
					</td>
					<td class="value">
					     	 <input id="username" name="username" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">用户名</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							会员级别:
						</label>
					</td>
					<td class="value">
					     	 <input id="tradeNo" name="tradeNo" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">会员级别</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							货币类型:
						</label>
					</td>
					<td class="value">
					     	 <input id="currencyType" name="currencyType" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">货币类型</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							价格:
						</label>
					</td>
					<td class="value">
					     	 <input id="price" name="price" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">价格</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							数量:
						</label>
					</td>
					<td class="value">
					     	 <input id="num" name="num" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">数量</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							金额:
						</label>
					</td>
					<td class="value">
					     	 <input id="money" name="money" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">金额</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							手续费比例:
						</label>
					</td>
					<td class="value">
					     	 <input id="feeRate" name="feeRate" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">手续费比例</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							费用:
						</label>
					</td>
					<td class="value">
					     	 <input id="fee" name="fee" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">费用</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							交易类型:
						</label>
					</td>
					<td class="value">
					     	 <input id="tradeType" name="tradeType" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">交易类型</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							状态:
						</label>
					</td>
					<td class="value">
					     	 <input id="status" name="status" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">状态</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							提出地址:
						</label>
					</td>
					<td class="value">
					     	 <input id="drawUrl" name="drawUrl" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">提出地址</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							输入日期:
						</label>
					</td>
					<td class="value">
							   <input id="inputtime" name="inputtime" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()"  ignore="ignore" />    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">输入日期</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							插入时间:
						</label>
					</td>
					<td class="value">
							   <input id="inserttimeforhis" name="inserttimeforhis" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()"  ignore="ignore" />    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">插入时间</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							更新时间:
						</label>
					</td>
					<td class="value">
							   <input id="operatetimeforhis" name="operatetimeforhis" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()"  ignore="ignore" />    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">更新时间</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							扩展字符字段:
						</label>
					</td>
					<td class="value">
					     	 <input id="vfield1" name="vfield1" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">扩展字符字段</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							扩展字符字段:
						</label>
					</td>
					<td class="value">
					     	 <input id="vfield2" name="vfield2" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">扩展字符字段</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							扩展字符字段:
						</label>
					</td>
					<td class="value">
					     	 <input id="vfield3" name="vfield3" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">扩展字符字段</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							扩展字符字段:
						</label>
					</td>
					<td class="value">
					     	 <input id="vfield4" name="vfield4" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">扩展字符字段</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							扩展字符字段:
						</label>
					</td>
					<td class="value">
					     	 <input id="vfield5" name="vfield5" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">扩展字符字段</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							扩展字符字段:
						</label>
					</td>
					<td class="value">
					     	 <input id="vfield6" name="vfield6" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">扩展字符字段</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							扩展金额字段:
						</label>
					</td>
					<td class="value">
					     	 <input id="nfield1" name="nfield1" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">扩展金额字段</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							扩展金额字段:
						</label>
					</td>
					<td class="value">
					     	 <input id="nfield2" name="nfield2" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">扩展金额字段</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							扩展金额字段:
						</label>
					</td>
					<td class="value">
					     	 <input id="nfield3" name="nfield3" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">扩展金额字段</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							扩展金额字段:
						</label>
					</td>
					<td class="value">
					     	 <input id="nfield4" name="nfield4" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">扩展金额字段</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							扩展时间字段:
						</label>
					</td>
					<td class="value">
							   <input id="dfield1" name="dfield1" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()"  ignore="ignore" />    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">扩展时间字段</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							扩展时间字段:
						</label>
					</td>
					<td class="value">
							   <input id="dfield2" name="dfield2" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()"  ignore="ignore" />    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">扩展时间字段</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							扩展时间字段:
						</label>
					</td>
					<td class="value">
							   <input id="dfield3" name="dfield3" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()"  ignore="ignore" />    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">扩展时间字段</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							扩展时间字段:
						</label>
					</td>
					<td class="value">
							   <input id="dfield4" name="dfield4" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()"  ignore="ignore" />    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">扩展时间字段</label>
						</td>
					</tr>
				
				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage//smp/usdtTrade.js"></script>		
