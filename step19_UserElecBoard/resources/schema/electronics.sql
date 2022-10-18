drop table Electronics;

create table Electronics(
	model_num varchar2(15) primary key, --��ǰ��ȣ
	model_name varchar2(20) not null,--��ǰ�̸�
	price int,--����
	description varchar2(100), --����
	password varchar2(20) not null,--��й�ȣ
	writeday date  not null, --�ۼ���
	readnum int, --��ȸ��
	 fname varchar2(50), --�����̸�
     fsize int --���Ͽ뷮
);


insert into Electronics values('NT900X4D-A68','�Ｚ����',1300000,'Windows 8','1111',sysdate,0,null,0); --sysdate�� ��¥
insert into Electronics values('SHV-E250S','Galaxy Note II',1000000,'Wi-Fi bluetooth 4.0','1111',sysdate,0,null,0);
insert into Electronics values('NT900X4D-A99S','�Ｚ����',1700000,'Windows 8','1111',sysdate,0,null,0);

select * from Electronics

commit;
 
 
 --					a�� ��� �÷�						(�ζ���)							a��� �̸��� ��
select * from (select a.*, rownum rnum from (select * from electronics order by writeday desc) a)
where rnum>=? and rnum<=?
 
 
select count(*) from electronics;
-- ��� ���̺� �ۼ��ϱ� (�θ�� �� ���� ���� ���� ����� �ۼ��� �� �ִ�)
create table replies(
    reply_num number primary key,
    reply_content varchar2(100) not null,
    reply_regdate date,
    parent_model_num varchar2(15) references electronics(model_num)
);

-- ��� ��ȣ���� ����� ������ ����
create sequence replies_num_seq;

-- ���� ������ �Է���
