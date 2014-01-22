/*
MySQL Data Transfer
Source Host: localhost
Source Database: ipcollect
Target Host: localhost
Target Database: ipcollect
Date: 2012/3/25 16:25:36
*/
Drop database if exists proxydb;
create database proxydb  character set utf8;
use proxydb;

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for user
-- ----------------------------
CREATE TABLE `ipadress` (
  `id` int(6) NOT NULL auto_increment,
  `adress` varchar(64) collate utf8_bin NOT NULL,
  `port` int(4) collate utf8_bin NOT NULL,
  `speed` varchar(64) collate utf8_bin default NULL,
  `country` varchar(64) collate utf8_bin default NULL,
  `province` varchar(64) collate utf8_bin default NULL,
  `city` varchar(64) collate utf8_bin default NULL,
  `isp` varchar(64) collate utf8_bin default NULL,
  `isDomestic` TINYINT ,
  `isAlive` TINYINT ,
  `collectDate` date,
  
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ----------------------------
-- Table structure for user
-- ----------------------------
CREATE TABLE `user` (
  `userid` int(6) NOT NULL auto_increment,
  `username` varchar(64) collate utf8_bin NOT NULL,
  `password` varchar(64) collate utf8_bin NOT NULL,
  `comment` varchar(64) collate utf8_bin default NULL,

  PRIMARY KEY  (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
