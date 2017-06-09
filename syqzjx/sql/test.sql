drop table Company;
drop table trends;
drop table context;
drop table productType;
drop table product;
drop table know;
drop table employ;
drop table User;
drop table guest;
drop table message;
-- ---------------------------------------------------------

-- ok
-- 公司简介表
drop table Company;

create table Company(
	cbrife VARCHAR(1000),			-- 公司简介
	cbrand VARCHAR(60)			-- 公司商标
);
insert into Company values('位于中国保定清苑区,占地5800平方米,位于京津石中心,紧靠京-深高速公路，国道107旁，交通便利。
  我公司专业生产起重机械设备，具有现代化生产线，及完善的测试手段。经中国国家工商局批准登记的“双航”，“航鸽”牌注册商标，由国家质量监督检验合格，并由中国人民保险公司承保。我公司主要生产（0.3-250吨）起重滑车。（0.5-20吨）手拉葫芦，（0.5-5吨）手扳葫芦，（0.5-10吨）电动葫芦，安全带脚扣，紧线器，吊索具等起重工具。并根据客户的要求设计，制造各种规格非标准的起重工具。产品具有独特、新颖、安全等特点。由于产品的优良，我们的产品已销售至全国二十多个省市自治区，远销亚洲、欧洲、美洲、非洲、中东等三十多个国家和地区，赢得了国内外用户的广泛赞誉。本公司在全国各区设有多个销售网点,在全国销售范围内进行售后服务。公司凭借一流的管理，一流的技术队伍通过ISO9001国际质量体系认证。 我公司真诚希望与国内外新老客户共创未来。公司本着“质量第一，信誉第二”的原则，欢迎新老客户，参观指导，洽谈合作。'
,'/upload/logo.jpg');

select * from Company;


-- ok
-- 动态表 trends
drop table trends;

create table trends(
	tid int PRIMARY KEY AUTO_INCREMENT, -- 插入tid用0就可以了
	ttag VARCHAR(50), -- 标题
	tcontent text,  -- 动态的内容
	tdate datetime			-- 最后修改时间  插入实际用now()
);
insert into trends value(0,'山叶机械起重有限公司公司动态','没动态动态',now());
insert into trends value(0,'山叶机械起重有限公司公司动态','没动态动态',now());
insert into trends value(0,'山叶机械起重有限公司公司动态','没动态动态',now());

-- ok
-- 联系方式表 context
drop table context;

create table context(
	cid int PRIMARY KEY AUTO_INCREMENT,
	cconcrete VARCHAR(20), -- 联系方式具体内容
	ctype int   -- 1 电话号码  2 微信二维码路径  3 微信账号 4 邮箱 5 证书
);
INSERT into context VALUES(0,'13722237047',1);
INSERT into context VALUES(0,'13303028262',1);
INSERT into context VALUES(0,'hbsyqzjx@foxmail.com',4);
INSERT into context VALUES(0,'13722237047',3);
INSERT into context VALUES(0,'13303028262',3);
INSERT into context VALUES(0,'/upload/weixin1.jpg',2);   
INSERT into context VALUES(0,'/upload/weixin2.jpg',2);
INSERT into context VALUES(0,'/upload/zizhi-tu.jpg',5);

select * FROM context;

-- ok
-- 产品类型表
drop table productType;

create table productType(
	ptid int PRIMARY KEY AUTO_INCREMENT,	-- 产品类型id
	ptname VARCHAR(20)		-- 产品类型名称
);
insert into productType VALUES(0,'手拉葫芦系列');
insert into productType VALUES(0,'起重滑车系列');
insert into productType VALUES(0,'钢丝绳电动葫芦');
insert into productType VALUES(0,'微型电动葫芦');
insert into productType VALUES(0,'环链电动葫芦');
insert into productType VALUES(0,'千斤顶系列');
insert into productType VALUES(0,'手扳葫芦系列');
insert into productType VALUES(0,'起重链条系列');
insert into productType VALUES(0,'防爆电动葫芦');
insert into productType VALUES(0,'坦克车系列');
insert into productType VALUES(0,'电动提升机系列');
insert into productType VALUES(0,'跑车系列');
insert into productType VALUES(0,'卸扣系列');
insert into productType VALUES(0,'吊运机系列');
insert into productType VALUES(0,'磁力吊系列');
insert into productType VALUES(0,'吊装带系列');
insert into productType VALUES(0,'起重吊钩系列');
insert into productType VALUES(0,'紧线器系列');
insert into productType VALUES(0,'卷扬机系列');
insert into productType VALUES(0,'平衡器系列');
insert into productType VALUES(0,'起重钳系列');

SELECT * from productType;

-- ok
-- 产品明细表 product
drop table product;

