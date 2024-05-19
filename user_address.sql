create table user_address
(
    id           int auto_increment comment '地址表主键'
        primary key,
    user_id      int     default 0 not null comment '用户ID',
    name         varchar(20)       null comment '联系人',
    gender       varchar(10)       null comment '性别',
    phone        varchar(20)       null comment '电话',
    latitude     varchar(20)       null comment '纬度',
    longitude    varchar(20)       null comment '经度',
    province     varchar(10)       null comment '省份',
    city         varchar(10)       null comment '城市',
    district     varchar(10)       null comment '区域',
    street       varchar(10)       null comment '街道',
    detal_addr   varchar(100)      null comment '详细地址',
    default_addr tinyint default 0 null comment '是否为默认地址',
    status       tinyint default 1 null comment '状态',
    add_time     datetime          null comment '添加时间',
    constraint user_address_ibfk_1
        foreign key (user_id) references user (id)
)
    collate = utf8mb3_general_ci;

create index user_id
    on user_address (user_id);

