


create table users(
   user_id varchar2(10) primary key,	--DB������ user_id ���� _�� ������
   pwd varchar2(10), 
   name varchar2(10)
);

select * from users;



insert into users values('jang', '1234', '������');
insert into users values('lee', '1234', '�̰���');

select user_id, pwd, name from users where user id=? and pwd=?
commit