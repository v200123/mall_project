create table t_order_detail
(
    id          int auto_increment comment '编号'
        primary key,
    m_id        int           null comment '订单主表ID',
    name        varchar(100)  null comment '菜品名称',
    quantity    int           null comment '数量',
    unit        varchar(11)   null comment '单位',
    image       varchar(100)  null comment '菜品图片',
    total_price decimal(6, 2) null comment '总价',
    constraint t_order_detail_ibfk_1
        foreign key (m_id) references t_order (id)
)
    collate = utf8mb3_general_ci;

create index m_id
    on t_order_detail (m_id);

INSERT INTO competition.t_order_detail (id, m_id, name, quantity, unit, image, total_price) VALUES (227, 163, '鱼香肉丝', 2, null, 'http://localhost:8081/static/goods/yuxiangrousi.jpg', 64.00);
INSERT INTO competition.t_order_detail (id, m_id, name, quantity, unit, image, total_price) VALUES (228, 163, '番茄炒蛋', 2, null, 'http://localhost:8081/static/goods/fanqiechaodan.jpg', 240.00);
INSERT INTO competition.t_order_detail (id, m_id, name, quantity, unit, image, total_price) VALUES (229, 164, '番茄炒蛋', 2, null, 'http://localhost:8081/static/goods/fanqiechaodan.jpg', 240.00);
INSERT INTO competition.t_order_detail (id, m_id, name, quantity, unit, image, total_price) VALUES (230, 164, '鱼香肉丝', 2, null, 'http://localhost:8081/static/goods/yuxiangrousi.jpg', 64.00);
INSERT INTO competition.t_order_detail (id, m_id, name, quantity, unit, image, total_price) VALUES (231, 164, '糖醋排骨', 2, null, 'http://localhost:8081/static/goods/tangcupaigu.jpg', 110.00);
