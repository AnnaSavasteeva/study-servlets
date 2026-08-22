
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Upload avatar</title>
</head>
<body>
    <form action="/avatar" method="post" enctype="multipart/form-data">
        <input type="file" name="avatar">
        <button>Upload</button>
    </form>
</body>
</html>
