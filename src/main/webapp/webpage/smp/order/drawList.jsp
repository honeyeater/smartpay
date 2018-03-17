<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class=" weui-bgf weui-bod_r weui-mt15">
    <h3 class="weui-f16 weui-f_b title"><i class="weui-dnb weui-v_m zj_ico"></i> 提出资金</h3>
    <div class=" weui-p15">
        <div class="table-responsive">
            <div class="">
                <table class="table2" width="100%" style="font-size: 14px;">

                    <c:if test="${not empty outlist}">
                        <c:forEach items="${outlist}" var="outOrder">

                            <tr>
                                <td><i class="glyphicon glyphicon-triangle-right weui-f12"></i> <span class="weui-c_9">编    号：</span>
                                    ${outOrder.orderCode}
                                </td>
                                <td><span class="weui-c_9">参与者：</span>
                                    ${outOrder.username}
                                </td>
                                <td><span class="weui-c_9">钱包：</span>
                                    <c:if test="${outOrder.drawWallet == '1'}">
                                        R钱包
                                    </c:if>
                                    <c:if test="${outOrder.drawWallet == '2'}">
                                        PI钱包 直推钱包
                                    </c:if>
                                </td>
                                <td><span class="weui-c_9">金额：</span> ${outOrder.orderMoney} </td>
                                <td><span class="weui-c_9">日期：</span> ${outOrder.orderTime} </td>
                                <td><span class="weui-c_9">状态：</span>
                                    <c:if test="${outOrder.orderStatus == '01' || outOrder.orderStatus == '02'}">
                                        等待处理
                                    </c:if>
                                    <c:if test="${outOrder.orderStatus == '03'}">
                                        完成
                                    </c:if>
                                </td>
                            </tr>
                        </c:forEach>
                    </c:if>
                </table>
            </div>
        </div>
    </div>
</div>
