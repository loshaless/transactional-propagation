create table test
(
    id   serial
        constraint test_pk
            primary key,
    name varchar(50) not null
);

alter table test
    owner to "user";