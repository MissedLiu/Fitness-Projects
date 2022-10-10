-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: db_test13
-- ------------------------------------------------------
-- Server version	8.0.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='会员客服分分配表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `allot_member`
--

LOCK TABLES `allot_member` WRITE;
/*!40000 ALTER TABLE `allot_member` DISABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='会员客服分分配表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `allot_prospect`
--

LOCK TABLES `allot_prospect` WRITE;
/*!40000 ALTER TABLE `allot_prospect` DISABLE KEYS */;
INSERT INTO `allot_prospect` VALUES (1,1,27);
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='黑名单表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `blacklist`
--

LOCK TABLES `blacklist` WRITE;
/*!40000 ALTER TABLE `blacklist` DISABLE KEYS */;
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
  `shenheemp_id` bigint NOT NULL COMMENT '审核人id',
  `state` tinyint NOT NULL DEFAULT '0' COMMENT '审核结果(0-待审,2-拒绝,1-同意)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='采购计划审核';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `caigou_shenhe`
--

LOCK TABLES `caigou_shenhe` WRITE;
/*!40000 ALTER TABLE `caigou_shenhe` DISABLE KEYS */;
INSERT INTO `caigou_shenhe` VALUES (1,47,6,1),(2,46,6,5),(3,44,6,1);
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='客服回访会员记录表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `callback_member`
--

LOCK TABLES `callback_member` WRITE;
/*!40000 ALTER TABLE `callback_member` DISABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `callback_prospect`
--

LOCK TABLES `callback_prospect` WRITE;
/*!40000 ALTER TABLE `callback_prospect` DISABLE KEYS */;
INSERT INTO `callback_prospect` VALUES (1,1,'亲爱的小赵同学.来我们牛牛健身房健身嘛','2022-10-10 23:04:57');
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
) ENGINE=InnoDB AUTO_INCREMENT=91 DEFAULT CHARSET=utf8 COMMENT='报损报溢表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `changenum`
--

LOCK TABLES `changenum` WRITE;
/*!40000 ALTER TABLE `changenum` DISABLE KEYS */;
INSERT INTO `changenum` VALUES (82,90,200,0,'2022-09-28 10:06:37'),(83,91,0,100,'2022-09-28 10:06:40'),(84,92,0,0,'2022-09-28 10:10:24'),(85,93,0,0,'2022-09-28 10:12:17'),(86,94,0,0,'2022-09-28 10:16:40'),(87,95,12,0,'2022-09-28 10:20:25'),(88,96,18,0,'2022-09-28 10:23:50'),(89,97,0,0,'2022-10-10 22:22:01'),(90,98,20,0,'2022-10-10 22:23:23');
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
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='所选项目表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `choose_projectname`
--

LOCK TABLES `choose_projectname` WRITE;
/*!40000 ALTER TABLE `choose_projectname` DISABLE KEYS */;
INSERT INTO `choose_projectname` VALUES (4,4,4,1,4),(6,6,6,1,6),(7,7,7,1,7),(8,8,8,1,8),(10,10,10,1,10),(11,11,11,1,11),(12,12,12,1,12),(16,16,1,1,1),(19,19,1,1,1),(22,22,1,1,1),(24,24,3,1,3),(26,19,1,1,1),(29,22,1,1,1),(31,24,3,1,3),(35,28,3,1,3),(36,31,2,1,2),(37,32,3,1,2),(38,33,3,14,14);
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='提成统计表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commission`
--

LOCK TABLES `commission` WRITE;
/*!40000 ALTER TABLE `commission` DISABLE KEYS */;
INSERT INTO `commission` VALUES (1,1,'小明','17680713872','牛牛健身有限公司',0.00,1.30,0.00,200.00,201,'2022-10-10 22:54:03');
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
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='普通会员套餐表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `common_meal`
--

