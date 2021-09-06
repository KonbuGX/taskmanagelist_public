# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table tasklist (
  accountno                     integer,
  task_no                       integer,
  task_name                     varchar(255),
  task_contents                 varchar(255),
  dead_line                     timestamp,
  status                        varchar(255),
  last_update                   timestamp
);


# --- !Downs

drop table if exists tasklist;

