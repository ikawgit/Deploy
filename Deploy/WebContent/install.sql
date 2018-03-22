CREATE DATABASE IF NOT EXISTS deploy DEFAULT CHARSET utf8 COLLATE utf8_general_ci;

CREATE TABLE `users` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) NOT NULL,
  `rolename` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `loginpwd` varchar(20) NOT NULL,
  `email` varchar(200) DEFAULT NULL,
  `roleid` varchar(100) DEFAULT NULL,
  `createdata` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;