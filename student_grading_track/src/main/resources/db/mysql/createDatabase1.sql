-- DROP DATABASE IF EXISTS cis2232_20230921_project1_GradingSystem;
-- CREATE DATABASE cis2232_grading_system;
-- use cis2232_grading_system;
-- 
-- 
-- CREATE TABLE Project1GradingSystem(
-- studentName varchar(50) NOT NULL  COMMENT 'Student name',
-- instructorName varchar(50) NOT NULL  COMMENT 'Instructor name',
-- courseName varchar(50) NOT NULL  COMMENT 'Course name',
-- courseRoom varchar(50) NOT NULL  COMMENT 'Course room',
-- numericGrade double(5) COMMENT 'Numeric Grade',
-- letterGrade varchar(50) NOT NULL  COMMENT 'Letter grade',
-- overallGrade double(5) COMMENT 'Overall numeric Grade',
-- overall LetterGrade varchar(50) NOT NULL  COMMENT 'Overall letter grade',
-- academicYear int(5) COMMENT 'Acadmic Year',
-- ) COMMENT 'This table holds grading system details';

-- ALTER TABLE Project1GradingSystem
--   ADD PRIMARY KEY (id);
-- ALTER TABLE Project1GradingSystem
--   MODIFY id int(4) NOT NULL AUTO_INCREMENT COMMENT 'This is the primary key', AUTO_INCREMENT=1;

DROP DATABASE IF EXISTS cis2232_grading_system;
CREATE DATABASE cis2232_Grading_Track;
use cis2232_Grading_Track;

-- DROP DATABASE IF EXISTS cis2232_squash_skills;
-- CREATE DATABASE cis2232_squash_skills;
-- use cis2232_squash_skills;

-- CREATE TABLE CodeType (codeTypeId int(3) COMMENT 'This is the primary key for code types',
--   englishDescription varchar(100) NOT NULL COMMENT 'English description',
--   frenchDescription varchar(100) DEFAULT NULL COMMENT 'French description',
--   createdDateTime datetime DEFAULT NULL,
--   createdUserId varchar(20) DEFAULT NULL,
--   updatedDateTime datetime DEFAULT NULL,
--   updatedUserId varchar(20) DEFAULT NULL
-- ) COMMENT 'This tables holds the code types that are available for the application';
-- 
-- INSERT INTO CodeType (CodeTypeId, englishDescription, frenchDescription, createdDateTime, createdUserId, updatedDateTime, updatedUserId) VALUES
-- (1, 'User Types', 'User Types FR', sysdate(), '', CURRENT_TIMESTAMP, '');
-- INSERT INTO CodeType (CodeTypeId, englishDescription, frenchDescription, createdDateTime, createdUserId, updatedDateTime, updatedUserId) VALUES
-- (2, 'Ticket Types', 'Ticket Types FR', sysdate(), '', CURRENT_TIMESTAMP, '');
-- 
-- CREATE TABLE CodeValue (
--   codeTypeId int(3) NOT NULL COMMENT 'see code_type table',
--   codeValueSequence int(3) NOT NULL,
--   englishDescription varchar(100) NOT NULL COMMENT 'English description',
--   englishDescriptionShort varchar(20) NOT NULL COMMENT 'English abbreviation for description',
--   frenchDescription varchar(100) DEFAULT NULL COMMENT 'French description',
--   frenchDescriptionShort varchar(20) DEFAULT NULL COMMENT 'French abbreviation for description',
--   sortOrder int(3) DEFAULT NULL COMMENT 'Sort order if applicable',
--   createdDateTime datetime DEFAULT NULL,
--   createdUserId varchar(20) DEFAULT NULL,
--   updatedDateTime datetime DEFAULT NULL,
--   updatedUserId varchar(20) DEFAULT NULL
-- ) COMMENT='This will hold code values for the application.';
-- 
-- INSERT INTO CodeValue (codeTypeId, codeValueSequence, englishDescription, englishDescriptionShort, frenchDescription, frenchDescriptionShort, createdDateTime, createdUserId, updatedDateTime, updatedUserId) VALUES
-- (1, 1, 'General', 'General', 'GeneralFR', 'GeneralFR', '2015-10-25 18:44:37', 'admin', '2015-10-25 18:44:37', 'admin');
-- INSERT INTO CodeValue (codeTypeId, codeValueSequence, englishDescription, englishDescriptionShort, frenchDescription, frenchDescriptionShort, createdDateTime, createdUserId, updatedDateTime, updatedUserId) VALUES
-- (1, 2, 'Admin', 'Admin', 'Admin', 'Admin', '2015-10-25 18:44:37', 'admin', '2015-10-25 18:44:37', 'admin');
-- 
-- INSERT INTO CodeValue (codeTypeId, codeValueSequence, englishDescription, englishDescriptionShort, frenchDescription, frenchDescriptionShort, createdDateTime, createdUserId, updatedDateTime, updatedUserId) VALUES
-- (2, 3, 'Balcony', 'Balcony', 'BalconyFR', 'BalconyFR', '2015-10-25 18:44:37', 'admin', '2015-10-25 18:44:37', 'admin');
-- INSERT INTO CodeValue (codeTypeId, codeValueSequence, englishDescription, englishDescriptionShort, frenchDescription, frenchDescriptionShort, createdDateTime, createdUserId, updatedDateTime, updatedUserId) VALUES
-- (2, 4, 'Orchestra', 'Orchestra', 'OrchestraFR', 'OrchestraFR', '2015-10-25 18:44:37', 'admin', '2015-10-25 18:44:37', 'admin');
-- INSERT INTO CodeValue (codeTypeId, codeValueSequence, englishDescription, englishDescriptionShort, frenchDescription, frenchDescriptionShort, createdDateTime, createdUserId, updatedDateTime, updatedUserId) VALUES
-- (2, 5, 'Main Floor', 'Main Floor', 'Main FloorFR', 'Main FloorFR', '2015-10-25 18:44:37', 'admin', '2015-10-25 18:44:37', 'admin');
-- 
-- 
-- 
-- CREATE TABLE UserAccess (
--   userAccessId int(3) NOT NULL,
--   username varchar(100) NOT NULL COMMENT 'Unique user name for app',
--   password varchar(128) NOT NULL,
--   name varchar(128),
--   userAccessStatusCode int(3) NOT NULL DEFAULT '1' COMMENT 'Code type #2',
--   userTypeCode int(3) NOT NULL DEFAULT '1' COMMENT 'Code type #1',
--   createdDateTime datetime DEFAULT NULL COMMENT 'When user was created.'
-- );
-- 
-- ALTER TABLE CodeType
--   ADD PRIMARY KEY (codeTypeId);
-- 
-- ALTER TABLE CodeValue
--   ADD PRIMARY KEY (codeValueSequence);
-- --  ADD KEY codeTypeId (codeTypeId);
-- 
-- ALTER TABLE UserAccess
--   ADD PRIMARY KEY (userAccessId),
--   ADD KEY userTypeCode (userTypeCode);
-- 
-- ALTER TABLE CodeType
--   MODIFY codeTypeId int(3) NOT NULL COMMENT 'This is the primary key for code types';
-- 
-- ALTER TABLE CodeValue
--   MODIFY codeValueSequence int(3) NOT NULL;
-- 
-- ALTER TABLE UserAccess
--   MODIFY userAccessId int(3) NOT NULL AUTO_INCREMENT;

