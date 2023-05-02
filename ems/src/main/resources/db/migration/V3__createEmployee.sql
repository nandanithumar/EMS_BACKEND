/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  nandani
 * Created: 26-Apr-2023
 */

drop table if exists employee;

CREATE TABLE employee (
  ID VARCHAR(250) PRIMARY KEY,
  password varchar(12) NOT NULL,
  first_name varchar(150) NOT NULL,
  middle_name varchar(150),
  last_name varchar(150) NOT NULL,
  email varchar(150) NOT NULL UNIQUE,
  designation varchar(50),
  birthdate timestamp NOT NULL,
  gender BOOLEAN,
  blood_group varchar(15),
  address varchar(1500),
  marital_status BOOLEAN,
  mobile_no varchar(50) NOT NULL UNIQUE,
  created_at timestamp DEFAULT CURRENT_TIMESTAMP,
  created_by varchar(150) DEFAULT 'Admin',
  updated_at timestamp DEFAULT CURRENT_TIMESTAMP,
  updated_by varchar(150) DEFAULT 'Admin',
  state_id VARCHAR(250),
  type_id VARCHAR(250),
  foreign key (state_id) REFERENCES ems_state(ID),
  foreign key (type_id) REFERENCES ems_type(ID)


);


