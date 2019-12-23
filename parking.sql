/*
SQLyog v10.2 
MySQL - 5.5.50 : Database - parking
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`parking` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `parking`;

/*Table structure for table `parking_manage` */

DROP TABLE IF EXISTS `parking_manage`;

CREATE TABLE `parking_manage` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `manage_sta_id` varchar(50) DEFAULT NULL COMMENT '车位号',
  `manage_area` varchar(50) DEFAULT NULL COMMENT '区域',
  `manage_ps` varchar(50) DEFAULT NULL COMMENT '备注',
  `manage_car_id` varchar(50) DEFAULT NULL COMMENT '车牌号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

/*Data for the table `parking_manage` */

insert  into `parking_manage`(`id`,`manage_sta_id`,`manage_area`,`manage_ps`,`manage_car_id`) values (1,'A001','A区','A001','豫L00000'),(2,'A002','A区','A002','豫L00001'),(3,'A003','A区','A003','豫L00008'),(4,'A004','A区','A004','豫L00010'),(5,'A005','A区','A005','豫L00009'),(6,'A006','A区','A006','豫L00011'),(7,'A007','A区','A007','豫L00017'),(8,'A008','A区','A008','豫L00018'),(9,'A009','A区','A009',''),(10,'B001','B区','B001',''),(11,'B002','B区','B002',NULL),(12,'B003','B区','B003',NULL),(13,'B004','B区','B004',NULL),(14,'B005','B区','B005',NULL),(15,'B006','B区','B006',NULL),(16,'B007','B区','B007',NULL),(17,'B008','B区','B008',NULL),(18,'B009','B区','B009',NULL),(19,'C001','C区','C001',NULL),(20,'C002','C区','C002',NULL),(21,'C003','C区','C003',NULL),(22,'C004','C区','C004',NULL),(23,'C005','C区','C005',NULL),(24,'C006','C区','C006',NULL),(25,'C007','C区','C007',NULL),(26,'C008','C区','C008',NULL),(27,'C009','C区','C009',NULL);

/*Table structure for table `parking_owner` */

DROP TABLE IF EXISTS `parking_owner`;

