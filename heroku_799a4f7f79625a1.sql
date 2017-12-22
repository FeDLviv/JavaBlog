/*
Navicat MySQL Data Transfer

Source Server         : Heroku
Source Server Version : 50636
Source Host           : us-cdbr-iron-east-05.cleardb.net:3306
Source Database       : heroku_799a4f7f79625a1

Target Server Type    : MYSQL
Target Server Version : 50636
File Encoding         : 65001

Date: 2017-12-21 19:21:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id_comment` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_post` int(10) unsigned NOT NULL,
  `id_user` int(10) unsigned NOT NULL,
  `text` text NOT NULL,
  `public` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_comment`),
  KEY `FK_IND` (`id_post`),
  KEY `FK_COM_US` (`id_user`),
  CONSTRAINT `FK_POST` FOREIGN KEY (`id_post`) REFERENCES `post` (`id_post`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_USER` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for mark
-- ----------------------------
DROP TABLE IF EXISTS `mark`;
CREATE TABLE `mark` (
  `id_mark` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id_mark`),
  UNIQUE KEY `UQ_NAME` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for post
-- ----------------------------
DROP TABLE IF EXISTS `post`;
CREATE TABLE `post` (
  `id_post` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `text` text NOT NULL,
  `public` datetime NOT NULL,
  PRIMARY KEY (`id_post`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for post_mark
-- ----------------------------
DROP TABLE IF EXISTS `post_mark`;
CREATE TABLE `post_mark` (
  `id_post_mark` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_post` int(10) unsigned NOT NULL,
  `id_mark` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id_post_mark`),
  UNIQUE KEY `UQ_POST_MARK` (`id_post`,`id_mark`) USING BTREE,
  KEY `FK_IND_POST` (`id_post`),
  KEY `FK_IND_MARK` (`id_mark`),
  CONSTRAINT `FK_PM_MARK` FOREIGN KEY (`id_mark`) REFERENCES `mark` (`id_mark`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_PM_POSTM` FOREIGN KEY (`id_post`) REFERENCES `post` (`id_post`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id_user` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id_user`),
  UNIQUE KEY `UN_USER` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
