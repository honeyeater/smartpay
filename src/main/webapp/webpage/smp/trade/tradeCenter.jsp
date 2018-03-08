<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container" id="tradeCenter">
    <div class="row">
        <div class="col-lg-2">
        </div>
        <div class="col-lg-4" style="background: green">
            <form class="form-horizontal">
                <div class="form-group">
                    <label class="control-label" for="buyprice">买入价格</label>
                    <div class="controls">
                        <input id="buyprice" type="text" class="form-control"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label" for="buynum">买入数量</label>
                    <div class="controls">
                        <input id="buynum" type="text" class="form-control"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label" for="buyfee">手续费</label>
                    <div class="controls">
                        <input id="buyfee" type="text" class="form-control"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label" for="tradebuyprice">交易金额</label>
                    <div class="controls">
                        <input id="tradebuyprice" type="text" />
                    </div>
                </div>
                <div class="form-group">
                    <div class="controls">
                        <button type="submit" class="btn btn-info">卖出</button>
                    </div>
                </div>
            </form>
        </div>
        <div class="col-lg-4">
            <form class="form-horizontal" style="background-color: green">
                <div class="form-group">
                    <label class="control-label" for="saleprice">卖出价格</label>
                    <div class="controls">
                        <input id="saleprice" type="text" class="form-control"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label" for="salenum">卖出数量</label>
                    <div class="controls">
                        <input id="salenum" type="text" class="form-control"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label" for="salefee">手续费</label>
                    <div class="controls">
                        <input id="salefee" type="text" class="form-control"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label" for="tradesaleprice">交易金额</label>
                    <div class="controls">
                        <input id="tradesaleprice" type="text" />
                    </div>
                </div>
                <div class="form-group">
                    <div class="controls">
                        <button type="submit" class="btn btn-info">卖出</button>
                    </div>
                </div>
            </form>
        </div>
        <div class="col-lg-2"></div>
    </div>
</div>
