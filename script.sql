create table if not exists category
(
    id   int auto_increment comment '菜谱ID'
        primary key,
    name varchar(20) null comment '种类名'
)
    comment '菜谱表' engine = InnoDB
                     collate = utf8mb3_general_ci;

create table if not exists t_admin
(
    id        int auto_increment
        primary key,
    user_name varchar(22) null,
    password  varchar(22) null
)
    engine = InnoDB
    collate = utf8mb3_general_ci;

create table if not exists t_order
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
    engine = InnoDB
    collate = utf8mb3_general_ci;

create table if not exists t_order_detail
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
    engine = InnoDB
    collate = utf8mb3_general_ci;

create index m_id
    on t_order_detail (m_id);

create table if not exists t_table
(
    id     int auto_increment
        primary key,
    number varchar(20)  null comment '桌号',
    time   datetime     null comment '创建世间',
    qrcode varchar(100) null comment '二维码'
)
    engine = InnoDB
    collate = utf8mb3_general_ci;

create table if not exists tags
(
    id   int auto_increment comment '菜品ID'
        primary key,
    name varchar(20) null comment '菜品标签'
)
    comment '菜品标签表' engine = InnoDB
                         collate = utf8mb3_general_ci;

create table if not exists goods
(
    id          int auto_increment comment '商品id'
        primary key,
    price       varchar(15)       null comment '商品价格',
    name        varchar(30)       null comment '商品名字',
    description varchar(150)      null comment '商品描述',
    sales       int     default 0 null comment '商品销量',
    pic         varchar(100)      null comment '商品图片',
    category_id int     default 0 not null comment '归属菜谱',
    tags_id     int     default 0 not null comment '菜品标签',
    status      tinyint default 1 null comment '商品状态，1为正常，0为下架',
    constraint goods_ibfk_1
        foreign key (category_id) references category (id),
    constraint goods_ibfk_2
        foreign key (tags_id) references tags (id)
)
    comment '单个商品，也就是菜单中的菜品' engine = InnoDB
                                          collate = utf8mb3_general_ci;

create index category_id
    on goods (category_id);

create index tags_id
    on goods (tags_id);

create table if not exists user
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
    engine = InnoDB
    collate = utf8mb3_general_ci;

create table if not exists user_address
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
    engine = InnoDB
    collate = utf8mb3_general_ci;

create index user_id
    on user_address (user_id);


