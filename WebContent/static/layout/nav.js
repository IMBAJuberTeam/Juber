$.ajax({
	type : "get",
	url : "getOnlineCount.do",
	success : function(data) {
		$("#onlineCount").text(data);
	}
});