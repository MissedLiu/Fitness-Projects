-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: db_test15
-- ------------------------------------------------------
-- Server version	8.0.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `allot_member`
--

DROP TABLE IF EXISTS `allot_member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `allot_member` (
                                `allot_id` bigint NOT NULL AUTO_INCREMENT COMMENT '分配编号',
                                `member_id` bigint NOT NULL COMMENT '会员编号',
                                `emp_id` bigint NOT NULL COMMENT '客服编号',
                                PRIMARY KEY (`allot_id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='会员客服分分配表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `allot_member`
--

LOCK TABLES `allot_member` WRITE;
/*!40000 ALTER TABLE `allot_member` DISABLE KEYS */;
INSERT INTO `allot_member` VALUES (17,7,28),(18,8,28),(19,9,28),(20,10,30),(21,11,30),(22,12,31),(23,22,32),(24,3,27),(25,4,27),(26,5,27),(27,6,27),(28,23,27),(29,24,55),(30,25,55),(31,26,55),(32,27,55),(33,28,55),(34,29,57),(35,30,57),(36,31,57),(37,33,57);
/*!40000 ALTER TABLE `allot_member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `allot_prospect`
--

DROP TABLE IF EXISTS `allot_prospect`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `allot_prospect` (
                                  `allot_id` bigint NOT NULL AUTO_INCREMENT COMMENT '分配编号',
                                  `prospect_id` bigint NOT NULL COMMENT '潜在用户编号',
                                  `emp_id` bigint NOT NULL COMMENT '客服编号',
                                  PRIMARY KEY (`allot_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='会员客服分分配表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `allot_prospect`
--

LOCK TABLES `allot_prospect` WRITE;
/*!40000 ALTER TABLE `allot_prospect` DISABLE KEYS */;
INSERT INTO `allot_prospect` VALUES (1,1,27),(2,2,27),(3,3,27),(4,4,27),(5,6,27),(6,7,55),(7,8,55),(8,9,55),(9,10,55),(10,11,57),(11,12,57),(12,13,57);
/*!40000 ALTER TABLE `allot_prospect` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `blacklist`
--

DROP TABLE IF EXISTS `blacklist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `blacklist` (
                             `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
                             `member_id` bigint NOT NULL COMMENT '会员编号',
                             `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '拉黑时间',
                             `why` varchar(255) NOT NULL COMMENT '原因',
                             PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='黑名单表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `blacklist`
--

LOCK TABLES `blacklist` WRITE;
/*!40000 ALTER TABLE `blacklist` DISABLE KEYS */;
INSERT INTO `blacklist` VALUES (24,32,'2022-10-19 19:39:10','qq');
/*!40000 ALTER TABLE `blacklist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `caigou_shenhe`
--

DROP TABLE IF EXISTS `caigou_shenhe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `caigou_shenhe` (
                                 `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
                                 `schedule_id` bigint NOT NULL COMMENT '采购编号',
                                 `shenheemp_id` bigint NOT NULL COMMENT '审核人账号id',
                                 `state` tinyint NOT NULL DEFAULT '0' COMMENT '审核结果(0-待审,2-拒绝,1-同意)',
                                 `result` varchar(800) DEFAULT NULL COMMENT '备注',
                                 PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=86 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='采购计划审核';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `caigou_shenhe`
--

LOCK TABLES `caigou_shenhe` WRITE;
/*!40000 ALTER TABLE `caigou_shenhe` DISABLE KEYS */;
INSERT INTO `caigou_shenhe` VALUES (36,73,6,1,'同意'),(37,73,14,1,'同意'),(38,73,15,1,'同意'),(42,71,6,2,'不同意'),(43,71,14,1,'同意'),(44,71,15,1,'不同意,太贵'),(45,70,6,1,'无'),(46,69,6,1,'无'),(47,69,14,1,'无'),(48,68,6,5,'无'),(49,68,14,5,'无'),(50,67,6,5,'无'),(51,67,14,5,'无'),(52,66,6,1,'无'),(53,66,14,1,'无'),(54,65,6,1,'无'),(55,65,14,1,'无'),(56,64,6,1,'无'),(57,64,14,1,'无'),(58,63,6,1,'无'),(59,63,14,1,'无'),(60,62,6,1,'无'),(61,62,14,1,'无'),(62,76,6,1,'无'),(63,75,6,1,'无'),(64,74,6,1,'无'),(65,77,6,1,'无'),(66,79,6,1,''),(67,78,6,0,NULL),(68,80,6,1,NULL),(84,81,6,1,'同意'),(85,81,14,1,'好 再买两百台');
/*!40000 ALTER TABLE `caigou_shenhe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `callback`
--

DROP TABLE IF EXISTS `callback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `callback` (
                            `callback_id` bigint NOT NULL AUTO_INCREMENT COMMENT '回访编号',
                            `member_id` bigint NOT NULL COMMENT '会员编号',
                            `callback_content` varchar(255) NOT NULL COMMENT '内容',
                            `Column_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '时间',
                            PRIMARY KEY (`callback_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='客服回访记录表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `callback`
--

LOCK TABLES `callback` WRITE;
/*!40000 ALTER TABLE `callback` DISABLE KEYS */;
/*!40000 ALTER TABLE `callback` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `callback_member`
--

DROP TABLE IF EXISTS `callback_member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `callback_member` (
                                   `callback_id` bigint NOT NULL AUTO_INCREMENT COMMENT '回访编号',
                                   `member_id` bigint NOT NULL COMMENT '会员编号',
                                   `callback_content` varchar(255) NOT NULL COMMENT '内容',
                                   `Column_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '时间',
                                   PRIMARY KEY (`callback_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='客服回访会员记录表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `callback_member`
--

LOCK TABLES `callback_member` WRITE;
/*!40000 ALTER TABLE `callback_member` DISABLE KEYS */;
INSERT INTO `callback_member` VALUES (2,3,' 我仍未二嘎而我国','2022-10-18 18:56:06'),(3,3,' 我仍未二嘎而我国','2022-10-18 18:56:06'),(4,3,' 我仍未二嘎而我国','2022-10-18 18:56:09'),(5,4,' 我仍未二嘎而我国','2022-10-18 18:56:11'),(6,5,' 我仍未二嘎而我国','2022-10-18 18:56:53'),(7,6,' 我仍未二嘎而我国','2022-10-18 18:56:54'),(8,5,' 我仍未二嘎而我国','2022-10-18 18:56:56'),(9,5,' 我仍未二嘎而我国','2022-10-18 18:56:57'),(10,3,'阿擦擦擦才','2022-10-18 18:57:06'),(11,4,'阿擦擦擦才','2022-10-18 18:57:08'),(12,5,'阿擦擦擦才','2022-10-18 18:57:09'),(13,6,'阿擦擦擦才','2022-10-18 18:57:11'),(14,7,'2022年10月18日无3','2022-10-18 19:02:12'),(15,3,'士大夫撒大哥','2022-10-18 19:03:30'),(16,3,'士大夫撒大哥','2022-10-18 19:03:31'),(17,3,'士大夫撒大哥','2022-10-18 19:03:33'),(18,3,'士大夫撒大哥','2022-10-18 19:03:35'),(19,3,'士大夫撒大哥','2022-10-18 19:03:36');
/*!40000 ALTER TABLE `callback_member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `callback_prospect`
--

DROP TABLE IF EXISTS `callback_prospect`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `callback_prospect` (
                                     `callback_id` bigint NOT NULL AUTO_INCREMENT COMMENT '回访编号',
                                     `prospect_id` bigint NOT NULL COMMENT '会员编号',
                                     `callback_content` varchar(255) NOT NULL COMMENT '内容',
                                     `Column_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '时间',
                                     PRIMARY KEY (`callback_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `callback_prospect`
--

LOCK TABLES `callback_prospect` WRITE;
/*!40000 ALTER TABLE `callback_prospect` DISABLE KEYS */;
INSERT INTO `callback_prospect` VALUES (1,1,'亲爱的小赵同学.来我们牛牛健身房健身嘛','2022-10-10 23:04:57'),(4,3,'发发按复位法为','2022-10-18 18:53:59'),(5,3,'啊发文','2022-10-18 18:54:03'),(6,2,'发我收发文分','2022-10-18 18:54:12'),(7,6,'瓦尔发为维AWE 我微软发额','2022-10-18 18:54:17'),(8,6,'人为我微软为为阿瓦尔娃儿我让人','2022-10-18 18:54:22'),(9,6,'二娃儿安慰我二为绕弯儿娃儿为微软为我绕弯儿娃儿无人为为绕弯儿娃儿','2022-10-18 18:54:28'),(10,3,'as二发翁所绕翁','2022-10-18 18:54:31'),(11,2,'发送到发士大夫','2022-10-18 18:54:42'),(12,6,'发的规划将对方过后就','2022-10-18 18:54:49'),(13,3,'恢复得更好的发生负担和对方过后','2022-10-18 18:55:05'),(14,2,'山东人gas恶的人gas儿童','2022-10-18 18:55:11'),(15,2,'噶尔噶而过阿无功无过 ','2022-10-18 18:55:24'),(16,4,'高二通过阿尔噶尔格奥尔 ','2022-10-18 18:55:29');
/*!40000 ALTER TABLE `callback_prospect` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `changenum`
--

DROP TABLE IF EXISTS `changenum`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `changenum` (
                             `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
                             `shopping_id` bigint NOT NULL COMMENT '物品编号',
                             `change_lose` bigint DEFAULT '0' COMMENT '报损数',
                             `change_more` bigint DEFAULT '0' COMMENT '报溢数',
                             `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                             PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=107 DEFAULT CHARSET=utf8mb3 COMMENT='报损报溢表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `changenum`
--

LOCK TABLES `changenum` WRITE;
/*!40000 ALTER TABLE `changenum` DISABLE KEYS */;
INSERT INTO `changenum` VALUES (91,101,2,0,'2022-10-18 19:37:03'),(92,110,0,0,'2022-10-18 19:44:11'),(93,109,0,0,'2022-10-18 19:44:17'),(94,108,0,0,'2022-10-18 19:44:19'),(95,107,0,0,'2022-10-18 19:44:23'),(96,106,0,0,'2022-10-18 19:44:28'),(97,105,0,0,'2022-10-18 19:44:31'),(98,104,0,0,'2022-10-18 19:44:35'),(99,103,0,0,'2022-10-18 19:44:39'),(100,102,0,0,'2022-10-18 19:44:42'),(101,113,0,0,'2022-10-18 19:51:19'),(102,112,0,0,'2022-10-18 19:51:23'),(103,111,0,0,'2022-10-18 19:51:26'),(104,114,0,0,'2022-10-18 19:54:24'),(105,115,0,0,'2022-10-18 20:40:51'),(106,116,0,0,'2022-10-19 15:36:52');
/*!40000 ALTER TABLE `changenum` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `choose_projectname`
--

DROP TABLE IF EXISTS `choose_projectname`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `choose_projectname` (
                                      `cp_id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
                                      `mm_id` bigint NOT NULL COMMENT '套餐办理编号',
                                      `ptp_id` bigint NOT NULL COMMENT '项目编号',
                                      `emp_id` bigint NOT NULL COMMENT '教练编号',
                                      `choose_id` bigint NOT NULL COMMENT '套餐编号',
                                      PRIMARY KEY (`cp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=203 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='所选项目表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `choose_projectname`
--

LOCK TABLES `choose_projectname` WRITE;
/*!40000 ALTER TABLE `choose_projectname` DISABLE KEYS */;
INSERT INTO `choose_projectname` VALUES (196,222,13,14,15),(198,224,13,14,17),(199,225,16,19,18),(202,228,15,11,25);
/*!40000 ALTER TABLE `choose_projectname` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `commission`
--

DROP TABLE IF EXISTS `commission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `commission` (
                              `commission_id` bigint NOT NULL AUTO_INCREMENT,
                              `salesman_id` bigint NOT NULL COMMENT '销售人',
                              `emp_name` varchar(255) NOT NULL COMMENT '销售人员姓名',
                              `emp_phone` varchar(255) NOT NULL COMMENT '销售人员电话',
                              `department_name` varchar(255) NOT NULL,
                              `commission_sj` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '私教课程提成',
                              `commission_pt` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '普通课程提成',
                              `commission_tc` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '团操课程提成',
                              `commission_sp` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '商品提成',
                              `commission_price` bigint NOT NULL DEFAULT '0' COMMENT '总提成',
                              `comm_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
                              PRIMARY KEY (`commission_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='提成统计表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commission`
--

LOCK TABLES `commission` WRITE;
/*!40000 ALTER TABLE `commission` DISABLE KEYS */;
INSERT INTO `commission` VALUES (2,1,'小明','17680713872','牛牛健身有限公司',0.00,170.00,0.00,0.00,170,'2022-10-19 11:05:40');
/*!40000 ALTER TABLE `commission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `common_meal`
--

DROP TABLE IF EXISTS `common_meal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `common_meal` (
                               `cm_id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '普通套餐编号',
                               `cm_time` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '套餐时长(月卡,周卡)',
                               `cm_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '套餐生效时间',
                               `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
                               `cm_price` bigint NOT NULL COMMENT '套餐价格',
                               `cm_is` tinyint unsigned DEFAULT '0' COMMENT '是否禁用(1-禁用,0-使用)',
                               `cm_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '套餐名',
                               PRIMARY KEY (`cm_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='普通会员套餐表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `common_meal`
--

LOCK TABLES `common_meal` WRITE;
/*!40000 ALTER TABLE `common_meal` DISABLE KEYS */;
INSERT INTO `common_meal` VALUES (22,'一天','2022-10-18 15:02:10','2022-10-18 15:02:10',100,0,'普通套餐1'),(23,'两天','2022-10-18 15:02:21','2022-10-18 15:02:21',150,0,'普通套餐2'),(24,'三天','2022-10-18 15:02:30','2022-10-18 15:02:30',200,0,'普通套餐3'),(25,'四天','2022-10-18 15:02:42','2022-10-18 15:02:42',250,0,'普通套餐4'),(26,'五天','2022-10-18 15:02:52','2022-10-18 15:02:52',500,0,'普通套餐5'),(27,'一周','2022-10-18 15:03:05','2022-10-18 15:03:05',600,0,'普通套餐6'),(28,'两周','2022-10-18 15:03:28','2022-10-18 15:03:28',1200,0,'普通套餐7'),(29,'三周','2022-10-18 15:03:41','2022-10-18 15:03:41',1500,0,'普通套餐8'),(30,'一个月','2022-10-18 15:04:06','2022-10-18 15:04:06',1600,0,'普通套餐9'),(31,'三个月','2022-10-18 15:04:20','2022-10-18 15:04:20',4569,0,'普通套餐10'),(32,'一年','2022-10-18 15:04:41','2022-10-18 15:04:41',5000,1,'普通套餐11'),(33,'八个月','2022-10-18 15:04:58','2022-10-18 15:04:58',1253,0,'普通套餐12'),(34,'九个月','2022-10-18 15:05:15','2022-10-18 15:05:15',1236,0,'普通套餐13'),(35,'十个月','2022-10-18 15:05:37','2022-10-18 15:05:37',1700,0,'普通套餐14'),(36,'十一个月','2022-10-18 15:06:00','2022-10-18 15:06:00',1800,0,'普通套餐15');
/*!40000 ALTER TABLE `common_meal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `communicating`
--

DROP TABLE IF EXISTS `communicating`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `communicating` (
                                 `com_id` bigint NOT NULL COMMENT '记录编号',
                                 `emp_id` bigint NOT NULL COMMENT '教练编号',
                                 `com_content` varchar(225) NOT NULL COMMENT '沟通内容',
                                 `com_time` datetime NOT NULL COMMENT '沟通时间',
                                 `com_uid` bigint NOT NULL COMMENT '当潜在用户变成会员时，改变成为会员编号\n            ',
                                 PRIMARY KEY (`com_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='客户沟通记录表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `communicating`
--

LOCK TABLES `communicating` WRITE;
/*!40000 ALTER TABLE `communicating` DISABLE KEYS */;
/*!40000 ALTER TABLE `communicating` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compact`
--

DROP TABLE IF EXISTS `compact`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `compact` (
                           `compact_id` bigint NOT NULL AUTO_INCREMENT COMMENT '合同编号',
                           `mm_id` bigint NOT NULL COMMENT '签订套餐编号',
                           `member_id` bigint NOT NULL COMMENT '会员编号',
                           `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '签订日期',
                           `end_date` datetime NOT NULL COMMENT '结束日期',
                           `photo_address` varchar(225) NOT NULL COMMENT '合同原件图片地址',
                           `photo_address2` varchar(225) NOT NULL COMMENT '合同原件图片地址2',
                           `photo_address3` varchar(225) NOT NULL COMMENT '合同原件图片地址3',
                           `photo_address4` varchar(225) DEFAULT NULL COMMENT '合同原件图片地址4',
                           `photo_address5` varchar(225) DEFAULT NULL COMMENT '合同原件图片地址5',
                           `compact_type` varchar(20) NOT NULL COMMENT '合同类型（私教，团操 ,普通）',
                           `salesman` varchar(50) NOT NULL COMMENT '业务员',
                           PRIMARY KEY (`compact_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='合同管理';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compact`
--

LOCK TABLES `compact` WRITE;
/*!40000 ALTER TABLE `compact` DISABLE KEYS */;
INSERT INTO `compact` VALUES (10,222,33,'2022-10-19 00:00:00','2022-10-20 00:00:00','https://liucz-bucket.oss-cn-hangzhou.aliyuncs.com/photoAddress/2022/10/19/95635de9c1f74b498cadb4f77eafdfc6.jpg','https://liucz-bucket.oss-cn-hangzhou.aliyuncs.com/photoAddress2/2022/10/19/ef752b458ddb4957bf5d68dd9336ea5e.jpg','https://liucz-bucket.oss-cn-hangzhou.aliyuncs.com/photoAddress3/2022/10/19/44586e53c35047af87d04e6060be0311.jpg','','','私教','小刘'),(11,228,31,'2022-10-19 00:00:00','2022-10-21 00:00:00','https://liucz-bucket.oss-cn-hangzhou.aliyuncs.com/photoAddress/2022/10/19/efed6242fd4a483982c9e72aaee36b6c.jpg','https://liucz-bucket.oss-cn-hangzhou.aliyuncs.com/photoAddress2/2022/10/19/998935386fbd4b4683abc337f9d57dda.jpg','https://liucz-bucket.oss-cn-hangzhou.aliyuncs.com/photoAddress3/2022/10/19/a37151d47d34469a98cf13c1bad75ed1.jpg','','','团操','小刘');
/*!40000 ALTER TABLE `compact` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comsune`
--

DROP TABLE IF EXISTS `comsune`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comsune` (
                           `comsune_id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
                           `member_id` bigint NOT NULL COMMENT '会员编号',
                           `meal_id` bigint NOT NULL COMMENT '套餐编号',
                           `meal_name` varchar(20) NOT NULL COMMENT '套餐名称',
                           `meal_type` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '套餐类型',
                           `ptp_id` bigint DEFAULT NULL COMMENT '项目编号',
                           `ptp_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '项目名称',
                           `comsune_price` bigint NOT NULL COMMENT '消费金额',
                           `comsune_date` datetime NOT NULL COMMENT '消费时间',
                           PRIMARY KEY (`comsune_id`)
) ENGINE=InnoDB AUTO_INCREMENT=177 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='消费记录表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comsune`
--

LOCK TABLES `comsune` WRITE;
/*!40000 ALTER TABLE `comsune` DISABLE KEYS */;
INSERT INTO `comsune` VALUES (128,4,23,'普通套餐2','普通',NULL,NULL,150,'2022-10-18 15:26:30'),(129,5,25,'普通套餐4','普通',NULL,NULL,250,'2022-10-18 15:26:57'),(130,6,26,'普通套餐5','普通',NULL,NULL,500,'2022-10-18 15:27:22'),(131,7,29,'普通套餐8','普通',NULL,NULL,1500,'2022-10-18 15:27:43'),(132,8,24,'普通套餐3','普通',NULL,NULL,200,'2022-10-18 15:28:10'),(133,3,28,'普通套餐7','普通',NULL,NULL,1200,'2022-10-18 15:29:19'),(134,1,27,'普通套餐6','普通',NULL,NULL,600,'2022-10-18 15:33:17'),(135,22,24,'普通套餐3','普通',NULL,NULL,200,'2022-10-18 15:36:53'),(136,23,24,'普通套餐3','普通',NULL,NULL,200,'2022-10-18 15:39:04'),(137,23,15,'私教套餐1','私教',13,'私教项目1',10,'2022-10-18 15:43:09'),(138,23,16,'私教套餐2','私教',14,'私教项目2',20,'2022-10-18 15:43:44'),(139,23,15,'私教套餐1','私教',15,'私教项目3',10,'2022-10-18 15:44:05'),(140,22,17,'私教套餐3','私教',15,'私教项目3',30,'2022-10-18 15:45:54'),(141,4,17,'私教套餐3','私教',15,'私教项目3',30,'2022-10-18 15:46:21'),(142,5,16,'私教套餐2','私教',15,'私教项目3',20,'2022-10-18 15:52:33'),(143,6,16,'私教套餐2','私教',15,'私教项目3',20,'2022-10-18 15:53:17'),(144,7,16,'私教套餐2','私教',15,'私教项目3',20,'2022-10-18 15:53:50'),(145,8,16,'私教套餐2','私教',14,'私教项目2',20,'2022-10-18 15:54:10'),(146,3,17,'私教套餐3','私教',15,'私教项目3',30,'2022-10-18 15:56:04'),(147,23,24,'团操套餐1','团操',13,'团操项目1',10,'2022-10-18 15:58:58'),(148,22,24,'团操套餐1','团操',14,'团操项目2',10,'2022-10-18 15:59:11'),(149,4,24,'团操套餐1','团操',14,'团操项目2',10,'2022-10-18 15:59:21'),(150,5,25,'团操套餐2','团操',13,'团操项目1',20,'2022-10-18 15:59:39'),(151,6,25,'团操套餐2','团操',14,'团操项目2',20,'2022-10-18 15:59:54'),(152,7,25,'团操套餐2','团操',13,'团操项目1',20,'2022-10-18 16:00:05'),(153,8,25,'团操套餐2','团操',15,'团操项目3',20,'2022-10-18 16:00:21'),(154,3,25,'团操套餐2','团操',13,'团操项目1',20,'2022-10-18 16:01:39'),(155,24,35,'普通套餐14','普通',NULL,NULL,1700,'2022-10-19 11:01:49'),(156,28,26,'团操套餐3','团操',16,'团操项目4',30,'2022-10-19 11:02:57'),(157,30,15,'私教套餐1','私教',13,'私教项目1',10,'2022-10-19 11:05:13'),(158,8,25,'普通套餐4','普通',NULL,NULL,250,'2022-10-19 18:34:33'),(159,7,25,'普通套餐4','普通',NULL,NULL,250,'2022-10-19 18:35:04'),(160,5,22,'普通套餐1','普通',NULL,NULL,100,'2022-10-19 18:44:26'),(161,5,22,'普通套餐1','普通',NULL,NULL,100,'2022-10-19 18:44:34'),(162,33,15,'私教套餐1','私教',16,'私教项目4',10,'2022-10-19 18:52:48'),(163,33,16,'私教套餐2','私教',13,'私教项目1',20,'2022-10-19 18:53:06'),(164,28,19,'私教套餐5','私教',20,'私教项目8',50,'2022-10-19 19:00:47'),(165,29,18,'私教套餐4','私教',18,'私教项目6',40,'2022-10-19 19:03:40'),(166,33,24,'团操套餐1','团操',14,'团操项目2',10,'2022-10-19 19:07:23'),(167,30,26,'团操套餐3','团操',13,'团操项目1',30,'2022-10-19 19:08:32'),(168,31,28,'团操套餐5','团操',14,'团操项目2',50,'2022-10-19 19:08:50'),(169,33,15,'私教套餐1','私教',14,'私教项目2',10,'2022-10-19 19:18:05'),(170,31,27,'团操套餐4','团操',13,'团操项目1',40,'2022-10-19 19:24:46'),(171,33,15,'私教套餐1','私教',13,'私教项目1',10,'2022-10-19 19:30:22'),(172,32,17,'私教套餐3','私教',13,'私教项目1',30,'2022-10-19 19:32:29'),(173,32,18,'私教套餐4','私教',16,'私教项目4',40,'2022-10-19 19:32:43'),(174,32,16,'私教套餐2','私教',13,'私教项目1',20,'2022-10-19 19:38:44'),(175,32,16,'私教套餐2','私教',13,'私教项目1',20,'2022-10-19 19:38:58'),(176,31,25,'团操套餐2','团操',15,'团操项目3',20,'2022-10-19 19:47:44');
/*!40000 ALTER TABLE `comsune` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `disburse`
--

DROP TABLE IF EXISTS `disburse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `disburse` (
                            `disburse_id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
                            `disburse_type` varchar(50) NOT NULL COMMENT '支出项目类型(商品,器材,其他)',
                            `disburse_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                            `disburse_price` bigint NOT NULL COMMENT '支出金额',
                            `beizhu` varchar(225) DEFAULT NULL COMMENT '备注',
                            PRIMARY KEY (`disburse_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1582697940799647747 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='支出统计报表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `disburse`
--

LOCK TABLES `disburse` WRITE;
/*!40000 ALTER TABLE `disburse` DISABLE KEYS */;
INSERT INTO `disburse` VALUES (1582258044382113794,'器械','2022-10-18 19:33:42',200,'购入2kg哑铃  20元*10件'),(1582258044382113795,'补剂','2022-10-18 19:42:44',3200,'购入右旋  80元*40件'),(1582258044382113796,'补剂','2022-10-18 19:42:48',4000,'购入肌酸  80元*50件'),(1582258044382113797,'补剂','2022-10-18 19:42:52',4000,'购入左旋  80元*50件'),(1582258044382113798,'补剂','2022-10-18 19:42:54',1600,'购入蛋白粉2号  80元*20桶'),(1582258044382113799,'补剂','2022-10-18 19:42:57',1600,'购入蛋白粉1号  80元*20桶'),(1582258044382113800,'器械','2022-10-18 19:42:58',100,'购入双杠  50元*2台'),(1582258044382113801,'器械','2022-10-18 19:43:00',500,'购入杠铃5kg  50元*10件'),(1582258044382113802,'器械','2022-10-18 19:43:02',4000,'购入龙门架  2000元*2台'),(1582258044382113803,'器械','2022-10-18 19:43:05',200,'购入3kg哑铃  10元*20台'),(1582258044382113804,'器械','2022-10-18 19:51:05',2500,'购入8kg哑铃  50元*50件'),(1582258044382113805,'器械','2022-10-18 19:51:07',100,'购入臂力棒  2元*50件'),(1582258044382113806,'器材','2022-10-18 19:51:09',1500,'购入仰卧起做器  50元*30台'),(1582258044382113807,'器械','2022-10-18 19:54:14',500,'购入2kg哑铃  10元*50件'),(1582258044382113808,'器械','2022-10-18 20:40:34',2500,'购入15kg哑铃  50元*50件'),(1582258044382113809,'器械','2022-10-19 15:36:32',8880,'购入跑步机  888元*10台'),(1582690558250000385,'退费','2022-10-19 19:10:09',300,'退费'),(1582692908914114562,'退费','2022-10-19 19:19:29',200,'退费'),(1582694404489633794,'退费','2022-10-19 19:25:26',233,'退费'),(1582695118158913537,'退费','2022-10-19 19:28:16',233,'退费'),(1582695887167737858,'退费','2022-10-19 19:31:19',26,'退费'),(1582696354929102850,'退费','2022-10-19 19:33:11',24,'退费'),(1582697940799647746,'退费','2022-10-19 19:39:29',21,'退费');
/*!40000 ALTER TABLE `disburse` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equipment_details`
--

DROP TABLE IF EXISTS `equipment_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `equipment_details` (
                                     `ed_id` bigint NOT NULL AUTO_INCREMENT COMMENT '器材使用详情id',
                                     `stockin_id` bigint NOT NULL COMMENT '物品id',
                                     `ed_name` varchar(255) NOT NULL COMMENT '器材名',
                                     `ed_code` varchar(255) NOT NULL COMMENT '器材编码',
                                     `ed_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '开始使用时间',
                                     `brand` varchar(255) NOT NULL COMMENT '品牌',
                                     `ed_state` bigint NOT NULL DEFAULT '1' COMMENT '器材状态 (1使用中 0未使用 )',
                                     `beizhu` varchar(255) NOT NULL COMMENT '备注',
                                     PRIMARY KEY (`ed_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='器材使用记录表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipment_details`
--

LOCK TABLES `equipment_details` WRITE;
/*!40000 ALTER TABLE `equipment_details` DISABLE KEYS */;
INSERT INTO `equipment_details` VALUES (2,101,'2kg哑铃','001','2022-10-18 00:00:00','Keep',0,'无'),(3,109,'龙门架','002','2022-10-18 19:58:08','Keep',1,'无'),(4,101,'2kg哑铃','003','2022-10-18 19:59:09','Keep',1,'无'),(5,101,'2kg哑铃','006','2022-10-18 20:02:03','Keep',1,'无'),(6,107,'双杠','007','2022-10-18 20:02:38','Keep',1,'无'),(9,110,'3kg哑铃','010','2022-10-18 20:05:28','Keep',1,'无'),(10,110,'3kg哑铃','011','2022-10-18 20:05:45','Keep',1,'无'),(11,110,'3kg哑铃','012','2022-10-18 20:06:06','Keep',1,'无'),(12,110,'3kg哑铃','013','2022-10-18 20:06:31','Keep',1,'无'),(13,107,'双杠','014','2022-10-18 20:07:27','Keep',2,'无'),(14,108,'杠铃5kg','015','2022-10-19 00:00:00','Keep',1,'无'),(15,116,'跑步机','pbj001','2022-10-19 00:00:00','keep',0,'跑步机001'),(16,116,'跑步机','pbj002','2022-10-19 00:00:00','keep',0,'跑步机002'),(17,116,'跑步机','pbj003','2022-10-19 15:39:13','keep',1,'跑步机003'),(18,116,'跑步机','pbj004','2022-10-19 15:39:50','keep',2,'跑步机004'),(19,116,'跑步机','pbj005','2022-10-19 15:41:08','keep',1,'跑步机005');
/*!40000 ALTER TABLE `equipment_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equipment_eamage`
--

DROP TABLE IF EXISTS `equipment_eamage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `equipment_eamage` (
                                    `ee_id` bigint NOT NULL AUTO_INCREMENT COMMENT '上报编号',
                                    `ed_code` varchar(225) NOT NULL COMMENT '器材编号(物品编号)',
                                    `ee_name` varchar(50) NOT NULL COMMENT '器材名称',
                                    `ee_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '登记时间',
                                    `ee_content` varchar(500) NOT NULL COMMENT '故障原因',
                                    `beizhu` varchar(200) DEFAULT NULL COMMENT '备注',
                                    `sname` varchar(225) NOT NULL COMMENT '上报人',
                                    `state` tinyint NOT NULL DEFAULT '0' COMMENT '(0-已上报, 2-维修中,3-维修完成,4-维修失败 )',
                                    PRIMARY KEY (`ee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='器材损坏上报表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipment_eamage`
--

LOCK TABLES `equipment_eamage` WRITE;
/*!40000 ALTER TABLE `equipment_eamage` DISABLE KEYS */;
INSERT INTO `equipment_eamage` VALUES (4,'014','双杠','2022-10-18 20:08:31','零件松动','有安全隐患','小刘',4),(6,'002','龙门架','2022-10-18 20:13:24','无法使用','无法使用','小刘',3),(7,'pbj004','跑步机','2022-10-19 15:41:51','坏了','坏了','刀哥',4);
/*!40000 ALTER TABLE `equipment_eamage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equipment_maintenance`
--

DROP TABLE IF EXISTS `equipment_maintenance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `equipment_maintenance` (
                                         `em_id` bigint NOT NULL AUTO_INCREMENT COMMENT '维修编号',
                                         `emp_name` varchar(225) NOT NULL COMMENT '维修人',
                                         `ee_id` bigint NOT NULL COMMENT '上报编号',
                                         `em_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '维修日期',
                                         `ed_code` varchar(255) NOT NULL,
                                         `resu_its` varchar(500) NOT NULL COMMENT '维修情况',
                                         `methods` tinyint NOT NULL COMMENT '问题解决方式(0-自修,1-换件,2,外修)',
                                         `ed_name` varchar(255) NOT NULL COMMENT '器材名称',
                                         PRIMARY KEY (`em_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='器材维修表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipment_maintenance`
--

LOCK TABLES `equipment_maintenance` WRITE;
/*!40000 ALTER TABLE `equipment_maintenance` DISABLE KEYS */;
INSERT INTO `equipment_maintenance` VALUES (2,'老王',4,'2022-10-18 00:00:00','014','无法维修',1,'双杠'),(3,'老王',6,'2022-10-18 00:00:00','002','好啦',1,'龙门架'),(4,'刀哥',7,'2022-10-19 00:00:00','pbj004','修不好',2,'跑步机');
/*!40000 ALTER TABLE `equipment_maintenance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flyer`
--

DROP TABLE IF EXISTS `flyer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `flyer` (
                         `flyer_id` bigint NOT NULL AUTO_INCREMENT COMMENT '活动记录编号',
                         `flyer_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '负责人姓名',
                         `flyer_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '活动地址',
                         `flyer_num` bigint NOT NULL COMMENT '发放数量',
                         `flyer_staff` varchar(225) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '参与员工',
                         `num` bigint NOT NULL COMMENT '收获潜在用户数量',
                         `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '时间',
                         PRIMARY KEY (`flyer_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='宣传活动记录表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flyer`
--

LOCK TABLES `flyer` WRITE;
/*!40000 ALTER TABLE `flyer` DISABLE KEYS */;
/*!40000 ALTER TABLE `flyer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `group_course`
--

DROP TABLE IF EXISTS `group_course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `group_course` (
                                `course_id` bigint NOT NULL AUTO_INCREMENT COMMENT '课表编号',
                                `gc_id` bigint NOT NULL COMMENT '套餐编号(私教套餐编号或团操套餐编号)',
                                `gc_type` tinyint NOT NULL COMMENT '套餐类型(0-私教,1-团操,2-普通)',
                                `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
                                PRIMARY KEY (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='套餐课课表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `group_course`
--

LOCK TABLES `group_course` WRITE;
/*!40000 ALTER TABLE `group_course` DISABLE KEYS */;
/*!40000 ALTER TABLE `group_course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `healthform`
--

DROP TABLE IF EXISTS `healthform`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `healthform` (
                              `healthForm_id` bigint NOT NULL AUTO_INCREMENT COMMENT '体检编号',
                              `member_id` bigint NOT NULL COMMENT '会员编号',
                              `member_name` varchar(225) NOT NULL COMMENT '会员姓名',
                              `emp_id` bigint NOT NULL COMMENT '体检人编号',
                              `weight` int NOT NULL COMMENT '体重',
                              `height` int NOT NULL COMMENT '身高',
                              `hipline` int DEFAULT NULL COMMENT '臀围',
                              `shoulder_wai` int DEFAULT NULL COMMENT '肩围',
                              `belly` int DEFAULT NULL COMMENT '腹围',
                              `BW` int DEFAULT NULL COMMENT '胸围',
                              `upbicep_left` int DEFAULT NULL COMMENT '上臂围',
                              `beforebicep_right` int DEFAULT NULL COMMENT '前臂围',
                              `bigtrousers_left` int DEFAULT NULL COMMENT '大腿围',
                              `littletrousers_right` int DEFAULT NULL COMMENT '小腿围',
                              `waistline` int DEFAULT NULL COMMENT '腰围',
                              `fat` int DEFAULT NULL COMMENT '脂肪',
                              `weightNBIM` int DEFAULT NULL COMMENT '体重指数BIM',
                              `uimsatz` int DEFAULT NULL COMMENT '基础代谢',
                              `endurance` int DEFAULT NULL COMMENT '腹肌耐力',
                              `flexibility` int DEFAULT NULL COMMENT '柔韧度测试',
                              `pushup` int DEFAULT NULL COMMENT '俯卧撑测试',
                              `OBPM` int DEFAULT NULL COMMENT '血压测量',
                              `hrrest` int DEFAULT NULL COMMENT '心率',
                              `time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '体检时间',
                              PRIMARY KEY (`healthForm_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='会员体检报告';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `healthform`
--

LOCK TABLES `healthform` WRITE;
/*!40000 ALTER TABLE `healthform` DISABLE KEYS */;
INSERT INTO `healthform` VALUES (5,23,'安福',10,180,185,67,34,34,67,43,23,65,45,87,45,34,23,45,23,89,324,67,'2022-10-18 20:21:57');
/*!40000 ALTER TABLE `healthform` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `interview`
--

DROP TABLE IF EXISTS `interview`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `interview` (
                             `interview_id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
                             `emp_id` bigint NOT NULL COMMENT '教练编号',
                             `member_id` bigint NOT NULL COMMENT '会员编号',
                             `member_name` varchar(225) NOT NULL COMMENT '会员姓名',
                             `member_type` tinyint NOT NULL COMMENT '会员类型(0-体验会员,1-会员)',
                             `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '访谈日期',
                             `interview` varchar(1000) NOT NULL COMMENT '访谈内容',
                             PRIMARY KEY (`interview_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='教练会员访谈记录表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `interview`
--

LOCK TABLES `interview` WRITE;
/*!40000 ALTER TABLE `interview` DISABLE KEYS */;
INSERT INTO `interview` VALUES (3,10,23,'安福',1,'2022-10-18 20:22:07','爱上大大'),(4,10,23,'安福',1,'2022-10-18 20:22:10','大声道');
/*!40000 ALTER TABLE `interview` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `invoice`
--

DROP TABLE IF EXISTS `invoice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `invoice` (
                           `invoice_id` bigint NOT NULL AUTO_INCREMENT COMMENT '发票编号',
                           `sales_id` bigint NOT NULL COMMENT '商品销售记录编号',
                           `invoice_name` varchar(200) NOT NULL COMMENT '购买人姓名',
                           `stockIn_name` varchar(100) NOT NULL COMMENT '物品名称',
                           `stockIn_num` bigint NOT NULL COMMENT '物品数量',
                           `price` bigint NOT NULL COMMENT '金额',
                           `emp_id` bigint NOT NULL COMMENT '销售人员编号',
                           `create_time` datetime NOT NULL COMMENT '创建时间',
                           `brand` varchar(50) DEFAULT NULL COMMENT '品牌',
                           PRIMARY KEY (`invoice_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='发票记录表(商品收入统计)';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invoice`
--

LOCK TABLES `invoice` WRITE;
/*!40000 ALTER TABLE `invoice` DISABLE KEYS */;
INSERT INTO `invoice` VALUES (4,4,'小小2','3kg哑铃',1,10,1,'2022-10-19 10:43:45','Keep'),(5,5,'小小3','3kg哑铃',1,10,1,'2022-10-19 10:43:58','Keep'),(6,6,'小小4','龙门架',1,2000,1,'2022-10-19 10:44:36','Keep'),(7,7,'小小5','蛋白粉1号',2,100,1,'2022-10-19 10:44:52','Keep'),(8,8,'小小6','2kg哑铃',2,100,1,'2022-10-19 10:45:42','Keep'),(9,9,'小小8','肌酸',2,160,1,'2022-10-19 10:46:01','Keep'),(10,10,'小小9','右旋',2,200,1,'2022-10-19 10:46:21','Keep'),(11,11,'小小7','肌酸',2,200,1,'2022-10-19 10:46:44','Keep'),(12,12,'小小10','右旋',2,200,1,'2022-10-19 10:47:02','Keep'),(13,13,'小小11','蛋白粉2号',2,200,1,'2022-10-19 10:47:21','Keep'),(14,14,'小小12','右旋',1,100,1,'2022-10-19 10:47:45','Keep');
/*!40000 ALTER TABLE `invoice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `locker`
--

DROP TABLE IF EXISTS `locker`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `locker` (
                          `locker_id` bigint NOT NULL COMMENT '储物柜编号',
                          `locker_state` tinyint NOT NULL DEFAULT '1' COMMENT '储物柜状态(0-已使用,1-未使用,3-不可用)',
                          PRIMARY KEY (`locker_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='储物柜';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `locker`
--

LOCK TABLES `locker` WRITE;
/*!40000 ALTER TABLE `locker` DISABLE KEYS */;
INSERT INTO `locker` VALUES (1,0),(2,0),(3,0),(4,0),(5,0),(6,0),(7,0),(8,0),(9,0),(10,0),(11,0),(12,0),(13,0),(21,1);
/*!40000 ALTER TABLE `locker` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lose`
--

DROP TABLE IF EXISTS `lose`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lose` (
                        `id` bigint NOT NULL AUTO_INCREMENT,
                        `item_name` varchar(200) NOT NULL,
                        `create_ttime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '时间',
                        `state` varchar(20) NOT NULL COMMENT '状态(是否招领)',
                        `uname` varchar(50) DEFAULT NULL,
                        `phone` varchar(20) DEFAULT NULL,
                        `add_time` datetime DEFAULT NULL COMMENT '领取时间',
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='失物招领表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lose`
--

LOCK TABLES `lose` WRITE;
/*!40000 ALTER TABLE `lose` DISABLE KEYS */;
INSERT INTO `lose` VALUES (6,'水壶','2022-10-18 00:00:00','已领取','复式','17680713874','2022-10-18 16:23:01'),(7,'毛衣','2022-10-18 16:20:04','未领取',NULL,NULL,NULL),(8,'手机','2022-10-18 16:20:10','未领取',NULL,NULL,NULL),(9,'毛衣1','2022-10-18 16:21:43','未领取',NULL,NULL,NULL),(10,'毛衣2','2022-10-18 16:21:55','未领取',NULL,NULL,NULL),(11,'毛衣3','2022-10-18 16:21:59','未领取',NULL,NULL,NULL),(12,'毛衣4','2022-10-18 16:22:03','未领取',NULL,NULL,NULL),(13,'毛衣5','2022-10-18 16:22:06','未领取',NULL,NULL,NULL),(14,'毛衣6','2022-10-18 16:22:13','未领取',NULL,NULL,NULL),(15,'毛衣7','2022-10-18 16:22:16','未领取',NULL,NULL,NULL),(16,'毛衣9','2022-10-18 00:00:00','已领取','小米','15197666546','2022-10-19 19:49:36'),(17,'毛衣9','2022-10-18 00:00:00','已领取','小明','17698782822','2022-10-19 19:49:05');
/*!40000 ALTER TABLE `lose` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `member` (
                          `member_id` bigint NOT NULL AUTO_INCREMENT COMMENT '会员编号',
                          `member_name` varchar(20) NOT NULL COMMENT '会员姓名',
                          `member_sex` tinyint NOT NULL COMMENT '会员性别(0-女,1-男)',
                          `member_date` datetime DEFAULT NULL COMMENT '出生日期',
                          `member_phone` varchar(50) NOT NULL COMMENT '电话',
                          `member_age` tinyint NOT NULL COMMENT '年龄',
                          `member_address` varchar(100) NOT NULL COMMENT '住址',
                          `member_state` tinyint DEFAULT '0' COMMENT '会员状态(0-不禁用,1-禁用)',
                          `member_type` int NOT NULL COMMENT '会员类型(0-体验,1-会员)',
                          `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                          `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                          PRIMARY KEY (`member_id`),
                          UNIQUE KEY `member_phone` (`member_phone`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='会员表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` VALUES (4,'安国',1,'2007-10-17 00:00:00','17680713875',15,'湖南株洲',2,1,'2022-10-18 15:17:32','2022-10-18 19:03:13'),(5,'安然',0,'2007-10-17 00:00:00','17680713876',15,'湖南株洲',2,1,'2022-10-18 15:17:32','2022-10-18 19:03:13'),(6,'安平',1,'2007-10-17 00:00:00','17680713877',15,'湖南株洲',2,1,'2022-10-18 15:17:32','2022-10-18 19:03:13'),(7,'安宁',1,'2007-10-17 00:00:00','17680713878',15,'湖南株洲',2,1,'2022-10-18 15:17:32','2022-10-18 16:26:51'),(8,'安民',1,'2003-10-04 00:00:00','17680713879',19,'湖南株洲',2,1,'2022-10-18 15:17:32','2022-10-18 16:26:51'),(9,'安澜',0,'1994-10-17 00:00:00','17680713880',28,'湖南株洲',2,0,'2022-10-18 15:17:32','2022-10-18 16:26:51'),(10,'安康',1,'2002-10-17 00:00:00','17680713881',20,'湖南株洲',2,0,'2022-10-18 15:17:32','2022-10-18 16:26:56'),(11,'安和',1,'2009-10-17 00:00:00','17680713882',12,'湖南株洲',2,0,'2022-10-18 15:17:32','2022-10-18 16:26:56'),(12,'安顺',1,'1993-10-17 00:00:00','17680713883',29,'湖南株洲',2,0,'2022-10-18 15:17:32','2022-10-18 16:27:00'),(22,'安晏',1,'1991-01-30 00:00:00','17180713872',31,'株洲',2,1,'2022-10-18 15:36:29','2022-10-18 16:27:02'),(23,'安福',1,'1980-02-05 00:00:00','17680713873',42,'西湖周',2,1,'2022-10-18 15:38:46','2022-10-18 19:03:13'),(24,'小刘11',1,'1960-05-03 00:00:00','18680713861',62,'株洲',2,1,'2022-10-19 10:51:48','2022-10-19 19:51:02'),(25,'小9',1,'2000-02-01 00:00:00','18680713899',22,'株洲',2,1,'2022-10-19 10:52:37','2022-10-19 19:51:02'),(26,'小刘7',1,'1980-06-03 00:00:00','18680713898',42,'株洲',2,1,'2022-10-19 10:53:28','2022-10-19 19:51:02'),(27,'小刘5',1,'1981-01-06 00:00:00','18680713894',41,'株洲',2,1,'2022-10-19 10:56:59','2022-10-19 19:51:02'),(28,'小刘6',1,'1980-06-03 00:00:00','18680713897',42,'株洲',2,1,'2022-10-19 10:57:27','2022-10-19 19:51:02'),(29,'小刘2',1,'1981-06-02 00:00:00','18680713892',41,'株洲',2,1,'2022-10-19 10:58:14','2022-10-19 19:51:22'),(30,'小刘1',1,'1980-06-03 00:00:00','18680713891',42,'株洲',2,1,'2022-10-19 11:00:16','2022-10-19 19:51:22'),(31,'明日',1,'2000-03-02 00:00:00','18987869867',22,'湖南',2,1,'2022-10-19 18:18:54','2022-10-19 19:51:22'),(32,'康乾',1,'2000-03-31 00:00:00','17648489845',22,'湖南株洲104号',1,1,'2022-10-19 18:32:12','2022-10-19 19:39:10'),(33,'季度',1,'2000-07-06 00:00:00','19898765748',22,'湖南株洲987号',2,1,'2022-10-19 18:33:00','2022-10-19 19:51:22');
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member_consult`
--

DROP TABLE IF EXISTS `member_consult`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `member_consult` (
                                  `consult_id` bigint NOT NULL AUTO_INCREMENT COMMENT '咨询编号',
                                  `consult_name` varchar(50) NOT NULL COMMENT '姓名',
                                  `consult_age` int NOT NULL COMMENT '年龄',
                                  `consult_sex` tinyint NOT NULL COMMENT '性别(0-女,1-男)',
                                  `consult_phone` varchar(30) NOT NULL COMMENT '电话',
                                  `consult_content` varchar(255) NOT NULL COMMENT '咨询内容',
                                  `consult_time` datetime NOT NULL COMMENT '时间',
                                  PRIMARY KEY (`consult_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户咨询表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member_consult`
--

LOCK TABLES `member_consult` WRITE;
/*!40000 ALTER TABLE `member_consult` DISABLE KEYS */;
INSERT INTO `member_consult` VALUES (1,'晗昱 ',56,1,'18680713874','打算考虑','2022-10-18 16:30:59'),(2,'涵育',56,0,'18680713871','打算考虑','2022-10-18 16:32:23'),(3,'翰采',56,1,'18680713872','打算考虑','2022-10-18 16:33:07'),(7,'和璧',56,1,'18680713876','打算考虑','2022-10-18 17:12:47'),(8,'弘阔',55,1,'18680713875','打算考虑','2022-10-18 17:13:47'),(9,'弘益',88,1,'18680713877','打算考虑','2022-10-18 17:14:38'),(11,'宏博',58,1,'18680713878','打算考虑','2022-10-18 17:17:39'),(12,' 鸿晖',58,1,'18680713879','打算考虑','2022-10-18 17:18:40'),(13,'华藏',56,1,'18680713880','打算考虑','2022-10-18 17:19:02'),(14,' 嘉茂 ',45,1,'18680713881','打算考虑','2022-10-18 17:19:23'),(15,'坚成',45,1,'18680713882','打算考虑','2022-10-18 17:19:48');
/*!40000 ALTER TABLE `member_consult` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member_locker`
--

DROP TABLE IF EXISTS `member_locker`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `member_locker` (
                                 `member_id` bigint NOT NULL COMMENT '会员编号',
                                 `locker_id` bigint NOT NULL COMMENT '储物柜编号',
                                 `create_time` date NOT NULL COMMENT '创建时间',
                                 `end_time` date NOT NULL COMMENT '到期时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='会员储物柜关系表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member_locker`
--

LOCK TABLES `member_locker` WRITE;
/*!40000 ALTER TABLE `member_locker` DISABLE KEYS */;
INSERT INTO `member_locker` VALUES (23,1,'2022-10-18','2022-10-25'),(22,2,'2022-10-18','2022-10-25'),(4,3,'2022-10-18','2022-10-25'),(5,4,'2022-10-18','2022-10-25'),(6,5,'2022-10-18','2022-10-25'),(7,6,'2022-10-18','2022-10-25'),(8,7,'2022-10-18','2022-10-25'),(9,8,'2022-10-18','2022-10-25'),(10,9,'2022-10-18','2022-10-25'),(11,10,'2022-10-18','2022-10-25'),(12,11,'2022-10-18','2022-10-25'),(3,12,'2022-10-18','2022-10-25'),(3,13,'2022-10-18','2022-10-25');
/*!40000 ALTER TABLE `member_locker` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member_meal`
--

DROP TABLE IF EXISTS `member_meal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `member_meal` (
                               `mm_id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
                               `member_id` bigint NOT NULL COMMENT '会员编号',
                               `meal_id` bigint NOT NULL COMMENT '所选套餐编号',
                               `meal_type` varchar(20) NOT NULL COMMENT '所选套餐类型(私教,团操,普通)',
                               `mm_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '套餐办理时间',
                               `mm_date` datetime NOT NULL COMMENT '套餐到期时间',
                               PRIMARY KEY (`mm_id`)
) ENGINE=InnoDB AUTO_INCREMENT=229 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='会员办理套餐表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member_meal`
--

LOCK TABLES `member_meal` WRITE;
/*!40000 ALTER TABLE `member_meal` DISABLE KEYS */;
INSERT INTO `member_meal` VALUES (164,12,22,'普通','2022-10-18 15:25:54','2022-10-19 15:25:54'),(165,4,23,'普通','2022-10-18 15:26:30','2022-10-20 15:26:30'),(166,5,25,'普通','2022-10-18 15:26:57','2022-10-22 15:26:57'),(167,6,26,'普通','2022-10-18 15:27:22','2022-10-23 15:27:22'),(168,7,29,'普通','2022-10-18 15:27:43','2022-11-08 15:27:43'),(169,8,24,'普通','2022-10-18 15:28:10','2022-10-21 15:28:10'),(170,9,26,'普通','2022-10-18 15:28:28','2022-10-19 15:28:28'),(171,10,27,'普通','2022-10-18 15:28:42','2022-10-19 15:28:42'),(172,11,28,'普通','2022-10-18 15:29:05','2022-10-19 15:29:05'),(174,1,27,'普通','2022-10-18 15:33:17','2022-10-25 15:33:17'),(175,22,24,'普通','2022-10-18 15:36:53','2022-10-21 15:36:53'),(176,23,24,'普通','2022-10-18 15:39:04','2022-10-21 15:39:04'),(206,7,25,'普通','2022-10-19 18:35:04','2022-10-23 18:35:04'),(222,33,15,'私教','2022-10-19 19:30:22','2022-10-20 19:30:22'),(228,31,25,'团操','2022-10-19 19:47:44','2022-10-21 19:47:44');
/*!40000 ALTER TABLE `member_meal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `on_file`
--

DROP TABLE IF EXISTS `on_file`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `on_file` (
                           `id` bigint NOT NULL AUTO_INCREMENT,
                           `money` decimal(10,2) NOT NULL COMMENT '金额',
                           `type` varchar(255) NOT NULL COMMENT '类型',
                           `date` date NOT NULL COMMENT '档案日期',
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='归档信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `on_file`
--

LOCK TABLES `on_file` WRITE;
/*!40000 ALTER TABLE `on_file` DISABLE KEYS */;
INSERT INTO `on_file` VALUES (3,3280.00,'商品收入','2022-10-01'),(4,6880.00,'套餐收入','2022-10-01');
/*!40000 ALTER TABLE `on_file` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `po`
--

DROP TABLE IF EXISTS `po`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `po` (
                      `po_id` bigint NOT NULL AUTO_INCREMENT COMMENT '物品编号',
                      `schedule_id` bigint NOT NULL COMMENT '编号',
                      `po_name` varchar(50) NOT NULL COMMENT '物品名称',
                      `po_num` bigint NOT NULL COMMENT '物品数量',
                      `po_price` bigint NOT NULL COMMENT '单价',
                      `brand` varchar(50) NOT NULL COMMENT '品牌',
                      `schedule_address` varchar(500) NOT NULL COMMENT '供货地址',
                      `schedule_supplier` varchar(100) NOT NULL COMMENT '供货名称',
                      `po_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                      `po_type` varchar(50) NOT NULL COMMENT '物品类型',
                      `po_state` varchar(10) DEFAULT '未入库',
                      PRIMARY KEY (`po_id`)
) ENGINE=InnoDB AUTO_INCREMENT=117 DEFAULT CHARSET=utf8mb3 COMMENT='物品已购表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `po`
--

LOCK TABLES `po` WRITE;
/*!40000 ALTER TABLE `po` DISABLE KEYS */;
INSERT INTO `po` VALUES (102,70,'右旋',40,80,'Keep','株洲','超市','2022-10-18 19:42:44','补剂','已入库'),(103,68,'肌酸',50,80,'Keep','淘宝','超市','2022-10-18 19:42:48','补剂','已入库'),(104,69,'左旋',50,80,'Keep','株洲','超市','2022-10-18 19:42:52','补剂','已入库'),(105,67,'蛋白粉2号',20,80,'Keep','淘宝','超市','2022-10-18 19:42:54','补剂','已入库'),(106,66,'蛋白粉1号',20,80,'Keep','淘宝','超市','2022-10-18 19:42:57','补剂','已入库'),(107,65,'双杠',2,50,'Keep','株洲','超市','2022-10-18 19:42:58','器械','已入库'),(108,64,'杠铃5kg',10,50,'Keep','株洲','超市','2022-10-18 19:43:00','器械','已入库'),(109,63,'龙门架',2,2000,'Keep','淘宝','超市','2022-10-18 19:43:02','器械','已入库'),(110,62,'3kg哑铃',20,10,'Keep','淘宝','超市','2022-10-18 19:43:05','器械','已入库'),(111,74,'8kg哑铃',50,50,'Keep','株洲','超市','2022-10-18 19:51:05','器械','已入库'),(112,75,'臂力棒',50,2,'keep','株洲','超市','2022-10-18 19:51:07','器械','已入库'),(113,76,'仰卧起做器',30,50,'Keep','淘宝','超市','2022-10-18 19:51:09','器材','已入库'),(114,77,'2kg哑铃',50,10,'Keep','株洲','超市','2022-10-18 19:54:14','器械','已入库'),(115,79,'15kg哑铃',50,50,'Keep','株洲','超市','2022-10-18 20:40:34','器械','已入库'),(116,81,'跑步机',10,888,'keep','株洲','大润发','2022-10-19 15:36:32','器械','已入库');
/*!40000 ALTER TABLE `po` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proceeds`
--

DROP TABLE IF EXISTS `proceeds`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proceeds` (
                            `proceeds_id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
                            `meal_name` varchar(225) NOT NULL COMMENT '套餐名称',
                            `p_name` varchar(225) DEFAULT NULL COMMENT '项目名称',
                            `meal_type` varchar(225) NOT NULL COMMENT '套餐类型',
                            `proceeds_price` bigint NOT NULL COMMENT '金额',
                            `proceeds_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                            PRIMARY KEY (`proceeds_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1582700017449889795 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='套餐收入统计报表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proceeds`
--

LOCK TABLES `proceeds` WRITE;
/*!40000 ALTER TABLE `proceeds` DISABLE KEYS */;
INSERT INTO `proceeds` VALUES (1582271889360187393,'普通套餐2',NULL,'普通',150,'2022-10-18 15:26:30'),(1582272003378147329,'普通套餐4',NULL,'普通',250,'2022-10-18 15:26:57'),(1582272106092457985,'普通套餐5',NULL,'普通',500,'2022-10-18 15:27:22'),(1582272195988975617,'普通套餐8',NULL,'普通',1500,'2022-10-18 15:27:43'),(1582272306781515777,'普通套餐3',NULL,'普通',200,'2022-10-18 15:28:10'),(1582272597367091202,'普通套餐7',NULL,'普通',1200,'2022-10-18 15:29:19'),(1582273595972153345,'普通套餐6',NULL,'普通',600,'2022-10-18 15:33:17'),(1582274500540919810,'普通套餐3',NULL,'普通',200,'2022-10-18 15:36:53'),(1582275052691681282,'普通套餐3',NULL,'普通',200,'2022-10-18 15:39:04'),(1582276077381120002,'私教套餐1','私教项目1','私教',10,'2022-10-18 15:43:09'),(1582276224584413185,'私教套餐2','私教项目2','私教',20,'2022-10-18 15:43:44'),(1582276311104516098,'私教套餐1','私教项目3','私教',10,'2022-10-18 15:44:05'),(1582276771571986434,'私教套餐3','私教项目3','私教',30,'2022-10-18 15:45:54'),(1582276884809805825,'私教套餐3','私教项目3','私教',30,'2022-10-18 15:46:21'),(1582278444067483650,'私教套餐2','私教项目3','私教',20,'2022-10-18 15:52:33'),(1582278627627003905,'私教套餐2','私教项目3','私教',20,'2022-10-18 15:53:17'),(1582278768677253122,'私教套餐2','私教项目3','私教',20,'2022-10-18 15:53:50'),(1582278852001296385,'私教套餐2','私教项目2','私教',20,'2022-10-18 15:54:10'),(1582279327903805442,'私教套餐3','私教项目3','私教',30,'2022-10-18 15:56:04'),(1582280059998597122,'团操套餐1','团操项目1','私教',10,'2022-10-18 15:58:58'),(1582280113220120578,'团操套餐1','团操项目2','私教',10,'2022-10-18 15:59:11'),(1582280156740218882,'团操套餐1','团操项目2','私教',10,'2022-10-18 15:59:21'),(1582280232480960513,'团操套餐2','团操项目1','私教',20,'2022-10-18 15:59:39'),(1582280294980284418,'团操套餐2','团操项目2','私教',20,'2022-10-18 15:59:54'),(1582280341310566402,'团操套餐2','团操项目1','私教',20,'2022-10-18 16:00:05'),(1582280405038821377,'团操套餐2','团操项目3','私教',20,'2022-10-18 16:00:21'),(1582280734111330305,'团操套餐2','团操项目1','私教',20,'2022-10-18 16:01:39'),(1582567667744022529,'普通套餐14',NULL,'普通',1700,'2022-10-19 11:01:49'),(1582567951484493826,'团操套餐3','团操项目4','私教',30,'2022-10-19 11:02:57'),(1582568521586876418,'私教套餐1','私教项目1','私教',10,'2022-10-19 11:05:13'),(1582681731622416386,'普通套餐4',NULL,'普通',250,'2022-10-19 18:35:04'),(1582684086623477762,'普通套餐1',NULL,'普通',100,'2022-10-19 18:44:26'),(1582686194827468801,'私教套餐1','私教项目4','私教',10,'2022-10-19 18:52:48'),(1582686267732860930,'私教套餐2','私教项目1','私教',20,'2022-10-19 18:53:06'),(1582688200673665026,'私教套餐5','私教项目8','私教',50,'2022-10-19 19:00:47'),(1582688928528015362,'私教套餐4','私教项目6','私教',40,'2022-10-19 19:03:40'),(1582689864197545985,'团操套餐1','团操项目2','私教',10,'2022-10-19 19:07:23'),(1582690153738739713,'团操套餐3','团操项目1','私教',30,'2022-10-19 19:08:32'),(1582692555002937346,'私教套餐1','私教项目2','私教',10,'2022-10-19 19:18:05'),(1582694235907973122,'团操套餐4','团操项目1','私教',40,'2022-10-19 19:24:46'),(1582695645697462273,'私教套餐1','私教项目1','私教',10,'2022-10-19 19:30:22'),(1582696238428114946,'私教套餐4','私教项目4','私教',40,'2022-10-19 19:32:43'),(1582697751980470274,'私教套餐2','私教项目1','私教',20,'2022-10-19 19:38:44'),(1582697811396980738,'私教套餐2','私教项目1','私教',20,'2022-10-19 19:38:58'),(1582700017449889794,'团操套餐2','团操项目3','私教',20,'2022-10-19 19:47:44');
/*!40000 ALTER TABLE `proceeds` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prospect`
--

DROP TABLE IF EXISTS `prospect`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prospect` (
                            `prospect_id` bigint NOT NULL AUTO_INCREMENT,
                            `prospect_name` varchar(50) NOT NULL,
                            `prospect_phone` varchar(20) NOT NULL,
                            `prospect_address` varchar(255) NOT NULL,
                            `prospect_sex` varchar(4) NOT NULL,
                            `prospect_age` int NOT NULL,
                            `type` varchar(200) NOT NULL COMMENT '（普通意向客户，重点意向客户，无意向）',
                            `prospect_is` tinyint DEFAULT '0' COMMENT '是否分配(0-无分配\n            ,1-已分配)',
                            PRIMARY KEY (`prospect_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='潜在用户记录表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prospect`
--

LOCK TABLES `prospect` WRITE;
/*!40000 ALTER TABLE `prospect` DISABLE KEYS */;
INSERT INTO `prospect` VALUES (2,'晗昱 ','18680713874','未知','男',57,'无意向',1),(3,'涵育','18680713871','株洲','女',56,'普通意向',1),(4,'翰采','18680713872','未知','男',56,'普通意向',1),(6,'和璧','18680713876','未知','男',56,'普通意向',1),(7,'弘阔','18680713875','未知','男',55,'普通意向',1),(8,'弘益','18680713877','未知','男',88,'普通意向',1),(9,'宏博','18680713878','未知','男',58,'普通意向',1),(10,' 鸿晖','18680713879','未知','男',58,'普通意向',1),(11,'华藏','18680713880','未知','男',56,'普通意向',1),(12,' 嘉茂 ','18680713881','未知','男',45,'普通意向',1),(13,'坚成','18680713882','未知','男',45,'普通意向',1);
/*!40000 ALTER TABLE `prospect` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pt_choose`
--

DROP TABLE IF EXISTS `pt_choose`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pt_choose` (
                             `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
                             `pt_id` bigint NOT NULL COMMENT '私教套餐编号',
                             `ptp_id` bigint NOT NULL COMMENT '项目编号项目编号',
                             PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=341 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='私教套餐项目关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pt_choose`
--

LOCK TABLES `pt_choose` WRITE;
/*!40000 ALTER TABLE `pt_choose` DISABLE KEYS */;
INSERT INTO `pt_choose` VALUES (84,28,14),(85,27,13),(86,26,18),(87,26,17),(88,26,16),(89,26,15),(90,26,14),(91,25,13),(92,25,14),(93,25,15),(94,25,16),(95,25,17),(96,25,18),(97,25,19),(98,25,20),(99,25,21),(100,25,22),(101,23,13),(102,23,14),(103,23,15),(104,23,16),(105,23,17),(106,23,18),(107,23,19),(108,23,20),(109,23,21),(110,23,22),(111,20,13),(112,20,14),(113,20,15),(114,20,16),(115,20,17),(116,20,18),(117,20,19),(118,20,20),(119,20,21),(120,20,22),(131,15,13),(132,15,14),(133,15,15),(134,15,16),(135,15,17),(136,15,18),(137,15,19),(138,15,20),(139,15,21),(140,15,22),(141,16,13),(142,16,14),(143,16,15),(144,16,16),(145,16,17),(146,16,18),(147,16,19),(148,16,20),(149,16,21),(150,16,22),(151,17,13),(152,17,14),(153,17,15),(154,17,16),(155,17,17),(156,17,18),(157,17,19),(158,17,20),(159,17,21),(160,17,22),(161,18,13),(162,18,14),(163,18,15),(164,18,16),(165,18,17),(166,18,18),(167,18,19),(168,18,20),(169,18,21),(170,18,22),(171,19,13),(172,19,14),(173,19,15),(174,19,16),(175,19,17),(176,19,18),(177,19,19),(178,19,20),(179,19,21),(180,19,22),(334,29,13),(335,29,14),(336,29,15),(337,29,16),(338,29,17),(339,29,18),(340,29,19);
/*!40000 ALTER TABLE `pt_choose` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pt_coach`
--

DROP TABLE IF EXISTS `pt_coach`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pt_coach` (
                            `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
                            `pt_id` bigint NOT NULL,
                            `emp_id` bigint NOT NULL,
                            PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=106 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='私教套餐的教练关系表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pt_coach`
--

LOCK TABLES `pt_coach` WRITE;
/*!40000 ALTER TABLE `pt_coach` DISABLE KEYS */;
INSERT INTO `pt_coach` VALUES (24,2,17),(25,3,17),(26,7,17),(27,2,15),(28,3,15),(29,7,15),(33,2,16),(34,3,16),(35,7,16),(46,15,11),(47,16,11),(48,17,11),(49,18,11),(50,19,11),(51,20,11),(52,21,11),(53,22,11),(54,23,11),(55,24,11),(56,25,11),(57,26,11),(58,27,11),(59,28,11),(60,29,11),(61,15,49),(62,16,49),(63,17,49),(64,18,49),(65,19,49),(66,20,49),(67,21,49),(68,22,49),(69,23,49),(70,24,49),(71,25,49),(72,26,49),(73,27,49),(74,28,49),(75,29,49),(76,15,14),(77,16,14),(78,17,14),(79,18,14),(80,19,14),(81,20,14),(82,21,14),(83,22,14),(84,23,14),(85,24,14),(86,25,14),(87,26,14),(88,27,14),(89,28,14),(90,29,14),(91,15,19),(92,16,19),(93,17,19),(94,18,19),(95,19,19),(96,20,19),(97,21,19),(98,22,19),(99,23,19),(100,24,19),(101,25,19),(102,26,19),(103,27,19),(104,28,19),(105,29,19);
/*!40000 ALTER TABLE `pt_coach` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pt_meal`
--

DROP TABLE IF EXISTS `pt_meal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pt_meal` (
                           `pt_id` bigint NOT NULL AUTO_INCREMENT COMMENT '私教套餐编号',
                           `pt_time` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                           `pt_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '套餐生效时间',
                           `pt_price` bigint NOT NULL COMMENT '套餐价格',
                           `pt_is` tinyint DEFAULT '1' COMMENT '是否禁用(1-禁用,0-使用)',
                           `pt_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '套餐名',
                           PRIMARY KEY (`pt_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='私教会员套餐表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pt_meal`
--

LOCK TABLES `pt_meal` WRITE;
/*!40000 ALTER TABLE `pt_meal` DISABLE KEYS */;
INSERT INTO `pt_meal` VALUES (15,'一天','2022-10-18 15:06:23',10,0,'私教套餐1'),(16,'两天','2022-10-18 15:06:31',20,0,'私教套餐2'),(17,'三天','2022-10-18 15:06:45',30,0,'私教套餐3'),(18,'四天','2022-10-18 15:06:55',40,0,'私教套餐4'),(19,'五天','2022-10-18 15:07:03',50,0,'私教套餐5'),(20,'六天','2022-10-18 15:07:15',60,0,'私教套餐6'),(21,'一周','2022-10-18 15:07:31',120,0,'私教套餐7'),(22,'两周','2022-10-18 15:07:42',160,0,'私教套餐8'),(23,'三周','2022-10-18 15:08:07',170,0,'私教套餐9'),(24,'一个月','2022-10-18 15:08:17',180,0,'私教套餐10'),(25,'两个月','2022-10-18 15:08:37',188,0,'私教套餐11'),(26,'三个月','2022-10-18 15:08:49',320,0,'私教套餐12'),(27,'四个月','2022-10-18 15:09:12',360,0,'私教套餐13'),(28,'五个月','2022-10-18 15:09:25',400,0,'私教套餐14'),(29,'八个月','2022-10-18 15:09:38',600,0,'私教套餐15');
/*!40000 ALTER TABLE `pt_meal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pt_projectname`
--

DROP TABLE IF EXISTS `pt_projectname`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pt_projectname` (
                                  `ptp_id` bigint NOT NULL AUTO_INCREMENT COMMENT '项目编号',
                                  `ptp_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '项目名称(减脂或塑形.)',
                                  `ptp_is` tinyint DEFAULT '1' COMMENT '是否禁用(1-禁用,0-使用)',
                                  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
                                  PRIMARY KEY (`ptp_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='私教项目类型表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pt_projectname`
--

LOCK TABLES `pt_projectname` WRITE;
/*!40000 ALTER TABLE `pt_projectname` DISABLE KEYS */;
INSERT INTO `pt_projectname` VALUES (13,'私教项目1',0,'2022-10-18 00:00:00','2022-10-18 14:56:13'),(14,'私教项目2',0,'2022-10-18 14:54:43','2022-10-18 14:54:43'),(15,'私教项目3',0,'2022-10-18 14:54:50','2022-10-18 14:54:50'),(16,'私教项目4',0,'2022-10-18 14:54:55','2022-10-18 14:54:55'),(17,'私教项目5',0,'2022-10-18 14:54:59','2022-10-18 14:54:59'),(18,'私教项目6',0,'2022-10-18 14:55:04','2022-10-18 14:55:04'),(19,'私教项目7',0,'2022-10-18 14:55:08','2022-10-18 14:55:08'),(20,'私教项目8',0,'2022-10-18 14:55:13','2022-10-18 14:55:13'),(21,'私教项目9',0,'2022-10-18 14:55:20','2022-10-18 14:55:20'),(22,'私教项目10',0,'2022-10-18 14:55:26','2022-10-18 14:55:26'),(23,'私教项目11',0,'2022-10-18 14:55:30','2022-10-18 14:55:30'),(24,'私教项目12',0,'2022-10-18 14:55:39','2022-10-18 14:55:39'),(25,'私教项目13',0,'2022-10-18 14:55:44','2022-10-18 14:55:44'),(26,'私教项目14',0,'2022-10-18 14:55:52','2022-10-18 14:55:52'),(27,'私教项目15',0,'2022-10-18 14:55:58','2022-10-18 14:55:58');
/*!40000 ALTER TABLE `pt_projectname` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sales`
--

DROP TABLE IF EXISTS `sales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sales` (
                         `sales_id` bigint NOT NULL AUTO_INCREMENT COMMENT '课程销售记录编号',
                         `salesman_id` bigint NOT NULL COMMENT '销售人员编号',
                         `meal_id` bigint DEFAULT NULL COMMENT '套餐编号',
                         `meal_name` varchar(255) DEFAULT NULL COMMENT '套餐名称',
                         `member_name` varchar(255) NOT NULL COMMENT '会员姓名',
                         `member_phone` varchar(50) NOT NULL COMMENT '会员电话',
                         `project_id` bigint DEFAULT NULL COMMENT '项目编号',
                         `project_name` varchar(225) DEFAULT NULL COMMENT '项目名称',
                         `type` varchar(50) DEFAULT NULL COMMENT '类型',
                         `sales_price` bigint NOT NULL COMMENT '金额',
                         `state` tinyint DEFAULT '0' COMMENT '是否购买从成功(0-未购买,1-已购买)',
                         `sales_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                         `meal_time` varchar(500) DEFAULT NULL COMMENT '时长',
                         PRIMARY KEY (`sales_id`)
) ENGINE=InnoDB AUTO_INCREMENT=273 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='课程销售记录表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sales`
--

LOCK TABLES `sales` WRITE;
/*!40000 ALTER TABLE `sales` DISABLE KEYS */;
INSERT INTO `sales` VALUES (261,1,29,'私教套餐15','小刘','18680713887',13,'私教项目1','私教',600,0,'2022-10-19 10:28:21','八个月'),(262,1,15,'私教套餐1','小刘1','18680713891',13,'私教项目1','私教',10,1,'2022-10-19 10:29:21','一天'),(264,1,17,'私教套餐3','小刘3','18680713892',15,'私教项目3','私教',30,0,'2022-10-19 10:30:07','三天'),(265,1,24,'团操套餐1','小刘4','18680713893',13,'团操项目1','团操',10,0,'2022-10-19 10:30:30','一天'),(266,1,25,'团操套餐2','小刘5','18680713894',14,'团操项目2','团操',20,0,'2022-10-19 10:30:53','两天'),(267,1,26,'团操套餐3','小刘6','18680713897',16,'团操项目4','团操',30,1,'2022-10-19 10:31:01','三天'),(270,1,36,'普通套餐15','小刘7','18680713898',NULL,NULL,'普通',1800,0,'2022-10-19 10:32:20','十一个月'),(271,1,35,'普通套餐14','小9','18680713899',NULL,NULL,'普通',1700,0,'2022-10-19 10:32:36','十个月'),(272,1,35,'普通套餐14','小刘11','18680713861',NULL,NULL,'普通',1700,2,'2022-10-19 10:33:01','十个月');
/*!40000 ALTER TABLE `sales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sales_article`
--

DROP TABLE IF EXISTS `sales_article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sales_article` (
                                 `sa_id` bigint NOT NULL AUTO_INCREMENT COMMENT '商品销售记录编号',
                                 `saemp_id` bigint NOT NULL COMMENT '销售人员编号',
                                 `stockout_id` bigint NOT NULL COMMENT '物品出库编号',
                                 `stockIn_name` varchar(100) NOT NULL COMMENT '物品名称',
                                 `stockIn_num` bigint NOT NULL COMMENT '被购物品数量',
                                 `sales_price` bigint NOT NULL COMMENT '金额',
                                 `sales_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                 `brand` varchar(50) DEFAULT NULL COMMENT '品牌',
                                 `state` bit(1) NOT NULL DEFAULT b'0',
                                 PRIMARY KEY (`sa_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='商品销售记录表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sales_article`
--

LOCK TABLES `sales_article` WRITE;
/*!40000 ALTER TABLE `sales_article` DISABLE KEYS */;
INSERT INTO `sales_article` VALUES (4,1,41,'3kg哑铃',1,10,'2022-10-19 10:43:45','Keep',_binary '\0'),(5,1,41,'3kg哑铃',1,10,'2022-10-19 10:43:58','Keep',_binary '\0'),(6,1,40,'龙门架',1,2000,'2022-10-19 10:44:36','Keep',_binary '\0'),(7,1,37,'蛋白粉1号',2,100,'2022-10-19 10:44:52','Keep',_binary '\0'),(8,1,32,'2kg哑铃',2,100,'2022-10-19 10:45:42','Keep',_binary '\0'),(9,1,34,'肌酸',2,160,'2022-10-19 10:46:01','Keep',_binary '\0'),(10,1,33,'右旋',2,200,'2022-10-19 10:46:21','Keep',_binary '\0'),(11,1,34,'肌酸',2,200,'2022-10-19 10:46:44','Keep',_binary '\0'),(12,1,33,'右旋',2,200,'2022-10-19 10:47:02','Keep',_binary '\0'),(13,1,36,'蛋白粉2号',2,200,'2022-10-19 10:47:21','Keep',_binary '\0'),(14,1,33,'右旋',1,100,'2022-10-19 10:47:45','Keep',_binary '\0');
/*!40000 ALTER TABLE `sales_article` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schedule`
--

DROP TABLE IF EXISTS `schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `schedule` (
                            `schedule_id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
                            `scheduleemp_id` bigint NOT NULL COMMENT '采购人员编号',
                            `schedule_name` varchar(100) NOT NULL COMMENT '物品名称',
                            `schedule_type` varchar(50) NOT NULL COMMENT '物品类型(器材,补剂,日常用品)',
                            `schedule_supplier` varchar(100) NOT NULL COMMENT '供货名称',
                            `unit` varchar(10) NOT NULL COMMENT '单位',
                            `schedule_address` varchar(500) NOT NULL COMMENT '供货地址',
                            `schedule_num` bigint NOT NULL COMMENT '数量',
                            `schedule_price` bigint NOT NULL COMMENT '单价',
                            `brand` varchar(50) NOT NULL COMMENT '品牌',
                            `schedule_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                            `schedule_state` tinyint NOT NULL DEFAULT '0' COMMENT '(0-未审核,-- 1-待审核 2-审核通过,3-审核不通过,4-已执行 , 5-已撤销)',
                            PRIMARY KEY (`schedule_id`)
) ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=utf8mb3 COMMENT='物品采购计划表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedule`
--

LOCK TABLES `schedule` WRITE;
/*!40000 ALTER TABLE `schedule` DISABLE KEYS */;
INSERT INTO `schedule` VALUES (62,1,'3kg哑铃','器械','超市','台','淘宝',20,10,'Keep','2022-10-18 19:07:42',4),(63,1,'龙门架','器械','超市','台','淘宝',2,2000,'Keep','2022-10-18 19:08:36',4),(64,1,'杠铃5kg','器械','超市','件','株洲',10,50,'Keep','2022-10-18 19:09:51',4),(65,1,'双杠','器械','超市','台','株洲',2,50,'Keep','2022-10-18 19:11:29',4),(66,1,'蛋白粉1号','补剂','超市','桶','淘宝',20,80,'Keep','2022-10-18 19:13:11',4),(67,1,'蛋白粉2号','补剂','超市','桶','淘宝',20,80,'Keep','2022-10-18 19:18:26',4),(68,1,'肌酸','补剂','超市','件','淘宝',50,80,'Keep','2022-10-18 19:19:40',4),(69,1,'左旋','补剂','超市','件','株洲',50,80,'Keep','2022-10-18 19:22:42',4),(70,1,'右旋','补剂','超市','件','株洲',40,80,'Keep','2022-10-18 19:23:47',4),(71,1,'双人坐推训练器','器械','超市','台','株洲',2,500,'Keep','2022-10-18 19:25:01',3),(73,1,'2kg哑铃','器械','超市','件','株洲',10,20,'Keep','2022-10-18 19:27:33',4),(74,1,'8kg哑铃','器械','超市','件','株洲',50,50,'Keep','2022-10-18 19:48:32',4),(75,1,'臂力棒','器械','超市','件','株洲',50,2,'keep','2022-10-18 19:49:22',4),(76,1,'仰卧起做器','器材','超市','台','淘宝',30,50,'Keep','2022-10-18 19:50:19',4),(77,1,'2kg哑铃','器械','超市','件','株洲',50,10,'Keep','2022-10-18 19:52:40',4),(78,1,'10kg哑铃','器械','超市','件','株洲',52,30,'Keep','2022-10-18 00:00:00',1),(79,1,'15kg哑铃','器械','超市','件','株洲',50,50,'Keep','2022-10-18 20:35:16',4),(80,1,'12kg哑铃','器材','超市','件','株洲',50,50,'Keep','2022-10-18 20:51:38',2),(81,5,'跑步机','器械','大润发','台','株洲',10,888,'keep','2022-10-19 15:33:45',4);
/*!40000 ALTER TABLE `schedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stock_in`
--

DROP TABLE IF EXISTS `stock_in`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stock_in` (
                            `in_id` bigint NOT NULL AUTO_INCREMENT COMMENT '入库编号',
                            `po_id` bigint DEFAULT NULL COMMENT '物品编号',
                            `in_name` varchar(50) NOT NULL COMMENT '物品名称',
                            `in_num` bigint NOT NULL COMMENT '物品数量',
                            `in_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '入库时间',
                            `in_type` varchar(50) NOT NULL COMMENT '物品类型',
                            `brand` varchar(50) NOT NULL COMMENT '品牌',
                            `in_is` tinyint NOT NULL DEFAULT '1' COMMENT '是否入库(0-否,1-是)',
                            PRIMARY KEY (`in_id`)
) ENGINE=InnoDB AUTO_INCREMENT=88 DEFAULT CHARSET=utf8mb3 COMMENT='物品入库表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stock_in`
--

LOCK TABLES `stock_in` WRITE;
/*!40000 ALTER TABLE `stock_in` DISABLE KEYS */;
INSERT INTO `stock_in` VALUES (73,110,'3kg哑铃',20,'2022-10-18 19:44:11','器械','Keep',1),(74,109,'龙门架',2,'2022-10-18 19:44:17','器械','Keep',1),(75,108,'杠铃5kg',10,'2022-10-18 19:44:19','器械','Keep',1),(76,107,'双杠',2,'2022-10-18 19:44:23','器械','Keep',1),(77,106,'蛋白粉1号',20,'2022-10-18 19:44:28','补剂','Keep',1),(78,105,'蛋白粉2号',20,'2022-10-18 19:44:31','补剂','Keep',1),(79,104,'左旋',50,'2022-10-18 19:44:35','补剂','Keep',1),(80,103,'肌酸',50,'2022-10-18 19:44:39','补剂','Keep',1),(81,102,'右旋',40,'2022-10-18 19:44:42','补剂','Keep',1),(82,113,'仰卧起做器',30,'2022-10-18 19:51:19','器材','Keep',1),(83,112,'臂力棒',50,'2022-10-18 19:51:23','器械','keep',1),(84,111,'8kg哑铃',50,'2022-10-18 19:51:26','器械','Keep',1),(85,114,'2kg哑铃',50,'2022-10-18 19:54:24','器械','Keep',1),(86,115,'15kg哑铃',50,'2022-10-18 20:40:51','器械','Keep',1),(87,116,'跑步机',10,'2022-10-19 15:36:52','器械','keep',1);
/*!40000 ALTER TABLE `stock_in` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stock_out`
--

DROP TABLE IF EXISTS `stock_out`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stock_out` (
                             `out_id` bigint NOT NULL AUTO_INCREMENT COMMENT '物品出库编号',
                             `store_id` bigint NOT NULL COMMENT '库存编号',
                             `stockin_id` bigint NOT NULL COMMENT '物品编号',
                             `stockin_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                             `store_num` bigint NOT NULL COMMENT '物品数量',
                             `out_num` bigint NOT NULL COMMENT '物品出库数量',
                             `out_is` tinyint NOT NULL DEFAULT '1' COMMENT '是否出库(0-否,1-是)',
                             `stockin_type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '物品类型',
                             `stockout_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '出库时间',
                             `brand` varchar(50) DEFAULT NULL COMMENT '品牌',
                             PRIMARY KEY (`out_id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb3 COMMENT='物品出库表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stock_out`
--

LOCK TABLES `stock_out` WRITE;
/*!40000 ALTER TABLE `stock_out` DISABLE KEYS */;
INSERT INTO `stock_out` VALUES (32,50,101,'2kg哑铃',16,18,1,'器械','2022-10-18 19:39:05','Keep'),(33,59,102,'右旋',0,5,1,'补剂','2022-10-18 19:45:54','Keep'),(34,58,103,'肌酸',1,5,1,'补剂','2022-10-18 19:45:58','Keep'),(35,57,104,'左旋',5,5,1,'补剂','2022-10-18 19:46:08','Keep'),(36,56,105,'蛋白粉2号',3,5,1,'补剂','2022-10-18 19:46:13','Keep'),(37,55,106,'蛋白粉1号',3,5,1,'补剂','2022-10-18 19:46:22','Keep'),(38,54,107,'双杠',2,2,1,'器械','2022-10-18 19:46:39','Keep'),(39,53,108,'杠铃5kg',5,5,1,'器械','2022-10-18 19:46:47','Keep'),(40,52,109,'龙门架',0,1,1,'器械','2022-10-18 19:47:00','Keep'),(41,51,110,'3kg哑铃',8,10,1,'器械','2022-10-18 19:47:08','Keep'),(42,64,116,'跑步机',5,5,1,'器械','2022-10-19 15:37:38','keep');
/*!40000 ALTER TABLE `stock_out` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stock_out_record`
--

DROP TABLE IF EXISTS `stock_out_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stock_out_record` (
                                    `out_id` bigint NOT NULL AUTO_INCREMENT COMMENT '物品出库编号',
                                    `store_id` bigint NOT NULL COMMENT '库存编号',
                                    `stockin_id` bigint NOT NULL COMMENT '物品编号',
                                    `stockin_name` varchar(255) NOT NULL,
                                    `out_num` bigint NOT NULL COMMENT '物品出库数量',
                                    `out_is` tinyint NOT NULL DEFAULT '1' COMMENT '是否出库(0-否,1-是)',
                                    `stockin_type` varchar(50) NOT NULL COMMENT '物品类型',
                                    `stockout_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '出库时间',
                                    `brand` varchar(50) DEFAULT NULL COMMENT '品牌',
                                    `emp_name` varchar(255) NOT NULL COMMENT '领取人（员工名）',
                                    PRIMARY KEY (`out_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='物品出库记录表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stock_out_record`
--

LOCK TABLES `stock_out_record` WRITE;
/*!40000 ALTER TABLE `stock_out_record` DISABLE KEYS */;
INSERT INTO `stock_out_record` VALUES (3,50,101,'2kg哑铃',8,1,'器械','2022-10-18 19:39:06','Keep','赵'),(4,59,102,'右旋',5,1,'补剂','2022-10-18 19:45:54','Keep','赵'),(5,58,103,'肌酸',5,1,'补剂','2022-10-18 19:45:58','Keep','赵'),(6,57,104,'左旋',5,1,'补剂','2022-10-18 19:46:08','Keep','赵'),(7,56,105,'蛋白粉2号',5,1,'补剂','2022-10-18 19:46:13','Keep','赵'),(8,55,106,'蛋白粉1号',5,1,'补剂','2022-10-18 19:46:22','Keep','赵'),(9,54,107,'双杠',2,1,'器械','2022-10-18 19:46:39','Keep','赵'),(10,53,108,'杠铃5kg',5,1,'器械','2022-10-18 19:46:47','Keep','赵'),(11,52,109,'龙门架',1,1,'器械','2022-10-18 19:47:00','Keep','赵'),(12,51,110,'3kg哑铃',10,1,'器械','2022-10-18 19:47:08','Keep','赵'),(13,50,101,'2kg哑铃',10,1,'器械','2022-10-18 19:54:48','Keep','赵'),(14,64,116,'跑步机',5,1,'器械','2022-10-19 15:37:38','keep','欧阳');
/*!40000 ALTER TABLE `stock_out_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `store`
--

DROP TABLE IF EXISTS `store`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `store` (
                         `store_id` bigint NOT NULL AUTO_INCREMENT COMMENT '库存编号',
                         `po_id` bigint NOT NULL COMMENT '物品编号',
                         `stockIn_name` varchar(50) NOT NULL COMMENT '物品名称',
                         `stockin_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后操作时间',
                         `stockIn_num` bigint NOT NULL COMMENT '最近入库物品数量',
                         `store_num` bigint NOT NULL COMMENT '库存数量',
                         `stockIn_type` varchar(50) NOT NULL COMMENT '物品类型',
                         `brand` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '品牌',
                         PRIMARY KEY (`store_id`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8mb3 COMMENT='物品库存表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `store`
--

LOCK TABLES `store` WRITE;
/*!40000 ALTER TABLE `store` DISABLE KEYS */;
INSERT INTO `store` VALUES (50,101,'2kg哑铃','2022-10-18 19:54:48',50,40,'器械','Keep'),(51,110,'3kg哑铃','2022-10-18 19:47:08',20,10,'器械','Keep'),(52,109,'龙门架','2022-10-18 19:47:00',2,1,'器械','Keep'),(53,108,'杠铃5kg','2022-10-18 19:46:47',10,5,'器械','Keep'),(54,107,'双杠','2022-10-18 19:46:39',2,0,'器械','Keep'),(55,106,'蛋白粉1号','2022-10-18 19:46:22',20,15,'补剂','Keep'),(56,105,'蛋白粉2号','2022-10-18 19:46:13',20,15,'补剂','Keep'),(57,104,'左旋','2022-10-18 19:46:08',50,45,'补剂','Keep'),(58,103,'肌酸','2022-10-18 19:45:58',50,45,'补剂','Keep'),(59,102,'右旋','2022-10-18 19:45:54',40,35,'补剂','Keep'),(60,113,'仰卧起做器','2022-10-18 19:51:19',30,30,'器材','Keep'),(61,112,'臂力棒','2022-10-18 19:51:23',50,50,'器械','keep'),(62,111,'8kg哑铃','2022-10-18 19:51:26',50,50,'器械','Keep'),(63,115,'15kg哑铃','2022-10-18 20:40:51',50,50,'器械','Keep'),(64,116,'跑步机','2022-10-19 15:37:38',10,5,'器械','keep');
/*!40000 ALTER TABLE `store` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_department`
--

DROP TABLE IF EXISTS `sys_department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_department` (
                                  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '部门编号',
                                  `department_name` varchar(50) NOT NULL COMMENT '部门名称',
                                  `phone` varchar(50) NOT NULL COMMENT '部门电话',
                                  `pid` bigint NOT NULL COMMENT '所属部门编号',
                                  `parent_name` varchar(50) NOT NULL COMMENT '所属部门名称',
                                  `order_num` int DEFAULT NULL COMMENT '排序',
                                  `is_delete` tinyint DEFAULT '0' COMMENT '是否删除(0-未删除，1-已删除)',
                                  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='部门表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_department`
--

LOCK TABLES `sys_department` WRITE;
/*!40000 ALTER TABLE `sys_department` DISABLE KEYS */;
INSERT INTO `sys_department` VALUES (1,'牛牛健身有限公司','020-8888888',0,'顶级部门',0,0),(2,'行政部','020-88881001',1,'牛牛健身有限公司',1,0),(3,'人事部','020-88881002',1,'牛牛健身有限公司',1,0),(4,'市场部','020-88881003',1,'牛牛健身有限公司',1,0),(5,'后勤部','020-88881234',1,'牛牛健身有限公司',1,0),(6,'财务部','020-12345678',1,'牛牛健身有限公司',1,0),(7,'教练部','020-88881234',1,'牛牛健身有限公司',1,0);
/*!40000 ALTER TABLE `sys_department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_emp`
--

DROP TABLE IF EXISTS `sys_emp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_emp` (
                           `emp_id` bigint NOT NULL AUTO_INCREMENT COMMENT '员工编号',
                           `emp_name` varchar(50) NOT NULL COMMENT '姓名',
                           `emp_age` int NOT NULL COMMENT '年龄',
                           `emp_sex` varchar(4) NOT NULL COMMENT '性别',
                           `emp_address` varchar(255) NOT NULL COMMENT '住址',
                           `emp_phone` varchar(20) NOT NULL COMMENT '电话',
                           `avatar` varchar(255) DEFAULT NULL COMMENT '用户头像',
                           `emil` varchar(50) DEFAULT NULL COMMENT '邮箱',
                           `qq` varchar(50) DEFAULT NULL COMMENT 'qq',
                           `weix` varchar(50) DEFAULT NULL COMMENT '微信',
                           `department_id` bigint DEFAULT NULL COMMENT '所属部门ID',
                           `department_name` varchar(50) DEFAULT NULL COMMENT '所属部门名称',
                           `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                           `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
                           `station` varchar(100) DEFAULT NULL COMMENT '岗位',
                           `synopsis` varchar(500) DEFAULT NULL COMMENT '简介',
                           PRIMARY KEY (`emp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_emp`
--

LOCK TABLES `sys_emp` WRITE;
/*!40000 ALTER TABLE `sys_emp` DISABLE KEYS */;
INSERT INTO `sys_emp` VALUES (1,'小明',50,'男','株洲荷塘区','17680713872','https://liucz-bucket.oss-cn-hangzhou.aliyuncs.com/avatar/2022/10/14/d62bf8b220f44b0eb020d407884e20ec.jpg','2042975339@qq.com','2042975339','12345ss',1,'牛牛健身有限公司',NULL,'2022-10-14 11:23:42','总经理','公司总负责人'),(2,'李明',30,'男','株洲荷塘区','17680713872','','2042975339@qq.com','2042975339','12345ss',2,'行政部',NULL,NULL,'行政部经理','行政部总负责人'),(3,'张三',25,'男','株洲荷塘区','17680713872','','2042975339@qq.com','2042975339','12345ss',3,'人事部',NULL,NULL,'人事部经理','人事部总负责人'),(4,'李四',24,'女','株洲荷塘区','17680713872','','2042975339@qq.com','2042975339','12345ss',4,'市场部',NULL,NULL,'市场部经理','市场部总负责人'),(5,'王五',26,'男','株洲荷塘区','17680713872','','2042975339@qq.com','2042975339','12345ss',5,'后勤部',NULL,NULL,'后勤部经理','后勤部总负责人'),(6,'赵六',34,'男','株洲荷塘区','17680713872','','2042975339@qq.com','2042975339','12345ss',6,'财务部',NULL,NULL,'财务部经理','财务部总负责人'),(7,'提米',34,'男','株洲荷塘区','17680713872','','2042975339@qq.com','2042975339','12345ss',7,'教练部',NULL,NULL,'教练部经理','教练部总负责人'),(9,'李',30,'男','株洲荷塘区','17680713872','','2042975339@qq.com','2042975339','12345ss',2,'行政部',NULL,NULL,'行政部副经理','行政部负责人'),(11,'李练练',24,'女','株洲荷塘区','17680713872','','2042975339@qq.com','2042975339','12345ss',7,'教练部',NULL,'2022-10-12 20:49:37','教练','市场部负责人'),(12,'王',26,'男','株洲荷塘区','17680713872','','2042975339@qq.com','2042975339','12345ss',5,'后勤部',NULL,NULL,'后勤部副经理','后勤部负责人'),(13,'赵',34,'男','株洲荷塘区','17680713872','','2042975339@qq.com','2042975339','12345ss',6,'财务部',NULL,NULL,'财务部副经理','财务部负责人'),(14,'小',50,'男','株洲荷塘区','17680713872','','2042975339@qq.com','2042975339','12345ss',7,'教练部',NULL,NULL,'教练','教练300年'),(16,'张',25,'男','株洲荷塘区','17680713872','','2042975339@qq.com','2042975339','12345ss',7,'教练部',NULL,NULL,'教练','教练300年'),(18,'王',26,'男','株洲荷塘区','17680713872','','2042975339@qq.com','2042975339','12345ss',7,'教练部',NULL,NULL,'教练','教练300年'),(19,'赵',34,'男','株洲荷塘区','17680713872','','2042975339@qq.com','2042975339','12345ss',7,'教练部',NULL,NULL,'教练','教练300年'),(20,'小1',34,'男','株洲荷塘区','17680713872','','2042975339@qq.com','2042975339','12345ss',7,'教练部',NULL,NULL,'教练部经理','教练部负责人'),(21,'小2',50,'男','株洲荷塘区','17680713872','','2042975339@qq.com','2042975339','12345ss',7,'教练部',NULL,NULL,'教练','教练300年'),(22,'小3',30,'男','株洲荷塘区','17680713872','','2042975339@qq.com','2042975339','12345ss',7,'教练部',NULL,NULL,'教练','教练300年'),(23,'小4',25,'男','株洲荷塘区','17680713872','','2042975339@qq.com','2042975339','12345ss',7,'教练部',NULL,NULL,'教练','教练300年'),(24,'小5',24,'女','株洲荷塘区','17680713872','','2042975339@qq.com','2042975339','12345ss',7,'教练部',NULL,NULL,'教练','教练300年'),(25,'小6',26,'男','株洲荷塘区','17680713872','','2042975339@qq.com','2042975339','12345ss',7,'教练部',NULL,NULL,'教练','教练300年'),(26,'小7',34,'男','株洲荷塘区','17680713872','','2042975339@qq.com','2042975339','12345ss',7,'教练部',NULL,NULL,'教练','教练300年'),(27,'小8',50,'男','株洲荷塘区','17680713872','','2042975339@qq.com','2042975339','12345ss',3,'人事部',NULL,'2022-10-18 17:22:35','客服','客服300年'),(28,'小9',30,'男','株洲荷塘区','17680713872','','2042975339@qq.com','2042975339','12345ss',4,'市场部',NULL,'2022-10-12 20:41:39','客服','客服300年'),(30,'小画',24,'女','株洲荷塘区','17680713872','','2042975339@qq.com','2042975339','12345ss',4,'市场部',NULL,'2022-10-12 20:42:05','客服','客服300年'),(31,'小是',26,'男','株洲荷塘区','17680713872','','2042975339@qq.com','2042975339','12345ss',4,'市场部',NULL,'2022-10-12 20:42:10','客服','客服300年'),(32,'小成',34,'男','株洲荷塘区','17680713872','','2042975339@qq.com','2042975339','12345ss',4,'市场部',NULL,'2022-10-12 20:42:17','客服','客服300年'),(33,'阿飞',25,'男','株洲荷塘区','17680713872','','2042975339@qq.com','2042975339','12345ss',5,'后勤部',NULL,'2022-10-12 20:42:25','后勤1','后勤1300年'),(34,'阿看',24,'女','株洲荷塘区','17680713872','','2042975339@qq.com','2042975339','12345ss',5,'后勤部',NULL,'2022-10-12 20:42:32','后勤2','后勤1300年'),(35,'艾克',26,'男','株洲荷塘区','17680713872','','2042975339@qq.com','2042975339','12345ss',5,'后勤部',NULL,'2022-10-12 20:42:39','后勤3','后勤1300年'),(36,'老刘',34,'男','株洲荷塘区','17680713872','','2042975339@qq.com','2042975339','12345ss',5,'后勤部',NULL,'2022-10-12 20:42:44','后勤4','后勤1300年'),(37,'小猪1号',25,'男','株洲荷塘区','17680713872','','2042975339@qq.com','2042975339','12345ss',6,'财务部',NULL,'2022-10-12 20:42:50','财务1','财务1300年'),(38,'小猪2号',24,'女','株洲荷塘区','17680713872','','2042975339@qq.com','2042975339','12345ss',6,'财务部',NULL,'2022-10-12 20:42:56','财务2','财务1300年'),(39,'小猪3号',26,'男','株洲荷塘区','17680713872','','2042975339@qq.com','2042975339','12345ss',7,'财务部',NULL,NULL,'财务3','财务1300年'),(40,'小猪4号',34,'男','株洲荷塘区','17680713872','','2042975339@qq.com','2042975339','12345ss',7,'财务部',NULL,NULL,'财务4','财务1300年'),(41,'小猪5号',25,'男','株洲荷塘区','17680713872','','2042975339@qq.com','2042975339','12345ss',7,'市场部',NULL,NULL,'销售1','销售1300年'),(42,'小猪6号',24,'女','株洲荷塘区','17680713872','','2042975339@qq.com','2042975339','12345ss',7,'市场部',NULL,NULL,'销售2','销售1300年'),(43,'小猪7号',26,'男','株洲荷塘区','17680713872','','2042975339@qq.com','2042975339','12345ss',7,'市场部',NULL,NULL,'销售3','销售1300年'),(44,'小猪8号',34,'男','株洲荷塘区','17680713872','','2042975339@qq.com','2042975339','12345ss',4,'市场部',NULL,'2022-10-12 20:43:24','销售4','销售1300年'),(48,'小猪13号',34,'男','株洲荷塘区','17680713872','','2042975339@qq.com','2042975339','12345ss',3,'人事部',NULL,'2022-10-12 20:43:07','人事4','人事1300年'),(49,'欧阳',21,'男','湖南株洲','17680713872','','2042975339@qq.com','5555555555','5555555555',7,'教练部','2022-10-10 11:21:29','2022-10-11 13:10:48','教练',''),(50,'老王',34,'男','株洲','17680713872','https://liucz-bucket.oss-cn-hangzhou.aliyuncs.com/avatar/2022/10/10/2c06e8f8cd734e729c2cff04f1892672.jpg','2042975339@qq.com','123456789','123456789',5,'后勤部','2022-10-10 15:30:33','2022-10-10 15:30:33','维修一号','阿达'),(51,'财务2号',34,'男','湖南株洲','17680713872','https://liucz-bucket.oss-cn-hangzhou.aliyuncs.com/avatar/2022/10/12/59e059833cd043a785c186bca497895c.jpg','2042975339@qq.com','2222222','2222222',6,'财务部','2022-10-12 16:00:53','2022-10-12 16:00:53','财务','打'),(52,'刀哥',38,'男','株洲人工智能学校','15575757575','https://liucz-bucket.oss-cn-hangzhou.aliyuncs.com/avatar/2022/10/19/3e054e0665754a809fb8e3c82e9b3e4f.jpg','cs@163.com','110120','110120',5,'后勤部','2022-10-19 15:21:20','2022-10-19 15:21:20','维修','维修大哥'),(53,'力哥',35,'女','你家','15575757575','https://liucz-bucket.oss-cn-hangzhou.aliyuncs.com/avatar/2022/10/19/c7331c1c526542aa9021952cc8babcf7.jpg','cs@163.com','110120','119129',6,'财务部','2022-10-19 15:22:35','2022-10-19 15:22:35','财务','力哥'),(54,'叼哥',28,'男','我家','15575757575','https://liucz-bucket.oss-cn-hangzhou.aliyuncs.com/avatar/2022/10/19/197571aae07546f0bb14d9b37a5e6153.jpg','cs@163.com','110120','110120',7,'教练部','2022-10-19 15:23:54','2022-10-19 15:23:54','教练','雕哥'),(55,'十四',23,'男','湖南株洲','15197222194','https://liucz-bucket.oss-cn-hangzhou.aliyuncs.com/avatar/2022/10/19/ae104af96c23485d8883bde28b2cfa72.jpg','121212221@qq.com','1213445','qwwqwq',2,'行政部','2022-10-19 16:19:04','2022-10-19 16:19:04','客服','客服'),(56,'小十四',24,'女','湖南株洲','17687698765','https://liucz-bucket.oss-cn-hangzhou.aliyuncs.com/avatar/2022/10/19/10919d850f8a4bcc9b93932e6c207a27.jpg','1221122121@qq.com','1234567','shyerifjj',2,'行政部','2022-10-19 16:22:54','2022-10-19 16:22:54',' 前台','前台'),(57,'十五',23,'男','湖南株洲','17164567898','https://liucz-bucket.oss-cn-hangzhou.aliyuncs.com/avatar/2022/10/19/093e699dc0574ee8b87f5f0be13c6f39.jpg','123324@qq.com','12213541','seefssdd',2,'行政部','2022-10-19 17:22:29','2022-10-19 17:22:29','客服','客服');
/*!40000 ALTER TABLE `sys_emp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_permission`
--

DROP TABLE IF EXISTS `sys_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_permission` (
                                  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '权限编号',
                                  `label` varchar(50) DEFAULT NULL COMMENT '权限名称',
                                  `parent_id` bigint DEFAULT NULL COMMENT '父权限ID',
                                  `parent_name` varchar(50) DEFAULT NULL COMMENT '父权限名称',
                                  `code` varchar(50) DEFAULT NULL COMMENT '授权标识符',
                                  `path` varchar(100) DEFAULT NULL COMMENT '路由地址',
                                  `name` varchar(50) DEFAULT NULL COMMENT '路由名称',
                                  `url` varchar(100) DEFAULT NULL COMMENT '授权路径',
                                  `type` tinyint DEFAULT NULL COMMENT '权限类型(0-目录 1-菜单 2-按钮)',
                                  `icon` varchar(50) DEFAULT NULL COMMENT '图标',
                                  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
                                  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
                                  `order_num` int DEFAULT NULL COMMENT '排序',
                                  `is_delete` tinyint DEFAULT '0' COMMENT '是否删除(0-未删除，1-已删除)',
                                  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=399 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_permission`
--

LOCK TABLES `sys_permission` WRITE;
/*!40000 ALTER TABLE `sys_permission` DISABLE KEYS */;
INSERT INTO `sys_permission` VALUES (1,'系统管理',0,'顶级菜单','sys:manager','/system','system','/system/system',0,'el-icon-menu','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,0,0),(2,'部门管理',1,'系统管理','sys:department','/department','department','/system/department/department',1,'el-icon-s-tools','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(3,'新增',2,'部门管理','sys:department:add',NULL,NULL,NULL,2,'el-icon-plus','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(4,'修改',2,'部门管理','sys:department:edit',NULL,NULL,NULL,2,'el-icon-edit','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(5,'删除',2,'部门管理','sys:department:delete',NULL,NULL,NULL,2,'el-icon-delete','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(6,'用户管理',1,'系统管理','s		ys:user','/userList','userList','/system/user/userList',1,'el-icon-s-custom','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(7,'新增',6,'用户管理','sys:emp:add',NULL,NULL,NULL,2,'el-icon-plus','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(8,'修改',6,'用户管理','sys:emp:edit',NULL,NULL,NULL,2,'el-icon-edit','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(9,'删除',6,'用户管理','sys:emp:delete',NULL,NULL,NULL,2,'el-icon-delete','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(10,'角色管理',1,'系统管理','sys:role','/roleList','roleList','/system/role/roleList',1,'el-icon-s-tools','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(11,'新增',10,'角色管理','sys:role:add',NULL,NULL,NULL,2,'el-icon-plus','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(12,'修改',10,'角色管理','sys:role:edit',NULL,NULL,NULL,2,'el-icon-edit','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(13,'删除',10,'角色管理','sys:role:delete',NULL,NULL,NULL,2,'el-icon-delete','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(14,'菜单管理',1,'系统管理','sys:menu','/menuList','menuList','/system/menu/menuList',1,'el-icon-s-tools','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(15,'新增',14,'权限管理','sys:menu:add',NULL,NULL,NULL,2,'el-icon-plus','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(16,'修改',14,'权限管理','sys:menu:edit',NULL,NULL,NULL,2,'el-icon-edit','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(17,'删除',14,'权限管理','sys:menu:delete',NULL,NULL,NULL,2,'el-icon-delete','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(23,'分配账号',6,'用户管理','sys:emp:user','','','',2,'el-icon-setting',NULL,NULL,NULL,NULL,0),(24,'分配权限',10,'角色管理','sys:role:assign','','','',2,'el-icon-setting',NULL,NULL,NULL,NULL,0),(25,'查询',2,'部门管理','sys:department:select','','','',2,'el-icon-search',NULL,NULL,NULL,NULL,0),(26,'查询',6,'用户管理','sys:user:select','','','',2,'el-icon-search',NULL,NULL,NULL,NULL,0),(27,'查询',10,'角色管理','sys:role:select','','','',2,'el-icon-search',NULL,NULL,NULL,NULL,0),(28,'查询',14,'菜单管理','sys:menu:select','','','',2,'el-icon-search',NULL,NULL,NULL,NULL,0),(29,'账号管理',1,'系统管理','sys:account','/account','account','/system/account/accountList',0,'el-icon-s-custom','2022-09-19 14:40:32','2022-09-19 14:40:32',NULL,0,0),(30,'新增',29,'账号管理','sys:account:add',NULL,NULL,NULL,2,'el-icon-plus','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(31,'修改',29,'账号管理','sys:account:edit',NULL,NULL,NULL,2,'el-icon-edit','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(32,'删除',29,'账号管理','sys:account:delete',NULL,NULL,NULL,2,'el-icon-delete','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(33,'查询',29,'账号管理','sys:account:select','','','',2,'el-icon-search',NULL,NULL,NULL,NULL,0),(34,'会员管理',0,'顶级菜单','members:members','/members','members','/members/members',0,'el-icon-menu','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,0,0),(35,'普通会员管理',34,'会员管理','members:ptmember','/ptmember','ptmember','/members/ptmember/ptmember',1,'el-icon-s-tools','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,0,0),(36,'私教会员管理',34,'会员管理','members:sjmember','/sjmember','sjmember','/members/sjmember/sjmember',1,'el-icon-s-tools','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,0,0),(37,'团操会员管理',34,'会员管理','members:tcmember','/tcmember','tcmember','/members/tcmember/tcmember',1,'el-icon-s-tools','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,0,0),(38,'黑白名单管理',34,'会员管理','members:blacklist','/blacklist','blacklist','/members/blacklist/blacklist',1,'el-icon-s-tools','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,0,0),(39,'会员列表管理',34,'会员管理','members:refinance','/refinance','refinance','/members/refinance/refinance',1,'el-icon-s-tools','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,0,0),(41,'消费记录管理',34,'会员管理','members:comsune','/comsune','comsune','/members/comsune/comsune',1,'el-icon-s-tools','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,0,0),(42,'合同管理',34,'会员管理','members:contract','/contract','contract','/members/contract/contract',1,'el-icon-s-tools','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,0,0),(43,'储物柜管理',0,'顶级菜单','lockers:lockers','/lockers','lockers','/lockers/lockers',0,'el-icon-menu','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,0,0),(44,'储物柜列表',43,'储物柜管理','lockers:locker','/locker','locker','/lockers/locker/locker',1,'el-icon-s-tools','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,0,0),(45,'失物招领管理',0,'顶级菜单','loses:loses','/loses','loses','/loses/loses',0,'el-icon-menu','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,0,0),(46,'失物列表',45,'失物招领管理','loses:lose','/lose','lose','/loses/lose/lose',1,'el-icon-s-tools','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,0,0),(52,'库存管理',0,'顶级菜单','stores:stores','/stores','stores','/stores/stores',0,'el-icon-s-custom','2022-09-20 15:40:57','2022-09-20 15:42:32',NULL,NULL,0),(53,'查看库存',52,'库存管理','stores:store','/storeList','storeList','/stores/store/storeList',1,'el-icon-s-custom','2022-09-20 15:45:00','2022-09-20 16:03:04',NULL,NULL,0),(54,'出库物品管理',52,'库存管理','stores:outStore','/outStoreList','outStoreList','/stores/store/outStoreList',1,'el-icon-s-custom','2022-09-20 15:51:44','2022-09-20 16:03:57',NULL,NULL,0),(55,'采购计划',52,'库存管理','stores:storePlanList','/storePlanList','storePlanList','/stores/store/storePlanList',1,'el-icon-s-custom','2022-09-20 16:13:15','2022-09-20 19:21:44',NULL,NULL,0),(56,'报修管理',0,'顶级菜单','repairs:repairs','/repairs','repairs','/repairs/repairs',0,'el-icon-s-custom','2022-09-20 16:20:35','2022-09-20 17:01:16',NULL,NULL,0),(57,'器材损坏上报',56,'报修管理','repairs:repair','/repairList','repairList','/repairs/repair/repairList',1,'el-icon-s-custom','2022-09-20 16:30:59','2022-09-20 19:47:05',NULL,NULL,0),(58,'器材管理',0,'顶级菜单','equipments:equipment','/equipments','equipment','/equipments/equipments',0,'el-icon-s-custom','2022-09-20 19:19:27','2022-09-20 19:19:52',NULL,NULL,0),(59,'器材维修记录',58,'器材管理','equipment:plan','/equipmentPlan','equipmentPlan','/equipments/equipment/equipmentPlan',1,'el-icon-s-custom','2022-09-20 19:21:31','2022-09-20 19:53:06',NULL,NULL,0),(60,'财务管理',0,'顶级菜单','finances:finances','/finances','finances','/finances/finances',0,'el-icon-s-custom','2022-09-20 19:44:11','2022-09-20 19:45:19',NULL,NULL,0),(61,'支出记录',60,'财务管理','finances:disburse','/disburseList','disburseList','/finances/finance/disburseList',1,'el-icon-s-custom','2022-09-20 19:46:31','2022-10-19 16:15:09',NULL,NULL,0),(62,'套餐收入记录',60,'财务管理','finances:proceeds','/proceedsList','proceedsList','/finances/finance/proceedsList',1,'el-icon-s-custom','2022-09-20 19:46:31','2022-10-19 16:15:10',NULL,NULL,0),(63,'商品收入记录',60,'财务管理','finances:invoice','/invoiceList','invoiceList','/finances/finance/invoiceList',1,'el-icon-s-custom','2022-09-20 19:46:31','2022-10-19 16:15:11',NULL,NULL,0),(64,'统计提成',60,'财务管理','finances:commission','/commissionList','commissionList','/finances/finance/commissionList',1,'el-icon-s-custom','2022-09-20 19:46:31','2022-09-20 19:47:53',NULL,NULL,0),(65,'已购物品管理',52,'库存管理','stores:po','/poList','poList','/stores/store/poList',1,'el-icon-s-custom','2022-09-21 09:21:41','2022-09-21 09:23:04',NULL,NULL,0),(66,'教练管理',0,'顶级菜单','coachs:coachs','/coachs','coachs','/coachs/coachs',0,'el-icon-menu','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(67,'教练信息',66,'教练管理','coachs:coach','/coach','coach','/coachs/coach/coachList',1,'el-icon-s-custom','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(68,'出库记录',52,'库存管理','stores:OutStockRecord','/outRecord','outRecord','/stores/store/outStockRecord',1,'el-icon-s-tools','2022-10-12 10:59:13','2022-10-12 11:01:35',NULL,NULL,0),(70,'学员列表',98,'学员管理','students:student','/student','student','/students/student/studentList',1,'el-icon-menu','2022-04-25 14:40:32','2022-10-05 00:04:30',NULL,0,0),(71,'销售管理',0,'顶级菜单','sellgood:sellgood','/sellgood','sellgood','/sellgood/sellgood',0,'el-icon-s-tools','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(72,'普通套餐管理',71,'销售管理','sellgood:commonMeal','/commonMeal','commonMeal','/sellgood/commonMeal/commonMealList',1,'el-icon-s-tools','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(73,'私教套餐管理',71,'销售管理','sellgood:ptMeal','/ptMeal','ptMeal','/sellgood/ptMeal/ptMealList',1,'el-icon-s-tools','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(74,'团操套餐管理',71,'销售管理','sellgood:teamMeal','/teamMeal','teamMeal','/sellgood/teamMeal/teamMealList',1,'el-icon-s-tools','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(75,'课程销售',71,'销售管理','sellgood:classSell','/classSell','classSell','/sellgood/classSell/classSellList',1,'el-icon-s-tools','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(76,'商品销售',71,'销售管理','sellgood:sellgood','/sellgood','sellgood','/sellgood/sellgood/sellgoodList',1,'el-icon-s-tools','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(77,'活动安排',71,'销售管理','sellgood:activity','/activity','activity','/sellgood/activity/activityList',1,'el-icon-s-tools','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(78,'会员体检管理',98,'学员管理','students:healthForm','/healthForm','healthForm','/students/healthForm/healthForm',1,'el-icon-s-tools','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(81,'项目类型',0,'顶级菜单','projectname:projectname','/projectname','projectname','/projectname/projectname',0,'el-icon-s-tools','2022-04-25 14:40:32','2022-09-26 14:17:09',NULL,NULL,0),(82,'私教项目类型',81,'项目类型','projectname:ptPro','/ptPro','ptPro','/projectname/ptPro/ptProList',1,'el-icon-s-tools','2022-04-25 14:40:32','2022-09-26 14:19:26',NULL,NULL,0),(83,'团操项目类型',81,'项目类型','projectname:teamPro','/teamPro','teamPro','/projectname/teamPro/teamProList',1,'el-icon-s-tools','2022-04-25 14:40:32','2022-09-26 14:16:53',NULL,NULL,0),(84,'客服管理',0,'顶级菜单','services:services','/services','services','/services/services',0,'el-icon-menu','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,0,0),(85,'客服信息管理',84,'客服管理','services:message','/message','message','/services/message/message',1,'el-icon-s-tools','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,0,0),(86,'回访管理',0,'顶级菜单','pay:pay','/pay','pay','/pay/pay',0,'el-icon-menu','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,0,0),(87,'潜在用户回访列表',86,'回访管理','pay:prospect','/prospect','prospect','/pay/prospectlist/prospectlist',1,'el-icon-s-tools','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,0,0),(88,'会员回访列表',86,'回访管理','pay:memberlist','/memberlist','memberlist','/pay/memberlist/memberlist',1,'el-icon-s-tools','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,0,0),(89,'会员回访记录',86,'回访管理','pay:memberecord','/memberecord','memberecord','/pay/memberecord/memberecord',1,'el-icon-s-tools','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,0,0),(90,'潜在用户回访记录',86,'回访管理','pay:prospectrecord','/prospectrecord','prospectrecord','/pay/prospectrecord/prospectrecord',1,'el-icon-s-tools','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,0,0),(91,'审核管理',0,'顶级菜单','shenhes:shenhe','/shenhes','shenhes','/shenhes/shenhes',0,'el-icon-menu','2022-04-25 14:40:32','2022-10-05 00:04:30',NULL,0,0),(92,'采购审批',91,'审核管理','shenhes:caigou','/caigou','caigou','/shenhes/caigou/caigouList',1,'el-icon-menu','2022-04-25 14:40:32','2022-10-05 00:04:30',NULL,0,0),(93,'器材损坏管理',58,'器材管理','shenhes:baoxiu','/baoxiu','baoxiu','/shenhes/baoxiu/baoxiuList',1,'el-icon-menu','2022-04-25 14:40:32','2022-10-05 00:04:30',NULL,0,0),(94,'入库记录',52,'库存管理','store:inStock','/inStock','inStock','/stores/store/inStockList',1,'el-icon-s-tools','2022-09-25 21:22:21','2022-09-25 21:27:51',NULL,NULL,0),(96,'用户咨询',86,'回访管理','pay:counsult','/counsult','counsult','/pay/counsult/counsult',1,'el-icon-s-tools','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,0,0),(98,'学员管理',0,'顶级菜单','students:students','/students','students','/students/students',0,'el-icon-menu','2022-04-25 14:40:32','2022-10-05 00:04:30',NULL,0,0),(99,'访谈记录',98,'教练管理','students:interview','/interview','interview','/students/interview/interviewList',1,'el-icon-s-tools','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(100,'潜在用户管理',0,'顶级菜单','prospects:prospects','/prospects','prospects','/prospects/prospects',0,'el-icon-s-tools','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,0,0),(101,'潜在用户列表',100,'潜在用户管理','prospects:prospects','/prospects','prospects','/prospects/prospects/prospects',1,'el-icon-s-tools','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,0,0),(110,'删除',37,'团操会员管理','members:tcmember:delete',NULL,NULL,NULL,2,'el-icon-delete','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(111,'查询',37,'团操会员管理','members:tcmember:select',NULL,NULL,NULL,2,'el-icon-search','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(115,'查询',38,'黑白名单管理','members:blacklist:select',NULL,NULL,NULL,2,'el-icon-search','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(116,'查询',41,'消费记录管理','members:comsune:select',NULL,NULL,NULL,2,'el-icon-search','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(117,'新增',42,'合同管理','members:contract:add',NULL,NULL,NULL,2,'el-icon-plus','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(119,'删除',42,'合同管理','members:contract:delete',NULL,NULL,NULL,2,'el-icon-delete','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(120,'查询',42,'合同管理','members:contract:select',NULL,NULL,NULL,2,'el-icon-search','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(121,'新增',44,'储物柜列表','members:locker:add',NULL,NULL,NULL,2,'el-icon-plus','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(123,'删除',44,'储物柜列表','members:locker:delete',NULL,NULL,NULL,2,'el-icon-delete','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(124,'查询',44,'储物柜列表','members:locker:select',NULL,NULL,NULL,2,'el-icon-search','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(125,'新增',46,'失物列表','loses:lose:add',NULL,NULL,NULL,2,'el-icon-plus','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(128,'查询',46,'失物列表','loses:lose:select',NULL,NULL,NULL,2,'el-icon-search','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(139,'出库',53,'查看库存','stores:store:outStock',NULL,NULL,NULL,2,'el-icon-plus','2022-09-20 15:45:54','2022-10-10 09:27:21',NULL,NULL,0),(140,'修改',53,'查看库存','stores:store:edit',NULL,NULL,NULL,2,'el-icon-edit','2022-09-20 15:48:50','2022-09-20 15:50:23',NULL,NULL,0),(141,'删除',53,'查看库存','stores:store:delete','',NULL,NULL,2,'el-icon-delete','2022-09-20 15:49:15','2022-09-20 16:08:25',NULL,NULL,0),(142,'查询',53,'查看库存','stores:store:select',NULL,NULL,NULL,2,'el-icon-select','2022-09-20 15:50:19','2022-09-20 16:08:20',NULL,NULL,0),(143,'新增',54,'出库物品管理','stores:outStore:add',NULL,NULL,NULL,2,'el-icon-plus','2022-09-20 16:00:20','2022-09-20 16:08:33',NULL,NULL,0),(144,'修改',54,'出库物品管理','stores:outStore:edit',NULL,NULL,NULL,2,'el-icon-edit','2022-09-20 16:09:13','2022-09-20 16:09:13',NULL,NULL,0),(145,'删除',54,'出库物品管理','stores:outStore:delete',NULL,NULL,NULL,2,'el-icon-delete','2022-09-20 16:09:53','2022-09-20 16:09:53',NULL,NULL,0),(146,'查询',54,'出库物品管理','stores:outStore:select',NULL,NULL,NULL,2,'el-icon-select','2022-09-20 16:11:37','2022-09-20 16:11:37',NULL,NULL,0),(147,'新增',55,'采购计划','stores:plan:add',NULL,NULL,NULL,2,'el-icon-plus','2022-09-20 16:00:20','2022-09-20 16:08:33',NULL,NULL,0),(148,'修改',55,'采购计划','stores:plan:edit',NULL,NULL,NULL,2,'el-icon-edit','2022-09-20 16:09:13','2022-09-20 16:09:13',NULL,NULL,0),(149,'删除',55,'采购计划','stores:plan:delete',NULL,NULL,NULL,2,'el-icon-delete','2022-09-20 16:09:53','2022-09-20 16:09:53',NULL,NULL,0),(150,'查询',55,'采购计划','stores:plan:select',NULL,NULL,NULL,2,'el-icon-select','2022-09-20 16:11:37','2022-09-20 16:11:37',NULL,NULL,0),(151,'已购',55,'采购计划','stores:plan:toPo',NULL,NULL,NULL,2,'el-icon-select','2022-10-10 14:55:49','2022-10-10 14:59:34',NULL,NULL,0),(152,'审核',55,'采购计划','stores:plan:shenhe',NULL,NULL,NULL,2,'el-icon-select','2022-10-10 14:55:54','2022-10-10 15:11:29',NULL,NULL,0),(153,'删除',57,'器材损坏上报','repairs:record:delete',NULL,NULL,NULL,2,'el-icon-delete','2022-09-20 16:09:53','2022-10-10 11:02:15',NULL,NULL,0),(154,'上报',57,'器材损坏上报','repairs:record:add',NULL,NULL,NULL,2,'el-icon-select','2022-09-20 16:11:37','2022-10-10 15:20:11',NULL,NULL,0),(157,'删除',59,'器材维修记录','equipment:plan:delete',NULL,NULL,NULL,2,'el-icon-delete','2022-09-20 16:09:53','2022-10-10 11:18:45',NULL,NULL,0),(158,'查询',59,'器材维修记录','equipment:plan:select',NULL,NULL,NULL,2,'el-icon-select','2022-09-20 16:11:37','2022-10-10 15:25:30',NULL,NULL,0),(205,'入库',65,'已购物品管理','stores:po:toStore',NULL,NULL,NULL,2,'el-icon-plus','2022-09-20 16:00:20','2022-10-10 09:32:15',NULL,NULL,0),(206,'修改',65,'已购物品管理','stores:po:edit',NULL,NULL,NULL,2,'el-icon-edit','2022-09-20 16:09:13','2022-09-20 16:09:13',NULL,NULL,0),(207,'删除',65,'已购物品管理','stores:po:delete',NULL,NULL,NULL,2,'el-icon-delete','2022-09-20 16:09:53','2022-09-20 16:09:53',NULL,NULL,0),(208,'查询',65,'已购物品管理','stores:po:select',NULL,NULL,NULL,2,'el-icon-select','2022-09-20 16:11:37','2022-09-20 16:11:37',NULL,NULL,0),(209,'新增',67,'教练信息','coachs:coach:add',NULL,NULL,NULL,2,'el-icon-plus','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(210,'修改',67,'教练信息','coachs:coach:edit',NULL,NULL,NULL,2,'el-icon-edit','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(211,'删除',67,'教练信息','coachs:coach:delete',NULL,NULL,NULL,2,'el-icon-delete','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(212,'查询',67,'教练信息','coachs:coach:select','','','',2,'el-icon-search',NULL,NULL,NULL,NULL,0),(213,'新增',68,'课程安排','coachs:classArrange:add',NULL,NULL,NULL,2,'el-icon-plus','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(214,'修改',68,'课程安排','coachs:classArrange:edit',NULL,NULL,NULL,2,'el-icon-edit','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(215,'删除',68,'课程安排','coachs:classArrange:delete',NULL,NULL,NULL,2,'el-icon-delete','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(216,'查询',68,'课程安排','coachs:classArrange:select','','','',2,'el-icon-search',NULL,NULL,NULL,NULL,0),(217,'新增',69,'会员考勤管理','coachs:memcheck:add',NULL,NULL,NULL,2,'el-icon-plus','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(218,'修改',69,'会员考勤管理','coachs:memcheck:edit',NULL,NULL,NULL,2,'el-icon-edit','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(219,'删除',69,'会员考勤管理','coachs:memcheck:delete',NULL,NULL,NULL,2,'el-icon-delete','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(220,'查询',69,'会员考勤管理','coachs:memcheck:select','','','',2,'el-icon-search',NULL,NULL,NULL,NULL,0),(223,'删除',70,'访谈记录','coachs:interview:delete',NULL,NULL,NULL,2,'el-icon-delete','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(224,'查询',70,'访谈记录','coachs:interview:select','','','',2,'el-icon-search',NULL,NULL,NULL,NULL,0),(225,'新增',72,'普通套餐管理','sellgood:commonMeal:add',NULL,NULL,NULL,2,'el-icon-plus','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(226,'修改',72,'普通套餐管理','sellgood:commonMeal:edit',NULL,NULL,NULL,2,'el-icon-edit','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(227,'删除',72,'普通套餐管理','sellgood:commonMeal:delete',NULL,NULL,NULL,2,'el-icon-delete','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(228,'查询',72,'普通套餐管理','sellgood:commonMeal:select','','','',2,'el-icon-search',NULL,NULL,NULL,NULL,0),(229,'新增',73,'私教套餐管理','sellgood:ptMeal:add',NULL,NULL,NULL,2,'el-icon-plus','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(230,'修改',73,'私教套餐管理','sellgood:ptMeal:edit',NULL,NULL,NULL,2,'el-icon-edit','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(231,'删除',73,'私教套餐管理','sellgood:ptMeal:delete',NULL,NULL,NULL,2,'el-icon-delete','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(232,'查询',73,'私教套餐管理','sellgood:ptMeal:select','','','',2,'el-icon-search',NULL,NULL,NULL,NULL,0),(234,'新增',74,'团操套餐管理','sellgood:teamMeal:add',NULL,NULL,NULL,2,'el-icon-plus','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(235,'修改',74,'团操套餐管理','sellgood:teamMeal:edit',NULL,NULL,NULL,2,'el-icon-edit','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(236,'删除',74,'团操套餐管理','sellgood:teamMeal:delete',NULL,NULL,NULL,2,'el-icon-delete','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(237,'查询',74,'团操套餐管理','sellgood:teamMeal:select','','','',2,'el-icon-search',NULL,NULL,NULL,NULL,0),(238,'购买套餐',75,'课程销售','sellgood:classSell:getMeal',NULL,NULL,NULL,2,'el-icon-plus','2022-04-25 14:40:32','2022-10-10 19:37:25',NULL,NULL,0),(239,'查询',75,'课程销售','sellgood:classSell:select',NULL,NULL,NULL,2,'el-icon-edit','2022-04-25 14:40:32','2022-10-10 19:43:52',NULL,NULL,0),(240,'删除',75,'课程销售','sellgood:classSell:delete',NULL,NULL,NULL,2,'el-icon-delete','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(241,'查询',75,'课程管理','sellgood:classSell:select','','','',2,'el-icon-search',NULL,NULL,NULL,NULL,0),(245,'购买',76,'商品销售','sellgood:sellgood:add',NULL,NULL,NULL,2,'el-icon-plus','2022-04-25 14:40:32','2022-10-10 19:46:25',NULL,NULL,0),(246,'撤销购买',76,'商品销售','sellgood:sellgood:delete2',NULL,NULL,NULL,2,'el-icon-edit','2022-04-25 14:40:32','2022-10-10 19:46:42',NULL,NULL,0),(247,'删除',76,'商品销售','sellgood:sellgood:delete',NULL,NULL,NULL,2,'el-icon-delete','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(248,'查询',76,'商品销售','sellgood:sellgood:select','','','',2,'el-icon-search',NULL,NULL,NULL,NULL,0),(249,'新增',77,'活动安排','sellgood:activity:add',NULL,NULL,NULL,2,'el-icon-plus','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(250,'修改',77,'活动安排','sellgood:activity:edit',NULL,NULL,NULL,2,'el-icon-edit','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(251,'删除',77,'活动安排','sellgood:activity:delete',NULL,NULL,NULL,2,'el-icon-delete','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(252,'查询',77,'活动安排','sellgood:activity:select','','','',2,'el-icon-search',NULL,NULL,NULL,NULL,0),(255,'删除',78,'会员体检管理','healthForm:healthForm:delete',NULL,NULL,NULL,2,'el-icon-delete','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(256,'查询',78,'会员体检管理','healthForm:healthForm:select','','','',2,'el-icon-search',NULL,NULL,NULL,NULL,0),(258,'新增',82,'私教项目类型','projectname:ptPro:add',NULL,NULL,NULL,2,'el-icon-plus','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(259,'修改',82,'私教项目类型','projectname:ptPro:edit',NULL,NULL,NULL,2,'el-icon-edit','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(260,'删除',82,'私教项目类型','projectname:ptPro:delete',NULL,NULL,NULL,2,'el-icon-delete','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(261,'查询',82,'私教项目类型','projectname:ptPro:select',NULL,NULL,NULL,2,'el-icon-search','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(262,'新增',83,'团操项目类型','projectname:teamPro:add',NULL,NULL,NULL,2,'el-icon-plus','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(263,'修改',83,'团操项目类型','projectname:teamPro:edit',NULL,NULL,NULL,2,'el-icon-edit','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(264,'删除',83,'团操项目类型','projectname:teamPro:delete',NULL,NULL,NULL,2,'el-icon-delete','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(265,'查询',83,'团操项目类型','projectname:teamPro:select',NULL,NULL,NULL,2,'el-icon-search','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(301,'分配角色',29,'账号管理','sys:account:role','','','',2,'el-icon-eleme',NULL,NULL,NULL,NULL,0),(318,'器材使用记录',58,'器材管理','equipments:details','/details','details','/equipments/equipment/details',1,'el-icon-s-tools','2022-09-29 11:32:35','2022-09-29 14:00:23',NULL,NULL,0),(319,'器材损坏记录',58,'器材管理','equipments:sunhuai','/sunhuai','sunhuai','/equipments/equipment/sunhuai',1,'el-icon-s-tools','2022-09-29 11:32:35','2022-09-29 14:00:23',NULL,NULL,0),(320,'新增',35,'普通会员管理','members:ptmember:add',NULL,NULL,NULL,2,'el-icon-plus','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(321,'修改',35,'普通会员管理','members:ptmember:edit',NULL,NULL,NULL,2,'el-icon-edit','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(322,'删除',35,'普通会员管理','members:ptmember:delete',NULL,NULL,NULL,2,'el-icon-delete','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(323,'查询',35,'普通会员管理','members:ptmember:select',NULL,NULL,NULL,2,'el-icon-search','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(324,'新增',36,'私教会员管理','members:sjmember:add',NULL,NULL,NULL,2,'el-icon-plus','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(325,'修改',36,'私教会员管理','members:sjmember:edit',NULL,NULL,NULL,2,'el-icon-edit','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(326,'删除',36,'私教会员管理','members:sjmember:delete',NULL,NULL,NULL,2,'el-icon-delete','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(327,'查询',36,'私教会员管理','members:sjmember:select',NULL,NULL,NULL,2,'el-icon-search','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(328,'新增',37,'团操会员管理','members:tcmember:add',NULL,NULL,NULL,2,'el-icon-plus','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(329,'修改',37,'团操会员管理','members:tcmember:edit',NULL,NULL,NULL,2,'el-icon-edit','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(330,'撤销审核',55,'采购计划','stores:plan:cxshenhe',NULL,NULL,NULL,2,'el-icon-edit','2022-10-10 15:12:07','2022-10-10 15:12:10',NULL,NULL,0),(331,'查询',57,'器材损坏上报','repairs:record:select',NULL,NULL,NULL,2,'el-icon-edit','2022-10-10 15:20:51','2022-10-10 15:20:53',NULL,NULL,0),(332,'分配维修工',93,'器材损坏管理','shenhes:baoxiu:fenpei',NULL,NULL,NULL,2,'el-icon-edit','2022-10-10 15:29:19','2022-10-10 15:41:01',NULL,NULL,0),(333,'删除',93,'器材损坏管理','shenhes:baoxiu:delete',NULL,NULL,NULL,2,'el-icon-edit','2022-10-10 15:29:42','2022-10-10 15:30:03',NULL,NULL,0),(334,'查询',93,'器材损坏管理','shenhes:baoxiu:select',NULL,NULL,NULL,2,'el-icon-edit','2022-10-10 15:30:28','2022-10-10 15:30:31',NULL,NULL,0),(335,'查询',318,'器材使用记录','equipments:details:select',NULL,NULL,NULL,2,'el-icon-edit','2022-10-10 18:30:29','2022-10-10 18:30:47',NULL,NULL,0),(336,'新增',318,'器材使用记录','equipments:details:add',NULL,NULL,NULL,2,'el-icon-edit','2022-10-10 18:31:15','2022-10-10 18:43:14',NULL,NULL,0),(337,'修改',318,'器材使用记录','equipments:details:edit',NULL,NULL,NULL,2,'el-icon-edit','2022-10-10 18:32:06','2022-10-10 18:43:16',NULL,NULL,0),(338,'删除',318,'器材使用记录','equipments:details:delete',NULL,NULL,NULL,2,'el-icon-edit','2022-10-10 18:32:24','2022-10-10 18:43:18',NULL,NULL,0),(340,'查询',319,'器材损坏记录','equipments:sunhuai:delete',NULL,NULL,NULL,2,'el-icon-edit','2022-10-10 18:53:58','2022-10-10 18:54:21',NULL,NULL,0),(341,'修理',319,'器材损坏记录','equipments:sunhuai:xiuli',NULL,NULL,NULL,2,'el-icon-edit','2022-10-10 18:56:14','2022-10-10 18:56:28',NULL,NULL,0),(342,'选择项目',73,'私教套餐管理','sellgood:ptMeal:xuanze',NULL,NULL,NULL,2,'el-icon-edit','2022-10-10 19:13:55','2022-10-10 19:17:14',NULL,NULL,0),(343,'选择项目',74,'团操套餐管理','sellgood:teamMeal:xuanze',NULL,NULL,NULL,2,'el-icon-edit','2022-10-10 19:23:06','2022-10-10 19:23:08',NULL,NULL,0),(344,'处理审核',92,'采购审核管理','shenhes:caigou:cl',NULL,NULL,NULL,2,'el-icon-edit','2022-10-10 20:11:28','2022-10-10 20:11:50',NULL,NULL,0),(345,'删除',92,'采购审核管理','shenhes:caigou:delete',NULL,NULL,NULL,2,'el-icon-edit','2022-10-10 20:13:41','2022-10-10 20:14:07',NULL,NULL,0),(346,'查询',92,'采购审核管理','shenhes:caigou:select',NULL,NULL,NULL,2,'el-icon-edit','2022-10-10 20:14:44','2022-10-10 20:14:44',NULL,NULL,0),(360,'删除',39,'会员列表管理','members:refinance:delete',NULL,NULL,NULL,2,'el-icon-delete','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(361,'查询',39,'会员列表管理','members:refinance:select',NULL,NULL,NULL,2,'el-icon-search','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(362,'新增',39,'会员列表管理','members:refinance:add',NULL,NULL,NULL,2,'el-icon-plus','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(363,'修改',39,'会员列表管理','members:refinance:edit',NULL,NULL,NULL,2,'el-icon-edit','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(364,'加入黑名单',39,'会员列表管理','members:refinance:addblack',NULL,NULL,NULL,2,'el-icon-plus','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(365,'移除黑名单',38,'黑白名单管理','members:blacklist:delete',NULL,NULL,NULL,2,'el-icon-delete','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(366,'续费',35,'普通会员管理','members:ptmember:xufei',NULL,NULL,NULL,2,'el-icon-plus','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(367,'详情',35,'普通会员管理','members:ptmember:xiangqing',NULL,NULL,NULL,2,'el-icon-delete','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(368,'续费',36,'私教会员管理','members:sjmember:xufei',NULL,NULL,NULL,2,'el-icon-plus','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(369,'详情',36,'私教会员管理','members:sjmember:xiangqing',NULL,NULL,NULL,2,'el-icon-delete','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(370,'续费',37,'团操会员管理','members:tcmember:xufei',NULL,NULL,NULL,2,'el-icon-plus','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(371,'详情',37,'团操会员管理','members:tcmember:xiangqing',NULL,NULL,NULL,2,'el-icon-delete','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(372,'查询空储物柜',44,'储物柜列表','members:locker:selectnull',NULL,NULL,NULL,2,'el-icon-search','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(373,'添加会员',44,'储物柜列表','members:locker:addmember',NULL,NULL,NULL,2,'el-icon-search','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(374,'移除会员',44,'储物柜列表','members:locker:deletemember',NULL,NULL,NULL,2,'el-icon-search','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(375,'领取',46,'失物列表','loses:lose:get',NULL,NULL,NULL,2,'el-icon-plus','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(376,'分配私教套餐',67,'教练信息','coachs:coach:sjmeal',NULL,NULL,NULL,2,'el-icon-edit','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(377,'分配团操套餐',67,'教练信息','coachs:coach:tcmeal',NULL,NULL,NULL,2,'el-icon-edit','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(378,'查询',85,'客服信息管理','services:message:select',NULL,NULL,NULL,2,'el-icon-edit','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(379,'分配会员',85,'客服信息管理','services:message:sllotmember',NULL,NULL,NULL,2,'el-icon-edit','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(380,'分配潜在用户',85,'客服信息管理','services:message:sllotpotential',NULL,NULL,NULL,2,'el-icon-edit','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(381,'查看会员',85,'客服信息管理','services:message:selectmember',NULL,NULL,NULL,2,'el-icon-edit','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(382,'查看潜在用户',85,'客服信息管理','services:message:selectpotential',NULL,NULL,NULL,2,'el-icon-edit','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(383,'查询',87,'潜在用户回访列表','pay:prospect:select',NULL,NULL,NULL,2,'el-icon-edit','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(384,'回访',87,'潜在用户回访列表','pay:prospect:payprospect',NULL,NULL,NULL,2,'el-icon-edit','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(385,'查询',88,'会员回访列表','pay:member:select',NULL,NULL,NULL,2,'el-icon-edit','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(386,'回访',88,'会员回访列表','pay:member:paymember',NULL,NULL,NULL,2,'el-icon-edit','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(387,'查询',89,'会员回访记录','pay:memberecord:select',NULL,NULL,NULL,2,'el-icon-edit','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(388,'查询',90,'潜在用户回访记录','pay:prospectrecord:select',NULL,NULL,NULL,2,'el-icon-edit','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(389,'查询',96,'用户咨询','pay:counsult:select',NULL,NULL,NULL,2,'el-icon-edit','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(390,'新增',96,'用户咨询','pay:counsult:add',NULL,NULL,NULL,2,'el-icon-plus','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(391,'新增',101,'潜在用户管理','prospects:prospects:add',NULL,NULL,NULL,2,'el-icon-plus','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(392,'修改',101,'潜在用户管理','prospects:prospects:edit',NULL,NULL,NULL,2,'el-icon-edit','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(393,'删除',101,'潜在用户管理','prospects:prospects:delete',NULL,NULL,NULL,2,'el-icon-delete','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(394,'查询',101,'潜在用户管理','prospects:prospects:select',NULL,NULL,NULL,2,'el-icon-search','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(395,'删除',96,'用户咨询','pay:counsult:delete',NULL,NULL,NULL,2,'el-icon-edit','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(396,'删除',89,'会员回访记录','pay:memberecord:delete',NULL,NULL,NULL,2,'el-icon-edit','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(397,'删除',90,'潜在用户回访记录','pay:prospectrecord:delete',NULL,NULL,NULL,2,'el-icon-edit','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(398,'修改',87,'潜在用户回访列表','prospects:prospects:editById',NULL,NULL,NULL,2,'el-icon-edit','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0);
/*!40000 ALTER TABLE `sys_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role`
--

DROP TABLE IF EXISTS `sys_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_role` (
                            `id` bigint NOT NULL AUTO_INCREMENT COMMENT '角色编号',
                            `role_code` varchar(50) NOT NULL COMMENT '角色编码',
                            `role_name` varchar(50) NOT NULL COMMENT '角色名称',
                            `create_user` bigint DEFAULT NULL COMMENT '创建人',
                            `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                            `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
                            `remark` varchar(255) DEFAULT NULL COMMENT '备注',
                            `is_delete` tinyint DEFAULT '0' COMMENT '是否删除(0-未删除，1-已删除)',
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role`
--

LOCK TABLES `sys_role` WRITE;
/*!40000 ALTER TABLE `sys_role` DISABLE KEYS */;
INSERT INTO `sys_role` VALUES (1,'ROLE_SYSTEM','总经理',1,'2022-09-16 14:44:23','2022-09-16 14:44:23','持有最高权限',0),(2,'ROLE_SYSTEM','系统管理员',1,'2022-09-16 14:44:23','2022-09-16 14:44:23','拥有系统管理功能模块的权限',0),(3,'ROLE_RESOURCE','教练1',1,NULL,NULL,'拥有教练1功能权限',0),(4,'ROLE_SYSTEM','教练2',1,'2022-09-16 14:44:23','2022-09-16 14:44:23','拥有教练2功能权限',0),(5,'ROLE_SYSTEM','教练3',1,'2022-09-16 14:44:23','2022-09-16 14:44:23','拥有教练3功能权限',0),(7,'ROLE_RESOURCE','人事1',NULL,NULL,NULL,'拥有人事1功能权限',0),(8,'ROLE_SYSTEM','人事2',1,'2022-09-16 14:44:23','2022-09-16 14:44:23','拥有人事2功能权限',0),(9,'ROLE_SYSTEM','市场部经理',1,'2022-09-16 14:44:23','2022-09-16 14:44:23','拥有市场部管理功能模块的权限',0),(10,'ROLE_RESOURCE','财务部经理',NULL,NULL,NULL,'拥有财务部管理模块的功能权限',0),(11,'ROLE_SYSTEM','后勤部经理',1,'2022-09-16 14:44:23','2022-09-16 14:44:23','拥有后勤部管理模块的功能权限',0),(12,'ROLE_SYSTEM','教练部经理',1,'2022-09-16 14:44:23','2022-09-16 14:44:23','拥有教练部管理功能模块的权限',0),(13,'ROLE_SYSTEM','行政部经理',1,'2022-09-16 14:44:23','2022-09-16 14:44:23','拥有行政部管理功能模块的权限',0),(14,'ROLE_SYSTEM','维修一号',1,'2022-10-10 15:31:42','2022-10-10 15:31:42','维修',0),(15,'ROLE_SYSTEM','客户小8',1,'2022-10-10 22:58:46','2022-10-10 22:58:46','维护客户',0),(16,'ROLE_RESOURCE','教练欧阳',1,'2022-10-11 13:07:54','2022-10-11 13:37:01','教练欧阳',0),(17,'ROLE_SYSTEM','教练小',1,'2022-10-11 13:36:32','2022-10-11 13:36:32','教练',0),(18,'ROLE_SYSTEM','教练提米',1,'2022-10-11 13:36:54','2022-10-11 13:36:54','教练提米',0),(19,'ROLE_SYSTEM','教练李',1,'2022-10-11 13:38:20','2022-10-11 13:38:20','教练李',0),(20,'ROLE_SYSTEM','财务2号',1,'2022-10-12 16:02:01','2022-10-12 16:02:01','财务',0),(21,'renshi','renshi',2,'2022-10-17 16:34:34','2022-10-17 16:44:24','人事',0),(22,'fasdf','sdf',2,'2022-10-17 16:35:24','2022-10-17 16:48:45','sdf',1),(23,'sys_tem','维修刀哥',5,'2022-10-19 15:29:33','2022-10-19 15:29:33','后勤部维修刀哥',0),(24,'sys_lige','财务力哥',6,'2022-10-19 16:03:20','2022-10-19 16:03:20','财务力哥',0),(25,'kefu1','客服1号',2,'2022-10-19 17:16:49','2022-10-19 17:16:49','客服',0),(26,'kefu2','客服2',2,'2022-10-19 17:17:28','2022-10-19 17:17:28','客服',0),(27,'qiantai','前台',2,'2022-10-19 17:18:10','2022-10-19 17:18:10','前台',0);
/*!40000 ALTER TABLE `sys_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role_permission`
--

DROP TABLE IF EXISTS `sys_role_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_role_permission` (
                                       `role_Id` bigint NOT NULL COMMENT '角色ID',
                                       `permission_Id` bigint NOT NULL COMMENT '权限ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色权限关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role_permission`
--

LOCK TABLES `sys_role_permission` WRITE;
/*!40000 ALTER TABLE `sys_role_permission` DISABLE KEYS */;
INSERT INTO `sys_role_permission` VALUES (17,98),(17,70),(17,223),(17,224),(17,78),(17,255),(17,256),(17,99),(18,98),(18,70),(18,223),(18,224),(18,78),(18,255),(18,256),(18,99),(19,98),(19,70),(19,223),(19,224),(19,78),(19,255),(19,256),(19,99),(9,60),(9,61),(9,62),(9,63),(9,64),(9,91),(9,92),(9,344),(9,345),(9,346),(20,91),(20,92),(20,344),(20,345),(20,346),(16,98),(16,70),(16,223),(16,224),(16,78),(16,255),(16,256),(16,99),(1,1),(1,2),(1,3),(1,4),(1,5),(1,25),(1,6),(1,7),(1,8),(1,9),(1,23),(1,26),(1,10),(1,11),(1,12),(1,13),(1,24),(1,27),(1,14),(1,15),(1,16),(1,17),(1,28),(1,29),(1,30),(1,31),(1,32),(1,33),(1,301),(1,34),(1,35),(1,320),(1,321),(1,322),(1,323),(1,366),(1,367),(1,36),(1,324),(1,325),(1,326),(1,327),(1,368),(1,369),(1,37),(1,110),(1,111),(1,328),(1,329),(1,370),(1,371),(1,38),(1,115),(1,365),(1,39),(1,360),(1,361),(1,362),(1,363),(1,364),(1,41),(1,116),(1,42),(1,117),(1,119),(1,120),(1,43),(1,44),(1,121),(1,123),(1,124),(1,372),(1,373),(1,374),(1,45),(1,46),(1,125),(1,128),(1,375),(1,52),(1,53),(1,139),(1,140),(1,141),(1,142),(1,54),(1,143),(1,144),(1,145),(1,146),(1,55),(1,147),(1,148),(1,149),(1,150),(1,151),(1,152),(1,330),(1,65),(1,205),(1,206),(1,207),(1,208),(1,68),(1,213),(1,214),(1,215),(1,216),(1,94),(1,56),(1,57),(1,153),(1,154),(1,331),(1,58),(1,59),(1,157),(1,158),(1,93),(1,332),(1,333),(1,334),(1,318),(1,335),(1,336),(1,337),(1,338),(1,319),(1,340),(1,341),(1,60),(1,61),(1,62),(1,63),(1,64),(1,66),(1,67),(1,209),(1,210),(1,211),(1,212),(1,376),(1,377),(1,71),(1,72),(1,225),(1,226),(1,227),(1,228),(1,73),(1,229),(1,230),(1,231),(1,232),(1,342),(1,74),(1,234),(1,235),(1,236),(1,237),(1,343),(1,75),(1,238),(1,239),(1,240),(1,241),(1,76),(1,245),(1,246),(1,247),(1,248),(1,77),(1,249),(1,250),(1,251),(1,252),(1,81),(1,82),(1,258),(1,259),(1,260),(1,261),(1,83),(1,262),(1,263),(1,264),(1,265),(1,84),(1,85),(1,378),(1,379),(1,380),(1,381),(1,382),(1,86),(1,87),(1,383),(1,384),(1,398),(1,88),(1,385),(1,386),(1,89),(1,387),(1,396),(1,90),(1,388),(1,397),(1,96),(1,389),(1,390),(1,395),(1,91),(1,92),(1,344),(1,345),(1,346),(1,98),(1,70),(1,223),(1,224),(1,78),(1,255),(1,256),(1,99),(1,100),(1,101),(1,391),(1,392),(1,393),(1,394),(2,1),(2,2),(2,3),(2,4),(2,5),(2,25),(2,6),(2,7),(2,8),(2,9),(2,23),(2,26),(2,10),(2,11),(2,12),(2,13),(2,24),(2,27),(2,14),(2,15),(2,16),(2,17),(2,28),(2,29),(2,30),(2,31),(2,32),(2,33),(2,301),(15,86),(15,87),(15,383),(15,384),(15,398),(15,88),(15,385),(15,386),(15,89),(15,387),(15,396),(15,90),(15,388),(15,397),(15,96),(15,389),(15,390),(15,395),(14,59),(14,157),(14,158),(14,319),(14,340),(14,341),(14,58),(21,7),(21,8),(21,9),(21,26),(21,1),(21,6),(11,23),(11,26),(11,10),(11,11),(11,12),(11,13),(11,24),(11,27),(11,14),(11,15),(11,16),(11,17),(11,28),(11,29),(11,30),(11,31),(11,32),(11,33),(11,301),(11,52),(11,53),(11,139),(11,140),(11,141),(11,142),(11,54),(11,143),(11,144),(11,145),(11,146),(11,55),(11,147),(11,148),(11,149),(11,150),(11,151),(11,152),(11,330),(11,65),(11,205),(11,206),(11,207),(11,208),(11,68),(11,213),(11,214),(11,215),(11,216),(11,94),(11,56),(11,57),(11,153),(11,154),(11,331),(11,58),(11,59),(11,157),(11,158),(11,93),(11,332),(11,333),(11,334),(11,318),(11,335),(11,336),(11,337),(11,338),(11,319),(11,340),(11,341),(11,1),(11,6),(12,23),(12,26),(12,10),(12,11),(12,12),(12,13),(12,24),(12,27),(12,29),(12,30),(12,31),(12,32),(12,33),(12,301),(12,66),(12,67),(12,209),(12,210),(12,211),(12,212),(12,376),(12,377),(12,98),(12,70),(12,223),(12,224),(12,78),(12,255),(12,256),(12,99),(12,391),(12,392),(12,394),(12,1),(12,6),(12,100),(12,101),(23,56),(23,57),(23,153),(23,154),(23,331),(23,59),(23,157),(23,158),(23,318),(23,335),(23,336),(23,337),(23,338),(23,319),(23,340),(23,341),(23,58),(10,23),(10,26),(10,10),(10,11),(10,12),(10,13),(10,24),(10,27),(10,29),(10,30),(10,31),(10,32),(10,33),(10,301),(10,60),(10,61),(10,62),(10,63),(10,64),(10,91),(10,92),(10,344),(10,345),(10,346),(10,1),(10,6),(24,60),(24,61),(24,62),(24,63),(24,64),(24,91),(24,92),(24,344),(24,345),(24,346),(25,86),(25,87),(25,383),(25,384),(25,398),(25,88),(25,385),(25,386),(25,89),(25,387),(25,396),(25,90),(25,388),(25,397),(25,96),(25,389),(25,390),(25,395),(26,86),(26,87),(26,383),(26,384),(26,398),(26,88),(26,385),(26,386),(26,89),(26,387),(26,396),(26,90),(26,388),(26,397),(26,96),(26,389),(26,390),(26,395),(27,34),(27,35),(27,320),(27,321),(27,322),(27,323),(27,366),(27,367),(27,36),(27,324),(27,325),(27,326),(27,327),(27,368),(27,369),(27,37),(27,110),(27,111),(27,328),(27,329),(27,370),(27,371),(27,38),(27,115),(27,365),(27,39),(27,360),(27,361),(27,362),(27,363),(27,364),(27,41),(27,116),(27,42),(27,117),(27,119),(27,120),(27,43),(27,44),(27,121),(27,123),(27,124),(27,372),(27,373),(27,374),(27,45),(27,46),(27,125),(27,128),(27,375),(13,23),(13,26),(13,10),(13,11),(13,12),(13,13),(13,24),(13,27),(13,29),(13,30),(13,31),(13,32),(13,33),(13,301),(13,34),(13,35),(13,320),(13,321),(13,322),(13,323),(13,366),(13,367),(13,36),(13,324),(13,325),(13,326),(13,327),(13,368),(13,369),(13,37),(13,110),(13,111),(13,328),(13,329),(13,370),(13,371),(13,38),(13,115),(13,365),(13,39),(13,360),(13,361),(13,362),(13,363),(13,364),(13,41),(13,116),(13,42),(13,117),(13,119),(13,120),(13,43),(13,44),(13,121),(13,123),(13,124),(13,372),(13,373),(13,374),(13,45),(13,46),(13,125),(13,128),(13,375),(13,84),(13,85),(13,378),(13,379),(13,380),(13,381),(13,382),(13,86),(13,87),(13,383),(13,384),(13,398),(13,88),(13,385),(13,386),(13,89),(13,387),(13,396),(13,90),(13,388),(13,397),(13,96),(13,389),(13,390),(13,395),(13,100),(13,101),(13,391),(13,392),(13,393),(13,394),(13,1),(13,6);
/*!40000 ALTER TABLE `sys_role_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user`
--

DROP TABLE IF EXISTS `sys_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_user` (
                            `id` bigint NOT NULL AUTO_INCREMENT COMMENT '账户编号',
                            `emp_id` bigint DEFAULT NULL COMMENT '员工编号',
                            `username` varchar(50) NOT NULL COMMENT '登录名称(用户名)',
                            `password` varchar(100) NOT NULL COMMENT '登录密码',
                            `is_account_non_expired` tinyint NOT NULL COMMENT '帐户是否过期(1-未过期，0-已过期)',
                            `is_account_non_locked` tinyint NOT NULL COMMENT '帐户是否被锁定(1-未过期，0-已过期)',
                            `is_credentials_non_expired` tinyint NOT NULL COMMENT '密码是否过期(1-未过期，0-已过期)',
                            `is_enabled` tinyint NOT NULL COMMENT '帐户是否可用(1-可用，0-禁用)',
                            `department_id` bigint DEFAULT NULL COMMENT '所属部门ID',
                            `department_name` varchar(50) DEFAULT NULL COMMENT '所属部门名称',
                            `is_admin` tinyint NOT NULL COMMENT '是否是管理员(1-管理员)',
                            `create_user` bigint DEFAULT NULL COMMENT '创建人',
                            `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                            `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
                            `is_delete` tinyint DEFAULT '0' COMMENT '是否删除(0-未删除，1-已删除)',
                            PRIMARY KEY (`id`),
                            UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user`
--

LOCK TABLES `sys_user` WRITE;
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
INSERT INTO `sys_user` VALUES (1,1,'admin','$2a$10$TdEVQtGCkpo8L.jKjFB3/uxV5xkkDfiy0zoCa.ZS2yAXHe7H95OIC',1,1,1,1,1,'牛牛健身有限公司',1,1,NULL,NULL,0),(2,2,'liming','$2a$10$WwhJ8dBezfyMFIn19.ELru58K65k6N2tgewtv2sWdClKiRCjC55wG',1,1,1,1,2,'行政部',0,1,NULL,NULL,0),(3,3,'zhangsan','$2a$10$iBQbmrAEBE5B84/U3RY7c.zhObI4aIpjl807FV4LzL/uay7arIcpu',1,1,1,1,3,'人事部',0,1,NULL,NULL,1),(4,4,'lisi','$2a$10$QywHvELdRoFGiU6LKpd/X.LYpfaXETtS0pD4Nem2K3c0iMQwaZuAm',1,1,1,1,4,'市场部',0,1,NULL,NULL,0),(5,5,'wangwu','$2a$10$O8uyPZFS9PLfR8JN.aMRi.l/YeykYYuKH.cg/HBAR.N4NJeNg8hQK',1,1,1,1,5,'后勤部',0,1,NULL,NULL,0),(6,6,'zhaoliu','$2a$10$r45wkEYLHlteEr0KLI8y3.G506ylhQrEJkmGM.i2eHkcCnFvfbhCS',1,1,1,1,6,'财务部',0,1,NULL,NULL,0),(7,NULL,'renshi','$2a$10$l6xjk/Q4kIpkpJFs.byiD.ymCYUrw4YPxvhjS73ucyQWDp0TmVtL2',1,1,1,1,3,'人事部',0,1,'2022-10-09 20:44:23','2022-10-17 16:57:19',1),(8,50,'laowang','$2a$10$TaKF/S9jFd8Fa411EQJJF.3xYgghTFBZW8Lr2ALRJpXGNjBsI0kJ.',1,1,1,1,5,'后勤部',0,1,'2022-10-10 15:32:17','2022-10-10 15:33:47',0),(9,27,'xiaoba','$2a$10$kT6Oh9zrFz58nDmh/I.Zf.Utf1b6BfFbQ9UM.TDujPKxwcC8iZXom',1,1,1,1,3,'人事部',0,1,'2022-10-10 23:01:47','2022-10-10 23:02:07',0),(10,49,'ouyang','$2a$10$.qdQuN.W3wQTwpd5SiP1M.nfkFfEhTa.lSZzFITsTXPmtiKETGpK2',1,1,1,1,7,'教练部',0,1,'2022-10-11 13:06:56','2022-10-11 13:07:17',0),(11,14,'xiao','$2a$10$j0rANtwIit/NIkRQQB8CXOHfBET8gEx8yDVRGSpNK/MgSYXFuEQjC',1,1,1,1,7,'教练部',0,1,'2022-10-11 13:34:10','2022-10-11 13:35:19',0),(12,7,'timi','$2a$10$CoaUhyo/SCojNanjcjBaIepKMG4UqXJ..Xl8Rub4HswNsR1NGv13K',1,1,1,1,7,'教练部',0,1,'2022-10-11 13:34:35','2022-10-11 13:35:12',0),(13,11,'li','$2a$10$BX9uOQDSiiWI4CL3Dr.qa.c/H.sENVV3WlyoZHkgFLcFWd9feGSP2',1,1,1,1,7,'教练部',0,1,'2022-10-11 13:34:53','2022-10-12 20:50:06',0),(14,13,'zhao','$2a$10$ANRxKei.iOlE/aeMGM2zBuGM8kFI1c2UBj6TktVWpT2anE3TJnO2a',1,1,1,1,6,'财务部',0,1,'2022-10-12 11:39:32','2022-10-12 11:39:52',0),(15,51,'caiwu2','$2a$10$CpX2YOzcv7ZlYXv06hd/puJRJ0JCSxaEVTmQfLoLANaRyZV53EnKu',1,1,1,1,6,'财务部',0,1,'2022-10-12 16:01:14','2022-10-12 16:01:26',0),(16,52,'daoge','$2a$10$Kl1gmi.8N.KXEU2vJMuXbeDiv83LrItAMlZU2/IRHrdyvHQNderd.',1,1,1,1,5,'后勤部',0,5,'2022-10-19 15:28:24','2022-10-19 15:28:45',0),(17,53,'lige','$2a$10$sn0aJTwU8dg6rkU0Gjy6xO7yhJOwZb4PftTtRbRYbFIsxarLRD7uW',1,1,1,1,6,'财务部',0,6,'2022-10-19 16:01:43','2022-10-19 16:03:58',0),(18,55,'shisi','$2a$10$bp/kHZpADrE0rvSiYp5kQ.0CYqzdLrEnLEPGC3FQXk8isgWkvc/AK',1,1,1,1,2,'行政部',0,2,'2022-10-19 16:27:47','2022-10-19 17:26:38',0),(19,56,'xiaoshisi','$2a$10$W0b.6ealwWbg6RAr9Nl58O2RyxP1Mese7hijhkPikqDyC0eGwWk6W',1,1,1,1,2,'行政部',0,2,'2022-10-19 16:29:14','2022-10-19 17:26:51',0),(26,57,'shiwu','$2a$10$PBVlkHz5fJJdvkQ9tZsaO.raD4DtHCZWIhZ2ZdLGEaJy.ZADVXCdC',1,1,1,1,2,'行政部',0,2,'2022-10-19 17:09:14','2022-10-19 17:26:57',0);
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user_role`
--

DROP TABLE IF EXISTS `sys_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_user_role` (
                                 `user_id` bigint NOT NULL COMMENT '账户编号',
                                 `role_id` bigint NOT NULL COMMENT '角色编号'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='账户角色关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user_role`
--

LOCK TABLES `sys_user_role` WRITE;
/*!40000 ALTER TABLE `sys_user_role` DISABLE KEYS */;
INSERT INTO `sys_user_role` VALUES (4,10),(5,11),(6,10),(11,17),(13,19),(14,10),(15,20),(9,15),(8,14),(1,1),(10,16),(12,18),(7,21),(16,23),(17,24),(2,13),(26,26),(18,25),(19,27),(3,9);
/*!40000 ALTER TABLE `sys_user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `team_choose`
--

DROP TABLE IF EXISTS `team_choose`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `team_choose` (
                               `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
                               `team_id` bigint NOT NULL COMMENT '团操套餐编号',
                               `tp_id` bigint NOT NULL COMMENT '项目编号',
                               PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=209 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='团操套餐项目关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `team_choose`
--

LOCK TABLES `team_choose` WRITE;
/*!40000 ALTER TABLE `team_choose` DISABLE KEYS */;
INSERT INTO `team_choose` VALUES (99,37,13),(100,37,14),(101,37,15),(102,37,16),(103,37,17),(104,37,18),(105,37,19),(106,37,20),(107,37,21),(108,37,22),(109,36,13),(110,36,14),(111,36,15),(112,36,16),(113,36,17),(114,36,18),(115,36,19),(116,36,20),(117,36,21),(118,36,22),(119,34,13),(120,34,14),(121,34,15),(122,34,16),(123,34,17),(124,34,18),(125,34,19),(126,34,20),(127,34,21),(128,34,22),(129,29,13),(130,29,14),(131,29,15),(132,29,16),(133,29,17),(134,29,18),(135,29,19),(136,29,20),(137,29,21),(138,29,22),(139,24,13),(140,24,14),(141,24,15),(142,24,16),(143,24,17),(144,24,18),(145,24,19),(146,24,20),(147,24,21),(148,24,22),(149,25,13),(150,25,14),(151,25,15),(152,25,16),(153,25,17),(154,25,18),(155,25,19),(156,25,20),(157,25,21),(158,25,22),(159,26,13),(160,26,14),(161,26,15),(162,26,16),(163,26,17),(164,26,18),(165,26,19),(166,26,20),(167,26,21),(168,26,22),(169,27,13),(170,27,14),(171,27,15),(172,27,16),(173,27,17),(174,27,18),(175,27,19),(176,27,20),(177,27,21),(178,27,22),(179,28,13),(180,28,14),(181,28,15),(182,28,16),(183,28,17),(184,28,18),(185,28,19),(186,28,20),(187,28,21),(188,28,22),(189,38,13),(190,38,14),(191,38,15),(192,38,16),(193,38,17),(194,38,18),(195,38,19),(196,38,20),(197,38,21),(198,38,22),(199,38,13),(200,38,14),(201,38,15),(202,38,16),(203,38,17),(204,38,18),(205,38,19),(206,38,20),(207,38,27),(208,38,26);
/*!40000 ALTER TABLE `team_choose` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `team_coach`
--

DROP TABLE IF EXISTS `team_coach`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `team_coach` (
                              `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
                              `team_id` bigint NOT NULL COMMENT '团操套餐编号',
                              `emp_id` bigint DEFAULT NULL COMMENT '员工编号（教练编号）',
                              PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=104 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='团操套餐的教练关系表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `team_coach`
--

LOCK TABLES `team_coach` WRITE;
/*!40000 ALTER TABLE `team_coach` DISABLE KEYS */;
INSERT INTO `team_coach` VALUES (44,24,11),(45,25,11),(46,26,11),(47,27,11),(48,28,11),(49,29,11),(50,30,11),(51,31,11),(52,32,11),(53,33,11),(54,34,11),(55,35,11),(56,36,11),(57,37,11),(58,38,11),(59,24,49),(60,25,49),(61,26,49),(62,27,49),(63,28,49),(64,29,49),(65,30,49),(66,31,49),(67,32,49),(68,33,49),(69,34,49),(70,35,49),(71,36,49),(72,37,49),(73,38,49),(74,24,14),(75,25,14),(76,26,14),(77,27,14),(78,28,14),(79,29,14),(80,30,14),(81,31,14),(82,32,14),(83,33,14),(84,34,14),(85,35,14),(86,36,14),(87,37,14),(88,38,14),(89,24,19),(90,25,19),(91,26,19),(92,27,19),(93,28,19),(94,29,19),(95,30,19),(96,31,19),(97,32,19),(98,33,19),(99,34,19),(100,35,19),(101,36,19),(102,37,19),(103,38,19);
/*!40000 ALTER TABLE `team_coach` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `team_meal`
--

DROP TABLE IF EXISTS `team_meal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `team_meal` (
                             `team_id` bigint NOT NULL AUTO_INCREMENT COMMENT '团操套餐编号',
                             `team_time` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '套餐时长(一节,两节)',
                             `team_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '套餐生效时间',
                             `team_price` bigint NOT NULL COMMENT '套餐价格',
                             `team_is` tinyint DEFAULT '1' COMMENT '是否禁用(1-禁用,0-使用)',
                             `team_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '套餐名',
                             PRIMARY KEY (`team_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='团操会员套餐表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `team_meal`
--

LOCK TABLES `team_meal` WRITE;
/*!40000 ALTER TABLE `team_meal` DISABLE KEYS */;
INSERT INTO `team_meal` VALUES (24,'一天','2022-10-18 15:09:58',10,0,'团操套餐1'),(25,'两天','2022-10-18 15:10:07',20,0,'团操套餐2'),(26,'三天','2022-10-18 15:10:16',30,0,'团操套餐3'),(27,'四天','2022-10-18 15:10:29',40,0,'团操套餐4'),(28,'五天','2022-10-18 15:10:41',50,0,'团操套餐5'),(29,'六天','2022-10-18 15:11:17',60,0,'团操套餐6'),(30,'一周','2022-10-18 15:11:32',70,0,'团操套餐7'),(31,'两周','2022-10-18 15:11:46',140,0,'团操套餐8'),(32,'三周','2022-10-18 15:12:00',200,0,'团操套餐9'),(33,'一个月','2022-10-18 15:12:16',230,0,'团操套餐10'),(34,'两个月','2022-10-18 15:12:31',320,0,'团操套餐11'),(35,'四个月','2022-10-18 15:12:46',450,0,'团操套餐12'),(36,'五个月','2022-10-18 15:13:03',480,0,'团操套餐13'),(37,'六个月','2022-10-18 15:13:16',560,0,'团操套餐14'),(38,'九个月','2022-10-18 15:13:27',800,0,'团操套餐15');
/*!40000 ALTER TABLE `team_meal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `team_projectname`
--

DROP TABLE IF EXISTS `team_projectname`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `team_projectname` (
                                    `tp_id` bigint NOT NULL AUTO_INCREMENT COMMENT '项目编号',
                                    `tp_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '项目名称(动感单车或瑜伽...)',
                                    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                    `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
                                    `tp_is` tinyint DEFAULT '1' COMMENT '是否禁用(0-禁用,1-使用)',
                                    PRIMARY KEY (`tp_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='团操项目类型表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `team_projectname`
--

LOCK TABLES `team_projectname` WRITE;
/*!40000 ALTER TABLE `team_projectname` DISABLE KEYS */;
INSERT INTO `team_projectname` VALUES (13,'团操项目1','2022-10-18 14:56:23','2022-10-18 14:56:23',0),(14,'团操项目2','2022-10-18 14:56:32','2022-10-18 14:56:32',0),(15,'团操项目3','2022-10-18 14:56:36','2022-10-18 14:56:36',0),(16,'团操项目4','2022-10-18 14:56:40','2022-10-18 14:56:40',0),(17,'团操项目5','2022-10-18 14:56:45','2022-10-18 14:56:45',0),(18,'团操项目6','2022-10-18 14:56:49','2022-10-18 14:56:49',0),(19,'团操项目7','2022-10-18 14:56:52','2022-10-18 14:56:52',0),(20,'团操项目8','2022-10-18 14:56:57','2022-10-18 14:56:57',0),(21,'团操项目9','2022-10-18 14:57:03','2022-10-18 14:57:03',0),(22,'团操项目10','2022-10-18 14:57:09','2022-10-18 14:57:09',0),(23,'团操项目11','2022-10-18 14:57:14','2022-10-18 14:57:14',0),(24,'团操项目12','2022-10-18 14:57:19','2022-10-18 14:57:19',0),(25,'团操项目13','2022-10-18 14:57:25','2022-10-18 14:57:25',0),(26,'团操项目14','2022-10-18 14:57:30','2022-10-18 14:57:30',0),(27,'团操项目15','2022-10-18 14:57:34','2022-10-18 14:57:34',0);
/*!40000 ALTER TABLE `team_projectname` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `weixg`
--

DROP TABLE IF EXISTS `weixg`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `weixg` (
                         `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
                         `weixg_id` bigint NOT NULL COMMENT '维修工账户编号',
                         `weixg_name` varchar(255) NOT NULL COMMENT '维修工姓名',
                         `ee_id` bigint NOT NULL COMMENT '上报编号',
                         PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='维修工分配';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `weixg`
--

LOCK TABLES `weixg` WRITE;
/*!40000 ALTER TABLE `weixg` DISABLE KEYS */;
INSERT INTO `weixg` VALUES (2,8,'老王',4),(3,8,'老王',6),(4,16,'刀哥',7);
/*!40000 ALTER TABLE `weixg` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-10-19 21:23:31
