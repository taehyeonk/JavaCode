<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CoderBy</title>
</head>
<body>
<h1>메뉴정보 삭제</h1>
${menu.menuId}사원 ${menu.menuName} ${menu.cost}의 정보를 삭제합니다.<p>
삭제후 데이터는 복구될 수 없습니다.<p>
${menu.menuName}메뉴의 이름을 입력하세요.
<form action="./menu/delete" method="post">
가게이름 : <input type="text" name="name">
<input type="hidden" name="Name" value="${menu.menuName}">
<input type="submit" value="삭제">
</form>
</body>
</html>