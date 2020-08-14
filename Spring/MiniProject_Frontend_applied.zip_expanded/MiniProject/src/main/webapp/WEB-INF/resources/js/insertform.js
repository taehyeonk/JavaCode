window.addEventListener("load", function () {
    var storeId = document.getElementById('store-id');
    var submit = document.getElementById('submit');
    submit.onclick = function() {
    	var id = parseInt(storeId.value);
    	if(id > 999999) {
    		alert("가게 번호 숫자가 너무 큽니다.");
    		// 다시 커서가 오게 하기 위함
    		storeId.value = '';
    		storeId.style.backgroundColor = "blue";
    		storeId.focus;
    	}
    	else {
    		storeId.style.backgroundColor = "white";
    	}
    	return;
    }
});