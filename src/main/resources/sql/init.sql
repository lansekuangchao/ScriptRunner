DROP TABLE IF EXISTS `api_category`;
CREATE TABLE `api_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category_code` varchar(64) NOT NULL COMMENT ' 算法类别code',
  `category_name` varchar(64) NOT NULL COMMENT '算法类别名称',
  `is_vaild` varchar(1) NOT NULL DEFAULT '1' COMMENT '是否有效 1 有效  0无效',
  `work_order` bigint(20) DEFAULT NULL COMMENT '执行顺序',
  `config` varchar(32) NOT NULL COMMENT '配置参数 参考 api-config表 config字段',
  `job_name` varchar(128) NOT NULL COMMENT '任务名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of api_category
-- ----------------------------
INSERT INTO `api_category` VALUES ('1', 'XXXCODE', '插入成功', '0', '1', 'prod', 'XXXXXX');
