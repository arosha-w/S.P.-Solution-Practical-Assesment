<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title><c:out value="${category.name}"/> - News</title>
  <link rel="stylesheet" href="style.css">
</head>
<body>
  <a href="home">&larr; All categories</a>
  <h1><c:out value="${category.name}"/> News</h1>
  <c:if test="${empty newsList}"><p>No news in this category yet.</p></c:if>
  <ul>
    <c:forEach var="n" items="${newsList}">
      <li><a href="news?id=${n.id}"><c:out value="${n.title}"/></a></li>
    </c:forEach>
  </ul>
</body>
</html>