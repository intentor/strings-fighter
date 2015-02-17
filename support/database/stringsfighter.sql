/*
SQLyog Enterprise - MySQL GUI v8.17 
MySQL - 5.1.40-community : Database - stringsfighters
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
/*Table structure for table `tblcharactertype` */

DROP TABLE IF EXISTS `tblcharactertype`;

CREATE TABLE `tblcharactertype` (
  `idcharactertype` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Primary key.',
  `idclan` int(11) DEFAULT NULL COMMENT 'Foreign key for tblclan.',
  `title` varchar(50) DEFAULT NULL COMMENT 'Title for a character type.',
  PRIMARY KEY (`idcharactertype`),
  KEY `FK_tblcharactertype_idclan` (`idclan`),
  CONSTRAINT `FK_tblcharactertype_idclan` FOREIGN KEY (`idclan`) REFERENCES `tblclan` (`idclan`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `tblcharactertype` */

insert  into `tblcharactertype`(`idcharactertype`,`idclan`,`title`) values (1,1,'Dobot'),(2,2,'Ankh');

/*Table structure for table `tblclan` */

DROP TABLE IF EXISTS `tblclan`;

CREATE TABLE `tblclan` (
  `idclan` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Primary key.',
  `title` varchar(50) DEFAULT NULL COMMENT 'Title of clan',
  PRIMARY KEY (`idclan`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `tblclan` */

insert  into `tblclan`(`idclan`,`title`) values (1,'Letras'),(2,'Símbolos');

/*Table structure for table `tblgameroom` */

DROP TABLE IF EXISTS `tblgameroom`;

CREATE TABLE `tblgameroom` (
  `idgameroom` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Primary key.',
  `idplayercharacterowner` int(11) DEFAULT NULL COMMENT 'Player id gameroom´s owner.',
  `hostowner` varchar(15) DEFAULT NULL COMMENT 'Owner´s host IP',
  `idplayercharacterchallenger` int(11) DEFAULT NULL COMMENT 'Player id of a challenger',
  `hostchallenger` varchar(15) DEFAULT NULL COMMENT 'Challenger´s IP',
  `idplayercharacterwinner` int(11) DEFAULT NULL COMMENT 'Player ID of a winner.',
  `won_at` datetime DEFAULT NULL COMMENT 'Winning date',
  `created_at` datetime DEFAULT NULL COMMENT 'Create date',
  PRIMARY KEY (`idgameroom`),
  KEY `FK_tblgameroom_idplayercharacterowner` (`idplayercharacterowner`),
  KEY `FK_tblgameroom_idplayercharacterchallenger` (`idplayercharacterchallenger`),
  CONSTRAINT `FK_tblgameroom_idplayercharacterowner` FOREIGN KEY (`idplayercharacterowner`) REFERENCES `tblplayercharacter` (`idplayercharacter`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Table structure for table `tblplayer` */

DROP TABLE IF EXISTS `tblplayer`;

CREATE TABLE `tblplayer` (
  `idplayer` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Primary key.',
  `score` int(11) DEFAULT '0' COMMENT 'Player´s score',
  `username` varchar(16) DEFAULT NULL COMMENT 'Player´s Username',
  `password` varchar(16) DEFAULT NULL COMMENT 'Player´s password',
  `active` smallint(1) DEFAULT '0' COMMENT 'Player´s active',
  PRIMARY KEY (`idplayer`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Table structure for table `tblplayercharacter` */

DROP TABLE IF EXISTS `tblplayercharacter`;

CREATE TABLE `tblplayercharacter` (
  `idplayercharacter` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Primary key.',
  `idplayer` int(11) DEFAULT NULL COMMENT 'Foreign key for tblplayer.',
  `idcharactertype` int(11) DEFAULT NULL COMMENT 'Foreign key for tblcharactertype.',
  `level` int(11) DEFAULT '0' COMMENT 'Character´s Level',
  `xp` int(11) DEFAULT '0' COMMENT 'Character´s XP',
  `created_at` datetime DEFAULT NULL COMMENT 'Create date',
  PRIMARY KEY (`idplayercharacter`),
  KEY `FK_tblplayercharacter_idcharactertype` (`idcharactertype`),
  KEY `FK_tblplayercharacter_idplayer` (`idplayer`),
  CONSTRAINT `FK_tblplayercharacter_idcharactertype` FOREIGN KEY (`idcharactertype`) REFERENCES `tblcharactertype` (`idcharactertype`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `FK_tblplayercharacter_idplayer` FOREIGN KEY (`idplayer`) REFERENCES `tblplayer` (`idplayer`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
