create table t_table
(
    id     int auto_increment
        primary key,
    number varchar(20)  null comment '桌号',
    time   datetime     null comment '创建世间',
    qrcode varchar(100) null comment '二维码'
)
    collate = utf8mb3_general_ci;

