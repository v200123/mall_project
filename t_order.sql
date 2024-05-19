create table t_order
(
    id               int auto_increment
        primary key,
    order_no         varchar(100)  null comment '订单号',
    table_number     varchar(50)   null comment '桌号',
    number_of_diners int           null comment '用餐人数',
    sett_amount      decimal(6, 2) null comment '计算总价',
    transac_status   varchar(50)   null comment '结账状态',
    order_receiving  varchar(50)   null comment '接单状态',
    order_time       datetime      null comment '下单时间',
    is_appointment   int           null comment '是否预约单',
    appointment_time datetime      null comment '预约到店时间',
    is_takeout_order int           null comment '是否外卖单',
    takeout_address  varchar(50)   null comment '外卖地址'
)
    collate = utf8mb3_general_ci;

INSERT INTO competition.t_order (id, order_no, table_number, number_of_diners, sett_amount, transac_status, order_receiving, order_time, is_appointment, appointment_time, is_takeout_order, takeout_address) VALUES (163, null, '-1', null, 304.00, null, null, '2024-05-16 13:55:28', null, null, 0, null);
INSERT INTO competition.t_order (id, order_no, table_number, number_of_diners, sett_amount, transac_status, order_receiving, order_time, is_appointment, appointment_time, is_takeout_order, takeout_address) VALUES (164, null, '-1', null, 414.00, null, null, '2024-05-16 15:22:10', null, null, 0, null);
INSERT INTO competition.t_order (id, order_no, table_number, number_of_diners, sett_amount, transac_status, order_receiving, order_time, is_appointment, appointment_time, is_takeout_order, takeout_address) VALUES (165, null, '5', null, 456.00, null, null, '2024-05-17 06:06:18', null, null, 0, null);
INSERT INTO competition.t_order (id, order_no, table_number, number_of_diners, sett_amount, transac_status, order_receiving, order_time, is_appointment, appointment_time, is_takeout_order, takeout_address) VALUES (166, null, null, null, 55.00, null, null, '2024-05-17 06:10:08', null, null, 0, '那行嘻嘻嘻');
INSERT INTO competition.t_order (id, order_no, table_number, number_of_diners, sett_amount, transac_status, order_receiving, order_time, is_appointment, appointment_time, is_takeout_order, takeout_address) VALUES (167, null, null, null, 152.00, null, null, '2024-05-17 06:12:47', null, null, 0, '摩西一定一下');
INSERT INTO competition.t_order (id, order_no, table_number, number_of_diners, sett_amount, transac_status, order_receiving, order_time, is_appointment, appointment_time, is_takeout_order, takeout_address) VALUES (168, null, null, null, 240.00, null, null, '2024-05-17 06:14:43', null, null, 0, '');
