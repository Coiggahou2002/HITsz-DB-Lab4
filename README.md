# 校园猫管理平台

> By [@Coiggahou2002](https://github.com/Coiggahou2002)

哈尔滨工业大学（深圳）2022 秋数据库实验四 - 项目仓库

## 前端

### 技术选型

| 概述  | 框架  | 描述 |
|------|------|------|
| 脚手架 | [Vite](https://cn.vitejs.dev/) | 预设了常见配置的项目构建工具 |
| 框架 | [Vue 3](https://cn.vuejs.org/) | Web 框架 |
| 路由| [Vue Router 4](https://router.vuejs.org/zh/index.html) | 负责管理项目的路由导航 |
| 状态管理库| [Vuex 4](https://vuex.vuejs.org/zh/) | 项目全局变量池 |
| 网络请求库| [Axios](https://www.axios-http.cn/) | 用于发送 http 请求 |
| UI 组件库| [Element Plus](https://element-plus.org/zh-CN/) | 提供了一批开箱即用的 UI 组件 |
| 原子 CSS 库| [TailwindCSS](https://tailwindcss.com/) | 提供了常用的样式快捷类名 |

### 如何启动

如果还没有安装 Node.js，请到[官网](https://nodejs.org/en/)安装最新 LTS 版本

在 `frontend` 目录下，打开终端输入

```
npm i
```

(也可以使用你自己惯用的包管理器，如果你不知道什么是包管理器，那按照指示来就可以了)

如果上述步骤安装很慢，可以尝试使用淘宝镜像源安装，也就是执行下面的命令

```
npm i --registry https://registry.npm.taobao.org
```

安装完成后, 终端输入以下命令即可运行

```
npm run dev
```

## 后端

### 技术选型

| 概述  | 框架  | 描述 |
|------|------|------|
| 持久层框架| [Mybatis Plus](https://baomidou.com/) | 接管 DAO 层工作的框架，负责管理实体类对象和数据库表记录的映射 |
| 服务端框架| [Spring Boot 2.7](https://spring.io/projects/spring-boot) | 服务端快速开发框架 |
| 数据库| MySQL 8 |
| 开发插件| [Lombok](https://projectlombok.org/) | 减少 Java 实体类代码书写量的插件 |
| API文档| 已整合[Swagger 3](https://swagger.io/) | 项目接口测试文档部署插件 |

### 如何启动

用 IntellJ IDEA 打开 `backend` 目录，点击 Maven 插件菜单栏，依次点击 `clean` 与 `install`，等待包安装完成后，找到 `MainApplication` 即可点击运行

### 数据库表

建表脚本如下

```sql
create table cat_types
(
    id   bigint       not null
        primary key,
    name varchar(255) not null comment '品种名'
)
    comment '猫品种表';

create table cats
(
    id                 bigint                                  not null
        primary key,
    color_id           bigint                                  not null comment '颜色id',
    around_location_id bigint                                  not null comment '经常出现的位置id',
    name               varchar(255) collate utf8mb4_unicode_ci not null comment '猫昵称',
    type_id            bigint                                  not null comment '类型id',
    character_id       bigint                                  not null comment '性格id',
    constraint cats_id_uindex
        unique (id) comment '猫id索引'
);

create table characters
(
    id   bigint       not null
        primary key,
    name varchar(255) not null
)
    comment '性格表';

create table check_records
(
    id          bigint   not null
        primary key,
    location_id bigint   not null comment '猫出现位置id',
    cat_id      bigint   not null comment '签到的猫id',
    time        datetime not null comment '猫出现的时间'
)
    comment '猫猫签到表';

create table colors
(
    id   bigint       not null
        primary key,
    name varchar(255) not null comment '颜色名'
)
    comment '颜色表';

create table feed_records
(
    id          bigint   not null
        primary key,
    user_id     bigint   not null comment '投喂者的用户id',
    time        datetime not null comment '投喂时间',
    location_id bigint   not null comment '投喂地点id',
    cat_id      bigint   not null comment '投喂的猫id',
    food_id     bigint   not null comment '投喂的食物id'
)
    comment '投喂记录表';

create definer = root@localhost trigger auto_feed_time
    before insert
    on feed_records
    for each row
    set new.time = now();

create table foods
(
    id   bigint       not null
        primary key,
    name varchar(255) not null comment '食物名称'
)
    comment '食物表';

create table locations
(
    id   bigint       not null
        primary key,
    name varchar(255) not null comment '食物名称'
)
    comment '地点表';

create table users
(
    id       bigint       not null
        primary key,
    username varchar(255) not null comment '用户名',
    password varchar(255) not null comment '密码',
    constraint unique_username
        unique (username),
    constraint username_index
        unique (username)
)
    comment '用户表';

create definer = root@localhost view cat_fullview as
select `c`.`id`    AS `id`,
       `c`.`name`  AS `name`,
       `c3`.`name` AS `color`,
       `c2`.`name` AS `character`,
       `ct`.`name` AS `type`,
       `l`.`name`  AS `location`
from ((((`cat_platform`.`cats` `c` left join `cat_platform`.`characters` `c2`
         on ((`c2`.`id` = `c`.`character_id`))) left join `cat_platform`.`colors` `c3`
        on ((`c3`.`id` = `c`.`color_id`))) left join `cat_platform`.`cat_types` `ct`
       on ((`c`.`type_id` = `ct`.`id`))) left join `cat_platform`.`locations` `l`
      on ((`c`.`around_location_id` = `l`.`id`)));

-- comment on column cat_fullview.name not supported: 猫昵称

-- comment on column cat_fullview.color not supported: 颜色名

-- comment on column cat_fullview.type not supported: 品种名

-- comment on column cat_fullview.location not supported: 食物名称
```




## PS

本项目无任何开源协议约束, 有需要的同学可自行下载参考

若有其他问题或需要补充注释可联系 coiggahou@foxmail.com