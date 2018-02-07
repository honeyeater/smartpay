<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container" id="teamList">
    <div class="row" style="margin-top: 20px">
        <div class="col-sm-1"></div>
        <div class="col-sm-10">
            <div class="col-sm-12" style="background:rgba(250,250,250,0.5);padding-top: 20px">
                <form action="https://www.vipzftaab.com/index/teamList/" method="get" style="min-height: 30px">
                    <div class="col-sm-5">
                        <div class="form-group">
                            <label class="col-md-2 control-label" style="line-height: 30px; padding: 0px;">会员名称</label>
                            <div class="input-group date col-md-10">
                                <input class="form-control" size="16" type="text" name="un" value="">
                            </div>
                        </div>
                    </div>

                    <div class="col-sm-2">
                        <button type="submit" class="btn btn-primary">搜索</button>
                    </div>
                </form>
            </div>
            <div style="clear: both"></div>
            <div class="panel panel-success">
                <div class="panel-heading">
                    <a href="javascript:showPList();"> <h3 class="panel-title" style="text-align: center">
                        团队业绩 <i id="pList" class="glyphicon glyphicon-triangle-bottom"></i></h3>
                    </a>
                    <p style="text-align: center">本页为会员（5615588,Z03839371,8387912,Z09699166,Z01836172,Z07877992,Z02181956,Z02162186）的订单记录</p>
                </div>
                <div class="panel-body" style="padding: 5px" id="pListHolder">
                    <table class="table " style="border-radius: 10px;margin-top:5px;margin-bottom:5px;width: 100%;background-color:  white ">
                        <thead style="border:none">
                        <tr style="border:none">
                            <th style="border:none">订单编号</th>
                            <th style="border:none">P1924984</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td style="border:none">参与会员</td>
                            <td style="border:none">5615588</td>
                        </tr>
                        <tr>
                            <td style="border:none">
                                订单金额
                            </td>
                            <td style="border:none">
                                10000CNY
                            </td>
                        </tr>
                        <tr>
                            <td style="border:none">
                                排单时间
                            </td>
                            <td style="border:none">
                                2017-09-25 06:11:00
                            </td>
                        </tr>
                        </tbody>
                    </table>
                    <div style="width: 100%;text-align: center">
                        <nav style="text-align: center">
                            <ul class="pagination pagination-sm">
                                <li><a href="#">共1页</a></li>
                                <li><a href="javascript:;" aria-label="Previous"><span aria-hidden="true">«</span></a></li>
                                <li class="active">
                                    <a href="#">1</a>
                                </li>
                                <li><a href="#" aria-label="Next"><span aria-hidden="true">»</span></a></li>
                                <li>
                                    <input type="text" class="input-mini" placeholder="0" style="width: 30px;float: left;height: 30px;" id="toPage"> <a href="javascript:gotoPageTO()">跳</a>
                                </li>
                            </ul>
                        </nav>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-sm-1"></div>
    </div>
</div>
