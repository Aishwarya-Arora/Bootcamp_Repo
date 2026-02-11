-- defining the employee table in the schema.sql
CREATE TABLE employee (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          name VARCHAR(100) NOT NULL,
                          designation VARCHAR(100) NOT NULL
);

