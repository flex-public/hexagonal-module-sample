/*
 * Copyright 2024 flex Inc. - All Rights Reserved.
 */

insert into `company` (id, name, created_at, updated_at) values (1, '테스트 회사1', now(), now());
insert into `company` (id, name, created_at, updated_at) values (2, '테스트 회사2', now(), now());

insert into `employee` (id, company_id, employee_number, name, created_at, updated_at) values (1, 1, 'TCA_1001', '유저1-1', now(), now());
insert into `employee` (id, company_id, employee_number, name, created_at, updated_at) values (2, 1, 'TCA_1002', '유저1-2', now(), now());
insert into `employee` (id, company_id, employee_number, name, created_at, updated_at) values (3, 1, 'TCA_1003', '유저1-3', now(), now());
insert into `employee` (id, company_id, employee_number, name, created_at, updated_at) values (4, 1, 'TCA_1004', '유저1-4', now(), now());
insert into `employee` (id, company_id, employee_number, name, created_at, updated_at) values (5, 2, 'TCB_1001', '유저2-1', now(), now());
insert into `employee` (id, company_id, employee_number, name, created_at, updated_at) values (6, 2, 'TCB_1002', '유저2-2', now(), now());
insert into `employee` (id, company_id, employee_number, name, created_at, updated_at) values (7, 2, 'TCB_1003', '유저2-3', now(), now());
insert into `employee` (id, company_id, employee_number, name, created_at, updated_at) values (8, 2, 'TCB_1004', '유저2-4', now(), now());

insert into `job_role` (id, company_id, name, created_at, updated_at) values (1, 1, 'Product Engineer(Backend)', now(), now());
insert into `job_role` (id, company_id, name, created_at, updated_at) values (2, 1, 'Product Engineer(Frontend)', now(), now());
insert into `job_role` (id, company_id, name, created_at, updated_at) values (3, 1, 'Product Designer', now(), now());
insert into `job_role` (id, company_id, name, created_at, updated_at) values (4, 1, 'Product Manager', now(), now());
insert into `job_role` (id, company_id, name, created_at, updated_at) values (5, 2, 'Backend Developer', now(), now());
insert into `job_role` (id, company_id, name, created_at, updated_at) values (6, 2, 'Frontend Developer', now(), now());

insert into `department` (id, company_id, parent_id, name, created_at, updated_at) values (1, 1, null, 'CEO', now(), now());
insert into `department` (id, company_id, parent_id, name, created_at, updated_at) values (2, 1, 1, 'Core Squad', now(), now());
insert into `department` (id, company_id, parent_id, name, created_at, updated_at) values (3, 1, 1, 'Review Squad', now(), now());
insert into `department` (id, company_id, parent_id, name, created_at, updated_at) values (4 ,1, 1, 'Payroll Squad', now(), now());
insert into `department` (id, company_id, parent_id, name, created_at, updated_at) values (5 ,2, null, '대표', now(), now());
insert into `department` (id, company_id, parent_id, name, created_at, updated_at) values (6 ,2, 5, '개발실', now(), now());
insert into `department` (id, company_id, parent_id, name, created_at, updated_at) values (7, 2, 6, '서버 개발1팀', now(), now());
insert into `department` (id, company_id, parent_id, name, created_at, updated_at) values (8, 2, 6, '서버 개발2팀', now(), now());
insert into `department` (id, company_id, parent_id, name, created_at, updated_at) values (9, 2, 6, '앱 개발팀', now(), now());
