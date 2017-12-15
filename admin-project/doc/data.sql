CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `username` varchar(40) NOT NULL,
  `password` varchar(40) NOT NULL,
  `age` int(3) DEFAULT NULL,
  `name` varchar(40) DEFAULT NULL,
  `role` varchar(40) DEFAULT '',
  `email` v  e` varchar(40) NOT NULL,
  `password` varchar(40) NOT NULL,
  `age` int(3) DEFAULT NULL,
  `name` varchar(40) DEFAULT NULL,
  `role` varchar(40) DEFAULT '',
  `email` varchar(40) DEFAULT '',
  `phone` varchar(20) DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



CREATE TABLE `pro_market_base` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `mkt_id` varchar(50) NOT NULL COMMENT '专业市场ID',
  `mkt_name_show` varchar(50) NOT NULL COMMENT '市场外部名称',
  `daily_min_packages` int(8) NOT NULL COMMENT '单客日均最小件量',
  `weight_min` decimal(5,1) NOT NULL DEFAULT '0.0' COMMENT '重量区间（最小）',
  `weight_max` decimal(5,1) NOT NULL DEFAULT '0.0' COMMENT '重量区间（最大）',
  `base_price` decimal(5,1) NOT NULL DEFAULT '0.0' COMMENT '首重价格',
  `base_weight` decimal(5,1) NOT NULL DEFAULT '0.0' COMMENT '首重重量',
  `group_limit` int(8) NOT NULL COMMENT '成团人数',
  `group_duration` int(8) NOT NULL COMMENT '拼团周期（单位：天）',
  `contract_duration` int(8) NOT NULL COMMENT '集货团有效期（单位：天）',
  `use_require` varchar(64) NOT NULL COMMENT '使用要求',
  `created_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modifed_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `mkt_id` (`mkt_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='专业市场基本信息表';




CREATE TABLE `pro_group_base` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `market_id` bigint(20) NOT NULL COMMENT '专业市场ID',
  `group_name` varchar(50) NOT NULL COMMENT '集货团显示名',
  `current_count` int(8) NOT NULL COMMENT '当前专业市场集货团计数',
  `banner` varchar(100) NOT NULL COMMENT '展示图片地址',
  `created_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modifed_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `group_name` (`group_name`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='集货团信息表';




CREATE TABLE `pro_group_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `group_id` bigint(20) NOT NULL COMMENT '集货团ID',
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `address_1` varchar(100) NOT NULL COMMENT '寄件地址第一行',
  `address_2` varchar(100) NOT NULL COMMENT '寄件地址第二行',
  `name` varchar(100) NOT NULL COMMENT '寄件人姓名',
  `mobile` varchar(100) NOT NULL COMMENT '寄件人手机号',
  `expect_sum` int(8) NOT NULL COMMENT '预计',
  `avg_weight` decimal(5,1) NOT NULL DEFAULT '0.0' COMMENT '平均重量',
  `created_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modifed_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='用户团购信息表';

