<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />

        <link rel="stylesheet" href="<c:url value="resources/css/default.css" />" />

        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Ubuntu" rel="stylesheet">

        <link rel="stylesheet" href="<c:url value="resources/js/jquery-ui.structure.css" />" />
        <link rel="stylesheet" href="<c:url value="resources/js/jquery-ui.theme.css" />" />
        <link rel="stylesheet" href="<c:url value="resources/js/jquery-ui.css" />" />

        <script src="https://use.fontawesome.com/10477127e7.js"></script>

        <script src="<c:url value="resources/js/jquery.js" />" ></script>
        <script src="<c:url value="resources/js/jquery-ui.js" />" ></script>

        <script src="<c:url value="resources/js/default.js" />" ></script>

		<title>DIFU - chat</title>
	</head>
	<body>
        <session class="mensagens">
            
        </session>
        <footer>
            <div class="input" contenteditable="true"></div>
            <a class="send-button"><i class="material-icons">send</i></a>
        </footer>
	</body>
</html>