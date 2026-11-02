CREATE DATABASE IF NOT EXISTS newsdb;
USE newsdb;

CREATE TABLE category (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100) NOT NULL
);

CREATE TABLE news (
  id INT AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(255) NOT NULL,
  content TEXT NOT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- many-to-many: one news item can belong to many categories
CREATE TABLE news_category (
  news_id INT NOT NULL,
  category_id INT NOT NULL,
  PRIMARY KEY (news_id, category_id),
  FOREIGN KEY (news_id) REFERENCES news(id) ON DELETE CASCADE,
  FOREIGN KEY (category_id) REFERENCES category(id) ON DELETE CASCADE
);

CREATE TABLE comment (
  id INT AUTO_INCREMENT PRIMARY KEY,
  news_id INT NOT NULL,
  author VARCHAR(100) NOT NULL,
  text VARCHAR(1000) NOT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (news_id) REFERENCES news(id) ON DELETE CASCADE
);

INSERT INTO category(name) VALUES ('Sports'),('Entertainment'),('Politics');
INSERT INTO news(title,content) VALUES
 ('Sri Lanka lost the cricket world cup','Full story about the match. Sri Lanka fought hard but fell short in the final over.'),
 ('New budget announced','Full story about the budget. The government presented the new budget in parliament today.'),
 ('Local film wins international award','Full story about the film and the award ceremony.');
INSERT INTO news_category VALUES (1,1),(1,2),(2,3),(3,2);
