# 1.熟悉学习中常见的几个表
# USE database mysqlstudy;
# DESC employees;
use mysqlstudy;
# drop table if exists student;

-- 正确的创建顺序：从没有外键依赖的表开始，逐步创建有依赖关系的表

-- 第 1 步：创建 regions 表（无外键依赖）
CREATE TABLE IF NOT EXISTS `regions`
(
    `region_id`   int(11) NOT NULL,
    `region_name` varchar(25) DEFAULT NULL,
    PRIMARY KEY (`region_id`),
    UNIQUE KEY `reg_id_pk` (`region_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- 第 2 步：创建 countries 表（依赖 regions）
CREATE TABLE IF NOT EXISTS `countries`
(
    `country_id`   char(2) NOT NULL,
    `country_name` varchar(40) DEFAULT NULL,
    `region_id`    int(11)     DEFAULT NULL,
    PRIMARY KEY (`country_id`),
    KEY `countr_reg_fk` (`region_id`),
    CONSTRAINT `countr_reg_fk` FOREIGN KEY (`region_id`) REFERENCES `regions` (`region_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- 第 3 步：创建 locations 表（依赖 countries）
CREATE TABLE IF NOT EXISTS `locations`
(
    `location_id`    int(4)      NOT NULL DEFAULT '0',
    `street_address` varchar(40)          DEFAULT NULL,
    `postal_code`    varchar(12)          DEFAULT NULL,
    `city`           varchar(30) NOT NULL,
    `state_province` varchar(25)          DEFAULT NULL,
    `country_id`     char(2)              DEFAULT NULL,
    PRIMARY KEY (`location_id`),
    UNIQUE KEY `loc_id_pk` (`location_id`),
    KEY `loc_c_id_fk` (`country_id`),
    CONSTRAINT `loc_c_id_fk` FOREIGN KEY (`country_id`) REFERENCES `countries` (`country_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- 第 4 步：创建 jobs 表（无外键依赖）
CREATE TABLE IF NOT EXISTS `jobs`
(
    `job_id`     varchar(10) NOT NULL DEFAULT '',
    `job_title`  varchar(35) NOT NULL,
    `min_salary` int(6)               DEFAULT NULL,
    `max_salary` int(6)               DEFAULT NULL,
    PRIMARY KEY (`job_id`),
    UNIQUE KEY `job_id_pk` (`job_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- 第 5 步：创建 employees 表（先不加外键约束，避免循环依赖）
CREATE TABLE IF NOT EXISTS `employees`
(
    `employee_id`    int(6)      NOT NULL DEFAULT '0',
    `first_name`     varchar(20)          DEFAULT NULL,
    `last_name`      varchar(25) NOT NULL,
    `email`          varchar(25) NOT NULL,
    `phone_number`   varchar(20)          DEFAULT NULL,
    `hire_date`      date        NOT NULL,
    `job_id`         varchar(10) NOT NULL,
    `salary`         double(8, 2)         DEFAULT NULL,
    `commission_pct` double(2, 2)         DEFAULT NULL,
    `manager_id`     int(6)               DEFAULT NULL,
    `department_id`  int(4)               DEFAULT NULL,
    PRIMARY KEY (`employee_id`),
    UNIQUE KEY `emp_email_uk` (`email`),
    UNIQUE KEY `emp_emp_id_pk` (`employee_id`),
    KEY `emp_dept_fk` (`department_id`),
    KEY `emp_job_fk` (`job_id`),
    KEY `emp_manager_fk` (`manager_id`),
    CONSTRAINT `emp_job_fk` FOREIGN KEY (`job_id`) REFERENCES `jobs` (`job_id`),
    CONSTRAINT `emp_manager_fk` FOREIGN KEY (`manager_id`) REFERENCES `employees` (`employee_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- 第 6 步：创建 departments 表（先不加 manager_id 外键）
CREATE TABLE IF NOT EXISTS `departments`
(
    `department_id`   int(4)      NOT NULL DEFAULT '0',
    `department_name` varchar(30) NOT NULL,
    `manager_id`      int(6)               DEFAULT NULL,
    `location_id`     int(4)               DEFAULT NULL,
    PRIMARY KEY (`department_id`),
    UNIQUE KEY `dept_id_pk` (`department_id`),
    KEY `dept_loc_fk` (`location_id`),
    KEY `dept_mgr_fk` (`manager_id`),
    CONSTRAINT `dept_loc_fk` FOREIGN KEY (`location_id`) REFERENCES `locations` (`location_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- 第 7 步：添加 employees 和 departments 之间的循环外键
ALTER TABLE `employees`
    ADD CONSTRAINT `emp_dept_fk` FOREIGN KEY (`department_id`) REFERENCES `departments` (`department_id`);

ALTER TABLE `departments`
    ADD CONSTRAINT `dept_mgr_fk` FOREIGN KEY (`manager_id`) REFERENCES `employees` (`employee_id`);

-- ========================================
-- 插入测试数据（适量，便于学习 SQL 查询）
-- ========================================

-- 1. 插入 regions 数据（4 个地区）
INSERT IGNORE INTO `regions` (`region_id`, `region_name`) VALUES
(1, 'Europe'),
(2, 'Americas'),
(3, 'Asia'),
(4, 'Middle East and Africa');

-- 2. 插入 countries 数据（6 个国家）
INSERT IGNORE INTO `countries` (`country_id`, `country_name`, `region_id`) VALUES
('US', 'United States of America', 2),
('UK', 'United Kingdom', 1),
('CN', 'China', 3),
('JP', 'Japan', 3),
('DE', 'Germany', 1),
('CA', 'Canada', 2);

-- 3. 插入 locations 数据（5 个办公地点）
INSERT IGNORE INTO `locations` (`location_id`, `street_address`, `postal_code`, `city`, `state_province`, `country_id`) VALUES
(1000, '1297 Via Cola di Rie', '00989', 'Roma', NULL, 'UK'),
(1100, '93091 Calle della Testa', '10934', 'Venice', NULL, 'UK'),
(1200, '2017 Shinjuku-ku', '1689', 'Tokyo', 'Tokyo Prefecture', 'JP'),
(1400, '2014 Jabberwocky Rd', '26192', 'Southlake', 'Texas', 'US'),
(1500, '2011 Interiors Blvd', '99236', 'South San Francisco', 'California', 'US');

-- 4. 插入 jobs 数据（6 个职位）
INSERT IGNORE INTO `jobs` (`job_id`, `job_title`, `min_salary`, `max_salary`) VALUES
('AD_PRES', 'President', 20000, 40000),
('AD_VP', 'Administration Vice President', 15000, 30000),
('IT_PROG', 'Programmer', 4000, 10000),
('SA_MAN', 'Sales Manager', 10000, 20000),
('SA_REP', 'Sales Representative', 6000, 12000),
('ST_CLERK', 'Stock Clerk', 2000, 5000);

-- 5. 插入 employees 数据（10 个员工，包含层级关系）
-- 注意：先插入高层管理者（没有 manager_id），再插入下属
INSERT IGNORE INTO `employees` (`employee_id`, `first_name`, `last_name`, `email`, `phone_number`, `hire_date`, `job_id`, `salary`, `commission_pct`, `manager_id`, `department_id`) VALUES
-- 总裁（无上级）
(100, 'Steven', 'King', 'SKING', '515.123.4567', '1987-06-17', 'AD_PRES', 24000.00, NULL, NULL, NULL),
-- 副总裁（上级是总裁）
(101, 'Neena', 'Kochhar', 'NKOCHHAR', '515.123.4568', '1989-09-21', 'AD_VP', 17000.00, NULL, 100, NULL),
(102, 'Lex', 'De Haan', 'LDEHAAN', '515.123.4569', '1993-01-13', 'AD_VP', 17000.00, NULL, 100, NULL),
-- IT 部门员工
(103, 'Alexander', 'Hunold', 'AHUNOLD', '590.423.4567', '1990-01-03', 'IT_PROG', 9000.00, NULL, 102, NULL),
(104, 'Bruce', 'Ernst', 'BERNST', '590.423.4568', '1991-05-21', 'IT_PROG', 6000.00, NULL, 103, NULL),
-- 销售部门员工
(145, 'John', 'Russell', 'JRUSSEL', '011.44.1344.429268', '1996-10-01', 'SA_MAN', 14000.00, 0.40, 100, NULL),
(146, 'Karen', 'Partners', 'KPARTNER', '011.44.1344.467268', '1997-01-05', 'SA_MAN', 13500.00, 0.30, 100, NULL),
(147, 'Alberto', 'Errazuriz', 'AERRAZUR', '011.44.1344.429278', '1997-03-10', 'SA_REP', 12000.00, 0.30, 145, NULL),
-- 仓库部门员工
(120, 'Matthew', 'Weiss', 'MWEISS', '650.123.1234', '1996-07-18', 'ST_CLERK', 8000.00, NULL, 100, NULL),
(121, 'Adam', 'Fripp', 'AFRIPP', '650.123.2234', '1997-04-10', 'ST_CLERK', 8200.00, NULL, 100, NULL);

-- 6. 插入 departments 数据（5 个部门）
-- 注意：manager_id 必须是已存在的 employee_id
INSERT IGNORE INTO `departments` (`department_id`, `department_name`, `manager_id`, `location_id`) VALUES
(10, 'Administration', 101, 1000),
(20, 'Marketing', 102, 1400),
(50, 'Shipping', 120, 1500),
(60, 'IT', 103, 1200),
(80, 'Sales', 145, 1100);

-- 7. 更新 employees 表的 department_id（建立员工与部门的关联）
UPDATE `employees` SET `department_id` = 10 WHERE `employee_id` IN (100, 101);
UPDATE `employees` SET `department_id` = 20 WHERE `employee_id` = 102;
UPDATE `employees` SET `department_id` = 60 WHERE `employee_id` IN (103, 104);
UPDATE `employees` SET `department_id` = 80 WHERE `employee_id` IN (145, 146, 147);
UPDATE `employees` SET `department_id` = 50 WHERE `employee_id` IN (120, 121);

CREATE TABLE IF NOT EXISTS `job_grades`
(
    `grade_level` varchar(3) DEFAULT NULL,
    `lowest_sal`  int(11)    DEFAULT NULL,
    `highest_sal` int(11)    DEFAULT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- 为 job_grades 准备覆盖 jobs 表薪资区间的数据，便于做区间查询练习
INSERT IGNORE INTO `job_grades` (`grade_level`, `lowest_sal`, `highest_sal`) VALUES
('G1', 2000, 4999),      -- 覆盖 ST_CLERK 薪资
('G2', 5000, 9999),      -- 覆盖 IT_PROG、SA_REP 薪资
('G3', 10000, 14999),    -- 覆盖 SA_MAN、管理岗位
('G4', 15000, 40000);    -- 覆盖 AD_VP、AD_PRES

CREATE TABLE IF NOT EXISTS `job_history`
(
    `employee_id`   int(6)      NOT NULL,
    `start_date`    date        NOT NULL,
    `end_date`      date        NOT NULL,
    `job_id`        varchar(10) NOT NULL,
    `department_id` int(4) DEFAULT NULL,
    PRIMARY KEY (`employee_id`, `start_date`),
    UNIQUE KEY `jhist_emp_id_st_date_pk` (`employee_id`, `start_date`),
    KEY `jhist_job_fk` (`job_id`),
    KEY `jhist_dept_fk` (`department_id`),
    CONSTRAINT `jhist_dept_fk` FOREIGN KEY (`department_id`) REFERENCES `departments` (`department_id`),
    CONSTRAINT `jhist_emp_fk` FOREIGN KEY (`employee_id`) REFERENCES `employees` (`employee_id`),
    CONSTRAINT `jhist_job_fk` FOREIGN KEY (`job_id`) REFERENCES `jobs` (`job_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- job_history 的记录与 employees、departments、jobs 保持一致，演示历史履历
INSERT IGNORE INTO `job_history` (`employee_id`, `start_date`, `end_date`, `job_id`, `department_id`) VALUES
(103, '1988-01-01', '1989-12-31', 'ST_CLERK', 50), -- 现任 IT 员工，历史在物流部
(104, '1989-02-01', '1991-05-20', 'ST_CLERK', 50), -- 转岗至 IT 之前的经历
(145, '1994-06-01', '1996-09-30', 'SA_REP', 80),  -- 晋升为销售经理之前
(146, '1995-03-01', '1996-12-31', 'SA_REP', 80);  -- 晋升为销售经理之前

CREATE TABLE IF NOT EXISTS `order`
(
    `order_id`   int(11)     DEFAULT NULL,
    `order_name` varchar(15) DEFAULT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- 订单数据通过名称与 departments、locations 形成业务含义关联
INSERT IGNORE INTO `order` (`order_id`, `order_name`) VALUES
(5001, 'Shipping-50'),    -- 对应 Shipping 部门
(5002, 'Sales-80'),       -- 对应 Sales 部门
(5003, 'IT-60-Support');  -- 对应 IT 部门

-- regions 表已在前面创建，删除重复定义

