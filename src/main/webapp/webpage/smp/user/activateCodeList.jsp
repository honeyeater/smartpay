<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container" id="activatemanger">
    <div class="row">
        <div class="col-sm-12" style="text-align: center;margin-bottom: 20px">
            <button type="button" class="btn btn-primary" onclick="buyCode()">激活码购买</button>
            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#doBuyCode" id="buyCode" style="display: none">激活码购买</button>
            <button type="button" class="btn btn-primary" onclick="doActiveB()">会员激活</button>
            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#doActiveB" id="doActiveButton" style="display: none">会员激活</button>
        </div>
        <div class="col-lg-1"></div>
        <div class="col-lg-10">
            <div class="col-sm-12">
                <table class="table table-striped table-bordered" style="border-color: #0a0c0e">
                    <thead>
                    <tr class="bg-warning">
                        <th style="font-size: 10px">激活码</th>
                        <th style="font-size: 10px">是否使用</th>
                        <th style="font-size: 10px">使用者</th>
                        <th style="font-size: 10px">使用时间</th>
                    </tr>
                    </thead>
                    <tbody>
                    </tbody>
                </table>
                <nav style="text-align: center">
                    <ul class="pagination pagination-sm">
                        <li><a href="#">共0页</a></li>
                        <li><a href="javascript:;" aria-label="Previous"><span aria-hidden="true">«</span></a></li>
                        <li><a href="#" aria-label="Next"><span aria-hidden="true">»</span></a></li>
                        <li>
                            <input type="text" class="input-mini" placeholder="0" style="width: 30px;float: left;height: 30px;" id="toPage"> <a href="javascript:gotoPageTO()">跳</a>
                        </li>
                    </ul>
                </nav>
            </div>
        </div>
        <div class="col-lg-1"></div>
    </div>
</div>



