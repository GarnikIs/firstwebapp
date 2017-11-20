CREATE TABLE category(
  category_id INT(11) AUTO_INCREMENT NOT NULL,
  category_name VARCHAR(255),
  category_description VARCHAR(255),
  category_image_url VARCHAR(255),
  category_is_active BOOLEAN,
  CONSTRAINT pk_category_id PRIMARY KEY (category_id)
);

INSERT INTO category (category_name, category_description, category_image_url, category_is_active)
            VALUES   ('Laptop', 'Some description for Laptop', 'CAT_1.png', true);
INSERT INTO category (category_name, category_description, category_image_url, category_is_active)
            VALUES   ('Mobile', 'Some description for Mobile', 'CAT_2.png', true);
INSERT INTO category (category_name, category_description, category_image_url, category_is_active)
            VALUES   ('TV', 'Some description for TV', 'CAT_3.png', true);

CREATE TABLE user_detail (
  user_id INT(11) AUTO_INCREMENT NOT NULL,
  first_name VARCHAR(255),
  last_name VARCHAR(255),
  role VARCHAR(255),
  enabled BOOLEAN,
  password VARCHAR(255),
  email VARCHAR(255),
  contract_number VARCHAR(255),
  CONSTRAINT pk_user_id PRIMARY KEY (user_id)
);

INSERT INTO user_detail (first_name, last_name, role, enabled, password, email, contract_number)
            VALUES      ('Garnik', 'Isajanyan', 'ADMIN', true, '123', 'garnikisajan@gmail.com', '123');
INSERT INTO user_detail (first_name, last_name, role, enabled, password, email, contract_number)
            VALUES      ('Vacho', 'Hovhannisyan', 'SUPPLIER', true, '123', 'vachoh@gmail.com', '456');
INSERT INTO user_detail (first_name, last_name, role, enabled, password, email, contract_number)
            VALUES      ('Garnik', 'Isajanyan', 'SUPPLIER', true, '123', 'arama@gmail.com', '789');

CREATE TABLE product (
  product_id INT(11) AUTO_INCREMENT NOT NULL,
  product_code VARCHAR(20),
  product_name VARCHAR(50),
  brand VARCHAR(50),
  product_description VARCHAR(255),
  unit_price DECIMAL(10,2),
  quantity INT(5),
  product_is_active BOOLEAN,
  product_category_id INT(11),
  product_supplier_id INT(11),
  purchase INT(11) DEFAULT 0,
  views INT(11) DEFAULT 0,
  CONSTRAINT pk_product_id PRIMARY KEY (product_id),
  CONSTRAINT fk_product_category_id FOREIGN KEY (product_category_id) REFERENCES category (category_id),
  CONSTRAINT fk_product_supplier_id FOREIGN KEY (product_supplier_id) REFERENCES user_detail (user_id)
);

INSERT INTO product (product_code, product_name, brand, product_description, unit_price, quantity,
                     product_is_active, product_category_id, product_supplier_id, purchase, views)
            VALUES  ('as123', 'Iphon 4s', 'apple', 'One of the best Mobile', 150000, 5, true, 2, 1, 0, 0);
INSERT INTO product (product_code, product_name, brand, product_description, unit_price, quantity,
                     product_is_active, product_category_id, product_supplier_id, purchase, views)
            VALUES  ('as456', 'SamsungTV', 'samsung', 'One of the best TV', 300000, 6, true, 3, 2, 0, 0);
INSERT INTO product (product_code, product_name, brand, product_description, unit_price, quantity,
                     product_is_active, product_category_id, product_supplier_id, purchase, views)
            VALUES  ('as789', 'Toshiba 5DD', 'Toshiba', 'One of the best Laptop', 400000, 4, true, 1, 3, 0, 0);