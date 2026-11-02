CREATE TABLE user_table (
  user_id VARCHAR(20) PRIMARY KEY,
  user_name VARCHAR(50) NOT NULL,
  password VARCHAR(100) NOT NULL
);
CREATE TABLE shoseki_info_table (
  shoseki_id VARCHAR(20) PRIMARY KEY,
  shoseki_title VARCHAR(100) NOT NULL,
  shoukaisha_id VARCHAR(20) NOT NULL,
  FOREIGN KEY (shoukaisha_id) REFERENCES user_table(user_id)
);
CREATE TABLE review_table (
  review_id VARCHAR(20) PRIMARY KEY,
  reviewed_shoseki_id VARCHAR(20) NOT NULL,
  review_toukousha_id VARCHAR(20) NOT NULL,
  FOREIGN KEY (reviewed_shoseki_id) REFERENCES shoseki_info_table(shoseki_id),
  FOREIGN KEY (review_toukousha_id) REFERENCES user_table(user_id)
);
