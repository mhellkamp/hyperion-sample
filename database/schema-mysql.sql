
CREATE TABLE categories (
  category_id bigint(20) NOT NULL AUTO_INCREMENT,
  category_name varchar(15) DEFAULT NULL,
  description longtext,
  image_url varchar(1024) DEFAULT NULL,
  created datetime DEFAULT NULL,
  created_by varchar(255) DEFAULT NULL,
  modified datetime DEFAULT NULL,
  modified_by varchar(255) DEFAULT NULL,
  PRIMARY KEY (category_id),
  UNIQUE KEY category_name (category_name)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE customer_type (
  customer_type_id bigint(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  description varchar(255) DEFAULT NULL,
  created datetime DEFAULT NULL,
  created_by varchar(255) DEFAULT NULL,
  modified datetime DEFAULT NULL,
  modified_by varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE regions (
  region_id bigint(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  region_name varchar(15) DEFAULT NULL,
  created datetime DEFAULT NULL,
  created_by varchar(255) DEFAULT NULL,
  modified datetime DEFAULT NULL,
  modified_by varchar(255) DEFAULT NULL,
  UNIQUE KEY region_name (region_name)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE territories (
  territory_id bigint(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  region_id bigint(20) DEFAULT NULL,
  territory_name varchar(64) DEFAULT NULL,
  created datetime DEFAULT NULL,
  created_by varchar(255) DEFAULT NULL,
  modified datetime DEFAULT NULL,
  modified_by varchar(255) DEFAULT NULL,
  UNIQUE KEY territory_name (territory_name),
  CONSTRAINT FOREIGN KEY (region_id) REFERENCES regions (region_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE customers (
  customer_id bigint(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  address varchar(60) DEFAULT NULL,
  city varchar(30) DEFAULT NULL,
  company_name varchar(40) DEFAULT NULL,
  contact_name varchar(30) DEFAULT NULL,
  contact_title varchar(30) DEFAULT NULL,
  country varchar(15) DEFAULT NULL,
  credit_rating varchar(50) DEFAULT NULL,
  fax varchar(24) DEFAULT NULL,
  phone varchar(24) DEFAULT NULL,
  postal_code varchar(10) DEFAULT NULL,
  region_id bigint(20) NOT NULL,
  created datetime DEFAULT NULL,
  created_by varchar(255) DEFAULT NULL,
  modified datetime DEFAULT NULL,
  modified_by varchar(255) DEFAULT NULL,
  KEY customer_region (region_id),
  CONSTRAINT FOREIGN KEY (region_id) REFERENCES regions (region_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE employees (
  employee_id bigint(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  address varchar(128) DEFAULT NULL,
  city varchar(64) DEFAULT NULL,
  date_of_birth date DEFAULT NULL,
  date_of_hire date DEFAULT NULL,
  first_name varchar(64) DEFAULT NULL,
  home_phone varchar(10) DEFAULT NULL,
  last_name varchar(64) DEFAULT NULL,
  postal_code varchar(10) DEFAULT NULL,
  state varchar(2) DEFAULT NULL,
  supervisor_id bigint(20) DEFAULT NULL,
  title varchar(64) DEFAULT NULL,
  created datetime DEFAULT NULL,
  created_by varchar(255) DEFAULT NULL,
  modified datetime DEFAULT NULL,
  modified_by varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE employee_territories (
  employee_territory_id bigint(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  employee_id bigint(20) NOT NULL,
  territory_id bigint(20) DEFAULT NULL,
  CONSTRAINT FOREIGN KEY (employee_id) REFERENCES employees (employee_id),
  CONSTRAINT FOREIGN KEY (territory_id) REFERENCES territories (territory_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE entity_history (
  entity_history_id bigint(20) NOT NULL AUTO_INCREMENT,
  api_version int(11) DEFAULT NULL,
  entity_id bigint(20) DEFAULT NULL,
  entity_type varchar(255) DEFAULT NULL,
  history_action varchar(255) DEFAULT NULL,
  serialized_entry longtext,
  timestamp datetime DEFAULT NULL,
  user varchar(255) DEFAULT NULL,
  PRIMARY KEY (entity_history_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


