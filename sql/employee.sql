/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 50731
 Source Host           : localhost:3306
 Source Schema         : mybatis

 Target Server Type    : MySQL
 Target Server Version : 50731
 File Encoding         : 65001

 Date: 07/01/2021 17:19:28
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`  (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `sex` int(11) NULL DEFAULT NULL,
  `department_id` int(11) NULL DEFAULT NULL,
  `date` date NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1005 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '职员表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES (1000, '张三', '123542@qq.com', 0, 4, '2020-12-02');
INSERT INTO `employee` VALUES (1001, '李四', 'f32412@qq.com', 1, 3, '2020-12-01');
INSERT INTO `employee` VALUES (1002, '王五', 'g32542@qq.com', 1, 1, '2020-12-18');
INSERT INTO `employee` VALUES (1003, '赵六', 'sdad22@qq.com', 1, 2, '2020-12-31');
INSERT INTO `employee` VALUES (1004, '欧阳', 'fff232@qq.com', 0, 5, '2020-12-30');

SET FOREIGN_KEY_CHECKS = 1;
