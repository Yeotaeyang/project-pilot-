create table member(
    USER_ID VARCHAR(36) NOT NULL PRIMARY KEY COMMENT'회원아이디',
    PASSWORD VARCHAR(70) NOT NULL COMMENT'회원비밀번호',
    EMAIL VARCHAR(50) NOT NULL COMMENT '회원이메일',
    GRADE CHAR(50) NULL DEFAULT 'ROLE_USER' COMMENT '회원등급',
    TELL VARCHAR(15) NULL COMMENT '회원전화번호',
    IS_LEAVE CHAR(1) NOT NULL DEFAULT 'N' COMMENT '탈퇴여부'
);

select * from member;

delete from member;
commit;