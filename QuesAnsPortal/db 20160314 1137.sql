-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.73-community


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema quesanssystem
--
drop database quesanssystem;
CREATE DATABASE IF NOT EXISTS quesanssystem;
USE quesanssystem;

--
-- Definition of table `quesans`
--

DROP TABLE IF EXISTS `quesans`;
CREATE TABLE `quesans` (
  `quesid` bigint(20) NOT NULL,
  `question` varchar(4000) DEFAULT NULL,
  `answer` varchar(4000) DEFAULT NULL,
  PRIMARY KEY (`quesid`)
) ENGINE=MyISAM AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `quesans`
--

/*!40000 ALTER TABLE `quesans` DISABLE KEYS */;
INSERT INTO `quesans` (`quesid`,`question`,`answer`) VALUES 
 (1,'Who is founder of facebook?',' Mark Zuckerberg with his college roommates and fellow Harvard University students Eduardo Saverin, Andrew McCollum, Dustin Moskovitz and Chris Hughes'),
 (2,'Who is founder of google','Google was founded by Larry Page and Sergey Brin while they were Ph.D. students at Stanford University'),
 (3,'What is Linux OS?','The Linux open source operating system, or Linux OS, is a freely distributable, cross-platform operating system based on Unix that can be installed on PCs, laptops, netbooks, mobile and tablet devices, video game consoles, servers, supercomputers and more.');
/*!40000 ALTER TABLE `quesans` ENABLE KEYS */;


--
-- Definition of table `searchengine`
--

DROP TABLE IF EXISTS `searchengine`;
CREATE TABLE `searchengine` (
  `searchEngineId` bigint(20) NOT NULL,
  `searchEngineName` varchar(50) DEFAULT NULL,
  `searchEngineURL` varchar(150) DEFAULT NULL,
  `resultTag` varchar(50) DEFAULT NULL,
  `resultTagAttrbName` varchar(45) DEFAULT NULL,
  `resultTagAttrbValue` varchar(50) DEFAULT NULL,
  `TagPosition` bigint(5) DEFAULT NULL,
  `regexDetails` varchar(50) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `searchengine`
--

/*!40000 ALTER TABLE `searchengine` DISABLE KEYS */;
INSERT INTO `searchengine` (`searchEngineId`,`searchEngineName`,`searchEngineURL`,`resultTag`,`resultTagAttrbName`,`resultTagAttrbValue`,`TagPosition`,`regexDetails`) VALUES 
 (1,'Wikipedia','http://en.wikipedia.org/w/index.php?search=','p','','',1,''),
 (2,'Google','https://www.google.co.in/search?q=','div','id','ires',0,'');
/*!40000 ALTER TABLE `searchengine` ENABLE KEYS */;


--
-- Definition of table `searchkeyword`
--

DROP TABLE IF EXISTS `searchkeyword`;
CREATE TABLE `searchkeyword` (
  `keywordId` int(11) NOT NULL,
  `searchEngineId` int(11) NOT NULL,
  `QuesId` int(11) NOT NULL,
  `keyword` varchar(100) NOT NULL,
  PRIMARY KEY (`keywordId`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `searchkeyword`
--

/*!40000 ALTER TABLE `searchkeyword` DISABLE KEYS */;
INSERT INTO `searchkeyword` (`keywordId`,`searchEngineId`,`QuesId`,`keyword`) VALUES 
 (1,1,2,'Larry Page'),
 (2,2,2,'founder of google'),
 (3,1,1,'Mark Zuckerberg'),
 (4,2,1,'founder of facebook'),
 (6,2,3,'Linux OS'),
 (5,1,3,'Linux');
/*!40000 ALTER TABLE `searchkeyword` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
