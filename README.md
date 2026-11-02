# News Website (Java 21, Servlets/JSP, MySQL)

Requires: JDK 21, Maven, MySQL, Apache Tomcat 10.1.x (NOT 9).

1. Run `sql/schema.sql` in MySQL.
2. Edit the password in `src/main/java/com/news/DB.java`.
3. `mvn clean package` -> produces `target/news.war`.
4. Copy `news.war` into Tomcat's `webapps/`, start Tomcat, open http://localhost:8080/news/

In IntelliJ: open the folder as a Maven project, set Project SDK to 21,
and run on Tomcat 10.1 with context path `/news`.
