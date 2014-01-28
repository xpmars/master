/*
MySQL Data Transfer
Source Host: localhost
Source Database: ordersky
Target Host: localhost
Target Database: ordersky
Date: 2012/3/25 16:25:36
*/
Drop database if exists ordersky;
create database ordersky  character set utf8;
use ordersky;

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for user
-- ----------------------------
CREATE TABLE `user` (
  `id` int(4) NOT NULL auto_increment,
  `username` varchar(64) collate utf8_bin default NULL,
  `password` varchar(64) collate utf8_bin default NULL,
  `telephone` varchar(64) collate utf8_bin default NULL,
  `email` varchar(64) collate utf8_bin default NULL,
  `usertype` varchar(64) collate utf8_bin default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `user` VALUES ('2', 'admin', '1234');

-- ----------------------------
-- Table structure for menu
-- ----------------------------
CREATE TABLE `rest` (
  `id` int(4) NOT NULL,
  `name` varchar(64) collate utf8_bin default NULL,
  `telephone` varchar(64) collate utf8_bin default NULL,
  `address` varchar(64) collate utf8_bin default NULL,
  `discount` varchar(64) collate utf8_bin default NULL,
  `remark` varchar(64) collate utf8_bin default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
CREATE TABLE `menu` (
  `id` int(4) NOT NULL,
  `restid` int(4),
  `name` varchar(64) collate utf8_bin default NULL,
  `taste` varchar(64) collate utf8_bin default NULL,
  `price` varchar(64) collate utf8_bin default NULL,
  `discount` varchar(64) collate utf8_bin default NULL,
  `remark` varchar(64) collate utf8_bin default NULL,
  PRIMARY KEY  (`id`),
  FOREIGN KEY (`restid`)     references  `rest` (`id`) ON DELETE CASCADE ON UPDATE CASCADE         
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;