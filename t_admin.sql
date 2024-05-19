create table t_admin
(
    id        int auto_increment
        primary key,
    user_name varchar(22) null,
    password  varchar(22) null
)
    collate = utf8mb3_general_ci;

INSERT INTO competition.t_admin (id, user_name, password) VALUES (1, 'java1234', '12345');
