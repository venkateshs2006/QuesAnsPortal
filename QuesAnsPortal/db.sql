drop database quesanssystem;
create database quesanssystem;
USE quesanssystem;

CREATE TABLE `quesans` (
  `quesid` bigint(20) NOT NULL,
  `question` varchar(250) DEFAULT NULL,
  `answer` varchar(250) DEFAULT NULL,
  `domainid` int(11) DEFAULT NULL,
  `keywords` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`quesid`)
) ENGINE=MyISAM AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;


insert into `quesans`(`quesid`,`question`,`answer`,`domainid`,`keywords`) values (1,'Who is father of internet','Timber lee',1,'father internet');
insert into `quesans`(`quesid`,`question`,`answer`,`domainid`,`keywords`) values (2,'What is internet','The Internet is a global system of interconnected computer networks that use the standard Internet protocol suite (TCP/IP) to link several billion devices worldwide.',1,'internet');
insert into `quesans`(`quesid`,`question`,`answer`,`domainid`,`keywords`) values (3,'What are the services of internet','World Wide Web,Communication,Data transfer',1,'World Wide Web Communication Data transfer  online');
insert into `quesans`(`quesid`,`question`,`answer`,`domainid`,`keywords`) values (4,'What is adds on','a piece of software which enhances another software application and usually cannot be run independently',2,'software application run independently');
insert into `quesans`(`quesid`,`question`,`answer`,`domainid`,`keywords`) values (5,'When network was invented ','The Advanced Research Projects Agency Network (ARPANET) was one of the world''s first operational packet switching networks, the first network to implement TCP/IP, and one of the progenitors of what was to become the global Internet',3,'network invented ');
insert into `quesans`(`quesid`,`question`,`answer`,`domainid`,`keywords`) values (6,'Who is founder of facebook',' Mark Zuckerberg with his college roommates and fellow Harvard University students Eduardo Saverin, Andrew McCollum, Dustin Moskovitz and Chris Hughes',4,'founder  facebook');
insert into `quesans`(`quesid`,`question`,`answer`,`domainid`,`keywords`) values (7,'What is facebook','Facebook (formerly [thefacebook]) is an online social networking service headquartered in Menlo Park, California.',4,'facebook social networking');
insert into `quesans`(`quesid`,`question`,`answer`,`domainid`,`keywords`) values (8,'Who is founder of google','Google was founded by Larry Page and Sergey Brin while they were Ph.D. students at Stanford University',5,'founder google');
insert into `quesans`(`quesid`,`question`,`answer`,`domainid`,`keywords`) values (9,'What is google','Google /gu?g(?)l/ is a U.S. headquartered, multinational corporation specializing in Internet-related services and products. These include online advertising technologies, search, cloud computing, and software',5,'services google');
insert into `quesans`(`quesid`,`question`,`answer`,`domainid`,`keywords`) values (10,'Who is father of internet','Timber lee',1,'Father of Internet');

USE quesanssystem;

CREATE TABLE `domain` (
  `domainid` bigint(20) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `maindomainid` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`domainid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


insert into `domain`(`domainid`,`name`,`maindomainid`) values (1,'Internet','Computer');
insert into `domain`(`domainid`,`name`,`maindomainid`) values (2,'Adds on','Computer');
insert into `domain`(`domainid`,`name`,`maindomainid`) values (3,'Networking','Computer');
insert into `domain`(`domainid`,`name`,`maindomainid`) values (4,'Facebook','Computer');
insert into `domain`(`domainid`,`name`,`maindomainid`) values (5,'Google','Computer');
insert into `domain`(`domainid`,`name`,`maindomainid`) values (6,'Laptop','Computer');
insert into `domain`(`domainid`,`name`,`maindomainid`) values (7,'Printer','Computer');
insert into `domain`(`domainid`,`name`,`maindomainid`) values (8,'Security','Computer');
insert into `domain`(`domainid`,`name`,`maindomainid`) values (9,'Wikipedia','Computer');
insert into `domain`(`domainid`,`name`,`maindomainid`) values (10,'Youtube','Computer');

USE quesanssystem;

CREATE TABLE `users` (
  `uid` bigint(20) NOT NULL AUTO_INCREMENT,
  `userid` varchar(50) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;


insert into `users`(`uid`,`userid`,`password`) values (1,'admin','admin');
insert into `users`(`uid`,`userid`,`password`) values (2,'manager','manager');

drop table quesanssystem.SearchEngine;
create table quesanssystem.SearchEngine (
`searchEngineId` bigint(20) NOT NULL,
`searchEngineName` varchar(50) DEFAULT NULL,
`searchEngineURL` varchar(150) DEFAULT NULL,
`resultTag` varchar(50) DEFAULT NULL,
`resultTagID` varchar(50) DEFAULT NULL,
`TagPosition` bigint(5) DEFAULT NULL,
`regexDetails` varchar(50) DEFAULT NULL);

insert into searchengine ( searchEngineId, searchEngineName,searchEngineURL, resultTag, resultTagID, TagPosition, regexDetails)
values(1,'Wikipedia','http://en.wikipedia.org/w/index.php?search=','p','',1,'');
insert into searchengine (searchEngineId, searchEngineName, searchEngineURL, resultTag, resultTagID, TagPosition, regexDetails)
values(2,'Google','https://www.google.co.in/search?q=','div','_OKe',0,'');
select * from searchengine;
CREATE TABLE `searchkeyword` (
  `searchEngineId` int(11) NOT NULL,
  `QuesId` int(11) NOT NULL,
  `keyword` varchar(100) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
