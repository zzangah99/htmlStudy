INSERT INTO customer " +
			"VALUES(CUSTOMER_SEQ.NEXTVAL,?,?,?,?)


CREATE TABLE customer2(
    id varchar2(20) primary key, --�����̵�
    NAME VARCHAR2(20), --���̸�
    age NUMBER(3), --������
    tel VARCHAR2(30), --������ó
    addr VARCHAR2(50)--���ּ�
)

drop table customer2;

insert into customer2 values('jang','������',20,'02-222-8282','����� ������');
insert into customer2 values('chun','õ����',24,'02-222-8282','��⵵ ������');
insert into customer2 values('king','ŷ',40,'02-222-8282','����� ���Ǳ�');
insert into customer2 values('queen','��',40,'02-222-8282','����� ��걸');
commit




select * from customer2