CREATE DATABASE IF NOT EXISTS MS_Ortodont;
USE MS_Ortodont;

--
-- Tabla para los Usuaros Administradores --
--
CREATE TABLE Admins(
  Id_Admin INT NOT NULL AUTO_INCREMENT,
  Passwd VARCHAR(20) NOT NULL,
  PRIMARY KEY(Id_Admin)
)ENGINE = InnoDB;
--
-- Tabla para los Pacientes --
--
CREATE TABLE Patient(
  Id_Pati INT NOT NULL AUTO_INCREMENT,
  First_Name VARCHAR(12) NOT NULL,
  Second_Name VARCHAR(12),
  Last_Name VARCHAR(12) NOT NULL,
  Second_Last_Name VARCHAR(12),
  Cellphone INT NOT NULL,
  Status INT NOT NULL,
  PRIMARY KEY(Id_Pati)
)ENGINE = InnoDB;
--
-- Tabla de Especialidades --
--
CREATE TABLE Specialties(
  Id_Specialty INT NOT NULL AUTO_INCREMENT,
  Specialty VARCHAR(30) NOT NULL,
  PRIMARY KEY(Id_Specialty)
)ENGINE = InnoDB;
--
-- Tabla de Cargos --
--
CREATE TABLE Charges(
  Id_Charge INT NOT NULL AUTO_INCREMENT,
  Specialty INT NOT NULL,
  PRIMARY KEY(Id_Charge),
  FOREIGN KEY(Specialty)
   REFERENCES Specialties(Id_Specialty)
)ENGINE = InnoDB;
--
-- Tabla par los Empleados --
--
CREATE TABLE Employee(
  Id_Employee INT NOT NULL AUTO_INCREMENT,
  First_Name VARCHAR(12) NOT NULL,
  Second_Name VARCHAR(12),
  Last_Name VARCHAR(12) NOT NULL,
  Second_Last_Name VARCHAR(12),
  Cellphone INT NOT NULL,
  Birthday_date DATE NOT NULL,
  Charge INT NOT NULL,
  PRIMARY KEY (Id_Employee),
  FOREIGN KEY(Charge)
   REFERENCES Charges(Id_Charge)
)ENGINE = InnoDB;
--
-- Tabla para las fechas de ingreso y salida --
--
CREATE TABLE Dates(
  Id_Date INT NOT NULL AUTO_INCREMENT,
  Day_of_Entry DATETIME NOT NULL,
  Day_of_Exit DATETIME NOT NULL,
  PRIMARY KEY(Id_Date)
)ENGINE = InnoDB;
--
-- Tabla de Tratamientos --
--
CREATE TABLE Treatments(
  Id_treat INT NOT NULL AUTO_INCREMENT,
  Detail VARCHAR(30) NOT NULL,
  Description VARCHAR(30) NOT NULL,
  PRIMARY KEY(Id_treat)
)ENGINE = InnoDB;
--
-- Tabla para las citas --
--
CREATE TABLE Appointment(
  Id_Appointment INT NOT NULL AUTO_INCREMENT,
  Id_Doc INT NOT NULL,
  Id_Date INT NOT NULL,
  Status INT NOT NULL,
  PRIMARY KEY(Id_Appointment),
  FOREIGN KEY(Id_Doc)
    REFERENCES Employee(Id_Employee),
  FOREIGN KEY(Id_Date)
    REFERENCES Dates(Id_Date)
)ENGINE = InnoDB;
--
-- Tabla para los medicamentos --
--
CREATE TABLE Medicines(
  Id_Medicine INT NOT NULL AUTO_INCREMENT,
  Name VARCHAR(12) NOT NULL,
  Description VARCHAR(20) NOT NULL,
  PRIMARY KEY(Id_Medicine)
)ENGINE = InnoDB;
--
-- Tabla para el Historial --
--
CREATE TABLE Record(
  Id_Historial INT NOT NULL AUTO_INCREMENT,
  Id_Pati INT NOT NULL,
  Id_Doc INT NOT NULL,
  Id_Date INT NOT NULL,
  Id_Treat INT NOT NULL,
  Id_Medicine INT NOT NULL,
  PRIMARY KEY(Id_Historial),
  FOREIGN KEY(Id_Pati)
    REFERENCES Patient(Id_Pati),
  FOREIGN KEY(Id_Doc)
    REFERENCES Employee(Id_Employee),
  FOREIGN KEY(Id_Date)
    REFERENCES Dates(Id_Date),
  FOREIGN KEY(Id_Treat)
    REFERENCES Treatments(Id_Treat),
  FOREIGN KEY(Id_Medicine)
    REFERENCES Medicines(Id_Medicine)
)ENGINE = InnoDB;
