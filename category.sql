create table category
(
    id   int auto_increment comment '菜谱ID'
        primary key,
    name varchar(20) null comment '种类名'
)
    comment '菜谱表' collate = utf8mb3_general_ci;

INSERT INTO competition.category (id, name) VALUES (1, '家常');
INSERT INTO competition.category (id, name) VALUES (2, '火锅');
INSERT INTO competition.category (id, name) VALUES (3, '小吃');
INSERT INTO competition.category (id, name) VALUES (4, '酒水');
