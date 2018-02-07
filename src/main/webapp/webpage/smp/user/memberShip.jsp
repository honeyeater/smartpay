<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container" id="expandrel">
    <div class="row" style="margin-top: 20px">

        <div class="row">

            <div class="col-lg-2"></div>
            <div class="col-lg-8">
                <div class="col-sm-12" style="background:rgba(250,250,250,0.5);padding-top: 20px">
                    <style>
                        /*
                            Sitemap Styler
                        */

                        #sitemap, #sitemap ul, #sitemap li{

                            padding:0;
                            list-style:none;
                        }
                        #sitemap{
                            border-left:solid 1px #333333;}
                        #sitemap ul{
                            margin-left: 15px;
                            border-left:solid 1px #333333;
                            display:none;
                        }
                        #sitemap li{
                            line-height:200%;
                            margin-top:1px;
                            background:#eee;
                            position:relative;
                            width:100%;
                        }
                        /* IE leaves a blank space where span is added so this is to avoid that */
                        * html #sitemap li{
                            float:left;
                            display:inline;
                        }

                        #sitemap li a{
                            padding-left:28px;}
                        #sitemap li span{
                            float:left;position:absolute;top:5px;left:5px;width:13px;height:13px;cursor:auto;font-size:0;}
                        #sitemap li span, #sitemap li span.collapsed{
                            background:url('https://www.vipzftaab.com//img/collapsed.gif') no-repeat 0 0;}
                        #sitemap li span.expanded{
                            background:url('https://www.vipzftaab.com//img/expanded.gif') no-repeat 0 0;}

                        /* second level */


                        /*  */
                        .ctree{
                            margin:0;
                            padding:0;
                            background:#f1f1f1;
                            font:70% Arial, Helvetica, sans-serif;
                            color:#555;
                            line-height:150%;
                            text-align:left;
                        }
                        .ctree a{
                            text-decoration:none;
                            color:#057fac;
                        }
                        .ctree a:hover{
                            text-decoration:none;
                            color:#999;
                        }
                        .ctree h1{
                            font-size:140%;
                            margin:0 20px;
                            line-height:80px;
                        }
                        .ctree #container{
                            margin:0 auto;
                            width:680px;
                            background:#fff;
                            padding-bottom:20px;
                        }
                        .ctree #content{
                            margin:0 20px;
                        }
                        .ctree p{
                            margin:0 auto;
                            width:680px;
                            padding:1em 0;
                        }

                    </style>

                    <div class="ctree">
                        <ul id="sitemap">
                            <script>
                                $(document).ready(function(e) {
                                    $("#sc").click(function(e) {
                                        window.location = "https://www.vipzftaab.com/nbfAdmin/recommendList/"+"?un="+$("#username").val();
                                    });
                                });
                                function show(id){
                                    if($("#"+id).hasClass('collapsed')){
                                        $("#"+id).removeClass('collapsed').addClass('expanded');


                                        if($("#"+id).hasClass('done')){
                                            $('#a_'+id).show();
                                        }else{
                                            $.ajax({
                                                type: "get",
                                                url: "https://www.vipzftaab.com/index/getRList/"+"?id="+$("#"+id).attr('uid'),
                                                dataType: "json",
                                                success: function(data){
                                                    $("#"+id).addClass('done');
                                                    if(data.length<1)
                                                        return;
                                                    var str = '<ul id="a_'+id+'">';
                                                    $.each(data,function(i,v){

                                                        if(v.childNumber>0){
                                                            str +='<li id="s_s_'+v.id+'"><a href="javascript:show(\'s_'+v.id+'\')">'+v.name+'</a>';
                                                            str +=  '<span class="collapsed" id=s_'+v.id+' onclick="show(\'s_'+v.id+'\')" number="'+v.childNumber+'"  uid="'+v.id+'"></span>';
                                                        }else{
                                                            str +='<li id="s_s_'+v.id+'"><a href="javascript:;">'+v.name+'</a>';
                                                        }
                                                        str +='</li>';
                                                    });
                                                    str +='</ul>';
                                                    $("#s_"+id).html($($("#"+id).parent('li')).html()+str);
                                                    $('#a_'+id).show();
                                                }
                                            });
                                        }

                                    }else{
                                        $("#"+id).removeClass('expanded').addClass('collapsed');

                                        $($("#s_"+id)).find('ul').hide();
                                        $($("#s_"+id)).find('span').removeClass('expanded').addClass('collapsed');
                                    }

                                }
                            </script>

                            <li id="s_s_13312"><a href="javascript:show('s_13312')">5615588(冯鑫,中级,正常)</a>
                                <span class="collapsed" id="s_13312" onclick="show('s_13312')" uid="13312"></span>
                            </li>

                            <li id="s_s_14759"><a href="javascript:;">Z03839371(王成林,初级,正常)</a>
                            </li>

                            <li id="s_s_14885"><a href="javascript:;">8387912(郑淑梅,初级,正常)</a>
                            </li>

                            <li id="s_s_16955"><a href="javascript:;">Z09699166(时大位,初级,正常)</a>
                            </li>

                            <li id="s_s_40570"><a href="javascript:;">Z01836172(李伟,初级,冻结)</a>
                            </li>

                        </ul>
                    </div>


                </div>
            </div>
            <div class="col-lg-2"></div>
        </div>
    </div>
</div>
