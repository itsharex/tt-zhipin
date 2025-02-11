-- liquibase formatted sql

-- changeset whoiszxl:1
-- comment 初始化file表结构

CREATE TABLE `fms_file` (
     `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '品牌主键id',
    `platform_type` tinyint(3) NOT NULL DEFAULT '1' COMMENT '平台类型: 1-阿里云 2-七牛云 3-百度云 4-AmazonS3 5-minio',
    `biz_id` bigint(11) NOT NULL DEFAULT '1' COMMENT '业务ID',
    `biz_type` tinyint(3) NOT NULL DEFAULT '1' COMMENT '业务类型: 1-简历 2-头像 3-公司图片 4-公司视频',
    `data_type` tinyint(3) NOT NULL DEFAULT '2' COMMENT '数据类型: 1-目录 2-图片 3-视频 4-音频 5-文档 6-其他',
    `original_file_name` varchar(256) NOT NULL COMMENT '原始文件名',
    `final_file_name` varchar(256) NOT NULL COMMENT '最终文件名',
    `relative_path` varchar(256) NOT NULL COMMENT '相对路径',
    `url` varchar(256) NOT NULL COMMENT '访问地址',
    `md5` varchar(256) DEFAULT NULL COMMENT 'md5值',
    `ext` varchar(16) NOT NULL COMMENT '文件后缀',
    `size` bigint(11) NOT NULL COMMENT '文件大小',
    `created_year` varchar(4) NOT NULL COMMENT '创建年份: yyyy',
    `created_month` varchar(8) NOT NULL COMMENT '创建年月: yyyy-MM',
    `created_day` varchar(10) NOT NULL COMMENT '创建年月日: yyyy-MM-dd',
    `version` bigint(11) unsigned NOT NULL DEFAULT '1' COMMENT '乐观锁',
    `is_deleted` tinyint(3) DEFAULT '0' COMMENT '逻辑删除 1: 已删除, 0: 未删除',
    `created_at` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='文件表';