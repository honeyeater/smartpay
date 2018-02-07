<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container" id="tradelist">
        <div class="row">
            <div class="col-sm-1"></div>
            <div class="col-sm-10">
                <div class="col-sm-12" style="background:rgba(250,250,250,0.5);padding-top: 20px">
                    <link href="https://www.vipzftaab.com//t/js/datePicker/css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">

                    <form action="https://www.vipzftaab.com/index/logList/" method="get" style="min-height: 30px">
                        <div class="col-sm-5">
                            <div class="form-group">
                                <label for="bTimeDate" class="col-md-2 control-label" style="line-height: 30px; padding: 0px;">开始</label>
                                <div class="input-group date form_datetime col-md-10" data-date="" data-date-format="yyyy-mm-dd HH:ii:ss" data-link-field="bTimeDate">
                                    <input class="form-control" size="16" type="text" value="" readonly="">

                                    <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                </div>
                                <input type="hidden" id="bTimeDate" name="bTimeDate" value=""><br>
                            </div>
                        </div>

                        <div class="col-sm-5">
                            <div class="form-group">
                                <label for="eTimeDate" class="col-md-2 control-label" style="line-height: 30px; padding: 0px;">结束</label>
                                <div class="input-group date form_datetime col-md-10" data-date="" data-date-format="yyyy-mm-dd HH:ii:ss" data-link-field="eTimeDate">
                                    <input class="form-control" size="16" type="text" value="" readonly="">

                                    <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                </div>
                                <input type="hidden" id="eTimeDate" name="eTimeDate" value=""><br>
                            </div>
                        </div>

                        <div class="col-sm-2">
                            <button type="submit" class="btn btn-primary">搜索</button>
                        </div>
                    </form>
                    <script type="text/javascript" src="https://www.vipzftaab.com//t/js/datePicker/js/bootstrap-datetimepicker.min.js" charset="UTF-8"></script>
                    <script type="text/javascript" src="https://www.vipzftaab.com//t/js/datePicker/js/locales/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
                    <script>
                        $('.form_datetime').datetimepicker({
                            language:  'zh-CN',
                            weekStart: 1,
                            todayBtn:  1,
                            autoclose: 1,
                            todayHighlight: 1,
                            startView: 2,
                            forceParse: 0,
                            showMeridian: 1
                        });
                    </script>
                    <table class="table table-striped table-bordered " style="border-color: #0a0c0e">
                        <thead>
                        <tr>

                            <th style="font-size: 10px">静态奖金</th>
                            <th style="font-size: 10px">动态奖金</th>
                            <th style="font-size: 10px">其他奖金</th>
                            <th style="font-size: 10px">待返金额</th>
                            <th style="font-size: 10px">释放钱包</th>
                            <th style="font-size: 10px">时间</th>
                            <th style="font-size: 10px">原因</th>

                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td style="font-size: 10px">0.00</td>
                            <td style="font-size: 10px">100.00</td>
                            <td style="font-size: 10px">0.00</td>
                            <td style="font-size: 10px">0</td>
                            <td style="font-size: 10px">0</td>

                            <td style="font-size: 10px">2018-01-31 09:47:00</td>
                            <td style="font-size: 10px">1代管理奖</td>

                        </tr>
                        </tbody>
                    </table>
                    <nav style="text-align: center">
                        <ul class="pagination pagination-sm">
                            <li><a href="#">共9页</a></li>
                            <li><a href="javascript:;" aria-label="Previous"><span aria-hidden="true">«</span></a></li>
                            <li class="active">
                                <a href="#">1</a>
                            </li>
                            <li><a href="javascript:gotoPage(2)">2</a></li>
                            <li><a href="javascript:gotoPage(3)">3</a></li>
                            <li><a href="javascript:gotoPage(4)">4</a></li>
                            <li><a href="javascript:gotoPage(5)">5</a></li>
                            <li><a href="javascript:gotoPage(6)">6</a></li>
                            <li><a href="javascript:gotoPage(2)" aria-label="Next"><span aria-hidden="true">»</span></a></li>
                            <li>
                                <input type="text" class="input-mini" placeholder="0" style="width: 30px;float: left;height: 30px;" id="toPage"> <a href="javascript:gotoPageTO()">跳</a>
                            </li>
                        </ul>
                    </nav>
                </div>

            </div>
            <div class="col-sm-1"></div>

        </div>
    </div>


