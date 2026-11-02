<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head><meta charset="UTF-8"><title><c:out value="${category.name}"/> - News</title>
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
  <a href="home">&larr; All categories</a>
  <h1><c:out value="${category.name}"/> News</h1>
  <c:if test="${empty newsList}"><p>No news in this category yet.</p></c:if>
  <ul>
    <c:forEach var="n" items="${newsList}">
      <li><a href="news?id=${n.id}"><c:out value="${n.title}"/></a>
          <small>(${n.createdAt})</small></li>
    </c:forEach>
  </ul>
</body>
</html>
