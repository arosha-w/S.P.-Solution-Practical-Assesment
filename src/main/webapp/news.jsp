<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title><c:out value="${news.title}"/></title>
  <link rel="stylesheet" href="style.css">
</head>
<body>
  <a href="home">&larr; All categories</a>
  <h1><c:out value="${news.title}"/></h1>
  <p><c:out value="${news.content}"/></p>

  <hr>
  <h3>Comments (${comments.size()})</h3>
  <form action="comment" method="post">
    <input type="hidden" name="newsId" value="${news.id}">
    <p><input name="author" placeholder="Your name" required maxlength="100"></p>
    <p><textarea name="text" placeholder="Your comment" rows="3" required maxlength="1000"></textarea></p>
    <button type="submit">Add comment</button>
  </form>

  <c:forEach var="cm" items="${comments}">
    <div class="comment">
      <b><c:out value="${cm.author}"/></b><br>
      <c:out value="${cm.text}"/>
    </div>
  </c:forEach>
</body>
</html>