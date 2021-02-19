$(function(){
		   



	
	//从左侧显示遮罩效果 开始
	$(".con-four").hover(function() {
		$(this).find(".txt-four").stop().animate({"left": 0});
	}, function() {
		$(this).find(".txt-four").stop().animate({"left":-297});
	})
	//从左侧显示遮罩效果 结束
	
	

	

});
