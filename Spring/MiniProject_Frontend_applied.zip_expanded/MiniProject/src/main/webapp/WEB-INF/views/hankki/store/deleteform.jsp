<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CoderBy</title>
</head>
<body>
<h1>가게정보 삭제</h1>
${store.storeId}사원 ${store.storeName} ${store.position}의 정보를 삭제합니다.<p>
삭제후 데이터는 복구될 수 없습니다.<p>
${store.storeId} 가게의 이름을 입력하세요.
<form action="./delete" method="post">
가게이름 : <input type="text" name="name">
<input type="hidden" name="storeName" value="${store.storeName}">
<input type="submit" value="삭제">
</form>
</body>
</html>