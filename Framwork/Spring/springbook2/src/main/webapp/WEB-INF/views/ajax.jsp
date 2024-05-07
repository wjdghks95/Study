<%--
  Created by IntelliJ IDEA.
  User: wjdgh
  Date: 2024-05-07
  Time: 오후 10:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script>
        $(document).ready(function () {
            $('#loginIdCheck').click(function () {
                $.getJSON('checkloginid/' + $('#loginId').val(), function (result) {
                    if (result.duplicated == true) {
                        alert("이미 등록된 로그인ID입니다. " + result.availableId + '는 사용할 수 있습니다.');
                    } else {
                        alert("사용할 수 있는 로그인ID입니다.");
                    }
                })
            });
        });

        $("#user").submit(function () {
            var user = $(this).serializeObject(); // 폼의 모든 입력 필드를 JSON 포맷의 메시지로 만든다.
            $.postJSON("register", user, function (user) {
                // 등록완료 안내 또는 에러 메시지 출력
            });
            return false;
        });
    </script>
</head>
<body>
    <form id="user">
        <fieldset>
            <label>로그인 아이디 :</label><input id="loginId" name="loginId" type="text">
            <input id="loginIdCheck" type="button" value="아이디 중복 검사"><br/>
            <label>비밀번호 : </label><input id="password" name="password" type="password"/><br/>
            <label>이름 : </label><input id="name" name="name" type="text"/><br/>
            <input type="submit" value="등록"/>
        </fieldset>
    </form>
</body>
</html>
