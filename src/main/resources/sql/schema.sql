CREATE DATABASE gym;

USE gym;

CREATE TABLE Admin (
                       username VARCHAR(255),
                       password VARCHAR(255)
);

CREATE TABLE Members (
                         MemberID VARCHAR(50) PRIMARY KEY,
                         FirstName VARCHAR(255),
                         LastName VARCHAR(255),
                         Age INT,
                         Gender VARCHAR(10),
                         BirthDate DATE NOT NULL,
                         Email VARCHAR(255),
                         ContactNo VARCHAR(15)
);

CREATE TABLE Equipment (
                           EquipmentID VARCHAR(50) PRIMARY KEY,
                           EquipmentName VARCHAR(255),
                           EquipmentQty VARCHAR(255),
                           PurchaseDate DATE NOT NULL
);

CREATE TABLE Instructor (
                            InstructorID VARCHAR(50) PRIMARY KEY,
                            FirstName VARCHAR(255),
                            LastName VARCHAR(255),
                            Age INT,
                            Gender VARCHAR(10),
                            BirthDate DATE NOT NULL,
                            Email VARCHAR(255),
                            ContactNo VARCHAR(15)
);

CREATE TABLE Report (
                        FromDate DATE NOT NULL,
                        ToDate DATE NOT NULL,
                        Income DECIMAL(10, 2)
);

CREATE TABLE HealthReport (
                              HealthReportID VARCHAR(50) PRIMARY KEY,
                              MemberID VARCHAR(50),
                              Weight DECIMAL(6, 2),
                              Height DECIMAL(6, 2),
                              MedicalCondition VARCHAR(255),
                              BodyFatPercentage DECIMAL(5, 2),
                              FOREIGN KEY (MemberID) REFERENCES Members(MemberID)
);

CREATE TABLE Feedback (
                          FeedbackDate DATE,
                          FeedbackText VARCHAR(255)
);

CREATE TABLE Payment (
                         MemberID VARCHAR(50) ,
                         PaymentType VARCHAR(255),
                         AccountNo VARCHAR(255),
                         FOREIGN KEY (MemberID) REFERENCES Members(MemberID)
);


CREATE TABLE Inventory (
                           ProductName VARCHAR(255) PRIMARY KEY,
                           ProductQty VARCHAR(255),
                           ProductPrice VARCHAR(255)

);

CREATE TABLE Supplements (
                             ProductName VARCHAR(255),
                             ProductQTY VARCHAR(255),
                             ProductPrice VARCHAR(255)
                                 FOREIGN KEY (ProductName) REFERENCES Inventory (ProductName)
);