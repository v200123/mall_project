create table user
(
    id         int auto_increment comment '用户主键'
        primary key,
    username   varchar(50)       null comment '用户昵称',
    phone      varchar(20)       null comment '联系电话',
    password   varchar(50)       null comment '登录密码',
    salt       varchar(20)       null comment '加盐',
    user_photo varchar(100)      null comment '用户头像',
    email      varchar(50)       null comment '邮箱',
    state      tinyint default 1 null comment '用户状态',
    join_time  datetime          null comment '注册时间',
    last_login datetime          null comment '最近登录',
    tag        int     default 1 null comment '身份标签',
    token      varchar(50)       null comment '登录凭证'
)
    collate = utf8mb3_general_ci;

INSERT INTO competition.user (id, username, phone, password, salt, user_photo, email, state, join_time, last_login, tag, token) VALUES (6, '烧雏鸡', '13658170135', 'e10adc3949ba59abbe56e057f20f883e', 'c5727', 'https://wx3.sinaimg.cn/large/008gYSn8gy1hpgzzw8yfdj37c04w0he2.jpg', null, 1, '2024-05-15 11:49:05', '2024-05-17 14:20:47', 1, 'a93ed5fb-4744-4a45-8490-8538af897527');
INSERT INTO competition.user (id, username, phone, password, salt, user_photo, email, state, join_time, last_login, tag, token) VALUES (7, '饥太美儿', '1365817035', 'e10adc3949ba59abbe56e057f20f883e', '96cb2', 'https://wx3.sinaimg.cn/large/008gYSn8gy1hpgzzw8yfdj37c04w0he2.jpg', null, 1, '2024-05-17 14:05:44', '2024-05-17 14:05:44', 1, 'a419ac15-fcd8-4211-b5c1-f492995c5de7');
