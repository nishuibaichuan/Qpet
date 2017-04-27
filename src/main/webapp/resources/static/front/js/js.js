// JavaScript Document
$(function(){
	j=$("#imgchange li").length;
	for(i=1;i<=j;i++)
	{
		$("#imgchange p").append("<span>"+i+"</span>");
	}
	$("#imgchange li:first").show();
	$("#imgchange span:first").addClass("current")
	$("#imgchange span").mouseover(function(){
		num=$(this).index();
		$(this).addClass("current").stop(true,true).show().siblings().removeClass("current");
		$("#imgchange li").eq(num).stop(true,true).fadeIn().siblings("#imgchange li").stop(true,true).hide();
	});
	int=setInterval(function(){
	num1=$(".current").index()+1;
	if(num1==j){
		num1=0;
	}
	$("span").eq(num1).trigger("mouseover");
	},2000);
	$("#imgchange img").stop().mouseover(function(){
		clearInterval(int);
	}).mouseout(function(){
		int=setInterval(function(){
		num1=$(".current").index()+1;
		if(num1==j)
		{
		num1=0;
		}
	$("span").eq(num1).trigger("mouseover");
	},2000);
	});
});

$(function(){
	$("#warpright .jqzoom:first").show();
	$("#warpleft img").mouseover(function(){
		warplefts=$(this).index();
		$(this).addClass("current").siblings("img").removeClass("current");
		$("#warpright .jqzoom").eq(warplefts).show().siblings(".jqzoom").hide();
	})
})