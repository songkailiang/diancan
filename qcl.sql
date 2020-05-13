drop database if exists sell;
create database sell default character set utf8 collate utf8_general_ci;;
use sell;

-- 门店
create table `store`
(
  `store_id`   bigint(20) not null auto_increment,
  `store_name` varchar(64) not null DEFAULT '' comment '门店名称',
  `store_address` varchar(500) not null DEFAULT '' comment '门店地址',
  `store_mobile` varchar(11) not null  DEFAULT '' comment '门店地址',
  `create_time`   timestamp   not null default current_timestamp comment '创建时间',
  `update_time`   timestamp   not null default current_timestamp on update current_timestamp comment '修改时间',
    primary key (`stord_id`)
) comment '门店信息表';

-- 桌位信息
create table `store_table`
(
  `table_id` int not null auto_increment,
  `table_no` int not null DEFAULT 0 comment '桌号',
  `store_id`   bigint(20) not null DEFAULT 0 comment '门店ID',
  `create_time`   timestamp   not null default current_timestamp comment '创建时间',
  `update_time`   timestamp   not null default current_timestamp on update current_timestamp comment '修改时间',
    primary key (`table_id`)
) comment '门店桌位信息表';

-- 类目
create table `product_category`
(
  `category_id`   int  not null auto_increment,
  `category_name` varchar(64) not null DEFAULT '' comment '类目名字',
  `category_type` int not null comment '类目类别',
  `store_id`   bigint(20) not null DEFAULT 0 comment '门店ID',
  `create_time`   timestamp   not null default current_timestamp comment '创建时间',
  `update_time`   timestamp   not null default current_timestamp on update current_timestamp comment '修改时间',
  primary key (`category_id`)
) comment '类目表';

create table `product_info`
(
  `product_id` int  not null auto_increment,
  `product_name`  varchar(64)   not null DEFAULT '' comment '商品名称',
  `product_price`   decimal(8, 2) not null comment '单价',
  `product_description` varchar(64) comment '描述',
  `product_icon`        varchar(512) comment '图片',
  `product_status`      tinyint(3)   DEFAULT '0' COMMENT '商品状态,0正常1下架',
  `category_type` int   not null comment '类目编号',
  `store_id`   bigint(20) not null DEFAULT 0 comment '门店ID',
  `create_time`         timestamp     not null default current_timestamp comment '创建时间',
  `update_time`         timestamp     not null default current_timestamp on update current_timestamp comment '修改时间',
  primary key (`product_id`)
) comment '商品表';

create table `order_master`
(
  `order_id`      varchar(32)   not null,
  `buyer_name`    varchar(32)   not null comment '买家名字',
  `buyer_phone`   varchar(32)   not null comment '买家电话',
  `table_no` varchar(64)  not null comment '买家桌号',
  `buyer_openid`  varchar(64)   not null comment '买家微信openid',
  `order_amount`  decimal(8, 2) not null comment '订单总金额',
  `real_amount`  decimal(8, 2) not null comment '实收总金额',
  `order_status`  tinyint(3)    not null default '0' comment '订单状态, 默认为新下单',
  `store_id`   bigint(20) not null DEFAULT 0 comment '门店ID',
  `create_time`   timestamp     not null default current_timestamp comment '创建时间',
  `update_time`   timestamp     not null default current_timestamp on update current_timestamp comment '修改时间',
  primary key (`order_id`),
  key `idx_buyer_openid` (`buyer_openid`)
) comment '订单表';

create table `order_detail`
(
  `detail_id`        varchar(32)   not null,
  `order_id`         varchar(32)   not null,
  `product_id`       int   not null,
  `product_name`     varchar(64)   not null comment '商品名称',
  `product_price`    decimal(8, 2) not null comment '当前价格,单位分',
  `product_quantity` int           not null comment '数量',
  `product_icon`     varchar(512) comment '小图',
  `store_id`   bigint(20) not null DEFAULT 0 comment '门店ID',
  `create_time`      timestamp     not null default current_timestamp comment '创建时间',
  `update_time`      timestamp     not null default current_timestamp on update current_timestamp comment '修改时间',
  primary key (`detail_id`),
  key `idx_order_id` (`order_id`)
) comment '订单详情';


create table `seller_info`
(
  `seller_id`   int         not null auto_increment,
  `username`    varchar(32) not null,
  `password`    varchar(32) not null,
  `phone`       varchar(64) not null comment '用户手机号',
  `create_time` timestamp   not null default current_timestamp comment '创建时间',
  `update_time` timestamp   not null default current_timestamp on update current_timestamp comment '修改时间',
  primary key (`seller_id`)
) comment '卖家信息表';

create table `user`
(
  `id`          INT         not null auto_increment,
  `username`    varchar(32) not null,
  `phone`       varchar(32) not null,
  `openid`      varchar(64) not null comment '微信openid',
  `table_no`     varchar(64) comment '桌号',
  `people_num`      varchar(64) comment '就餐人数',
  `create_time` timestamp   not null default current_timestamp comment '创建时间',
  `update_time` timestamp   not null default current_timestamp on update current_timestamp comment '修改时间',
  primary key (`id`)
) comment '用户信息表';

create table `picture`
(
  `pic_id`      INT          not null auto_increment,
  `pic_url`     varchar(255) not null,
  `pic_message` varchar(64)  not null,
  `store_id`   bigint(20) not null DEFAULT 0 comment '门店ID',
  `pic_create`  timestamp    not null default current_timestamp comment '创建时间',
  primary key (`pic_id`)
) comment '轮播图表';






