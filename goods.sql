create table goods
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
    comment '单个商品，也就是菜单中的菜品' collate = utf8mb3_general_ci;

create index category_id
    on goods (category_id);

create index tags_id
    on goods (tags_id);

INSERT INTO competition.goods (id, price, name, description, sales, pic, category_id, tags_id, status) VALUES (1, '120', '番茄炒蛋', '番茄炒蛋不一定要用牛番茄，小番茄炒出来也很好吃哦', 66, 'http://localhost:8081/static/goods/fanqiechaodan.jpg', 1, 5, 1);
INSERT INTO competition.goods (id, price, name, description, sales, pic, category_id, tags_id, status) VALUES (2, '32', '鱼香肉丝', '此菜主料是猪肉，要选用三成肥、七成瘦的猪肉切丝滑炒，方能使肉丝质地鲜嫩。成菜色红润、肉嫩、质鲜、富鱼香味。', 35, 'http://localhost:8081/static/goods/yuxiangrousi.jpg', 1, 7, 1);
INSERT INTO competition.goods (id, price, name, description, sales, pic, category_id, tags_id, status) VALUES (3, '55', '糖醋排骨', '酸甜适中，不油不腻，口感丰富细腻，不会觉得任何一种调料的突兀。 颜色呈糖稀色，不浓不淡,男女老少皆宜。', 88, 'http://localhost:8081/static/goods/tangcupaigu.jpg', 1, 8, 1);
INSERT INTO competition.goods (id, price, name, description, sales, pic, category_id, tags_id, status) VALUES (4, '15', '香菇青菜', '香菇青菜是一道菜品，制作原料有青菜、香菇、油、盐等。香菇盛出后，用筷子整齐地摆放在青菜上，最后将锅内的汁淋在菜上。', 36, 'http://localhost:8081/static/goods/xiangguqingcai.jpg', 1, 5, 1);
INSERT INTO competition.goods (id, price, name, description, sales, pic, category_id, tags_id, status) VALUES (5, '88', '红烧鲫鱼', '红烧鲫鱼是以鲫鱼为主要食材，配以香菜、红辣椒一起烧制的美味私房菜，口味香辣可口，美容抗皱，营养价值丰富。', 121, 'http://localhost:8081/static/goods/hongshaojiyu.jpg', 1, 9, 1);
INSERT INTO competition.goods (id, price, name, description, sales, pic, category_id, tags_id, status) VALUES (6, '128', '牛肉小火锅', '牛肉是补气血的佳品，可治疗由气血虚弱引起的脾胃虚弱都，健脾养胃，对面黄肌瘦以及虚胖的人群都有好处。', 26, 'http://localhost:8081/static/goods/niurouhuoguo.jpg', 2, 9, 1);
