<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--Добавляем директиву для jstl с префиксом для разграничения тегов--%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<html>
<head>
    <meta charset="utf-8">
    <title>History</title>
</head>
<body>
    <jsp:include page="_header.jsp"/>

    <div class="container">
        <div class="row justify-content-center">
            <div class="col-6">
                <c:if test="${not empty operations}">
                    <ul class="list-group">
                            <%--        items — коллекция, массив и т.п.; var — итеративная переменная --%>
                        <c:forEach items="${operations}" var="operation">
                            <li class="list-group-item">${operation}</li>
                        </c:forEach>
                    </ul>
                </c:if>
<%--                В jstl нет конструкции if-else--%>
                <c:if test="${empty operations}">
                    <h3>У вас пока нет истории операций</h3>
                </c:if>
            </div>
        </div>
    </div>

</body>
</html>