CREATE TABLE `parking_owner` (
  `own_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `car_id` varchar(50) NOT NULL COMMENT '车牌编号',
  `car_sta_id` varchar(50) DEFAULT NULL COMMENT '身份证号',
  `car_name` varchar(50) DEFAULT NULL COMMENT '姓名',
  `car_site` varchar(50) DEFAULT NULL COMMENT '地址',
  `car_age` varchar(50) DEFAULT NULL COMMENT '年龄',
  `car_phone` varchar(50) DEFAULT NULL COMMENT '联系电话',
  `car_color` varchar(50) DEFAULT NULL COMMENT '车辆颜色',
  `car_money` varchar(50) DEFAULT NULL COMMENT '余额',
  PRIMARY KEY (`own_id`),
  KEY `car_sta_id` (`car_sta_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `parking_owner` */

insert  into `parking_owner`(`own_id`,`car_id`,`car_sta_id`,`car_name`,`car_site`,`car_age`,`car_phone`,`car_color`,`car_money`) values (1,'豫L00000','1','徐先生','',NULL,'123456','','2000'),(3,'豫L00001','1','徐先生','',NULL,'123456','','2000'),(6,'豫L66666','53413215312','常钰浩','河南省漯河市郾城区','null','12345678918','null','1');

/*Table structure for table `parking_record` */

DROP TABLE IF EXISTS `parking_record`;

CREATE TABLE `parking_record` (
  `rec_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `rec_car_id` varchar(50) NOT NULL COMMENT '车牌编号',
  `rec_entry_date` datetime NOT NULL COMMENT '进入日期',
  `rec_leave_date` datetime DEFAULT NULL COMMENT '离开日期',
  `rec_time` bigint(20) DEFAULT NULL COMMENT '停车时间',
  `rec_charge` varchar(20) DEFAULT NULL COMMENT '收费标准',
  `rec_cost` varchar(20) DEFAULT NULL COMMENT '总费用',
  `rec_own_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`rec_id`),
  KEY `rec_veh_id` (`rec_car_id`),
  KEY `parking_record_ibfk_1` (`rec_own_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

/*Data for the table `parking_record` */

insert  into `parking_record`(`rec_id`,`rec_car_id`,`rec_entry_date`,`rec_leave_date`,`rec_time`,`rec_charge`,`rec_cost`,`rec_own_id`) values (1,'豫L00000','2019-12-16 00:00:00',NULL,NULL,NULL,NULL,1),(2,'豫L00001','2019-12-16 00:00:00',NULL,NULL,NULL,NULL,2),(3,'豫L66666','2019-12-17 16:47:40','2019-12-17 16:47:50',1,'2','2',NULL),(4,'豫L66666','2019-12-18 09:48:45','2019-12-18 09:49:12',1,'2','2',NULL),(5,'豫L66666','2019-12-18 09:48:58','2019-12-18 09:49:12',1,'2','2',NULL),(6,'豫L66666','2019-12-18 10:29:50','2019-12-18 10:30:10',1,'2','2',NULL),(7,'豫L66666','2019-12-19 23:08:00','2019-12-19 23:08:21',1,'2','2',NULL),(8,'豫L66666','2019-12-19 23:21:26','2019-12-19 23:26:45',1,'2','2',NULL),(9,'豫L66666','2019-12-19 23:26:51','2019-12-19 23:26:58',1,'2','2',NULL),(10,'豫L66666','2019-12-19 23:27:23','2019-12-19 23:38:58',1,'2','2',NULL),(11,'豫L66666','2019-12-19 23:38:45','2019-12-19 23:38:58',1,'2','2',NULL),(12,'豫L66666','2019-12-19 23:39:42','2019-12-19 23:41:28',1,'2','2',NULL),(13,'豫L66666','2019-12-19 23:41:34','2019-12-19 23:41:40',1,'2','2',NULL),(14,'豫L66666','2019-12-19 23:41:56','2019-12-19 23:42:01',1,'2','2',NULL),(15,'豫L66666','2019-12-20 09:08:27','2019-12-20 09:09:14',1,'2','2',NULL),(16,'豫L66666','2019-12-20 09:26:56','2019-12-20 09:27:12',1,'2','2',NULL),(17,'豫L66666','2019-12-20 09:26:56','2019-12-20 09:27:12',1,'2','2',NULL),(18,'豫L66666','2019-12-20 09:27:03','2019-12-20 09:27:12',1,'2','2',NULL);

/*Table structure for table `parking_res` */

DROP TABLE IF EXISTS `parking_res`;

CREATE TABLE `parking_res` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '预订车位ID',
  `res_car_id` varchar(50) DEFAULT NULL COMMENT '车牌号',
  `res_sta_id` varchar(50) DEFAULT NULL COMMENT '车位号',
  `res_start_time` datetime DEFAULT NULL COMMENT '预订开始时间',
  `res_end_time` datetime DEFAULT NULL COMMENT '预订结束时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

/*Data for the table `parking_res` */

/*Table structure for table `parking_stall` */

DROP TABLE IF EXISTS `parking_stall`;

CREATE TABLE `parking_stall` (
  `id` bigint(20) NOT NULL COMMENT '车位编号',
  `sta_id` varchar(50) DEFAULT NULL COMMENT '是否占位',
  `sta_place` bigint(20) DEFAULT NULL COMMENT '是否固定',
  `sta_fixation` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `parking_stall` */

insert  into `parking_stall`(`id`,`sta_id`,`sta_place`,`sta_fixation`) values (1,'1',1,NULL),(2,'1',1,NULL);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(50) NOT NULL COMMENT '密码',
  `user_role_id` bigint(10) NOT NULL,
  `user_car_id` varchar(50) NOT NULL COMMENT '停车用户表的id',
  PRIMARY KEY (`user_id`),
  KEY `user_role_id` (`user_role_id`),
  KEY `user_car_id` (`user_car_id`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`user_role_id`) REFERENCES `user_role` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`user_id`,`username`,`password`,`user_role_id`,`user_car_id`) values (1,'admin','admin',2,'豫L00000'),(2,'xiaobai','xiaobi',1,'豫L00001'),(3,'cyh','cyh',2,'豫L66666'),(4,'Gxuxu','Gxuxu',1,'豫L00022');

/*Table structure for table `user_role` */

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(50) NOT NULL,
  `role_desc` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `user_role` */

insert  into `user_role`(`role_id`,`role_name`,`role_desc`) values (1,'普通用户','普通用户必须要先使用该系统的注册功能注册账号之后才能登陆使用该系统，普通用户可以管理用户信息、车位预'),(2,'管理员','管理所有操作');

/*Table structure for table `wx_user` */

DROP TABLE IF EXISTS `wx_user`;

CREATE TABLE `wx_user` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `openid` varchar(50) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `user_role_id` bigint(11) DEFAULT NULL,
  `user_car_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `wx_user` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
