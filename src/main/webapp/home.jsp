<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head><meta charset="UTF-8"><title>News Website</title>
<style>
  body{font-family:Segoe UI,Arial,sans-serif;max-width:760px;margin:30px auto;padding:0 16px;color:#222}
  a{color:#0b5ed7;text-decoration:none} a:hover{text-decoration:underline}
  li{margin:8px 0} small{color:#777}
  input,textarea{width:100%;padding:8px;box-sizing:border-box;font:inherit}
  button{padding:8px 16px;cursor:pointer}
  .comment{border-bottom:1px solid #ddd;padding:8px 0}
</style>
</head>
<body>
  <h1>News Categories</h1>
  <p>Select a category to see its headlines:</p>
  <ul>
    <c:forEach var="cat" items="${categories}">
      <li><a href="category?id=${cat.id}"><c:out value="${cat.name}"/></a></li>
    </c:forEach>
  </ul>
</body>
</html>
