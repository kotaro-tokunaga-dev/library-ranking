-- 図書館掲示板ランキング（個人ポートフォリオ用）テーブル定義
CREATE DATABASE IF NOT EXISTS library_ranking DEFAULT CHARACTER SET utf8mb4;
USE library_ranking;

DROP TABLE IF EXISTS review_table;
DROP TABLE IF EXISTS shoseki_info_table;
DROP TABLE IF EXISTS user_table;

CREATE TABLE user_table (
  user_id   VARCHAR(20)  NOT NULL,
  user_name VARCHAR(100) NOT NULL,
  password  VARCHAR(255) NOT NULL,
  PRIMARY KEY (user_id)
) DEFAULT CHARSET=utf8mb4;

CREATE TABLE shoseki_info_table (
  shoseki_id    VARCHAR(20)  NOT NULL,
  shoseki_title VARCHAR(100),
  shoukaisha_id VARCHAR(20)  NOT NULL,
  PRIMARY KEY (shoseki_id),
  FOREIGN KEY (shoukaisha_id) REFERENCES user_table(user_id)
) DEFAULT CHARSET=utf8mb4;

CREATE TABLE review_table (
  review_id           VARCHAR(20) NOT NULL,
  reviewed_shoseki_id VARCHAR(20) NOT NULL,
  review_toukousha_id VARCHAR(20) NOT NULL,
  PRIMARY KEY (review_id),
  FOREIGN KEY (reviewed_shoseki_id) REFERENCES shoseki_info_table(shoseki_id),
  FOREIGN KEY (review_toukousha_id) REFERENCES user_table(user_id)
) DEFAULT CHARSET=utf8mb4;
