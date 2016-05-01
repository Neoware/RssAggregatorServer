# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table feeds (
  id                            integer auto_increment not null,
  name                          varchar(255),
  url                           varchar(255),
  constraint uq_feeds_url unique (url),
  constraint pk_feeds primary key (id)
);

create table feed_articles (
  id                            integer auto_increment not null,
  title                         varchar(255),
  content                       varchar(255),
  author                        varchar(255),
  published_date                date,
  feed_id                       integer,
  constraint pk_feed_articles primary key (id)
);

create table users (
  id                            integer auto_increment not null,
  username                      varchar(255),
  password                      varchar(255),
  mail                          varchar(255),
  user_hash                     varchar(255),
  constraint uq_users_username unique (username),
  constraint uq_users_mail unique (mail),
  constraint pk_users primary key (id)
);

create table user_articles (
  id                            integer auto_increment not null,
  user_id                       integer,
  feed_articles_id              integer,
  is_read                       tinyint(1) default 0,
  constraint pk_user_articles primary key (id)
);

create table user_subscriptions (
  id                            integer auto_increment not null,
  user_id                       integer,
  feed_id                       integer,
  constraint pk_user_subscriptions primary key (id)
);

alter table feed_articles add constraint fk_feed_articles_feed_id foreign key (feed_id) references feeds (id) on delete restrict on update restrict;
create index ix_feed_articles_feed_id on feed_articles (feed_id);

alter table user_articles add constraint fk_user_articles_user_id foreign key (user_id) references users (id) on delete restrict on update restrict;
create index ix_user_articles_user_id on user_articles (user_id);

alter table user_articles add constraint fk_user_articles_feed_articles_id foreign key (feed_articles_id) references feed_articles (id) on delete restrict on update restrict;
create index ix_user_articles_feed_articles_id on user_articles (feed_articles_id);

alter table user_subscriptions add constraint fk_user_subscriptions_user_id foreign key (user_id) references users (id) on delete restrict on update restrict;
create index ix_user_subscriptions_user_id on user_subscriptions (user_id);

alter table user_subscriptions add constraint fk_user_subscriptions_feed_id foreign key (feed_id) references feeds (id) on delete restrict on update restrict;
create index ix_user_subscriptions_feed_id on user_subscriptions (feed_id);


# --- !Downs

alter table feed_articles drop foreign key fk_feed_articles_feed_id;
drop index ix_feed_articles_feed_id on feed_articles;

alter table user_articles drop foreign key fk_user_articles_user_id;
drop index ix_user_articles_user_id on user_articles;

alter table user_articles drop foreign key fk_user_articles_feed_articles_id;
drop index ix_user_articles_feed_articles_id on user_articles;

alter table user_subscriptions drop foreign key fk_user_subscriptions_user_id;
drop index ix_user_subscriptions_user_id on user_subscriptions;

alter table user_subscriptions drop foreign key fk_user_subscriptions_feed_id;
drop index ix_user_subscriptions_feed_id on user_subscriptions;

drop table if exists feeds;

drop table if exists feed_articles;

drop table if exists users;

drop table if exists user_articles;

drop table if exists user_subscriptions;

