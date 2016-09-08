var clickTime = 0;
function toPage(currentPage, dataCount) {
	if (currentPage == -99) {
		currentPage = $("#junmpPage").val();
	}
	var url = contextPath + "/getAreas.do";
	var condition = $("input[name=condition]").val();
	window.location.href = url + "?pageNum=" + currentPage + "&dataCount="
			+ dataCount + "&condition=" + condition;
}
function showChildren(id) {
	var children = Array();
	if (clickTime == 0) {
		$.getJSON(contextPath + "/getChildrens.do?id=" + id, function(result) {
			if (result == undefined) {
				return;
			} else {
				children = result;
			}

			if ($("tr[name='children']") != undefined
					&& $("tr[name='children']").length >= children.length) {
				return;
			} else {
				for (var i = 0; i < children.length; i++)
					$('#area_' + id).after(
							"<tr name ='children'><td bgcolor='e91e6f'>"
									+ result[i].id
									+ "</td><td bgcolor='e91e6f'>"
									+ result[i].areaCode
									+ "</td><td bgcolor='e91e6f'>"
									+ result[i].areaName + "</td></tr>");
				clickTime++;
			}

		});
	} else {
		$("tr[name='children']").remove();
		clickTime = 0;
	}
	$('#area_' + id).attr("bgcolor", "yellow");
}
function coloredTable(isOver, id) {
	if (isOver) {
		$('#area_' + id).attr("bgcolor", "yellow");
	} else {
		$('#area_' + id).attr("bgcolor", "");
	}
}