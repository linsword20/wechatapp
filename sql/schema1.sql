
CREATE DATABASE wechat;

USE wechat;

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS user;
 CREATE TABLE user (
  ID int(11) NOT NULL,
  USERNAME varchar(20) NOT NULL,
  PASSWORD varchar(50) NOT NULL,
  EMAIL varchar(30) DEFAULT NULL,
  WID varchar(30) DEFAULT '1',
  ROLE varchar(20) NOT NULL,
  PRIMARY KEY (ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `tasks`
-- ----------------------------
DROP TABLE IF EXISTS tasks;

CREATE TABLE tasks (
  ID int(11) NOT NULL DEFAULT '0',
  CONTENT varchar(200) NOT NULL,
  FLAG tinyint(1) NOT NULL DEFAULT '0',
  USER_ID int(11) NOT NULL,
  STARTTIME timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  STOPTIME timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `log`
-- ----------------------------
DROP TABLE IF EXISTS log;

CREATE TABLE log (
  ID bigint(20) NOT NULL,
  USERNAME varchar(20) DEFAULT NULL,
  TIME timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  DESCRIPTION varchar(50) DEFAULT NULL,
  PRIMARY KEY (ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `city_code`
-- ----------------------------
DROP TABLE IF EXISTS city_code;

CREATE TABLE city_code (
  ID int(11) NOT NULL,
  CITY varchar(20) NOT NULL,
  CODE varchar(20) NOT NULL,
  PRIMARY KEY (ID),
  KEY IDX_CITY (CITY)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;





