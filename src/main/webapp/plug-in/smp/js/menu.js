



$('.leftmenu>ul>li>a').click(function(e) {
	$('.leftmenu>ul>li>a').removeClass('on');
	$('.leftmenu>ul ul').slideUp();
    $(this).addClass('on');
	$(this).next().slideDown();
});

$('.m_nav').click(function(e) {
    $('.leftmenu').toggleClass('on');
});


















