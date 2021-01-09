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

 Date: 09/01/2021 17:01:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for roles_permissions
-- ----------------------------
DROP TABLE IF EXISTS `roles_permissions`;
CREATE TABLE `roles_permissions`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `permission` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色权限' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of roles_permissions
-- ----------------------------
INSERT INTO `roles_permissions` VALUES (1, 'admin', '*:*');
INSERT INTO `roles_permissions` VALUES (2, '访客', 'read:*');
INSERT INTO `roles_permissions` VALUES (3, 'java开发', 'read:*');
INSERT INTO `roles_permissions` VALUES (4, 'java开发', 'dev:java');
INSERT INTO `roles_permissions` VALUES (5, 'python开发', 'read:*');
INSERT INTO `roles_permissions` VALUES (6, 'python开发', 'dev:python');

SET FOREIGN_KEY_CHECKS = 1;
