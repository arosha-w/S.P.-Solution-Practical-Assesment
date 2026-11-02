<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head><meta charset="UTF-8"><title><c:out value="${news.title}"/></title>
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
  <h1><c:out value="${news.title}"/></h1>
  <small>${news.createdAt}</small>
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
      <b><c:out value="${cm.author}"/></b> <small>${cm.createdAt}</small><br>
      <c:out value="${cm.text}"/>
    </div>
  </c:forEach>
</body>
</html>
