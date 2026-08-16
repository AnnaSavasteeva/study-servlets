<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<html>
    <head>
        <title>Calculator</title>
    </head>
    <body>
    <jsp:include page="_header.jsp"/>

        <div class="container">
            <div class="row justify-content-center">
                <div class="col-4">
                    <form action="/calcjsp" method="post">
<%--                        Бывает, нужно вместе с данными от пользователя отправить какие-то дополнительные
                            данные — это можно сделать через скрытое поле --%>
                        <input type="hidden" name="version" value="123.4.5">
                        <div class="mb-3">
                            <label for="exampleInputEmail1" class="form-label">Num 1</label>
                            <input name="num1" type="number" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                        </div>
                        <div class="mb-3">
                            <label for="exampleInputPassword1" class="form-label">Num 2</label>
                            <input name="num2" type="number" class="form-control" id="exampleInputPassword1">
                        </div>
                        <button type="submit" class="btn btn-primary w-100">Submit</button>
                    </form>
<%--                    В атрибуте test — булево значение:
                         - если true, то все, что в теге <c:if...>, показывается на странице,
                         - если false — содержимое тега <c:if...> НЕ выводится --%>
                    <c:if test="${result != null}">
                        <h3>Result = ${result}</h3>
                    </c:if>
                </div>
            </div>
        </div>

    </body>
</html>
