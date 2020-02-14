/*
SQLyog Ultimate v12.5.0 (64 bit)
MySQL - 5.5.27 : Database - hospital2
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`hospital2` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `hospital2`;

/*Table structure for table `blood` */

DROP TABLE IF EXISTS `blood`;

CREATE TABLE `blood` (
  `b_id` int(10) NOT NULL AUTO_INCREMENT,
  `u_id` int(10) DEFAULT NULL,
  `h_id` int(10) DEFAULT NULL,
  `p_date` date DEFAULT NULL,
  `e_date` date DEFAULT NULL,
  `capacity` int(10) DEFAULT NULL,
  `state` enum('已预约','已完成','已献血','已取消') DEFAULT '已预约',
  PRIMARY KEY (`b_id`),
  KEY `u_id` (`u_id`),
  CONSTRAINT `blood_ibfk_1` FOREIGN KEY (`u_id`) REFERENCES `user` (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8;

/*Data for the table `blood` */

insert  into `blood`(`b_id`,`u_id`,`h_id`,`p_date`,`e_date`,`capacity`,`state`) values 
(1,1,1,'2020-02-06','2020-02-12',200,'已完成'),
(2,2,1,'2020-02-10','2020-02-17',100,'已取消'),
(3,1,2,'2020-02-12','2020-03-17',400,'已完成'),
(10,4,1,NULL,NULL,0,'已取消'),
(14,2,2,'2020-02-12','2020-02-29',200,'已预约'),
(15,2,1,'2020-02-26','2020-02-08',100,'已取消'),
(16,3,1,NULL,NULL,200,'已完成'),
(17,4,1,NULL,NULL,200,'已取消'),
(21,2,1,NULL,NULL,200,'已预约'),
(23,3,1,NULL,NULL,200,'已取消'),
(32,4,1,NULL,NULL,200,'已献血'),
(33,3,1,NULL,NULL,200,'已完成'),
(34,2,1,NULL,NULL,200,'已预约'),
(35,4,1,NULL,NULL,200,'已献血'),
(36,2,1,NULL,NULL,200,'已取消'),
(38,2,1,NULL,NULL,200,'已完成'),
(45,3,3,NULL,NULL,100,'已完成'),
(46,4,3,NULL,NULL,250,'已献血'),
(47,2,3,NULL,NULL,300,'已取消'),
(48,1,3,NULL,NULL,500,'已献血'),
(49,3,2,NULL,NULL,200,'已献血'),
(50,4,2,NULL,NULL,300,'已取消'),
(51,4,3,NULL,NULL,200,'已献血');

/*Table structure for table `hospital` */

DROP TABLE IF EXISTS `hospital`;

CREATE TABLE `hospital` (
  `h_id` int(10) NOT NULL AUTO_INCREMENT,
  `h_address` varchar(50) DEFAULT NULL,
  `h_name` varchar(20) DEFAULT NULL,
  `h_total` int(11) DEFAULT NULL,
  PRIMARY KEY (`h_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `hospital` */

insert  into `hospital`(`h_id`,`h_address`,`h_name`,`h_total`) values 
(1,'南充','川北医院',NULL),
(2,'内江','人民医院',NULL),
(3,'内江','市一院',NULL);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `u_id` int(10) NOT NULL AUTO_INCREMENT,
  `u_number` int(10) NOT NULL,
  `u_gender` enum('男','女') NOT NULL,
  `u_address` varchar(20) DEFAULT NULL,
  `u_name` varchar(20) NOT NULL,
  `u_password` int(6) NOT NULL,
  `u_type` varchar(6) DEFAULT NULL,
  `u_totle` int(10) DEFAULT NULL,
  `u_mail` varchar(20) DEFAULT NULL,
  `u_phone` varchar(15) DEFAULT NULL,
  `u_birthday` date DEFAULT NULL,
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`u_id`,`u_number`,`u_gender`,`u_address`,`u_name`,`u_password`,`u_type`,`u_totle`,`u_mail`,`u_phone`,`u_birthday`) values 
(1,1001,'男','内江','张三',1001,'A',0,'13@123','1008611','2044-12-25'),
(2,1002,'男','南充','李四2',1002,'B',0,'12@qq','132',NULL),
(3,1003,'女','南充','王五',1003,'AB',NULL,'286@qq','543211','2020-02-28'),
(4,1004,'女','内江','赵六',1004,'O',NULL,'4662@66','139552','2020-02-24');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
