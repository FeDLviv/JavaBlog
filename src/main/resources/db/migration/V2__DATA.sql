INSERT INTO `post` VALUES ('21', 'Spring', 'Це програмний каркас (фреймворк) з відкритим кодом та контейнера з підтримкою інверсії управління для платформи Java.', '2017-12-26 02:00:00');
INSERT INTO `post` VALUES ('31', 'Entity Framework', 'ORM технологія  для доступу до бази данних.', '2016-11-30 02:00:00');
INSERT INTO `post` VALUES ('141', 'JPA', 'Java Persistence API — стандартизований інтерфейс для Java ORM фреймворків.', '2017-12-30 02:00:00');
INSERT INTO `post` VALUES ('151', 'JPQL', 'Java Persistenc...', '2017-12-25 02:00:00');

INSERT INTO `mark` VALUES ('41', 'C#');
INSERT INTO `mark` VALUES ('31', 'Java');
INSERT INTO `mark` VALUES ('71', 'Java EE');

INSERT INTO `post_mark` VALUES ('1', '21', '31');
INSERT INTO `post_mark` VALUES ('51', '21', '71');
INSERT INTO `post_mark` VALUES ('21', '31', '41');
INSERT INTO `post_mark` VALUES ('31', '141', '31');

INSERT INTO `user` VALUES ('1', 'admin', '$2a$10$1uLtcjlufE.bfvmcKuiyuemLkaKHYkJg9xabgwq5gRUf3iy8EryH2');
INSERT INTO `user` VALUES ('31', 'user', '$2a$10$wwiERSqmeypHgAA0Sej3dOSWhLxHe1gGiuzI5uHzPdTwTe1lsx/1m');

INSERT INTO `comment` VALUES ('91', '21', '1', 'Стаття повне гівно', '2017-12-30 15:33:50');

INSERT INTO `role` VALUES ('1', 'ROLE_ADMIN');
INSERT INTO `role` VALUES ('11', 'ROLE_USER');

INSERT INTO `user_role` VALUES ('1', '1');
INSERT INTO `user_role` VALUES ('31', '11');