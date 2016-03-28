# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table users (
  id                            integer auto_increment not null,
  username                      varchar(255),
  password                      varchar(255),
  mailol                        varchar(255),
  constraint pk_users primary key (id)
);


# --- !Downs

drop table if exists users;