-- CREATE TABLE TicketOrder(
-- id int(5),
-- customerName varchar(20) NOT NULL COMMENT 'Customer name',
-- hollpassNumber int(5) NOT NULL  COMMENT 'Student Hollpass Number',
-- dateOfOrder varchar(10) NOT NULL COMMENT 'Date of order',
-- dateOfPerformance varchar(10) NOT NULL COMMENT 'Date of performance (yyyy-MM-dd)',
-- timeOfPerformance varchar(5) NOT NULL COMMENT 'Time of performance (hh24:mm)',
-- numberOfTickets int(4) NOT NULL  COMMENT 'Number of Tickets',
-- ticketTypeCode int(3) NOT NULL default 0 COMMENT 'Type of ticket',
-- costOfTickets decimal(6,2) NOT NULL  COMMENT 'Cost of Tickets'
-- ) COMMENT 'This table holds ticket order data';

CREATE TABLE GradingTrack(
id int(5),
studentName varchar(50) NOT NULL  COMMENT 'Student name',
instructorName varchar(50) NOT NULL  COMMENT 'Instructor name',
courseName varchar(50) NOT NULL  COMMENT 'Course name',
courseRoom varchar(50) NOT NULL  COMMENT 'Course room',
numericGrade double COMMENT 'Numeric Grade',
letterGrade varchar(50)   COMMENT 'Letter grade',
-- overallGrade double COMMENT 'Overall numeric Grade',
-- overallLetterGrade varchar(50) NOT NULL  COMMENT 'Overall letter grade',
academicYear int(5) COMMENT 'Acadmic Year'
) COMMENT 'This table holds grading system details';

-- ALTER TABLE TicketOrder
--   ADD PRIMARY KEY (id);
-- ALTER TABLE TicketOrder
--   MODIFY id int(4) NOT NULL AUTO_INCREMENT COMMENT 'This is the primary key', AUTO_INCREMENT=1;
ALTER TABLE GradingTrack
  ADD PRIMARY KEY (id);
ALTER TABLE GradingTrack
  MODIFY id int(4) NOT NULL AUTO_INCREMENT COMMENT 'This is the primary key', AUTO_INCREMENT=1;

insert into gradingtrack values(1, 'Joe Smith', 'jj', 'cis-123','1-2','90','A','1');
insert into gradingtrack values(2, 'Junjie', 'oo', 'cis-123','1-2','99','A','1');
insert into gradingtrack values(3, 'carly', 'yu', 'cis-123','1-2','60','C','1');
insert into gradingtrack values(4, 'Joey', 'jj', 'cis-123','1-2','90','A','1');

