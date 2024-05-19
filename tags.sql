create table tags
(
    id   int auto_increment comment '菜品ID'
        primary key,
    name varchar(20) null comment '菜品标签'
)
    comment '菜品标签表' collate = utf8mb3_general_ci;

INSERT INTO competition.tags (id, name) VALUES (1, '酸');
INSERT INTO competition.tags (id, name) VALUES (2, '甜');
INSERT INTO competition.tags (id, name) VALUES (3, '辣');
INSERT INTO competition.tags (id, name) VALUES (4, '清淡');
INSERT INTO competition.tags (id, name) VALUES (5, '正常');
INSERT INTO competition.tags (id, name) VALUES (6, '重口');
INSERT INTO competition.tags (id, name) VALUES (7, '偏咸');
INSERT INTO competition.tags (id, name) VALUES (8, '偏甜');
INSERT INTO competition.tags (id, name) VALUES (9, '微辣');
