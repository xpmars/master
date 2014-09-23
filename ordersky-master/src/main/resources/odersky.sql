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
  `name` varchar(64) collate utf8_bin default NULL,
  `error` varchar(64) collate utf8_bin default NULL,
  `henchman` varchar(64) collate utf8_bin default NULL,
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
-- Table structure for dish
-- ----------------------------
CREATE TABLE `dish` (
  `id` INT(4) NOT NULL,
  `restId` INT(4) NOT NULL,
  `dishName` varchar(64) collate utf8_bin default NULL,
  `taste` varchar(64) collate utf8_bin default NULL,
  `price` INT(4) collate utf8_bin default NULL,
  `discount` varchar(64) collate utf8_bin default NULL,
  `remark` varchar(64) collate utf8_bin default NULL,
  `interval` varchar(64) collate utf8_bin default NULL,
  PRIMARY KEY  (`id`),
  FOREIGN KEY (`restId`)     references  `rest` (`id`) ON DELETE CASCADE ON UPDATE CASCADE         
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ----------------------------
-- Table structure for orders
-- ----------------------------
CREATE TABLE `orders` (
  `id` bigint(22) NOT NULL,
  `orderUser` varchar(64) NOT NULL,
  `totalPrice` NOT NULL collate utf8_bin default NULL,
  `remark` varchar(64) collate utf8_bin default NULL,
  `orderDate` varchar(64) collate utf8_bin default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ----------------------------
-- Table structure for order-dish
-- ----------------------------
CREATE TABLE `ordersdish` (
  `id` varchar(64) NOT NULL,
  `ordersId` bigint(22) NOT NULL,
  `dishId` int(4) NOT NULL,
  PRIMARY KEY  (`id`),
  FOREIGN KEY (`ordersId`)     references  `orders` (`id`) ON DELETE CASCADE ON UPDATE CASCADE ,     
  FOREIGN KEY (`dishId`)     references  `dish` (`id`) ON DELETE CASCADE ON UPDATE CASCADE      
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;