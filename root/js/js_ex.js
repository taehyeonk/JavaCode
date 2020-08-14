window.addEventListener("load", function () {
    var btnPrint = document.getElementById('btn-print');
    btnPrint.onclick = function () {
        var x, y;
        x = prompt("x값을 입력하세요");
        y = prompt("y값을 입력하세요");
        if( 10 < parseInt(x) + parseInt(y) ) {
        btnPrint.tpye = "text";
        btnPrint.style.height ="40px";
        btnPrint.style.backgroundColor ="blue";
        btnPrint.value = x + y;
        }
    };
});