/*
 * Copyright 2024 flex Inc. - All Rights Reserved.
 */

CREATE TABLE `payroll`
(
    `id`              BIGINT      NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `employee_id`     BIGINT      NOT NULL comment 'FK: employee.id',
    `company_id`      BIGINT      NOT NULL comment 'FK: company.id',
    `payday`          INT(2)      NOT NULL comment '지급일 1-31, 0 means last day of month',
    `payroll_amount`  BIGINT      NOT NULL comment '월급 금액',
    `created_at`      DATETIME    NOT NULL comment '생성일시',
    `updated_at`      DATETIME    NOT NULL comment '수정일시'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

CREATE TABLE `payroll_history`
(
    `id`              BIGINT      NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `payroll_id`      BIGINT      NOT NULL comment 'FK: payroll.id',
    `employee_id`     BIGINT      NOT NULL comment 'FK: employ.id, for efficient query',
    `company_id`      BIGINT      NOT NULL comment 'FK: company.id, for efficient query',
    `payroll_amount`  BIGINT      NOT NULL comment '지급한 월급 금액',
    `pay_datetime`    DATETIME    NOT NULL comment '지급 일시',
    `created_at`      DATETIME    NOT NULL comment '생성일시',
    `updated_at`      DATETIME    NOT NULL comment '수정일시'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
