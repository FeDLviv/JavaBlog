CREATE TABLE `post` (
  `id_post` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `title`   VARCHAR(255)     NOT NULL,
  `text`    TEXT             NOT NULL,
  `public`  DATETIME         NOT NULL,
  PRIMARY KEY (`id_post`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE `mark` (
  `id_mark` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name`    VARCHAR(255)     NOT NULL,
  PRIMARY KEY (`id_mark`),
  UNIQUE KEY `UQ_NAME` (`name`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE `post_mark` (
  `id_post_mark` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_post`      INT(10) UNSIGNED NOT NULL,
  `id_mark`      INT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`id_post_mark`),
  UNIQUE KEY `UQ_POST_MARK` (`id_post`, `id_mark`) USING BTREE,
  KEY `FK_IND_POST` (`id_post`),
  KEY `FK_IND_MARK` (`id_mark`),
  CONSTRAINT `FK_PM_MARK` FOREIGN KEY (`id_mark`) REFERENCES `mark` (`id_mark`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `FK_PM_POSTM` FOREIGN KEY (`id_post`) REFERENCES `post` (`id_post`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE `user` (
  `id_user`  INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name`     VARCHAR(255)     NOT NULL,
  `password` VARCHAR(255)     NOT NULL,
  PRIMARY KEY (`id_user`),
  UNIQUE KEY `UN_USER` (`name`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE `comment` (
  `id_comment` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_post`    INT(10) UNSIGNED NOT NULL,
  `id_user`    INT(10) UNSIGNED NOT NULL,
  `text`       TEXT             NOT NULL,
  `public`     TIMESTAMP        NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_comment`),
  KEY `FK_IND` (`id_post`),
  KEY `FK_COM_US` (`id_user`),
  CONSTRAINT `FK_POST` FOREIGN KEY (`id_post`) REFERENCES `post` (`id_post`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `FK_USER` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE `role` (
  `id_role` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name`    VARCHAR(255)     NOT NULL,
  PRIMARY KEY (`id_role`),
  UNIQUE KEY `UN_NAME` (`name`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE `user_role` (
  `id_user` INT(10) UNSIGNED NOT NULL,
  `id_role` INT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`id_user`, `id_role`),
  KEY `id_role` (`id_role`),
  CONSTRAINT `user_role_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `user_role_ibfk_2` FOREIGN KEY (`id_role`) REFERENCES `role` (`id_role`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;