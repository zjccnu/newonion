# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table course (
  courseid                  bigint auto_increment not null,
  courseName                varchar(255),
  courseTeacher             varchar(255),
  bz1                       varchar(255),
  bz2                       varchar(255),
  bz3                       varchar(255),
  constraint pk_course primary key (courseid))
;

create table courseComment (
  courseCommentId           bigint auto_increment not null,
  courseId                  bigint,
  courseContent             varchar(255),
  courseQuality             varchar(255),
  courseScore               varchar(255),
  courseLike                varchar(255),
  score                     varchar(255),
  comment                   varchar(255),
  time                      varchar(255),
  idAnonymous               varchar(255),
  url                       varchar(255),
  usname                    varchar(255),
  count                     varchar(255),
  bz1                       varchar(255),
  bz2                       varchar(255),
  bz3                       varchar(255),
  constraint pk_courseComment primary key (courseCommentId))
;

create table notice (
  noticeId                  bigint auto_increment not null,
  title                     varchar(255),
  url                       varchar(255),
  type                      varchar(255),
  noticetime                varchar(255),
  bz1                       varchar(255),
  bz2                       varchar(255),
  bz3                       varchar(255),
  constraint pk_notice primary key (noticeId))
;

create table thumbsUp (
  thumbsUpId                bigint auto_increment not null,
  username                  varchar(255),
  courseCommentId           varchar(255),
  constraint pk_thumbsUp primary key (thumbsUpId))
;

create table userinfo (
  userid                    bigint auto_increment not null,
  username                  varchar(255),
  password                  varchar(255),
  token                     varchar(255),
  expire                    varchar(255),
  bz1                       varchar(255),
  bz2                       varchar(255),
  bz3                       varchar(255),
  constraint pk_userinfo primary key (userid))
;

alter table courseComment add constraint fk_courseComment_course_1 foreign key (courseId) references course (courseId) on delete restrict on update restrict;
create index ix_courseComment_course_1 on courseComment (courseId);



# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table course;

drop table courseComment;

drop table notice;

drop table thumbsUp;

drop table userinfo;

SET FOREIGN_KEY_CHECKS=1;