create table product(
	pid int primary key AUTO_INCREMENT,
	pname varchar(20) not NULL,  -- 产品名字
	pbrife varchar(1000),		-- 产品简要
	ppic varchar(20),	-- 产品图片
	ptid int ,						-- 产品类型
	foreign key(ptid) references productType(ptid)
);
insert into product VALUES(0,'HSZ系列手拉葫芦','产品简要产品简要','/upload/1.jpg',1);
insert into product VALUES(0,'HSZ-C手拉葫芦','产品简要产品简要','/upload/2.jpg',1);
insert into product VALUES(0,'单轮滑车','产品简要产品简要','/upload/3.jpg',2);
insert into product VALUES(0,'双轮滑车','产品简要产品简要','/upload/4.jpg',2);
insert into product VALUES(0,'冶金电动葫芦','产品简要产品简要','/upload/5.jpg',3);
insert into product VALUES(0,'防爆钢丝绳电动葫芦','产品简要产品简要','/upload/6.jpg',3);
insert into product VALUES(0,'微型电动葫芦','产品简要产品简要','/upload/7.jpg',4);
insert into product VALUES(0,'微型电动葫芦支架','产品简要产品简要','/upload/8.jpg',4);

-- ok
-- 起重知识表 know
drop table know;

CREATE TABLE know(
		kid int PRIMARY KEY auto_Increment,
		ktag varchar(20),
		kcontent VARCHAR(2000) ,
		kdate date
);

insert into know VALUES(0,'电动葫芦电机如何保护','电机，环链电动葫芦中最为重要的部件之一，电机的使用情况决定葫芦的使用寿命，所以对于 电机部分一般都设有保护装置，由于绝缘技术的不断发展，在电机的设计上既要求增加出力，要求 减小体积，使新型环链电动葫芦电机的热容量越来越小，负荷能力越来越弱，再由于生产自动化程 度的提高，要求电机经常运行在频繁的起动、制动、正反转以及变负荷等多种方式，对电机保护装 置提出了更高的要求。
　　传统的环链电动葫芦电机保护装置以“热继电器”为主，但热继电器灵敏度低、误差大、稳定 性差，保护不可靠。使得电机损坏而影响正常生产的现象仍普遍存在.
　　理想的电机保护器不是功能最多，更不是所谓最先进的，而是应该满足现场实际需求，做到经 济性和可靠性的统一，具有较高性价比。根据现场的实际情况选择环链电动葫芦电机保护器的种类 ，同时要考虑保护器安装、调整、使用简单方便等情况。',SYSDATE());


select * from know;


-- ok
-- 招聘表
drop table employ;

create table employ(
	eid int PRIMARY KEY auto_Increment,
	ename varchar(20), -- 职位名称
	ecount varchar(20),	-- 招聘人数
	eaddress VARCHAR(20),	-- 工作地点
	etime varchar(20),	-- 有效时间
	edescription VARCHAR(400) -- 职位描述       出于安全考虑，做了些修改（400）
)

insert into employ VALUES(0,'业务员','1人','洞口','2016.12.1','有责任心,耐心负责');
insert into employ VALUES(0,'普通员工','2至3人','洞口','2016.12.1','有责任心,耐心负责');


select * from employ;


-- ok
-- 用户表
drop table User;

create table User(
	usid int PRIMARY KEY AUTO_INCREMENT,
	uname VARCHAR(20),
	upwd VARCHAR(100),
	utel  VARCHAR(20)
);
insert into User 
values(0,'Admin','6f9b0a55df8ac28564cb9f63a10be8af6ab3f7c2','18873462694');
update User set utel='15886451001'
update User set utel='18873462694'
select * from User;


-- 留言表
drop table guest;

create table guest(
	gid int primary key auto_Increment,
	gname varchar(20), -- 留言名字
	gtel varchar(20), -- 留言人电话号码
	gemail varchar(20), -- 留言人邮箱
	gcontent varchar(1000), -- 留言内容
	gtime datetime
)

insert into guest values(0,'刘阳','15886451001','865161933@qq.com','内容啊内容',now());

-- ok
-- 短信通知内容表
drop table message;

create table message(
	mid int primary KEY AUTO_INCREMENT,
	mappkey varchar(20),
	msecret varchar(50),
	mtel varchar(20), -- 短信通知的电话号码
	msignname varchar(20), -- 短信签名
	mtemplateCode varchar(20), -- 短信模板id
	mtype int -- 短信类型  1:通知短信 2:验证码
)

insert into message values(0,'23564811','53c04d3585be1d3e54dafa71f73942c3','15886451001','河北山叶机械','SMS_33980261',1);
insert into message values(0,'23564811','53c04d3585be1d3e54dafa71f73942c3','15886451001','河北山叶机械','SMS_33990117',2);

select * from message;



COMMIT;