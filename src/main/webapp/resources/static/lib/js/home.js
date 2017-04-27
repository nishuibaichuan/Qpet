$(function() {
	$(".leftnav h2").click(function() {
		$(".leftnav > ul").not($(this).next()).slideUp();//加上这样一句话就可以在点击的同时关闭其他打开的菜单
		$(this).next().slideToggle(200);
		$(this).toggleClass("on");
	});
	$(".leftnav ul li a").click(function() {
		$("#a_leader_txt").text($(this).text());
		$(".leftnav ul li a").removeClass("on");
		$(this).addClass("on");
		$('strong').addClass("one");//移除其他的class=one
	});
	//页面加载时绑定按钮点击事件
    $(".on").click(function(){
        refresh();
    });
	//点击按钮调用的方法
	function refresh(){
	   location.reload();//刷新当前页面.
	}
});