LOCK TABLES `common_meal` WRITE;
/*!40000 ALTER TABLE `common_meal` DISABLE KEYS */;
INSERT INTO `common_meal` VALUES (6,'一天','2022-10-10 00:00:00','2022-10-10 21:38:51',10,0,'套餐2'),(7,'两天','2022-10-10 00:00:00','2022-10-10 21:38:54',10,0,'套餐3'),(8,'三天','2022-10-10 00:00:00','2022-10-10 21:38:58',1,0,'套餐5'),(9,'五天','2022-10-20 00:00:00','2022-10-10 21:40:13',13,0,'套餐4'),(10,'五天','2022-10-20 00:00:00','2022-10-10 21:40:10',13,1,'套餐1'),(11,'四天','2022-10-20 00:00:00','2022-10-10 21:40:06',13,0,'套餐6'),(12,'五天','2022-10-20 00:00:00','2022-10-10 21:39:12',13,0,'套餐7'),(18,'五个月','2022-09-23 14:02:47','2022-10-10 21:39:16',121,0,'套餐8'),(19,'五天','2022-10-10 21:39:36','2022-10-10 21:39:36',100,0,'套餐9'),(20,'六天','2022-10-10 21:39:46','2022-10-10 21:39:46',100,0,'套餐10'),(21,'四天','2022-10-10 21:40:01','2022-10-10 21:40:01',100,0,'套餐11');
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
  `compact_type` varchar(20) NOT NULL COMMENT '合同类型（私教，团操 ,普通）',
  `salesman` varchar(50) NOT NULL COMMENT '业务员',
  PRIMARY KEY (`compact_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='合同管理';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compact`
--

LOCK TABLES `compact` WRITE;
/*!40000 ALTER TABLE `compact` DISABLE KEYS */;
INSERT INTO `compact` VALUES (1,16,1,'2022-10-13 00:00:00','2022-10-10 00:00:00','https://liucz-bucket.oss-cn-hangzhou.aliyuncs.com/photoAddress/2022/10/10/eee8824c490840de83a9ee901d5d0dc4.jpg','私教','小刘');
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
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='消费记录表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comsune`
--

LOCK TABLES `comsune` WRITE;
/*!40000 ALTER TABLE `comsune` DISABLE KEYS */;
INSERT INTO `comsune` VALUES (1,13,7,'套餐二','普通',NULL,NULL,10,'2022-10-09 21:22:42'),(2,13,7,'套餐二','普通',NULL,NULL,10,'2022-10-09 21:22:47'),(3,13,7,'套餐二','普通',NULL,NULL,10,'2022-10-09 21:22:50'),(4,1,1,'套餐1','私教',1,'项目1',2333,'2022-10-09 21:24:21'),(5,2,2,'套餐2','私教',2,'项目2',13,'2022-10-09 21:24:28'),(6,1,7,'周卡1','普通',NULL,NULL,10,'2022-10-09 21:22:42'),(7,1,7,'周卡2','普通',NULL,NULL,10,'2022-10-09 21:22:42'),(8,1,7,'周卡3','普通',NULL,NULL,10,'2022-10-09 21:22:42'),(9,1,7,'周卡4','普通',NULL,NULL,10,'2022-10-09 21:22:42'),(10,1,7,'周卡5','普通',NULL,NULL,10,'2022-10-09 21:22:42'),(11,1,7,'周卡6','普通',NULL,NULL,10,'2022-10-09 21:22:42'),(12,1,7,'周卡3','团操',NULL,NULL,10,'2022-10-09 21:22:42'),(13,1,7,'周卡4','团操',NULL,NULL,10,'2022-10-09 21:22:42'),(14,1,7,'周卡5','团操',NULL,NULL,10,'2022-10-09 21:22:42'),(15,1,7,'周卡6','团操',NULL,NULL,10,'2022-10-09 21:22:42'),(16,1,2,'套餐2','私教',2,'项目2',13,'2022-10-10 22:31:33'),(17,1,2,'套餐2','私教',2,'项目2',13,'2022-10-10 22:31:39'),(18,1,2,'套餐2','私教',2,'项目2',13,'2022-10-10 22:33:15'),(19,5,14,'团操套餐2','团操',3,'项目2',100,'2022-10-10 22:37:27'),(21,14,9,'套餐4','普通',NULL,NULL,13,'2022-10-10 22:53:19');
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='支出统计报表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `disburse`
--

LOCK TABLES `disburse` WRITE;
/*!40000 ALTER TABLE `disburse` DISABLE KEYS */;
INSERT INTO `disburse` VALUES (1,'ass','2022-10-10 22:21:40',1200,'购入iphone1412*100sa'),(2,'手机','2022-10-10 22:23:12',100000,'购入oppo5100*1000台');
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='器材使用记录表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipment_details`
--

LOCK TABLES `equipment_details` WRITE;
/*!40000 ALTER TABLE `equipment_details` DISABLE KEYS */;
INSERT INTO `equipment_details` VALUES (1,95,'iphone14','001','2022-10-10 15:26:22','苹果',1,'苹果');
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='器材损坏上报表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipment_eamage`
--

LOCK TABLES `equipment_eamage` WRITE;
/*!40000 ALTER TABLE `equipment_eamage` DISABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='器材维修表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipment_maintenance`
--

LOCK TABLES `equipment_maintenance` WRITE;
/*!40000 ALTER TABLE `equipment_maintenance` DISABLE KEYS */;
INSERT INTO `equipment_maintenance` VALUES (1,'老王',1,'2022-10-10 00:00:00','001','漏机油',2,'iPhone14');
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='宣传活动记录表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flyer`
--

LOCK TABLES `flyer` WRITE;
/*!40000 ALTER TABLE `flyer` DISABLE KEYS */;
INSERT INTO `flyer` VALUES (1,'小刘','湖南株洲',1000,'小小2号',200,'2022-10-10 21:52:13');
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
  PRIMARY KEY (`healthForm_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='会员体检报告';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `healthform`
--

LOCK TABLES `healthform` WRITE;
/*!40000 ALTER TABLE `healthform` DISABLE KEYS */;
INSERT INTO `healthform` VALUES (1,3,'小小3',1,123,2112,234,234,342,234,234,234,234,4,24,24,24,24,233,243,234,243,43);
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='教练会员访谈记录表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `interview`
--

LOCK TABLES `interview` WRITE;
/*!40000 ALTER TABLE `interview` DISABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='发票记录表(商品收入统计)';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invoice`
--

LOCK TABLES `invoice` WRITE;
/*!40000 ALTER TABLE `invoice` DISABLE KEYS */;
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
INSERT INTO `locker` VALUES (1,1);
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='失物招领表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lose`
--

LOCK TABLES `lose` WRITE;
/*!40000 ALTER TABLE `lose` DISABLE KEYS */;
INSERT INTO `lose` VALUES (1,'手机','2022-10-09 00:00:00','已领取','DA','17680713872','2022-10-09 21:30:53'),(2,'毛衣','2022-10-10 00:00:00','已领取','复式','17680713875','2022-10-10 22:44:06');
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
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='会员表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` VALUES (1,'小小1',0,'2020-10-10 00:00:00','17680713819',12,'湖南',0,1,'2020-10-10 00:00:00','2022-10-10 22:52:20'),(3,'小小3',0,'2020-10-10 00:00:00','17680713874',12,'湖南',0,1,'2020-10-10 00:00:00','2022-10-10 22:38:29'),(4,'小小4',1,'2020-10-10 00:00:00','17680713875',12,'湖南',0,0,'2020-10-10 00:00:00','2022-10-10 00:00:00'),(5,'小小5',0,'2020-10-10 00:00:00','17680714876',12,'湖南',0,1,'2020-10-10 00:00:00','2022-10-10 22:37:27'),(6,'小小6',0,'2020-10-10 00:00:00','17680713877',12,'湖南',0,1,'2020-10-10 00:00:00','2022-10-10 22:40:08'),(7,'小小7',1,'2020-10-10 00:00:00','17680713878',12,'湖南',0,0,'2020-10-10 00:00:00','2022-10-10 00:00:00'),(8,'小小8',1,'2020-10-10 00:00:00','17680713879',12,'湖南',0,0,'2020-10-10 00:00:00','2022-10-10 00:00:00'),(9,'小小9',1,'2020-10-10 00:00:00','17680713811',12,'湖南',0,0,'2020-10-10 00:00:00','2022-10-10 00:00:00'),(10,'小小10',1,'2020-10-10 00:00:00','17680713823',12,'湖南',0,0,'2020-10-10 00:00:00','2022-10-09 21:20:02'),(11,'小小11',1,'2020-10-10 00:00:00','17680713834',12,'湖南',0,0,'2020-10-10 00:00:00','2022-10-09 21:19:57'),(12,'小小12',0,'2020-10-10 00:00:00','17680713845',12,'湖南',0,0,'2020-10-10 00:00:00','2022-10-10 00:00:00'),(14,'小赵',1,'2020-01-01 00:00:00','17680713872',34,'湖南株洲',0,1,'2022-10-10 22:52:55','2022-10-10 22:52:55');
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户咨询表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member_consult`
--

LOCK TABLES `member_consult` WRITE;
/*!40000 ALTER TABLE `member_consult` DISABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='会员办理套餐表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member_meal`
--

LOCK TABLES `member_meal` WRITE;
/*!40000 ALTER TABLE `member_meal` DISABLE KEYS */;
INSERT INTO `member_meal` VALUES (4,4,4,'私教','2020-10-10 00:00:00','2022-10-10 00:00:00'),(6,6,2,'团操','2020-10-10 00:00:00','2022-10-10 00:00:00'),(7,7,3,'团操','2020-10-10 00:00:00','2022-10-10 00:00:00'),(8,8,4,'团操','2020-10-10 00:00:00','2022-10-10 00:00:00'),(10,10,7,'团操','2020-10-10 00:00:00','2022-10-10 00:00:00'),(11,11,8,'团操','2020-10-10 00:00:00','2022-10-10 00:00:00'),(12,12,9,'团操','2020-10-10 00:00:00','2022-10-10 00:00:00'),(16,1,4,'私教','2020-10-10 00:00:00','2022-10-10 00:00:00'),(19,1,3,'团操','2020-10-10 00:00:00','2022-10-10 00:00:00'),(22,1,7,'团操','2020-10-10 00:00:00','2022-10-10 00:00:00'),(24,3,9,'团操','2020-10-10 00:00:00','2022-10-10 00:00:00'),(28,1,4,'私教','2020-10-10 00:00:00','2022-10-10 00:00:00'),(29,3,3,'私教','2020-10-10 00:00:00','2022-10-10 00:00:00'),(30,1,4,'私教','2020-10-10 00:00:00','2022-10-10 00:00:00'),(31,1,2,'私教','2022-10-10 22:31:33','2022-10-16 22:31:33'),(32,4,2,'私教','2022-10-10 22:33:10','2022-10-11 22:33:10'),(33,5,14,'团操','2022-10-10 22:37:23','2022-10-12 22:37:23'),(34,6,6,'普通','2022-10-10 22:39:28','2022-10-12 22:39:28'),(35,14,9,'普通','2022-10-10 22:53:19','2022-10-15 22:53:19');
/*!40000 ALTER TABLE `member_meal` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=99 DEFAULT CHARSET=utf8 COMMENT='物品已购表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `po`
--

LOCK TABLES `po` WRITE;
/*!40000 ALTER TABLE `po` DISABLE KEYS */;
INSERT INTO `po` VALUES (97,47,'iphone14',100,12,'苹果','as','as','2022-10-10 22:21:40','ass','已入库'),(98,44,'oppo5',1000,100,'oppo','中国','oppo','2022-10-10 22:23:12','手机','已入库');
/*!40000 ALTER TABLE `po` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proceeds`
--

DROP TABLE IF EXISTS `proceeds`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proceeds` (
  `proceeds_id` bigint NOT NULL COMMENT '编号',
  `meal_name` varchar(225) NOT NULL COMMENT '套餐名称',
  `p_name` varchar(225) NOT NULL COMMENT '项目名称',
  `meal_type` varchar(225) NOT NULL COMMENT '套餐类型',
  `proceeds_price` bigint NOT NULL COMMENT '金额',
  `proceeds_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`proceeds_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='套餐收入统计报表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proceeds`
--

LOCK TABLES `proceeds` WRITE;
/*!40000 ALTER TABLE `proceeds` DISABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='潜在用户记录表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prospect`
--

LOCK TABLES `prospect` WRITE;
/*!40000 ALTER TABLE `prospect` DISABLE KEYS */;
INSERT INTO `prospect` VALUES (1,'小赵','17680713872','湖南株洲','男',56,'普通意向',1);
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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='私教套餐项目关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pt_choose`
--

LOCK TABLES `pt_choose` WRITE;
/*!40000 ALTER TABLE `pt_choose` DISABLE KEYS */;
INSERT INTO `pt_choose` VALUES (1,1,2),(2,1,3),(3,1,4),(4,1,5),(5,2,2),(6,2,3),(7,2,4),(8,2,5);
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
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='私教套餐的教练关系表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pt_coach`
--

LOCK TABLES `pt_coach` WRITE;
/*!40000 ALTER TABLE `pt_coach` DISABLE KEYS */;
INSERT INTO `pt_coach` VALUES (1,1,1),(2,2,1),(3,3,1),(4,4,1),(5,5,1),(6,6,1),(7,7,1),(8,8,1),(9,9,1),(10,10,1),(11,11,1),(12,12,1),(13,2,14);
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
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='私教会员套餐表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pt_meal`
--

LOCK TABLES `pt_meal` WRITE;
/*!40000 ALTER TABLE `pt_meal` DISABLE KEYS */;
INSERT INTO `pt_meal` VALUES (1,'一天','2022-09-14 16:13:17',2333,1,'套餐1'),(2,'两天','2022-08-29 16:13:35',13,0,'套餐2'),(3,'三天','2022-09-23 16:17:10',123,0,'套餐3'),(7,'五天','2022-09-26 08:48:18',1,0,'套餐4'),(8,'四天','2022-09-26 08:48:52',9,0,'套餐5'),(9,'四天','2022-09-26 08:48:52',9,0,'套餐6'),(10,'五天','2022-09-26 08:48:52',9,0,'套餐7'),(11,'五天','2022-09-26 08:48:52',9,0,'套餐8'),(12,'五天','2022-09-26 08:48:52',9,0,'套餐9'),(13,'一周','2022-09-26 08:48:52',9,0,'套餐10'),(14,'五天','2022-09-26 08:48:52',9,0,'套餐11');
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
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='私教项目类型表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pt_projectname`
--

LOCK TABLES `pt_projectname` WRITE;
/*!40000 ALTER TABLE `pt_projectname` DISABLE KEYS */;
INSERT INTO `pt_projectname` VALUES (1,'项目1',1,'2022-09-13 00:00:00','2022-09-27 20:01:05'),(2,'项目2',0,'2022-09-26 00:00:00','2022-09-27 20:30:40'),(3,'项目3',0,'2022-09-26 00:00:00','2022-09-27 16:19:28'),(4,'项目4',0,'2022-09-26 00:00:00','2022-09-27 16:19:28'),(5,'项目5',0,'2022-09-26 00:00:00','2022-09-27 16:19:28'),(6,'项目6',0,'2022-09-26 00:00:00','2022-09-27 16:19:28'),(7,'项目7',0,'2022-09-26 00:00:00','2022-09-27 16:19:28'),(8,'项目8',0,'2022-09-26 00:00:00','2022-09-27 16:19:28'),(9,'项目9',0,'2022-09-26 00:00:00','2022-09-27 16:19:28'),(10,'项目10',0,'2022-09-26 00:00:00','2022-09-27 16:19:28'),(11,'项目11',0,'2022-09-26 00:00:00','2022-09-27 16:19:28'),(12,'项目12',0,'2022-09-26 00:00:00','2022-09-27 16:19:28');
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='课程销售记录表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sales`
--

LOCK TABLES `sales` WRITE;
/*!40000 ALTER TABLE `sales` DISABLE KEYS */;
INSERT INTO `sales` VALUES (1,1,2,'套餐2','小刘','17680713872',2,'项目2','私教',13,0,'2022-10-10 21:48:03','两天'),(2,1,2,'套餐2','小刘','17680713872',2,'项目2','私教',13,0,'2022-10-10 21:48:50','两天'),(3,1,2,'套餐2','小刘','17680713872',5,'项目5','私教',13,0,'2022-10-10 21:50:21','两天'),(4,1,14,'团操套餐2','小王','17680713872',6,'项目5','团操',100,0,'2022-10-10 21:50:44','一天'),(5,1,9,'套餐4','小赵','17680713872',NULL,NULL,'普通',13,0,'2022-10-10 21:50:55','五天'),(6,1,9,'套餐4','小赵','17680713872',NULL,NULL,'普通',13,2,'2022-10-10 21:50:55','五天');
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='商品销售记录表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sales_article`
--

LOCK TABLES `sales_article` WRITE;
/*!40000 ALTER TABLE `sales_article` DISABLE KEYS */;
INSERT INTO `sales_article` VALUES (1,1,30,'iphone14',20,2000,'2022-10-10 21:51:25','苹果',_binary '');
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
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8 COMMENT='物品采购计划表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedule`
--

LOCK TABLES `schedule` WRITE;
/*!40000 ALTER TABLE `schedule` DISABLE KEYS */;
INSERT INTO `schedule` VALUES (39,1,'vivoX100','手机','vivo公司','台','中国',120,1200,'vivo','2022-09-27 19:52:25',0),(44,1,'oppo5','手机','oppo','台','中国',1000,100,'oppo','2022-09-28 00:00:00',4),(45,1,'荣耀v100','手机','手机','台','手机',1000,100,'手机','2022-09-28 00:00:00',0),(46,1,'荣耀v100','1','1','1','1',1000,1,'手机','2022-09-28 09:41:54',3),(47,1,'iphone14','ass','as','sa','as',100,12,'苹果','2022-09-28 10:21:55',4);
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
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=utf8 COMMENT='物品入库表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stock_in`
--

LOCK TABLES `stock_in` WRITE;
/*!40000 ALTER TABLE `stock_in` DISABLE KEYS */;
INSERT INTO `stock_in` VALUES (63,90,'荣耀v100',300,'2022-09-28 10:06:37','手机','手机',1),(64,91,'荣耀v100',700,'2022-09-28 10:06:40','1','手机',1),(65,92,'华为mate88',50,'2022-09-28 10:10:24','手机','华为',1),(66,93,'oppo',1000,'2022-09-28 10:12:17','手机','oppo',1),(67,94,'vivoX100',100,'2022-09-28 10:16:40','手机','vivo',1),(68,95,'iphone14',88,'2022-09-28 10:20:25','手机','苹果',1),(69,96,'iphone14',2,'2022-09-28 10:23:50','ass','苹果',1),(70,97,'iphone14',100,'2022-10-10 22:22:01','ass','苹果',1),(71,98,'oppo5',980,'2022-10-10 22:23:23','手机','oppo',1);
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
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8 COMMENT='物品出库表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stock_out`
--

LOCK TABLES `stock_out` WRITE;
/*!40000 ALTER TABLE `stock_out` DISABLE KEYS */;
INSERT INTO `stock_out` VALUES (30,48,95,'iphone14',60,80,1,'手机','2022-10-10 15:24:52','苹果'),(31,49,98,'oppo5',80,80,1,'手机','2022-10-10 22:30:05','oppo');
/*!40000 ALTER TABLE `stock_out` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8 COMMENT='物品库存表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `store`
--

LOCK TABLES `store` WRITE;
/*!40000 ALTER TABLE `store` DISABLE KEYS */;
INSERT INTO `store` VALUES (44,90,'荣耀v100','2022-09-28 10:07:04',700,0,'手机','手机'),(45,92,'华为mate88','2022-09-28 10:10:24',50,50,'手机','华为'),(46,93,'oppo','2022-09-28 10:12:17',1000,1000,'手机','oppo'),(47,94,'vivoX100','2022-09-28 10:16:40',100,100,'手机','vivo'),(48,95,'iphone14','2022-10-10 22:22:01',100,110,'手机','苹果'),(49,98,'oppo5','2022-10-10 22:30:05',980,900,'手机','oppo');
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
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_emp`
--

LOCK TABLES `sys_emp` WRITE;
/*!40000 ALTER TABLE `sys_emp` DISABLE KEYS */;
INSERT INTO `sys_emp` VALUES (1,'小明',50,'男','株洲荷塘区','17680713872','https://manong-authority.oss-cn-guangzhou.aliyuncs.com/avatar/default-avatar.gif','2042975339@qq.com','2042975339','12345ss',1,'牛牛健身有限公司',NULL,NULL,'总经理','公司总负责人'),(2,'李明',30,'男','株洲荷塘区','17680713872','','2042975339@qq.com','2042975339','12345ss',2,'行政部',NULL,NULL,'行政部经理','行政部总负责人'),(3,'张三',25,'男','株洲荷塘区','17680713872','','2042975339@qq.com','2042975339','12345ss',3,'人事部',NULL,NULL,'人事部经理','人事部总负责人'),(4,'李四',24,'女','株洲荷塘区','17680713872','','2042975339@qq.com','2042975339','12345ss',4,'市场部',NULL,NULL,'市场部经理','市场部总负责人'),(5,'王五',26,'男','株洲荷塘区','17680713872','','2042975339@qq.com','2042975339','12345ss',5,'后勤部',NULL,NULL,'后勤部经理','后勤部总负责人'),(6,'赵六',34,'男','株洲荷塘区','17680713872','','2042975339@qq.com','2042975339','12345ss',6,'财务部',NULL,NULL,'财务部经理','财务部总负责人'),(7,'提米',34,'男','株洲荷塘区','17680713872','','2042975339@qq.com','2042975339','12345ss',7,'教练部',NULL,NULL,'教练部经理','教练部总负责人'),(9,'李',30,'男','株洲荷塘区','17680713872','','2042975339@qq.com','2042975339','12345ss',2,'行政部',NULL,NULL,'行政部副经理','行政部负责人'),(10,'张',25,'男','株洲荷塘区','17680713872','','2042975339@qq.com','2042975339','12345ss',3,'人事部',NULL,NULL,'人事部副经理','人事部负责人'),(11,'李',24,'女','株洲荷塘区','17680713872','','2042975339@qq.com','2042975339','12345ss',4,'市场部',NULL,NULL,'市场部副经理','市场部负责人'),(12,'王',26,'男','株洲荷塘区','17680713872','','2042975339@qq.com','2042975339','12345ss',5,'后勤部',NULL,NULL,'后勤部副经理','后勤部负责人'),(13,'赵',34,'男','株洲荷塘区','17680713872','','2042975339@qq.com','2042975339','12345ss',6,'财务部',NULL,NULL,'财务部副经理','财务部负责人'),(14,'小',50,'男','株洲荷塘区','17680713872','','2042975339@qq.com','2042975339','12345ss',7,'教练部',NULL,NULL,'教练','教练300年'),(15,'李',30,'男','株洲荷塘区','17680713872','','2042975339@qq.com','2042975339','12345ss',7,'教练部',NULL,NULL,'教练','教练300年'),(16,'张',25,'男','株洲荷塘区','17680713872','','2042975339@qq.com','2042975339','12345ss',7,'教练部',NULL,NULL,'教练','教练300年'),(17,'李',24,'女','株洲荷塘区','17680713872','','2042975339@qq.com','2042975339','12345ss',7,'教练部',NULL,NULL,'教练','教练300年'),(18,'王',26,'男','株洲荷塘区','17680713872','','2042975339@qq.com','2042975339','12345ss',7,'教练部',NULL,NULL,'教练','教练300年'),(19,'赵',34,'男','株洲荷塘区','17680713872','','2042975339@qq.com','2042975339','12345ss',7,'教练部',NULL,NULL,'教练','教练300年'),(20,'小1',34,'男','株洲荷塘区','17680713872','','2042975339@qq.com','2042975339','12345ss',7,'教练部',NULL,NULL,'教练部经理','教练部负责人'),(21,'小2',50,'男','株洲荷塘区','17680713872','','2042975339@qq.com','2042975339','12345ss',7,'教练部',NULL,NULL,'教练','教练300年'),(22,'小3',30,'男','株洲荷塘区','17680713872','','2042975339@qq.com','2042975339','12345ss',7,'教练部',NULL,NULL,'教练','教练300年'),(23,'小4',25,'男','株洲荷塘区','17680713872','','2042975339@qq.com','2042975339','12345ss',7,'教练部',NULL,NULL,'教练','教练300年'),(24,'小5',24,'女','株洲荷塘区','17680713872','','2042975339@qq.com','2042975339','12345ss',7,'教练部',NULL,NULL,'教练','教练300年'),(25,'小6',26,'男','株洲荷塘区','17680713872','','2042975339@qq.com','2042975339','12345ss',7,'教练部',NULL,NULL,'教练','教练300年'),(26,'小7',34,'男','株洲荷塘区','17680713872','','2042975339@qq.com','2042975339','12345ss',7,'教练部',NULL,NULL,'教练','教练300年'),(27,'小8',50,'男','株洲荷塘区','17680713872','','2042975339@qq.com','2042975339','12345ss',7,'市场部',NULL,NULL,'客服','客服300年'),(28,'小9',30,'男','株洲荷塘区','17680713872','','2042975339@qq.com','2042975339','12345ss',7,'市场部',NULL,NULL,'客服','客服300年'),(29,'小和',25,'男','株洲荷塘区','17680713872','','2042975339@qq.com','2042975339','12345ss',7,'市场部',NULL,NULL,'客服','客服300年'),(30,'小画',24,'女','株洲荷塘区','17680713872','','2042975339@qq.com','2042975339','12345ss',7,'市场部',NULL,NULL,'客服','客服300年'),(31,'小是',26,'男','株洲荷塘区','17680713872','','2042975339@qq.com','2042975339','12345ss',7,'市场部',NULL,NULL,'客服','客服300年'),(32,'小成',34,'男','株洲荷塘区','17680713872','','2042975339@qq.com','2042975339','12345ss',7,'市场部',NULL,NULL,'客服','客服300年'),(33,'阿飞',25,'男','株洲荷塘区','17680713872','','2042975339@qq.com','2042975339','12345ss',7,'后勤部',NULL,NULL,'后勤1','后勤1300年'),(34,'阿看',24,'女','株洲荷塘区','17680713872','','2042975339@qq.com','2042975339','12345ss',7,'后勤部',NULL,NULL,'后勤2','后勤1300年'),(35,'艾克',26,'男','株洲荷塘区','17680713872','','2042975339@qq.com','2042975339','12345ss',7,'后勤部',NULL,NULL,'后勤3','后勤1300年'),(36,'老刘',34,'男','株洲荷塘区','17680713872','','2042975339@qq.com','2042975339','12345ss',7,'后勤部',NULL,NULL,'后勤4','后勤1300年'),(37,'小猪1号',25,'男','株洲荷塘区','17680713872','','2042975339@qq.com','2042975339','12345ss',7,'财务部',NULL,NULL,'财务1','财务1300年'),(38,'小猪2号',24,'女','株洲荷塘区','17680713872','','2042975339@qq.com','2042975339','12345ss',7,'财务部',NULL,NULL,'财务2','财务1300年'),(39,'小猪3号',26,'男','株洲荷塘区','17680713872','','2042975339@qq.com','2042975339','12345ss',7,'财务部',NULL,NULL,'财务3','财务1300年'),(40,'小猪4号',34,'男','株洲荷塘区','17680713872','','2042975339@qq.com','2042975339','12345ss',7,'财务部',NULL,NULL,'财务4','财务1300年'),(41,'小猪5号',25,'男','株洲荷塘区','17680713872','','2042975339@qq.com','2042975339','12345ss',7,'市场部',NULL,NULL,'销售1','销售1300年'),(42,'小猪6号',24,'女','株洲荷塘区','17680713872','','2042975339@qq.com','2042975339','12345ss',7,'市场部',NULL,NULL,'销售2','销售1300年'),(43,'小猪7号',26,'男','株洲荷塘区','17680713872','','2042975339@qq.com','2042975339','12345ss',7,'市场部',NULL,NULL,'销售3','销售1300年'),(44,'小猪8号',34,'男','株洲荷塘区','17680713872','','2042975339@qq.com','2042975339','12345ss',7,'市场部',NULL,NULL,'销售4','销售1300年'),(45,'小猪9号',25,'男','株洲荷塘区','17680713872','','2042975339@qq.com','2042975339','12345ss',7,'人事部',NULL,NULL,'人事1','人事1300年'),(46,'小猪11号',24,'女','株洲荷塘区','17680713872','','2042975339@qq.com','2042975339','12345ss',7,'人事部',NULL,NULL,'人事2','人事1300年'),(47,'小猪12号',26,'男','株洲荷塘区','17680713872','','2042975339@qq.com','2042975339','12345ss',7,'人事部',NULL,NULL,'人事3','人事1300年'),(48,'小猪13号',34,'男','株洲荷塘区','17680713872','','2042975339@qq.com','2042975339','12345ss',7,'人事部',NULL,NULL,'人事4','人事1300年'),(49,'欧阳',21,'男','湖南株洲','17680713872','','2042975339@qq.com','5555555555','5555555555',7,'教练部','2022-10-10 11:21:29','2022-10-10 11:21:29','教练欧阳',''),(50,'老王',34,'男','株洲','17680713872','https://liucz-bucket.oss-cn-hangzhou.aliyuncs.com/avatar/2022/10/10/2c06e8f8cd734e729c2cff04f1892672.jpg','2042975339@qq.com','123456789','123456789',5,'后勤部','2022-10-10 15:30:33','2022-10-10 15:30:33','维修一号','阿达');
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
) ENGINE=InnoDB AUTO_INCREMENT=395 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_permission`
--

LOCK TABLES `sys_permission` WRITE;
/*!40000 ALTER TABLE `sys_permission` DISABLE KEYS */;
INSERT INTO `sys_permission` VALUES (1,'系统管理',0,'顶级菜单','sys:manager','/system','system','/system/system',0,'el-icon-menu','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,0,0),(2,'部门管理',1,'系统管理','sys:department','/department','department','/system/department/department',1,'el-icon-s-tools','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(3,'新增',2,'部门管理','sys:department:add',NULL,NULL,NULL,2,'el-icon-plus','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(4,'修改',2,'部门管理','sys:department:edit',NULL,NULL,NULL,2,'el-icon-edit','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(5,'删除',2,'部门管理','sys:department:delete',NULL,NULL,NULL,2,'el-icon-delete','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(6,'用户管理',1,'系统管理','s		ys:user','/userList','userList','/system/user/userList',1,'el-icon-s-custom','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(7,'新增',6,'用户管理','sys:emp:add',NULL,NULL,NULL,2,'el-icon-plus','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(8,'修改',6,'用户管理','sys:emp:edit',NULL,NULL,NULL,2,'el-icon-edit','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(9,'删除',6,'用户管理','sys:emp:delete',NULL,NULL,NULL,2,'el-icon-delete','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(10,'角色管理',1,'系统管理','sys:role','/roleList','roleList','/system/role/roleList',1,'el-icon-s-tools','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(11,'新增',10,'角色管理','sys:role:add',NULL,NULL,NULL,2,'el-icon-plus','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(12,'修改',10,'角色管理','sys:role:edit',NULL,NULL,NULL,2,'el-icon-edit','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(13,'删除',10,'角色管理','sys:role:delete',NULL,NULL,NULL,2,'el-icon-delete','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(14,'菜单管理',1,'系统管理','sys:menu','/menuList','menuList','/system/menu/menuList',1,'el-icon-s-tools','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(15,'新增',14,'权限管理','sys:menu:add',NULL,NULL,NULL,2,'el-icon-plus','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(16,'修改',14,'权限管理','sys:menu:edit',NULL,NULL,NULL,2,'el-icon-edit','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(17,'删除',14,'权限管理','sys:menu:delete',NULL,NULL,NULL,2,'el-icon-delete','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(23,'分配账号',6,'用户管理','sys:emp:user','','','',2,'el-icon-setting',NULL,NULL,NULL,NULL,0),(24,'分配权限',10,'角色管理','sys:role:assign','','','',2,'el-icon-setting',NULL,NULL,NULL,NULL,0),(25,'查询',2,'部门管理','sys:department:select','','','',2,'el-icon-search',NULL,NULL,NULL,NULL,0),(26,'查询',6,'用户管理','sys:user:select','','','',2,'el-icon-search',NULL,NULL,NULL,NULL,0),(27,'查询',10,'角色管理','sys:role:select','','','',2,'el-icon-search',NULL,NULL,NULL,NULL,0),(28,'查询',14,'菜单管理','sys:menu:select','','','',2,'el-icon-search',NULL,NULL,NULL,NULL,0),(29,'账号管理',1,'系统管理','sys:account','/account','account','/system/account/accountList',0,'el-icon-s-custom','2022-09-19 14:40:32','2022-09-19 14:40:32',NULL,0,0),(30,'新增',29,'账号管理','sys:account:add',NULL,NULL,NULL,2,'el-icon-plus','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(31,'修改',29,'账号管理','sys:account:edit',NULL,NULL,NULL,2,'el-icon-edit','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(32,'删除',29,'账号管理','sys:account:delete',NULL,NULL,NULL,2,'el-icon-delete','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(33,'查询',29,'账号管理','sys:account:select','','','',2,'el-icon-search',NULL,NULL,NULL,NULL,0),(34,'会员管理',0,'顶级菜单','members:members','/members','members','/members/members',0,'el-icon-menu','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,0,0),(35,'普通会员管理',34,'会员管理','members:ptmember','/ptmember','ptmember','/members/ptmember/ptmember',1,'el-icon-s-tools','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,0,0),(36,'私教会员管理',34,'会员管理','members:sjmember','/sjmember','sjmember','/members/sjmember/sjmember',1,'el-icon-s-tools','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,0,0),(37,'团操会员管理',34,'会员管理','members:tcmember','/tcmember','tcmember','/members/tcmember/tcmember',1,'el-icon-s-tools','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,0,0),(38,'黑白名单管理',34,'会员管理','members:blacklist','/blacklist','blacklist','/members/blacklist/blacklist',1,'el-icon-s-tools','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,0,0),(39,'会员列表管理',34,'会员管理','members:refinance','/refinance','refinance','/members/refinance/refinance',1,'el-icon-s-tools','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,0,0),(41,'消费记录管理',34,'会员管理','members:comsune','/comsune','comsune','/members/comsune/comsune',1,'el-icon-s-tools','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,0,0),(42,'合同管理',34,'会员管理','members:contract','/contract','contract','/members/contract/contract',1,'el-icon-s-tools','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,0,0),(43,'储物柜管理',0,'顶级菜单','lockers:lockers','/lockers','lockers','/lockers/lockers',0,'el-icon-menu','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,0,0),(44,'储物柜列表',43,'储物柜管理','lockers:locker','/locker','locker','/lockers/locker/locker',1,'el-icon-s-tools','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,0,0),(45,'失物招领管理',0,'顶级菜单','loses:loses','/loses','loses','/loses/loses',0,'el-icon-menu','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,0,0),(46,'失物列表',45,'失物招领管理','loses:lose','/lose','lose','/loses/lose/lose',1,'el-icon-s-tools','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,0,0),(52,'库存管理',0,'顶级菜单','stores:stores','/stores','stores','/stores/stores',0,'el-icon-s-custom','2022-09-20 15:40:57','2022-09-20 15:42:32',NULL,NULL,0),(53,'查看库存',52,'库存管理','stores:store','/storeList','storeList','/stores/store/storeList',1,'el-icon-s-custom','2022-09-20 15:45:00','2022-09-20 16:03:04',NULL,NULL,0),(54,'出库物品管理',52,'库存管理','stores:outStore','/outStoreList','outStoreList','/stores/store/outStoreList',1,'el-icon-s-custom','2022-09-20 15:51:44','2022-09-20 16:03:57',NULL,NULL,0),(55,'采购计划',52,'库存管理','stores:storePlanList','/storePlanList','storePlanList','/stores/store/storePlanList',1,'el-icon-s-custom','2022-09-20 16:13:15','2022-09-20 19:21:44',NULL,NULL,0),(56,'报修管理',0,'顶级菜单','repairs:repairs','/repairs','repairs','/repairs/repairs',0,'el-icon-s-custom','2022-09-20 16:20:35','2022-09-20 17:01:16',NULL,NULL,0),(57,'器材损坏上报',56,'报修管理','repairs:repair','/repairList','repairList','/repairs/repair/repairList',1,'el-icon-s-custom','2022-09-20 16:30:59','2022-09-20 19:47:05',NULL,NULL,0),(58,'器材管理',0,'顶级菜单','equipments:equipment','/equipments','equipment','/equipments/equipments',0,'el-icon-s-custom','2022-09-20 19:19:27','2022-09-20 19:19:52',NULL,NULL,0),(59,'器材维修记录',58,'器材管理','equipment:plan','/equipmentPlan','equipmentPlan','/equipments/equipment/equipmentPlan',1,'el-icon-s-custom','2022-09-20 19:21:31','2022-09-20 19:53:06',NULL,NULL,0),(60,'财务管理',0,'顶级菜单','finances:finances','/finances','finances','/finances/finances',0,'el-icon-s-custom','2022-09-20 19:44:11','2022-09-20 19:45:19',NULL,NULL,0),(61,'支出报表',60,'财务管理','finances:disburse','/disburseList','disburseList','/finances/finance/disburseList',1,'el-icon-s-custom','2022-09-20 19:46:31','2022-09-20 19:47:53',NULL,NULL,0),(62,'套餐收入报表',60,'财务管理','finances:proceeds','/proceedsList','proceedsList','/finances/finance/proceedsList',1,'el-icon-s-custom','2022-09-20 19:46:31','2022-09-20 19:47:53',NULL,NULL,0),(63,'商品收入报表',60,'财务管理','finances:invoice','/invoiceList','invoiceList','/finances/finance/invoiceList',1,'el-icon-s-custom','2022-09-20 19:46:31','2022-09-20 19:47:53',NULL,NULL,0),(64,'统计提成',60,'财务管理','finances:commission','/commissionList','commissionList','/finances/finance/commissionList',1,'el-icon-s-custom','2022-09-20 19:46:31','2022-09-20 19:47:53',NULL,NULL,0),(65,'已购物品管理',52,'库存管理','stores:po','/poList','poList','/stores/store/poList',1,'el-icon-s-custom','2022-09-21 09:21:41','2022-09-21 09:23:04',NULL,NULL,0),(66,'教练管理',0,'顶级菜单','coachs:coachs','/coachs','coachs','/coachs/coachs',0,'el-icon-menu','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(67,'教练信息',66,'教练管理','coachs:coach','/coach','coach','/coachs/coach/coachList',1,'el-icon-s-custom','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(70,'学员列表',98,'学员管理','students:student','/student','student','/students/student/studentList',1,'el-icon-menu','2022-04-25 14:40:32','2022-10-05 00:04:30',NULL,0,0),(71,'销售管理',0,'顶级菜单','sellgood:sellgood','/sellgood','sellgood','/sellgood/sellgood',0,'el-icon-s-tools','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(72,'普通套餐管理',71,'销售管理','sellgood:commonMeal','/commonMeal','commonMeal','/sellgood/commonMeal/commonMealList',1,'el-icon-s-tools','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(73,'私教套餐管理',71,'销售管理','sellgood:ptMeal','/ptMeal','ptMeal','/sellgood/ptMeal/ptMealList',1,'el-icon-s-tools','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(74,'团操套餐管理',71,'销售管理','sellgood:teamMeal','/teamMeal','teamMeal','/sellgood/teamMeal/teamMealList',1,'el-icon-s-tools','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(75,'课程销售',71,'销售管理','sellgood:classSell','/classSell','classSell','/sellgood/classSell/classSellList',1,'el-icon-s-tools','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(76,'商品销售',71,'销售管理','sellgood:sellgood','/sellgood','sellgood','/sellgood/sellgood/sellgoodList',1,'el-icon-s-tools','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(77,'活动安排',71,'销售管理','sellgood:activity','/activity','activity','/sellgood/activity/activityList',1,'el-icon-s-tools','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(78,'会员体检管理',98,'学员管理','students:healthForm','/healthForm','healthForm','/students/healthForm/healthForm',1,'el-icon-s-tools','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(81,'项目类型',0,'顶级菜单','projectname:projectname','/projectname','projectname','/projectname/projectname',0,'el-icon-s-tools','2022-04-25 14:40:32','2022-09-26 14:17:09',NULL,NULL,0),(82,'私教项目类型',81,'项目类型','projectname:ptPro','/ptPro','ptPro','/projectname/ptPro/ptProList',1,'el-icon-s-tools','2022-04-25 14:40:32','2022-09-26 14:19:26',NULL,NULL,0),(83,'团操项目类型',81,'项目类型','projectname:teamPro','/teamPro','teamPro','/projectname/teamPro/teamProList',1,'el-icon-s-tools','2022-04-25 14:40:32','2022-09-26 14:16:53',NULL,NULL,0),(84,'客服管理',0,'顶级菜单','services:services','/services','services','/services/services',0,'el-icon-menu','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,0,0),(85,'客服信息管理',84,'客服管理','services:message','/message','message','/services/message/message',1,'el-icon-s-tools','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,0,0),(86,'回访管理',0,'顶级菜单','pay:pay','/pay','pay','/pay/pay',0,'el-icon-menu','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,0,0),(87,'潜在用户回访列表',86,'回访管理','pay:prospect','/prospect','prospect','/pay/prospectlist/prospectlist',1,'el-icon-s-tools','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,0,0),(88,'会员回访列表',86,'回访管理','pay:memberlist','/memberlist','memberlist','/pay/memberlist/memberlist',1,'el-icon-s-tools','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,0,0),(89,'会员回访记录',86,'回访管理','pay:memberecord','/memberecord','memberecord','/pay/memberecord/memberecord',1,'el-icon-s-tools','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,0,0),(90,'潜在用户回访记录',86,'回访管理','pay:prospectrecord','/prospectrecord','prospectrecord','/pay/prospectrecord/prospectrecord',1,'el-icon-s-tools','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,0,0),(91,'审核管理',0,'顶级菜单','shenhes:shenhe','/shenhes','shenhes','/shenhes/shenhes',0,'el-icon-menu','2022-04-25 14:40:32','2022-10-05 00:04:30',NULL,0,0),(92,'采购审批',91,'审核管理','shenhes:caigou','/caigou','caigou','/shenhes/caigou/caigouList',1,'el-icon-menu','2022-04-25 14:40:32','2022-10-05 00:04:30',NULL,0,0),(93,'器材损坏管理',58,'器材管理','shenhes:baoxiu','/baoxiu','baoxiu','/shenhes/baoxiu/baoxiuList',1,'el-icon-menu','2022-04-25 14:40:32','2022-10-05 00:04:30',NULL,0,0),(94,'入库记录',52,'库存管理','store:inStock','/inStock','inStock','/stores/store/inStockList',1,'el-icon-s-tools','2022-09-25 21:22:21','2022-09-25 21:27:51',NULL,NULL,0),(96,'用户咨询',86,'回访管理','pay:counsult','/counsult','counsult','/pay/counsult/counsult',1,'el-icon-s-tools','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,0,0),(98,'学员管理',0,'顶级菜单','students:students','/students','students','/students/students',0,'el-icon-menu','2022-04-25 14:40:32','2022-10-05 00:04:30',NULL,0,0),(99,'访谈记录',98,'教练管理','students:interview','/interview','interview','/students/interview/interviewList',1,'el-icon-s-tools','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(100,'潜在用户管理',0,'顶级菜单','prospects:prospects','/prospects','prospects','/prospects/prospects',0,'el-icon-s-tools','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,0,0),(101,'潜在用户列表',100,'潜在用户管理','prospects:prospects','/prospects','prospects','/prospects/prospects/prospects',1,'el-icon-s-tools','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,0,0),(110,'删除',37,'团操会员管理','members:tcmember:delete',NULL,NULL,NULL,2,'el-icon-delete','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(111,'查询',37,'团操会员管理','members:tcmember:select',NULL,NULL,NULL,2,'el-icon-search','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(115,'查询',38,'黑白名单管理','members:blacklist:select',NULL,NULL,NULL,2,'el-icon-search','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(116,'查询',41,'消费记录管理','members:comsune:select',NULL,NULL,NULL,2,'el-icon-search','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(117,'新增',42,'合同管理','members:contract:add',NULL,NULL,NULL,2,'el-icon-plus','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(119,'删除',42,'合同管理','members:contract:delete',NULL,NULL,NULL,2,'el-icon-delete','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(120,'查询',42,'合同管理','members:contract:select',NULL,NULL,NULL,2,'el-icon-search','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(121,'新增',44,'储物柜列表','members:locker:add',NULL,NULL,NULL,2,'el-icon-plus','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(123,'删除',44,'储物柜列表','members:locker:delete',NULL,NULL,NULL,2,'el-icon-delete','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(124,'查询',44,'储物柜列表','members:locker:select',NULL,NULL,NULL,2,'el-icon-search','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(125,'新增',46,'失物列表','loses:lose:add',NULL,NULL,NULL,2,'el-icon-plus','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(128,'查询',46,'失物列表','loses:lose:select',NULL,NULL,NULL,2,'el-icon-search','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(139,'出库',53,'查看库存','stores:store:outStock',NULL,NULL,NULL,2,'el-icon-plus','2022-09-20 15:45:54','2022-10-10 09:27:21',NULL,NULL,0),(140,'修改',53,'查看库存','stores:store:edit',NULL,NULL,NULL,2,'el-icon-edit','2022-09-20 15:48:50','2022-09-20 15:50:23',NULL,NULL,0),(141,'删除',53,'查看库存','stores:store:delete','',NULL,NULL,2,'el-icon-delete','2022-09-20 15:49:15','2022-09-20 16:08:25',NULL,NULL,0),(142,'查询',53,'查看库存','stores:store:select',NULL,NULL,NULL,2,'el-icon-select','2022-09-20 15:50:19','2022-09-20 16:08:20',NULL,NULL,0),(143,'新增',54,'出库物品管理','stores:outStore:add',NULL,NULL,NULL,2,'el-icon-plus','2022-09-20 16:00:20','2022-09-20 16:08:33',NULL,NULL,0),(144,'修改',54,'出库物品管理','stores:outStore:edit',NULL,NULL,NULL,2,'el-icon-edit','2022-09-20 16:09:13','2022-09-20 16:09:13',NULL,NULL,0),(145,'删除',54,'出库物品管理','stores:outStore:delete',NULL,NULL,NULL,2,'el-icon-delete','2022-09-20 16:09:53','2022-09-20 16:09:53',NULL,NULL,0),(146,'查询',54,'出库物品管理','stores:outStore:select',NULL,NULL,NULL,2,'el-icon-select','2022-09-20 16:11:37','2022-09-20 16:11:37',NULL,NULL,0),(147,'新增',55,'采购计划','stores:plan:add',NULL,NULL,NULL,2,'el-icon-plus','2022-09-20 16:00:20','2022-09-20 16:08:33',NULL,NULL,0),(148,'修改',55,'采购计划','stores:plan:edit',NULL,NULL,NULL,2,'el-icon-edit','2022-09-20 16:09:13','2022-09-20 16:09:13',NULL,NULL,0),(149,'删除',55,'采购计划','stores:plan:delete',NULL,NULL,NULL,2,'el-icon-delete','2022-09-20 16:09:53','2022-09-20 16:09:53',NULL,NULL,0),(150,'查询',55,'采购计划','stores:plan:select',NULL,NULL,NULL,2,'el-icon-select','2022-09-20 16:11:37','2022-09-20 16:11:37',NULL,NULL,0),(151,'已购',55,'采购计划','stores:plan:toPo',NULL,NULL,NULL,2,'el-icon-select','2022-10-10 14:55:49','2022-10-10 14:59:34',NULL,NULL,0),(152,'审核',55,'采购计划','stores:plan:shenhe',NULL,NULL,NULL,2,'el-icon-select','2022-10-10 14:55:54','2022-10-10 15:11:29',NULL,NULL,0),(153,'删除',57,'器材损坏上报','repairs:record:delete',NULL,NULL,NULL,2,'el-icon-delete','2022-09-20 16:09:53','2022-10-10 11:02:15',NULL,NULL,0),(154,'上报',57,'器材损坏上报','repairs:record:add',NULL,NULL,NULL,2,'el-icon-select','2022-09-20 16:11:37','2022-10-10 15:20:11',NULL,NULL,0),(157,'删除',59,'器材维修记录','equipment:plan:delete',NULL,NULL,NULL,2,'el-icon-delete','2022-09-20 16:09:53','2022-10-10 11:18:45',NULL,NULL,0),(158,'查询',59,'器材维修记录','equipment:plan:select',NULL,NULL,NULL,2,'el-icon-select','2022-09-20 16:11:37','2022-10-10 15:25:30',NULL,NULL,0),(205,'入库',65,'已购物品管理','stores:po:toStore',NULL,NULL,NULL,2,'el-icon-plus','2022-09-20 16:00:20','2022-10-10 09:32:15',NULL,NULL,0),(206,'修改',65,'已购物品管理','stores:po:edit',NULL,NULL,NULL,2,'el-icon-edit','2022-09-20 16:09:13','2022-09-20 16:09:13',NULL,NULL,0),(207,'删除',65,'已购物品管理','stores:po:delete',NULL,NULL,NULL,2,'el-icon-delete','2022-09-20 16:09:53','2022-09-20 16:09:53',NULL,NULL,0),(208,'查询',65,'已购物品管理','stores:po:select',NULL,NULL,NULL,2,'el-icon-select','2022-09-20 16:11:37','2022-09-20 16:11:37',NULL,NULL,0),(209,'新增',67,'教练信息','coachs:coach:add',NULL,NULL,NULL,2,'el-icon-plus','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(210,'修改',67,'教练信息','coachs:coach:edit',NULL,NULL,NULL,2,'el-icon-edit','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(211,'删除',67,'教练信息','coachs:coach:delete',NULL,NULL,NULL,2,'el-icon-delete','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(212,'查询',67,'教练信息','coachs:coach:select','','','',2,'el-icon-search',NULL,NULL,NULL,NULL,0),(213,'新增',68,'课程安排','coachs:classArrange:add',NULL,NULL,NULL,2,'el-icon-plus','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(214,'修改',68,'课程安排','coachs:classArrange:edit',NULL,NULL,NULL,2,'el-icon-edit','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(215,'删除',68,'课程安排','coachs:classArrange:delete',NULL,NULL,NULL,2,'el-icon-delete','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(216,'查询',68,'课程安排','coachs:classArrange:select','','','',2,'el-icon-search',NULL,NULL,NULL,NULL,0),(217,'新增',69,'会员考勤管理','coachs:memcheck:add',NULL,NULL,NULL,2,'el-icon-plus','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(218,'修改',69,'会员考勤管理','coachs:memcheck:edit',NULL,NULL,NULL,2,'el-icon-edit','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(219,'删除',69,'会员考勤管理','coachs:memcheck:delete',NULL,NULL,NULL,2,'el-icon-delete','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(220,'查询',69,'会员考勤管理','coachs:memcheck:select','','','',2,'el-icon-search',NULL,NULL,NULL,NULL,0),(223,'删除',70,'访谈记录','coachs:interview:delete',NULL,NULL,NULL,2,'el-icon-delete','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(224,'查询',70,'访谈记录','coachs:interview:select','','','',2,'el-icon-search',NULL,NULL,NULL,NULL,0),(225,'新增',72,'普通套餐管理','sellgood:commonMeal:add',NULL,NULL,NULL,2,'el-icon-plus','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(226,'修改',72,'普通套餐管理','sellgood:commonMeal:edit',NULL,NULL,NULL,2,'el-icon-edit','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(227,'删除',72,'普通套餐管理','sellgood:commonMeal:delete',NULL,NULL,NULL,2,'el-icon-delete','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(228,'查询',72,'普通套餐管理','sellgood:commonMeal:select','','','',2,'el-icon-search',NULL,NULL,NULL,NULL,0),(229,'新增',73,'私教套餐管理','sellgood:ptMeal:add',NULL,NULL,NULL,2,'el-icon-plus','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(230,'修改',73,'私教套餐管理','sellgood:ptMeal:edit',NULL,NULL,NULL,2,'el-icon-edit','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(231,'删除',73,'私教套餐管理','sellgood:ptMeal:delete',NULL,NULL,NULL,2,'el-icon-delete','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(232,'查询',73,'私教套餐管理','sellgood:ptMeal:select','','','',2,'el-icon-search',NULL,NULL,NULL,NULL,0),(234,'新增',74,'团操套餐管理','sellgood:teamMeal:add',NULL,NULL,NULL,2,'el-icon-plus','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(235,'修改',74,'团操套餐管理','sellgood:teamMeal:edit',NULL,NULL,NULL,2,'el-icon-edit','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(236,'删除',74,'团操套餐管理','sellgood:teamMeal:delete',NULL,NULL,NULL,2,'el-icon-delete','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(237,'查询',74,'团操套餐管理','sellgood:teamMeal:select','','','',2,'el-icon-search',NULL,NULL,NULL,NULL,0),(238,'购买套餐',75,'课程销售','sellgood:classSell:getMeal',NULL,NULL,NULL,2,'el-icon-plus','2022-04-25 14:40:32','2022-10-10 19:37:25',NULL,NULL,0),(239,'查询',75,'课程销售','sellgood:classSell:select',NULL,NULL,NULL,2,'el-icon-edit','2022-04-25 14:40:32','2022-10-10 19:43:52',NULL,NULL,0),(240,'删除',75,'课程销售','sellgood:classSell:delete',NULL,NULL,NULL,2,'el-icon-delete','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(241,'查询',75,'课程管理','sellgood:classSell:select','','','',2,'el-icon-search',NULL,NULL,NULL,NULL,0),(245,'购买',76,'商品销售','sellgood:sellgood:add',NULL,NULL,NULL,2,'el-icon-plus','2022-04-25 14:40:32','2022-10-10 19:46:25',NULL,NULL,0),(246,'撤销购买',76,'商品销售','sellgood:sellgood:delete2',NULL,NULL,NULL,2,'el-icon-edit','2022-04-25 14:40:32','2022-10-10 19:46:42',NULL,NULL,0),(247,'删除',76,'商品销售','sellgood:sellgood:delete',NULL,NULL,NULL,2,'el-icon-delete','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(248,'查询',76,'商品销售','sellgood:sellgood:select','','','',2,'el-icon-search',NULL,NULL,NULL,NULL,0),(249,'新增',77,'活动安排','sellgood:activity:add',NULL,NULL,NULL,2,'el-icon-plus','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(250,'修改',77,'活动安排','sellgood:activity:edit',NULL,NULL,NULL,2,'el-icon-edit','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(251,'删除',77,'活动安排','sellgood:activity:delete',NULL,NULL,NULL,2,'el-icon-delete','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(252,'查询',77,'活动安排','sellgood:activity:select','','','',2,'el-icon-search',NULL,NULL,NULL,NULL,0),(255,'删除',78,'会员体检管理','healthForm:healthForm:delete',NULL,NULL,NULL,2,'el-icon-delete','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(256,'查询',78,'会员体检管理','healthForm:healthForm:select','','','',2,'el-icon-search',NULL,NULL,NULL,NULL,0),(258,'新增',82,'私教项目类型','projectname:ptPro:add',NULL,NULL,NULL,2,'el-icon-plus','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(259,'修改',82,'私教项目类型','projectname:ptPro:edit',NULL,NULL,NULL,2,'el-icon-edit','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(260,'删除',82,'私教项目类型','projectname:ptPro:delete',NULL,NULL,NULL,2,'el-icon-delete','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(261,'查询',82,'私教项目类型','projectname:ptPro:select',NULL,NULL,NULL,2,'el-icon-search','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(262,'新增',83,'团操项目类型','projectname:teamPro:add',NULL,NULL,NULL,2,'el-icon-plus','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(263,'修改',83,'团操项目类型','projectname:teamPro:edit',NULL,NULL,NULL,2,'el-icon-edit','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(264,'删除',83,'团操项目类型','projectname:teamPro:delete',NULL,NULL,NULL,2,'el-icon-delete','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(265,'查询',83,'团操项目类型','projectname:teamPro:select',NULL,NULL,NULL,2,'el-icon-search','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(301,'分配角色',29,'账号管理','sys:account:role','','','',2,'el-icon-eleme',NULL,NULL,NULL,NULL,0),(318,'器材使用记录',58,'器材管理','equipments:details','/details','details','/equipments/equipment/details',1,'el-icon-s-tools','2022-09-29 11:32:35','2022-09-29 14:00:23',NULL,NULL,0),(319,'器材损坏记录',58,'器材管理','equipments:sunhuai','/sunhuai','sunhuai','/equipments/equipment/sunhuai',1,'el-icon-s-tools','2022-09-29 11:32:35','2022-09-29 14:00:23',NULL,NULL,0),(320,'新增',35,'普通会员管理','members:ptmember:add',NULL,NULL,NULL,2,'el-icon-plus','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(321,'修改',35,'普通会员管理','members:ptmember:edit',NULL,NULL,NULL,2,'el-icon-edit','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(322,'删除',35,'普通会员管理','members:ptmember:delete',NULL,NULL,NULL,2,'el-icon-delete','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(323,'查询',35,'普通会员管理','members:ptmember:select',NULL,NULL,NULL,2,'el-icon-search','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(324,'新增',36,'私教会员管理','members:sjmember:add',NULL,NULL,NULL,2,'el-icon-plus','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(325,'修改',36,'私教会员管理','members:sjmember:edit',NULL,NULL,NULL,2,'el-icon-edit','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(326,'删除',36,'私教会员管理','members:sjmember:delete',NULL,NULL,NULL,2,'el-icon-delete','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(327,'查询',36,'私教会员管理','members:sjmember:select',NULL,NULL,NULL,2,'el-icon-search','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(328,'新增',37,'团操会员管理','members:tcmember:add',NULL,NULL,NULL,2,'el-icon-plus','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(329,'修改',37,'团操会员管理','members:tcmember:edit',NULL,NULL,NULL,2,'el-icon-edit','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(330,'撤销审核',55,'采购计划','stores:plan:cxshenhe',NULL,NULL,NULL,2,'el-icon-edit','2022-10-10 15:12:07','2022-10-10 15:12:10',NULL,NULL,0),(331,'查询',57,'器材损坏上报','repairs:record:select',NULL,NULL,NULL,2,'el-icon-edit','2022-10-10 15:20:51','2022-10-10 15:20:53',NULL,NULL,0),(332,'分配维修工',93,'器材损坏管理','shenhes:baoxiu:fenpei',NULL,NULL,NULL,2,'el-icon-edit','2022-10-10 15:29:19','2022-10-10 15:41:01',NULL,NULL,0),(333,'删除',93,'器材损坏管理','shenhes:baoxiu:delete',NULL,NULL,NULL,2,'el-icon-edit','2022-10-10 15:29:42','2022-10-10 15:30:03',NULL,NULL,0),(334,'查询',93,'器材损坏管理','shenhes:baoxiu:select',NULL,NULL,NULL,2,'el-icon-edit','2022-10-10 15:30:28','2022-10-10 15:30:31',NULL,NULL,0),(335,'查询',318,'器材使用记录','equipments:details:select',NULL,NULL,NULL,2,'el-icon-edit','2022-10-10 18:30:29','2022-10-10 18:30:47',NULL,NULL,0),(336,'新增',318,'器材使用记录','equipments:details:add',NULL,NULL,NULL,2,'el-icon-edit','2022-10-10 18:31:15','2022-10-10 18:43:14',NULL,NULL,0),(337,'修改',318,'器材使用记录','equipments:details:edit',NULL,NULL,NULL,2,'el-icon-edit','2022-10-10 18:32:06','2022-10-10 18:43:16',NULL,NULL,0),(338,'删除',318,'器材使用记录','equipments:details:delete',NULL,NULL,NULL,2,'el-icon-edit','2022-10-10 18:32:24','2022-10-10 18:43:18',NULL,NULL,0),(340,'查询',319,'器材损坏记录','equipments:sunhuai:delete',NULL,NULL,NULL,2,'el-icon-edit','2022-10-10 18:53:58','2022-10-10 18:54:21',NULL,NULL,0),(341,'修理',319,'器材损坏记录','equipments:sunhuai:xiuli',NULL,NULL,NULL,2,'el-icon-edit','2022-10-10 18:56:14','2022-10-10 18:56:28',NULL,NULL,0),(342,'选择项目',73,'私教套餐管理','sellgood:ptMeal:xuanze',NULL,NULL,NULL,2,'el-icon-edit','2022-10-10 19:13:55','2022-10-10 19:17:14',NULL,NULL,0),(343,'选择项目',74,'团操套餐管理','sellgood:teamMeal:xuanze',NULL,NULL,NULL,2,'el-icon-edit','2022-10-10 19:23:06','2022-10-10 19:23:08',NULL,NULL,0),(344,'处理审核',92,'采购审核管理','shenhes:caigou:cl',NULL,NULL,NULL,2,'el-icon-edit','2022-10-10 20:11:28','2022-10-10 20:11:50',NULL,NULL,0),(345,'删除',92,'采购审核管理','shenhes:caigou:delete',NULL,NULL,NULL,2,'el-icon-edit','2022-10-10 20:13:41','2022-10-10 20:14:07',NULL,NULL,0),(346,'查询',92,'采购审核管理','shenhes:caigou:select',NULL,NULL,NULL,2,'el-icon-edit','2022-10-10 20:14:44','2022-10-10 20:14:44',NULL,NULL,0),(360,'删除',39,'会员列表管理','members:refinance:delete',NULL,NULL,NULL,2,'el-icon-delete','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(361,'查询',39,'会员列表管理','members:refinance:select',NULL,NULL,NULL,2,'el-icon-search','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(362,'新增',39,'会员列表管理','members:refinance:add',NULL,NULL,NULL,2,'el-icon-plus','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(363,'修改',39,'会员列表管理','members:refinance:edit',NULL,NULL,NULL,2,'el-icon-edit','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(364,'加入黑名单',39,'会员列表管理','members:refinance:addblack',NULL,NULL,NULL,2,'el-icon-plus','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(365,'移除黑名单',38,'黑白名单管理','members:blacklist:delete',NULL,NULL,NULL,2,'el-icon-delete','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(366,'续费',35,'普通会员管理','members:ptmember:xufei',NULL,NULL,NULL,2,'el-icon-plus','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(367,'详情',35,'普通会员管理','members:ptmember:xiangqing',NULL,NULL,NULL,2,'el-icon-delete','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(368,'续费',36,'私教会员管理','members:sjmember:xufei',NULL,NULL,NULL,2,'el-icon-plus','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(369,'详情',36,'私教会员管理','members:sjmember:xiangqing',NULL,NULL,NULL,2,'el-icon-delete','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(370,'续费',37,'团操会员管理','members:tcmember:xufei',NULL,NULL,NULL,2,'el-icon-plus','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(371,'详情',37,'团操会员管理','members:tcmember:xiangqing',NULL,NULL,NULL,2,'el-icon-delete','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(372,'查询空储物柜',44,'储物柜列表','members:locker:selectnull',NULL,NULL,NULL,2,'el-icon-search','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(373,'添加会员',44,'储物柜列表','members:locker:addmember',NULL,NULL,NULL,2,'el-icon-search','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(374,'移除会员',44,'储物柜列表','members:locker:deletemember',NULL,NULL,NULL,2,'el-icon-search','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(375,'领取',46,'失物列表','loses:lose:get',NULL,NULL,NULL,2,'el-icon-plus','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(376,'分配私教套餐',67,'教练信息','coachs:coach:sjmeal',NULL,NULL,NULL,2,'el-icon-edit','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(377,'分配团操套餐',67,'教练信息','coachs:coach:tcmeal',NULL,NULL,NULL,2,'el-icon-edit','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(378,'查询',85,'客服信息管理','services:message:select',NULL,NULL,NULL,2,'el-icon-edit','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(379,'分配会员',85,'客服信息管理','services:message:sllotmember',NULL,NULL,NULL,2,'el-icon-edit','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(380,'分配潜在用户',85,'客服信息管理','services:message:sllotpotential',NULL,NULL,NULL,2,'el-icon-edit','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(381,'查看会员',85,'客服信息管理','services:message:selectmember',NULL,NULL,NULL,2,'el-icon-edit','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(382,'查看潜在用户',85,'客服信息管理','services:message:selectpotential',NULL,NULL,NULL,2,'el-icon-edit','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(383,'查询',87,'潜在用户回访列表','pay:prospect:select',NULL,NULL,NULL,2,'el-icon-edit','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(384,'回访',87,'潜在用户回访列表','pay:prospect:payprospect',NULL,NULL,NULL,2,'el-icon-edit','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(385,'查询',88,'会员回访列表','pay:member:select',NULL,NULL,NULL,2,'el-icon-edit','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(386,'回访',88,'会员回访列表','pay:member:paymember',NULL,NULL,NULL,2,'el-icon-edit','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(387,'查询',89,'会员回访记录','pay:memberecord:select',NULL,NULL,NULL,2,'el-icon-edit','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(388,'查询',90,'潜在用户回访记录','pay:prospectrecord:select',NULL,NULL,NULL,2,'el-icon-edit','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(389,'查询',96,'用户咨询','pay:counsult:select',NULL,NULL,NULL,2,'el-icon-edit','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(390,'新增',96,'用户咨询','pay:counsult:add',NULL,NULL,NULL,2,'el-icon-plus','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(391,'新增',101,'潜在用户管理','prospects:prospects:add',NULL,NULL,NULL,2,'el-icon-plus','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(392,'修改',101,'潜在用户管理','prospects:prospects:edit',NULL,NULL,NULL,2,'el-icon-edit','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(393,'删除',101,'潜在用户管理','prospects:prospects:delete',NULL,NULL,NULL,2,'el-icon-delete','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0),(394,'查询',101,'潜在用户管理','prospects:prospects:select',NULL,NULL,NULL,2,'el-icon-search','2022-04-25 14:40:32','2022-04-25 14:40:32',NULL,NULL,0);
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
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role`
--

LOCK TABLES `sys_role` WRITE;
/*!40000 ALTER TABLE `sys_role` DISABLE KEYS */;
INSERT INTO `sys_role` VALUES (1,'ROLE_SYSTEM','总经理',1,'2022-09-16 14:44:23','2022-09-16 14:44:23','持有最高权限',0),(2,'ROLE_SYSTEM','系统管理员',1,'2022-09-16 14:44:23','2022-09-16 14:44:23','拥有系统管理功能模块的权限',0),(3,'ROLE_RESOURCE','教练1',1,NULL,NULL,'拥有教练1功能权限',0),(4,'ROLE_SYSTEM','教练2',1,'2022-09-16 14:44:23','2022-09-16 14:44:23','拥有教练2功能权限',0),(5,'ROLE_SYSTEM','教练3',1,'2022-09-16 14:44:23','2022-09-16 14:44:23','拥有教练3功能权限',0),(7,'ROLE_RESOURCE','人事1',NULL,NULL,NULL,'拥有人事1功能权限',0),(8,'ROLE_SYSTEM','人事2',1,'2022-09-16 14:44:23','2022-09-16 14:44:23','拥有人事2功能权限',0),(9,'ROLE_SYSTEM','市场部经理',1,'2022-09-16 14:44:23','2022-09-16 14:44:23','拥有市场部管理功能模块的权限',0),(10,'ROLE_RESOURCE','财务部经理',NULL,NULL,NULL,'拥有财务部管理模块的功能权限',0),(11,'ROLE_SYSTEM','后勤部经理',1,'2022-09-16 14:44:23','2022-09-16 14:44:23','拥有后勤部管理模块的功能权限',0),(12,'ROLE_SYSTEM','教练部经理',1,'2022-09-16 14:44:23','2022-09-16 14:44:23','拥有教练部管理功能模块的权限',0),(13,'ROLE_SYSTEM','行政部经理',1,'2022-09-16 14:44:23','2022-09-16 14:44:23','拥有行政部管理功能模块的权限',0),(14,'ROLE_SYSTEM','维修一号',1,'2022-10-10 15:31:42','2022-10-10 15:31:42','维修',0),(15,'ROLE_SYSTEM','客户小8',1,'2022-10-10 22:58:46','2022-10-10 22:58:46','维护客户',0);
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
INSERT INTO `sys_role_permission` VALUES (14,59),(14,319),(14,58),(10,91),(10,92),(10,344),(10,345),(10,346),(1,1),(1,2),(1,3),(1,4),(1,5),(1,25),(1,6),(1,7),(1,8),(1,9),(1,23),(1,26),(1,10),(1,11),(1,12),(1,13),(1,24),(1,27),(1,14),(1,15),(1,16),(1,17),(1,28),(1,29),(1,30),(1,31),(1,32),(1,33),(1,301),(1,34),(1,35),(1,320),(1,321),(1,322),(1,323),(1,366),(1,367),(1,36),(1,324),(1,325),(1,326),(1,327),(1,368),(1,369),(1,37),(1,110),(1,111),(1,328),(1,329),(1,370),(1,371),(1,38),(1,115),(1,365),(1,39),(1,360),(1,361),(1,362),(1,363),(1,364),(1,41),(1,116),(1,42),(1,117),(1,119),(1,120),(1,43),(1,44),(1,121),(1,123),(1,124),(1,372),(1,373),(1,374),(1,45),(1,46),(1,125),(1,128),(1,375),(1,52),(1,53),(1,139),(1,140),(1,141),(1,142),(1,54),(1,143),(1,144),(1,145),(1,146),(1,55),(1,147),(1,148),(1,149),(1,150),(1,151),(1,152),(1,330),(1,65),(1,205),(1,206),(1,207),(1,208),(1,94),(1,56),(1,57),(1,153),(1,154),(1,331),(1,58),(1,59),(1,157),(1,158),(1,93),(1,332),(1,333),(1,334),(1,318),(1,335),(1,336),(1,337),(1,338),(1,319),(1,340),(1,341),(1,60),(1,61),(1,62),(1,63),(1,64),(1,66),(1,67),(1,209),(1,210),(1,211),(1,212),(1,376),(1,377),(1,71),(1,72),(1,225),(1,226),(1,227),(1,228),(1,73),(1,229),(1,230),(1,231),(1,232),(1,342),(1,74),(1,234),(1,235),(1,236),(1,237),(1,343),(1,75),(1,238),(1,239),(1,240),(1,241),(1,76),(1,245),(1,246),(1,247),(1,248),(1,77),(1,249),(1,250),(1,251),(1,252),(1,81),(1,82),(1,258),(1,259),(1,260),(1,261),(1,83),(1,262),(1,263),(1,264),(1,265),(1,84),(1,85),(1,378),(1,379),(1,380),(1,381),(1,382),(1,86),(1,87),(1,383),(1,384),(1,88),(1,385),(1,386),(1,89),(1,387),(1,90),(1,388),(1,96),(1,389),(1,390),(1,91),(1,92),(1,344),(1,345),(1,346),(1,98),(1,70),(1,223),(1,224),(1,78),(1,255),(1,256),(1,99),(1,100),(1,101),(1,391),(1,392),(1,393),(1,394),(15,378),(15,381),(15,382),(15,87),(15,383),(15,384),(15,90),(15,388),(15,96),(15,389),(15,390),(15,84),(15,85),(15,86);
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
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_delete` tinyint DEFAULT '0' COMMENT '是否删除(0-未删除，1-已删除)',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user`
--

LOCK TABLES `sys_user` WRITE;
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
INSERT INTO `sys_user` VALUES (1,1,'admin','$2a$10$TdEVQtGCkpo8L.jKjFB3/uxV5xkkDfiy0zoCa.ZS2yAXHe7H95OIC',1,1,1,1,1,'牛牛健身有限公司',1,NULL,NULL,0),(2,2,'liming','$2a$10$WwhJ8dBezfyMFIn19.ELru58K65k6N2tgewtv2sWdClKiRCjC55wG',1,1,1,1,2,'行政部',0,NULL,NULL,0),(3,3,'zhangsan','$2a$10$iBQbmrAEBE5B84/U3RY7c.zhObI4aIpjl807FV4LzL/uay7arIcpu',1,1,1,1,3,'人事部',0,NULL,NULL,1),(4,4,'lisi','$2a$10$QywHvELdRoFGiU6LKpd/X.LYpfaXETtS0pD4Nem2K3c0iMQwaZuAm',1,1,1,1,4,'市场部',0,NULL,NULL,0),(5,5,'wangwu','$2a$10$O8uyPZFS9PLfR8JN.aMRi.l/YeykYYuKH.cg/HBAR.N4NJeNg8hQK',1,1,1,1,5,'后勤部',0,NULL,NULL,0),(6,6,'zhaoliu','$2a$10$r45wkEYLHlteEr0KLI8y3.G506ylhQrEJkmGM.i2eHkcCnFvfbhCS',1,1,1,1,6,'财务部',0,NULL,NULL,0),(7,NULL,'renshi','$2a$10$l6xjk/Q4kIpkpJFs.byiD.ymCYUrw4YPxvhjS73ucyQWDp0TmVtL2',1,1,1,1,3,'人事部',0,'2022-10-09 20:44:23','2022-10-09 20:44:23',0),(8,50,'laowang','$2a$10$TaKF/S9jFd8Fa411EQJJF.3xYgghTFBZW8Lr2ALRJpXGNjBsI0kJ.',1,1,1,1,5,'后勤部',0,'2022-10-10 15:32:17','2022-10-10 15:33:47',0),(9,27,'xiaoba','$2a$10$kT6Oh9zrFz58nDmh/I.Zf.Utf1b6BfFbQ9UM.TDujPKxwcC8iZXom',1,1,1,1,3,'人事部',0,'2022-10-10 23:01:47','2022-10-10 23:02:07',0);
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
INSERT INTO `sys_user_role` VALUES (1,1),(2,2),(3,9),(4,10),(5,11),(8,14),(6,10),(9,15);
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
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='团操套餐项目关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `team_choose`
--

LOCK TABLES `team_choose` WRITE;
/*!40000 ALTER TABLE `team_choose` DISABLE KEYS */;
INSERT INTO `team_choose` VALUES (2,2,1),(3,3,1),(4,4,1),(5,5,1),(6,6,1),(7,7,1),(8,8,1),(9,9,1),(10,10,1),(11,11,1),(12,1,3),(13,1,4),(14,1,5),(15,1,6),(21,14,3),(22,14,4),(23,14,5),(24,14,6),(25,14,7);
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='团操套餐的教练关系表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `team_coach`
--

LOCK TABLES `team_coach` WRITE;
/*!40000 ALTER TABLE `team_coach` DISABLE KEYS */;
INSERT INTO `team_coach` VALUES (1,14,14),(2,15,14),(3,16,14),(4,17,14);
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
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='团操会员套餐表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `team_meal`
--

LOCK TABLES `team_meal` WRITE;
/*!40000 ALTER TABLE `team_meal` DISABLE KEYS */;
INSERT INTO `team_meal` VALUES (1,'两天','2022-09-06 22:59:06',100,1,'团操套餐1'),(14,'一天','2022-10-10 21:42:56',100,0,'团操套餐2'),(15,'两天','2022-10-10 21:43:15',100,0,'团操套餐3'),(16,'两天','2022-10-10 21:43:27',100,0,'团操套餐4'),(17,'两天','2022-10-10 21:43:41',100,0,'团操套餐5'),(18,'两天','2022-10-10 21:43:55',100,0,'团操套餐6'),(19,'两天','2022-10-10 21:44:08',100,0,'团操套餐7'),(20,'五天','2022-10-10 21:44:19',100,0,'团操套餐8'),(21,'两天','2022-10-10 21:44:32',100,0,'团操套餐9'),(22,'五天','2022-10-10 21:44:44',100,0,'团操套餐22');
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
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='团操项目类型表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `team_projectname`
--

LOCK TABLES `team_projectname` WRITE;
/*!40000 ALTER TABLE `team_projectname` DISABLE KEYS */;
INSERT INTO `team_projectname` VALUES (1,'项目1','2022-09-12 00:00:00','2022-10-10 21:45:29',1),(3,'项目2','2022-09-26 16:04:04','2022-09-26 16:04:04',0),(4,'项目3','2022-09-26 16:04:09','2022-09-26 16:04:09',0),(5,'项目4','2022-09-26 16:04:14','2022-09-26 16:04:14',0),(6,'项目5','2022-09-15 00:00:00','2022-09-26 20:43:55',0),(7,'项目6','2022-09-12 00:00:00','2022-09-26 19:18:26',0),(8,'项目7','2022-09-26 16:04:04','2022-09-26 16:04:04',0),(9,'项目8','2022-09-26 00:00:00','2022-10-10 21:45:33',0),(10,'项目9','2022-09-26 16:04:14','2022-09-26 16:04:14',0),(11,'项目10','2022-09-15 00:00:00','2022-10-10 21:45:35',0),(12,'项目11','2022-09-26 00:00:00','2022-10-10 21:45:39',0);
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='维修工分配';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `weixg`
--

LOCK TABLES `weixg` WRITE;
/*!40000 ALTER TABLE `weixg` DISABLE KEYS */;
INSERT INTO `weixg` VALUES (1,8,'老王',1);
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

-- Dump completed on 2022-10-10 23:47:57
