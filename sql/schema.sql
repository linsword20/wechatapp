
CREATE DATABASE wechat;

USE wechat;

-- ----------------------------
-- Table structure for `user`
-- ----------------------------

 CREATE TABLE `user` (
  `ID` int(11) NOT NULL,
  `USERNAME` varchar(20) NOT NULL,
  `PASSWORD` varchar(50) NOT NULL,
  `EMAIL` varchar(30) DEFAULT NULL,
  `WID` varchar(30) DEFAULT '1',
  `ROLE` varchar(20) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

-- ----------------------------
-- Table structure for `tasks`
-- ----------------------------

CREATE TABLE `tasks` (
  `ID` int(11) NOT NULL DEFAULT '0',
  `CONTENT` varchar(200) NOT NULL,
  `FLAG` tinyint(1) NOT NULL DEFAULT '0',
  `USER_ID` int(11) NOT NULL,
  `STARTTIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIM
ESTAMP,
  `STOPTIME` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

-- ----------------------------
-- Table structure for `log`
-- ----------------------------

| LOG   | CREATE TABLE `log` (
  `LOGID` bigint(20) NOT NULL,
  `USERNAME` varchar(20) DEFAULT NULL,
  `TIME` datetime NOT NULL,
  `OPERATION` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`LOGID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 |

