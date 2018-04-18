/*
Navicat MySQL Data Transfer

Source Server         : 10.21.12.89_3306
Source Server Version : 50721
Source Host           : 10.21.12.89:3306
Source Database       : deploy

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-04-18 19:12:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for filedetail
-- ----------------------------
DROP TABLE IF EXISTS `filedetail`;
CREATE TABLE `filedetail` (
  `id` int(10) NOT NULL,
  `issueno` varchar(20) NOT NULL,
  `member` varchar(50) DEFAULT NULL,
  `agent` varchar(50) DEFAULT NULL,
  `control` varchar(50) DEFAULT NULL,
  `api` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of filedetail
-- ----------------------------

-- ----------------------------
-- Table structure for files
-- ----------------------------
DROP TABLE IF EXISTS `files`;
CREATE TABLE `files` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `issue` varchar(20) NOT NULL,
  `platform` varchar(20) NOT NULL,
  `member` varchar(50) DEFAULT NULL,
  `agent` varchar(50) DEFAULT NULL,
  `control` varchar(50) DEFAULT NULL,
  `api` varchar(50) DEFAULT NULL,
  `middleware` varchar(50) DEFAULT NULL,
  `nginx` varchar(50) DEFAULT NULL,
  `web` varchar(50) DEFAULT NULL,
  `h5` varchar(50) DEFAULT NULL,
  `comptime` varchar(20) NOT NULL,
  `status` varchar(10) NOT NULL,
  `deploytime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of files
-- ----------------------------
INSERT INTO `files` VALUES ('1', 'GPO-2454', 'GPO', null, null, null, null, null, null, null, null, '20180321211943', '未发布', '2018-04-11 13:17:22', null);
INSERT INTO `files` VALUES ('2', 'GPO-2360', 'GPO', null, null, null, null, null, null, null, null, '20180322071043', '已发布线上', '2018-04-09 16:08:52', null);
INSERT INTO `files` VALUES ('3', 'GPO-2358', 'GPO', null, null, null, null, null, null, null, null, '20180322072721', '线上回退', '2018-04-09 16:09:03', null);
INSERT INTO `files` VALUES ('4', 'CP-2396', 'CP', null, null, null, null, null, null, null, null, '20180322072755', 'UAT2回退', '2018-04-09 16:09:11', null);
INSERT INTO `files` VALUES ('5', 'GPO-2412', 'GPO', null, null, null, null, null, null, null, null, '20180322011454', 'UAT2回退', '2018-04-09 16:09:18', null);
INSERT INTO `files` VALUES ('6', 'GPO-2454', 'GPO', null, null, null, null, null, null, null, null, '20180321211943', '已发布UAT2', '2018-04-09 16:08:45', null);
INSERT INTO `files` VALUES ('7', 'GPO-2454', 'GPO', null, null, null, null, null, null, null, null, '20180321211943', '已发布UAT2', '2018-04-09 16:08:45', null);
INSERT INTO `files` VALUES ('8', 'GPO-2360', 'GPO', null, null, null, null, null, null, null, null, '20180322071043', '已发布线上', '2018-04-09 16:08:52', null);
INSERT INTO `files` VALUES ('9', 'GPO-2358', 'GPO', null, null, null, null, null, null, null, null, '20180322072721', '线上回退', '2018-04-09 16:09:03', null);
INSERT INTO `files` VALUES ('10', 'CP-2396', 'CP', null, null, null, null, null, null, null, null, '20180322072755', 'UAT2回退', '2018-04-09 16:09:11', null);
INSERT INTO `files` VALUES ('11', 'GPO-2412', 'GPO', null, null, null, null, null, null, null, null, '20180322011454', 'UAT2回退', '2018-04-09 16:09:18', null);
INSERT INTO `files` VALUES ('12', 'GPO-2454', 'GPO', null, null, null, null, null, null, null, null, '20180321211943', '已发布UAT2', '2018-04-09 16:08:45', null);
INSERT INTO `files` VALUES ('13', 'GPO-2360', 'GPO', null, null, null, null, null, null, null, null, '20180322071043', '已发布线上', '2018-04-09 16:08:52', null);
INSERT INTO `files` VALUES ('14', 'GPO-2358', 'GPO', null, null, null, null, null, null, null, null, '20180322072721', '线上回退', '2018-04-09 16:09:03', null);
INSERT INTO `files` VALUES ('15', 'CP-2396', 'CP', null, null, null, null, null, null, null, null, '20180322072755', 'UAT2回退', '2018-04-09 16:09:11', null);
INSERT INTO `files` VALUES ('16', 'GPO-2412', 'GPO', null, null, null, null, null, null, null, null, '20180322011454', 'UAT2回退', '2018-04-09 16:09:18', null);

-- ----------------------------
-- Table structure for qatask
-- ----------------------------
DROP TABLE IF EXISTS `qatask`;
CREATE TABLE `qatask` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `issue` varchar(20) NOT NULL,
  `status` varchar(20) NOT NULL,
  `deploytime` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  `deploytype` varchar(20) NOT NULL,
  `deployproj` varchar(255) NOT NULL,
  `details` varchar(255) NOT NULL,
  `operator` varchar(20) NOT NULL,
  `qa` varchar(20) DEFAULT NULL,
  `rd` varchar(20) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `restart` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qatask
-- ----------------------------
INSERT INTO `qatask` VALUES ('1', 'GPO-2454', '发布线上', '2018-03-24 09:51:16', '线上紧急BUG', 'member|agent|control|api', 'GPO代理端账号管理查询优化从主库切换到从库 — dean / detail', 'ikaw', 'len', 'dean', '需要发布sql', '是');
INSERT INTO `qatask` VALUES ('2', 'GPO-2360', '发布UAT2', '2018-03-24 09:52:42', '线上紧急BUG', 'agent', 'GPO代理端账号管理查询优化从主库切换到从库 — de', 'ikaw', 'parker', 'handy', '', '否');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) NOT NULL,
  `rolename` varchar(100) DEFAULT NULL,
  `loginpwd` varchar(20) NOT NULL,
  `email` varchar(200) DEFAULT NULL,
  `roleid` varchar(100) DEFAULT NULL,
  `createdata` datetime DEFAULT NULL,
  `status` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('11', 'admin', '管理员', '123456', 'admin@admin.com', '01', '2018-03-21 14:53:15', null);
INSERT INTO `users` VALUES ('12', 'ikaw', '管理员', 'qwe123', 'ikaw@orientalgame99.com', '01', '2018-03-22 13:28:22', null);
