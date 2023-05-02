/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  nandani
 * Created: 11-Apr-2023
 */
drop table if exists ems_type;

CREATE TABLE ems_type (
  id VARCHAR(250) PRIMARY KEY,
  ref_obj_uri VARCHAR(500),
  type_name VARCHAR(500),
  effective_date TIMESTAMP DEFAULT NOW(),
  expiration_date TIMESTAMP DEFAULT null,
  description_plain VARCHAR(500) DEFAULT NULL,
  description_formatted VARCHAR(500) DEFAULT NULL,
  state_id VARCHAR(250),
  created_at TIMESTAMP NOT NULL DEFAULT NOW(),
  created_by VARCHAR(150) NOT NULL DEFAULT 'Admin',
  updated_at TIMESTAMP NOT NULL DEFAULT NOW(),
  updated_by VARCHAR(150) NOT NULL DEFAULT 'Admin',
  FOREIGN KEY (state_id) REFERENCES ems_state(id)
  
);

