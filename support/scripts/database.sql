-- phpMyAdmin SQL Dump
-- version 3.2.4
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tempo de Geração: Jan 04, 2012 as 12:59 
-- Versão do Servidor: 5.1.41
-- Versão do PHP: 5.3.1

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Banco de Dados: `stringsfighters`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `tblcharactertype`
--

CREATE TABLE IF NOT EXISTS `tblcharactertype` (
  `idcharactertype` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Primary key.',
  `idclan` int(11) DEFAULT NULL COMMENT 'Foreign key for tblclan.',
  `title` varchar(50) DEFAULT NULL COMMENT 'Title for a character type.',
  PRIMARY KEY (`idcharactertype`),
  KEY `FK_tblcharactertype_idclan` (`idclan`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Extraindo dados da tabela `tblcharactertype`
--

INSERT INTO `tblcharactertype` (`idcharactertype`, `idclan`, `title`) VALUES
(1, 1, 'Dôbot'),
(2, 2, 'Ankh');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tblclan`
--

CREATE TABLE IF NOT EXISTS `tblclan` (
  `idclan` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Primary key.',
  `title` varchar(50) DEFAULT NULL COMMENT 'Title of clan',
  PRIMARY KEY (`idclan`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Extraindo dados da tabela `tblclan`
--

INSERT INTO `tblclan` (`idclan`, `title`) VALUES
(1, 'Symbols'),
(2, 'Letters');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tblgameroom`
--

CREATE TABLE IF NOT EXISTS `tblgameroom` (
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
  KEY `FK_tblgameroom_idplayercharacterchallenger` (`idplayercharacterchallenger`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=57 ;

--
-- Extraindo dados da tabela `tblgameroom`
--

INSERT INTO `tblgameroom` (`idgameroom`, `idplayercharacterowner`, `hostowner`, `idplayercharacterchallenger`, `hostchallenger`, `idplayercharacterwinner`, `won_at`, `created_at`) VALUES
(56, 8, '192.168.0.2', 15, '192.168.0.1', 15, '2010-09-24 21:02:51', '2010-09-24 20:59:23');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tblplayer`
--

CREATE TABLE IF NOT EXISTS `tblplayer` (
  `idplayer` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Primary key.',
  `score` int(11) DEFAULT '0' COMMENT 'Player´s score',
  `username` varchar(16) DEFAULT NULL COMMENT 'Player´s Username',
  `password` varchar(16) DEFAULT NULL COMMENT 'Player´s password',
  `active` smallint(1) DEFAULT '0' COMMENT 'Player´s active',
  PRIMARY KEY (`idplayer`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- Extraindo dados da tabela `tblplayer`
--

INSERT INTO `tblplayer` (`idplayer`, `score`, `username`, `password`, `active`) VALUES
(1, 2966, 'intentor', '*****', 1),
(2, 1179, 'monk', '*****', 1),
(3, 1418, 'animal', '*****', 1),
(4, 124, 'anderson', '*****', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `tblplayercharacter`
--

CREATE TABLE IF NOT EXISTS `tblplayercharacter` (
  `idplayercharacter` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Primary key.',
  `idplayer` int(11) DEFAULT NULL COMMENT 'Foreign key for tblplayer.',
  `idcharactertype` int(11) DEFAULT NULL COMMENT 'Foreign key for tblcharactertype.',
  `level` int(11) DEFAULT '1' COMMENT 'Character´s Level',
  `xp` int(11) DEFAULT '0' COMMENT 'Character´s XP',
  `created_at` datetime DEFAULT NULL COMMENT 'Create date',
  PRIMARY KEY (`idplayercharacter`),
  KEY `FK_tblplayercharacter_idcharactertype` (`idcharactertype`),
  KEY `FK_tblplayercharacter_idplayer` (`idplayer`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=16 ;

--
-- Extraindo dados da tabela `tblplayercharacter`
--

INSERT INTO `tblplayercharacter` (`idplayercharacter`, `idplayer`, `idcharactertype`, `level`, `xp`, `created_at`) VALUES
(8, 1, 2, 2, 309, '2010-06-06 11:31:36'),
(9, 2, 1, 2, 283, '2010-06-06 11:31:47'),
(10, 2, 2, 2, 152, '2010-06-06 11:43:35'),
(11, 1, 1, 3, 161, '2010-06-06 11:46:10'),
(12, 3, 2, 1, 15, '2010-06-12 10:11:00'),
(13, 4, 1, 1, 10, '2010-06-12 10:19:08'),
(14, 4, 2, 1, 54, '2010-06-12 10:39:24'),
(15, 3, 1, 3, 342, '2010-06-12 10:56:34');

--
-- Restrições para as tabelas dumpadas
--

--
-- Restrições para a tabela `tblcharactertype`
--
ALTER TABLE `tblcharactertype`
  ADD CONSTRAINT `FK_tblcharactertype_idclan` FOREIGN KEY (`idclan`) REFERENCES `tblclan` (`idclan`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Restrições para a tabela `tblgameroom`
--
ALTER TABLE `tblgameroom`
  ADD CONSTRAINT `FK_tblgameroom_idplayercharacterowner` FOREIGN KEY (`idplayercharacterowner`) REFERENCES `tblplayercharacter` (`idplayercharacter`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Restrições para a tabela `tblplayercharacter`
--
ALTER TABLE `tblplayercharacter`
  ADD CONSTRAINT `FK_tblplayercharacter_idcharactertype` FOREIGN KEY (`idcharactertype`) REFERENCES `tblcharactertype` (`idcharactertype`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_tblplayercharacter_idplayer` FOREIGN KEY (`idplayer`) REFERENCES `tblplayer` (`idplayer`) ON DELETE SET NULL ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
