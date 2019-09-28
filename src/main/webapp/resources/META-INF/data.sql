INSERT INTO suppliers (name) VALUES ('Supplier 1');
INSERT INTO suppliers (name) VALUES ('Supplier 2');
INSERT INTO suppliers (name) VALUES ('Supplier 3');


INSERT INTO products (name,supplier_id,unit_price,units_in_stock) VALUES ('Product1', 1,18.00, 10);
INSERT INTO products (name,supplier_id,unit_price,units_in_stock) VALUES ('Product2', 1,19.00, 40);
INSERT INTO products (name,supplier_id,unit_price,units_in_stock) VALUES ('Product3', 2,20.00, 10);
INSERT INTO products (name,supplier_id,unit_price,units_in_stock) VALUES ('Product4', 2,30.00, 20);
INSERT INTO products (name,supplier_id,unit_price,units_in_stock) VALUES ('Product5', 3,20.00, 30);
INSERT INTO products (name,supplier_id,unit_price,units_in_stock) VALUES ('Product6', 3,15.00, 17);
INSERT INTO products (name,supplier_id,unit_price,units_in_stock) VALUES ('Product7', 3,20.00, 17);



INSERT INTO medical_exams(name) VALUES('Rayos X');
INSERT INTO medical_exams(name) VALUES('Sangre');


INSERT INTO roles (type) VALUES ('ADMIN');
INSERT INTO roles (type) VALUES ('USER');


INSERT INTO doctors (address,country,dni,name) VALUES('Av. Peru','Peru','12345678','Henry Mendoza Puerta')

INSERT INTO users (id,password,state,username) VALUES(1,'$2a$10$fnKPd0bL4LY7I3LrWp8FW.H4FLBbVVayVz/91n/QzBDBEcQOgwDoa','A','hamp');

INSERT INTO user_roles(rol_id,user_id) VALUES (1,1);