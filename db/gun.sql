/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50620
Source Host           : localhost:3306
Source Database       : gun

Target Server Type    : MYSQL
Target Server Version : 50620
File Encoding         : 65001

Date: 2017-09-22 17:05:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for at_custom_info
-- ----------------------------
DROP TABLE IF EXISTS `at_custom_info`;
CREATE TABLE `at_custom_info` (
  `id` bigint(20) NOT NULL,
  `login_name` varchar(24) NOT NULL,
  `password` varchar(64) NOT NULL,
  `name` varchar(32) NOT NULL,
  `sex` char(1) DEFAULT NULL,
  `identity` varchar(18) DEFAULT NULL,
  `phone` varchar(16) DEFAULT NULL,
  `address` varchar(128) DEFAULT NULL,
  `point_card` bigint(20) DEFAULT NULL,
  `level` char(1) DEFAULT NULL,
  `check_label` char(1) DEFAULT NULL COMMENT '有效标识',
  `create_date` datetime DEFAULT NULL,
  `remark` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='顾客基本信息';

-- ----------------------------
-- Records of at_custom_info
-- ----------------------------

-- ----------------------------
-- Table structure for bas_operate_info
-- ----------------------------
DROP TABLE IF EXISTS `bas_operate_info`;
CREATE TABLE `bas_operate_info` (
  `id` bigint(20) NOT NULL,
  `ope_date` datetime DEFAULT NULL COMMENT '操作时间',
  `ope_name` varchar(32) DEFAULT NULL COMMENT '操作人',
  `ope_type` char(1) DEFAULT NULL COMMENT '类别',
  `result` varchar(32) DEFAULT NULL COMMENT '结果',
  `ip` varchar(24) DEFAULT NULL,
  `description` varchar(128) DEFAULT NULL COMMENT '描述',
  `create_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='操作日志';

-- ----------------------------
-- Records of bas_operate_info
-- ----------------------------

-- ----------------------------
-- Table structure for www_comment_info
-- ----------------------------
DROP TABLE IF EXISTS `www_comment_info`;
CREATE TABLE `www_comment_info` (
  `id` bigint(20) NOT NULL,
  `title` varchar(64) DEFAULT NULL COMMENT '概要',
  `comment` varchar(256) DEFAULT NULL COMMENT '评论内容',
  `star_level` char(1) DEFAULT NULL COMMENT '星级',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='评论库';

-- ----------------------------
-- Records of www_comment_info
-- ----------------------------

-- ----------------------------
-- Table structure for www_goods_info
-- ----------------------------
DROP TABLE IF EXISTS `www_goods_info`;
CREATE TABLE `www_goods_info` (
  `id` bigint(20) NOT NULL,
  `website_id` bigint(20) DEFAULT NULL,
  `name` varchar(64) DEFAULT NULL,
  `old_price` decimal(10,2) DEFAULT NULL,
  `cur_price` decimal(10,2) DEFAULT NULL,
  `description` varchar(256) DEFAULT NULL,
  `check_label` char(1) DEFAULT NULL COMMENT '下架标识',
  `create_date` datetime DEFAULT NULL,
  `remark` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_1` (`website_id`),
  CONSTRAINT `FK_Reference_1` FOREIGN KEY (`website_id`) REFERENCES `www_website_info` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品信息';

-- ----------------------------
-- Records of www_goods_info
-- ----------------------------
INSERT INTO `www_goods_info` VALUES ('1', '1', '荣耀8青春版 全网通 标配版 3GB+32GB 幻海蓝', '1099.00', '1099.00', '荣耀8青春版 全网通 标配版 3GB+32GB 幻海蓝', '1', '2017-09-22 16:05:46', null);

-- ----------------------------
-- Table structure for www_route_info
-- ----------------------------
DROP TABLE IF EXISTS `www_route_info`;
CREATE TABLE `www_route_info` (
  `id` bigint(20) NOT NULL,
  `goods_id` bigint(20) DEFAULT NULL,
  `element_name` varchar(256) DEFAULT NULL,
  `element_type` varchar(2) DEFAULT NULL,
  `event_type` varchar(2) DEFAULT NULL,
  `order_no` int(2) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `remark` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_2` (`goods_id`),
  CONSTRAINT `FK_Reference_2` FOREIGN KEY (`goods_id`) REFERENCES `www_goods_info` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品路径信息';

-- ----------------------------
-- Records of www_route_info
-- ----------------------------
INSERT INTO `www_route_info` VALUES ('1', '1', '手机', '3', '1', '1', '2017-09-22 16:09:23', '京东-手机');
INSERT INTO `www_route_info` VALUES ('2', '1', '//a[@href=\'//order.jd.com/center/list.action\']', '6', '1', '2', '2017-09-22 16:11:12', '京东-手机');

-- ----------------------------
-- Table structure for www_website_info
-- ----------------------------
DROP TABLE IF EXISTS `www_website_info`;
CREATE TABLE `www_website_info` (
  `id` bigint(20) NOT NULL,
  `name` varchar(64) DEFAULT NULL,
  `site` varchar(64) DEFAULT NULL,
  `type` char(1) DEFAULT NULL,
  `check_label` char(1) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `remark` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='网站信息';

-- ----------------------------
-- Records of www_website_info
-- ----------------------------
INSERT INTO `www_website_info` VALUES ('1', '京东', 'https://www.jd.com/', '1', '1', '2017-09-22 16:03:23', '京东商城');
