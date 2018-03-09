<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container" id="tradeCenter">
    <div class="row" style="margin-top: 10px;padding-top: 10px;padding-bottom: 20px">
        <div class="col-sm-6" style="margin-bottom:-20px;margin-top: -20px;">
            <div class="panel panel-default">
                <div class="panel-heading">
                    买入
                </div>
                <div class="panel-body">
                    <form class="form-horizontal">
                        <div class="form-group">
                            <label class="col-lg-4 control-label" for="buyprice">买入价格</label>
                            <div class="col-lg-6">
                                <input id="buyprice" name="buyprice" type="text" class="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-4 control-label" for="buynum">买入数量</label>
                            <div class="col-lg-6">
                                <input id="buynum" name="buynum" type="text" class="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-4 control-label" for="buyfee">手续费</label>
                            <div class="col-lg-6">
                                <input id="buyfee" name="buyfee" type="text" class="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-4 control-label" for="buysumamount">交易金额</label>
                            <div class="col-lg-6">
                                <input id="buysumamount" name="buysumamount" type="text" class="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-4 control-label" for="buysafepwd">安全密码</label>
                            <div class="col-lg-6">
                                <input id="buysafepwd" name="buysafepwd" type="text" class="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <input type="hidden" id="buyalipay" name="buyalipay">
                            <input type="hidden" id="buybankcard" name="buybankcard">
                            <div class="col-lg-8 col-lg-offset-2">
                                <button type="submit" class="btn btn-info btn-block">买入</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <div class="col-sm-6" style="margin-bottom:-20px;margin-top: -20px;">
            <div class="panel panel-default">
                <div class="panel-heading">
                    买入
                </div>
                <div class="panel-body">
                    <form class="form-horizontal">
                        <div class="form-group">
                            <label class="col-lg-4 control-label" for="saleprice">卖出价格</label>
                            <div class="col-lg-6">
                                <input id="saleprice" name="saleprice" type="text" class="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-4 control-label" for="salenum">卖出数量</label>
                            <div class="col-lg-6">
                                <input id="salenum" name="salenum" type="text" class="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-4 control-label" for="salefee">手续费</label>
                            <div class="col-lg-6">
                                <input id="salefee" name="salefee" type="text" class="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-4 control-label" for="salefeerate">手续费比例</label>
                            <div class="col-lg-6">
                                <input id="salefeerate" name="salefeerate" type="text" class="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-4 control-label" for="salesumamount">交易金额</label>
                            <div class="col-lg-6">
                                <input id="salesumamount" name="salesumamount" class="form-control" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-4 control-label" for="saledrawurl">交易金额</label>
                            <div class="col-lg-6">
                                <input id="saledrawurl" name="saledrawurl" class="form-control" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-4 control-label" for="saleSafePwd">安全密码</label>
                            <div class="col-lg-6">
                                <input id="saleSafePwd" name="saleSafePwd" class="form-control" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-lg-8 col-lg-offset-2">
                                <button type="submit" class="btn btn-info btn-block">卖出</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

